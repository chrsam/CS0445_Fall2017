import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Assignment 8 is to navigate a maze represented as a Graph. A Graph implementation that uses a Map of Strings (node names)
 * to Lists (node neighbors) is provided. The implementation will allow you to load the edges of your graph as a single String;
 * for instance, to represent an undirected, unweighted graph (see CourseWeb for visual depiction). You can represent this
 * Graph with this String: A,B;A,D;B,C;B,F;C,F;D,E;E,H;F,G;G,H. Your assignment is to implement the getShortestPath method -
 * this method should find the shortest path between the two specified nodes; if no path exists, your method should return null.
 * Hint: You should implement a breadth-first search algorithm to solve this problem. We'll get into how to build this in the
 * final week of class.
 */

public class Graph {

	private Map<String,List<Edge>> graphData = new HashMap<String,List<Edge>>();
	private boolean isDirected;
	private boolean isWeighted;

	public Graph(boolean isDirected, boolean isWeighted) {
	  this.isDirected = isDirected;
	  this.isWeighted = isWeighted;
	}

	// this method will add edges to the graph based on a string.
	// this string is in the form "from,to"
	// each pair of adjacent nodes should be separated by a semicolon.
	public void addEdges(String edgeList) {
	  for (String edgePair : edgeList.split(";")) {
	    String[] edges = edgePair.split(",");
	    if (edges.length == 2) {
	      addEdge(edges[0], edges[1]);
	    }
	  }
	}

	// add an edge from one node to another; if this is a weighted graph this will throw an exception
	public void addEdge(String from, String to) {
	  if (isWeighted) {
	    throw new UnsupportedOperationException("Graph is weighted.");
	  }
	  addEdge(from, to, 1);
	}

	// add an edge from one node to another;
	// this method will handle reversing the edge for undirected graphs
	public void addEdge(String from, String to, int weight) {
		List<Edge> connections = graphData.get(from);
		if (connections == null) {
			connections = new LinkedList<Edge>();
			graphData.put(from, connections);
		}
		connections.add(new Edge(to, weight));
		if (!isDirected) {
		  connections = graphData.get(to);
		  if (connections == null) {
		    connections = new LinkedList<Edge>();
		    graphData.put(to, connections);
		  }
		  connections.add(new Edge(from, weight));
		}
	}

	// determine if you can travel directly from "from" to "to"
	public boolean isAdjacent(String from, String to) {
	  List<Edge> edges = graphData.get(from);
	  if (edges != null) {
	    for (Edge edge : edges) {
	      if (edge.adjacentNode.equals(to)) {
	        return true;
	      }
	    }
	  }
	  return false;
	}

	// return the weight between "from" and "to"
	// if nodes are not adjacent, return -1
	public int getWeight(String from, String to) {
	  List<Edge> edges = graphData.get(from);
	  if (edges != null) {
	    for (Edge edge : edges) {
	      if (edge.adjacentNode.equals(to)) {
	        return edge.weight;
	      }
	    }
	  }
	  return -1;
	}

	// represent the weight and an adjacent node
	private class Edge {
	  private int weight = 1;
	  private String adjacentNode;

	  public Edge(String adjacentNode, int weight) {
	    this.adjacentNode = adjacentNode;
	  }
	}

	public static void main(String[] args) {
	  String nodes = "A,B;B,C;C,D;D,E;A,K;K,E;A,F;F,G;G,H;H,I;I,J;J,E";
	  Graph graph = new Graph(false, false);
	  graph.addEdges(nodes);
	  System.out.println(graph.getShortestPath("A", "E")); // should print [A, K, E]
	}

  //TODO implement this method
	public List<String> getShortestPath(String from, String to) {
    Queue<String> vQueue = new LinkedList<>(); //Creates a Queue to tell you which vertices to visit next.
    Map visited = new HashMap(); //Creates a Map to identify visited vertices. Can be used to trace path backward.

    String originVertex = from;
    String destinationVertex = to;
    String currentVertex;
    String neighborVertex;

    vQueue.add(originVertex); //Adds originVertex to the Queue.
    visited.put(originVertex, null); //Adds originVertex to the Map.
    while(!vQueue.isEmpty()) { //While Queue is not empty (meaning there are still nodes not traversed)
      currentVertex = vQueue.remove(); //Retrieves and removes the next value in the Queue. Set as currentVertex.
      if(currentVertex == destinationVertex) {
        String current = destinationVertex; //Creates a variable "current" and is set equal to destinationVertex.
        LinkedList<String> path = new LinkedList<String>(); //Creates a LinkedList to represent the path.
        while(!current.equals(originVertex)) { //While current is not your origin.
          path.add(current); //Adds current to front of List.
          String currentValue = visited.getValue(current); //Retreives current's value from Map.
          current = currentValue; //Current is set equal to the values found from the Map.
        }
        path.add(originVertex); //Adds origin to front of the List.
        return originVertex + ", " + current + ", " + destinationVertex;
      } else {
        for(Edge edge : graphData.get(currentVertex)) {
          neighborVertex = graphData.get(currentVertex);
          vQueue.add(neighborVertex);
          if(!containsKey(neighborVertex)) {
            visited.put(neighborVertex, currentVertex);
          }
        }
      }
    }
		return null;

    // private String findPath(String originVertex, String destinationVertex) {
    //     String current = destinationVertex; //Creates a variable "current" and is set equal to destinationVertex.
    //     LinkedList<String> path = new LinkedList<String>(); //Creates a LinkedList to represent the path.
    //     while(!current.equals(originVertex)) { //While current is not your origin.
    //       path.add(current); //Adds current to front of List.
    //       String currentValue = visited.getValue(current); //Retreives current's value from Map.
    //       current = currentValue; //Current is set equal to the values found from the Map.
    //     }
    //     path.add(originVertex); //Adds origin to front of the List.
    //     return originVertex + ", " + current + ", " + destinationVertex;
    // }
	}
}

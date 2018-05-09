import java.util.Arrays;

public class SelectionSorter implements IntSorter {

  private int[] array = null;
  private static int moves = 0;
  private long startTime = 0;
  private long endTime = 0;

  public void init(int[] a) {
    this.array = a;
    moves = 0;
  }

  public void sort() {
    startTime = System.nanoTime();
    for(int index = 0; index < array.length-1; index++) {
      int indexOfNextSmallest = getIndexOfSmallest(array, index, array.length-1);
      swap(array, index, indexOfNextSmallest);
    }
    endTime = System.nanoTime();
    // System.out.println(Arrays.toString(array));
  }

  private int getIndexOfSmallest(int[] array, int first, int last) {
    int min = array[first]; // ex: if first = 0, array[0] = min
    int indexOfMin = first; // ex: if first = 0, 0 = indexOfMin
    for(int index = first + 1; index <= last; index++) {
      if(array[index] < min) { // ex: compare array[1] to array[0]
        min = array[index]; // ex: array[1] becomes new min
        indexOfMin = index; // ex: index increased to 1
      }
    }
    return indexOfMin;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp; // stores value originally in array[i] into array[j]
    moves++;
  }

  public long getSortTime() {
    return endTime - startTime;
  }

  public int getMoves() {
    return moves;
  }

}

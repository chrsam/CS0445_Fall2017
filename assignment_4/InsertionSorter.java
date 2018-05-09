import java.util.Arrays;

public class InsertionSorter implements IntSorter {

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
    for(int i = 1; i < array.length; i++) {
      int k = i;
      while(k > 0 && array[k-1] > array[k]) {
        swap(array, k, k-1);
        k--;
      }
    }
    endTime = System.nanoTime();
    // System.out.println(Arrays.toString(array));
  }

  private static void swap(int[] array, int begin, int end) {
    int temp = array[begin];
    array[begin] = array[end];
    array[end] = temp;
    moves++;
  }

  public long getSortTime() {
    return endTime - startTime;
  }

  public int getMoves() {
    return moves;
  }

}

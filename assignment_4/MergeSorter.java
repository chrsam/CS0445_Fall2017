import java.util.Arrays;

public class MergeSorter implements IntSorter {

  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;
  private int[] temp = null;

  public void init(int[] a) {
    this.array = a;
    moves = 0;
    this.temp = new int[a.length];
  }

  public void sort() {
    startTime = System.nanoTime();
    mergeSort(0, array.length - 1);
    endTime = System.nanoTime();
    // System.out.println(Arrays.toString(array));
  }

  private void mergeSort(int start, int end) {
    if(start < end) {
      int mid = (start+end)/2;
      mergeSort(start, mid);
      mergeSort(mid + 1, end);
      merge(start, mid, end);
    }
  }

  private void merge (int start, int mid, int end) {
    int b1 = start;
    int b2 = mid + 1;
    int index = 0;
    while(b1 <= mid && b2 <= end) {
      if(array[b1] <= array[b2]) {
        temp[index] = array[b1];
        b1++;
      } else {
        temp[index] = array[b2];
        b2++;
      }
      index++;
      moves++;
    }

      if(b1 == mid) {
        while(b2 <= end) {
          temp[index] = array[b2];
          index++;
          b2++;
          moves++;
        }
      } else {
        while(b1 <= mid) {
          temp[index] = array[b1];
          index++;
          b1++;
          moves++;
        }
      }
      System.arraycopy(temp, 0, array, start, index);
  }

  public long getSortTime() {
    return endTime - startTime;
  }

  public int getMoves() {
    return moves;
  }

}

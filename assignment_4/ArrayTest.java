//import com.sun.corba.se.spi.orbutil.fsm.TestAction1;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayTest {

  public static int[] createArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = (int)(Math.random() * 1000);
    }
    return result;
  }

  public static boolean isSorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void testSort() {
    int[] array = createArray(100);
    BubbleSorter sorter = new BubbleSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Bubble Sort: " + sorter.getMoves());
    System.out.println("\nRuntime of Bubble Sort: " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testInsertionSortS() {
    int[] array = createArray(100);
    InsertionSorter sorter = new InsertionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Insertion Sort (small): " + sorter.getMoves());
    System.out.println("\nRuntime of Insertion Sort (small): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testInsertionSortM() {
    int[] array = createArray(1000);
    InsertionSorter sorter = new InsertionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Insertion Sort (medium): " + sorter.getMoves());
    System.out.println("\nRuntime of Insertion Sort (medium): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testInsertionSortL() {
    int[] array = createArray(10000);
    InsertionSorter sorter = new InsertionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Insertion Sort (large): " + sorter.getMoves());
    System.out.println("\nRuntime of Insertion Sort (large): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testSelectionSortS() {
    int[] array = createArray(100);
    SelectionSorter sorter = new SelectionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Selection Sort (small): " + sorter.getMoves());
    System.out.println("\nRuntime of Selection Sort (small): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testSelectionSortM() {
    int[] array = createArray(1000);
    SelectionSorter sorter = new SelectionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Selection Sort (medium): " + sorter.getMoves());
    System.out.println("\nRuntime of Selection Sort (medium): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testSelectionSortL() {
    int[] array = createArray(10000);
    SelectionSorter sorter = new SelectionSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Selection Sort (large): " + sorter.getMoves());
    System.out.println("\nRuntime of Selection Sort (large): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testMergeSortS() {
    int[] array = createArray(100);
    MergeSorter sorter = new MergeSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Merge Sort (small): " + sorter.getMoves());
    System.out.println("\nRuntime of Merge Sort (small): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testMergeSortM() {
    int[] array = createArray(1000);
    MergeSorter sorter = new MergeSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Merge Sort (medium): " + sorter.getMoves());
    System.out.println("\nRuntime of Merge Sort (medium): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }

  @Test
  public void testMergeSortL() {
    int[] array = createArray(10000);
    MergeSorter sorter = new MergeSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves used in Merge Sort (large): " + sorter.getMoves());
    System.out.println("\nRuntime of Merge Sort (large): " + sorter.getSortTime());
    assertTrue(isSorted(array));
  }
}

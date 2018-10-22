package test.java;
import java.util.Arrays;
import org.junit.Test;

import main.java.InvalidOperationException;
import main.java.Item;
import main.java.RandomNumber;
import main.java.SortAlgos;

public class AlgoTest {
	
	private static SortAlgos Algo = new SortAlgos();
	private int size = 100;
	
	@Test
	public void testBubbleSortResultsWithInsertionSort() {
		Item[] items = getInputItems(size);
		Item[] itemsCopy = getCopyofArray(items);
		Algo.bubbleSort(items);
		Algo.insertionSort(itemsCopy);
		for (int i =0;i<size;i++) {
			assert(items[i].key == itemsCopy[i].key);
		}
	}
	
	@Test (expected = NullPointerException.class) 
	public void bubbleSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.bubbleSort(getInputItems(0));
	}
	
	@Test (expected = NullPointerException.class) 
	public void insertionSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.insertionSort(getInputItems(0));
	}
	@Test (expected = NullPointerException.class) 
	public void mergenSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.mergeSort(getInputItems(0));
	}
	@Test (expected = NullPointerException.class) 
	public void quickSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.quickSort(getInputItems(0));
	}
	
	@Test (expected = NullPointerException.class) 
	public void heapSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.heapSort(getInputItems(0));
	}
	
	@Test (expected = NullPointerException.class) 
	public void selectionSortShouldThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.selectionSort(getInputItems(0));
	}
	
	
	
	@Test
	public void testBubbleSortResultsWithSelectionSort() {
		Item[] items = getInputItems(size);
		Item[] itemsCopy = getCopyofArray(items);
		SortAlgos.bubbleSort(items);
		SortAlgos.selectionSort(itemsCopy);
		for (int i =0;i<size;i++) {
			assert(items[i].key == itemsCopy[i].key);
		}
	}
	
	@Test
	public void testBubbleSortResultsWithHeapSort() {
		Item[] items = getInputItems(size);
		Item[] itemsCopy = getCopyofArray(items);
		SortAlgos.bubbleSort(items);
		SortAlgos.heapSort(itemsCopy);
		for (int i =0;i<size;i++) {
			assert(items[i].key == itemsCopy[i].key);
		}
	}
	
	@Test
	public void testBubbleSortResultsWithMergeSort() {
		Item[] items = getInputItems(size);
		Item[] itemsCopy = getCopyofArray(items);
		SortAlgos.bubbleSort(items);
		SortAlgos.mergeSort(itemsCopy);
		for (int i =0;i<size;i++) {
			assert(items[i].key == itemsCopy[i].key);
		}
	}
	
	@Test
	public void testBubbleSortResultWithJDKSortImplementation() {
		Item[] items = getInputItems(size);
		int[] numbers = new int[size];
		for (int i = 0; i< size; i++) {
			numbers[i] = items[i].key;
		}
		Arrays.sort(numbers);
		SortAlgos.bubbleSort(items);
		for(int i =0;i<size;i++)
		{
			assert(numbers[i] == items[i].key);
		}
	}
	
	@Test
	public void testBubbleSortResultsWithQuickSort() {
		Item[] items = getInputItems(size);
		Item[] itemsCopy = getCopyofArray(items);
		SortAlgos.bubbleSort(items);
		SortAlgos.quickSort(itemsCopy);
		for (int i =0;i<size;i++) {
			assert(items[i].key == itemsCopy[i].key);
		}
	}

	private Item[] getInputItems(int size) {
		Item[] items = null;
		if (size > 0) {
			items =  new Item[size];
			RandomNumber randomGenerator = new RandomNumber();
			for (int i = 0; i< size; i++) {
				items[i] = new Item(randomGenerator.nextIntRand(0, size));
			}
		}
		return items;
	}
	
	@Test (expected = InvalidOperationException.class) 
	public void selectionSortShouldThrowsNullPointerExceptionIfInputIsNull11() {
		RandomNumber randomGenerator = new RandomNumber();
		int a = randomGenerator.nextIntRand(10, 5);
	}
	
	private Item[] getCopyofArray(Item[] source) {
		Item[] copyOfSource = new Item[source.length];
		System.arraycopy(source, 0, copyOfSource, 0, source.length);
		return copyOfSource;
	}
	
}

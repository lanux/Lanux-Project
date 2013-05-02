package com.lanux.common;
public class SortUtil {

	// 插入排序:
	public static <T extends Comparable<T>> void insertSort(T[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if (data[j].compareTo(data[j - 1]) > 0) {
					swap(data, j, j - 1);
				}
			}
		}
	}

	// 冒泡排序:
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = data.length - 1; j > i; j--) {
				if (data[j].compareTo(data[j - 1]) > 0) {
					swap(data, j, j - 1);
				}
			}
		}
	}

	// 选择排序:
	public static <T extends Comparable<T>> void selectionSort(T[] data) {
		for (int i = 0; i < data.length; i++) {
			int lowIndex = i;
			for (int j = data.length - 1; j > i; j--) {
				if (data[j].compareTo(data[lowIndex]) > 0) {
					lowIndex = j;
				}
			}
			swap(data, i, lowIndex);
		}
	}

	// shell排序
	public static <T extends Comparable<T>> void shellSort(T[] data) {
		for (int i = data.length / 2; i > 2; i /= 2) {
			for (int j = 0; j < i; j++) {
				insertSort(data, j, i);
			}
		}
		insertSort(data, 0, 1);
	}

	private static <T extends Comparable<T>> void insertSort(T[] data, int start, int inc) {
		for (int i = start + inc; i < data.length; i += inc) {
			for (int j = i; j >= inc; j -= inc) {
				if (data[j].compareTo(data[j - inc]) > 0) {
					swap(data, j, j - inc);
				}
			}
		}
	}

	// 快速排序:
	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static void quickSort(int[] data, int i, int j) {
		int pivotIndex = (i + j) / 2;
		swap(data, pivotIndex, j);
		int k = partition(data, i - 1, j, data[j]);
		SortUtil.swap(data, k, j);
		if ((k - i) > 1)
			quickSort(data, i, k - 1);
		if ((j - k) > 1)
			quickSort(data, k + 1, j);
	}

	private static int partition(int[] data, int l, int r, int pivot) {
		do {
			while (data[++l] < pivot)
				;
			while ((r != 0) && data[--r] > pivot)
				;
			SortUtil.swap(data, l, r);
		} while (l < r);
		SortUtil.swap(data, l, r);
		return l;
	}

	// 归并排序:
	public static void MergeSort(int[] data) {
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}

	private static void mergeSort(int[] data, int[] temp, int l, int r) {
		int mid = (l + r) / 2;
		if (l == r)
			return;
		mergeSort(data, temp, l, mid);
		mergeSort(data, temp, mid + 1, r);
		for (int i = l; i <= r; i++) {
			temp[i] = data[i];
		}
		int i1 = l;
		int i2 = mid + 1;
		for (int cur = l; cur <= r; cur++) {
			if (i1 == mid + 1)
				data[cur] = temp[i2++];
			else if (i2 > r)
				data[cur] = temp[i1++];
			else if (temp[i1] < temp[i2])
				data[cur] = temp[i1++];
			else
				data[cur] = temp[i2++];
		}
	}

	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static <T> void swap(T[] data, int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}

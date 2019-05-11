package sortingalgorithms;

import java.util.*;

public class SortArray {

    //time complex o(n^2), space o(1)
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minPos = i;
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            swap(nums, i, minPos);
        }
        System.out.println(Arrays.toString(nums));
    }

    //time complex bestcase: o(n) worst and average case: o(n^2), space o(1)
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println(Arrays.toString(nums));
    }


    //time complex best case: o(n) worst and average case: o(n^2), space o(1)
    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > num) {
                nums[j+1] = nums[j];
                j = j - 1;
            }
            nums[j+1] = num;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(double[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            double num = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > num) {
                nums[j+1] = nums[j];
                j = j - 1;
            }
            nums[j+1] = num;
        }
        System.out.println("insertion sort algorithm with double value");
        System.out.println(Arrays.toString(nums));
    }

    //time complext o(nlongn), space o(n)
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l+r)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = nums[l+i];
        for (int j = 0; j < n2; j++)
            R[j] = nums[m+1+j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    //complex time o(nlong) worst case: o(n^2), space o(n)
    public static void quicksort(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quicksort(nums, low, pi-1);
            quicksort(nums, pi+1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i+1, high);
        return i+1;
    }

    //time complex: o(nlongn), space: o(1)
    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--)
            heapify(nums, n, i);

        for (int i = n-1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && nums[l] > nums[largest])
            largest = l;

        if (r < n && nums[r] > nums[largest])
            largest = r;

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    //time complex o(k+n), space o(k+n)
    public static void countingSort(int[] nums, int finish) {
        int[] index = new int[finish+1];
        int n = nums.length;
        int[] output = new int[n];

        for (int num : nums)
            index[num]++;

        for (int i = 1; i <= finish; i++) {
            index[i] += index[i-1];
        }

        for (int i = 0; i < n; i++) {
            output[index[nums[i]]-1] = nums[i];
            index[nums[i]]--;
        }

        System.out.println(Arrays.toString(output));
    }

    //time comple o(nk) , space o(n+k)
    public static void radixSort(int[] nums) {
        List<LinkedList<Integer>> saved = new ArrayList<>();
        Queue<Integer> numbers = new LinkedList<>();

        int maxDigitSize = getMaxRadix(nums);

        for (int i : nums) numbers.add(i);

        for (int i = 0; i < 10; i++) saved.add(new LinkedList<>());

        for (int i = 1; maxDigitSize/i > 0; i *= 10) {

            for (int j = 0; j < nums.length; j++) {
                int number = numbers.remove();
                int digit = (number / i) % (10);
                saved.get(digit).add(number);
            }
            int j = 0;
            while (!saved.isEmpty() && j < 10) {
                while (!saved.get(j).isEmpty()) {
                    int num = saved.get(j).remove();
                    numbers.add(num);
                }
                j++;
            }
        }

        System.out.println(numbers);
    }

    //time complex o(nk), space o(n+k)
    public static void radixSortBestImplemented(int[] nums) {
        int maxDigitSize = getMaxRadix(nums);

        for (int i = 1; maxDigitSize/i > 0; i *= 10) {
            int[] sorted = new int[nums.length];
            int[] count = new int[10];
            Arrays.fill(count, 0);

            for (int j = 0; j < nums.length; j++) {
                count[(nums[j]/i)%10]++;
            }

            for (int j = 1; j < 10; j++)
                count[j] += count[j - 1];

            for (int j = nums.length - 1; j >= 0; j--) {
                sorted[count[(nums[j]/i)%10] - 1] = nums[j];
                count[(nums[j]/i)%10]--;
            }

            for (int j = 0; j < nums.length; j++)
                nums[j] = sorted[j];
        }

        System.out.println(Arrays.toString(nums));
    }

    public static int getMaxRadix(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) max = i;
        }

        return max;
    }

    //time complex o(n+k), space complex o(n*k)
    public static void bucketSort(double[] nums, int n) {
        List<LinkedList<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) buckets.add(new LinkedList<>());

        for (double num : nums) {
            buckets.get((int)(n*num)).add(num);
        }

        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i) != null) {
                Collections.sort(buckets.get(i));
            }
        }

        int j = 0;
        for (int i = 0; i < buckets.size(); i++) {
            while (!buckets.get(i).isEmpty()) {
                double data = buckets.get(i).remove();
                nums[j] = data;
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

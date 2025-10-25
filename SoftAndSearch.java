=== CustomSorter (Selection Sort) ===
Исходные данные: [45, 12, 78, 33, 91]
Отсортированные данные: [12, 33, 45, 78, 91]

=== SimpleSorter (Bubble Sort) ===
Исходные данные: [55, 14, 88, 27, 39, 99, 41]
Отсортированные данные: [14, 27, 39, 41, 55, 88, 99]

=== ArraySorter (Insertion Sort) ===
Исходные данные: [15, 7, 9, 2, 8]
Отсортированные данные: [2, 7, 8, 9, 15]

=== SplitSorter (Merge Sort) ===
Исходные данные: [50, 15, 65, 7, 18, 95, 25]
Отсортированные данные: [7, 15, 18, 25, 50, 65, 95]

=== GapSorter (Shell Sort) ===
Исходные данные: [34, 11, 2, 9, 45, 67, 3, 5]
Отсортированные данные: [2, 3, 5, 9, 11, 34, 45, 67]

=== TreeSorter (Heap Sort) ===
Исходные данные: [7, 12, 4, 8, 2]
Отсортированные данные: [2, 4, 7, 8, 12]

=== SequentialSearch (Linear Search) ===
Исходные данные: [3, 6, 9, 13, 17, 24, 41, 48]
Результат поиска: элемент 17 найден на позиции: 4
Результат поиска: элемент 101 найден на позиции: -1

=== BinaryFinder (Binary Search) ===
Исходные данные: [3, 6, 9, 13, 17, 24, 41, 48, 70, 92]
Результат поиска: элемент 24 найден на позиции: 5

=== EstimateSearch (Interpolation Search) ===
Исходные данные: [5, 15, 25, 35, 45, 55, 65, 75, 85, 95]
Результат поиска: элемент 55 найден на позиции: 5
Результат поиска: элемент 52 найден на позиции: -1

=== FibonacciFinder (Fibonacci Search) ===
Исходные данные: [5, 18, 28, 33, 38, 43, 88, 89, 92, 95, 105]
Результат поиска: элемент 92 найден на позиции: 8
Результат поиска: элемент 28 найден на позиции: 2

public class AllSortsAndSearches {

    // === 1. CustomSorter (Selection Sort) ===
    public static class CustomSorter {
        public static void executeSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {45, 12, 78, 33, 91};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            executeSort(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 2. SimpleSorter (Bubble Sort) ===
    public static class SimpleSorter {
        public static void performSort(int[] nums) {
            int size = nums.length;
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {55, 14, 88, 27, 39, 99, 41};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            performSort(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 3. ArraySorter (Insertion Sort) ===
    public static class ArraySorter {
        public static void arrange(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                int current = nums[i];
                int prev = i - 1;

                while (prev >= 0 && nums[prev] > current) {
                    nums[prev + 1] = nums[prev];
                    prev = prev - 1;
                }
                nums[prev + 1] = current;
            }
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {15, 7, 9, 2, 8};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            arrange(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 4. SplitSorter (Merge Sort) ===
    public static class SplitSorter {
        public static void divideSort(int[] nums) {
            if (nums.length < 2) return;

            int center = nums.length / 2;
            int[] left = new int[center];
            int[] right = new int[nums.length - center];

            System.arraycopy(nums, 0, left, 0, center);
            System.arraycopy(nums, center, right, 0, nums.length - center);

            divideSort(left);
            divideSort(right);
            combine(nums, left, right);
        }

        private static void combine(int[] nums, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    nums[k++] = left[i++];
                } else {
                    nums[k++] = right[j++];
                }
            }

            while (i < left.length) nums[k++] = left[i++];
            while (j < right.length) nums[k++] = right[j++];
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {50, 15, 65, 7, 18, 95, 25};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            divideSort(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 5. GapSorter (Shell Sort) ===
    public static class GapSorter {
        public static void processSort(int[] nums) {
            int size = nums.length;

            for (int gap = size / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < size; i++) {
                    int temp = nums[i];
                    int j;
                    for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                        nums[j] = nums[j - gap];
                    }
                    nums[j] = temp;
                }
            }
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {34, 11, 2, 9, 45, 67, 3, 5};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            processSort(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 6. TreeSorter (Heap Sort) ===
    public static class TreeSorter {
        public static void sortHeap(int[] nums) {
            int size = nums.length;

            for (int i = size / 2 - 1; i >= 0; i--)
                adjust(nums, size, i);

            for (int i = size - 1; i > 0; i--) {
                swap(nums, 0, i);
                adjust(nums, i, 0);
            }
        }

        private static void adjust(int[] nums, int size, int root) {
            int largest = root;
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < size && nums[left] > nums[largest])
                largest = left;

            if (right < size && nums[right] > nums[largest])
                largest = right;

            if (largest != root) {
                swap(nums, root, largest);
                adjust(nums, size, largest);
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {7, 12, 4, 8, 2};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            sortHeap(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 7. SequentialSearch (Linear Search) ===
    public static class SequentialSearch {
        public static int findElement(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {3, 6, 9, 13, 17, 24, 41, 48};
            int target = 17;
            System.out.print("Исходные данные: ");
            displayArray(testData);
            int result = findElement(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 101;
            result = findElement(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 8. BinaryFinder (Binary Search) ===
    public static class BinaryFinder {
        public static int locate(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) return mid;
                if (nums[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return -1;
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {3, 6, 9, 13, 17, 24, 41, 48, 70, 92};
            int target = 24;
            System.out.print("Исходные данные: ");
            displayArray(testData);
            int result = locate(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 9. EstimateSearch (Interpolation Search) ===
    public static class EstimateSearch {
        public static int predict(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low <= high && target >= nums[low] && target <= nums[high]) {
                if (low == high) {
                    if (nums[low] == target) return low;
                    return -1;
                }

                int pos = low + ((target - nums[low]) * (high - low)) / (nums[high] - nums[low]);

                if (nums[pos] == target) return pos;
                if (nums[pos] < target) low = pos + 1;
                else high = pos - 1;
            }
            return -1;
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {5, 15, 25, 35, 45, 55, 65, 75, 85, 95};
            int target = 55;
            System.out.print("Исходные данные: ");
            displayArray(testData);
            int result = predict(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 52;
            result = predict(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === 10. FibonacciFinder (Fibonacci Search) ===
    public static class FibonacciFinder {
        public static int locateFibonacci(int[] nums, int target) {
            int fmm2 = 0;
            int fmm1 = 1;
            int fm = fmm2 + fmm1;

            while (fm < nums.length) {
                fmm2 = fmm1;
                fmm1 = fm;
                fm = fmm2 + fmm1;
            }

            int offset = -1;

            while (fm > 1) {
                int i = Math.min(offset + fmm2, nums.length - 1);

                if (nums[i] < target) {
                    fm = fmm1;
                    fmm1 = fmm2;
                    fmm2 = fm - fmm1;
                    offset = i;
                } else if (nums[i] > target) {
                    fm = fmm2;
                    fmm1 = fmm1 - fmm2;
                    fmm2 = fm - fmm1;
                } else {
                    return i;
                }
            }

            if (fmm1 == 1 && nums[offset + 1] == target)
                return offset + 1;

            return -1;
        }

        public static void displayArray(int[] nums) {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            int[] testData = {5, 18, 28, 33, 38, 43, 88, 89, 92, 95, 105};
            int target = 92;
            System.out.print("Исходные данные: ");
            displayArray(testData);
            int result = locateFibonacci(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);

            target = 28;
            result = locateFibonacci(testData, target);
            System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
            System.out.println();
        }
    }

    // === Main для запуска всех классов ===
    public static void main(String[] args) {
        System.out.println("=== CustomSorter (Selection Sort) ===");
        CustomSorter.main(args);

        System.out.println("=== SimpleSorter (Bubble Sort) ===");
        SimpleSorter.main(args);

        System.out.println("=== ArraySorter (Insertion Sort) ===");
        ArraySorter.main(args);

        System.out.println("=== SplitSorter (Merge Sort) ===");
        SplitSorter.main(args);

        System.out.println("=== GapSorter (Shell Sort) ===");
        GapSorter.main(args);

        System.out.println("=== TreeSorter (Heap Sort) ===");
        TreeSorter.main(args);

        System.out.println("=== SequentialSearch (Linear Search) ===");
        SequentialSearch.main(args);

        System.out.println("=== BinaryFinder (Binary Search) ===");
        BinaryFinder.main(args);

        System.out.println("=== EstimateSearch (Interpolation Search) ===");
        EstimateSearch.main(args);

        System.out.println("=== FibonacciFinder (Fibonacci Search) ===");
        FibonacciFinder.main(args);
    }
}
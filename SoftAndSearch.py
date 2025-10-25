=== InsertionSorter (из Python InsertionSort) ===
Исходные данные: [15, 8, 42, 4, 23, 16]
Отсортированные данные: [4, 8, 15, 16, 23, 42]

=== QuickSorter (из Python QuickSort) ===
Исходные данные: [24, 15, 38, 2, 19, 41, 8]
Отсортированные данные: [2, 8, 15, 19, 24, 38, 41]

=== BinaryFinder (из Python BinarySearch) ===
Исходные данные: [3, 7, 14, 21, 29, 33, 42, 55, 67, 78]

Результат поиска: элемент 29 найден на позиции: 4
Результат поиска: элемент 7 найден на позиции: 1
Результат поиска: элемент 100 не найден
Результат поиска: элемент 42 найден на позиции: 6

public class AllPythonToJava {

    // === 1. InsertionSorter (из Python InsertionSort) ===
    public static class InsertionSorter {
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
            int[] testData = {15, 8, 42, 4, 23, 16};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            arrange(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 2. QuickSorter (из Python QuickSort) ===
    public static class QuickSorter {
        public static void processSort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private static void quickSort(int[] nums, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(nums, low, high);
                quickSort(nums, low, pivotIndex - 1);
                quickSort(nums, pivotIndex + 1, high);
            }
        }

        private static int partition(int[] nums, int low, int high) {
            int pivot = nums[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (nums[j] < pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, high);
            return i + 1;
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
            int[] testData = {24, 15, 38, 2, 19, 41, 8};
            System.out.print("Исходные данные: ");
            displayArray(testData);
            processSort(testData);
            System.out.print("Отсортированные данные: ");
            displayArray(testData);
            System.out.println();
        }
    }

    // === 3. BinaryFinder (из Python BinarySearch) ===
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
            int[] testData = {3, 7, 14, 21, 29, 33, 42, 55, 67, 78};
            int[] targets = {29, 7, 100, 42};

            System.out.print("Исходные данные: ");
            displayArray(testData);
            System.out.println();

            for (int target : targets) {
                int result = locate(testData, target);
                if (result != -1) {
                    System.out.println("Результат поиска: элемент " + target + " найден на позиции: " + result);
                } else {
                    System.out.println("Результат поиска: элемент " + target + " не найден");
                }
            }
            System.out.println();
        }
    }

    // === Main для запуска всех классов ===
    public static void main(String[] args) {
        System.out.println("=== InsertionSorter (из Python InsertionSort) ===");
        InsertionSorter.main(args);

        System.out.println("=== QuickSorter (из Python QuickSort) ===");
        QuickSorter.main(args);

        System.out.println("=== BinaryFinder (из Python BinarySearch) ===");
        BinaryFinder.main(args);
    }
}
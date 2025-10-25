=== InsertionSorter (из Python InsertionSort) ===
Исходные данные: [33, 17, 68, 9, 45, 28]
Отсортированные данные: [9, 17, 28, 33, 45, 68]

=== QuickSorter (из Python QuickSort) ===
Исходные данные: [42, 23, 71, 5, 36, 89, 14]
Отсортированные данные: [5, 14, 23, 36, 42, 71, 89]

=== BinaryFinder (из Python BinarySearch) ===
Исходные данные: [5, 12, 23, 37, 48, 55, 69, 81, 94, 107]

Результат поиска: элемент 48 найден на позиции: 4
Результат поиска: элемент 12 найден на позиции: 1
Результат поиска: элемент 150 не найден
Результат поиска: элемент 69 найден на позиции: 6

# =========================================
# 1. InsertionSorter (из оригинального InsertionSort)
class InsertionSorter:
    @staticmethod
    def arrange(arr):
        """
        Сортировка вставками
        Сложность: O(n²) в худшем случае, O(n) в лучшем случае
        """
        for i in range(1, len(arr)):
            current = arr[i]
            j = i - 1

            while j >= 0 and arr[j] > current:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = current

    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

    @staticmethod
    def main():
        test_array = [33, 17, 68, 9, 45, 28]
        print("Исходные данные:", InsertionSorter._print_array(test_array))
        InsertionSorter.arrange(test_array)
        print("Отсортированные данные:", InsertionSorter._print_array(test_array))
        print()


# =========================================
# 2. QuickSorter (из оригинального QuickSort)
class QuickSorter:
    @staticmethod
    def process_sort(arr):
        """
        Быстрая сортировка
        Сложность: O(n log n) в среднем, O(n²) в худшем случае
        """
        QuickSorter._quick_sort(arr, 0, len(arr) - 1)

    @staticmethod
    def _quick_sort(arr, low, high):
        if low < high:
            pi = QuickSorter._partition(arr, low, high)
            QuickSorter._quick_sort(arr, low, pi - 1)
            QuickSorter._quick_sort(arr, pi + 1, high)

    @staticmethod
    def _partition(arr, low, high):
        pivot = arr[high]
        i = low - 1

        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                QuickSorter._swap(arr, i, j)

        QuickSorter._swap(arr, i + 1, high)
        return i + 1

    @staticmethod
    def _swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]

    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

    @staticmethod
    def main():
        test_array = [42, 23, 71, 5, 36, 89, 14]
        print("Исходные данные:", QuickSorter._print_array(test_array))
        QuickSorter.process_sort(test_array)
        print("Отсортированные данные:", QuickSorter._print_array(test_array))
        print()


# =========================================
# 3. BinaryFinder (из оригинального BinarySearch)
class BinaryFinder:
    @staticmethod
    def locate(arr, target):
        """
        Бинарный поиск
        Сложность: O(log n)
        Требует отсортированный массив
        """
        left = 0
        right = len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

    @staticmethod
    def main():
        test_array = [5, 12, 23, 37, 48, 55, 69, 81, 94, 107]
        targets = [48, 12, 150, 69]

        print("Исходные данные:", BinaryFinder._print_array(test_array))
        print()

        for target in targets:
            result = BinaryFinder.locate(test_array, target)
            if result != -1:
                print(f"Результат поиска: элемент {target} найден на позиции: {result}")
            else:
                print(f"Результат поиска: элемент {target} не найден")
        print()


# =========================================
# Запуск всех алгоритмов
if __name__ == "__main__":
    print("=== InsertionSorter (из Python InsertionSort) ===")
    InsertionSorter.main()

    print("=== QuickSorter (из Python QuickSort) ===")
    QuickSorter.main()

    print("=== BinaryFinder (из Python BinarySearch) ===")
    BinaryFinder.main()

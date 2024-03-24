import java.util.Arrays;

public class Task2 {
        public static void main(String[] args) {
            int[] array = new int[100];
            // Заповнюємо масив випадковими числами в діапазоні -100..100
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 201) - 100;
            }

            rearrangeArray(array);

            // Виводимо відсортований масив
            System.out.println(Arrays.toString(array));
        }

        public static void rearrangeArray(int[] arr) {
            int left = 0; // Індекс для додатних чисел
            int right = arr.length - 1; // Індекс для від'ємних чисел

            // Переміщуємо додатні числа в ліву частину, від'ємні - в праву
            while (left <= right) {
                if (arr[left] < 0 && arr[right] >= 0) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                } else {
                    if (arr[left] >= 0) {
                        left++;
                    }
                    if (arr[right] < 0) {
                        right--;
                    }
                }
            }

            // Розміщаємо нулі по центру
            int mid = left; // Індекс для нулів
            for (int i = left; i < arr.length; i++) {
                if (arr[i] == 0) {
                    int temp = arr[i];
                    arr[i] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                }
            }
        }
}

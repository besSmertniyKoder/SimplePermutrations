
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {3, 4, 6, 2, 1, 9, 5};

        permute(arr, 0);

        permuteWithoutCollections(Arrays.stream(arr).mapToInt(Integer::intValue).toArray());
    }

    static void permute(Integer[] arrayBefore, int firstElement) {
        List<Integer> array = Arrays.asList(arrayBefore);
        for (int i = firstElement; i < array.size(); i++) {
            Collections.swap(array, i, firstElement);
            permute(arrayBefore, firstElement + 1);

            Collections.swap(array, firstElement, i);
        }
        if (firstElement == array.size() - 1) {
            System.out.println(Arrays.toString(array.toArray()));
        }
    }

    //Ниже рекурсивное решение без использования коллекций
    static void permuteWithoutCollections(int[] arr) {
        int count = fuctorial(arr.length);
        int max = arr.length - 1;
        int shift = max;
        int t;
        while (count > 0) {
            t = arr[shift];
            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            System.out.println(Arrays.toString(arr));
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

}

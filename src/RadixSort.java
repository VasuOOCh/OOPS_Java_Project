import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RadixSort {
    static int[] arr = {
            45, 12, 87, 23, 56, 34, 78, 15, 67, 39, 82, 28, 51, 93, 16, 74, 42, 89, 31, 65,
            19, 73, 47, 85, 26, 59, 14, 92, 38, 61, 83, 25, 57, 11, 94, 43, 76, 29, 68, 17,
            95, 32, 64, 13, 88, 46, 71, 35, 58, 22, 77, 41, 86, 24, 53, 18, 91, 44, 69, 27,
            84, 16, 72, 37, 96, 21, 63, 48, 75, 33, 62, 15, 97, 43, 81, 28, 55, 12, 79, 36,
            66, 24, 98, 45, 83, 19, 52, 87, 31, 74, 42, 88, 26, 61, 14, 93, 35, 67, 20, 54,
            49, 82, 17, 95, 38, 73, 25, 91, 44, 68, 13, 86, 32, 77, 21, 96, 45, 62, 29, 84,
            16, 93, 41, 75, 27, 89, 34, 58, 22, 97, 43, 81, 19, 65, 36, 92, 48, 71, 23, 85,
            31, 76, 18, 94, 42, 67, 28, 83, 15, 96, 37, 72, 25, 88, 46, 63, 21, 95, 34, 79,
            12, 87, 45, 61, 29, 93, 16, 74, 38, 82, 27, 91, 43, 68, 14, 86, 35, 77, 22, 98,
            47, 81, 26, 92, 39, 75, 18, 94, 33, 85, 24, 97, 41, 66, 28, 89, 15, 73, 36, 84,
            25, 96, 42, 78, 13, 87, 31, 95, 44, 69, 17, 92, 38, 83, 22, 97, 45, 71, 27, 88,
            16, 93, 35, 82, 28, 76, 19, 94, 41, 67, 23, 85, 32, 78, 14, 91, 46, 72, 25, 86,
            37, 81, 18, 95, 43, 69, 26, 92, 33, 77, 15, 88, 42, 64, 29, 96, 21, 75, 34, 83,
            17, 94, 39, 73, 24, 87, 31, 82, 45, 68, 22, 91, 36, 79, 13, 95, 44, 66, 28, 84,
            19, 93, 47, 71, 26, 85, 32, 78, 16, 96, 41, 67, 23, 89, 35, 74, 27, 92, 18, 86,
            43, 77, 25, 91, 38, 72, 14, 95, 33, 81, 29, 87, 42, 65, 21, 94, 37, 76, 24, 88,
            15, 93, 46, 69, 28, 82, 34, 77, 22, 97, 41, 63, 26, 85, 31, 92, 17, 74, 39, 86,
            23, 95, 44, 68, 12, 91, 35, 79, 27, 83, 16, 96, 42, 75, 28, 87, 33, 62, 19, 94,
            45, 71, 24, 88, 36, 82, 21, 97, 43, 65, 29, 84, 15, 93, 47, 76, 25, 89, 32, 78,
            18, 95, 41, 73, 27, 86, 34, 81, 22, 96, 38, 67, 13, 92, 46, 72, 28, 85, 31, 77,
            16, 94, 42, 69, 25, 88, 33, 83, 19, 97, 45, 64, 23, 91, 37, 75, 26, 87, 32, 78,
            14, 95, 43, 66, 29, 84, 21, 98, 35, 73, 17, 92, 44, 68, 24, 86, 39, 81, 27, 93,
            15, 97, 41, 74, 22, 89, 36, 82, 28, 85, 13, 96, 45, 71, 25, 88, 34, 77, 19, 94,
            42, 67, 23, 91, 38, 76, 16, 95, 31, 83, 27, 87, 44, 62, 21, 96, 35, 78, 24, 92,
            17, 85, 46, 73, 28, 89, 32, 81, 14, 97, 43, 65, 26, 93, 37, 74, 22, 88, 33, 79,
            18, 95, 41, 72, 25, 86, 34, 77, 16, 98, 45, 63, 29, 91, 38, 76, 23, 87, 31, 82,
            15, 94, 42, 68, 27, 83, 35, 78, 21, 96, 44, 61, 19, 92, 36, 75, 28, 86, 32, 77,
            13, 95, 47, 71, 24, 88, 39, 84, 22, 97, 43, 66, 18, 93, 37, 72, 25, 89, 34, 81,
            16, 96, 41, 69, 28, 85, 33, 76, 12, 94, 45, 67, 23, 87, 38, 73, 26, 91, 35, 78,
            14, 97, 42, 65, 29, 83, 31, 75, 17, 95, 44, 68, 22, 86, 39, 74, 27, 92, 36, 82,
            15, 98, 43, 71, 25, 89, 32, 77, 18, 96, 41, 64, 28, 85, 37, 73, 24, 93, 34, 79,
            16, 95, 46, 72, 21, 87, 33, 78, 26, 91, 42, 66, 19, 94, 38, 75, 23, 88, 35, 81,
            17, 96, 44, 69, 28, 84, 31, 77, 22, 92, 45, 63, 25, 86, 37, 74, 29, 89, 32, 78,
            13, 97, 41, 73, 26, 85, 34, 76, 18, 93, 46, 67, 21, 88, 39, 72, 27, 91, 33, 82,
            15, 94, 42, 68, 24, 87, 35, 79, 19, 95, 43, 65, 28, 86, 31, 75, 22, 92, 36, 83,
            16, 98, 44, 71, 25, 89, 32, 77, 17, 96, 41, 66, 23, 85, 38, 74, 27, 93, 34, 81
    };
    static ArrayVisual arrayVisual = new ArrayVisual(arr);

    public static void main(String[] args) {
        System.out.println(arr.length);
        radixSort(arr,arr.length);
//        System.out.println(Arrays.toString(arr));
    }


    public static void radixSort(int[] arr, int n) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int m = findLargest(arr, n);
            // m is the largest , so will iterate the no. of digits in m

            for (int i = 1; m/i > 0; i*=10) {
                // now i represents the exponent (1,10,100, ....)
                countSort(arr,n,i);
            }
        }).start();

    }

    public static void countSort(int[] arr, int n, int e) {
        int[] count = new int[10];
        // digits can be from 0-9 i.e length is 10
        Arrays.fill(count, 0);

        int[] output = new int[n];

        // storing the count of expo. digit i in count array
        for (int i = 0; i < n; i++) {
            count[(arr[i]/e) % 10]++;
            arrayVisual.panel.paintCurrentElement(i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
            // arr[i]/e % 10 this will give the exponent digit of the arr[i]
        }

        // commulative addition :
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        // after this step :
        // the (value-1) af the ith index of the count array is the position of the org. array element whose
        // exponent digit is i

        // Making the output
        for (int i = n-1; i >=0 ; i--) {
            output[count[(arr[i]/e) % 10] - 1] = arr[i];
            count[(arr[i]/e) % 10]--;
        }

        // copying into original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
            arrayVisual.panel.repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }

    }

    public static int findLargest(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}

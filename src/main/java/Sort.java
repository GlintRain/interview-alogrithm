import java.util.Arrays;

/**
 * @author ming
 * @version Sort, v 0.1 2018/6/20 上午11:17 ming
 */
public class Sort {
    //选择排序
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int minIndex = 0;
        //只需要比较n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //如果minIndex不为i，说明找到了更小的值，交换之。
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //假设第一个数位置时正确的；要往后移，必须要假设第一个。
        for (int i = 1; i < arr.length; i++) {

            int j = i;
            //待插入的
            int target = arr[i];

            //后移
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            //插入
            arr[j] = target;
        }

    }

    //快排 不鼓励这种全写在一起的方式
    public static void qsort(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int base = begin;
        int left = begin;
        int right = end;
        //要考虑等于的情况吗？
        while (left < right) {
            while (left < right && data[right] >= data[base]) {
                right--;
            }
            while (left < right && data[left] <= data[base]) {
                left++;
            }
            int temp = data[right];
            data[right] = data[left];
            data[left] = temp;

        }

        int temp = data[base];
        data[base] = data[left];
        data[left] = temp;

        qsort(data, begin, left - 1);
        qsort(data, left + 1, end);
    }

    //一次划分
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        int pivotPointer = left;
        while (left < right) {
            while (left < right && arr[right] >= pivotKey) {
                right--;
            }
            while (left < right && arr[left] <= pivotKey) {
                left++;
            }
            //把大的交换到右边，把小的交换到左边。
            swap(arr, left, right);
        }
        //最后把pivot交换到中间
        swap(arr, pivotPointer, left);
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] data = { 2, 4, 1, 2, 5, 6, 7 };
        qsort(data, 0, data.length - 1);
        System.out.println("data:" + Arrays.toString(data));
    }
}

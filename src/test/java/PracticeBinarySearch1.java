public class PracticeBinarySearch1 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        int result = search(arr, 0, arr.length - 1, 5);

        System.out.println(result);

    }

    public  static  int search(int[] arr, int leftIndex, int rightIndex, int value) {

        if (leftIndex > rightIndex) {
            return -1;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        int middleValue = arr[middleIndex];
        if (value < middleValue) {
            return search(arr, leftIndex, middleIndex - 1, value);
        } else if (value > middleValue) {
            return search(arr, middleIndex + 1, rightIndex, value);
        } else {

            return middleValue;
        }

    }
}

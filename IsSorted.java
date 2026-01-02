public class IsSorted {

    public static boolean isSorted(int[] a) {
       if (a.length == 0) {
            return true;
        }
        return isSortedHelper(a, 0);
    }

    private static boolean isSortedHelper(int[] a, int i) {
        if (i >= a.length - 1) {
            return true;
        }

        if (a[i] > a[i + 1]) {
            return false;
        }

        return isSortedHelper(a, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}
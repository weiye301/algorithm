package leetcode;

/**
 * @author weiye
 * @date 2021/2/22 10:56
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class JianZhiOffer51 {

    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, tmp);
    }

    private int sort(int[] arr, int l, int r, int[] tmp) {
        if (l >= r) return 0;

        int res = 0;
        int mid = (l + r) / 2;
        res += sort(arr, l, mid, tmp);
        res += sort(arr, mid + 1, r, tmp);

        if (arr[mid] > arr[mid + 1]) {
            res += merge(arr, l, r, mid, tmp);
        }
        return res;
    }

    private int merge(int[] arr, int l, int r, int mid, int[] tmp) {
        System.arraycopy(arr, l, tmp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        int res = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i];
                i++;
            } else if (tmp[i] > tmp[j]) {
                res += mid - i + 1;
                arr[k] = tmp[j];
                j++;
            } else {
                arr[k] = tmp[i];
                i++;
            }
        }
        return res;
    }
}

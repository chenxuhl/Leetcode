//Java
//Author:Joey
//Date：2020/08/23

//解题思路：递归

package main.java.笔试.joey.tencent;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/8/23 21:44
 */
public class tc04 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        res = helper(arr,0, n-1, 0);
        System.out.println(res);
    }
    public static int helper(int[] arr, int l, int r, int h) {
        if (l > r) return 0;
        int minn = Integer.MAX_VALUE, ind = -1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] < minn) {
                minn = arr[i];
                ind = i;
            }
            if (arr[i] > h)  sum++;
        }
        int num = minn - h;
        int next_h = minn;
        int res_l = helper(arr, l, ind-1, next_h);
        int res_r = helper(arr, ind+1, r, next_h);
        int res = Math.min(sum, res_l+res_r+num);
        return res;
    }
}

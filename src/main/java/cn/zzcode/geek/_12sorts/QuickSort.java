/*
 * $Id: QuickSort.java, 2018年10月22日 下午6:34:45 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._12sorts;

/**
 * <p>
 * Title: QuickSort
 * </p>
 * <p>
 * Description:快速排序
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月22日 下午6:34:45
 * @modified [who date description]
 * @check [who date description]
 */
public class QuickSort {

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int partition = partition(a, p, r);
        quickSortInternally(a, p, partition - 1);
        quickSortInternally(a, partition + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;

    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 3, 5};
        quickSort(a, a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

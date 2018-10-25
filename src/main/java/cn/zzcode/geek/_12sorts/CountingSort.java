/*
 * $Id: CountingSort.java, 2018年10月23日 下午7:11:27 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._12sorts;

import cn.zzcode.geek.util.ArrayUtils;

/**
 * <p>
 * Title: CountingSort
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月23日 下午7:11:27
 * @modified [who date description]
 * @check [who date description]
 */
public class CountingSort {
    public static void main(String[] argv) {
        CountingSort.countingSort(new int[] {16, 16, 4, 4, 10, 14, 7, 9, 3, 2, 8, 1});
        System.out.println("---------------------------");

    }

    public static void countingSort(int[] a) {
        // 假设A中的数据a'有，0<=a' && a' < k并且k=100
        int k = 20;
        countingSort(a, k);
    }

    private static void countingSort(int[] a, int k) {
        int[] countArray = new int[k];
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            countArray[value]++;
        }
        ArrayUtils.print(countArray);
        System.out.println("---------------------------");

        // 累加
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        ArrayUtils.print(countArray);
        System.out.println("---------------------------");

        int[] newArray = new int[k];
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int count = countArray[value];
            if (count > 0) {
                newArray[count - 1] = value;
                countArray[value]--;
            }
        }
        ArrayUtils.print(newArray);
    }
}

/*
 * $Id: Sorts.java, 2018年10月15日 下午6:51:21 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._11sorts;

/**
 * <p>
 * Title: Sorts
 * </p>
 * <p>
 * Description:冒泡排序，插入排序，选择排序
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月15日 下午6:51:21
 * @modified [who date description]
 * @check [who date description]
 */
public class Sorts {

    /**
     * 冒泡排序
     * 
     * @author XiuYu.Ge
     * @created 2018年10月15日 下午6:56:57
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {

                // 交换
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 
     * @author XiuYu.Ge
     * @created 2018年10月15日 下午7:07:50
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }

    /**
     * 选择排序
     * 
     * @author XiuYu.Ge
     * @created 2018年10月15日 下午8:36:05
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = 0; j < array.length; j++) {
                if (minValue < array[j]) {
                    minIndex = j;
                    minValue = array[j];
                }
            }

            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    /**
     * 
     * @author XiuYu.Ge
     * @created 2018年10月15日 下午6:56:53
     * @param array
     */
    public static void print(int[] array) {
        for (int curr = 0; curr < array.length; curr++) {
            System.out.print(array[curr] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3};
        // bubbleSort(arr);

        selectionSort(arr);
        //
        print(arr);
    }
}

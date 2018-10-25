/*
 * $Id: BinarySearchFind.java, 2018年10月25日 下午8:46:30 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._13find;

/**
 * <p>
 * Title: BinarySearchFind
 * </p>
 * <p>
 * Description:二分查找
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月25日 下午8:46:30
 * @modified [who date description]
 * @check [who date description]
 */
public class BinarySearchFind {

    static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * 迭代版本
     * 
     * @author XiuYu.Ge
     * @created 2018年10月25日 下午8:49:00
     */
    public static int iterationFind(int value) {
        int low = 0;
        int high = array.length;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] == value) {
                return array[mid];
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归版本
     * 
     * @author XiuYu.Ge
     * @created 2018年10月25日 下午9:02:07
     * @return
     */
    public static int recurrenceFind(int value) {
        return recurrence(0, array.length, value);

    }

    public static int recurrence(int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = (high + low) / 2;
        if (array[mid] == value) {
            return array[mid];
        } else if (array[mid] < value) {
            return recurrence(high, mid + 1, value);
        } else {
            return recurrence(mid - 1, low, value);
        }
    }

    public static void main(String[] args) {
        int iterationFind = recurrenceFind(111);
        System.out.println(iterationFind);
    }
}

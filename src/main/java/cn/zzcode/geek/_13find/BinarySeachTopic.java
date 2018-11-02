/*
 * $Id: BinarySeachTopic.java, 2018年10月26日 上午10:23:33 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._13find;

/**
 * <p>
 * Title: BinarySeachTopic
 * </p>
 * <p>
 * Description:二分题目
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月26日 上午10:23:33
 * @modified [who date description]
 * @check [who date description]
 */
public class BinarySeachTopic {

    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10, 13, 16};

    /**
     * 查找第一个值等于给定值的元素
     * 
     * @author XiuYu.Ge
     * @created 2018年10月26日 上午10:24:39
     */
    public static int seachFirst(int value) {
        int low = 0;
        int high = array.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * 
     * @author XiuYu.Ge
     * @created 2018年10月26日 上午10:24:39
     */
    public static int seachLast(int value) {
        int low = 0;
        int high = array.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * 
     * @author XiuYu.Ge
     * @created 2018年10月26日 下午8:03:34
     * @return
     */
    public static int seachBigFirst(int value) {
        int low = 0;
        int high = array.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] < value) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int seachFirst = seachFirst(8);
        System.out.println(seachFirst);
    }
}

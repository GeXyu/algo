/*
 * $Id: Array.java, 2018年10月11日 下午6:36:25 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._05array;

import java.util.Arrays;

/**
 * <p>
 * Title: Array
 * </p>
 * <p>
 * Description:数组的插入、删除、按照下标随机访问操作
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月11日 下午6:36:25
 * @modified [who date description]
 * @check [who date description]
 */
public class Array {

    int[] data;

    int count;

    public Array() {
        data = new int[5];
        count = 0;
    }

    /**
     * 像数组插入元素
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:41:08
     * @param index
     * @param value
     */
    public boolean add(int index, int value) {
        if (index < 0)
            return false;

        // 需要扩容
        if (index >= data.length) {
            magnify();
        }

        data[index] = value;
        count++;
        return true;
    }

    /**
     * 扩容
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:50:59
     */
    public void magnify() {
        int[] arr = new int[data.length + 5];
        System.arraycopy(data, 0, arr, 0, data.length);
        data = arr;
    }

    /**
     * 查找
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:41:17
     * @param index
     * @return
     */
    public int find(int index) {
        return data[index];
    }

    /**
     * 删除
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:42:30
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index > count)
            return false;
        for (; index < count - 1; index++) {
            int curr = index + 1;
            data[index] = data[curr];
        }

        // 最后一个元素置初始值
        data[count - 1] = 0;
        count--;
        return true;

    }

    /**
     * 添加到尾部
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:43:31
     * @param value
     * @return
     */
    public boolean addToTail(int value) {
        return add(count, value);
    }

    /**
     * 长度
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午6:37:41
     * @return
     */
    public int size() {
        return data.length;
    }

    /**
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午7:01:07
     * @return
     */
    @Override
    public String toString() {
        return "Array [data=" + Arrays.toString(data) + ", count=" + count + "]";
    }

}

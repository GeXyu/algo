/*
 * $Id: SleepSort.java, 2018年11月8日 上午9:23:42 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._11sorts;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Title: SleepSort
 * </p>
 * <p>
 * Description:睡眠排序
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年11月8日 上午9:23:42
 * @modified [who date description]
 * @check [who date description]
 */
public class SleepSort {

    int[] arr = {1, 10, 5, 4, 2, 7};

    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            SleepThread sleepThread = new SleepThread(arr[i]);
            new Thread(sleepThread).start();
        }
    }

    class SleepThread implements Runnable {
        private int time;

        public SleepThread(int time) {
            this.time = time;
        }

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time);
        }
    }

    // ------------
    public static void main(String[] args) {
        new SleepSort().sort();
    }
}

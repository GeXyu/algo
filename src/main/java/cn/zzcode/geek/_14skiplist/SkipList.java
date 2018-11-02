/*
 * $Id: SkipList.java, 2018年10月29日 下午8:02:58 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._14skiplist;

import java.util.Random;

/**
 * <p>
 * Title: SkipList
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月29日 下午8:02:58
 * @modified [who date description]
 * @check [who date description]
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;

    private Random random = new Random();

    private int levelCount = 1;

    // 带头链表
    private Node head = new Node();

    /**
     * 插入
     * 
     * @author XiuYu.Ge
     * @created 2018年11月2日 下午7:12:20
     * @param value
     */
    public void insert(int value) {
        // 抛硬币的高度
        int k = randomLevel();

        // 初始化
        Node newNode = new Node();
        newNode.data = value;
        Node[] update = new Node[k];
        for (int i = 0; i < k; i++) {
            update[i] = head;
        }

        // 找到带插入节点的左侧
        Node p = head;
        for (int i = k - 1; i >= 0; i--) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
            update[i] = p;
        }

        // 插入
        for (int i = 0; i < k; i++) {
            newNode.forwords[i] = update[i].forwords[i];
            update[i].forwords[i] = newNode;
        }

        // 更新节点
        if (levelCount < k) {
            levelCount = k;
        }

    }

    /**
     * 查找
     * 
     * @author XiuYu.Ge
     * @created 2018年11月2日 下午7:23:37
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = head;
        // 找到比当前value小的forwords[]
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
        }

        if (p.forwords[0] != null && p.forwords[0].data == value) {
            return p.forwords[0];
        }
        return null;
    }

    /**
     * 删除
     * 
     * @author XiuYu.Ge
     * @created 2018年11月2日 下午7:33:00
     * @param value
     */
    public void delete(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
        }

        if (p.forwords[0] != null && p.forwords[0].data == value) {

            for (int i = 0; i < levelCount; i++) {
                p.forwords[i] = p.forwords[0].forwords[i];
            }

        }
    }

    public void printAll() {
        Node p = head;
        while (p.forwords[0] != null) {
            System.out.print(p.forwords[0] + " ");
            p = p.forwords[0];
        }
        System.out.println();
    }

    /**
     * 抛硬币
     * 
     * @author XiuYu.Ge
     * @created 2018年11月1日 下午4:11:49
     * @return
     */
    public int randomLevel() {
        int k = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 0) {
                k++;
            }
        }
        return k;
    }

    public int getLevelCount() {
        return levelCount;
    }

    // ---------------
    class Node {
        public int data;
        public Node[] forwords = new Node[MAX_LEVEL];

        public Node() {
            super();
        }

        /**
         * @author XiuYu.Ge
         * @created 2018年11月1日 下午5:18:26
         * @return
         */
        @Override
        public String toString() {
            return data + " ";
        }
    }

    // --------
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(4);
        skipList.insert(3);

        skipList.printAll();

        skipList.delete(3);

        skipList.printAll();
    }
}

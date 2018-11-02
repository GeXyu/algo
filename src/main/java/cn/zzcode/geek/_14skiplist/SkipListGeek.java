/*
 * $Id: SkipList.java, 2018年10月29日 下午3:24:01 XiuYu.Ge Exp $
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
 * Description:跳表
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月29日 下午3:24:01
 * @modified [who date description]
 * @check [who date description]
 */
public class SkipListGeek {

    private static final int MAX_LEVEL = 16;

    // 当前层数
    private int levelCount = 1;

    private Node head = new Node(); // 带头链表

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
        }

        if (p.forwords[0] != null && p.forwords[0].data == value) {
            return p.forwords[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; ++i) {
            newNode.forwords[i] = update[i].forwords[i];
            update[i].forwords[i] = newNode;
        }

        if (levelCount < level)
            levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
            update[i] = p;
        }

        if (p.forwords[0] != null && p.forwords[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwords[i] != null && update[i].forwords[i].data == value) {
                    update[i].forwords[i] = update[i].forwords[i].forwords[i];
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwords[0] != null) {
            System.out.print(p.forwords[0] + " ");
            p = p.forwords[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        private Node forwords[] = new Node[MAX_LEVEL];

        // 最高层数
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}

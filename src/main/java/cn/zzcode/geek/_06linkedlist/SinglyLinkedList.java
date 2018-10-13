/*
 * $Id: SinglyLinkedList.java, 2018年10月11日 下午7:08:07 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._06linkedlist;

/**
 * <p>
 * Title: SinglyLinkedList
 * </p>
 * <p>
 * Description:单链表的插入、删除、查找操作；
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月11日 下午7:08:07
 * @modified [who date description]
 * @check [who date description]
 */
public class SinglyLinkedList {

    // 哨兵
    private Node sentry;

    private int count;

    public SinglyLinkedList() {
        sentry = new Node(0, null);
        count = 0;
    }

    /**
     * 删除
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午7:12:14
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index > count) {
            return false;
        }
        Node node = findNode(sentry.next, index, 0);
        if (node != null) {
            Node parentNode = findNode(sentry.next, index - 1, 0);
            parentNode.next = null;
            count--;

            // 如果下一个节点不为空，则把上一个节点的指针指向下一个节点
            Node next = node.next;
            if (next != null) {
                parentNode.next = next;
            }

        }
        return true;

    }

    /**
     * 获取尾节点
     * 
     * @author XiuYu.Ge
     * @created 2018年10月12日 下午12:24:59
     * @param node
     * @return
     */
    private Node findNode(Node node, int context, int curr) {
        if (context == -1) {
            return sentry;
        }

        if (curr == context) {
            return node;
        }
        if (node != null) {
            return findNode(node.next, context, curr + 1);
        }
        return node;
    }

    /**
     * 查找
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午7:11:41
     * @param index
     * @return
     */
    public int find(int index) {
        Node node = findNode(sentry.next, index, 0);
        if (node != null) {
            return node.data;
        }
        return -1;

    }

    /**
     * 添加到尾部
     * 
     * @author XiuYu.Ge
     * @created 2018年10月11日 下午7:12:00
     * @param value
     * @return
     */
    public boolean add(int value) {
        Node node = findNode(sentry, count, 0);
        node.next = new Node(value, null);
        count++;
        return true;

    }

    /**
     * 打印
     * 
     * @author XiuYu.Ge
     * @created 2018年10月12日 下午12:37:22
     */
    public void printAll() {
        Node currNode = sentry.next;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public Node getSentry() {
        return sentry;
    }

    public void setHead(Node head) {
        this.sentry.next = head;
    }

    /**
     * 
     * @author XiuYu.Ge
     * @created 2018年10月12日 下午12:43:07
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * @param sentry
     * @param count
     */
    public SinglyLinkedList(Node sentry, int count) {
        super();
        this.sentry = sentry;
        this.count = count;
    }

    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }

        /**
         * @author XiuYu.Ge
         * @created 2018年10月13日 上午9:19:38
         * @return
         */
        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

}

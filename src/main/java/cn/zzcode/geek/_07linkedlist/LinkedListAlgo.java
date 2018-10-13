/*
 * $Id: LinkedListAlgo.java, 2018年10月12日 下午12:59:24 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._07linkedlist;

import cn.zzcode.geek._06linkedlist.SinglyLinkedList;

/**
 * <p>
 * Title: LinkedListAlgo
 * </p>
 * <p>
 * Description: <br/>
 * 1) 单链表反转<br/>
 * 2) 链表中环的检测<br/>
 * 3) 两个有序的链表合并<br/>
 * 4) 删除链表倒数第n个结点<br/>
 * 5) 求链表的中间结点<br/>
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年10月12日 下午12:59:24
 * @modified [who date description]
 * @check [who date description]
 */
public class LinkedListAlgo extends SinglyLinkedList {

    /**
     * 单链表反转
     * 
     * @author XiuYu.Ge
     * @created 2018年10月12日 下午8:07:53
     * @param node
     */
    public void reverse(Node node) {
        Node left = null;
        Node between = node;
        Node right = node.next;
        Node head = null;

        while (right != null) {
            between.next = left;
            head = right.next;
            right.next = between;

            left = between;
            between = right;
            right = head;
        }

        setHead(between);
    }

    /**
     * 检测环
     * 
     * @author XiuYu.Ge
     * @created 2018年10月13日 上午9:27:55
     */
    public boolean checkCircle(Node node) {
        if (node == null)
            return false;

        Node fast = node;
        Node slow = node;

        while (fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next; // 慢指针走一步
            fast = fast.next.next;// 快指针走俩步

        }
        return false;
    }

    /**
     * 合并有序列表
     * 
     * @author XiuYu.Ge
     * @created 2018年10月13日 上午9:47:55
     * @param la
     * @param lb
     * @return
     */
    public Node mergeSortedLists(Node la, Node lb) {

        // 先合并到一个列表

        // 快排进行排序
        return lb;

    }

    /**
     * 删除倒数第K个元素
     * 
     * 先求出倒数第K个元素的下标<br>
     * 根据下标 找到该元素
     * 
     * @author XiuYu.Ge
     * @created 2018年10月13日 上午10:00:47
     * @param list
     * @param k
     */
    public void deleteLastKth(Node node, int k) {

        // 删除的下标
        int curr = size() - k;
        if (curr < 0) {
            return;
        }

        int i = 0;
        Node next = node;
        Node last = null;
        while (i <= curr) {

            last = next;
            next = next.next;
            // 说明是要删除的节点
            if (i == curr) {
                last.next = next.next;
            }

            i++;
        }

    }

    /**
     * 中间节点<br/>
     * 当快指针移动的速度是慢指针的2倍，当快指针移动到尾节点，那么慢指针就是中间节点
     * 
     * @author XiuYu.Ge
     * @created 2018年10月13日 上午10:24:56
     * @param node
     * @return
     */
    public Node findMiddle(Node node) {

        Node fast = node;
        Node slow = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        boolean checkCircle = linkedListAlgo.checkCircle(linkedListAlgo.getSentry().next);
        System.out.println(checkCircle);
    }

}

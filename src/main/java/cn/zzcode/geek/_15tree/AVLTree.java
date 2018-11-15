/*
 * $Id: AVLTree.java, 2018年11月15日 下午6:58:51 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2018 Vnierlai Technologies Co.,Ltd All rights reserved.
 * 
 * This software is copyrighted and owned by Vnierlai or the copyright holder specified, unless otherwise noted, and may
 * not be reproduced or distributed in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.geek._15tree;

/**
 * <p>
 * Title: AVLTree
 * </p>
 * <p>
 * Description:avl
 * </p>
 * 
 * @author XiuYu.Ge
 * @param <T>
 * @created 2018年11月15日 下午6:58:51
 * @modified [who date description]
 * @check [who date description]
 */
public class AVLTree {

    /**
     * 插入
     * 
     * @author XiuYu.Ge
     * @created 2018年11月15日 下午8:14:41
     */
    public void insert(Node node, int value) {
        if (node == null) {
            node = new Node(value, 0, null, null);
        } else {
            // 应该 放在左子树
            if (value < node.value) {

            }
        }
    }

    /**
     * 左单旋转 https://images0.cnblogs.com/i/497634/201403/281626153129361.jpg
     * 
     * @author XiuYu.Ge
     * @created 2018年11月15日 下午7:30:37
     * @return 旋转后的根节点
     */
    private Node leftLeft(Node k2) {
        Node k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;

        // 更新高度
        k2.height = max(height(k2.leftNode), height(k2.rightNode)) + 1;
        k1.height = max(height(k1.leftNode), k2.height) + 1;
        return k1;
    }

    /**
     * 右单旋转
     * 
     * @author XiuYu.Ge
     * @created 2018年11月15日 下午7:51:44
     * @return
     */
    private Node rightRight(Node k1) {
        Node k2 = k1.rightNode;
        k1.leftNode = k2.leftNode;
        k2.leftNode = k1;

        // 更新高度
        k1.height = max(height(k1.leftNode), height(k1.rightNode)) + 1;
        k2.height = max(height(k2.rightNode), k1.height) + 1;

        return k2;
    }

    /**
     * LR<br/>
     * 第一次旋转是围绕"k1"进行的"RR旋转"，第二次是围绕"k3"进行的"LL旋转"。
     * 
     * @author XiuYu.Ge
     * @created 2018年11月15日 下午8:10:16
     * @param K1
     * @return 旋转后的节点
     */
    private Node leftRight(Node k1) {
        Node k3 = rightRight(k1);
        return leftLeft(k3);
    }

    /**
     * RL<br/>
     * 第一次旋转是围绕"k3"进行的"LL旋转"，第二次是围绕"k1"进行的"RR旋转"。
     * 
     * @author XiuYu.Ge
     * @created 2018年11月15日 下午8:11:40
     * @return
     */
    private Node rightLeft(Node k3) {
        Node k1 = leftLeft(k3);
        return rightRight(k1);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int height(Node node) {
        if (node != null)
            return node.height;

        return 0;
    }

    // ------------------------------------
    private class Node {
        public int value;
        public int height;
        public Node leftNode;
        public Node rightNode;

        public Node(int value, int height, Node leftNode, Node rightNode) {
            super();
            this.value = value;
            this.height = height;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

}

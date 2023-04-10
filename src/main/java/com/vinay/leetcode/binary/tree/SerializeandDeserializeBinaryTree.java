package com.vinay.leetcode;

import com.vinay.leetcode.binary.tree.PathSum2.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree serializeandDeserializeBinaryTree = new SerializeandDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(serializeandDeserializeBinaryTree.serialize(root));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        List<TreeNode> levelOrder = new LinkedList<>();
        levelOrder.add(root);
        list.add(root.val);
        while (!levelOrder.isEmpty()){
            TreeNode remove = levelOrder.remove(0);
            if (remove.left == null)
                list.add(null);
            else {
                levelOrder.add(remove.left);
                list.add(remove.left.val);
            }

            if (remove.right == null)
                list.add(null);
            else {
                levelOrder.add(remove.right);
                list.add(remove.right.val);
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(list.remove(0));
        list.forEach(val->{
            if (val == null)
                str.append(",").append("null");
            else
                str.append(",").append(val);
        });
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        for (int i=1;i< split.length;i++){
            TreeNode remove = level.remove(0);
            if (split[i].compareToIgnoreCase("null") != 0) {
                remove.left = new TreeNode(Integer.valueOf(split[i]));
                level.add(remove.left);
            }
            if (split[++i].compareToIgnoreCase("null") != 0){
                remove.right = new TreeNode(Integer.valueOf(split[i]));
                level.add(remove.right);
            }
        }
        return root;
    }

}

package com.vinay.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree serializeandDeserializeBinaryTree = new SerializeandDeserializeBinaryTree();
        PathSum2.TreeNode root = new PathSum2.TreeNode(1);
        root.left = new PathSum2.TreeNode(2);
        root.left.left = new PathSum2.TreeNode(3);
        root.right = new PathSum2.TreeNode(4);
        System.out.println(serializeandDeserializeBinaryTree.serialize(root));
    }
    // Encodes a tree to a single string.
    public String serialize(PathSum2.TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        List<PathSum2.TreeNode> levelOrder = new LinkedList<>();
        levelOrder.add(root);
        list.add(root.val);
        while (!levelOrder.isEmpty()){
            PathSum2.TreeNode remove = levelOrder.remove(0);
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
    public PathSum2.TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] split = data.split(",");
        PathSum2.TreeNode root = new PathSum2.TreeNode(Integer.valueOf(split[0]));
        List<PathSum2.TreeNode> level = new LinkedList<>();
        level.add(root);
        for (int i=1;i< split.length;i++){
            PathSum2.TreeNode remove = level.remove(0);
            if (split[i].compareToIgnoreCase("null") != 0) {
                remove.left = new PathSum2.TreeNode(Integer.valueOf(split[i]));
                level.add(remove.left);
            }
            if (split[++i].compareToIgnoreCase("null") != 0){
                remove.right = new PathSum2.TreeNode(Integer.valueOf(split[i]));
                level.add(remove.right);
            }
        }
        return root;
    }

}

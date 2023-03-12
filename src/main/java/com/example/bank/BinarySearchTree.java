package com.example.bank;


import java.util.ArrayList;
class BSTNode {
    int key;
    String value;
    BSTNode left, right;

    public BSTNode(int data,String val){
        key = data;
        value=val;
        left = right = null;
    }
}
class BinarySearchTree {
    //BSTNode class that defines BST BSTNode

    // BST root BSTNode
    BSTNode root;

    // Constructor for BST =>initial empty tree
    BinarySearchTree(){
        root = null;
    }
    //delete a BSTNode from BST
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    BSTNode delete_Recursive(BSTNode root, int key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // BSTNode contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // BSTNode has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(BSTNode root)  {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    // insert a BSTNode in BST
    void insert(int key,String value)  {
        root = insert_Recursive(root, key,value);
    }

    //recursive insert function
    BSTNode insert_Recursive(BSTNode root, int key,String value) {
        //tree is empty
        if (root == null) {
            root = new BSTNode(key,value);
            return root;
        }
        //traverse the tree
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key,value);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key,value);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    public void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    void inorder_Recursive(BSTNode root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " "+root.value);

            inorder_Recursive(root.right);
        }
    }
    public ArrayList<String> inorderArray()
    {
        ArrayList<String> newStr=new ArrayList<String>();
        inorderrec(root,newStr);
        return newStr;
    }
    // recursively traverse the BST
    void inorderrec(BSTNode root,ArrayList<String> newStr) {
        if (root != null) {
            inorderrec(root.left,newStr);
            newStr.add(root.key+" "+root.value);


            inorderrec(root.right,newStr);
        }
    }

    String search(int key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return root.value;
        else
            return root.value;
    }

    //recursive insert function
    BSTNode search_Recursive(BSTNode root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
}
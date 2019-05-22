package com.company.test2018_021.questions;

import java.io.*;

/*
	题目描述
		判断给定的二叉树是否为二分查找树。假设树的每个节点以整数为键值，且不同节点的键值互不相等。二分查找树成立的判定条件：
		对任何非叶子节点A，如果A存在左子树，则A的键值大于其左子树所有节点的键值，且，如果A存在右子树，则A的键值小于其右子树所有节点的键值
	输入描述:
		第一行：根节点键值;
		第二行开始，二叉树的结构，每行代表一组根节点与左右子节点的对应关系，-1代表空节点。格式：
		根节点键值:左子节点键值|右子节点键值
		例如，
			5:3|-1
			表示键值为5的节点，左子节点的键值为3,右子节点为空节点
			假设：所有节点的键值非负，且不超过1023
	输出描述:
		判断结果，0表示输入不是二分查找树，1表示输入是二分查找树
	
	示例1
		输入
			5
			5:4|7
			4:3|8
			7:2|-1
			3:-1|-1
			8:-1|-1
			2:-1|-1
		输出
			0
	
 */
public class Question_031 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a1 = Integer.valueOf(br.readLine());
		BinaryTreeNode root = new BinaryTreeNode(a1, null, null);
		while(br.hashCode()>0) {
			int b1 = Integer.valueOf(br.readLine().split(":")[0]);
			int l1 = Integer.valueOf(br.readLine().split(":")[1].split("|")[0]);
			int r1 = Integer.valueOf(br.readLine().split(":")[1].split("|")[1]);
			
		}
	}
	
}
class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

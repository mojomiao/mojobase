package com.mojo.base.tree;

import java.util.List;

public class TreeNode {
    
    private int value;
    
    private List<TreeNode> childList;
    
    public TreeNode(int value) {
        this.value = value;
    }
    
    public TreeNode(int value, List<TreeNode> childList) {
        this.value = value;
        this.childList = childList;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public List<TreeNode> getChildList() {
        return childList;
    }
    
    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }
}

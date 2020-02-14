package com.company.project.demo;

public class IsSymmetry {
    boolean symmetry(Treenode treenode){
         if(treenode == null){return true;};
         return isSymmetrital(treenode.left,treenode.right);
    }


    public boolean isSymmetrital(Treenode left, Treenode right){
        if(left ==null && right ==null){return true;};
        if(left == null || right == null){return false;};

        return left.val == right.val && isSymmetrital(left.left,right.right) && isSymmetrital(left.right,right.left);

    }
}

class Treenode{
    int val = 0;
    Treenode left = null;
    Treenode right = null;
    public Treenode(int val){
        this.val =val;
    }
}
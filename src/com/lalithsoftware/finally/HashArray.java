package com.lalithsoftware.finally;

public class HashArray
{
    private SubsetBST subsetTree;
    private BucketList[] subsetArray;
    
    public HashArray()
    {
        subsetTree = new SubsetBST();
        subsetArray = new BucketList[100];
    }
}

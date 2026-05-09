package com.lalithsoftware.finally;
  
public class HashSubset
{
    private ArrayList<SubsetItem> itemList;
    private Integer size;

    public HashSubset()
    {
        itemList = new ArrayList<SubsetItem>();
        size = new Integer(0);
    }

    public ArrayList<SubsetItem> getItemList()
    {
        return itemList;
    }

    public int getSizeEstimate()
    {
        int toReturn = 0;
    }
}

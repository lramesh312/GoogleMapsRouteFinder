package com.lalithsoftware.finally;
  
public class HashSubset
{
    private ArrayList<SubsetItem> itemList;
    private Integer size;
    private Integer sizeEstimate;

    public HashSubset()
    {
        itemList = new ArrayList<SubsetItem>();
        size = new Integer(0);
        sizeEstimate = new Integer(0);
    }

    public ArrayList<SubsetItem> getItemList()
    {
        return itemList;
    }

    public int getSizeEstimate()
    {
        for(int k = 0; k < itemList.size(); k++)
        {
            SubsetItem listItem = itemList.get(k);
            
        }
        int toReturn = 0;
    }
}

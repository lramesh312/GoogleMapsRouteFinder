package com.lalithsoftware.finally;

public class BucketItem
{
      private BucketItem next = null;

      private HashItem data = null;
  
      public BucketItem()
      {
          
      }

      public BucketItem getNext()
      {
            return next;
      }

      public void setNext(BucketItem newNext)
      {
            next = newNext;
      }

      public HashItem getData()
      {
            return data;
      }

      public void setData(HashItem newData)
      {
            data = newData;
      }
}

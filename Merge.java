import java.util.*;
import java.io.*;

/*sort the array from least to greatest value. This is a wrapper function*/
public class Merge{
  public static void mergesort(int[] data){
    mergesortMake(data);
  }

  // public static void mergesortBreak(int[] data,int[] thing1,int[] thing2){
  //   if(data.length <= 1){} //stop
  //   else
  //   {
  //     int[] thing1Left = new int[thing1.length / 2];
  //     int[] thing1Right = new int[thing1.length - thing1Left.length];
  //     int[] thing2Left = new int[thing2.length / 2];
  //     int[] thing2Right = new int[thing2.length - thing2Left.length];
  //     for(int i = 0; i < thing1Left.length; i ++)
  //     {
  //       thing1Left[i] = thing1[i];
  //     }
  //     for(int i = 0; i < thing1right.length; i ++)
  //     {
  //       right[i] = data[left.length + i];
  //     }
  //     mergesortBreak(left,left,right);
  //     mergesortBreak(right,left,right);
  //   }
  // }

  public static void mergesortMake(int[] data){
    if(data.length <= 1){}
    else
    {
      int[] left = new int[data.length / 2];
      int[] right = new int[data.length - left.length];
      for(int i = 0; i < left.length; i ++)
      {
        left[i] = data[i];
      }
      for(int i = 0; i < right.length; i ++)
      {
        right[i] = data[left.length + i];
      }
      System.out.println("My two new arrays are");
      System.out.println(Arrays.toString(left));
      System.out.println(Arrays.toString(right));
      mergesortMake(left);
      mergesortMake(right);
      for(int i = 0, a = 0 , b = 0; a < left.length && b < right.length && i < data.length; i ++)
      {
        if(left[a] <= right[b])
        {
          data[i] = left[a];
          a ++;
        }
        else
        {
          data[i] = right[b];
          b ++;
        }
      }
    }
  }

  public static void main(String[] args){

  }

}

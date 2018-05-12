package pers.lxs.offer.from31to40;

import java.util.TreeSet;
import org.junit.Test;

public class Main33 {
	@Test
	public void test() {
		int index = 1650;

		System.out.println(GetUglyNumber_Solution(index));
	}

	public int GetUglyNumber_Solution(int index)
   {
     if (index <= 0) {
       return 0;
     }
 
     int[] nums = { 2, 3, 5 };
 
     int count = 0;
     int curr = 1;
 
     TreeSet<Integer> set = new TreeSet<Integer>();
     set.add(Integer.valueOf(curr));
  
     System.out.println(nums[0] + " " + count);
 
     while (!set.isEmpty()) {
       System.out.print(set.pollFirst() + " ");
     }
     System.out.println();
 
     return curr;
   }
}
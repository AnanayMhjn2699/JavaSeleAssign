package AnanayMahajan.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StringInverter {
	
	public static void main(String[] args) {
		String s="HEllo World";
		String s1=invertString(s);
		System.out.println(s1);
		
		
		
		//pattern problem:
		for(int i=5;i>0;i--) {
			for(int j=i;j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//Sorting the elements of hashMap
		HashMap<Character,Integer> m=new HashMap<Character,Integer>();
		m.put('A', 1);
		m.put('C', 2);
		m.put('B', 3);
		m.put('E', 4);
		m.put('D', 5);
		
		sorted(m);
		
		
	}

	
	private static void sorted(HashMap<Character, Integer> m) {
		// TODO Auto-generated method stub
		
		ArrayList<Character> Keys = new ArrayList<Character>(m.keySet());
 
        Collections.sort(Keys);
        for (Character x : Keys)
            System.out.println("Key = " + x + ", Value = " + m.get(x));

	}


	private static String invertString(String s) {
		// TODO Auto-generated method stub
		String[] list=s.split(" ");
		String s1="";
		for(String i:list) {
			StringBuffer sbr = new StringBuffer(i);
			s1=s1+sbr.reverse()+" ";
		}
		return s1;
	}
}

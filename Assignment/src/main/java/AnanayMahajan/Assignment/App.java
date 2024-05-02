package AnanayMahajan.Assignment;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    String str = "username1+password1-username2+password2-username3+password3-usernamen+passwordn";
    List<String> ans=stringSplitter(str);
    
    for(int i=0;i<ans.size();i=i+2) {
    	System.out.println("username is: "+ans.get(i)+" and password is: "+ans.get(i+1));
    }
    
  }
  
  public static List stringSplitter(String str) {
	  String[] list1 = str.split("-");
	    List<String> list2=new ArrayList<String>();  
	    for(String s:list1) {
	    	String[] var=s.split("\\+");
	    	list2.add(var[0])  ;
	    	list2.add(var[1])  ;
	    }
	    return list2;
  }
}

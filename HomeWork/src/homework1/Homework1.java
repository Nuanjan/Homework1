
package homework1;

import java.*;
import java.util.Arrays;;

public class Homework1 {
	
	public static int[] findMinMax(int[] array) {
		//The code for the Dance Counter question goes here
		
		int minSum=Integer.MAX_VALUE;
		int maxSum=Integer.MIN_VALUE;
		int sum = 0;
		int minIndex=0;
		int maxIndex=0;
		
		
		
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
			
			if(sum<minSum) {
				minSum=sum;
				minIndex=i;
				
			}	
			if(sum>maxSum) {
				maxSum=sum;
				maxIndex=i;
		}
			
			
		}
		
		
	return new int[] {minIndex,maxIndex};
	
	}
	
	
	

	public static int[] removeDup(int[] array) {
		//The code for the Clean the Data question goes here
		int newArr = new int[0];
		int j=0;
		boolean notSame=true;
		for(int i=0;i<array.length;i++) {
			if(notSame) {
				newArr=array[i];
			}else if(notSame==false) {
				break;
			}
		}
		
		for(int k=0;k<array.length;k++) {
			if(notSame) {
				newArr=array[k];
			}else if(notSame==false) {
				newArr=array[j];
				j++;
			}
		}
		return newArr;
	           
	        
	            }
	         
	    
	public static int createMirror(String str) {
		//The code for the Create a Word Mirror question goes here
		
				if(str.length()<=1) {
					return 0;
				}
				char begin = str.charAt(0);
				str = str.substring(1); //start form string index 1
				int found =-1;
				
				for(int i=str.length()-1;i>=0;i--) { //find found from the back
					if(str.charAt(i)==begin) { //compare char i to char index 0;
						found=i; //found=index
					}
				}
					if(found<0) { //no same char
						return 1+createMirror(str);
						
					}else {
						int case1= str.length()-(found+1)+createMirror(str.substring(0,found));
						int case2 = 1+createMirror(str);
						return Math.min(case1,case2);
						
					}
				}
	
				
	
	public static int minVisits(int mechanics, int houses) {
		//The code fore the Power Company Problem question goes here
		return 0;
	}
}

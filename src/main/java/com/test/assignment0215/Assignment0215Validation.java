package com.test.assignment0215;

import java.util.Arrays;
import java.util.List;

public class Assignment0215Validation {
	public boolean cropFormatValidation(String[] arrayColumnData) {
		final String[] cropCodeListArray = {"W", "B", "M", "BE", "C", "PO", "PA" , "O"};
		final List<String> cropCodeList = Arrays.asList(cropCodeListArray);
		
		if(arrayColumnData.length % 2 == 0) {
			System.out.println("The data of this line might have problem. ");
			return false;
		}
		
		if(arrayColumnData[0].length() <= 2 ) {
			 System.out.println("Area is not set properly");
			 return false;
		}
	
        for(int i = 1; i < arrayColumnData.length; i++ ) {
      	  if(i % 2 != 0) {
      		  if(!cropCodeList.contains(arrayColumnData[i].trim())) {
     			 System.out.println("This crop code is not included in the list : " + arrayColumnData[i]); 
     			 return false;
      		  }
      	  }else {
      		  if(!(arrayColumnData[i].trim()).matches("[0-9]*")) {
     			 System.out.println("Crop amount is not set properly : " + arrayColumnData[i]);
    			 return false;     			  
      		  }
      	  }	
        }
		return true;
	}
}

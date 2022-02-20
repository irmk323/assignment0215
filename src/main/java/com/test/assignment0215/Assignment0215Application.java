package com.test.assignment0215;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.*;

@SpringBootApplication
public class Assignment0215Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment0215Application.class, args);
		
//		String path = "src/main/resources/clean.csv";
		String path = "src/main/resources/validation_needed.csv";
	    BufferedReader buffReader = null;
	 
	      try {
	        FileInputStream fileInput = new FileInputStream(path);
	        InputStreamReader inputStream = new InputStreamReader(fileInput);
	        buffReader = new BufferedReader(inputStream);
	        String currentContent;
	        
	        Assignment0215Logic cropOutputLogic = new Assignment0215Logic();
	        Assignment0215Validation cropOutputValidation = new Assignment0215Validation();
	        
	        while((currentContent = buffReader.readLine()) != null) {
	            String[] arrayColumnData = currentContent.split(",");
	            
		          if(cropOutputValidation.cropFormatValidation(arrayColumnData)) {
			          Double totalSumOfCountry = 0.0;
			          for(int i = 1; i < arrayColumnData.length; i++ ) {
			        	  if(i % 2 == 0) {
			        		  totalSumOfCountry += Double.parseDouble(arrayColumnData[i]);
			        	  }
			          }
			          for(int i = 1; i < arrayColumnData.length; i++ ) {
			        	  if(i % 2 != 0) {
			        		  arrayColumnData[i] = cropOutputLogic.convertCropInitialToName(arrayColumnData[i].trim());
			        	  }else {
			        		  arrayColumnData[i] = cropOutputLogic.calculateCropsPercentage(totalSumOfCountry, Double.parseDouble(arrayColumnData[i]));
			        	  }
			          }
			        	  System.out.println((Arrays.toString(arrayColumnData)));		        	  
		          }else {
		        	  continue;
		          }
	        }
	      } catch(Exception ex) {
	        ex.printStackTrace();
	      } finally {
	        try{
	          buffReader.close();
	        } catch(Exception ex) {
	          ex.printStackTrace();
	        }
	      }
	}
}

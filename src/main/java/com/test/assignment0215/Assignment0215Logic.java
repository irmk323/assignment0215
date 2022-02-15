package com.test.assignment0215;

public class Assignment0215Logic {

	public String calculateCropsPercentage(Double totalSumOfCountry, Double cropAmount) {
		return String.valueOf(Math.round((cropAmount / totalSumOfCountry *100 )*10.0)/10.0);
	}

	public  String convertCropInitialToName(String initial) {
		String cropName = "";
		switch (initial){
		  case "W":
			  cropName = "Wheat";
		    break;
		  case "B":
			  cropName = "Barley";
		    break;
		  case "M":
			  cropName = "Maize";
		    break;
		  case "BE":
			  cropName = "Beetroot";
		    break;
		  case "C":
			  cropName = "Carrot";
		    break;
		  case "PO":
			  cropName = "Potatoes";
		    break;
		  case "PA":
			  cropName = "Parsnips";
		    break;
		  case "O":
			  cropName = "Oats";
		    break;
		  default:
			  cropName = "Not Exists";
		}
		return cropName;
	}
}

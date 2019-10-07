package com.david.learn.mockito.stubbing;

public enum SortOrder {
   ASC, DESC;
   
   public static SortOrder find(String order) {
	   for(SortOrder o: values()) {
		   if(o.name().equalsIgnoreCase(order)) {
			   return o;
		   }
	   }
	   return null;
   }
}

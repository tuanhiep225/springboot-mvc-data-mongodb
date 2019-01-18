package com.springmvc.springmongodbweb.utils;


import java.util.HashMap;
import java.util.Map;

public class ConvertPhone {
	private static Map<String, String> phones;
	
	static {
		phones = new HashMap<String,String>();
		phones.put( "070","84120");
		phones.put( "079","84121");
		phones.put("077","84122");
		phones.put("076","84126");
		phones.put("078","84128");
		
		phones.put("083","84123");
		phones.put("084","84124");
		phones.put("085","84125");
		phones.put("081","84127");
		phones.put("082","84129");
		
		phones.put("032","84162");
		phones.put("033","84163");
		phones.put("034","84164");
		phones.put("035","84165");
		phones.put("036","84166");
		phones.put("037","84167");
		phones.put("038","84168");
		phones.put("039", "84169");
		
		phones.put("056","84186");
		phones.put("058","84188");
		
		phones.put("059","84199");
	}
	
	public static String convert(String phone) {
		if(phone != null) {
			String dausomoi = phone.substring(0, 3);
			String number_original =phone.substring(3);
			String dausocu = phones.get(dausomoi);
			if(dausocu != null)
				return dausocu+number_original;
		}
		return "";
		
	}
}

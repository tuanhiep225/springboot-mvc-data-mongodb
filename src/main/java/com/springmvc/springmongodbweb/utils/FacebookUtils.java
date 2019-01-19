/**
 * 
 */
package com.springmvc.springmongodbweb.utils;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author tuanhiep225
 *
 */
public class FacebookUtils {
	public static String getNameByUid(String uid) {
		
		String url ="https://www.facebook.com/profile.php?id=" + uid;
		
		Connection connect =Jsoup.connect(url).userAgent(
		        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
      try {
		Document doc = connect.get();
		Element element = doc.getElementsByTag("meta").attr("property", "og:title").get(11);
		if(element.hasAttr("content"))
			return element.attr("content");
		return "";
	} catch (IOException e) {
		return "";
	}
	}
}

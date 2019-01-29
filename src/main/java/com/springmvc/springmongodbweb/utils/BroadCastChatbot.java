/**
 * 
 */
package com.springmvc.springmongodbweb.utils;

import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.springmvc.springmongodbweb.models.InformationRequestModel;
import com.springmvc.springmongodbweb.models.User;
import com.springmvc.springmongodbweb.models.UserV2;

/**
 * @author tuanhiep225
 *
 */
public class BroadCastChatbot {

	private static final Log LOGGER = LogFactory.getLog(BroadCastChatbot.class);
	private static Client client;

	public static void sendToBlock(String blockName, InformationRequestModel model, String nguoiduocgioithieu) throws Exception {
		client = ClientHelperUtils.createClient();
		String url = "https://api.chatfuel.com/bots/" + model.getBot_id() + "/users/" + model.getMessid()
				+ "/send?chatfuel_token=" + model.getBot_token() + "&chatfuel_block_name=" + blockName+"&nguoigioithieu="+URLEncoder.encode(nguoiduocgioithieu);
		WebTarget target = client.target(url);
		Response response = target.request().post(Entity.json("{}"));
	}

	public static void sendToBlock(String blockName, User model) throws Exception {
		client = ClientHelperUtils.createClient();
		String phuong = model != null ? model.getPhuong_xa().getName(): "";
		String huyen = model != null ? model.getQuan_huyen().getName(): "";
		String tinh = model != null ? model.getTinh_tp().getName(): "";
		String url = "https://api.chatfuel.com/bots/"+model.getBot_id()+"/users/"+model.getMessenger_user_id()+"/send?chatfuel_token="+model.getBot_token()+"&chatfuel_block_name="+blockName+"&hoten="+URLEncoder.encode(model.getHoten())+"&dienthoai="+model.getSodienthoai()+"&diachi="+URLEncoder.encode(model.getDiachi())+"&phuong_xa="+URLEncoder.encode(phuong) +"&quan_huyen="+URLEncoder.encode(huyen)+"&tinh_tp="+URLEncoder.encode(tinh)+"&validinfor="+ model.getValid();
		WebTarget target = client.target(url);
		Response response = target.request().post(Entity.json("{}"));
	}
	
	public static void sendToBlockNoAtribute(String blockName, UserV2 model) throws Exception {
		client = ClientHelperUtils.createClient();
		String phuong = model != null ? model.getPhuong_xa().getName(): "";
		String huyen = model != null ? model.getQuan_huyen().getName(): "";
		String tinh = model != null ? model.getTinh_tp().getName(): "";
		String url = "https://api.chatfuel.com/bots/"+model.getBot_id()+"/users/"+model.getMessenger_user_id()+"/send?chatfuel_token="+model.getBot_token()+"&chatfuel_block_name="+blockName;
		WebTarget target = client.target(url);
		Response response = target.request().post(Entity.json("{}"));
	}
	
	public static void sendToBlockV2(String blockName, UserV2 model) throws Exception {
		
		client = ClientHelperUtils.createClient();
		String phuong = model != null ? model.getPhuong_xa().getName(): "";
		String huyen = model != null ? model.getQuan_huyen().getName(): "";
		String tinh = model != null ? model.getTinh_tp().getName(): "";
		String url = "https://api.chatfuel.com/bots/"+model.getBot_id()+"/users/"+model.getMessenger_user_id()+"/send?chatfuel_token="+model.getBot_token()+"&chatfuel_block_name="+blockName+"&hoten="+URLEncoder.encode(model.getHoten())+"&dienthoai="+model.getSodienthoai()+"&diachi="+URLEncoder.encode(model.getDiachi())+"&phuong_xa="+URLEncoder.encode(phuong) +"&quan_huyen="+URLEncoder.encode(huyen)+"&tinh_tp="+URLEncoder.encode(tinh)+"&dadienthongtin=true";
		WebTarget target = client.target(url);
		Response response = target.request().post(Entity.json("{}"));
		
		LOGGER.info("sendToBlockV2: "+ model.toString());
	}
}

/**
 * 
 */
package com.springmvc.springmongodbweb.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.springmongodbweb.models.District;
import com.springmvc.springmongodbweb.models.InformationRequestModel;
import com.springmvc.springmongodbweb.models.Province;
import com.springmvc.springmongodbweb.models.ResponseChatfuel;
import com.springmvc.springmongodbweb.models.User;
import com.springmvc.springmongodbweb.models.Ward;
import com.springmvc.springmongodbweb.mysql.models.PhoneMail;
import com.springmvc.springmongodbweb.mysql.repositories.PhoneMailRepository;
import com.springmvc.springmongodbweb.repositories.DistrictRepository;
import com.springmvc.springmongodbweb.repositories.ProvinceRepository;
import com.springmvc.springmongodbweb.repositories.UserRepository;
import com.springmvc.springmongodbweb.repositories.WardRepository;
import com.springmvc.springmongodbweb.service.InformationRequestModelService;
import com.springmvc.springmongodbweb.utils.BroadCastChatbot;

/**
 * @author tuanhiep225
 *
 */
@Controller
@RequestMapping("/api/v1/chatbot")
public class ChatBotController {
	@Autowired
	private InformationRequestModelService service;

	@Autowired
	private ProvinceRepository provinceRepo;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private WardRepository wardRepository;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PhoneMailRepository phonemail;

	// private Client client;
	//
	// public ChatBotController() throws Exception {
	// client = ClientHelperUtils.createClient();
	// }
	private static final Log LOGGER = LogFactory.getLog(ChatBotController.class);

	@GetMapping("/gender")
	@ResponseBody
	public ResponseChatfuel getGender(@RequestParam(value = "gender", required = false) String gender) {
		Map<String, String> resutl_gender = new HashMap<String, String>();
		if ("male".equals(gender)) {
			resutl_gender.put("gioitinh", "anh");
			resutl_gender.put("GioiTinh", "Anh");
		} else if ("female".equals(gender)) {
			resutl_gender.put("gioitinh", "chị");
			resutl_gender.put("GioiTinh", "Chị");
		} else {
			resutl_gender.put("gioitinh", "bạn");
			resutl_gender.put("GioiTinh", "Bạn");
		}
		return ResponseChatfuel.builder().set_attributes(resutl_gender).build();
	}

	@RequestMapping(value = "/request-invite", method = RequestMethod.POST)
	@ResponseBody
	public ResponseChatfuel postObject(InformationRequestModel data) throws Exception {

		String linkgioithieu = "https://" + data.getBot_link() + "?ref=viral" + data.getMessid();
		Map attributes = new HashMap<String, String>();
		data.setLinkgioithieu(linkgioithieu);
		attributes.put("linkgioithieu", linkgioithieu);

		LOGGER.info(data.toString());
		LOGGER.info(linkgioithieu);

		service.add(data);

		String urlLink = "https://" + data.getBot_link() + "?ref=" + data.getRef();
		InformationRequestModel userGioithieu = service.getInformationRequestModelByLinkgioithieu(urlLink);

		if (userGioithieu != null && urlLink.equals(userGioithieu.getLinkgioithieu())) {
			BroadCastChatbot.sendToBlock("CongDiem", userGioithieu, data.getHoten());
		}
		return ResponseChatfuel.builder().set_attributes(attributes).build();
	}

	@RequestMapping("/create")
	public String create(@RequestParam String title, @RequestParam String messenger_user_id,
			@RequestParam String bot_id, @RequestParam String bot_token, @RequestParam String bot_link,
			@RequestParam String goToBlock, @RequestParam String fb_iframe_origin, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("messenger_user_id", messenger_user_id);
		model.addAttribute("bot_id", bot_id);
		model.addAttribute("bot_token", bot_token);
		model.addAttribute("bot_link", bot_link);
		model.addAttribute("goToBlock", goToBlock);
		model.addAttribute("fb_iframe_origin", fb_iframe_origin);
		return "create";
	}

	@PostMapping("/save")
	@ResponseBody
	public User save(@RequestParam String hoten, @RequestParam String dienthoai, @RequestParam String tinh_tp,
			@RequestParam String quan_huyen, @RequestParam String phuong_xa, @RequestParam String diachi,
			@RequestParam String messenger_user_id, @RequestParam String bot_id, @RequestParam String bot_token,
			@RequestParam String bot_link, @RequestParam String goToBlock, @RequestParam String fb_iframe_origin) throws Exception {

		User user = User.builder().hoten(hoten).sodienthoai(dienthoai).tinh_tp(provinceRepo.getByProvinceid(tinh_tp)).quan_huyen(districtRepository.getByDistrictid(quan_huyen))
				.phuong_xa(wardRepository.getByWardid(phuong_xa)).diachi(diachi).messenger_user_id(messenger_user_id).bot_id(bot_id)
				.bot_token(bot_token).bot_link(bot_link).goToBlock(goToBlock).fb_iframe_origin(fb_iframe_origin)
				.build();
		User res = userRepo.add(user);
		
		BroadCastChatbot.sendToBlock(user.getGoToBlock(), res);
		return user;
	}

	@GetMapping("/provinces")
	@ResponseBody
	public Collection<Province> provinces() {
		return provinceRepo.findAll();
	}

	@GetMapping("/districts")
	@ResponseBody
	public Collection<District> districts(@RequestParam String provinceid) {
		return districtRepository.getByProvinceid(provinceid);
	}

	@GetMapping("/wards")
	@ResponseBody
	public Collection<Ward> wards(@RequestParam String districtid) {
		return wardRepository.getByDistrictid(districtid);
	}
	
	@GetMapping("/check-phone")
	@ResponseBody
	public PhoneMail checkPhone(@RequestParam String phone) {
		return phonemail.getByPhone(phone);
	}
	
	@GetMapping("/check-uid")
	@ResponseBody
	public PhoneMail checkUid(@RequestParam String uid) {
		return phonemail.getByUid(uid);
	}
}

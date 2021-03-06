package com.javatpoint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Message;

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	private List<String> response = new ArrayList<>();

	@Autowired
	HttpServletRequest httpServletRequest;

	@PostConstruct
	void init() {
		response.add("test 1");
		response.add("test 2");
		response.add("test 3");
	}

	@GetMapping(value = "/product")
	public List<Product> getProduct() {
		List<Product> products = productService.findAll();
		return products;
	}

	@GetMapping(value = "/response/sms")
	public List<String> getSmsResponse() {
		return response;
	}

	@RequestMapping(value = "/response/sms")
	public String putSmsResponse(Object request) {

	//	System.out.println("Request Data ::" + request);

	//	System.out.println("Req Params :: " + httpServletRequest.getParameterMap().size());

	//	System.out.println("Req Params :: " + new Gson().toJson(httpServletRequest.getParameterMap()));

	//	response.add(new Gson().toJson(request));

		response.add(new Gson().toJson(httpServletRequest.getParameterMap()));

		Message message = new Message.Builder("This is message 1 of 2.").build();
		Message message2 = new Message.Builder("This is message 2 of 2.").build();
		MessagingResponse response1 = new MessagingResponse.Builder().message(message).message(message2).build();

		return "Success";
	}
}

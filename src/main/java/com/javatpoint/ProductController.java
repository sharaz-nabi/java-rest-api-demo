package com.javatpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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

	@PostMapping(value = "/response/sms")
	public List<String> putSmsResponse(@RequestBody Map<String,String> request) {

		System.out.println("Request Data ::" + request);
		
		System.out.println("Req Params :: " + httpServletRequest.getParameterMap().size());
		
		System.out.println("Req Params :: " + new Gson().toJson(httpServletRequest.getParameterMap()));

		response.add(new Gson().toJson(request));
		
		response.add(new Gson().toJson(httpServletRequest.getParameterMap()));

		return response;
	}
}

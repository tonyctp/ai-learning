package com.ss.crdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/hackathon")
public class HealthIndicatorController {

	@ResponseBody
	@RequestMapping("/crdt/hello")
	public String index() {
		return "Hello hackathon!";
	}

}

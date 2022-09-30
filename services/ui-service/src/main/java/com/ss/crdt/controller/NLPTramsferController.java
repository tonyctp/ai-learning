package com.ss.crdt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.crdt.bean.ChatClientBean;
import com.ss.crdt.bean.ChatServerBean;
import com.ss.crdt.service.NLPTransferService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hackathon/crdt")
public class NLPTramsferController {

	@PostMapping(value = "/chat")
	@CrossOrigin
	public ChatClientBean getToken(HttpServletRequest request, @RequestBody ChatClientBean chat) {
		String content = chat.getContent();
		List<String> tagList = NLPTransferService.getOriginalText(content);
		chat.setTags(tagList);
		return chat;
	}
}

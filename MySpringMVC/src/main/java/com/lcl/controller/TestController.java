package com.lcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theServlet")
public class TestController {
	   //����4����������������������������һ��Ҫ����һ��String�����ַ�����Ϊ����ֵ
	    //������ص��ַ�������Ŀ��ҳ���ҳ���ļ�����
	@RequestMapping("/hello")
	public String Hello() {
		return "hello";
	}
	@RequestMapping("/goodbye")
	public String GoodBye() {
		return "bye";
	}
}

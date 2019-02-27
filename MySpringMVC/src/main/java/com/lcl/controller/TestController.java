package com.lcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theServlet")
public class TestController {
	   //步骤4：创建控制器方法，控制器方法一定要返回一个String类型字符串作为返回值
	    //这个返回的字符串就是目标页面的页面文件名称
	@RequestMapping("/hello")
	public String Hello() {
		return "hello";
	}
	@RequestMapping("/goodbye")
	public String GoodBye() {
		return "bye";
	}
}

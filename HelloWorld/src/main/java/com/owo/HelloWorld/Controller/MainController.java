package com.owo.HelloWorld.Controller;
import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owo.HelloWorld.Service.MainService;
import net.sf.json.JSONObject;

@Controller
public class MainController {

	@Inject
	MainService service;
	
	
	@RequestMapping("/")
	public String main() {
		System.out.println("main");
		return "codeAndCanvas";
	}
	
	
	@RequestMapping("/ajax")
	@ResponseBody	//requestbody�ؼ� json���� �����Ÿ� ���⼭ string���� ����ȯ
	public void sendToCanvas(@RequestBody String text,HttpServletResponse response) throws ServletException, IOException {
		System.out.println(text);
		JSONObject jsonobject = new JSONObject();	//json��ü ����
		
		//���⼭ �Լ� �ҷ��� ó���Ѵ����� �ٽ� ����� ���ƿ��� �������
		HashMap<Integer,String> splitcode = service.splitCode(text);
		HashMap<Integer,String> codeall = service.methodSplit(splitcode);
		
		System.out.println(codeall);
		
		/*********************************************/
		
		jsonobject.put("line", "value");
		
		
		
		//json�� map�����̱� ������ Ű�� ���� �ٸ����ָ� �󸶵��� ���� �� ����
		//jsonobject�� �� 1�� ������ ������
		
		
		
		
		
		
		
		System.out.println(jsonobject);
		response.setContentType("application/x-json; charset=UTF-8");
		//������ Ÿ�� �������ְ� (�ѱ�����)
		response.getWriter().print(jsonobject);
		//jsonobject�����ؼ� ������
		
	}
	
}

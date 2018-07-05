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

import com.owo.HelloWorld.Buffer.CoreBuffer;
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
		System.out.println("��Ʈ�� �κ�"+text);
		JSONObject object = new JSONObject();	//json��ü ����
		
		//���⼭ �Լ� �ҷ��� ó���Ѵ����� �ٽ� ����� ���ƿ��� �������
		
		
		HashMap<Integer,String> splitcode = service.splitCode(text);
		//���⼭ �ϴ� �޾ƿ� String�� ���ø�����
		CoreBuffer corebuffer = service.allRead(splitcode);
		//���ø��� �ڵ带 �Ѱ��ְ� �ű⼭ ��ü ���� ���⼭ �۾��� ��������
		//���⼭ �ھ���۰� ��ȯ��
		
		
		
		HashMap<Integer,String> codeall = service.methodSplit(splitcode);
		
		System.out.println(codeall);
		
		
		/*********************************************/
		JSONObject code = JSONObject.fromObject(splitcode); 
		
		object.put("line", code);
		//object.put("core", corebuffer);
		//�̷��� ������ �ȵǰų� ������ �� �����ϱ� �ھ���۾ȿ��ִ� �ؽ�����ü�� json���� ���� ������
		
		
		//json�� map�����̱� ������ Ű�� ���� �ٸ����ָ� �󸶵��� ���� �� ����
		//jsonobject�� �� 1�� ������ ������
		
		
		
		
		
		
		
		System.out.println(code);
		response.setContentType("application/x-json; charset=UTF-8");
		//������ Ÿ�� �������ְ� (�ѱ�����)
		response.getWriter().print(object);
		//jsonobject�����ؼ� ������
		
	}
	
}

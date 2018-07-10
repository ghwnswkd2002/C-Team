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
		JSONObject jobject = new JSONObject();	//json��ü ����
		
		//���⼭ �Լ� �ҷ��� ó���Ѵ����� �ٽ� ����� ���ƿ��� �������
		
		
		System.out.println("���ø� �ڵ� ��");
		HashMap<String,String> splitcode = service.splitCode(text);
		System.out.println("���ø� �ڵ� ����");
		//���⼭ �ϴ� �޾ƿ� String�� ���ø�����
		System.out.println("���� �б�� ��");
		
		
		CoreBuffer corebuffer = new CoreBuffer();
		corebuffer = service.allRead(splitcode);
		System.out.println("���� �б� ����");
		//���ø��� �ڵ带 �Ѱ��ְ� �ű⼭ ��ü ���� ���⼭ �۾��� ��������
		//���⼭ �ھ���۰� ��ȯ��
		
		
		//System.out.println("�޼ҵ彺�ø� ��");
		HashMap<String,String> codeall = service.methodSplit(splitcode);
		//System.out.println("�޼ҵ� ���ø� ����");
		
		System.out.println("codeall ���"+codeall);		//�ӽø��Ƶ�
		
		
		/*********************************************/
		
		//System.out.println("hashmap->JSONObject �ٲ�");
		//JSONObject code = JSONObject.fromObject(splitcode);  //��ø���
		//hashmap�� json
		System.out.println("�ٲ����?");
		System.out.println(corebuffer.getParam().get("1line"));
		System.out.println(corebuffer.getParam());
		//JSONObject paramjson = new JSONObject();
		jobject.put("keys", corebuffer);
		
		//jobject.put("paramjson", paramjson);
		//jobject.put("corebuffer", corebuffer);
		//object.put("core", corebuffer);
		//�̷��� ������ �ȵǰų� ������ �� �����ϱ� �ھ���۾ȿ��ִ� �ؽ�����ü�� json���� ���� ������
		System.out.println("�ھ���� ��´� ���³�����"+ jobject);
		
		
		//json�� map�����̱� ������ Ű�� ���� �ٸ����ָ� �󸶵��� ���� �� ����
		//jsonobject�� �� 1�� ������ ������
		
		
		
		
		
		
		
		System.out.println(jobject);
		response.setContentType("application/x-json; charset=UTF-8");
		//������ Ÿ�� �������ְ� (�ѱ�����)
		response.getWriter().print(jobject);
		//jsonobject�����ؼ� ������
		
	}
	
}

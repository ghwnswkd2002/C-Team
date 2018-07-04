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
	@ResponseBody	//requestbody해서 json으로 받은거를 여기서 string으로 형변환
	public void sendToCanvas(@RequestBody String text,HttpServletResponse response) throws ServletException, IOException {
		System.out.println(text);
		JSONObject jsonobject = new JSONObject();	//json객체 생성
		
		//여기서 함수 불러서 처리한다음에 다시 여기로 돌아오게 만들어줌
		HashMap<Integer,String> splitcode = service.splitCode(text);
		HashMap<Integer,String> codeall = service.methodSplit(splitcode);
		
		System.out.println(codeall);
		
		/*********************************************/
		
		jsonobject.put("line", "value");
		
		
		
		//json이 map형식이기 때문에 키와 값만 다르게주면 얼마든지 넣을 수 있음
		//jsonobject는 단 1번 전송이 가능함
		
		
		
		
		
		
		
		System.out.println(jsonobject);
		response.setContentType("application/x-json; charset=UTF-8");
		//컨텐츠 타입 지정해주고 (한글전송)
		response.getWriter().print(jsonobject);
		//jsonobject주입해서 보내기
		
	}
	
}

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
	@ResponseBody	//requestbody해서 json으로 받은거를 여기서 string으로 형변환
	public void sendToCanvas(@RequestBody String text,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤 부분"+text);
		JSONObject object = new JSONObject();	//json객체 생성
		
		//여기서 함수 불러서 처리한다음에 다시 여기로 돌아오게 만들어줌
		
		
		System.out.println("스플릿 코드 들어감");
		HashMap<String,String> splitcode = service.splitCode(text);
		System.out.println("스플릿 코드 나옴");
		//여기서 일단 받아온 String을 스플릿해줌
		System.out.println("전부 읽기로 들어감");
		CoreBuffer corebuffer = service.allRead(splitcode);
		System.out.println("전부 읽기 나옴");
		//스플릿한 코드를 넘겨주고 거기서 객체 얻어옴 여기서 작업이 많아질듯
		//여기서 코어버퍼가 반환됨
		
		
		System.out.println("메소드스플릿 들어감");
		HashMap<String,String> codeall = service.methodSplit(splitcode);
		System.out.println("메소드 스플릿 나옴");
		
		System.out.println("codeall 찍기"+codeall);
		
		
		/*********************************************/
		
		System.out.println("hashmap->JSONObject 바꿈");
		JSONObject code = JSONObject.fromObject(splitcode); 
		//hashmap을 json
		System.out.println("바뀌었나?");
		object.put("line", code);
		//object.put("core", corebuffer);
		//이렇게 보내면 안되거나 불편할 수 있으니까 코어버퍼안에있는 해쉬맵자체를 json으로 만들어서 보내기
		
		
		//json이 map형식이기 때문에 키와 값만 다르게주면 얼마든지 넣을 수 있음
		//jsonobject는 단 1번 전송이 가능함
		
		
		
		
		
		
		
		System.out.println(object);
		response.setContentType("application/x-json; charset=UTF-8");
		//컨텐츠 타입 지정해주고 (한글전송)
		response.getWriter().print(object);
		//jsonobject주입해서 보내기
		
	}
	
}

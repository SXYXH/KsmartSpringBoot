package ksmart.springboot.member.controller;

import ksmart.springboot.exam.dto.Member;
import ksmart.springboot.exam.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MemberController {

    private final ExamService examService;

    public MemberController(ExamService examService) {
        this.examService = examService;
    }
    @GetMapping("/member/list")
    public List<Member> memberList() {
        return examService.getMemberList();
    }

    /**
     *    @PathVariable : 주소 맵핑시 { 바인딩 받을 키 }
     *    핸들러 메소드에 매개변수의 @PathVariable(name="바인딩 받을 키")  데이터타입 변수명
     *    @RestController = @Controller + @responseBody
     */
    @GetMapping("/member/{memberId}")
    public Member getMemberInfoById(@PathVariable(name="memberId")String memberId){
        return examService.getMemberbyId(memberId);
    }
}

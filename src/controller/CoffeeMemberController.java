package controller;

import javax.swing.JOptionPane;

import dto.CoffeeMemberDto;
import service.CoffeeMemberService;
import service.CoffeeMemberServiceImpl;
import view.LoginView;
import view.OrderView;
import view.SignUpView;

public class CoffeeMemberController {
	CoffeeMemberService cfMemberServ = new CoffeeMemberServiceImpl();
	
	public void login() {
		new LoginView();
	}
	public void signUp() {
		new SignUpView();
	}
	public void order() {
		new OrderView();
	}
	
	public boolean loginCheck(String id, String pwd) {
		
		if(id == null || id.equals("")) {
			JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
			return false;
		}
		if(pwd == null || pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "PW를 입력해주세요.");
			return false;
		}
		
		CoffeeMemberDto memberDto = cfMemberServ.login(id, pwd);
		
		if(memberDto == null) {
			//로그인 실패
			JOptionPane.showMessageDialog(null, "id나 패스워드가 틀렸습니다.");
			return false;
		}else {
			//로그인 성공
			JOptionPane.showMessageDialog(null, memberDto.getName() + "님. 환영합니다.");
			order();
			return true;
		}
	}
	
	public boolean regiMember(String id, String pwd, String name, String email)  {
		if(id == null || id.equals("")) {
			JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
			return false;
		}
		if(pwd == null || pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "PW를 입력해주세요.");
			return false;
		}
		if(name == null || name.equals("")) {
			JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
			return false;
		}
		if(email == null || email.equals("")) {
			JOptionPane.showMessageDialog(null, "PW를 입력해주세요.");
			return false;
		}
		
		boolean result = cfMemberServ.regiMember(new CoffeeMemberDto(id, pwd, name, email));
		
		if(result) {
			//회원가입 성공
			JOptionPane.showMessageDialog(null, "회원가입이 성공적으로 진행되었습니다.");
			login();
		}else {
			//회원가입 실패
			JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다. 다른 ID를 이용해주세요.");
		}

		return result;
	}
	
	
	
}

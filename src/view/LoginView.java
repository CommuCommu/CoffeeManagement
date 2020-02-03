package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import singleton.Singleton;

public class LoginView extends JFrame{
	private JLabel idL , pwdL;
	private JButton signUpBtn, loginBtn;
	private JTextField idTf;
	private JPasswordField pwdTf;
	
	public LoginView() {
		//리스너 선언
		ActionListener loginListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//로그인
				Singleton s = Singleton.getInstance();
				
				String pwd = "";
				
				char[] secret_pwd = pwdTf.getPassword(); 
				for(char cha : secret_pwd) { 
					pwd += cha;
				}

				boolean result = s.cfMemberC.loginCheck(idTf.getText(), pwd);
				
				if(result) {
					dispose();
				}else {
					
				}
			}
		};
		
		ActionListener signUpListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입
				Singleton s = Singleton.getInstance();
				s.cfMemberC.signUp();
				dispose();
			}
		};
		
		
		//라벨
		idL = new JLabel("ID");
		idL.setBounds(20, 20, 50, 30);

		pwdL = new JLabel("PW");
		pwdL.setBounds(20, 50, 50, 30);

		//텍스트 필드
		idTf = new JTextField("");
		idTf.setBounds(50, 20, 140, 30);

		pwdTf = new JPasswordField("");
		pwdTf.setBounds(50, 50, 140, 30);
		pwdTf.setEchoChar('*');

		//버튼
		loginBtn = new JButton("Login");
		loginBtn.setBounds(200, 20, 80, 60);
		loginBtn.addActionListener(loginListener);

		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(20, 90, 260, 40);
		signUpBtn.addActionListener(signUpListener);

		//추가
		add(idL);
		add(pwdL);
		add(idTf);
		add(pwdTf);
		add(loginBtn);
		add(signUpBtn);
		
		//기본 세팅
		setTitle("로그인");
		setLayout(null);
		setBounds(120, 120, 320, 180);
		setVisible(true);
	}

}

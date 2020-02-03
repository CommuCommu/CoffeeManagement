package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import singleton.Singleton;

public class SignUpView extends JFrame{
	private JLabel idL, pwdL, nameL, emailL;
	private JButton backBtn, signUpBtn;
	private JTextField idTf, nameTf, emailTf, pwdTf;
	
	public SignUpView() {
		//리스너 선언
		ActionListener BackListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//뒤로가기
				Singleton s = Singleton.getInstance();
				s.cfMemberC.login();
				dispose();
			}
		};
		
		ActionListener SignUpListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//회원가입 시도
				Singleton s = Singleton.getInstance();
				boolean result = s.cfMemberC.regiMember(idTf.getText(), pwdTf.getText(), nameTf.getText(), emailTf.getText());
				
				if(result) {
					dispose();
				}else {
					
				}
			}
		};
		
		
		//라벨
		idL = new JLabel("ID");
		idL.setBounds(20, 20, 50, 30);

		pwdL = new JLabel("PW");
		pwdL.setBounds(20, 50, 50, 30);
		
		nameL = new JLabel("Name");
		nameL.setBounds(20, 80, 50, 30);
		
		emailL = new JLabel("E-Mail");
		emailL.setBounds(20, 110, 50, 30);

		//텍스트 필드
		idTf = new JTextField("");
		idTf.setBounds(60, 20, 220, 30);

		pwdTf = new JTextField("");
		pwdTf.setBounds(60, 50, 220, 30);
		
		nameTf = new JTextField();
		nameTf.setBounds(60, 80, 220, 30);
		
		emailTf = new JTextField();
		emailTf.setBounds(60, 110, 220, 30);

		//버튼
		backBtn = new JButton("Back");
		backBtn.setBounds(20, 150, 120, 40);
		backBtn.addActionListener(BackListener);

		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(160, 150, 120, 40);
		signUpBtn.addActionListener(SignUpListener);

		//추가
		add(idL);
		add(pwdL);
		add(nameL);
		add(emailL);
		
		add(idTf);
		add(pwdTf);
		add(nameTf);
		add(emailTf);
		
		add(backBtn);
		add(signUpBtn);
		
		//기본 세팅
		setTitle("회원가입");
		setLayout(null);
		setBounds(120, 120, 320, 240);
		setVisible(true);
	}
	
}

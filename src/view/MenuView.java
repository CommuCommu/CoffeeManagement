package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MenuView extends JFrame {
	private JFrame menuJf;
	private JPanel menuJp;
	private String[] menuList = {"헤이즐넛 카라멜 모카",
			 "카라멜 마끼아또",
			 "화이트 초콜릿 모카",
			 "카라멜 모카",
			 "카페 모카",
			 "카라멜 라떼",
			 "카페 라떼",
			 "카푸치노",
			 "아메리카노",
			 "오늘의 커피"};
	private int[] menuPrice = {4800, 4300, 4300, 4300, 3800, 3800, 3300, 3300, 2800, 2500}; //위 메뉴 순서대로의 short 가격임.
	
	public MenuView() {

		menuJp = new JPanel();
		
		menuJp.setBorder(new TitledBorder(new LineBorder(Color.gray,2),"가격표"));
		menuJp.setLayout(new GridLayout(0,4,10,0));
		menuJp.setBounds(30, 20, 590, 390);
		
		menuJp.add(new JLabel("Espresso Beverages"));
		menuJp.add(new JLabel("Short"));
		menuJp.add(new JLabel("Tall"));
		menuJp.add(new JLabel("Grande"));
		
		
		for(int i = 0; i < menuPrice.length; i++) {
			menuJp.add(new JLabel(menuList[i]));
			menuJp.add(new JLabel(menuPrice[i] + ""));
			menuJp.add(new JLabel((menuPrice[i] + 500) + ""));
			menuJp.add(new JLabel((menuPrice[i] + 1000) + ""));
		}
		
		menuJf = new JFrame("메뉴판");
		menuJf.add(menuJp);
		
		//기본 세팅
		menuJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuJf.setBounds(120, 120, 640, 450);
		menuJf.setVisible(true);
	}
}

package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import singleton.Singleton;

public class OrderView extends JFrame {
	private JPanel sizeJp, syrupJp, plusJp;
	
	private ButtonGroup sizeGroup, syrupGroup;
	
	private JRadioButton shortRb, tailRb, greadeRb;
	private JRadioButton vanillaRb, caramelRb, hazelnutRb;
	private JCheckBox shotCb, creamCb;
	
	private JLabel countL;
	private JButton orderBtn, menuBtn, orderListBtn, orderedListBtn;
	private JTextField countTf;
	
	private JComboBox selectMenuComboBox;
	
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
	
	public OrderView() {
		
		//리스너 선언
		ActionListener orderListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//주문을 넣을때.
				String name = (String)selectMenuComboBox.getSelectedItem();
				String syrup = "";
				String orderSize = "";
				int shot = shotCb.isSelected() ? 1 : 0;
				int cream = creamCb.isSelected() ? 1 : 0;
				int orderCount = -1;	//초기값.
				int price;

				price = menuPrice[selectMenuComboBox.getSelectedIndex()];

				if(shortRb.isSelected()) {
					orderSize = "Short";
				}else if(tailRb.isSelected()) {
					orderSize = "Tall";
					price += 500;
				}else if(greadeRb.isSelected()) {
					orderSize = "Grande";
					price += 1000;
				}else {}
				
				if(vanillaRb.isSelected())
					syrup = "바닐라";
				if(caramelRb.isSelected())
					syrup = "카라멜";
				if(hazelnutRb.isSelected())
					syrup = "헤이즐넛";
					
				try {
					orderCount = Integer.parseInt(countTf.getText());
					price = price * orderCount;
				}catch (Exception ee) {
					ee.printStackTrace();
				}
				
				Singleton s = Singleton.getInstance();
				s.cfOrderC.orderCoffee(name, syrup, orderSize, shot, cream, orderCount, price);
			}
		};
		
		ActionListener menuListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//메뉴를 볼때
				Singleton s = Singleton.getInstance();
				s.cfOrderC.menu();
			}
		};
		
		ActionListener orderListListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//주문내역 (카운터입장) 볼때.
				Singleton s = Singleton.getInstance();
				s.cfOrderC.orderList();
			}
		};
		ActionListener orderedListListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//주문내역 (손님입장) 볼때.
				Singleton s = Singleton.getInstance();
				s.cfOrderC.orderedList();
			}
		};
		
		
		//패널 생성
		sizeJp = new JPanel();
		sizeJp.setBorder(new TitledBorder(new LineBorder(Color.gray,2),"사이즈"));
		sizeJp.setLayout(new GridLayout(3,1));
		sizeJp.setBounds(40, 100, 100, 150);

		syrupJp = new JPanel();
		syrupJp.setBorder(new TitledBorder(new LineBorder(Color.gray,2),"시럽"));
		syrupJp.setLayout(new GridLayout(3,1));
		syrupJp.setBounds(160, 100, 100, 150);
		
		plusJp = new JPanel();
		plusJp.setBorder(new TitledBorder(new LineBorder(Color.gray,2),"추가"));
		plusJp.setLayout(new GridLayout(2,1));
		plusJp.setBounds(280, 100, 100, 150);
		
		//버튼 그룹 생성
		sizeGroup = new ButtonGroup();
		syrupGroup = new ButtonGroup();
		
		//라디오 버튼 생성
		shortRb = new JRadioButton("Short");
		sizeGroup.add(shortRb);
		sizeJp.add(shortRb);
		shortRb.setSelected(true);//초기값
		
		tailRb = new JRadioButton("Tail");
		sizeGroup.add(tailRb);
		sizeJp.add(tailRb);
		
		greadeRb = new JRadioButton("Greade");
		sizeGroup.add(greadeRb);
		sizeJp.add(greadeRb);
		
		vanillaRb = new JRadioButton("바닐라");
		syrupGroup.add(vanillaRb);
		syrupJp.add(vanillaRb);
		vanillaRb.setSelected(true);//초기값
		
		caramelRb = new JRadioButton("카라멜");
		syrupGroup.add(caramelRb);
		syrupJp.add(caramelRb);
		
		hazelnutRb = new JRadioButton("헤이즐넛");
		syrupGroup.add(hazelnutRb);
		syrupJp.add(hazelnutRb);
		
		//체크 버튼 생성
		shotCb = new JCheckBox("샷 추가");
		plusJp.add(shotCb);
		
		creamCb = new JCheckBox("휘핑 크림");
		plusJp.add(creamCb);
		
		//콤보 박스 생성
		selectMenuComboBox = new JComboBox(menuList);
		selectMenuComboBox.setBounds(40, 50, 340, 30);
		
		//텍스트 필드
		countTf = new JTextField("");
		countTf.setBounds(40, 300, 50, 30);
		
		//라벨
		countL = new JLabel("잔");
		countL.setBounds(90, 300, 30, 30);
		
		//버튼
		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(120, 290, 100, 50);
		orderBtn.addActionListener(orderListener);

		menuBtn = new JButton("메뉴보기");
		menuBtn.setBounds(290, 10, 100, 30);
		menuBtn.addActionListener(menuListener);
		
		orderListBtn = new JButton("주문내역");
		orderListBtn.setBounds(10, 10, 100, 30);
		orderListBtn.addActionListener(orderListListener);
		
		orderedListBtn = new JButton("주문한 내역");
		orderedListBtn.setBounds(120, 10, 120, 30);
		orderedListBtn.addActionListener(orderedListListener);
		
		//추가
		add(countL);
		
		add(countTf);
		
		add(orderBtn);
		add(menuBtn);
		add(orderListBtn);
		add(orderedListBtn);
				
		add(sizeJp);
		add(syrupJp);
		add(plusJp);
		
		add(selectMenuComboBox);
		
		//기본 세팅
		setTitle("주문하기");
		setLayout(null);
		setBounds(120, 120, 420, 400);
		setVisible(true);
	}
}

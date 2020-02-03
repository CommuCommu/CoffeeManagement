package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.CoffeeOrderListDto;


public class OrderListView extends JFrame {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	String columnNames[] = {"Espresso Beverages", "시럽", "크기", "샷추가", "휘핑크림", "잔", "총액"	};
	
	Object rowData[][];
	DefaultTableModel model;	// table의 넓이를 설정
	
	public OrderListView(List<CoffeeOrderListDto> list) {
		super("주문 내역");
		
		// jtable row를 생성
		rowData = new Object[list.size()][7];
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			CoffeeOrderListDto dto = list.get(i);
			
			rowData[i][0] = dto.getName(); // 메뉴 이름
			rowData[i][1] = dto.getSyrup();	// 시럽
			rowData[i][2] = dto.getOrdersize();	// 크기
			rowData[i][3] = dto.getShot() == 0 ? "추가 안함" : "추가";	// 샷추가
			rowData[i][4] = dto.getCream() == 0 ? "추가 안함" : "추가";	// 휘핑크림
			rowData[i][5] = dto.getOrdercount();	// 잔
			rowData[i][6] = dto.getPrice();	// 총액
			
		}

		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int i, int c) {	//더블클릭을 금지하는 코드.
				return false;
			}
		};
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(200);	// 메뉴이름
		jtable.getColumnModel().getColumn(1).setMaxWidth(50);	// 시럽
		jtable.getColumnModel().getColumn(2).setMaxWidth(100);	// 크기
		jtable.getColumnModel().getColumn(3).setMaxWidth(100);	// 샷추가
		jtable.getColumnModel().getColumn(4).setMaxWidth(100);	// 휘핑크림
		jtable.getColumnModel().getColumn(5).setMaxWidth(50);	// 잔
		jtable.getColumnModel().getColumn(6).setMaxWidth(100);	// 총액
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 10, 650, 400);
		add(jscrPane);

		setBounds(120, 120, 700, 470);
		setLayout(null);
		setVisible(true);
	}
}

package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dto.CoffeeMemberDto;
import dto.CoffeeOrderListDto;
import service.CoffeeOrderListService;
import service.CoffeeOrderListServiceImpl;
import view.MenuView;
import view.OrderListView;
import view.OrderedListView;

public class CoffeeOrderListController {
	CoffeeOrderListService cfOrderServ = new CoffeeOrderListServiceImpl();
	
	public void menu() {
		new MenuView();
	}
	
	public void orderList() {
		//주문 내역
		List<CoffeeOrderListDto> list = cfOrderServ.getOrderList();
		new OrderListView(list);
	}
	
	public void orderedList() {
		//주문 한 내역
		List<CoffeeOrderListDto> list = cfOrderServ.getOrderList();
		new OrderedListView(list);
	}
	
	public void orderCoffee(String name, String syrup, String orderSize, int shot, int cream, int orderCount, int price) {
		//주문을 데이터베이스에 넣기.
		if(orderCount == -1) {
			JOptionPane.showMessageDialog(null, "주문 수량 부분을 다시 확인해주세요.");
			return;
		}
		
		boolean result = cfOrderServ.orderCoffee(new CoffeeOrderListDto(name, syrup, orderSize, shot, cream, orderCount, price, ""));
		
		if(result) {
			//주문 성공
			JOptionPane.showMessageDialog(null, "주문이 성공적으로 진행되었습니다.");
		}else {
			//주문 실패
			JOptionPane.showMessageDialog(null, "에러로 인해 주문이 실패했습니다.");
		}
		
	}
}

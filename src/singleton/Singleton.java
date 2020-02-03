package singleton;

import controller.CoffeeMemberController;
import controller.CoffeeOrderListController;

public class Singleton {
	private static Singleton s = null;
	
	//컨트롤러 모음
	public CoffeeMemberController cfMemberC = null;
	public CoffeeOrderListController cfOrderC = null;
	
	
	private Singleton() {
		cfMemberC = new CoffeeMemberController();
		cfOrderC = new CoffeeOrderListController();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton(); 
		}
		return s;
	}
}

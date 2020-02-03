package service;

import java.util.List;

import dao.CoffeeOrderListDao;
import dao.CoffeeOrderListDaoImpl;
import dto.CoffeeOrderListDto;

public class CoffeeOrderListServiceImpl implements CoffeeOrderListService {
	CoffeeOrderListDao orderListDao = new CoffeeOrderListDaoImpl();
	@Override
	public boolean orderCoffee(CoffeeOrderListDto cfdto) {
		return orderListDao.orderCoffee(cfdto);
	}
	@Override
	public List<CoffeeOrderListDto> getOrderList() {
		return orderListDao.getOrderList();
	}

}

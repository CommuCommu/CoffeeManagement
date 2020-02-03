package service;

import java.util.List;

import dto.CoffeeOrderListDto;

public interface CoffeeOrderListService {
	public boolean orderCoffee(CoffeeOrderListDto cfdto);
	public List<CoffeeOrderListDto> getOrderList();
}

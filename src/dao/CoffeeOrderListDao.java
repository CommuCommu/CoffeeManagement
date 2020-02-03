package dao;

import java.util.List;

import dto.CoffeeOrderListDto;

public interface CoffeeOrderListDao {
	public boolean orderCoffee(CoffeeOrderListDto dto);
	public List<CoffeeOrderListDto> getOrderList();
}

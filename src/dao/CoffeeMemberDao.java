package dao;

import dto.CoffeeMemberDto;

public interface CoffeeMemberDao {
	public CoffeeMemberDto login(String id, String pwd);
	public boolean regiMember (CoffeeMemberDto dto);
}

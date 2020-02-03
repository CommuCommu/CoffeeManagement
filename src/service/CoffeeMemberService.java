package service;

import dto.CoffeeMemberDto;

public interface CoffeeMemberService {
	public CoffeeMemberDto login(String id, String pwd);
	public boolean regiMember(CoffeeMemberDto dto);
}

package service;

import dao.CoffeeMemberDao;
import dao.CoffeeMemberDaoImpl;
import dto.CoffeeMemberDto;

public class CoffeeMemberServiceImpl implements CoffeeMemberService{
	CoffeeMemberDao memberDao = new CoffeeMemberDaoImpl();
	
	@Override
	public CoffeeMemberDto login(String id, String pwd) {
		return memberDao.login(id, pwd);
	}


	@Override
	public boolean regiMember(CoffeeMemberDto dto) {
		return memberDao.regiMember(dto);
	}

}

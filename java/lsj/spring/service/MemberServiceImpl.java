package lsj.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsj.spring.dao.MemberDAO;
import lsj.spring.vo.Member;

@Service("msrv")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public int newMember(Member mb) {
		
		
		
		return mdao.insertMember(mb);
	}
	
	@Override
	public int loginMember(Member mb) {
		return mdao.loginMember(mb);
	}

	@Override
	public Member readOneMember(String mno) {
		
		
		
		return mdao.selectOneMember(mno);
	}

}

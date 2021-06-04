package lsj.spring.dao;

import java.util.List;

import lsj.spring.vo.Member;

public interface MemberDAO {

	int insertMember(Member mb);

	int loginMember(Member mb);
	
	Member selectOneMember(String mno);


}

package lsj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lsj.spring.vo.Member;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public int insertMember(Member mb) {
		
		return sqlSession.insert("member.insertMember", mb);
	}
	
	@Override
	public int loginMember(Member mb) {
		return sqlSession.selectOne("member.loginMember", mb);
	}
	

	@Override
	public Member selectOneMember(String userid) {
		return sqlSession.selectOne("member.selectOneMember",userid);
	}
	

}

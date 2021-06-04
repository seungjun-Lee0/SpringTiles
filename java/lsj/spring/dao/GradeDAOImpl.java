package lsj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lsj.spring.vo.Grade;

@Repository("gdao")
public class GradeDAOImpl implements GradeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertGrade(Grade gd) {
		
		return sqlSession.insert("grade.insertGrade",gd);
	}

	@Override
	public List<Grade> selectAllGrade() {
		
		return sqlSession.selectList("grade.selectGrade");
	}

	@Override
	public Grade selectOneGrade(int gno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGrade(Grade gd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeGrade(int gno) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

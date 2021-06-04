package lsj.spring.dao;


import java.util.List;

import lsj.spring.vo.Grade;

public interface GradeDAO {
	int insertGrade(Grade gd);

	List<Grade> selectAllGrade();

	Grade selectOneGrade(int gno);

	int updateGrade(Grade gd);

	int removeGrade(int gno);
}

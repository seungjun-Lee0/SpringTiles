package lsj.spring.service;

import java.util.List;

import lsj.spring.vo.Grade;

public interface GradeService {
	int newGrade(Grade gd);
	
	
	List<Grade> readAllGrade();

	Grade readOneGrade(int gno);

	int modifyGrade();

	int removeGrade();

	void computeGrade(Grade gd);
}

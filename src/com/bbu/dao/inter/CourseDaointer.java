package com.bbu.dao.inter;

import java.util.ArrayList;

import com.bbu.model.CourseBean;

public interface CourseDaointer {
	//addcourse
	public boolean addCourse(CourseBean nn);
	//deleteCourse
	public boolean deleteCourse(String id);
	//getAllcourse
	public ArrayList<CourseBean> getAllcourse();
}

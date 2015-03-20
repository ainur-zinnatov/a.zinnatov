package ru.kpfu.itis.group403.zinnatov.textTable;

import java.util.Comparator;

/**
 * Created by hp on 20.03.2015.
 */
public class StudentModelProvider implements ModelProvider<Student> {
	Student[] students;

	public StudentModelProvider(Student[] students) {
		this.students = students;
	}

	@Override
	public Student[] getModel() {
		return students;
	}

	@Override
	public Comparator<Student> getComporator() {
		return Student.StudentHelper.getNameComparator();
	}
}

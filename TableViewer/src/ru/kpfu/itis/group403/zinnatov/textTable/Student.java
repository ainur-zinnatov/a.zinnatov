package ru.kpfu.itis.group403.zinnatov.textTable;

import java.util.Comparator;

public class Student {
	private int  grade;
	private int  year;
	private String  name;

	public Student(String name, int year, int grade) {
		this.grade = grade;
		this.year = year;
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
	return "%";
	}

	protected static class StudentHelper {

		public static Comparator<Student> getGradeComparator() {

			return (o1, o2) -> {
				if(o1 != null && o2 != null) {
					return o2.getGrade() - o1.getGrade();
				}
				return -1;
			};
		}


		public static Comparator<Student> getNameComparator() {

			return (o1, o2) -> {
					if(o1 != null && o2 != null) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
					return -1;
				};

		}

		public static Comparator<Student> getYearComparator() {

			return  (o1,  o2) -> {
					if(o1 != null && o2 != null) {
						return o2.getYear() - o1.getYear();
					}
					return -1;

				};
		}
	}

}

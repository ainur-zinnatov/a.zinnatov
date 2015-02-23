package ru.kpfu.itis.group403.zinnatov.stud;
import java.util.Comparator;
/**
 * Created by hp on 23.02.2015.
 */
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
		return "Student{" +
				"grade=" + grade +
				", year=" + year +
				", name='" + name + '\'' +
				'}';
	}


	protected static class StudentHelper {

		public static Comparator<Student> getGradeComparator() {

			return new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o2.getGrade() - o1.getGrade();
				}
			};
		}


		public static Comparator<Student> getNameComparator() {

			return new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {

					return o1.getName().compareToIgnoreCase(o2.getName());

				}

			};

		}

		public static Comparator<Student> getYearComparator() {

			return new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {

					return o2.getYear()-o1.getYear();

				}

			};

		}
	}

}

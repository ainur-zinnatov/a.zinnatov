package ru.kpfu.itis.group403.zinnatov.stud;
import  java.util.Arrays;
/**
 * Created by hp on 23.02.2015.
 */
public class Main {
	public static void main(String[] args) {

		Student students[] = new Student[15];

		students[0]=new Student("Ainur Zinnatov",18,4);
		students[1]=new Student("Ramil Safin",18,5);
		students[2]=new Student("Iliya Vlasov",18,5);
		students[3]=new Student("Lia Sharipova",19,4);
		students[4]=new Student("Marat Abdullin",18,5);
		students[5]=new Student("Ramis Shakirov",19,4);
		students[6]=new Student("Ilgiz Husaenov",19,4);
		students[7]=new Student("Leonid Yuskevich",18,5);
		students[8]=new Student("Adelya Ahmerova",18,3);
		students[9]=new Student("Artur Arifullin",19,4);
		students[10]=new Student("Renat Yusupov",18,3);
		students[11]=new Student("Bulat Tazetdinov",19,3);
		students[12]=new Student("Stanislav Salnikov",18,2);
		students[13]=new Student("group403",1,5);
		students[14]=new Student("ITIS",4,5);


		System.out.println("Sort by grade");
		Arrays.sort(students, Student.StudentHelper.getGradeComparator());
		for (Student student : students) {

			System.out.println(student);

		}


		System.out.println("Sort by name");
		Arrays.sort(students, Student.StudentHelper.getNameComparator());
		for (Student student : students) {

			System.out.println(student);

		}

		System.out.println("Sort by year");
		Arrays.sort(students, Student.StudentHelper.getYearComparator());
		for (Student student : students) {

			System.out.println(student);

		}
	}

}

package ru.kpfu.itis.group403.zinnatov.para;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Faculty {

	private Student[] students;

	public Faculty(Student[] students) {

		this.students = students;
	}

	public Student [] getStudents(){
		List<Integer> flags = new ArrayList<Integer>();
		Random rnd = new Random();
		int random = rnd.nextInt(students.length-1)+1;
		//создали массив студентов размерности рандом
		Student [] randomStudents = new Student[random];

		//заполняем список студентов для посылки на клинику рандомно
		for (int i = 0; i < randomStudents.length; i++) {
			random = rnd.nextInt(students.length);
			if (!flags.contains(random)) {
				flags.add(random);
				randomStudents[i] = students[random];
			}else {
				while (flags.contains(random)){
					random = rnd.nextInt(students.length);
				}
				flags.add(random);
				randomStudents[i] = students[random];
			}
		}
		return randomStudents;
	}
	}




package ru.kpfu.itis.group403.zinnatov.para;

public class Main {

    public static void main(String[] args) {



			    //1 -ый факультет со студентами
			    Student [] students = new Student[]{
					    new Student("1_Student_1", 19),
					    new Student("1_Student_2",10),
					    new Student("1_Student_3",20),
					    new Student("1_Student_4",16),
					    new Student("1_Student_5",34),
			    };
			    Student [] students2 = new Student[]{
					    new Student("2_Student_1", 19),
					    new Student("2_Student_2",10),
					    new Student("2_Student_3",20),
					    new Student("2_Student_4",16),
					    new Student("2_Student_5",34),
			    };
			    //факультеты
			    Faculty [] faculties = new Faculty[]{
					    new Faculty(students),
					    new Faculty(students2)
			    };

			    Clinic clinic = new Clinic(faculties);


			    clinic.registration(students.length + students2.length);

			    clinic.outputQueueOfStudents();






	}
}

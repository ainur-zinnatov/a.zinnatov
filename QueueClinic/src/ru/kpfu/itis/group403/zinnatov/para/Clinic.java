package ru.kpfu.itis.group403.zinnatov.para;


public class Clinic {
	private  Faculty[] faculties;
	private MyQueueClass<Student> queueOfStudents;
	public Clinic(Faculty[] faculties) {

		this.faculties = faculties;
	}



	public void registration(int size){
		queueOfStudents = new MyQueueClass<Student>(size);
		for (Faculty val : faculties){
			for (Student student : val.getStudents()){
				queueOfStudents.offer(student);
			}
		}
	}


	public void outputQueueOfStudents(){
		while (queueOfStudents.size() > 0){
			System.out.println(queueOfStudents.poll().toString());
		}
	}
}

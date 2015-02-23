Объекты класса Student, в котором содержится 3 поля: grade, year, name составляют массив из 15 элементов. Необходимо реализовать 3 компаратора (java.util.Comparator) для сортировок этого массива: по оценке, году рождения и имени. Компараторы возвращаются методами класса StudentHelper: getGradeComparator(), getYearComparator(), getNameComparator(). Используйте внутренние или анонимные классы. Задание рассмотрено на последней практике.

INPUT:

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

OUTPUT:
Sort by grade
Student{grade=5, year=18, name='Ramil Safin'}
Student{grade=5, year=18, name='Iliya Vlasov'}
Student{grade=5, year=18, name='Marat Abdullin'}
Student{grade=5, year=18, name='Leonid Yuskevich'}
Student{grade=5, year=1, name='group403'}
Student{grade=5, year=4, name='ITIS'}
Student{grade=4, year=18, name='Ainur Zinnatov'}
Student{grade=4, year=19, name='Lia Sharipova'}
Student{grade=4, year=19, name='Ramis Shakirov'}
Student{grade=4, year=19, name='Ilgiz Husaenov'}
Student{grade=4, year=19, name='Artur Arifullin'}
Student{grade=3, year=18, name='Adelya Ahmerova'}
Student{grade=3, year=18, name='Renat Yusupov'}
Student{grade=3, year=19, name='Bulat Tazetdinov'}
Student{grade=2, year=18, name='Stanislav Salnikov'}
Sort by name
Student{grade=3, year=18, name='Adelya Ahmerova'}
Student{grade=4, year=18, name='Ainur Zinnatov'}
Student{grade=4, year=19, name='Artur Arifullin'}
Student{grade=3, year=19, name='Bulat Tazetdinov'}
Student{grade=5, year=1, name='group403'}
Student{grade=4, year=19, name='Ilgiz Husaenov'}
Student{grade=5, year=18, name='Iliya Vlasov'}
Student{grade=5, year=4, name='ITIS'}
Student{grade=5, year=18, name='Leonid Yuskevich'}
Student{grade=4, year=19, name='Lia Sharipova'}
Student{grade=5, year=18, name='Marat Abdullin'}
Student{grade=5, year=18, name='Ramil Safin'}
Student{grade=4, year=19, name='Ramis Shakirov'}
Student{grade=3, year=18, name='Renat Yusupov'}
Student{grade=2, year=18, name='Stanislav Salnikov'}
Sort by year
Student{grade=4, year=19, name='Artur Arifullin'}
Student{grade=3, year=19, name='Bulat Tazetdinov'}
Student{grade=4, year=19, name='Ilgiz Husaenov'}
Student{grade=4, year=19, name='Lia Sharipova'}
Student{grade=4, year=19, name='Ramis Shakirov'}
Student{grade=3, year=18, name='Adelya Ahmerova'}
Student{grade=4, year=18, name='Ainur Zinnatov'}
Student{grade=5, year=18, name='Iliya Vlasov'}
Student{grade=5, year=18, name='Leonid Yuskevich'}
Student{grade=5, year=18, name='Marat Abdullin'}
Student{grade=5, year=18, name='Ramil Safin'}
Student{grade=3, year=18, name='Renat Yusupov'}
Student{grade=2, year=18, name='Stanislav Salnikov'}
Student{grade=5, year=4, name='ITIS'}
Student{grade=5, year=1, name='group403'}

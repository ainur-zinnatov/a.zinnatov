package ru.kpfu.itis.group403.zinnatov.textTable;


/**
 * Created by hp on 20.03.2015.
 */
public class StudentViewProvider implements ViewProvider<Student>{

	private String [] headers = new String[]{"Name","Year","Grade"};
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getHeader(int r) {
		return headers[r];
	}

	@Override
	public String getLabel(Student a, int r) {
		if(r==0){
			return a.getName();
		}
		else if(r == 1){
			return Integer.toString(a.getYear());
		}
		else if(r == 2){
			return Integer.toString(a.getGrade());
		}
		return null;
	}
}

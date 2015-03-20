package ru.kpfu.itis.group403.zinnatov.textTable;

/**
 * Created by hp on 14.03.2015.
 */
public interface ViewProvider<T> {

	int getColumnCount();
	String  getHeader(int r);
	String getLabel(T a, int r);
}

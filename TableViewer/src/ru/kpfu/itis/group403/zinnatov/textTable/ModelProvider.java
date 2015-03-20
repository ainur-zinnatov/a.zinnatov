package ru.kpfu.itis.group403.zinnatov.textTable;

import java.util.Comparator;

/**
 * Created by hp on 14.03.2015.
 */
public interface ModelProvider<T> {
	T[] getModel();

	Comparator<T> getComporator();


}

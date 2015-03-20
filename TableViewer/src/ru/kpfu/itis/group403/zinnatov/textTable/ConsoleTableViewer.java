package ru.kpfu.itis.group403.zinnatov.textTable;

import java.util.Arrays;



/**
 * Created by hp on 14.03.2015.
 */
public class ConsoleTableViewer<T> {
	private ModelProvider<T> modelProvider;
	private ViewProvider<T> viewProvider;

	public ConsoleTableViewer(ModelProvider<T> modelProvider, ViewProvider<T> viewProvider) {
		this.modelProvider = modelProvider;
		this.viewProvider = viewProvider;
	}

	public ModelProvider<T> getModelProvider() {
		return modelProvider;
	}

	public void setModelProvider(ModelProvider<T> modelProvider) {
		this.modelProvider = modelProvider;
	}

	public ViewProvider<T> getViewProvider() {
		return viewProvider;
	}

	public void setViewProvider(ViewProvider<T> viewProvider) {
		this.viewProvider = viewProvider;
	}


	public void show() {
		//отобразить таблицу
		String [] header = new String[viewProvider.getColumnCount()];
		for (int i = 0; i <header.length ; i++) {
			header[i] = viewProvider.getHeader(i);
		}
		T[] model = modelProvider.getModel();
		Arrays.sort(model, modelProvider.getComporator());
		Object[][] modelTable = tableMod(model, header.length);



		TextTable<Student> textTable = new TextTable<>(modelTable,header);
		textTable.printTable();
		}

	private Object[][] tableMod(T[] model, int columnCount){

		Object[][] arrayValues = new Object[model.length][];

		for (int i = 0; i < model.length; i++) {
			arrayValues[i] = dataLines(model[i],columnCount);
		}

		return arrayValues;

	}

	private Object[] dataLines(T model, int columnCount){
		Object[] linesData = new Object[columnCount];

		for(int i = 0; i < columnCount; i++) {
			linesData[i] = viewProvider.getLabel(model, i);
		}

		return linesData;
	}


}

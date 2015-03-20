package ru.kpfu.itis.group403.zinnatov.textTable;

/**
 * Created by hp on 20.03.2015.
 */
public class TextTable<T> {

	private String[] header;
	private Object[][] data;
	private int max = 0;

	public TextTable(Object[][] data, String[] header) {
		this.data = data;
		this.header = header;
	}


	public void printTable() {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				if (data[i][j].toString().length() > max) {
					max = data[i][j].toString().length();
				}
			}
		}
		String k = "%" + max + "s";

		for (int j = 0; j <= max * header.length; j++) {
			if (j % max == 0) System.out.print("|");
			else
				System.out.print("=");
		}
		System.out.println();

		for (String aHeader : header) {
			System.out.format(k, aHeader);
		}

		System.out.println();
		for (int j = 0; j <= max * header.length; j++) {
			if (j % max == 0) System.out.print("|");
			else
				System.out.print("=");
		}
		System.out.println();
		for (Object[] aData : data) {
			for (int j = 0; j < data[1].length; j++) {
				System.out.format(k, aData[j]);

			}
			System.out.println();
			for (int j = 0; j <= max * header.length; j++) {
				if (j % max == 0) System.out.print("|");
				else
					System.out.print("-");
			}
			System.out.println();
		}

	}
}
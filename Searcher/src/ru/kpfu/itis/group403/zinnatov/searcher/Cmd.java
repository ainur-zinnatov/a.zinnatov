package ru.kpfu.itis.group403.zinnatov.searcher;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 28.02.2015.
 */
public class Cmd {
	public static void main(String[] args) {


		String f1 ="";
		String f2 ="/java";


		ArrayList<File> foundFiles = new ArrayList<File>(1);
		boolean searchDirectory = false;
		boolean recSearch = false;
		boolean depthSearch = false;
		int sDepth = 0;

		if(args.length>=1) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-r")) {
					recSearch = true;
				}
				if (args[i].equals("-v")) {
					searchDirectory = true;
				}
				if (args[i].equals("-d")) {
					depthSearch = true;
					try {
						sDepth = Integer.parseInt(args[i + 1]);
					} catch (NumberFormatException e) {
						sDepth = 0;
					}
				}
			}
			if (!args[args.length - 1].equals("-v") && !args[args.length - 1].equals("-r") && !args[args.length - 1].equals("-d")) {
				f1 = args[args.length - 1];
			}

			if (!args[args.length - 2].equals("-v") && !args[args.length - 2].equals("-r") && !args[args.length - 2].equals("-d")) {
				if (args[args.length - 2].charAt(0) != '/') {
					args[args.length - 2] = "/" + args[args.length - 2];
				}
				f2 = args[args.length - 2];
			}

		}




		if(recSearch && depthSearch) {
			System.out.println("Ошибка ввода!");
		}
		else {
			try {
				File f = new File(f2);
				search(f, foundFiles, f1, searchDirectory, recSearch, depthSearch, sDepth);
			}catch (NullPointerException a){
				System.out.println(a.getMessage()+" Ошибка ввода!");
			}

			if(foundFiles.size() > 0) {
				Object[] a = foundFiles.toArray();
				for (int i = 0; i <foundFiles.size() ; i++) {
					System.out.println(a[i].toString());
				}


			}
			else{
				System.out.println("Не найдено");
			}
		}

	}

	public static void search(File f,List<File> foundFiles,String fileName,boolean searchDirectory, boolean recSsearch, boolean depthSearch,int depth){

		File[] file = f.listFiles() ;

//рекурсивный поиск по вложенным папкам
		if(recSsearch && !depthSearch ) {
			for (File aFile : file) {

				if (aFile.isDirectory()) {
					if (searchDirectory && aFile.getName().contains(fileName)) {
						foundFiles.add(aFile);
					}
					search(aFile, foundFiles, fileName, searchDirectory, true, false, depth);
				} else {
					if (aFile.getName().contains(fileName)) {

						foundFiles.add(aFile);
					}
				}
			}
		}
//поиск до определенной вложенности папок
		else if(!recSsearch && depthSearch){
			int d = depth;
			for (File aFile : file) {

				if (aFile.isDirectory()) {
					if (searchDirectory && aFile.getName().contains(fileName)) {
						foundFiles.add(aFile);
					}
					if(d != 0)
					search(aFile, foundFiles, fileName, searchDirectory, false, true, d-1);

				}
				else {
					if (aFile.getName().contains(fileName)) {

						foundFiles.add(aFile);

					}
				}
			}
		}
//default
		else {
			for (File aFile : file) {

				if (aFile.isDirectory()) {
					if (searchDirectory && aFile.getName().contains(fileName)) {
						foundFiles.add(aFile);

					}
				}
				else {
					if (aFile.getName().contains(fileName)) {

						foundFiles.add(aFile);

					}
				}


			}
		}

	}


}

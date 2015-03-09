package ru.kpfu.itis.group403.zinnatov.fraction;

public class Main {

    public static void main(String[] args) {
	// write your code here
	    try {
		    reduceFraction(args[0], args[1]);
	    }catch (ArithmeticException e){
		    System.out.println(e.getMessage());
	    }catch (NumberFormatException e){
		    System.out.println("Неправильный формат чисел");
	    }catch (ArrayIndexOutOfBoundsException e){
		    System.out.println("Мало аргументов");
	    }

	    }

	public static void reduceFraction (String a1, String a2) throws  ArithmeticException,NumberFormatException{
		int a = Integer.parseInt(a1);
		int b = Integer.parseInt(a2);
		int n = a;

		if(a == 0 || b == 0){
			throw new ArithmeticException("Деление на ноль");
		}
		while(true){
			if(n == 0){
				break;
			}
			if(b%n==0 && a%n == 0){
				System.out.println((a/n)+"/"+(b/n));
				break;
			}
			n--;
		}
	}
}

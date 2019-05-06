//package org.stepic.java.example;

public class Aaa {
    public static void main(String[] args) {
        try { System.out.println(getCallerClassAndMethodName());}
        catch(Exception e) {System.out.println("d");}
        anotherMethod();
    }

    private static void anotherMethod() {
        try {System.out.println(getCallerClassAndMethodName());}
        catch(Exception e) {System.out.println("d");}
    }

    public static String getCallerClassAndMethodName() {
        try {
        	throw new AException("a");
        }
        catch(AException e) {
        	System.out.println("111");
        	throw new Exception("b");
        }
        catch(Exception e) {
        	System.out.println(e.getStackTrace()[1].getClassName() + "#" + e.getStackTrace()[1].getMethodName());
        	//return e.getStackTrace()[2].toString();
        }
        return("c");

    }
    public static class AException extends Exception {

    public  AException(String message) {
        super(message);

    }

    public  AException(String message, Throwable cause) {
        super(message, cause);
    }
}
}
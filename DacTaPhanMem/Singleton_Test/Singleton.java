 

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable{

	private static final long serialVersionUID = -1093810940935189395L;
	private static Singleton sc = new Singleton();
	private Singleton(){
		if(sc!=null){
			throw new IllegalStateException("Already created.");
		}
	}
	public static Singleton getInstance(){
		return sc;
	}
	
	private Object readResolve() throws ObjectStreamException{
		return sc;
	}
	
	private Object writeReplace() throws ObjectStreamException{
		return sc;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}
	
	private static Class getClass(String classname) throws ClassNotFoundException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    if(classLoader == null) 
	        classLoader = Singleton.class.getClassLoader();
	    return (classLoader.loadClass(classname));
	}
	public static void main(String[] args) {
        // Kiểm thử SingletonLazyDoubleCheck
        System.out.println("== Kiểm thử SingletonLazyDoubleCheck ==");

        SingletonLazyDoubleCheck instanceLazyDoubleCheck1 = SingletonLazyDoubleCheck.getInstance();
        System.out.println("Thể hiện 1 hash code: " + instanceLazyDoubleCheck1.hashCode());

        SingletonLazyDoubleCheck instanceLazyDoubleCheck2 = SingletonLazyDoubleCheck.getInstance();
        System.out.println("Thể hiện 2 hash code: " + instanceLazyDoubleCheck2.hashCode());

        if (instanceLazyDoubleCheck1 == instanceLazyDoubleCheck2) {
            System.out.println("Cả hai thể hiện là cùng một đối tượng.");
        } else {
            System.out.println("Các thể hiện là các đối tượng khác nhau.");
        }

        // Kiểm thử SingletonLazy
        System.out.println("\n== Kiểm thử SingletonLazy ==");

        SingletonLazy instanceLazy1 = SingletonLazy.getInstance();
        System.out.println("Thể hiện 1 hash code: " + instanceLazy1.hashCode());

        SingletonLazy instanceLazy2 = SingletonLazy.getInstance();
        System.out.println("Thể hiện 2 hash code: " + instanceLazy2.hashCode());

        if (instanceLazy1 == instanceLazy2) {
            System.out.println("Cả hai thể hiện là cùng một đối tượng.");
        } else {
            System.out.println("Các thể hiện là các đối tượng khác nhau.");
        }

        // Kiểm thử SingletonEager
        System.out.println("\n== Kiểm thử SingletonEager ==");

        SingletonEager instanceEager1 = SingletonEager.getInstance();
        System.out.println("Thể hiện 1 hash code: " + instanceEager1.hashCode());

        SingletonEager instanceEager2 = SingletonEager.getInstance();
        System.out.println("Thể hiện 2 hash code: " + instanceEager2.hashCode());

        if (instanceEager1 == instanceEager2) {
            System.out.println("Cả hai thể hiện là cùng một đối tượng.");
        } else {
            System.out.println("Các thể hiện là các đối tượng khác nhau.");
        }

        // Kiểm thử SingletoneEnum
        System.out.println("\n== Kiểm thử SingletoneEnum ==");

        SingletoneEnum.SingleEnum enumInstance1 = SingletoneEnum.SingleEnum.SINGLETON_ENUM;
        SingletoneEnum.SingleEnum enumInstance2 = SingletoneEnum.SingleEnum.SINGLETON_ENUM;

        if (enumInstance1 == enumInstance2) {
            System.out.println("Cả hai thể hiện là cùng một đối tượng.");
        } else {
            System.out.println("Các thể hiện là các đối tượng khác nhau.");
        } 
    }
}

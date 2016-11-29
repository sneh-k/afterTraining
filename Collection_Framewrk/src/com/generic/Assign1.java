package com.generic;


class GenericWrapper<T>
{
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
class A
{
	String name;

	public A(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
}
public class Assign1 {

	public static void main(String[] args) {
		
		GenericWrapper<A> g=new GenericWrapper<A>();
		g.setT(new A("ABC"));
		System.out.println(" String : "+g.getT());
	}

}

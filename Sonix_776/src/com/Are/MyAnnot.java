package com.Are;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // specifies at what level we use this annotation
@Retention(RetentionPolicy.RUNTIME) // at what extent we need this annot
@interface SonyXperia
{
	String music() default "Nokia";
	int series() default 2;
}
@SonyXperia(music="Michael Jackson",series = 1)
class MyCell
{
	String model;
	int size;
	public MyCell(String model, int size) {
		super();
		this.model = model;
		this.size = size;
	}
	
}




public class MyAnnot {
	public static void main(String[] args) {
		MyCell m = new MyCell("Walkman",6);
		Class<? extends MyCell> c = m.getClass(); //Reflection API
		Annotation an = c.getAnnotation(SonyXperia.class);
		SonyXperia s = (SonyXperia) an;
		System.out.println(s.music()+"  "+s.series());
	}

}

//두 개의 생성자를 가진 Circle 클래스, 생성자 선언 및 호출 연습
//생성자 예제->tptty.example01->TV
package tptty.example03;

public class Circle {

	int radius;
	String name;
	
	public Circle() {
		radius = 1;
		name = "";
	}
	
	public Circle(int r, String n) {
		radius = r;
		name = n;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	//=====================================================================
	
//	public class Book {
//		String title;
//		String author;
//		
//		public Book(String t) {
//			title = t;
//			author = "작자미상";
//		}
//		
//		public Book(String t, String a) {
//			title =t;
//			author = a;
//		}
//	}
	
	//main=====================================================================
	public static void main(String[] args) {
		Circle pizza = new Circle(10, "자바피자");
		double area = pizza.getArea();
		System.out.println(pizza.name+"의 면적은 "+area);
		
		Circle donut = new Circle();
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name+"의 면적은 "+area);
		
//		Book javaBook = new Book("Java", "홍길동");
//		Book bible = new Book("Bible");
		//Book b1 = new Book(); 
		//오류발생 : 생성자가 이미 선언되어 있는 경우, 디폴트생성자 자동생성x
		//오류원인 : 생성자가 없음 (디폴트생성자가 자동으로 생성되지 않았음)
		//해결방법 : 다른 생성자처럼 디폴트생성자도 직접 생성

	}

}

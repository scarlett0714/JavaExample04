package tptty.example04;

public class Book {
	
	String title;
	String author;
	void show() {
		System.out.println(title+" "+author);
	}
	
	public Book() {
		this("",""); //생성자 중 매개변수를 2개 가지는 public Book(String title, String author)호출
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title, "작자미상"); //생성자 중 매개변수를 2개 가지는 public Book(String title, String author)호출
	}
	
	public Book(String title, String author) {
		this.title = title; //매개변수 title과, author와 혼란->this.title은 필드영역에 있던 this를 가리킴
		this.author = author; //매개변수 title과, author와 혼란->this.author은 필드영역에 있던 author를 가리킴
	}
	
	public static void main(String[] args) {
		Book javaBook = new Book("Java", "홍길동");
		Book bible = new Book("Bible");
		Book emptyBook = new Book();
		javaBook.show();
		bible.show();
		emptyBook.show();
				

	}

}

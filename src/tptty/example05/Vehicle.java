package tptty.example05;

import tptty.example01.TV;

public class Vehicle {

	public String color; //차량색상
	public int speed; //차량속도
	public int mileage; //주행거리
	public char gearStatus; //기어상태 : P N D 1 2
	public TV tv; //타입이 TV인 변수생성, 앞의 기본타입과는 달리 복사 시 깊은복사 필요
	
	//생성자 생성법
	//1. 직접입력
	//2. Source->Generate Constructor using filed : 클래스를 구성하는 필드정보가 뜸
	//->생성자가 받을 인자를 필드에서선택, 접근권한 선택->super();가 갑자기 생기는데 일단 지우고 실행
	
	public Vehicle() { //디폴트 생성자
		this("검정색",0,0,'P'); //아래처럼 동일한 코드를 반복해서 쓰기보단 this로 다른 생성자 호출
		
//		this.color = "검정색"; //this=내 멤버(필드에 있는 color를 가리킴)
//		this.speed = 0;
//		this.mileage = 0;
//		this.gearStatus = 'P';
	}
	
	public Vehicle(String color, int mileage) {
		//this생성자는 반드시 첫줄에 위치
		this(color,0,mileage,'P'); //매개변수가 4개인 다른 생성자 호출
	}
	
	public Vehicle(String color, int speed, int mileage, char gearStatus) {
		//Vehicle클래스 내부에서 내 멤버를 참조할 땐, this사용
		System.out.println("생성자 : "+this);
		this.color = color; //매개변수와 필드의 color를 구분
		this.speed = speed;
		this.mileage = mileage;
		this.gearStatus = gearStatus;
	}
	
	public Vehicle(String color, int speed, int mileage, char gearStatus, TV tv) {
		//Vehicle클래스 내부에서 내 멤버를 참조할 땐, this사용
		System.out.println("생성자 : "+this);
		this.color = color; //매개변수와 필드의 color를 구분
		this.speed = speed;
		this.mileage = mileage;
		this.gearStatus = gearStatus;
		this.tv = tv;
	}

	public Vehicle(Vehicle car2) {//복사 생성자
		//TV는 기본타입과는 다르게 새로운 객체 생성필요(깊은 복사 : 새로운 공간 할당)
		//TV에는 복사 생성자가 없으므로 생성자 생성
		this(car2.color, car2.speed, car2.mileage, car2.gearStatus, new TV (car2.tv));
	}

	public void accelerate(int speed) { //speed만큼 속도 상승
		if((this.gearStatus!='P')&&(this.gearStatus!='N')) {
			this.speed += speed;
			this.mileage += speed;
		}
		else {
			System.out.println("현재 기어상태는 "+this.gearStatus+" 상태입니다.");
		}
	}
	
	public void breaker(int speed) { //speed만큼 속도 감소
		if((this.gearStatus!='P')&&(this.gearStatus!='N')) {
			this.speed -= speed;
			this.mileage += this.speed;
		}
		else {
			System.out.println("현재 기어상태는 "+this.gearStatus+" 상태입니다.");
		}
	}
	
	public void changeGear (char gearStatus) {
		this.gearStatus = gearStatus;
		switch(this.gearStatus) {
		case 'P':
		case 'N':
			this.speed = 0;
			break;
		case '1':
			this.speed = 20;
			break;
		case '2':
			this.speed = 30;
			break;
		}
	}
	
	public void showStatus() {
		switch(this.gearStatus) {
		case 'P':
			System.out.println("주차중");
			break;
		case 'N':
			System.out.println("중립모드");
			break;
		case 'D':
			System.out.println("주행중");
			break;
		case '1':
			System.out.println("1단 저속운행중");
			break;
		case '2':
			System.out.println("2단 저속운행중");
			break;
		}
		System.out.println("================");
		System.out.println("차의 색상 : "+this.color);
		System.out.println("차의 현재속도 : "+this.speed);
		System.out.println("차의 기어상태 : "+this.gearStatus);
		if(tv!=null) //차량에 tv가 장책되어있다면
			tv.show(); //tv상태 출력
		System.out.println("================");
	}

}

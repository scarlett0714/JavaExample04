package tptty.example05;

import tptty.example01.TV; //다른 패키지에 있는 클래스 불러오기

public class TestMain {

	public static void main(String[] args) {
		System.out.println("---------- Car1 ----------");
		Vehicle car1 = new Vehicle(); //디폴트생성자를 이용해 디폴트객체 생성
		car1.showStatus(); //처음 디폴트값에서 주차중
		
		car1.changeGear('D');
		car1.accelerate(10);
		car1.accelerate(10);
		car1.showStatus();
		
		car1.breaker(5);
		car1.changeGear('N'); //중립모드일 경우, 현재속도 = 0
		car1.showStatus();
		
		System.out.println();
		System.out.println("---------- Car2 ----------");
		Vehicle car2 = new Vehicle("빨간색", 0, 100, 'P');
		car2.tv = new TV(true, 12);
		//Vehicle클래스 외부에서 참조할 때, 변수이름사용
		System.out.println("car2 : "+car2); //car1의 주소값이 출력됨
		car2.showStatus(); //처음 디폴트값에서 주차중
		
		car2.changeGear('D');
		car2.accelerate(10);
		car2.accelerate(10);
		car2.showStatus();
		
		car2.breaker(5);
		car2.changeGear('N'); //중립모드일 경우, 현재속도 = 0
		car2.showStatus();
		
		//복사생성자(오버로딩 불가능)
		System.out.println();
		System.out.println("---------- Car3 ----------");
		
		Vehicle car3 = new Vehicle(car2); //car1의 속성을 그대로 얕은복사->문제없음
		//오류발생 : Vehicle이 인자로 들어오는 생성자가 Vehicle클래스에 없음
		//해결방법 : 마우스-> Create Constructor Vehicle(Vehicle) : Vehicle클래스 내부에 생성자 생성
		
		car3.showStatus(); //car1과 같은 값 출력
		car3.color = "보라색"; //복사 후, 값 변경 가능
		car3.changeGear('D');
		car3.showStatus(); //앞의 값을 변경 후 출력
		
		System.out.println("---------- Car2 채널변경 ----------");
		car2.tv.channelUp();
		System.out.println("---------- Car3 ----------");
		car3.showStatus();
		//오류발생 : car2와 car3가 같은 TV객체 공유
		//해결방법 : 깊은복사(Vehicle에서 새로 객체 생성)
		

	}

}

package tptty.example01;

public class TestMain { //.java파일이름과 같은 클래스는(TestMain) 반드시 public으로 선언 *public클래스는 파일내부에 딱 1개만 존재

	public static void main(String[] args) {
		System.out.println("====== TV1 ======");
		TV tv1 = new TV(); //TV객체는 heap영역에 생성됨, tv1변수는 stack영역에 생성되고 TV객체의 주소를 가짐
		//TV에서 디폴트생성자가 아닌 다른 형태의 생성자를 생성했다면, 디폴트생성자를 따로 만들어줘야 위에 코드 정상작동
		//->마우스->create constructor 'TV()'->TV클래스에 생성됨
		tv1.powerOnOff();
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelDown();
		tv1.powerOnOff();
		
		System.out.println("\n====== TV2 ======");
		TV tv2 = new TV(); //필요할 때마다 객체 생성
		tv2.powerOnOff();
		tv2.channelUp();
		
		System.out.println("tv1 : "+tv1);
		System.out.println("tv2 : "+tv2);
		System.out.println("\n====== TV1 = TV2 ======"); //tv1과 tv2는 타입이 같아 대입연산가능
		tv1 = tv2;
		System.out.println("tv1 : "+tv1);
		System.out.println("tv2 : "+tv2);
		
		System.out.println("\n====== TV1 ======");
		tv1.show(); //tv1은 꺼져있었음에도 불구하고 tv2의 값을 대입받아 tv2의 상태 출력
	}

}

//class TV{ //파일이름과 같은 클래스(TestMain)을 public으로 선언했다면, 다른 클래스는 public으로 선언불가
//	//필드 선언
//	public boolean power; //자동으로 power값은 false로 초기화
//	public int channel; //자동으로 channel값은 0으로 초기화
//	
//	//메소드 선언
//	public void show() { //현 상태를 확인하기위한 출력구문
//		if(power) {//전원이 들어와있는 경우
//			System.out.println("현재 "+channel+"번 시청 중");
//		}
//		else //전원이 들어와있지 않은 경우
//			System.out.println("TV전원 꺼져있음");
//	}
//	
//	public void powerOnOff() {
//		//false->true,true->false
//		power = !power; //필드에 선언된 변수들은 static이 붙어있지 않으므로 클래스나부에선 필드이름으로 자유롭게 사용가능
//		show();
//	}
//	
//	public void channelUp() {
//		if(power) {
//			++channel; 
//		}
//		show();
//	}
//	
//	public void channelDown() {
//		if(power) {
//		--channel;
//		}
//		show();
//	}
//}

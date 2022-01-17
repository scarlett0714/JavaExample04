package tptty.example01;

public class TV { //파일이름과 동일한 class는 public으로 설정
	//같은 tptty.example01패키지 내부에 main함수가 없는 TV클래스 생성
	//->오류발생 : TestMain에도 동일한 이름의 TV클래스 존재
	//->TestMain의 TV클래스 삭제 후 새로 생성한 TV로 코드 이동
	//->TestMain에 TV클래스로 있을 때랑 동일하게 작동됨
	
	//필드 선언
		public boolean power; //자동으로 power값은 false로 초기화
		public int channel; //자동으로 channel값은 0으로 초기화, 원하는 값으로 초기화 가능
		
		//생성자 선언
		public TV(boolean p) { //TV의 초기상태가 powerOn인 상황
			power = p;
		}
		
		public TV(boolean p, int c) { //초기 전원설정, 초기 채널설정
			power = p;
			channel = c;
		}
		
		public TV() {
			// TODO Auto-generated constructor stub
		}

		public TV(TV tv) {
			// TODO Auto-generated constructor stub
			this(tv.power, tv.channel);
//			this.channel = tv.channel;
//			this.power = tv.power;
		}

		//메소드 선언
		public void show() { //현 상태를 확인하기위한 출력구문
			if(power) {//전원이 들어와있는 경우
				System.out.println("현재 "+channel+"번 시청 중");
			}
			else //전원이 들어와있지 않은 경우
				System.out.println("TV전원 꺼져있음");
		}
		
		public void powerOnOff() {
			//false->true,true->false
			power = !power; //필드에 선언된 변수들은 static이 붙어있지 않으므로 클래스나부에선 필드이름으로 자유롭게 사용가능
			show();
		}
		
		public void channelUp() {
			if(power) {
				++channel; 
			}
			show();
		}
		
		public void channelDown() {
			if(power) {
			--channel;
			}
			show();
		}

}

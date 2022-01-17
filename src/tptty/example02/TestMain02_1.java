//문자 치환하기 (메소드 오버로딩)
package tptty.example02;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain02_1 {

	public static Scanner scan = new Scanner(System.in);
	
	//문자배열이 입력되면 1번째, 문자열이 입력되면 2번째 replaceChar 실행
	public static void replaceChar(char[] input, char char1, char char2) {
		for(int i=0;i<input.length;i++) {
			if(input[i]==char1)
				input[i] = char2;
		}
	}
	
	public static char[] replaceChar(String input, char char1, char char2) {
		char [] charArr = input.toCharArray(); //toCharArray() : 문자열을 문자배열로 변환해서 반환 (input값은 변경x)
		replaceChar(charArr, char1, char2); //문자열을 문자배열로 바꿨다면 문자배열이 입력된 경우(1번째 replaceChar 실행)
		//참조변수는 주소를 넘기기때문에 다른 함수에서 값을 변경해도 실인자도 변경됨(같은 메모리를 공유하고있는 상태)
		
		return charArr;
	}
	
	public static void example02_1() {
		System.out.print("문자열을 입력하세요 : ");
		String userInput = scan.nextLine();
		
		System.out.print("찾을 문자를 입력하세요 : ");
		String userChar1 = scan.nextLine();
		char char1 = userChar1.charAt(0); //입력한 문자열의 첫번째 값만 가지고옴
		
		System.out.print("바꿀 문자를 입력하세요 : ");
		String userChar2 = scan.nextLine();
		char char2 = userChar2.charAt(0);
		
		char[] charArr = userInput.toCharArray(); //입력받은 문자열을 문자배열로 변환한값을 반환
		replaceChar(charArr, char1, char2);
		System.out.println(charArr);
		//Q.참조변수 charArr은 주소값을 저장하고있을 텐데, sysout(charArr)하면 charArr이 가리키는 문자배열이 출력됨
		//->주소값이 출력되어야 하는 것 아닌가?
		//A.C언어와 마찬가지로 문자배열은 특별취급해서 주소값이 아닌 문자배열이 바로 출력됨
		
		char[] charArr1 = replaceChar(userInput, char1, char2); //사용자가 입력한값은 문자열이므로 2번째 replaceChar실행
		System.out.println(charArr1);
		System.out.println(userInput);
	}
	public static void main(String[] args) {
		example02_1();
		
		//example02_1에서의 출력과 차이비교 (int형 배열[](기본타입 배열) vs 문자배열
		int[] arr = {1,2,3,4,5};
		System.out.println("\n"+arr); //arr의 주소값이 출력됨
		System.out.println(Arrays.toString(arr)); //Arrays.toString() : 배열을 문자열로 변환, arr의 값이 출력됨
	}

}

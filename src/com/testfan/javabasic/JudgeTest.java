package com.testfan.javabasic;

/**
 * @author ɳİ qq2879897713
 *
 */
public class JudgeTest {

	public static void ifElse() {
		int score = 60;

		// if (score>=90) {
		// System.out.println("����");
		// } else {
		// System.out.println("������");
		// }
		//
		if (score >= 90&&score<=100) {
			System.out.println("����");
		} else if (score < 90 && score >= 80) {
			System.out.println("����");
		} else if (score < 80 && score >= 70) {
			System.out.println("һ��");
		} else if (score < 70 && score >= 60) {
			System.out.println("����");
		} else if(score<60&&score>=0){
			System.out.println("������");
		}else{
			System.out.println("�������ڷ�Χ��");
		}
		
		if(score>3000){
			System.out.println("��ϲ���ҵ���������");
		};
	}
	
	public static void switchTest(String direction){
		
		switch (direction.toUpperCase()) {
		case "UP":
			System.out.println("��");
			break;
		case "DOWN":
			System.out.println("��");
			break;
		case "LEFT":
			System.out.println("��");
			break;
		case "RIGHT":
			System.out.println("��");
			break;

		default:
			System.out.println("�����������");
			break;
		}
	}

	public static void main(String[] args) {
		//ifElse();
		switchTest("up");
	}

}

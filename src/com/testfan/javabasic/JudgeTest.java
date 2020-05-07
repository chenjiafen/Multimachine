package com.testfan.javabasic;

/**
 * @author 沙陌 qq2879897713
 *
 */
public class JudgeTest {

	public static void ifElse() {
		int score = 60;

		// if (score>=90) {
		// System.out.println("优秀");
		// } else {
		// System.out.println("不优秀");
		// }
		//
		if (score >= 90&&score<=100) {
			System.out.println("优秀");
		} else if (score < 90 && score >= 80) {
			System.out.println("良好");
		} else if (score < 80 && score >= 70) {
			System.out.println("一般");
		} else if (score < 70 && score >= 60) {
			System.out.println("及格");
		} else if(score<60&&score>=0){
			System.out.println("不及格");
		}else{
			System.out.println("分数不在范围内");
		}
		
		if(score>3000){
			System.out.println("恭喜你找到了外星球");
		};
	}
	
	public static void switchTest(String direction){
		
		switch (direction.toUpperCase()) {
		case "UP":
			System.out.println("上");
			break;
		case "DOWN":
			System.out.println("下");
			break;
		case "LEFT":
			System.out.println("左");
			break;
		case "RIGHT":
			System.out.println("右");
			break;

		default:
			System.out.println("方向参数不对");
			break;
		}
	}

	public static void main(String[] args) {
		//ifElse();
		switchTest("up");
	}

}

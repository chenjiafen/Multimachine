package com.testfan.javabasic;

/**
 * @author ɳİ qq2879897713
 *
 */
public class XunHuanTest {

	// ���1��10������
	public static void whileTest() {
		int i = 10;

		while (i > 0) {
			System.out.println(i);
			// i-- ʵ�ʾ���i=i-1
			i--;
		}
	}

	public static void doWhileTest() {
		int i = 10;

		do {
			System.out.println(i);
			i--;
		} while (i > 10);
	}

	public static void forTest() {
		// int i=10;

		// int j=1�����ʱ��j=1

		// ִ��j<11,true
		// System.out.println(j);
		// j++,j=2

		// ִ��j<11,true
		// System.out.println(j);
		// j++,j=3

		// ִ��j<11,true
		// System.out.println(j);
		// j++,j=4

		for (int j = 1; j < 11; j++) {
			System.out.println(j);
		}

		int i = 4;
		for (; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println(i+10);
	}

	public void forEach() {
		int[] i = { 1, 2, 5, 6, 8, 10 };
		for (int i1 : i) {
			System.out.println(i1);
		}
	}

	public static void main(String[] args) {
		// whileTest();
		// doWhileTest();
		forTest();
	}

}

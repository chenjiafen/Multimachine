package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class ExceptionTest {
	
	
	public static void exception() throws Exception{
		
	}
	
	public static void exTest(){
			try {
				exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static void main(String[] args) {
		String[] sArray=new String[3];
		sArray[0]="AAA";
		sArray[1]="BBB";
		sArray[2]="CCC";
		
		try {
			sArray[0]="AAA";
			sArray[1]="BBB";
			sArray[2]="CCC";
			//int a=2/0;
			sArray[3]="DDD";
		} catch(Exception e){
			System.out.println("�������쳣");
		} finally{
			System.out.println("��������ִ�е������ɶ���Ҷ�Ҫִ��");
		}
			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//			System.out.println("����Խ���쳣");
//		} catch(ArithmeticException e1){
//			System.out.println("��ĸ����Ϊ0");
//		}
		
		System.out.println("��ֵ���");
		
		//Array index out of Bounds Exception
		//����        ����       ����          �߽�           �쳣
	}

}

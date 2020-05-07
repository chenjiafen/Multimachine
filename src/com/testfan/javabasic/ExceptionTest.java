package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
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
			System.out.println("这里有异常");
		} finally{
			System.out.println("不管上面执行的情况是啥，我都要执行");
		}
			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//			System.out.println("数组越界异常");
//		} catch(ArithmeticException e1){
//			System.out.println("分母不能为0");
//		}
		
		System.out.println("赋值完成");
		
		//Array index out of Bounds Exception
		//数组        索引       超出          边界           异常
	}

}

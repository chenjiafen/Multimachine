package com.testfan.javabasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author ɳİ qq2879897713
 *
 */
public class FileReaderAndWrite {

	public static void writeFile() {
		try {
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("test.txt",true), "utf-8"));
			writer.write("hello testfan");
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readerFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
			String str = "";

			while ((str = reader.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		writeFile();
		readerFile();
	}
}

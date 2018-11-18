package primenum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import primenum.primeCal;




public class primeMain {

	//数据保存在数组供线程读取
	public static ArrayList<String> pList = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		//输入数据并写文件
		File file = new File("E:\\eclipse\\shiyan3\\test.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter in = new FileWriter(file.getName());
		Scanner input = new Scanner(System.in);
		System.out.println("enter num:");
		String ss = input.nextLine();
		in.write(ss);
		in.close();
		input.close();
		
		//读取文件，把数据写到list中
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String bb = reader.readLine();
		String[] cc = bb.split("\\s");
		reader.close();
		for (String st : cc) {
			pList.add(st);
		}
		
		//打开写的文件并清空
		File file2 = new File("E:\\eclipse\\shiyan3\\test1.txt");
		if(!file2.exists()) {
			file2.createNewFile();
		}
		in = new FileWriter(file2.getName());
		in.close();
		
		//开启10个线程
		for(int i = 0;i<10;i++) {
			primeCal p = new primeCal();
			Thread tt = new Thread(p);
			tt.start();
		}
	}
}

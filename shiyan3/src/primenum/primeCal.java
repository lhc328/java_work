package primenum;

import java.io.File;
import java.io.FileWriter;

public class primeCal implements Runnable {

	//判断是否是素数
	public boolean isPrime(int num) {
		if (num <= 1)
			return false;
		int a = (int) Math.sqrt(num);
		for (int i = 2; i <= a; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void run() {
		int num;
		while (true) {
			if (!primeMain.pList.isEmpty()) {
				num = Integer.parseInt(primeMain.pList.remove(0));
				if (isPrime(num)) {
					File file2 = new File("E:\\eclipse\\shiyan3\\test1.txt");
					try {
						FileWriter in = new FileWriter(file2.getName(), true);
						//保证写文件是安全的
						synchronized (in) {
							in.write(num + " ");
							in.flush();
							in.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				break;
			}
		}
	}
}

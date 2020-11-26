package com.bambooJohn.test05;

import java.util.Random;

public class TestTools {

	public static void main(String[] args) {
		
		MyThread m1 = new MyThread();
		m1.start();
		
		MyThread m2 = new MyThread();
		m2.start();
	}
	
}

class Tools{
	private static Random random = new Random();
	private static ThreadLocal<Integer> th = new ThreadLocal<>();
	
	public static void setNumber() {
		th.set(random.nextInt(100));
	}
	
	public static int getNumber() {
		return th.get();
	}
}

class MyThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Tools.setNumber();
		
		for(int i = 0;i < 5;i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			int number = Tools.getNumber();
			System.out.println(Thread.currentThread().getName() + ":" + number);
		}
		
	}
	
}


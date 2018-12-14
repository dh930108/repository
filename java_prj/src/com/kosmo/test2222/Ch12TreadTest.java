package com.kosmo.test2222;



class MyThread implements Runnable  {
	String man = null;
	public MyThread(String man) {
		this.man = man;
	}
	
	public void run() {
			try {
				for(int i =0; i<10000; i++) {
				Thread.sleep(0);
				System.out.println(man+"놈 "+i + "번 일하는중...");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}



public class Ch12TreadTest{

	
	
	
	public static void main(String[] args) {
//		==Extends Thread로 스레드 사용==
//		MyThread man1 = new MyThread("man1");
//		man1.start();
//		
//		MyThread man2 = new MyThread("man2");
//		man2.start();
		
		
		Thread t1 = new Thread(new MyThread("man111"));
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		Runnable man2 = new MyThread("man222");
		Thread t2 = new Thread(man2);
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		

	}

}

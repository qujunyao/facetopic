/******************************************************************
 * Question2.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate：2018-2-28
 * Author：tuhongtao
 * Version：F1.0.0.0
 ******************************************************************/

package com.company.gnnt.question;

/**
 * <b>修改记录：</b>
 * <p>
 * <li>
 * 
 * ---- tuhongtao 2018-2-28</li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p>
 * 题目2： 创建两个线程，一个模拟显卡、一个模拟CPU，显卡的处理速度为2mb/s，CPU的处理速度为8mb/s，
 * 显卡和CPU同时处理图像，如果CPU比显卡处理的信息多出10mb以上时，必须停顿等待显卡进行处理，直到差距小于等于5mb，
 * 请使用线程模拟出CPU和显卡的运行日志，打印在控制台上。
 * 
 * 例如： 输出： 1秒 CPU处理了8mb 显卡处理了2mb 2秒 CPU处理了16mb，显卡处理了4mb 3秒
 * CPU处理了16mb，暂停处理新数据，显卡处理了6mb 4秒 CPU处理了16mb，暂停处理新数据，显卡处理了8mb 5秒
 * CPU处理了16mb，暂停处理新数据，显卡处理了10mb 6秒 CPU处理了16mb，暂停处理新数据，显卡处理了12mb 7秒
 * CPU处理了24mb，显卡处理了14mb 。。。 。。。
 * 
 * 考察点：线程
 * </p>
 */
public class Question_002 {

	private static int xiankaShu = 0;// 显卡处理量
	private static int cpuShu = 0;// cpu处理量
	private static int s = 1;// 标记
	private static int num = 1;// 时间计数

	public static void main(String[] args) {

		final Buess buess = new Buess();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print("第" + (num++) + "秒, ");
					buess.cpu();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					buess.xianka();

				}
			}
		}).start();
	}

	static class Buess {
		boolean cpuShould = true;

		private synchronized void cpu() {
			if (!cpuShould) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cpuShu - xiankaShu >= 10 || s == 0) {
				s = 0;
				System.out.print("cpu处理数据" + cpuShu + "m, cpu等待显卡处理数据, ");
				cpuShould = false;
				this.notify();
				return;

			}

			cpuShu += 8;
			System.out.print("cpu处理数据" + cpuShu + "m, ");
			cpuShould = false;
			this.notify();
		}

		private synchronized void xianka() {

			if (cpuShould) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			xiankaShu += 2;
			System.out.println("显卡处理数据" + xiankaShu + "m");

			if (cpuShu - xiankaShu <= 5) {
				s = 1;
			}
			cpuShould = true;
			this.notify();
		}

	}

}

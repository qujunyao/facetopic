package com.company.gnnt.answer;

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
 * 例如： 输出： +
 * 1秒 CPU处理了8mb 显卡处理了2mb 
 * 2秒 CPU处理了16mb，显卡处理了4mb 
 * 3秒 CPU处理了16mb，暂停处理新数据，显卡处理了6mb 
 * 4秒 CPU处理了16mb，暂停处理新数据，显卡处理了8mb 
 * 5秒 CPU处理了16mb，暂停处理新数据，显卡处理了10mb 
 * 6秒 CPU处理了16mb，暂停处理新数据，显卡处理了12mb 
 * 7秒 CPU处理了24mb，显卡处理了14mb 
 * 。。。 。。。
 * 
 * 考察点：线程
 * </p>
 */
public class Answer_002 {

	private static int cpuNumber = 0;
	private static int gpuNumber = 0;
	private static int num = 1;

	public static void main(String[] args) {

		MainThread thread = new MainThread();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print("第" + (num++) + "秒, ");
					thread.cpu();
				}
			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					thread.gpu();
				}

			}

		}).start();

	}

	static class MainThread {
		boolean flag = true;
		boolean wait = false;

		private synchronized void cpu() {
			if(wait) {
				if(cpuNumber-gpuNumber<=5) {
					wait = false;
				}else {
					System.out.print("CPU处理了" + cpuNumber + "mb, cpu等待显卡处理数据, ");
					this.notify();
					return;
				}
			}
			if(cpuNumber-gpuNumber>=10) {
				flag = false;
				wait = true;
				System.out.print("CPU处理了" + cpuNumber + "mb, cpu等待显卡处理数据, ");
				this.notify();
				return;
			}
			cpuNumber += 8;
			System.out.print("CPU处理了" + cpuNumber + "mb ");
			flag = false;
			this.notify();
		}

		private synchronized void gpu() {
			if (flag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gpuNumber += 2;
			System.out.println("显卡处理了" + gpuNumber +"mb");
			flag = true;
			this.notify();
		}
	}

}

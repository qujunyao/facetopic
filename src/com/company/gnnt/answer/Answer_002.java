package com.company.gnnt.answer;

/**
 * <b>�޸ļ�¼��</b>
 * <p>
 * <li>
 * 
 * ---- tuhongtao 2018-2-28</li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p>
 * ��Ŀ2�� ���������̣߳�һ��ģ���Կ���һ��ģ��CPU���Կ��Ĵ����ٶ�Ϊ2mb/s��CPU�Ĵ����ٶ�Ϊ8mb/s��
 * �Կ���CPUͬʱ����ͼ�����CPU���Կ��������Ϣ���10mb����ʱ������ͣ�ٵȴ��Կ����д���ֱ�����С�ڵ���5mb��
 * ��ʹ���߳�ģ���CPU���Կ���������־����ӡ�ڿ���̨�ϡ�
 * 
 * ���磺 ����� +
 * 1�� CPU������8mb �Կ�������2mb 
 * 2�� CPU������16mb���Կ�������4mb 
 * 3�� CPU������16mb����ͣ���������ݣ��Կ�������6mb 
 * 4�� CPU������16mb����ͣ���������ݣ��Կ�������8mb 
 * 5�� CPU������16mb����ͣ���������ݣ��Կ�������10mb 
 * 6�� CPU������16mb����ͣ���������ݣ��Կ�������12mb 
 * 7�� CPU������24mb���Կ�������14mb 
 * ������ ������
 * 
 * ����㣺�߳�
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
					System.out.print("��" + (num++) + "��, ");
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
					System.out.print("CPU������" + cpuNumber + "mb, cpu�ȴ��Կ���������, ");
					this.notify();
					return;
				}
			}
			if(cpuNumber-gpuNumber>=10) {
				flag = false;
				wait = true;
				System.out.print("CPU������" + cpuNumber + "mb, cpu�ȴ��Կ���������, ");
				this.notify();
				return;
			}
			cpuNumber += 8;
			System.out.print("CPU������" + cpuNumber + "mb ");
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
			System.out.println("�Կ�������" + gpuNumber +"mb");
			flag = true;
			this.notify();
		}
	}

}

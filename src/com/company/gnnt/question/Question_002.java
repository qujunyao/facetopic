/******************************************************************
 * Question2.java
 * Copyright 2018 by GNNT Company. All Rights Reserved.
 * CreateDate��2018-2-28
 * Author��tuhongtao
 * Version��F1.0.0.0
 ******************************************************************/

package com.company.gnnt.question;

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
 * ���磺 ����� 1�� CPU������8mb �Կ�������2mb 2�� CPU������16mb���Կ�������4mb 3��
 * CPU������16mb����ͣ���������ݣ��Կ�������6mb 4�� CPU������16mb����ͣ���������ݣ��Կ�������8mb 5��
 * CPU������16mb����ͣ���������ݣ��Կ�������10mb 6�� CPU������16mb����ͣ���������ݣ��Կ�������12mb 7��
 * CPU������24mb���Կ�������14mb ������ ������
 * 
 * ����㣺�߳�
 * </p>
 */
public class Question_002 {

	private static int xiankaShu = 0;// �Կ�������
	private static int cpuShu = 0;// cpu������
	private static int s = 1;// ���
	private static int num = 1;// ʱ�����

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
					System.out.print("��" + (num++) + "��, ");
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
				System.out.print("cpu��������" + cpuShu + "m, cpu�ȴ��Կ���������, ");
				cpuShould = false;
				this.notify();
				return;

			}

			cpuShu += 8;
			System.out.print("cpu��������" + cpuShu + "m, ");
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
			System.out.println("�Կ���������" + xiankaShu + "m");

			if (cpuShu - xiankaShu <= 5) {
				s = 1;
			}
			cpuShould = true;
			this.notify();
		}

	}

}

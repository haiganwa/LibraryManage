/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject7;

import java.util.Scanner;

/**
 *
 * @author dell
 */
public class BBB extends LibraryUI {
    UserData user = new UserData();
    public void welcome() {
		System.out.println("*********************************");
		System.out.println("************ͼ��ݹ���ϵͳ********");
		System.out.println("*********************************");
		loginBoundary();// ��¼����
    }

    public void loginBoundary() {
		System.out.print("����Ա�˺ţ�");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.print("�� ¼ �� �� ��");
		Scanner scanner1 = new Scanner(System.in);
		String password = scanner1.nextLine();
		int flag = login(username, password);// ��¼��֤
		switch (flag) {
		case 0:// �������
			System.out.println("����������������롣");
			loginBoundary();
			break;
 
		case 1:// ��֤ͨ��
			System.out.println("��¼�ɹ���");     
                        showMenu();
			break;
		case -1:// �˻�������
			System.out.println("������Ĺ���Ա�˺Ų����ڣ���ȷ�Ϻ������롣");
			loginBoundary();
			break;
		}
	}
    
// ����Ա��¼��֤
	public int login(String username, String password) {
		if (username.equals(user.getUser())) {
			if (password.equals(user.getPassword())) {
				return 1;// �˺ź�������֤ͨ��
			} else {
				return 0;// �������
			}
		} else {
			return -1;// �˺Ų�����
		}
	}
    @Override
        public void borrowBook() {
		System.out.print("������Ҫ���������");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		int flag = bo.testReader(bookname);
		switch (flag) {
		case 0://���ڴ��鲢���˽�����
 
			System.out.println("����������ߵ����֣�");
			String readername = scanner.nextLine();
			bo.borrow(bookname,readername);
			System.out.println(readername+"�Ӹ�ͼ�����������"+bookname+"Ϊ�����鼮��");
			System.out.print("����0�س����������˵�������1�س���������飺");
			int a0 = scanner.nextInt();
				if(a0==0)
					showMenu();
				if(a0==1)
					borrowBook();
			break;
 
		case 1://���ڴ��鱻������
			System.out.println("����ʧ�ܣ�" + bookname + "�ѱ��裡");
			System.out.print("����0�س����������˵�������1�س���������飺");
			int a = scanner.nextInt();
			switch (a) {
			case 0:
				showMenu();
				break;
 
			case 1:
				borrowBook();
				break;
				
				}
		case -1://�����ڴ�������      
			System.out.println("����ʧ�ܣ�" + bookname + "�����ڸ�ͼ����С�");
			System.out.print("����0�س����������˵�������1�س���������飺");
			int a1 = scanner.nextInt();
			switch (a1) {
			case 0:
				showMenu();
				break;
 
			case 1:
				borrowBook();
				break;
 
			}
}
        }
}

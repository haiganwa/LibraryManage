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

public class LibraryUI {
 private final String accountFileName = "account-lab4.txt";
 
	Bo bo = new Bo();
	// ��ӭ����		
	// ����Ա��¼����	
	// �˵�����չʾ�б�
	public void showMenu() {
		System.out.println("�����빦�ܱ�Ž�����Ӧ�Ĺ��ܣ�");
		System.out.println("���е�ͼ����Ϣ������ţ�1");
		System.out.println("¼���µ��鼮������ţ�2");
		System.out.println("�޸��鼮������Ϣ������ţ�3");
		System.out.println("ɾ���鼮���ܡ�����ţ�4");
		System.out.println("���鹦�ܡ�����ţ�5");
		System.out.println("�鼮���Ĺ��ܡ�����ţ�6");
		System.out.println("�˳�ϵͳ������ţ�7");
		System.out.print("�����빦�ܱ�ţ�");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();//
		switch (a) {
		case 1:// ͼ����Ϣ
			showBook();
			returnMethod();// �������˵�
			break;
		case 2:// ¼�����鼮
			addBook();
			break;
		case 3:// �޸��鼮������Ϣ
			modBookInfo();
			break;
		case 4:// ɾ���鼮
			delete();
			break;
		case 5:// ����
			returnBook();
			break;
		case 6:// ����
			borrowBook();
			break;
		
		}
	}
 
	// �������˵�����
	public void returnMethod() {
		System.out.print("����ENTER�����ص��������˵���");
		Scanner scanner = new Scanner(System.in);
		String i = scanner.nextLine();
		showMenu();
	}
 
	// ͼ����Ϣչʾ����
	public void showBook() {	
            

		bo.showBook();
	}
 
	// ¼�����鼮����
	public void addBook() {
            String content = FileTool.read(accountFileName);
            String[] items = content.split(",");
		System.out.print("������Ҫ���ӵ��鼮���ƣ�");// ����
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		System.out.print("������" + bookname + "�����ߣ�");// ����
		Scanner scanner1 = new Scanner(System.in);
		String author = scanner1.nextLine();
		System.out.print("������" + bookname + "�ĳ������ڣ���ʽ��2000-01-01����");// ��������
		Scanner scanner2 = new Scanner(System.in);
		String pubdate = scanner2.nextLine();
		System.out.print("������" + bookname + "����ҳ����ҳ����");// ��ҳ��
		Scanner scanner3 = new Scanner(System.in);
		String sumpagination = scanner3.nextLine();
		int flag = bo.addBook(bookname, author, pubdate, sumpagination);
		// 1Ϊ�ɹ���0Ϊͼ����Ѿ����ڸ����飬-1Ϊ�ֿⱬ��
		switch (flag) {
		case 1:
			System.out.println("���鼮" + bookname + "��ӳɹ���Ŀǰͼ��ݻ���" + bo.remainSpace() + "��λ�ÿ��Դ�����鼮��");
			returnMethod();// �鼮��ӽ����еķ��ع��ܣ���ѡ�������ӻ��߻ص����˵�
			break;
		case 0:
			System.out.println("����鼮ʧ�ܣ�" + bookname + "�Ѵ��ڸ�ͼ����У�");
			returnMethod();// �鼮��ӽ����еķ��ع��ܣ���ѡ�������ӻ��߻ص����˵�
			break;
		case -1:
			System.out.println("���ʧ�ܣ�ͼ����Ѿ��洢���Ѿ������ˣ���ɾ�������鼮���ٽ�����ӡ�");
			showMenu();
			break;
		}
	}
 
	// �޸��鼮��Ϣ
	public void modBookInfo() {
		System.out.print("��������Ҫ������������");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		// ��������������ص��鼮��Ϣ
		int flag = bo.selectBook(bookname);
		switch (flag) {
		case 0:
			System.out.print("δ�ҵ�����鼮������0�س�����ò㹦�ܣ�����1�س����ص��������˵���");
			int a = scanner.nextInt();
			if (a == 0) {
				modBookInfo();
			} else if (a == 1) {
 
				showMenu();
			}
			break;
 
		case -1:
			System.out.println("����Ϊ�գ�����0�س�����ò㹦�ܣ�����1�س����ص��������˵���");
			int a1 = scanner.nextInt();
			if (a1 == 0) {
				modBookInfo();
			} else {
				showMenu();
			}
			break;
 
		case 1:
			System.out.print("������ϢΪ����������ҵĽ�������У����֡�1���������������֡�2���������ߣ����֡�3������������ڣ����֡�4��������ҳ�������֡�5����������ߣ�����������ֿ����޸������Ϣ��");
			int a2 = scanner.nextInt();// 1���� 2���� 3�������� 4��ҳ�� 5������
			if (a2 > 0 && a2 < 6) {
				System.out.print("�����������޸ĵ�" + sortName(a2) + "��");
				Scanner scanner2 = new Scanner(System.in);
				String value = scanner2.nextLine();
				int index = bo.selectIndex(bookname);
				bo.modinfo(a2, value, index);
				System.out.println(bookname + "�Ȿ��������Ϣ�޸ĳɹ���");
				returnMethod();
			} else {
				System.out.println("����������ֲ��Ϸ��������ԣ�");
				modBookInfo();
			}
 
			break;
 
		}
	}
 
	// �޸ĵķ�������
	public String sortName(int flag) {
		if (flag == 1)
			return "����";
		if (flag == 2)
			return "����";
		if (flag == 3)
			return "��������";
		if (flag == 4)
			return "��ҳ��";
		else
			return "������";
	}
 
	// ɾ���鼮����
	public void delete() {
		System.out.print("������Ҫ��ɾ����������");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		int flag = bo.testReader(bookname);
		// ���ڴ��鲢���˽�
		if (flag == 0) {
			bo.deleteBook(bookname);
			System.out.println(bookname + "�Ѵ�ͼ��ݳɹ��Ƴ�������0�ص����˵�������1�����ɾ��");
			delReturn();
		} else if (flag == 1) {// ���˽�
			System.out.println("�����ѽ������ȴ��黹����ɾ��������0�ص����˵�������1�����ɾ��");
			delReturn();
		} else {// �����ڴ���
			System.out.println("���ݲ����ڴ��飬����ϸ�϶ԡ�����0�ص����˵�������1�����ɾ��");
			delReturn();
		}
 
	}
 
	// ɾ���ķ��ز���
	public void delReturn() {
 
		Scanner scanner1 = new Scanner(System.in);
		int i = scanner1.nextInt();
		if (i == 0) {
			showMenu();
		} else if (i == 1) {
			delete();
		}
	}
 
	// ���鹦��
	public void returnBook() {
		System.out.print("������Ҫ�����鼮���ƣ�");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		int flag = bo.testReader(bookname);
		if (flag == 0) {
			System.out.println(bookname + "��δ�����");
			System.out.print("����0�س����������˵����������������������");
			String a = scanner.nextLine();
			if(a.equals("0")){
				showMenu();
			}else {
				returnBook();
			}
		} else if (flag == -1) {
			System.out.println(bookname + "�����ڸ�ͼ����С�");
			System.out.print("����0�س����������˵����������������������");
			String a = scanner.nextLine();
			if(a.equals("0")){
				showMenu();
			}else {
				returnBook();
			}
		} else if (flag == 1) {
 
			System.out.println(bo.getBorrowReader(bookname) + "�Ѿ�����ɹ���");
			bo.setBorrowReader(bookname);
			System.out.print("����0�س����������˵����������������������");
			String a = scanner.nextLine();
			if(a.equals("0")){
				showMenu();
			}else {
				returnBook();
			}
		}
	}
 public boolean saveAccount(Bo account) {
       String content =  ",";
       return FileTool.write(accountFileName, content);
   }
	// �鼮���Ĺ���
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
		
			}
		}
	}


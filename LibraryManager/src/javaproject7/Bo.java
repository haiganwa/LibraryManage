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
public class Bo {
	public static BookData book = new BookData();
	/*
	 * �˵�����չʾ�б�
	 * 
	 * ͼ����Ϣչʾ����
	 */
	public void showBook() {
		System.out.println("��ͼ��ݹ���" + (book.booknames.length - remainSpace()) + "����");
		int a = bookinfo();
		if (a == 0) {
			// չʾ����ͼ����Ϣ
			showAll();
		} else if (a > 0 && a <= book.booknames.length) {
			// չʾ���ͼ����Ϣ
			showPart(a);
		} else {
			System.out.println("����ı�Ų��Ϸ���");
			showBook();
		}
	}
	// չʾ����ͼ����Ϣ
	public void showAll() {
		for (int i = 0; i < book.booknames.length; i++) {
			if (book.booknames[i] != null) {
				System.out.println("---------------------------------------���" + (i + 1)
						+ "--------------------------------------------------------------");
				System.out.println("�鼮���Ϊ" + (i + 1) + "����ϸ��ϢΪ��");
				System.out.print("������" + book.booknames[i] + " ");
				System.out.print("���ߣ�" + book.authors[i] + " ");
				System.out.print("�������ڣ�" + book.pubdates[i] + " ");
				System.out.print("��ҳ����" + book.sumpaginations[i] + " ");
				System.out.println("�����ߣ�" + book.borrowreaders[i]+" ");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
	}
	// չʾ���ͼ����Ϣ
	public void showPart(int a) {
		int i = a;
		System.out.println(
				"---------------�ֽ���---------------------------------------------------------------------------------------------------");
		System.out.println("�鼮���" + (i) + "����ϸ��ϢΪ��");
		System.out.print("������" + book.booknames[i - 1] + " ");
		System.out.println("���ߣ�" + book.authors[i - 1] + " ");
		System.out.print("�������ڣ�" + book.pubdates[i - 1] + " ");
		System.out.print("��ҳ����" + book.sumpaginations[i - 1] + " ");
		System.out.println("�����ߣ�" + book.borrowreaders[i - 1]+" ");
		System.out.println(
				"---------------------------------------------------------------�ֽ���---------------------------------------------------");
	}
	//���ݱ���ж�Ҫȫ��չʾ���ǲ���չʾ
	public int bookinfo() {
		for (int i = 0; i < book.booknames.length; i++) {
			if (book.booknames[i] != null) {
				System.out.println("�������" + (i + 1) + "��" + book.booknames[i] + " ");
			}
		}
		System.out.print("������Ӧ��ż��ɲ鿴��Ӧ�鼮����ϸ��Ϣ(����0��鿴������Ϣ)��");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		return i;
	}
	// ¼�����鼮�ж�
	public int addBook(String bookname, String author, String pubdate, String sumpagination) {
		int flag = 0;// 1Ϊ�ɹ���0Ϊͼ����Ѿ����ڸ����飬-1Ϊ�ֿⱬ��
		if (book.booknames[book.booknames.length - 1] != null) {
			flag = -1;// ����
		}
		if (book.booknames[book.booknames.length - 1] == null) {
 
			for (int i = 0; i < book.booknames.length; i++) {
 
				if (bookname.equals(book.booknames[i])) {
					flag = 0;// �Ѵ���book.booknames[i]
					break;
				}
				if (!(bookname.equals(book.booknames[i]))) {
					// ����鼮
					add(bookname, author, pubdate, sumpagination);
					flag = 1;// �ɹ�
					break;
				}
			}
		}
		return flag;
	}
	// ¼�����鼮
	public void add(String bookname, String author, String pubdate, String sumpagination) {
		for (int i = 0; i < book.booknames.length; i++) {
			if (book.booknames[i] == null) {
				book.booknames[i] = bookname;
				book.authors[i] = author;
				book.pubdates[i] = pubdate;
				book.sumpaginations[i] = sumpagination;
				break;
			}
		}
	}
	// ����鱾��ʣ������
	public int remainSpace() {
		int count = 0;
		try {
			for (int i = 0; i < book.booknames.length; i++) {
				if (book.booknames[i] == null) {
					++count;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	// �޸�ʱ��������������ص��鼮��Ϣ
	public int selectBook(String bookname) {
		int flag = 0;
		for (int i = 0; i < book.booknames.length; i++) {
			if (bookname.equals("")) {
				flag = -1;// -1Ϊδ��������
				break;
			}
			// ���������Ϊƥ������ͼ��
			if (bookname.equals(book.booknames[i])) {
				flag = 1;// 1�ҵ��������
				showPart(i + 1);
				break;
			}
			if (!bookname.equals(book.booknames[i])) {
				if (i == book.booknames.length - 1) {
					flag = 0;// 0Ϊδ�ҵ�
				}
			}
		}
		return flag;
	}
	// �������������������д��鷵���������޷�-1
	public int selectIndex(String bookname) {
		int flag = -1;
		for (int i = 0; i < book.booknames.length; i++) {
			if (bookname.equals(book.booknames[i])) {
				flag = i;
			}
		}
		return flag;// �Ҳ�������
	}
	// �޸��鼮��Ϣ 1���� 2���� 3�������� 4��ҳ�� 5������
	public void modinfo(int a, String value, int index) {
 
		switch (a) {
		case 1:
			book.booknames[index] = value;
			break;
 
		case 2:
			book.authors[index] = value;
			break;
		case 3:
			book.pubdates[index] = value;
			break;
		case 4:
			book.sumpaginations[index] = value;
			break;
		case 5:
			book.borrowreaders[index] = value;
			break;
		}
 
	}
	// ɾ���鼮����
	public void deleteBook(String bookname) {
		int a = selectIndex(bookname);
		book.booknames[a] = null;
		book.authors[a] = null;
		book.pubdates[a] = null;
		book.sumpaginations[a] = null;
		book.booknames[a] = null;
 
	}
	// ������Ƿ���ڹ�����Ƿ��ѽ��
	public int testReader(String bookname) {
 
		// �����д��飬���Ҵ�����������д���a>=0���޷�-1
		int a = selectIndex(bookname);
		// �����д���
		if (a >= 0) {
			if ((book.borrowreaders[a].equals("��") || book.borrowreaders[a].equals("")))// ���˽���飬""Ϊɨ������ֱ�ӻس�ֵ
				return 0;//δ��
			else
				return 1;//�ѽ�
		} else {
			return -1;// ����û�д���
		}
 
	}
	//������������Ϊ�޻���Ϊ��
	public void setBorrowReader(String bookname){
		int a = selectIndex(bookname);
		book.borrowreaders[a]="��";
	}
	//��ѯָ����Ľ�����
	public String getBorrowReader(String bookname){
		int a = selectIndex(bookname);
		return book.borrowreaders[a];
	}
 
	//�鼮���Ĺ���
	    public void borrow(String bookname,String readername){
		int a = selectBook(bookname);
		book.borrowreaders[a]=readername;
}
	}


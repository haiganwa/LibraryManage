/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject7;

/**
 *
 * @author dell
 */
public class BookData {
	//��� 
    
	public BookData() {
		{ 
			String noreaders= "��";
			for (int i = 0; i < borrowreaders.length; i++) {
				borrowreaders[i]=noreaders;
			}
			for (int i = 0; i < 5; i++) {
				switch (i) {
				case 0:
					booknames[i]="֩����";
					authors[i]="�ܿ�";
					pubdates[i]="2016-03-31";
					sumpaginations[i]="1320";
					break;
				case 1:
					booknames[i]="��������";
					authors[i]="����";
					pubdates[i]="2017-07-25";
					sumpaginations[i]="6156";
					break;
				case 2:
					booknames[i]="��Ӱ����";
					authors[i]="��������";
					pubdates[i]="2016-01-31";
					sumpaginations[i]="1120";
					break;
				case 3:
					booknames[i]="�ܳ�û";
					authors[i]="��ͷǿ";
					pubdates[i]="2017-04-04";
					sumpaginations[i]="1310";
					break;
				case 4:
					booknames[i]="����������";
					authors[i]="������";
					pubdates[i]="2012-08-20";
					sumpaginations[i]="954";
					break;
				}
			}
													
		}
	}
 
	public String[] booknames = new String[100];// ����
	public String[] authors = new String[100];// ����
	public String[] pubdates = new String[100];// ��������
	public String[] sumpaginations = new String[100];// ��ҳ��
	public String[] borrowreaders = new String[100];// ������
 
}


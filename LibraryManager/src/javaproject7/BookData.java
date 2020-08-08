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
	//书库 
    
	public BookData() {
		{ 
			String noreaders= "无";
			for (int i = 0; i < borrowreaders.length; i++) {
				borrowreaders[i]=noreaders;
			}
			for (int i = 0; i < 5; i++) {
				switch (i) {
				case 0:
					booknames[i]="蜘蛛侠";
					authors[i]="杰克";
					pubdates[i]="2016-03-31";
					sumpaginations[i]="1320";
					break;
				case 1:
					booknames[i]="我欲封天";
					authors[i]="耳根";
					pubdates[i]="2017-07-25";
					sumpaginations[i]="6156";
					break;
				case 2:
					booknames[i]="火影忍者";
					authors[i]="漩涡鸣人";
					pubdates[i]="2016-01-31";
					sumpaginations[i]="1120";
					break;
				case 3:
					booknames[i]="熊出没";
					authors[i]="光头强";
					pubdates[i]="2017-04-04";
					sumpaginations[i]="1310";
					break;
				case 4:
					booknames[i]="复仇者联盟";
					authors[i]="钢铁侠";
					pubdates[i]="2012-08-20";
					sumpaginations[i]="954";
					break;
				}
			}
													
		}
	}
 
	public String[] booknames = new String[100];// 书名
	public String[] authors = new String[100];// 作者
	public String[] pubdates = new String[100];// 出版日期
	public String[] sumpaginations = new String[100];// 总页数
	public String[] borrowreaders = new String[100];// 借阅人
 
}


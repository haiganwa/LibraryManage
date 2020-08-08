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
	 * 菜单功能展示列表
	 * 
	 * 图书信息展示功能
	 */
	public void showBook() {
		System.out.println("本图书馆共有" + (book.booknames.length - remainSpace()) + "本书");
		int a = bookinfo();
		if (a == 0) {
			// 展示所有图书信息
			showAll();
		} else if (a > 0 && a <= book.booknames.length) {
			// 展示相关图书信息
			showPart(a);
		} else {
			System.out.println("输入的编号不合法！");
			showBook();
		}
	}
	// 展示所有图书信息
	public void showAll() {
		for (int i = 0; i < book.booknames.length; i++) {
			if (book.booknames[i] != null) {
				System.out.println("---------------------------------------编号" + (i + 1)
						+ "--------------------------------------------------------------");
				System.out.println("书籍编号为" + (i + 1) + "的详细信息为：");
				System.out.print("书名：" + book.booknames[i] + " ");
				System.out.print("作者：" + book.authors[i] + " ");
				System.out.print("出版日期：" + book.pubdates[i] + " ");
				System.out.print("总页数：" + book.sumpaginations[i] + " ");
				System.out.println("借阅者：" + book.borrowreaders[i]+" ");
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
	}
	// 展示相关图书信息
	public void showPart(int a) {
		int i = a;
		System.out.println(
				"---------------分界线---------------------------------------------------------------------------------------------------");
		System.out.println("书籍编号" + (i) + "的详细信息为：");
		System.out.print("书名：" + book.booknames[i - 1] + " ");
		System.out.println("作者：" + book.authors[i - 1] + " ");
		System.out.print("出版日期：" + book.pubdates[i - 1] + " ");
		System.out.print("总页数：" + book.sumpaginations[i - 1] + " ");
		System.out.println("借阅者：" + book.borrowreaders[i - 1]+" ");
		System.out.println(
				"---------------------------------------------------------------分界线---------------------------------------------------");
	}
	//根据编号判断要全局展示还是部分展示
	public int bookinfo() {
		for (int i = 0; i < book.booknames.length; i++) {
			if (book.booknames[i] != null) {
				System.out.println("书名编号" + (i + 1) + "：" + book.booknames[i] + " ");
			}
		}
		System.out.print("输入相应编号即可查看相应书籍的详细信息(输入0则查看所有信息)：");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		return i;
	}
	// 录入新书籍判断
	public int addBook(String bookname, String author, String pubdate, String sumpagination) {
		int flag = 0;// 1为成功，0为图书馆已经存在该新书，-1为仓库爆满
		if (book.booknames[book.booknames.length - 1] != null) {
			flag = -1;// 爆满
		}
		if (book.booknames[book.booknames.length - 1] == null) {
 
			for (int i = 0; i < book.booknames.length; i++) {
 
				if (bookname.equals(book.booknames[i])) {
					flag = 0;// 已存在book.booknames[i]
					break;
				}
				if (!(bookname.equals(book.booknames[i]))) {
					// 添加书籍
					add(bookname, author, pubdate, sumpagination);
					flag = 1;// 成功
					break;
				}
			}
		}
		return flag;
	}
	// 录入新书籍
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
	// 存放书本的剩余容量
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
	// 修改时根据书名查找相关的书籍信息
	public int selectBook(String bookname) {
		int flag = 0;
		for (int i = 0; i < book.booknames.length; i++) {
			if (bookname.equals("")) {
				flag = -1;// -1为未输入书名
				break;
			}
			// 其他情况下为匹配馆里的图书
			if (bookname.equals(book.booknames[i])) {
				flag = 1;// 1找到相关书名
				showPart(i + 1);
				break;
			}
			if (!bookname.equals(book.booknames[i])) {
				if (i == book.booknames.length - 1) {
					flag = 0;// 0为未找到
				}
			}
		}
		return flag;
	}
	// 根据书名查找索引，有此书返其索引，无返-1
	public int selectIndex(String bookname) {
		int flag = -1;
		for (int i = 0; i < book.booknames.length; i++) {
			if (bookname.equals(book.booknames[i])) {
				flag = i;
			}
		}
		return flag;// 找不到此书
	}
	// 修改书籍信息 1书名 2作者 3出版日期 4总页数 5借阅者
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
	// 删除书籍功能
	public void deleteBook(String bookname) {
		int a = selectIndex(bookname);
		book.booknames[a] = null;
		book.authors[a] = null;
		book.pubdates[a] = null;
		book.sumpaginations[a] = null;
		book.booknames[a] = null;
 
	}
	// 检查书是否存在馆里和是否已借出
	public int testReader(String bookname) {
 
		// 馆里有此书，查找此书的索引，有此书a>=0，无返-1
		int a = selectIndex(bookname);
		// 馆里有此书
		if (a >= 0) {
			if ((book.borrowreaders[a].equals("无") || book.borrowreaders[a].equals("")))// 无人借此书，""为扫描器的直接回车值
				return 0;//未借
			else
				return 1;//已借
		} else {
			return -1;// 馆里没有此书
		}
 
	}
	//将借阅者设置为无或者为空
	public void setBorrowReader(String bookname){
		int a = selectIndex(bookname);
		book.borrowreaders[a]="无";
	}
	//查询指定书的借阅者
	public String getBorrowReader(String bookname){
		int a = selectIndex(bookname);
		return book.borrowreaders[a];
	}
 
	//书籍借阅功能
	    public void borrow(String bookname,String readername){
		int a = selectBook(bookname);
		book.borrowreaders[a]=readername;
}
	}


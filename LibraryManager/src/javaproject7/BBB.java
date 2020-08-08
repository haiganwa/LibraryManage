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
		System.out.println("************图书馆管理系统********");
		System.out.println("*********************************");
		loginBoundary();// 登录界面
    }

    public void loginBoundary() {
		System.out.print("管理员账号：");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.print("登 录 密 码 ：");
		Scanner scanner1 = new Scanner(System.in);
		String password = scanner1.nextLine();
		int flag = login(username, password);// 登录验证
		switch (flag) {
		case 0:// 密码错误
			System.out.println("密码错误，请重新输入。");
			loginBoundary();
			break;
 
		case 1:// 验证通过
			System.out.println("登录成功！");     
                        showMenu();
			break;
		case -1:// 账户不存在
			System.out.println("您输入的管理员账号不存在，请确认后再输入。");
			loginBoundary();
			break;
		}
	}
    
// 管理员登录验证
	public int login(String username, String password) {
		if (username.equals(user.getUser())) {
			if (password.equals(user.getPassword())) {
				return 1;// 账号和密码验证通过
			} else {
				return 0;// 密码错误
			}
		} else {
			return -1;// 账号不存在
		}
	}
    @Override
        public void borrowBook() {
		System.out.print("请输入要借的书名：");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		int flag = bo.testReader(bookname);
		switch (flag) {
		case 0://存在此书并无人借的情况
 
			System.out.println("请输入借阅者的名字：");
			String readername = scanner.nextLine();
			bo.borrow(bookname,readername);
			System.out.println(readername+"从该图书馆里借出了以"+bookname+"为名的书籍。");
			System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
			int a0 = scanner.nextInt();
				if(a0==0)
					showMenu();
				if(a0==1)
					borrowBook();
			break;
 
		case 1://存在此书被借的情况
			System.out.println("借书失败，" + bookname + "已被借！");
			System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
			int a = scanner.nextInt();
			switch (a) {
			case 0:
				showMenu();
				break;
 
			case 1:
				borrowBook();
				break;
				
				}
		case -1://不存在此书的情况      
			System.out.println("借书失败，" + bookname + "不存在该图书馆中。");
			System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
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

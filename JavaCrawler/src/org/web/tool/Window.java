package org.web.tool;
/* 
* 程序头部注释开始   
* 程序的版权和版本声明部分   
* Copyright (c) 2011, 烟台大学计算机学院学生   
* All rights reserved.   
* 文件名称：一个带菜单的窗口                                
* 作    者：薛广晨                               
* 完成日期：2011  年 09 月  10  日   
* 版 本号：x1.0            
   
* 对任务及求解方法的描述部分   
* 输入描述：  
* 问题描述:
  
* 程序输出：   
* 程序头部的注释结束 
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class FirstWindow extends JFrame	
{

	JTextArea prompt;
	Button btn;
	JScrollPane jsp;
	FirstWindow(String s)
	{
		setLayout(null);
		setTitle(s);
		Toolkit tool = getToolkit();
		Dimension dim = tool.getScreenSize();
		setBounds(0, 0, 510, 450);
		btn=new Button("刷新");
		prompt=new JTextArea("hello\n world");
		
//		Rule rule = new Rule("https://list.lu.com/list/all",
//				null, null,
//				"product-list", Rule.CLASS, Rule.GET);
//		List<LinkTypeData> extracts = ExtractService.extract(rule);
//		printf(extracts);
		
		jsp = new JScrollPane(prompt);

		
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Rule rule = new Rule("https://list.lu.com/list/all",null, null,"product-list", Rule.CLASS, Rule.GET);
				List<LinkTypeData> extracts = ExtractService.extract(rule);
				printf(extracts);
				
			}
		});
		btn.setBounds(100, 90, 300, 30);
		jsp.setBounds(0, 200, 500, 200);
		

		add(btn);
		add(jsp);

//		menubar = new MenuBar();
//		menu = new Menu("文件");
//		item1 = new MenuItem("打开");
//		item2 = new MenuItem("保存");
//		menu.add(item1);
//		menu.add(item2);
//		menubar.add(menu);
//		setMenuBar(menubar);
		setResizable(false);
		setVisible(true);	
	}

	public void printf(List<LinkTypeData> datas)
	{
		String str="";
		for (LinkTypeData data : datas)
		{
			str+=data.getLinkText()+"     ";
			str+=data.getInterestRate()+"     ";
			str+=data.getRate()+"\n";
//			System.out.println(data.getLinkHref());
			str+="***********************************\n";
		}
		prompt.setText(str);

	}
		
}


public class Window {
	
	public static void main(String args[])
    {
		FirstWindow win = new FirstWindow("p2p原始界面");

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

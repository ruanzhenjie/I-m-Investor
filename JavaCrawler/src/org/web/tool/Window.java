package org.web.tool;
/* 
* ����ͷ��ע�Ϳ�ʼ   
* ����İ�Ȩ�Ͱ汾��������   
* Copyright (c) 2011, ��̨��ѧ�����ѧԺѧ��   
* All rights reserved.   
* �ļ����ƣ�һ�����˵��Ĵ���                                
* ��    �ߣ�Ѧ�㳿                               
* ������ڣ�2011  �� 09 ��  10  ��   
* �� ���ţ�x1.0            
   
* ��������ⷽ������������   
* ����������  
* ��������:
  
* ���������   
* ����ͷ����ע�ͽ��� 
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
		btn=new Button("ˢ��");
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
//		menu = new Menu("�ļ�");
//		item1 = new MenuItem("��");
//		item2 = new MenuItem("����");
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
		FirstWindow win = new FirstWindow("p2pԭʼ����");

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

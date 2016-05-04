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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;



class FirstWindow extends JFrame	
{

	JTextArea prompt;
	Button btn,rushBuyBtn;
	JScrollPane jsp;
	ProjectFilter projectFilter,rushProjectFilter;

	JLabel periodJL[];
	JLabel modeJL[];
	JLabel amountJL[];
	
	Boolean rushflag=true;
	
	JLabel lblNewLabel;
	
	public void setmode(int a,int b) {
		int i;
		switch (a) {
		case 0:
			for(i=0;i<3;i++){
				if(b==i){
					periodJL[i].setForeground(Color.BLUE);
				}
				else{
					periodJL[i].setForeground(Color.BLACK);
				}
			}
			break;
		case 1:
			for(i=0;i<3;i++){
				if(b==i){
					modeJL[i].setForeground(Color.BLUE);
				}
				else{
					modeJL[i].setForeground(Color.BLACK);
				}
			}
			break;
		case 2:
			for(i=0;i<3;i++){
				if(b==i){
					amountJL[i].setForeground(Color.BLUE);
				}
				else{
					amountJL[i].setForeground(Color.BLACK);
				}
			}
			break;

		default:
			break;
		}
	}
	
	FirstWindow(String s)
	{
		setLayout(null);
		setTitle(s);
		Toolkit tool = getToolkit();
		Dimension dim = tool.getScreenSize();
		setBounds(0, 0, 510, 450);
		btn=new Button("ˢ��");
		rushBuyBtn=new Button("��ʼ����");
		prompt=new JTextArea("We Are Invester");
		projectFilter=new ProjectFilter();
		

		
		
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(421, 25, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�����ۻ�����ʱ�䣨s����");
		lblNewLabel_1.setBounds(360, 10, 150, 15);
		add(lblNewLabel_1);

		rushBuyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(rushflag)
				{
					synchronized (rushflag) {
						//rushflag=false;
						rushflag=false;
						rushBuyBtn.setLabel("ֹͣ����");
					}

					new Thread() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							// super.run();
							int c=0;
							while (true) {
								synchronized (rushflag) {
									//rushflag=false;
									if(rushflag)
										break;
								}
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								lblNewLabel.setText((c++)+"");
							}
						}
					}.start();
					
					new Thread() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							// super.run();
							rushProjectFilter = new ProjectFilter(projectFilter);
							Rule rule = new Rule(rushProjectFilter.getURL(), null, null,"product-list", Rule.CLASS, Rule.GET);
							while (true) {
								synchronized (rushflag) {
									//rushflag=false;
									if(rushflag)
										break;
								}
								
								// Rule rule = new
								// Rule("https://list.lu.com/list/p2p?minMoney=&maxMoney=&minDays=0&maxDays=180&minRate=&maxRate=&mode=&tradingMode=&isCx=&currentPage=1&orderCondition=&isShared=&canRealized=&productCategoryEnum=",null,
								// null,"product-list", Rule.CLASS, Rule.GET);
								List<ProjectData> extracts = ExtractService
										.extract(rule);
								if (extracts.size() != 0) {
									String str="";
									for (ProjectData data : extracts)
									{
										str+=data.getLinkText()+"\n";
										str+="Ԥ���껯����\t"+data.getInterestRate()+"\n";
										//str+=data.getRate()+"\n";
										str+="Ͷ������\t"+data.getInvestPeriod()+"\n";
										str+="���淽ʽ\t"+data.getCollectionMode()+"\n";
										str+="Ͷ�ʽ��\t"+data.getProductAmount()+"\n";
//										System.out.println(data.getLinkHref());
										str+="***********************************\n";
									}
									prompt.setText(str+"������������Ŀ��\n");
									synchronized (rushflag) {
										//rushflag=false;
										rushflag=true;
										rushBuyBtn.setLabel("��ʼ����");
									}
									break;

								}
							}
						}
					}.start();
				}
				else{
					synchronized (rushflag) {
						//rushflag=false;
						rushflag=true;
						rushBuyBtn.setLabel("��ʼ����");
					}
				}
			}
		});
		
		rushBuyBtn.setBounds(150, 160, 100, 30);
		add(rushBuyBtn);
		
		jsp = new JScrollPane(prompt);
		
		

		periodJL=new JLabel[3];
		
		periodJL[0]=new JLabel("Ͷ�����޲���");
		periodJL[0].setBounds(39, 25, 90, 15);
		periodJL[0].addMouseListener(new JLListener(0, 0, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setPeriod("", "");
			}
		}));
		
		periodJL[1]=new JLabel("6��������");
		periodJL[1].setBounds(143, 25, 90, 15);
		periodJL[1].addMouseListener(new JLListener(0, 1, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setPeriod("0","180");
			}
		}));
		
		periodJL[2]=new JLabel("6~12����");
		periodJL[2].setBounds(256, 25, 90, 15);
		periodJL[2].addMouseListener(new JLListener(0, 2, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setPeriod("180","360");
			}
		}));
		
		modeJL=new JLabel[3];

		modeJL[0]=new JLabel("���淽ʽ����");
		modeJL[0].setBounds(39, 66, 90, 15);
		modeJL[0].addMouseListener(new JLListener(1, 0, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setMode("");
			}
		}));
		
		modeJL[1]=new JLabel("ÿ�µȶϢ");
		modeJL[1].setBounds(143, 66, 90, 15);
		modeJL[1].addMouseListener(new JLListener(1, 1, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setMode("MONTHLY_AVERAGE_CAPITAL_PLUS_INTEREST");
			}
		}));
		
		modeJL[2]=new JLabel("һ���Ի���Ϣ");
		modeJL[2].setBounds(256, 66, 90, 15);
		modeJL[2].addMouseListener(new JLListener(1, 2, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setMode("ONE_TIME_CAPITAL_PLUS_INTEREST");
			}
		}));

		amountJL=new JLabel[3];

		amountJL[0]=new JLabel("��Ͷ����");
		amountJL[0].setBounds(39, 109, 90, 15);
		amountJL[0].addMouseListener(new JLListener(2, 0, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setAmount("", "");
			}
		}));

		amountJL[1]=new JLabel("һ��Ԫ����");
		amountJL[1].setBounds(143, 109, 90, 15);
		amountJL[1].addMouseListener(new JLListener(2, 1, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setAmount("0", "10000");
			}
		}));

		amountJL[2]=new JLabel("1��~5��Ԫ");
		amountJL[2].setBounds(256, 109, 90, 15);
		amountJL[2].addMouseListener(new JLListener(2, 2, new JLInterface() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				projectFilter.setAmount("10000", "50000");
			}
		}));
		

		for (JLabel JLB : periodJL) {
			add(JLB);
		}
		for (JLabel JLB : modeJL) {
			add(JLB);
		}
		for (JLabel JLB : amountJL) {
			add(JLB);
		}

		setmode(0, 0);
		setmode(1, 0);
		setmode(2, 0);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Rule rule = new Rule("https://list.lu.com/list/all",null, null,"product-list", Rule.CLASS, Rule.GET);
				//Rule rule = new Rule("https://list.lu.com/list/p2p",null, null,"product-list", Rule.CLASS, Rule.GET);
				Rule rule = new Rule(projectFilter.getURL(),null, null,"product-list", Rule.CLASS, Rule.GET);
				//Rule rule = new Rule("https://list.lu.com/list/p2p?minMoney=&maxMoney=&minDays=0&maxDays=180&minRate=&maxRate=&mode=&tradingMode=&isCx=&currentPage=1&orderCondition=&isShared=&canRealized=&productCategoryEnum=",null, null,"product-list", Rule.CLASS, Rule.GET);
				List<ProjectData> extracts = ExtractService.extract(rule);
				printf(extracts);
				
			}
		});
		btn.setBounds(10, 160, 100, 30);
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

	public void printf(List<ProjectData> datas)
	{
		String str="";
		for (ProjectData data : datas)
		{
			str+=data.getLinkText()+"\n";
			str+="Ԥ���껯����\t"+data.getInterestRate()+"\n";
			//str+=data.getRate()+"\n";
			str+="Ͷ������\t"+data.getInvestPeriod()+"\n";
			str+="���淽ʽ\t"+data.getCollectionMode()+"\n";
			str+="Ͷ�ʽ��\t"+data.getProductAmount()+"\n";
//			System.out.println(data.getLinkHref());
			str+="***********************************\n";
		}
		prompt.setText(str);

	}
	
	interface JLInterface{
		void onclick();
	}
	
	class JLListener implements MouseListener{
		private JLInterface minterface=null;
		private int r,l;
		
		JLListener(int a,int b,JLInterface m_interface){
			minterface=m_interface;
			r=a;
			l=b;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(minterface!=null){
				minterface.onclick();
			}
			setmode(r, l);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


public class Window {
	
	public static void main(String args[])
    {
		FirstWindow win = new FirstWindow("p2pԭʼ����");

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
        
    }

}

import java.sql.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class Employee implements ActionListener,KeyListener
{		
	Connection con;
	ResultSet rs;
	JFrame frmobj,frmsearch,frmnum,frmnamesrc,frmname;
	GridLayout gridobj,gridobj1,gridobj2;
	JLabel lbln,lblnm,lblage,lblgen,lblq,lblhb,number,nm,nm1;
	JTextField txtn,txtfn,txtmn,txtln,txtage,txt,txtnum,txtname;
	JRadioButton rbmale,rbfemale;
	ButtonGroup bg;
	JComboBox cbx,txtname1;
	JCheckBox cbs,cbr,cbc;
	String[] Stream={"---SELECT---","Diploma","Graduate","Post Graduate"};
	JPanel pnlgen,pnlhb,pnlbtn1,pnlbtn2,pnlname,pnlsearch;
	JButton subnum,subname,searchname,btnf,btnpr,btnnxt,btnl,btnadd,btnup,btndel,btnsrc,btns,btncan,btne,name,no;
	
	public void sqlop()
	{	try
		{
			con=DriverManager.getConnection("jdbc:sqlserver://VAIO;databaseName=Employee","sa","pass123");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select * from Emp");
		}catch(Exception e)
		{
			System.out.println(e);
		} 
	}

	public void createComp()
	{
		frmobj=new JFrame("Employee Details");
		gridobj=new GridLayout(7,3);
		gridobj1=new GridLayout(1,2);
		gridobj2=new GridLayout(1,3);
		lbln=new JLabel("Enter Employee Number");
		txtn=new JTextField(10);
		lblnm=new JLabel("Enter Employee Name");
		pnlname=new JPanel();
		txtfn=new JTextField(15);
		txtfn.setText("First Name");
		txtfn.setForeground(Color.gray);
		txtmn=new JTextField(15);
		txtmn.setText("Middle Name");
		txtmn.setForeground(Color.gray);
		txtln=new JTextField(15);
		txtln.setText("Last Name");
		txtln.setForeground(Color.gray);
		lblage=new JLabel("Enter your age");
		txtage=new JTextField(10);
		pnlgen=new JPanel();
		lblgen=new JLabel("Select Gender");
		rbmale=new JRadioButton("Male");
		rbfemale=new JRadioButton("Female");
		lblq=new JLabel("Select Qualification");
		cbx=new JComboBox(Stream);
		pnlhb=new JPanel();
		lblhb=new JLabel("Select Hobby");
		cbs=new JCheckBox("Singing");
		cbr=new JCheckBox("Reading");
		cbc=new JCheckBox("Cycling");
		pnlbtn1=new JPanel();
		pnlbtn2=new JPanel();
		btnf=new JButton("FIRST");
		btnpr=new JButton("PREVIOUS");
		btnnxt=new JButton("NEXT");
		btnl=new JButton("LAST");
		btnadd=new JButton("ADD");		
		btnup=new JButton("UPDATE");
		btndel=new JButton("DELETE");
		btnsrc=new JButton("SEARCH");
		btns=new JButton("SAVE");
		btne=new JButton("EXIT");
		btncan=new JButton("CANCEL");
	}
	public void displayComp()
	{
		frmobj.setLayout(gridobj);
		frmobj.add(lbln);
		frmobj.add(txtn);
		frmobj.add(lblnm);
		frmobj.add(pnlname);
		pnlname.setLayout(gridobj2);
		pnlname.add(txtfn);
		pnlname.add(txtmn);
		pnlname.add(txtln);
		frmobj.add(lblage);
		frmobj.add(txtage);
		frmobj.add(lblgen);
		frmobj.add(pnlgen);
		pnlgen.setLayout(gridobj1);
		pnlgen.add(rbmale);
		pnlgen.add(rbfemale);
		frmobj.add(lblq);
		frmobj.add(cbx);
		frmobj.add(lblhb);
		frmobj.add(pnlhb);	
		pnlhb.setLayout(gridobj2);
		pnlhb.add(cbs);
		pnlhb.add(cbr);
		pnlhb.add(cbc);
		frmobj.add(pnlbtn1);
		frmobj.add(pnlbtn2);
		pnlbtn1.add(btnf);
		pnlbtn1.add(btnpr);
		pnlbtn1.add(btnnxt);
		pnlbtn1.add(btnl);
		pnlbtn2.add(btnadd);
		pnlbtn2.add(btnup);
		pnlbtn2.add(btndel);
		pnlbtn2.add(btnsrc);
		pnlbtn2.add(btns);
		pnlbtn2.add(btncan);
		pnlbtn2.add(btne);
		frmobj.setSize(200,200);
		frmobj.setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(btns))
		{
			if(txtn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(frmobj,"Enter employee number","error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(txtfn.getText().equals("First Name")||txtmn.getText().equals("Middle Name")||txtln.getText().equals("Last Name"))
			{
				JOptionPane.showMessageDialog(frmobj,"Enter name","error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(txtage.getText().equals(""))
			{
				JOptionPane.showMessageDialog(frmobj,"Enter age","error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(!(rbmale.isSelected()||rbfemale.isSelected()))
			{
				JOptionPane.showMessageDialog(frmobj,"Gender","error",JOptionPane.ERROR_MESSAGE);	
			}

			else if(cbx.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(frmobj,"Qualification","error",JOptionPane.ERROR_MESSAGE);		
			}
			else if(!(cbs.isSelected()||cbr.isSelected()||cbc.isSelected()))
			{
				JOptionPane.showMessageDialog(frmobj,"Hobby","error",JOptionPane.ERROR_MESSAGE);	
			}	
		}
		if(ae.getSource().equals(btnf))
		{
			try
			{
				//sqlop();
				rs.first();
				getDet();
			}catch(Exception e){}
		}
		if(ae.getSource().equals(btnpr))
		{
			try
			{
				rs.previous();
			}catch(Exception e){}
			getDet();
		}
		if(ae.getSource().equals(btnnxt))
		{
			try
			{
				rs.next();
			}catch(Exception e){}
			getDet();
		}
		if(ae.getSource().equals(btnl))
		{
			try
			{
				//sqlop();
				rs.last();
			}catch(Exception e){}
			getDet();
		}
		if(ae.getSource().equals(btnadd))
		{
			reset();
			addDet();
		}
		if(ae.getSource().equals(btns))
		{
			saveDet();
		}
		if(ae.getSource().equals(btncan))
		{
			reset();
		}
		if(ae.getSource().equals(btnsrc))
		{
			createSearch();
		}
		if(ae.getSource().equals(name))
		{
			BName();	
		}
		if(ae.getSource().equals(no))
		{
			BNum();
		}
		if(ae.getSource().equals(searchname))
		{
			frmnamesrc.setVisible(false);
			BName1();
		}
		if(ae.getSource().equals(subname))
		{
			frmname.setVisible(false);
			try
			{
				//sqlop();
				rs.first();
				while(!(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)).equals(txtname1.getSelectedItem()))
				{
					rs.next();
				}
				getDet();				
			}catch(Exception e){System.out.println();}
		}
		if(ae.getSource().equals(subnum))
		{
			frmnum.setVisible(false);
			try
			{
				//sqlop();
				rs.first();
				while(!(rs.getString(1).equals(txtnum.getText())))
					rs.next();
				getDet();				
			}catch(Exception e){System.out.println(e);}
		}
		if(ae.getSource().equals(btne))
		{
			//System.exit(0);
			//frmobj.dispose();
			frmobj.setVisible(false);
		}
	}
	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource().equals(txtfn) && txtfn.getText().equals("First Name"))
		{
			txtfn.setText("");
			txtfn.setForeground(Color.black);			
		}
		else if(ke.getSource().equals(txtmn) && txtmn.getText().equals("Middle Name"))
		{
			txtmn.setText("");
			txtmn.setForeground(Color.black);			
		}
		else if(ke.getSource().equals(txtln) && txtln.getText().equals("Last Name"))
		{
			txtln.setText("");
			txtln.setForeground(Color.black);			
		}
	}
	
	public void keyReleased(KeyEvent ke)
	{
		if(ke.getSource().equals(txtfn)||ke.getSource().equals(txtmn)||ke.getSource().equals(txtln))
		{
			if(txtfn.getText().equals(""))
			{
				txtfn.setText("First Name");
				txtfn.setForeground(Color.gray);
			}	
			else if(txtmn.getText().equals(""))
			{
				txtmn.setText("Middle Name");
				txtmn.setForeground(Color.gray);
			}
			else if(txtln.getText().equals(""))
			{
				txtln.setText("Last Name");
				txtln.setForeground(Color.gray);
			}		
		}
	}
	
	public void keyTyped(KeyEvent ke)
	{
		if(ke.getSource().equals(txtfn)||ke.getSource().equals(txtmn)||ke.getSource().equals(txtln))
		{
			if((ke.getKeyChar()>='A'&&ke.getKeyChar()<='Z')||(ke.getKeyChar()>='a'&&ke.getKeyChar()<='z'))
			{
			}
			else
			{
				if(ke.getKeyChar()=='\b'||ke.getKeyChar()==' ')
				{
				}
				else
				{
					JOptionPane.showMessageDialog(frmobj,"Enter letters only","error",JOptionPane.ERROR_MESSAGE);	
					ke.consume();
				}
			}
		}
	
	}
	
	public void reg()
	{
		btnf.addActionListener(this);
		btnpr.addActionListener(this);
		btnnxt.addActionListener(this);
		btnl.addActionListener(this);
		btnadd.addActionListener(this);
		btnup.addActionListener(this);		
		btndel.addActionListener(this);
		btnsrc.addActionListener(this);
		btns.addActionListener(this);
		btncan.addActionListener(this);
		btne.addActionListener(this);
		txtfn.addKeyListener(this);
		txtmn.addKeyListener(this);
		txtln.addKeyListener(this);
	}
	
	public static void main(String[] a)
	{
		Employee obj=new Employee();
		obj.createComp();
		obj.displayComp();
		obj.reg();
		obj.sqlop();
	}

	public void reset()
	{
		cbs.setSelected(false);
		cbr.setSelected(false);
		cbc.setSelected(false);
		rbmale.setSelected(false);
		rbfemale.setSelected(false);
		txtfn.setText("First Name");
		txtfn.setForeground(Color.gray);
		txtmn.setText("Middle Name");
		txtfn.setForeground(Color.gray);
		txtln.setText("Last Name");
		txtage.setText("");
		txtn.setText("");
		cbx.setSelectedIndex(0);
	}
	
	public void getDet()
	{
		try
		{	
			txtn.setText(rs.getString(1));
			txtfn.setText(rs.getString(2));
			txtmn.setText(rs.getString(3));
			txtln.setText(rs.getString(4));
			txtage.setText(rs.getString(5));
			if(rs.getString(6).equals("M"))
			{
				rbmale.setSelected(true);
				rbfemale.setSelected(false);
			}
			else
			{
				rbfemale.setSelected(true);
				rbmale.setSelected(false);
			}
			cbx.setSelectedIndex(rs.getInt(8));
			String s=rs.getString(7);
			char c[];
			c=s.toCharArray();
			int i=0;
			while(i<c.length)
			{
				if(c[i]=='1')
					cbs.setSelected(true);
				if(c[i]=='2')
					cbr.setSelected(true);
				if(c[i]=='3')
					cbc.setSelected(true);
				if(c[i]==';'){}
				i++;
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void addDet()
	{
		try
		{
			rs.last();
			String str=rs.getString(1);
			int count=0;
			String temp="E";
			int num=Integer.parseInt(str.substring(1));
			int i=num;
			while(i!=0)
			{
				i=i%10;
				count++;
				i=i/10;
			}
			for(int j=0;j<3-count;j++)
			{
				temp=temp+"0";
			}
			txtn.setText(temp+(num+1));
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void createSearch()
	{
		gridobj1=new GridLayout(2,1);
		frmsearch=new JFrame("Search");
		name=new JButton("By Name");
		no=new JButton("By Number");
		pnlsearch=new JPanel();
		frmsearch.setLayout(gridobj1);
		frmsearch.add(name);
		frmsearch.add(no);
		frmsearch.setSize(200,200);
		frmsearch.setVisible(true);
		name.addActionListener(this);
		no.addActionListener(this);
	}
	public void BNum()
	{
		frmsearch.setVisible(false);
		frmnum=new JFrame("SEARCH BY NUMBER");
		number=new JLabel("EMPLOYEE NUMBER");
		txtnum=new JTextField(10);
		subnum=new JButton("SUBMIT");
		gridobj1=new GridLayout(3,1);
		frmnum.setLayout(gridobj1);
		frmnum.add(number);
		frmnum.add(txtnum);
		frmnum.add(subnum);
		frmnum.setSize(400,400);
		frmnum.setVisible(true);
		subnum.addActionListener(this);
	}
	public void BName()
	{
		frmsearch.setVisible(false);
		frmnamesrc=new JFrame("SEARCH BY NAME");
		nm=new JLabel("EMPLOYEE NAME");
		txtname=new JTextField(10);
		searchname=new JButton("SEARCH");
		gridobj1=new GridLayout(3,1);
		frmnamesrc.setLayout(gridobj1);
		frmnamesrc.add(nm);
		frmnamesrc.add(txtname);
		frmnamesrc.add(searchname);
		frmnamesrc.setSize(400,400);
		frmnamesrc.setVisible(true);
		searchname.addActionListener(this);
	}
	public void BName1()
	{
		frmnamesrc.setVisible(false);
		frmname=new JFrame("SELECT");
		nm1=new JLabel("SELECT NAME");
		txtname1=new JComboBox();
		subname=new JButton("SUBMIT");
		gridobj1=new GridLayout(3,1);
		frmname.setLayout(gridobj1);
		frmname.add(nm1);
		frmname.add(txtname1);
		frmname.add(subname);
		frmname.setSize(400,400);
		frmname.setVisible(true);
		subname.addActionListener(this);
		try
		{
			rs.first();
			String s=rs.getString(2);
			s=s.substring(0,1);
			if(txtname.getText().equals(s))
			{
				txtname1.addItem(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			while(rs.next())
			{
				s=rs.getString(2);
				s=s.substring(0,1);
				if(txtname.getText().equals(s))
				{
					txtname1.addItem(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}	
			}
		}catch(Exception e){System.out.println(e);}	
	}
	public void saveDet()
	{
		String s;
		try
		{
			rs.last();
			PreparedStatement ps=con.prepareStatement("insert into Emp values(?,?,?,?,?,?,?,?)");
			ps.setString(1,txtn.getText());
			ps.setString(2,txtfn.getText());
			ps.setString(3,txtmn.getText());
			ps.setString(4,txtln.getText());
			ps.setInt(5,Integer.parseInt(txtage.getText()));
			if(rbmale.isSelected())
				ps.setString(6,"M");
			else
				ps.setString(6,"F");
			if(cbs.isSelected()||cbr.isSelected()||cbc.isSelected())
			{
				if(cbs.isSelected())
				{
				}	
			}
			ps.setString(7,"1;2");
			ps.setInt(8,cbx.getSelectedIndex());
			int i=ps.executeUpdate();
			System.out.println(i);
		}catch(Exception e)
		{
			System.out.println(e);
		}	
	}

}
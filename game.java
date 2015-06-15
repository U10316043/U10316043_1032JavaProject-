import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class game extends JFrame implements ActionListener{
	String username ;
	static JLabel n;
	private ImageIcon[] color = new ImageIcon[8];
	private JButton[] bcolor = new JButton[8];	
	private ImageIcon[] colorpattern = new ImageIcon[8];
	private JLabel[] lcolor = new JLabel[8];
	int[] colorarray = new int[8];
	
	Timer timer = new Timer();
	int sec = 6;
	
	private ImageIcon[] num = new ImageIcon[10];
	private JLabel number = new JLabel();
	
	int push;
	int score = 0;
	static JTextField SCORE = new JTextField("0");
	private JLabel ss = new JLabel("POINTS");
	int[] deck = new int[80];
	int q =0;
	
	private JLabel runtime =new JLabel();
	int time = 5;
	Thread thread ;

	private runrun aaa;
		
	public game(String username){
		this.setLayout(null);
		/**username*/
		this.username = username;
		n = new JLabel("HERO "+username);
		this.add(n);

		this.n.setBounds(20,5,300,30);
			
		/**Score*/
		this.ss.setBounds(970,620,100,50);
		this.add(ss);
		SCORE.setEnabled(false);
		SCORE.setHorizontalAlignment(JTextField.CENTER);
		SCORE.setFont(new Font("新細明體",Font.PLAIN,50) );
		this.SCORE.setBounds(970,670,150,150);
		this.add(SCORE);	
		
		/**button*/
		for(int i = 0 ; i < 8 ; i++){
			color[i] = new ImageIcon(getClass().getResource("colorworld/color"+(i+1)+".jpg"));
			bcolor[i] = new JButton(color[i]);
			this.add(bcolor[i]);
		}
		
		for(int k = 0;k<8;k++){
			lcolor[k] = new JLabel(" ");
		}
		
		this.bcolor[0].setBounds(300,400,150,150);
		this.bcolor[1].setBounds(450,400,150,150);
		this.bcolor[2].setBounds(600,400,150,150);
		this.bcolor[3].setBounds(750,400,150,150);
		this.bcolor[4].setBounds(300,550,150,150);
		this.bcolor[5].setBounds(450,550,150,150);
		this.bcolor[6].setBounds(600,550,150,150);
		this.bcolor[7].setBounds(750,550,150,150);
		

		for(int i = 0;i<deck.length ;i++)  
			deck[i] = i;
		for(int i = 0;i<deck.length;i++){
			int index =(int)(Math.random()*80);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		for(int i = 0;i<8;i++){
			colorarray[i] = deck[i]+11;
			colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
			lcolor[i] = new JLabel(colorpattern[i]);
			add(lcolor[i]);
		}

		
		this.lcolor[0].setBounds(50,100,150,150);
		this.lcolor[1].setBounds(200,100,150,150);
		this.lcolor[2].setBounds(350,100,150,150);
		this.lcolor[3].setBounds(500,100,150,150);
		this.lcolor[4].setBounds(650,100,150,150);
		this.lcolor[5].setBounds(800,100,150,150);
		this.lcolor[6].setBounds(950,100,150,150);
		this.lcolor[7].setBounds(1100,100,150,150);
		
		
		this.number.setBounds(500,300,500,500);	


		//execute start count method
		timer.schedule(new Count(),500,1000); 
		this.getLayeredPane().add(number,new Integer(0));
		

		for(int i =0 ;i<8;i++){
			bcolor[i].addActionListener(this);
			bcolor[i].setEnabled(false);
		}
		
		runtime.setText("*");
		runtime.setFont(new Font("新細明體",Font.PLAIN,200) );
		runtime.setBounds(1030,380,300,300);
		this.getContentPane().add(runtime);
		
		
		/**game start*/
		aaa = new runrun();
		thread = new Thread(aaa);
		

			

				
		

		
		/**background*/
		this.setTitle("ColorWorld");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1900,750);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	/**start countdown method*/
	private class Count extends TimerTask{
		public void run(){
			if(sec>-1){
				sec--;
				System.out.println(sec);
				if(sec == 5){
					num[5] = new ImageIcon(getClass().getResource("colorworld/6.png")); 
					number.setIcon(num[5]);
				}
				else if(sec ==4){
					num[4] = new ImageIcon(getClass().getResource("colorworld/5.png")); 
					number.setIcon(num[4]);
				}
				else if(sec == 3){
					num[3] = new ImageIcon(getClass().getResource("colorworld/4.png")); 
					number.setIcon(num[3]);
				}
				else if(sec ==2){
					num[2] = new ImageIcon(getClass().getResource("colorworld/3.png")); 
					number.setIcon(num[2]);
				}
				else if(sec == 1){
					num[1] = new ImageIcon(getClass().getResource("colorworld/2.png")); 
					number.setIcon(num[1]);
				}
				else if(sec == 0){
					num[0] = new ImageIcon(getClass().getResource("colorworld/1.png")); 
					number.setIcon(num[0]);
				}
				else{
					System.out.println(sec);
					num[6] = new ImageIcon(getClass().getResource("colorworld/0.png")); 
					number.setIcon(num[6]);
					for(int i =0;i<8;i++){
						bcolor[i].setEnabled(true);
	
					}		thread.start();	
				} 
				
			}
			else{
				try{
				
					timer.cancel();
				}
				catch(ArrayIndexOutOfBoundsException E){
					
				}
				
			}
		}
	}
	
	/**runtime*/
	public class runrun implements Runnable{
		private boolean isRunning =true;
		runrun(){}
		public void run(){
			for(int i =time;i>=0;i--){
				if(isRunning ==false)
					break;
				runtime.setText(i+"");
				if(i ==0){
					timeup();
				}
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException E){		
				}
			}
		}	
		public void stop(){
			isRunning = false;
		}
		public void timeup(){
			if(q<8){
				System.out.println("time's up!");
				score = score+(-10)*(8-q);
				String sss =  String.valueOf(score);
				SCORE.setText(sss);
				patterndeck();
				for(int i = 0;i<8;i++){
					colorarray[i] = deck[i]+11;
					colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
					lcolor[i].setIcon(colorpattern[i]);
					lcolor[i].setEnabled(true);
				}q=0;
			}
		}
	}
			
	


	

	/**pattern deck*/
	public void patterndeck(){
		System.out.println("patterndeck");
		aaa.stop();
		aaa = new runrun();
		thread =new Thread(aaa);
		thread.start();
		
		for(int i = 0;i<deck.length ;i++)  
			deck[i] = i;
		for(int i = 0;i<deck.length;i++){
			int index =(int)(Math.random()*80);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}

	}
	
	
	/**ActionPerformed*/
	public void actionPerformed(ActionEvent e){
		try{
			if(e.getSource() == bcolor[0] ){
				push = 1;
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				System.out.println(ca);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[1] ){
				push = 2;
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[2] ){
				push = 3;
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[3] ){
				push = 4;
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[4] ){
				push = 5;		
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);;
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[5] ){
				push = 6;				
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[6] ){
				push = 7;				
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
			if(e.getSource() == bcolor[7] ){
				push = 8;			
				q++;
				int ca = (int)((colorarray[q-1]-1)/10);
				if( ca == push){
					score +=10;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}
				else{
					score-=5;
					String sss =  String.valueOf(score);
					SCORE.setText(sss);
					lcolor[q-1].setEnabled(false);
				}	
				if(q>=8){
					patterndeck();				
					for(int i = 0;i<8;i++){
						colorarray[i] = deck[i]+11;
						
						colorpattern[i] = new ImageIcon(getClass().getResource("colorworld/"+(deck[i]+11)+".jpg")); 
						lcolor[i].setIcon(colorpattern[i]);
						lcolor[i].setEnabled(true);
					}q=0;
				}
			}
		}		
		catch(NumberFormatException q){
			JOptionPane.showMessageDialog(null,"invalid","Note",JOptionPane.WARNING_MESSAGE);
		}
	}		
}

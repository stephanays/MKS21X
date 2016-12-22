import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;
    
    public Temperature() {
	this.setTitle("Temperature Converter");
	this.setSize(400,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	JButton b = new JButton("F to C");
	b.addActionListener(this);
	b.setActionCommand("FtoC");
	JButton b2 = new JButton("C to F");
	b2.addActionListener(this);
	b2.setActionCommand("CtoF");
	t = new JTextField(1);
	j = new JLabel("");
	pane.add(t);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
    }

    public static double FtoC(double t){
	return (t-32)/1.8;
    }

    public static double CtoF(double t){
	return (t*1.8)+32;
    }
    
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	String s=t.getText();
	if(event.equals("FtoC")){
	    j.setText(String.valueOf(FtoC(Double.parseDouble(s)))+" C");
	    t.setText(s+" F");
	}
	if(event.equals("CtoF")){
	    j.setText(String.valueOf(CtoF(Double.parseDouble(s)))+" F");
	    t.setText(s+" C");
	}
    }

    public static void main(String[] args) {
        Temperature g = new Temperature();
        g.setVisible(true);
    }
}

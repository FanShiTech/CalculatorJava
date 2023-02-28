
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addB, subB, mulB, divB;
	JButton decB, equB, delB, clrB, negB;
	JPanel panel;

	Font myFont = new Font("Ink free", Font.BOLD,30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows me to close out of the program
		frame.setSize(420, 550);
		frame.setLayout(null);
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("*");
		divB = new JButton("/");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("Del");
		clrB = new JButton("Clear");
		negB = new JButton("(-)");
		
		
		
		functionButtons[0] = addB;
		functionButtons[1] = subB;
		functionButtons[2] = mulB;
		functionButtons[3] = divB;
		functionButtons[4] = decB;
		functionButtons[5] = equB;
		functionButtons[6] = delB;
		functionButtons[7] = clrB;
		functionButtons[8] = negB;
		
		
		for(int i = 0 ; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		
		negB.setBounds(50,430,100,50);
		delB.setBounds(150,430,100,50);
		clrB.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulB);
		panel.add(decB);
		
		panel.add(numberButtons[0]);
		panel.add(equB);
		panel.add(divB);
		
			
		frame.add(panel);
		frame.add(negB);
		frame.add(delB);
		frame.add(clrB);
		frame.add(textField);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<10; i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decB) {
			textField.setText(textField.getText().concat("."));
		}
		
		
		if(e.getSource()==addB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource()==subB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource()==mulB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource()==divB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		
		if(e.getSource() == equB) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
			case'+':
				result = num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource() == clrB) {
			textField.setText("");
		}
		if(e.getSource() == delB) {
			String string = textField.getText();
			textField.setText("");
			for (int i =0; i < string.length()-1; i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negB) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	
		
	}

}

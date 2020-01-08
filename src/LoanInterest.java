import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanInterest extends JFrame{

    private  JTextField amountsField;
    private  JTextField interestField;
    private  JTextField yearsField;
    private  JTextField paymentField;

    private JButton clearButton;
    private JButton submitButton;
    private JButton exitButton;

    public LoanInterest(){

        super("Monthly Payments");
        setBounds(0,0,600,500);

        JPanel panel = new JPanel();//for text fields and labels

        JLabel amountLabel = new JLabel();
        amountLabel.setFont(new Font("Courier",Font.BOLD,12));
        amountLabel.setText("Amount:");
        amountsField  = new JTextField(10);
        panel.add(amountLabel);
        panel.add(amountsField);

        JLabel interestLabel = new JLabel();
        interestLabel.setFont(new Font("Courier",Font.BOLD,12));
        interestLabel.setText("Interest:");
        interestField = new JTextField(10);
        panel.add(interestLabel);
        panel.add(interestField);

        JLabel yearsLabel = new JLabel();
        yearsLabel.setFont(new Font("Courier",Font.BOLD,12));
        yearsLabel.setText("Years");
        yearsField = new JTextField(10);
        panel.add(yearsLabel);
        panel.add(yearsField);

        JLabel paymentLabel = new JLabel();
        paymentLabel.setFont(new Font("Courier",Font.BOLD,12));
        paymentLabel.setText("Payment");
        paymentField = new JTextField(10);
        panel.add(paymentLabel);
        panel.add(paymentField);
        paymentField.setEditable(false);//read only

        add(panel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();//Hold the buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        add(buttonPanel,BorderLayout.SOUTH);


        submitButton.addActionListener(new ButtonListener());
        clearButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());


        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private class ButtonListener implements ActionListener //responds to the button events
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==submitButton)//calculates payment

                try//DoubleParseDouble()throws NumberFormatException
                {
                    //retrieve data from the text fields,the data are strings
                    //use Double.parseDouble(...)to convert the strings to numbers
                    double amount = Double.parseDouble(amountsField.getText());
                    double interest = Double.parseDouble(interestField.getText());
                    double years = Double.parseDouble(yearsField.getText());
                    double payment = ((amount*interest*years)/100) ;
                    paymentField.setText(payment +"");
                }
                catch (NumberFormatException ex)
                {
                    paymentField.setText("Illegal Input");
                }
            else if(e.getSource()==clearButton)  //clear all fields
            {
                amountsField.setText("");
                interestField.setText("");
                yearsField.setText("");
                paymentField.setText("");
            }
            else
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        LoanInterest obj = new LoanInterest();
    }
}

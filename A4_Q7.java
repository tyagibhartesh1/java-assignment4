
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A4_Q7 extends JFrame implements ActionListener {

    JTextField display;
    JButton[] buttons = new JButton[16];

    String[] labels = {
            "+", "1", "2", "3",
            "-", "4", "5", "6",
            "*", "7", "8", "9",
            "/", ".", "0", "C"
    };

    double num1, num2;
    String operator = "";
    boolean newNumber = true;

    A4_Q7() {
        setTitle("Calculator");
        setSize(240, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLUE);

        // Display field
        display = new JTextField();
        display.setBounds(30, 10, 170, 27);
        display.setFont(new Font("Arial", Font.PLAIN, 14));
        display.setHorizontalAlignment(JTextField.LEFT);
        add(display);

        // Calculator buttons
        int x = 10;
        int y = 43;

        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].setBounds(x, y, 48, 30);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            buttons[i].setBackground(new Color(230, 230, 230));
            buttons[i].setForeground(Color.BLACK);
            buttons[i].addActionListener(this);
            add(buttons[i]);

            x += 56;

            if ((i + 1) % 4 == 0) {
                x = 10;
                y += 35;
            }
        }

        // Equals button
        JButton equals = new JButton("=");
        equals.setBounds(90, 183, 50, 29);
        equals.setBackground(new Color(230, 230, 230));
        equals.setFont(new Font("Arial", Font.PLAIN, 14));
        equals.addActionListener(this);
        add(equals);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();

        if (value.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
            newNumber = true;
        }
        else if (value.equals("+") || value.equals("-")
                || value.equals("*") || value.equals("/")) {

            try {
                num1 = Double.parseDouble(display.getText());
                operator = value;
                newNumber = true;
            } catch (NumberFormatException ex) {
                display.setText("Enter a number");
            }
        }
        else if (value.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            display.setText("Cannot divide by zero");
                            newNumber = true;
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(
                        num1 + operator + num2 + "=" + result
                );
                newNumber = true;

            } catch (NumberFormatException ex) {
                display.setText("Invalid input");
            }
        }
        else {
            if (newNumber) {
                display.setText(value);
                newNumber = false;
            } else {
                display.setText(display.getText() + value);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A4_Q7());
    }
}

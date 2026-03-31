import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvestmentCalculator extends JFrame {
    private JTextField txtPrincipal, txtRate, txtYears, txtResult;
    private JButton btnCalculate;

    public InvestmentCalculator() {
        setTitle("Investment Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel(" Principal Amount:"));
        txtPrincipal = new JTextField();
        add(txtPrincipal);

        add(new JLabel(" Annual Interest Rate (%):"));
        txtRate = new JTextField();
        add(txtRate);

        add(new JLabel(" Number of Years:"));
        txtYears = new JTextField();
        add(txtYears);

        add(new JLabel(" Future Value:"));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        add(txtResult);

        btnCalculate = new JButton("Calculate");
        add(new JLabel("")); // Empty cell
        add(btnCalculate);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double p = Double.parseDouble(txtPrincipal.getText());
                    double r = Double.parseDouble(txtRate.getText()) / 100;
                    int n = Integer.parseInt(txtYears.getText());

                    double futureValue = p * Math.pow((1 + r), n);
                    txtResult.setText(String.format("%.2f", futureValue));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InvestmentCalculator().setVisible(true);
        });
    }
}

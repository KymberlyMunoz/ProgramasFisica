import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConvertidorNotacionCientifica extends JFrame {

    private JTextField entradaTextField, resultadoTextField;

    public ConvertidorNotacionCientifica() {
        setTitle("Convertidor Notación Científica");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel etiquetaEntrada = new JLabel("Número Decimal:");
        etiquetaEntrada.setBounds(10, 20, 120, 25);
        panel.add(etiquetaEntrada);

        entradaTextField = new JTextField(20);
        entradaTextField.setBounds(140, 20, 200, 25);
        panel.add(entradaTextField);

        JButton aNotacionCientificaButton = new JButton("A Notación Científica");
        aNotacionCientificaButton.setBounds(10, 60, 180, 25);
        aNotacionCientificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirANotacionCientifica();
            }
        });
        panel.add(aNotacionCientificaButton);

        JButton aDecimalButton = new JButton("A Decimal");
        aDecimalButton.setBounds(200, 60, 140, 25);
        aDecimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirADecimal();
            }
        });
        panel.add(aDecimalButton);

        JLabel etiquetaResultado = new JLabel("Resultado:");
        etiquetaResultado.setBounds(10, 100, 80, 25);
        panel.add(etiquetaResultado);

        resultadoTextField = new JTextField(20);
        resultadoTextField.setBounds(90, 100, 250, 25);
        resultadoTextField.setEditable(false);
        panel.add(resultadoTextField);
    }

    private void convertirANotacionCientifica() {
        try {
            double numeroDecimal = Double.parseDouble(entradaTextField.getText());
            resultadoTextField.setText(new DecimalFormat("0.#####E0").format(numeroDecimal));
        } catch (NumberFormatException ex) {
            resultadoTextField.setText("Error: Ingrese un número decimal válido");
        }
    }

    private void convertirADecimal() {
        try {
            double numeroCientifico = Double.parseDouble(entradaTextField.getText());
            resultadoTextField.setText(String.valueOf(numeroCientifico));
        } catch (NumberFormatException ex) {
            resultadoTextField.setText("Error: Ingrese una notación científica válida");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConvertidorNotacionCientifica();
            }
        });
    }
}
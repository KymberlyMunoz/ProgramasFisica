import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorSI1 extends JFrame {

    private JTextField inputField;
    private JComboBox<String> fromUnitComboBox;
    private JComboBox<String> toUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    // Factores de conversión para algunas unidades comunes
    private static final double[] CONVERSION_FACTORS = {
            1.0,  // Metros
            0.001, // Kilómetros
            100,   // Centímetros
            0.01,  // Decímetros
            0.001, // Milímetros
            1.0,   // Gramos
            0.001, // Kilogramos
            1000,  // Miligramos
            1.0,   // Litros
            0.001, // Mililitros
            2.4, // Pulgada
            3.281, // Pie
            0.914, // Yarda
            1478.5, // Milla
            2.205, // Libra
            35.274, // Onza
            1000, // Tonelada
            
            
            
    };

    // Unidades disponibles para la conversión
    private static final String[] UNITS = {
            "Metros", "Kilómetros", "Centímetros", "Decímetros", "Milímetros",
            "Gramos", "Kilogramos", "Miligramos",
            "Litros", "Mililitros", "Pulgada" , "Pie" , "Yarda", "Milla" , "Libra" , "Onza" , "Tonelada"
    };

    public ConversorSI1() {
        // Configuración del JFrame
        setTitle("Conversor Sistema Internacional de Unidades");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        inputField = new JTextField();
        fromUnitComboBox = new JComboBox<>(UNITS);
        toUnitComboBox = new JComboBox<>(UNITS);
        convertButton = new JButton("Convertir");
        resultLabel = new JLabel("Resultado:");

        // Configuración del layout del panel
        setLayout(new GridLayout(5, 1));

        // Agregar componentes al panel
        add(inputField);
        add(fromUnitComboBox);
        add(toUnitComboBox);
        add(convertButton);
        add(resultLabel);

        // Configuración del botón para realizar la conversión
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirUnidades();
            }
        });
    }

    private void convertirUnidades() {
        try {
            double valorEntrada = Double.parseDouble(inputField.getText());
            int unidadDesde = fromUnitComboBox.getSelectedIndex();
            int unidadHacia = toUnitComboBox.getSelectedIndex();

            double resultado = valorEntrada * CONVERSION_FACTORS[unidadDesde] / CONVERSION_FACTORS[unidadHacia];

            resultLabel.setText("Resultado: " + resultado + " " + UNITS[unidadHacia]);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Entrada no válida");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversorSI1().setVisible(true);
            }
        });
    }
}
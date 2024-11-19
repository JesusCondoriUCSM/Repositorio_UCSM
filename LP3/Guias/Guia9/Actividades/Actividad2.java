import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
		// Crea el marco principal
        JFrame frame = new JFrame("Resta de Dos Enteros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Establece el layout a BorderLayout
        frame.setLayout(new BorderLayout());

        // Crea los componentes
        JPanel inputPanel = new JPanel();
        JLabel label1 = new JLabel("Primer entero:");
        JTextField campo1 = new JTextField(10);
        
        JLabel label2 = new JLabel("Segundo entero:");
        JTextField campo2 = new JTextField(10);
        
        JButton botonResta = new JButton("Restar");
        JLabel resultadoLabel = new JLabel("La resta es: ");
        
        // Añade los componentes al panel de entrada
        inputPanel.add(label1);
        inputPanel.add(campo1);
        inputPanel.add(label2);
        inputPanel.add(campo2);
        
        // Añade el panel de entrada al centro del marco
        frame.add(inputPanel, BorderLayout.CENTER);
        
        // Añade el botón al sur del marco
        frame.add(botonResta, BorderLayout.SOUTH);
        
        // Añade la etiqueta de resultado al norte del marco
        frame.add(resultadoLabel, BorderLayout.NORTH);

        // Acción del botón para sumar los números
        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campo1.getText());
                    int numero2 = Integer.parseInt(campo2.getText());
                    int resta = numero1 - numero2;
                    resultadoLabel.setText("La resta es: " + resta);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Muestra el marco
        frame.setVisible(true);
    }
}

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
		// Crea el marco principal
        JFrame frame = new JFrame("Suma de Dos Enteros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Crea un panel con FlowLayout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        // Crea los componentes
        JLabel label1 = new JLabel("Primer entero:");
        JTextField campo1 = new JTextField(10);
        
        JLabel label2 = new JLabel("Segundo entero:");
        JTextField campo2 = new JTextField(10);
        
        JButton botonSumar = new JButton("Sumar");
        JLabel resultadoLabel = new JLabel("La suma es: ");
        
        // Añade los componentes al panel
        panel.add(label1);
        panel.add(campo1);
        panel.add(label2);
        panel.add(campo2);
        panel.add(botonSumar);
        panel.add(resultadoLabel);
        
        // Añade el panel al marco
        frame.getContentPane().add(panel);
        
        // Acción del botón para sumar los números
        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campo1.getText());
                    int numero2 = Integer.parseInt(campo2.getText());
                    int suma = numero1 + numero2;
                    resultadoLabel.setText("La suma es: " + suma);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Muestra el marco
        frame.setVisible(true);
    }
}

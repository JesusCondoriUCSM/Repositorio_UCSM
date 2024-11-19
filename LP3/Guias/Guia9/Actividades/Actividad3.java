import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
		// Crea el marco principal
        JFrame frame = new JFrame("Multiplicación de Dos Enteros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Establece el layout a GridLayout con 3 filas y 2 columnas
        frame.setLayout(new GridLayout(3, 2));
        
        // Crea los componentes
        JLabel label1 = new JLabel("Primer entero:");
        JTextField campo1 = new JTextField();
        
        JLabel label2 = new JLabel("Segundo entero:");
        JTextField campo2 = new JTextField();
        
        JButton botonMult = new JButton("Sumar");
        JLabel resultadoLabel = new JLabel("La suma es: ");
        
        // Añade los componentes al marco
        frame.add(label1);
        frame.add(campo1);
        frame.add(label2);
        frame.add(campo2);
        frame.add(resultadoLabel);
        frame.add(botonMult);
        

        // Acción del botón para sumar los números
        botonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campo1.getText());
                    int numero2 = Integer.parseInt(campo2.getText());
                    int multi = numero1 * numero2;
                    resultadoLabel.setText("La multiplicación es: " + multi);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Muestra el marco
        frame.setVisible(true);
    }
}

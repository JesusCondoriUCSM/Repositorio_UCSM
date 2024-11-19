import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
	// Crear la ventana
	JFrame frame = new JFrame("Datos viaje");
	frame.setSize(600, 500); // Tamaño de la ventana
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// Crear un panel para organizar los componentes
	
	frame.setLayout(new GridLayout(15, 2));
	
	// Crear los componentes
	JLabel etiqueta1 = new JLabel("Nombres: ");
	JTextField NombresTexto = new JTextField(30); // Campo de texto para ingresar el nombre
	
	JLabel etiqueta2= new JLabel("Apellidos:");
	JTextField ApellidosTexto= new JTextField(30);
	
	JLabel etiqueta3= new JLabel("Documento de identidad:");
	JTextField DNITexto= new JTextField(8);
	
	JLabel etiqueta4= new JLabel("Fecha de viaje:");
	JTextField FechaTexto= new JTextField(30);
	
	//Casillas de verificacion
	//Servicio opcional
	JLabel etiqueta5= new JLabel("Servicio opcional:");
	JCheckBox chkAudifonos=new JCheckBox("Audifonos");
	JCheckBox chkManta = new JCheckBox("Manta");
	JCheckBox chkRevistas = new JCheckBox("Revistas");
	
	
	//Botones de opcion
	JLabel etiqueta6= new JLabel("Piso de viaje:");
	JRadioButton opcprimer=new JRadioButton("1er piso");
	JRadioButton opcsegundo = new JRadioButton("2do piso");
	
	ButtonGroup grupoPisos = new ButtonGroup();
	grupoPisos.add(opcprimer);
	grupoPisos.add(opcsegundo);
	
	//Cuadros combinados
	JLabel etiqueta7= new JLabel("Origen y destino:");
	
	String [] origen= {"Seleccione el origen","Arequipa","Lima","Tacna"};
	JComboBox<String> comboOrigen=new JComboBox<>(origen);
	String [] destino= {"Seleccione el destino","Ayacucho","Moquegua","Cuzco"};
	JComboBox<String> comboDestino=new JComboBox<>(destino);
	
	
	//Lista
	JLabel etiqueta8= new JLabel("Calidad de servicio:");
	String [] servicios= {"Ecónomico","Standar","VIP"};
	JList<String> listaServicios=new JList<>(servicios); 
	listaServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Permitir solo una opcion
	
	     //Lista seleccionable
	JScrollPane scrollPane =new JScrollPane(listaServicios);
	scrollPane.setPreferredSize(new Dimension(300,70));
	
	//Botones
	JButton botonReiniciar = new JButton("Reinciar"); // Botón para generar la salida
	JButton botonMostrar = new JButton("Mostrar información");
	
	// Agregar los componentes al panel
	frame.add(etiqueta1);
	frame.add(NombresTexto);
	
	frame.add(etiqueta2);
	frame.add(ApellidosTexto);
	
	frame.add(etiqueta3);
	frame.add(DNITexto);
	
	frame.add(etiqueta4);
	frame.add(FechaTexto);
	
	//Casillas de verificacion
	//Servicios opcionales
	frame.add(etiqueta5);
	frame.add(chkAudifonos);
	frame.add(new JLabel());
	frame.add(chkManta);
	frame.add(new JLabel());
	frame.add(chkRevistas);
	
	//Botones de opcion
	frame.add(etiqueta6);
	frame.add(opcprimer);
	frame.add(new JLabel());
	frame.add(opcsegundo);
	
	//Cuadros combinados
	frame.add(etiqueta7);
	frame.add(comboOrigen);
	frame.add(new JLabel());
	frame.add(comboDestino);
	
	frame.add(new JLabel());
	frame.add(new JLabel());
	//Lista
	frame.add(etiqueta8);
	frame.add(scrollPane);
	
	frame.add(new JLabel());
	frame.add(new JLabel());
	
	//botones
	frame.add(botonReiniciar);
	frame.add(botonMostrar);
	
	
	
	// Acción cuando se hace clic en el botón
	botonReiniciar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			NombresTexto.setText(" ");
			ApellidosTexto.setText(" ");
			DNITexto.setText(" ");
			FechaTexto.setText(" ");
			
			chkAudifonos.setSelected(false);
			chkManta.setSelected(false);
			chkRevistas.setSelected(false);
			
			grupoPisos.clearSelection();
			
			
			comboOrigen.setSelectedIndex(0);
			comboDestino.setSelectedIndex(0);
			
			listaServicios.clearSelection();
			
		}
	});
	
	botonMostrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String mensaje = "Nombres: "+NombresTexto.getText()+"\nApellidos: "+ApellidosTexto.getText()+"\nDNI: "+DNITexto.getText()+"\nFecha del viaje: "+FechaTexto.getText()+"\nServicios opcionales: ";
			
			if(chkAudifonos.isSelected()) {
				mensaje+="\n  - Audifonos";
			}
			if(chkManta.isSelected()) {
				mensaje+="\n  - Manta";
			}
			if(chkRevistas.isSelected()) {
				mensaje+="\n  - Revistas";
			}
			mensaje+="\nPiso de viaje: ";
			if(opcprimer.isSelected()) {
				mensaje+="1er piso";
			}
			else if(opcsegundo.isSelected()) {
				mensaje+="2do piso";
			}
			else {
				mensaje+="No seleccionado";
			}
			
			mensaje+="\nOrigen y destino: "+comboOrigen.getSelectedItem()+" - "+comboDestino.getSelectedItem();
			mensaje+="\nCalidad de servicio: ";
			String service= listaServicios.getSelectedValue();
			if(service != null) {
				mensaje+=service;
			}
			else {
				mensaje+="Ninguna seleccionada";
			}
			
			
			JOptionPane.showMessageDialog(null,mensaje ,"Información ingresada",JOptionPane.INFORMATION_MESSAGE);
		}
	});
	// Hacer visible la ventana
	frame.setVisible(true);
	}
	
}

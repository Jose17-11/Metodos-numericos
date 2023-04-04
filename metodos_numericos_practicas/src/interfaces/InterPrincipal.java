package interfaces;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class InterPrincipal extends JFrame implements ActionListener{

	JLabel titulo, opcion1, opcion2, opcion3;
	JTextField txtdecision;
	JButton boton1;
	JPanel panel;
	
	InterPrincipal(){
		setTitle("Metodos Numericos");
		
		titulo=new JLabel("Metodos Numericos");
		titulo.setBounds(250, 20, 250, 40);
		opcion1=new JLabel("1. Metodo de Biseccion");
		opcion1.setBounds(50, 60, 200, 20);
		opcion2=new JLabel("2. Metodo de Newton Raphson");
		opcion2.setBounds(50, 90, 250, 20);
		opcion3=new JLabel("3. Salir");
		opcion3.setBounds(50, 120, 100, 20);
		
		txtdecision=new JTextField();
		txtdecision.setBounds(50, 150, 150, 20);
		
		boton1=new JButton("Aceptar");
		boton1.setBounds(200, 150, 100, 20);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		panel.add(titulo);
		
		panel.add(opcion1);
		panel.add(opcion2);
		panel.add(opcion3);
		
		panel.add(txtdecision);
		panel.add(boton1);
		
		add(panel);
		setSize(600,400);
		setVisible(true);
		
//		Jframe2 oforma = new Jframe2();
//		oforma.setVisible(true);
//		
	}
	
	public static void main(String[] args) {
		InterPrincipal b=new InterPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package pruebaJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame implements ActionListener, MouseListener{
	JButton bCalcular = new JButton("Calcular");
	Panelx	pMenu = new Panelx(550,40,150,400,Color.BLACK, null);
	Panelx	pEncabezado = new Panelx(0,0,700,80,new Color(90,90,90), null);
	Panelx	pContenido = new Panelx(0,80,700,620,new Color(60,60,60), null);
	Panelx	pRecargos = new Panelx(0,60,692,150,new Color(70,70,70), null);
	Panelx	pSubtotal = new Panelx(0,230,692,100,new Color(70,70,70), null);
	//escalar imagen  y la incluye dentro de un label
	Image	imagBanco = new ImageIcon("src/imagenes/ImBanco.png").getImage();
	ImageIcon reSizeBanco = new ImageIcon(imagBanco.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
	
	Image	imagMenu = new ImageIcon("src/imagenes/iconoMenu.png").getImage();
	ImageIcon reSizeMenu = new ImageIcon(imagMenu.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
	
	JLabel	liMenu = new JLabel(reSizeMenu);
	JLabel	liBanco = new JLabel(reSizeBanco);
	JLabel	lTitulo = new JLabel("Calculo de Salario");
	JLabel	lSalarioMes = new JLabel("Ingrese el Salario Mensual");
	JLabel	lNetoPago = new JLabel("Salario Neto");
	
	Border	bRecargos = new TitledBorder(new EtchedBorder(),"Recargos por Hora");
	
	JLabel	lNocturnas = new JLabel("Nocturnas");
	JLabel	lDominicales = new JLabel("Dominicales");
	JLabel	lNocturnasDominicales = new JLabel("Noct-Dominicales");
	
	JLabel	lSueldoQuincenal = new JLabel("Sueldo Quincenal");
	JLabel	lTotalRecargos = new JLabel("TotalRecargos");
	JLabel	lSubTotal = new JLabel("SubTotal");
	
	JLabel	lSalud = new JLabel("Salud");
	JLabel	lPesion = new JLabel("Pension");
	JLabel	lSubTotal2 = new JLabel("SubTotal");
	
	JTextField	tSalud = new JTextField();
	JTextField	tPesion = new JTextField();
	JTextField	tSubTotal2 = new JTextField();
	
	JTextField	tSueldoQuincenal = new JTextField();
	JTextField	tTotalRecargos = new JTextField();
	JTextField	tSubTotal = new JTextField();
	
	JTextField	tNocturnas = new JTextField("0");
	JTextField	tDominicales = new JTextField("0");
	JTextField	tNocturnasDominicales = new JTextField("0");
	
	JTextField	tSalarioMes = new JTextField();
	JTextArea  taNeto = new JTextArea();
	JPopupMenu popMenu = new  JPopupMenu();
	
	TranslucentPopupMenu n= new TranslucentPopupMenu();
	JMenuItem iAbrir = new JMenuItem();
	public Ventana() {
		initGui();
		
		
	}

	private void initGui() {
		setBounds(300,200,700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(60,60,60));
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		///////////////////////////////////////Menu
		//pMenu.setBackground(new Color(60,60,60));
		popMenu.add("Name");
		popMenu.addSeparator();
		popMenu.add("Id");
		popMenu.addSeparator();
		popMenu.setBackground(new Color(0,0,0,50));
		popMenu.setForeground(new Color(0,0,0,50));
		popMenu.add(new JButton("botn"));
		
		
		
		liBanco.setBounds(50, 15, 100, 50);
		liMenu.setBounds(660, 0, 40, 40);
		liMenu.setName("menu");
		liMenu.addMouseListener(this);
		
		lTitulo.setFont(new Font("Arial",Font.BOLD,30));
		lTitulo.setForeground(new Color(220,220,220));
		lTitulo.setBounds(250,0,300,100);
		
		//sueldo
		lSalarioMes.setBounds(150,10,300,30);
		lSalarioMes.setFont(new Font("Arial",Font.BOLD,20));
		lSalarioMes.setForeground(new Color(220,220,220));
		
		tSalarioMes.setBounds(420,10,100,30);
		
		//Recargos
		pRecargos.setBorder(bRecargos);
		
		lNocturnas.setForeground(new Color(255,220,220));
		lDominicales.setForeground(new Color(255,220,220));
		lNocturnasDominicales.setForeground(new Color(255,220,220));
		
		lNocturnas.setBounds(20,35,100,20);
		lDominicales.setBounds(280,35,100,20);
		lNocturnasDominicales.setBounds(540,35,100,20);
		
		tNocturnas.setBounds(20,80,80,20);
		tDominicales.setBounds(280,80,80,20);
		tNocturnasDominicales.setBounds(540,80,80,20);
		
		//SubTotal
		lSueldoQuincenal.setBounds(20,10,100,20);
		lTotalRecargos.setBounds(20,40,100,20);
		lSubTotal.setBounds(20,70,100,20);
		
		tSueldoQuincenal.setBounds(150,10,100,20);
		tTotalRecargos.setBounds(150,40,100,20);
		tSubTotal.setBounds(150,70,100,20);
		
		
		lSalud.setBounds(350,10,100,20);
		lPesion.setBounds(350,40,100,20);
		lSubTotal2.setBounds(350,70,100,20);
		
		tSalud.setBounds(480,10,100,20);
		tPesion.setBounds(480,40,100,20);
		tSubTotal2.setBounds(480,70,100,20);
		
		tSueldoQuincenal.setEditable(false);
		tTotalRecargos.setEditable(false);
		tSubTotal.setEditable(false);
		tSalud.setEditable(false);
		tPesion.setEditable(false);
		tSubTotal2.setEditable(false);
		
		lSueldoQuincenal.setForeground(new Color(220,220,220));
		lTotalRecargos.setForeground(new Color(220,220,220));
		lSubTotal.setForeground(new Color(220,220,220));
		lSalud.setForeground(new Color(220,220,220));
		lPesion.setForeground(new Color(220,220,220));
		lSubTotal2.setForeground(new Color(220,220,220));
		
		lNetoPago.setBounds(100,350,100,20);
		lNetoPago.setForeground(new Color(220,220,220));
				
		
		JScrollPane sBarra = new JScrollPane(taNeto,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sBarra.setBounds(205, 335, 250, 100);
				
		
		bCalcular.setBounds(570, 340, 100, 40);
		bCalcular.addActionListener(this);
		
		// agregar elementos a paneles
		pSubtotal.add(lSueldoQuincenal);
		pSubtotal.add(lTotalRecargos);
		pSubtotal.add(lSubTotal);
		pSubtotal.add(lSalud);
		pSubtotal.add(lPesion);
		pSubtotal.add(lSubTotal2);
		
		pSubtotal.add(tSueldoQuincenal);
		pSubtotal.add(tTotalRecargos);
		pSubtotal.add(tSubTotal);
		pSubtotal.add(tSalud);
		pSubtotal.add(tPesion);
		pSubtotal.add(tSubTotal2);
		
		pRecargos.add(lNocturnas);
		pRecargos.add(lDominicales);
		pRecargos.add(lNocturnasDominicales);
		pRecargos.add(tNocturnas);
		pRecargos.add(tDominicales);
		pRecargos.add(tNocturnasDominicales);
		
		pEncabezado.add(liBanco);
		pEncabezado.add(liMenu);
		pEncabezado.add(lTitulo);
		
		pContenido.add(pSubtotal);
		pContenido.add(lSalarioMes);
		pContenido.add(tSalarioMes);
		pContenido.add(pRecargos);
		pContenido.add(lNetoPago);
		pContenido.add(sBarra);
		pContenido.add(bCalcular);
			
		//add(pMenu);
		add(pEncabezado);
		add(pContenido);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * dominical 0.75
		 * nocturno	 0.35
		 * noct-Dominical 1.1
		 * */
		
		if(tSalarioMes.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(lTotalRecargos, "Ingrese el valor del sueldo mensual");
		}else if(tNocturnas.getText().trim().isEmpty()) {
			tNocturnas.setText("0");
		}else if(tDominicales.getText().trim().isEmpty()) {
			tDominicales.setText("0");
		}else if(tNocturnasDominicales.getText().trim().isEmpty()) {
			tNocturnasDominicales.setText("0");
		}
		double mensual = Double.parseDouble(tSalarioMes.getText());
		double hora = mensual/2/15/8;
		double dominical = (Double.parseDouble(tDominicales.getText())*hora*0.75);
		double nocturno = (Double.parseDouble(tNocturnas.getText())*hora*0.35);
		double quincenal = mensual/2 ;
		double noctDominical = (Double.parseDouble(tNocturnasDominicales.getText())*hora*1.1);
		double subtotal = dominical+nocturno+noctDominical+quincenal;
		
		tSueldoQuincenal.setText(Double.toString(quincenal));
		tTotalRecargos.setText(Double.toString(dominical+nocturno+noctDominical));
		tSubTotal.setText(Double.toString(subtotal));
		
		double salud = subtotal*0.04;
		double pension = subtotal*0.04;
		double subtotal2 = salud+pension;
		
		
		tSalud.setText(Double.toString(salud));
		tPesion.setText(Double.toString(pension));
		tSubTotal2.setText(Double.toString(subtotal2));
		
		double neto =  subtotal - subtotal2;
		
		taNeto.append(Double.toString(neto)+"\n");
		System.out.println("hora: " + hora);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String nombre = ((JLabel) e.getSource()).getName();
		if(nombre.equals("menu")) {
			System.out.println("menu");
			popMenu.show(e.getComponent(), -20, 40);
			
			
		}
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}


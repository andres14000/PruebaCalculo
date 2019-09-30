package pruebaJava;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Panelx extends JPanel {
	public Panelx(int posX,int posY, int x, int y, Color color, LayoutManager esq ) {
		setBounds(posX, posY, x, y);
		setBackground(color);
		setLayout(esq);
		
	}
}

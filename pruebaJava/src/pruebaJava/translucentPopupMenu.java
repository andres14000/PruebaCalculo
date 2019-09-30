package pruebaJava;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;

class TranslucentPopupMenu extends JPopupMenu{
  private static final Color ALPHA_ZERO = new Color(0, true);
  private static final Color POPUP_BACK = new Color(250,250,250,200);
  private static final Color POPUP_LEFT = new Color(230,230,230,200);
  private static final int LEFT_WIDTH = 24;
  @Override public boolean isOpaque() {
    return false;
  }
  @Override public void updateUI() {
    super.updateUI();
    //Test:
    boolean isNimbus = UIManager.getBorder("PopupMenu.border")==null;
    if(isNimbus) {
      //XXX: NimbusLnF not work???
      setBorder(new BorderUIResource(BorderFactory.createLineBorder(Color.GRAY)));
    }
  }
  @Override public JMenuItem add(JMenuItem menuItem) {
    menuItem.setOpaque(false);
    return super.add(menuItem);
  }
  @Override public void show(Component c, int x, int y) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        Window p = SwingUtilities.getWindowAncestor(TranslucentPopupMenu.this);
        if(p!=null && p instanceof JWindow) {
          System.out.println("Heavy weight");
          JWindow w = (JWindow)p;
          //To be exact: 1.6.0_10 <= java.version < 1.7.0
          //if(System.getProperty("java.version").startsWith("1.6.0")) {
          //  w.dispose();
          //  if(com.sun.awt.AWTUtilities.isWindowOpaque(w)) {
          //    com.sun.awt.AWTUtilities.setWindowOpaque(w, false);
          //  }
          //  w.setVisible(true);
          //}else{
          w.setBackground(ALPHA_ZERO);
          //}}
        }else{
          System.out.println("Light weight");
        }
      }
    });
    super.show(c, x, y);
  }
  @Override protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D)g.create();
    g2.setPaint(POPUP_LEFT);
    g2.fillRect(0,0,LEFT_WIDTH,getHeight());
    g2.setPaint(POPUP_BACK);
    g2.fillRect(LEFT_WIDTH,0,getWidth(),getHeight());
    g2.dispose();
  }
}
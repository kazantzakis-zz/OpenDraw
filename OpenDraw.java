import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
	
public class OpenDraw {
	
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	}
    	catch(Exception e) {
      		e.printStackTrace();
    	}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
        		new OpenDraw();
        	}
        });
	}

	public OpenDraw() {
				//The windows decorations
				//JFrame.setDefaultLookAndFeelDecorated(true);
                myFrame frame = new myFrame();
                frame.pack();
                frame.setSize(800,600);
                //frame.setLocation(100,200);
                //Κεντράρει το παράθυρο στο κέντρο της οθόνης
                frame.setLocationRelativeTo(null);
                //frame.setResizable(false);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setIconImage(new ImageIcon("icons/appIcon1.png").getImage());
	}
}

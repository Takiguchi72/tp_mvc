package pointEntree;

import vues.MainFrame;
import controleurs.ControleurPrincipal;

public class PointDEntree {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ControleurPrincipal controlleur = new ControleurPrincipal();
			MainFrame frame = new MainFrame(controlleur);
			controlleur.addFrame(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	/**
	 * @param args
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		
		Visage v = new Visage(d);
		d.ajouterObjet(v);
		
		
		Forme f = new Etoile(350,100,50, 8.f,null ,Color.GREEN);
		d.ajouterObjet(f);
		
		Forme p = new PolygoneRegulier(5,200, 50 , 50, 4.0f,Color.BLACK,null);
		d.ajouterObjet(p);
		
		Forme m = new Etoile(350,100,50, 8.f,null ,Color.YELLOW);
		
		Forme o = new PolygoneRegulier(5,200, 50 , 50, 4.0f,Color.GRAY,null);
		
	   MvtCirculaire t = new MvtCirculaire(350,100,50,90.8,201.3);
	   
      AnimationForme l = new AnimationForme(m,t);
      AnimationForme k = new AnimationForme(o,t);
		
		d.ajouterObjet(l);
		d.ajouterObjet(k);
		
		
		
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}

	}

}

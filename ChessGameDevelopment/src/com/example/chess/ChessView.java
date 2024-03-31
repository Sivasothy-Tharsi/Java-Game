package com.example.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessView extends JPanel {

	int originX = 50;
	int originY = 45;
	int cellSize = 60;
	Map<String, Image> keyNameValueImage = new HashMap<String, Image>();
	
	public ChessView() {
		String[] imgNames = {
				"Bishop-black",
				"Bishop-white",
				"King-black",
				"King-white",
				"Kinght-black",
				"Kinght-white",
				"Pawn-black",
				"Pawn-white",
				"Queen-black",
				"Queen-white",
				"Rook-black",
				"Rook-white"
		};
		for(String image: imgNames) {
			try {
				Image img = loadImage(image);
				keyNameValueImage.put(image, img);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		
		super.paintChildren(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		drawBoard(g2);
		drawImage(g2, "Bishop-black", 0, 0);
		drawImage(g2, "Rook-white", 0, 1);
		

	}
	
	private void drawImage(Graphics2D g2, String imgName, int col, int row) {
		Image img = keyNameValueImage.get(imgName);
		 if (img != null) {
		        g2.drawImage(img, originX + col * cellSize, originY+ row * cellSize, cellSize, cellSize, null);
		    }
		 
	}

	private Image loadImage(String imgFileName) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		URL res = classLoader.getResource("img/" + imgFileName + ".png");
		if(res == null) {
			return null;
		}else {
			File imgFile = new File(res.toURI());
			return ImageIO.read(imgFile);
		}
		
	}
	
	private void drawBoard(Graphics2D g2) {
		for(int j=0; j<4;j++) {
			for(int i=0; i<4;i++) {
				drawSqure(g2, 0+2*i, 0+2*j, true);
				drawSqure(g2, 1+2*i, 1+2*j, true);
		
				drawSqure(g2, 1+2*i, 0+2*j, false);
				drawSqure(g2, 0+2*i, 1+2*j, false);
			}
		}
			
	}
	private void drawSqure(Graphics2D g2,int col, int row, boolean light) {
		g2.setColor(light? Color.WHITE: Color.GRAY);
		g2.fillRect(originX + col * cellSize, originY + row * cellSize, cellSize, cellSize);
		
	}
}

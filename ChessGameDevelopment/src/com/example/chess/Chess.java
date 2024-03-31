package com.example.chess;

import java.awt.Frame;

import javax.swing.JFrame;

public class Chess {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Chess Game");
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ChessPanel chessPanel = new ChessPanel();
		frame.add(chessPanel);
		frame.setResizable(false);

	}

}

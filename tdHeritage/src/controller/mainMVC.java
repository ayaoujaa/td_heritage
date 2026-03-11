package controller;

import view.index;

public class mainMVC {

	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
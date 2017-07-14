package main.fortressbreaker.htr89.maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import main.fortressbreaker.htr89.maingame.view.WinView;
import main.fortressbreaker.htr89.menu.controller.MenuController;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class WinController implements ActionListener {

	private WinView winView;

	public WinController(String winner, String loser) {
		winView = new WinView();
		winView.getWinner().setText(winner);
		winView.getLoser().setText(loser);
		winView.getStartAgain().addActionListener(this);
		MainFrameSingleton.getInstance().add(winView);
		MainFrameSingleton.getInstance().revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrameSingleton.getInstance().remove(winView);
		MainFrameSingleton.getInstance().revalidate();
		MainFrameSingleton.getInstance().repaint();
		MainFrameSingleton.getInstance().doLayout();
		try {
			new MenuController();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MainFrameSingleton.getInstance().revalidate();
		MainFrameSingleton.getInstance().repaint();
		MainFrameSingleton.getInstance().doLayout();

	}

}

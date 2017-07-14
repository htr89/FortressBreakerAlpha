package main.fortressbreaker.htr89.menu.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import main.fortressbreaker.htr89.login.controller.LoginRequestController;
import main.fortressbreaker.htr89.menu.view.MenuPanelView;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class MenuController implements ActionListener {

	private MenuPanelView menuPanelView;

	public MenuController() throws IOException {
		// TODO Auto-generated constructor stub
		menuPanelView = new MenuPanelView();
		MainFrameSingleton.getInstance().add(menuPanelView);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				menuPanelView.addFirstSetListeningButtons(MenuController.this);
			}
		});
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Image image = toolkit.getImage("gif/rockbullet.png");
		// Cursor c = toolkit.createCustomCursor(image , new
		// Point(menuPanelView.getX(),
		// menuPanelView.getY()), "img");
		// menuPanelView.setCursor (c);

	}

	public static void main(String[] args) {
		try {
			new MenuController();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton abutton = (JButton) e.getSource();

		switch (abutton.getText()) {
		case "Start":
			menuPanelView.addSecondSetListeningButtons(MenuController.this);
			break;
		case "Back":
			menuPanelView.addFirstSetListeningButtons(MenuController.this);
			break;
		case "Highscore":
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().browse(new URI("http://localhost:8080/FBDatabaseWeb/FBServlet"));
				} catch (URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case "Player vs Ai":
			MainFrameSingleton.getInstance().remove(menuPanelView);
			MainFrameSingleton.getInstance().repaint();
			try {
				new LoginRequestController();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Exit":
			System.exit(0);
			break;

		default:
			break;
		}

	}

}

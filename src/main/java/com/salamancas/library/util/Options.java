package com.salamancas.library.util;

import com.salamancas.library.model.database.LibrarianAccount;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Options {

	private static Options instance;

	private LibrarianAccount loggedInUser;
	private Stage logIn;
	private Stage library;

	private Options() {}

	public static void initialize(Stage logIn) {
		if(instance != null) {
			return;
		}
		instance = new Options();
		instance.logIn = logIn;
	}

	public static Options getInstance() {
		if(instance == null) {
			System.out.println("Options must be initialized first");
			return null;
		}
		return instance;
	}

	public void switchStage() {
		if(library == null) {
			try {
				Stage library = new Stage();
				FXMLLoader fxmlLoader = new FXMLLoader(Assets.library);
				Scene scene = new Scene(fxmlLoader.load());
				scene.getStylesheets().add(getClass().getResource("/com/salamancas/library/assets/css/main.css").toExternalForm());
				library.setScene(scene);
				library.setTitle("Library");
				this.library = library;
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(logIn.isShowing()) {
			logIn.hide();
			library.show();
			return;
		}
		library.hide();
		library = null;
		logIn.show();
	}

	public LibrarianAccount getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(LibrarianAccount loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

}

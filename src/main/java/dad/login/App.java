package dad.login;

import dad.login.mvc.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private LoginController controller = new LoginController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(controller.getView(), 350, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

    }

}
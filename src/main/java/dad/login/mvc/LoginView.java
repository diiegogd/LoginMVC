package dad.login.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

    // Declaración de variables de la clase
    private Label usuarioLabel, contrasenaLabel;
    private TextField usuarioTextField;
    private PasswordField contrasenaPassField;
    private CheckBox checkBox1;
    private Button accederButton, cancelarButton;

    public LoginView() {
        super();

        // Inicialización de los elementos de la interfaz de usuario
        usuarioLabel = new Label("Usuario:");
        usuarioTextField = new TextField();
        usuarioTextField.setPromptText("Nombre de usuario");

        contrasenaLabel = new Label("Contraseña:");
        contrasenaPassField = new PasswordField();
        contrasenaPassField.setPromptText("Contraseña del usuario");

        checkBox1 = new CheckBox("Usar LDAP");

        accederButton = new Button("Acceder");
        cancelarButton = new Button("Cancelar");

        // Creación y configuración de contenedores para organizar los elementos de la interfaz
        HBox usuarioBox = new HBox(usuarioLabel, usuarioTextField);
        usuarioBox.setPadding(new Insets(5));
        usuarioBox.setAlignment(Pos.CENTER);

        HBox contrasenaBox = new HBox(contrasenaLabel, contrasenaPassField);
        contrasenaBox.setPadding(new Insets(5));
        contrasenaBox.setAlignment(Pos.CENTER);

        HBox botonesBox = new HBox(accederButton, cancelarButton);
        botonesBox.setPadding(new Insets(5));
        botonesBox.setAlignment(Pos.CENTER);

        // Agregar elementos al contenedor principal (VBox)
        getChildren().addAll(usuarioBox, contrasenaBox, checkBox1, botonesBox);
        setAlignment(Pos.CENTER);
        setSpacing(10);

    }

    // Métodos para obtener referencias a los elementos de la interfaz desde otras clases
    public TextField getUsuarioTextField() {
        return usuarioTextField;
    }

    public PasswordField getContrasenaPassField() {
        return contrasenaPassField;
    }

    public CheckBox getCheckBox1() {
        return checkBox1;
    }

    public Button getAccederButton() {
        return accederButton;
    }

    public Button getCancelarButton() {
        return cancelarButton;
    }

}
package dad.login.mvc;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class LoginController {

    // Declaración de instancias de modelo y vista
    private LoginModel model = new LoginModel();
    private LoginView view = new LoginView();

    public LoginController() {

        // Vinculación bidireccional entre propiedades de la vista y del modelo
        view.getUsuarioTextField().textProperty().bindBidirectional(model.usuarioTextFieldProperty());
        view.getContrasenaPassField().textProperty().bindBidirectional(model.contrasenaPassFieldProperty());
        view.getCheckBox1().selectedProperty().bindBidirectional(model.checkBoxProperty());

        // Acción para el botón "Acceder"
        view.getAccederButton().setOnAction(event -> AccederAction());

        // Acción para el botón "Cancelar" que cierra la aplicación
        view.getCancelarButton().setOnAction(e -> Platform.exit());

    }

    // Método para manejar la acción de acceso
    private void AccederAction() {
        // Determinar si se seleccionó la opción LDAP
        boolean ldap = view.getCheckBox1().isSelected();

        // Crear una instancia de AuthService basada en la selección de LDAP o File
        AuthService authService = ldap ? new LdapAuthService() : new FileAuthService();

        try {
            // Intentar iniciar sesión y mostrar mensajes según el resultado
            boolean acceder = authService.login(model.getUsuarioTextField(), model.getContrasenaPassField());
            mostrarMensaje(acceder);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // Método para mostrar mensajes según el resultado de la autenticación
    private void mostrarMensaje(boolean acceder) {
        if (acceder) {
            Alert mensaje1 = new Alert(Alert.AlertType.INFORMATION);
            mensaje1.setTitle("Iniciar sesión");
            mensaje1.setHeaderText("Acceso permitido");
            mensaje1.setContentText("Las credenciales de acceso son válidas.");
            mensaje1.showAndWait();
        } else {
            Alert mensaje2 = new Alert(Alert.AlertType.ERROR);
            mensaje2.setTitle("Iniciar sesión");
            mensaje2.setHeaderText("Acceso denegado");
            mensaje2.setContentText("El usuario y/o la contraseña no son válidos.");
            mensaje2.showAndWait();
        }
    }

    // Método para obtener la vista
    public LoginView getView() {
        return view;
    }

}
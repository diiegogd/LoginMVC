package dad.login.mvc;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {

    // Declaración de propiedades de cadena y propiedad booleana
    private StringProperty usuarioTextField = new SimpleStringProperty();
    private StringProperty contrasenaPassField = new SimpleStringProperty();
    private BooleanProperty checkBox = new SimpleBooleanProperty();

    // Métodos para obtener y establecer valores de las propiedades de cadena y booleana
    public String getUsuarioTextField() {
        return usuarioTextField.get();
    }

    public StringProperty usuarioTextFieldProperty() {
        return usuarioTextField;
    }

    public void setUsuarioTextField(String usuarioTextField) {
        this.usuarioTextField.set(usuarioTextField);
    }

    public String getContrasenaPassField() {
        return contrasenaPassField.get();
    }

    public StringProperty contrasenaPassFieldProperty() {
        return contrasenaPassField;
    }

    public void setContrasenaPassField(String contrasenaPassField) {
        this.contrasenaPassField.set(contrasenaPassField);
    }

    public boolean isCheckBox() {
        return checkBox.get();
    }

    public BooleanProperty checkBoxProperty() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox.set(checkBox);
    }

}
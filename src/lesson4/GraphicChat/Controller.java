package lesson4.GraphicChat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Date;


public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    @FXML
    private Button button;
    private final String def = "Введите сообщение";
    private String bufferStr;
    private Date date = new Date();
    public void EnterSend(KeyEvent keyEvent) {
        if (!(textField.getText().equals(def)||textField.getText().equals(""))) {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                bufferStr = textField.getText() + "    (" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + ")";
                if (!textField.isFocused())
                    textField.setText(def);
                else textField.setText("");

                textArea.appendText(bufferStr + '\n');
            }
        }
    }

    public void Clear(MouseEvent mouseEvent) {
        if (textField.getText().equalsIgnoreCase(def)) textField.setText("");
    }

    public void Send(MouseEvent mouseEvent) {
        if (!(textField.getText().equals(def)||textField.getText().equals(""))) {
            bufferStr = textField.getText() + "    (" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + ")";
            if (!textField.isFocused())
                textField.setText(def);
            else textField.setText("");
            textArea.appendText(bufferStr + '\n');
        }
        textField.setText(def);
    }
}

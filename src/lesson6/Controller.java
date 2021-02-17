package lesson6;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    private Socket socket;
    private final Integer numPort = 8085;
    private final String address = "localhost";
    DataInputStream inputStream;
    DataOutputStream outputStream;
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    private final String def = "Введите сообщение";
    private String bufferStr;

    public void enterSend(KeyEvent keyEvent) {
        if (!(textField.getText().equals(def) || textField.getText().equals(""))) {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                bufferStr = textField.getText();
                if (!textField.isFocused())
                    textField.setText(def);
                else textField.setText("");
                try {
                    outputStream.writeUTF(bufferStr);
                    textArea.appendText(bufferStr + "\n");
                } catch (IOException e) {
                    e.printStackTrace();

                }

            }
        }
    }

    public void clear(MouseEvent mouseEvent) {
        if (textField.getText().equalsIgnoreCase(def)) textField.setText("");
    }

    public void send(MouseEvent mouseEvent) {
        if (!(textField.getText().equals(def) || textField.getText().equals(""))) {

            try {
                outputStream.writeUTF(textField.getText());
                textArea.appendText(textField.getText()+'\n');
                if (!textField.isFocused())
                    textField.setText(def);
                else textField.setText("");
            } catch (IOException ignore) {
            }

        }
        textField.setText(def);
    }

    private void connect() throws IOException {
        socket = new Socket(address, numPort);
        System.out.println(socket.isConnected());

        inputStream = new DataInputStream(socket.getInputStream());

        outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                while (true) {
                    String message = inputStream.readUTF();
                    if (message.equalsIgnoreCase("/stopChat")) {
                        break;
                    }
                    textArea.appendText(message + "\n");
                }

            } catch (IOException ignore) {
            }
        }).start();
    }

    public Controller() {
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


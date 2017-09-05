package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private int firstNumber;
    private String operation;

    @FXML
    private TextField screen;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    private void clearClicked (){
        screen.setText("0");
    }

    @FXML
    private void anyDigitClicked (ActionEvent event){
        String digit = ((Button) event.getSource()).getText();
        String oldText = screen.getText();
        String newText;

        if(oldText.equals("0")){
            newText = digit;
        }else{
            newText = oldText + digit;
        }

        screen.setText(newText);
    }

    @FXML
    private void equalButtonClicked(){
        String nextText = screen.getText();
        int nextNumber = Integer.parseInt(nextText);
        int score = 0;

        switch (operation){
            case "+":
                score = Math.addExact(firstNumber, nextNumber);
                break;
            case "-":
                score = Math.subtractExact(firstNumber, nextNumber);
                break;
            case "*":
                score = Math.multiplyExact(firstNumber, nextNumber);
                break;
            case "/":
                score = Math.floorDiv(firstNumber, nextNumber);
                break;
            case "pow":
                score = (int) Math.pow(firstNumber, nextNumber);
                break;
            default:
                break;
        }
        screen.setText(String.valueOf(score));
    }

    @FXML
    private void sqrButtonClicked(){
        String text = screen.getText();
        firstNumber = Integer.parseInt(text);
        int score = (int) Math.sqrt(firstNumber);
        screen.setText(String.valueOf(score));
    }

    @FXML
    private void backspaceButtonClicked(){
        String text = screen.getText();
        String newText = text.substring(0, text.length()-1);
        screen.setText(newText);
    }

    @FXML
    private void someOperation(ActionEvent event){
        String firstText = screen.getText();
        firstNumber = Integer.parseInt(firstText);
        screen.setText("");
        operation = ((Button) event.getSource()).getText();
    }


}

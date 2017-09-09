package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private String firstText;
    private int firstIntNumber;
    private double firstDoubleNumber;
    private String operation;

    @FXML
    private TextField screen;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        screen.setText("0");
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

        if(oldText.equals("0") && digit.equals(".")){
            newText = oldText + digit;
        }else if (oldText.equals("0")){
            newText = digit;
        }else {
            newText = oldText + digit;
        }

        screen.setText(newText);
    }

    @FXML
    private void equalButtonClicked(){
        String nextText = screen.getText();

        int intScore = 0;
        double doubleScore = 0;

        if(firstText.contains(".") || nextText.contains(".")){
            if(firstIntNumber != 0){
                firstDoubleNumber = (double) firstIntNumber;
            }

            double nextNumber = Double.parseDouble(nextText);

            switch (operation){
                case "+":
                    doubleScore = firstDoubleNumber + nextNumber;
                    break;
                case "-":
                    doubleScore = firstDoubleNumber - nextNumber;
                    break;
                case "*":
                    doubleScore = firstDoubleNumber * nextNumber;
                    break;
                case "/":
                    doubleScore = firstDoubleNumber / nextNumber;
                    break;
                case "pow":
                    doubleScore = Math.pow(firstDoubleNumber, nextNumber);
                    break;
                default:
                    break;
            }

            screen.setText(String.valueOf(doubleScore));

       }else {
            int nextNumber = Integer.parseInt(nextText);
            switch (operation){
                case "+":
                    intScore = firstIntNumber + nextNumber;
                    break;
                case "-":
                    intScore = firstIntNumber - nextNumber;
                    break;
                case "*":
                    intScore = firstIntNumber * nextNumber;
                    break;
                case "/":
                    if(firstIntNumber % nextNumber == 0){
                        intScore = firstIntNumber / nextNumber;
                        screen.setText(String.valueOf(intScore));
                    }else{
                        doubleScore = (double) firstIntNumber / (double) nextNumber;
                        screen.setText(String.valueOf(doubleScore));
                    }
                    break;
                case "pow":
                    intScore = (int) Math.pow(firstIntNumber, nextNumber);
                    break;
                default:
                    break;
            }
            if(operation.equals("/")){
                return;
            }else{
                screen.setText(String.valueOf(intScore));
            }
        }
    }

    @FXML
    private void sqrButtonClicked(){
        firstText = screen.getText();
        double score = 0;

        if(firstText.contains(".")){
            firstDoubleNumber = Double.parseDouble(firstText);
            score = Math.sqrt(firstDoubleNumber);

        }else{
            firstIntNumber = Integer.parseInt(firstText);
            score = Math.sqrt(firstIntNumber);
        }
        screen.setText(String.valueOf(score));
    }

    @FXML
    private void backspaceButtonClicked(){
        firstText = screen.getText();
        String newText = firstText.substring(0, firstText.length()-1);
        screen.setText(newText);
    }

    @FXML
    private void someOperation(ActionEvent event){
        firstText = screen.getText();
        if(firstText.contains(".")){
            firstDoubleNumber = Double.parseDouble(firstText);
        }else{
            firstIntNumber = Integer.parseInt(firstText);
        }

        screen.setText("");
        operation = ((Button) event.getSource()).getText();
    }
}

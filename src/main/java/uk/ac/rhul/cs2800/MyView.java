package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * This class evaluates both Infix and Postfix expressions within the CS2800 Calculator application
 * using objects from previous classes.
 * 
 * @author Michael Panlilio
 */
public class MyView {
  RhulStandardCalc infixCalc = new RhulStandardCalc();
  RhulRevPolishCalc postfixCalc = new RhulRevPolishCalc();
  @FXML
  private ToggleGroup CalcMode;

  @FXML
  private Button calcButton;

  @FXML
  private TextField resultField;

  @FXML
  private TextField expressionField;

  @FXML
  private RadioButton infixButton;

  @FXML
  private RadioButton postfixButton;

  /**
   * This method makes the resultField to not be edited so it can only display the answer and an
   * invalid warning.
   */
  @FXML
  private void initialize() {
    resultField.setEditable(false);
  }

  /**
   * Uses selection statements that outputs the answer on the resultField by using evaluate()
   * whether the Postfix or Infix class is used.
   * 
   * @param event the button that is pressed
   * @throws BadTypeException if the type value is incorrect from the specialised stack.
   * @throws EmptyStackException if there are no elements in the stack therefore it's empty
   * @throws NumberFormatException if the converted string is incorrect format
   */
  @FXML
  void isPressed(ActionEvent event)
      throws BadTypeException, EmptyStackException, NumberFormatException {
    resultField.setText("What are you trying to calculate?");
    String inputExpression = expressionField.getText();
    float result;
    if (infixButton.isSelected()) {
      try {
        result = infixCalc.evaluate(inputExpression);
        resultField.setText(String.valueOf(result));
      } catch (BadTypeException | EmptyStackException | NumberFormatException e) {
        resultField.setText("INVALID! Enter Infix Expression");
      }
    }
    if (postfixButton.isSelected()) {
      try {
        result = postfixCalc.evaluate(inputExpression);
        resultField.setText(String.valueOf(result));
      } catch (BadTypeException | EmptyStackException | NumberFormatException e) {
        resultField.setText("INVALID! Enter Postfix Expression");
      }
    }
  }

  @FXML
  // Notifies the client that they need to enter an Infix expression as that's the option they've
  // chosen.
  void calcInfix(ActionEvent event) {
    resultField.setText("Infix Mode Set");
  }

  @FXML
  // Notifies the client that they need to enter an Postfix expression as that's the option they've
  // chosen.
  void calcPostfix(ActionEvent event) {
    resultField.setText("Postfix Mode Set");
  }
}



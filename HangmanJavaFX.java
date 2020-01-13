/**
 * Import all the necessary tools from the Java API   = JULIEN
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;


public class HangmanJavaFX<Vbox> extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initialize a hangman object   ==== JULIEN
     */

    HangmanGame hangman = new HangmanGame();

    @Override
    public void start(Stage primaryStage)
    {

        /**
         * Create a grid to format all the nodes
         * Align the grid to the center of the GUI   ==== KEVIN
         */

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        TextArea outputMessage = new TextArea();


        /**
         * Create a label named "Guess a letter "
         * Create a text field for the User's letter  ============= MILES
         */


        Label label = new Label ("Guess a letter: ");
        grid.add(label, 0, 1);
        TextField textBox = new TextField();
        grid.add(textBox, 1, 1);

        /**
         * Create a label for the output named "Output: "    ======= NIHAL
         * Create a text field for the output
         */

        Label outputLabel = new Label ("Output: ");
        grid.add(outputLabel, 0, 2);
        TextField outputBox = new TextField();
        grid.add(outputBox, 1, 2);

        /**
         * Create a label for where the Hangman picture appears ===== JULIEN
         * Add the label to the grid
         */

        Label outputPicture = new Label ("HangMan");
        grid.add(outputPicture, 5, 1);

        /**
         * Create a title for the program named "Hangman Game"
         * and set the font to 20
         * Add the title to the grid at the certain position   ====== NIHAL
         */

        Text title = new Text("Hangman Game");
        title.setFont(Font.font(20));
        grid.add(title, 1, 0, 2, 1);

        textBox.setPrefColumnCount(10);

        /**
         * Create a button named "Enter" and create a button    ==== MILES
         * named "Reset"
         * Add the two buttons to the grid
         */

        Button btn = new Button("Enter");
        grid.add(btn, 2,1);
        Button btn1 = new Button("Reset");
        grid.add(btn1, 2, 2);

        /**
         * Create two final Text objects named actiontarget   ===== JULIEN
         * and outputFinish
         * These two will display the output result
         */

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 3);
        final Text outputFinish = new Text();
        grid.add(outputFinish, 1, 4);
        Node node = grid.getChildren().get(8);


        /**
         * Add an EventHandler to the actiontarget button ==== JULIEN
         */


        btn.setOnAction(new EventHandler<ActionEvent>()
                        {
                            @Override
                            public void handle(ActionEvent event)
                            {

                                /**
                                 * Declare and Initialize userLetter to the letter that
                                 * the user enters
                                 * Declare and initialize userLetterArray to the char array
                                 * of the User's letter
                                 * Call in the letterChange method to compare the User's letter   ===== NIHAL
                                 * to any of the letters inside the random word.
                                 * If any of them match, then change the letter to the User's letter
                                 */

                                String userLetter = textBox.getText(0,1);
                                char[] userLetterArray = hangman.word(userLetter);
                                hangman.letterChange(hangman.getWordArray(), userLetterArray, hangman.getDashedLinesArray());
                                boolean gameFinish = hangman.isFinished(hangman.getDashedLinesArray());

                                /**
                                 * Set the TextField outputBox to print out the dashedLinesArray   ==== NIHAL
                                 */

                                outputBox.setText(Arrays.toString(hangman.getDashedLinesArray()));

                                /**
                                 * If the User's letter is found in the random word then   ===== MILES
                                 * print to the User that they're guessed right
                                 * If the User guessed wrong then print out an image
                                 * of the hangman and tell the User that they're wrong
                                 */

                                if (hangman.isLetterIsRight(hangman.getWordArray(), userLetterArray))
                                {
                                    actiontarget.setText("\"" + userLetter + "\" is found in the word.");

                                }
                                else
                                {
                                    /**
                                     * Create a try catch block to catch a malformed URL exception   ==== MILES
                                     */

                                    try {
                                        File HangmanHead1 = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\HangmanHead.png");
                                        String HangmanHead = HangmanHead1.toURI().toURL().toString();
                                        Image hangmanHeadImage = new Image(HangmanHead);
                                        ImageView iv1 = new ImageView();
                                        iv1.setFitHeight(200);
                                        iv1.setFitWidth(200);
                                        iv1.setImage(hangmanHeadImage);
                                        File hangman2File = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\Hangman2.png");
                                        String hangman2 = hangman2File.toURI().toURL().toString();
                                        Image hangman2Image = new Image(hangman2);
                                        ImageView iv2 = new ImageView();
                                        iv2.setFitHeight(200);
                                        iv2.setFitWidth(200);
                                        iv2.setImage(hangman2Image);
                                        File hangman3File = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\Hangman33.png");
                                        String hangman3 = hangman3File.toURI().toURL().toString();
                                        Image hangman3Image = new Image(hangman3);
                                        ImageView iv3 = new ImageView();
                                        iv3.setFitHeight(200);
                                        iv3.setFitWidth(200);
                                        iv3.setImage(hangman3Image);
                                        File hangman4File = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\Hangman44.png");
                                        String hangman4 = hangman4File.toURI().toURL().toString();
                                        Image hangman4Image = new Image(hangman4);
                                        ImageView iv4 = new ImageView();
                                        iv4.setFitHeight(200);
                                        iv4.setFitWidth(200);
                                        iv4.setImage(hangman4Image);
                                        File hangman5File = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\Hangman55.png");
                                        String hangman5 = hangman5File.toURI().toURL().toString();
                                        Image hangman5Image = new Image(hangman5);
                                        ImageView iv5 = new ImageView();
                                        iv5.setFitHeight(200);
                                        iv5.setFitWidth(200);
                                        iv5.setImage(hangman5Image);
                                        File hangman6File = new File ("C:\\Users\\Kevin\\Desktop\\Project Images\\Hangman66.png");
                                        String hangman6 = hangman6File.toURI().toURL().toString();
                                        Image hangman6Image = new Image(hangman6);
                                        ImageView iv6 = new ImageView();
                                        iv6.setFitHeight(200);
                                        iv6.setFitWidth(200);
                                        iv6.setImage(hangman6Image);

                                        /**
                                         * Create a switch statement where each time the User
                                         * guesses wrong then a different image of the hangman      ==== JULIEN
                                         * appears
                                         */

                                        switch (hangman.getHangmanbodyCounter())
                                        {
                                            case 1: grid.add(iv1, 5, 2);
                                                break;
                                            case 2: grid.add(iv2, 5, 2);
                                                break;
                                            case 3: grid.add(iv3, 5, 2);
                                                break;
                                            case 4: grid.add(iv4, 5, 2);
                                                break;
                                            case 5: grid.add(iv5, 5, 2);
                                                break;
                                            case 6:  grid.add(iv6, 5, 2);
                                                break;
                                        }

                                    }
                                    catch (MalformedURLException e) {
                                        e.printStackTrace();
                                    }

                                    /**
                                     * Set the text of actiontarget to print out that   ===== KEVIN
                                     * the User guessed it wrong
                                     */

                                    actiontarget.setText("\"" + userLetter + "\" was not found in the word. Try again.");
                                }

                                /**
                                 * Call the gameFinish method to check if the
                                 * whole word is guessed.
                                 * If the game is finished, then congratulate the    ===== NIHAL
                                 * User on winning
                                 * If the game is not finished and the User guessed
                                 * too many times, then print to the User that they
                                 * lost
                                 */

                                if (gameFinish)
                                {
                                    outputFinish.setText("Congratulations. You've guessed the whole word!");
                                    actiontarget.setText("");
                                }

                                if (hangman.getHangmanbodyCounter() == 6)
                                {
                                    actiontarget.setText("");
                                    outputFinish.setText("You Lost. Hit the reset button.");
                                }


                            }
                        }
        );

        /**
         * Add an EventHandler to the reset button
         * When the user hits the reset button, the whole program will reset.   ========= NIHAL
         */

        btn1.setOnAction(new EventHandler<ActionEvent>()
                         {
                             @Override
                             public void handle(ActionEvent event) {
                                 hangman.newRandomIndex();
                                 hangman.newRandomWord();
                                 hangman.newDashedLinesArray();
                                 outputBox.setText(Arrays.toString(hangman.getDashedLinesArray()));
                                 actiontarget.setText("");

                                 grid.getChildren().clear();
                                 hangman.setHangmanbodyCounter(0);
                                 grid.getChildren().addAll(title,label, textBox,outputBox, outputLabel, outputPicture,actiontarget, btn, btn1);
                             }
                         }
        );

        /**
         * Set the grid size and set the background color of the GUI =========== KEVIN
         */

        grid.setMinSize(900, 550);
        BackgroundFill backgroundColor = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundColor);
        grid.setBackground(background);

        /**
         * Create the stage   ====== KEVIN
         */

        Scene scene = new Scene (grid);
        primaryStage.setTitle("Hangman Game");
        primaryStage.setScene(scene);

        /**
         * Show the stage     ====== KEVIN
         */

        primaryStage.show();
    }
}


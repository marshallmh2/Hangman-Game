import javafx.stage.Stage;

/**
 * Import Arrays from the Java API                ===== KEVIN
 */

import java.util.Arrays;

public class HangmanGame
{

    /**
     * Declare variables such as randomIndex, dictionary, randomWord,
     * wordArray, dashedLinesArray, letterIsRight, and hangmanbodyCounter           ======== KEVIN
     * Initialize String array dictionary to random words. This will act
     * as the actual dictionary for the hangman game.
     */

    private int randomIndex;
    private String [] dictionary = {"elephant", "ants", "france", "television", "jupiter", "kale", "lebron"
            ,"sun", "computer", "science", "basketball", "chair", "fundamental"
            ,"calculus","math","cat","dog","fish","garbage","battery", "backpack"
            ,"moon", "heart", "love", "bird","eagle","starfish","football","soccer"
            ,"rainbow","richmond","virginia"};;
    private String randomWord;
    private char [] wordArray;
    private char [] dashedLinesArray;
    private boolean letterIsRight;
    private int hangmanbodyCounter;

    /**
     * Create a no-arg constructor for HangmanGame.
     * This no-arg constructor will set the instance variables                 ====== MILES
     * to the default values. In addition, fill the dashedLinesArray
     * with dashes.
     */

    public HangmanGame ()
    {
        this.randomIndex = (int) (Math.random() * dictionary.length);
        this.randomWord = dictionary[randomIndex];
        this.wordArray = randomWord.toCharArray();
        this.letterIsRight = false;
        this.dashedLinesArray = new char[randomWord.length()];
        Arrays.fill(dashedLinesArray, '-');
        this.hangmanbodyCounter = 0;
    }

    /**
     * Create a getter method to return the value   ====== JULIEN
     * of randomIndex
     */

    public int getRandomIndex ()
    {
        return this.randomIndex;
    }

    /**
     * Create a getter method to return the value
     * of randomWord
     */

    public String getRandomWord ()
    {
        return this.randomWord;
    }

    /**
     * Create a getter method to return the value
     * of wordArray
     */

    public char [] getWordArray ()
    {
        return this.wordArray;
    }

    /**
     * Create a getter method to return the value
     * of dashedLinesArray
     */

    public char [] getDashedLinesArray ()
    {
        return this.dashedLinesArray;
    }

    /**
     * Create a getter method to return the value
     * of letterIsRight
     */

    public boolean getLetterIsRight ()
    {
        return this.letterIsRight;
    }

    /**
     * Create a getter method to return the value
     * of hangmanbodyCounter
     */

    public int getHangmanbodyCounter ()
    {
        return this.hangmanbodyCounter;
    }

    /**
     * Create a setter method to set the value
     * of randomIndex
     */

    public void setRandomIndex (int num)
    {
        this.randomIndex = num;
    }

    /**
     * Create a setter method to set the value
     * of randomWord
     */

    public void setRandomWord (String word)
    {
        this.randomWord = word;
    }

    /**
     * Create a setter method to set the value
     * of wordArray
     */

    public void setWordArray (String word)
    {
        this.wordArray = word.toCharArray();
    }

    /**
     * Create a setter method to set the elements
     * inside dashedLinesArray to the dashes
     */

    public void setDashedLinesArray (char [] dashlines)
    {
        Arrays.fill(dashlines, '-');
    }

    /**
     * Create a setter method to set the
     * letterIsRight variable
     */

    public void setLetterIsRight (boolean rightOrWrong)
    {
        this.letterIsRight = rightOrWrong;
    }

    /**
     * Create a setter method to set the value
     * of hangmanbodyCounter
     */

    public void setHangmanbodyCounter (int num)
    {
        this.hangmanbodyCounter = num;
    }

    /**
     * Create a method called letterChange that will check if the User's
     * letter matches any of the letters inside the random word.                       ==== NIHAL
     * If so, change the position of the letter to the User's letter
     */

    public void letterChange (char[] wordArray, char[] userLetterArray, char[] dashedLineArray)
    {
        for (int k = 0; k < wordArray.length; k++)
        {
            if (userLetterArray[0] == wordArray[k])
            {
                dashedLineArray[k] = userLetterArray[0];
            }
        }

    }

    /**
     * Create a method called isLetterIsRight that will check if the letter does match        ======== MILES
     * any of the letters inside the word.
     * If so, then return a boolean value
     */

    public boolean isLetterIsRight (char[] wordArray, char[] userLetterArray)
    {
        boolean isLetterRight = false;
        int x = 0;
        while (x < wordArray.length)
        {
            if (userLetterArray[0] == wordArray[x])
            {
                isLetterRight = true;
            }
            x++;
        }
        if (!(isLetterRight))
        {
            this.hangmanbodyCounter++;
        }
        return isLetterRight;
    }

    /**
     * Create a randomWordGenerator method that will     ====== JULIEN
     * create a brand new word
     */

    public String randomWordGenerator ()
    {
        int num = (int) (Math.random() * dictionary.length);
        return dictionary[num];
    }

    /**
     * Create a word method that will return   ======== JULIEN
     * the word in a char array
     */

    public char [] word (String randomWord)
    {
        return randomWord.toCharArray();
    }

    /**
     * Create a newRandomIndex method that will
     * set the randomIndex to a new random index of the    ==========     KEVIN
     * dictionary
     */

    public void newRandomIndex ()
    {
        randomIndex = (int) (Math.random() * dictionary.length);
    }

    /**
     * Create a newRandomWord method that will change the
     * randomWord variable to a new word in the dictionary
     * Pass in the randomWord to the word method                        ==== MILES
     * Set the wordArray to the randomWord after invoking the
     * word method
     */

    public void newRandomWord ()
    {
        this.randomWord = dictionary[randomIndex];
        wordArray = word(randomWord);
    }

    /**
     * Create a newDashedLinesArray method that will set      ===== NIHAL
     * all the elements inside the array to dashes
     */

    public void newDashedLinesArray ()
    {
        dashedLinesArray = new char[randomWord.length()];
        Arrays.fill(dashedLinesArray, '-');
    }

    /**
     * Create a isFinished method that will check if the whole   ===== NIHAL
     * word is guessed.
     * If so, return true if all the letters are guessed,
     * otherwise return false
     */

    public boolean isFinished (char [] dashedLines)
    {
        boolean isFinish = true;
        for (int k = 0; k < dashedLines.length; k++)
        {
            if (dashedLines[k] == '-')
            {
                isFinish = false;
            }
        }
        return isFinish;
    }
}

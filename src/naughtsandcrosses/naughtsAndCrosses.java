
package naughtsandcrosses;

import javax.swing.*;


public class naughtsAndCrosses {

    public static void main(String[] args) {

        JFrame newGame = new gameWindow();
        newGame.setSize(600, 700);
        newGame.setDefaultCloseOperation(newGame.EXIT_ON_CLOSE);
        newGame.setResizable(false);
        newGame.setVisible(true);
       
    }

}

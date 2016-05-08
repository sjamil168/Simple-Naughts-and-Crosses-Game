package naughtsandcrosses;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;


public class gameWindow extends JFrame {

    //turn indicator
    private char turn = 'X';

    //create reset game button
    private JButton clear;

    private boolean gameOver;

    //create cell grid
    private Cell[] [] cells = new Cell [3][3];

    //Create Status Label
    JLabel status = new JLabel ("X's turn");



   public gameWindow (){

       
       //Cell  Panel
        JPanel panel = new JPanel (new GridLayout (3, 3, 0,0));
        for (int i = 0; i <3; i ++)
            for (int j = 0; j <3; j++)
                panel.add(cells[i][j] = new Cell());
            

        panel.setBorder(new LineBorder (Color.RED, 1));
        status.setBorder(new LineBorder (Color.BLUE, 1));
       


         add(panel, BorderLayout.CENTER);
         add (status, BorderLayout.SOUTH);

     
       
    }


   public boolean isFull(){
       //Checks if gameboard is full

         for (int i = 0; i <3; i ++){
            for (int j = 0; j <3; j++){
                if (cells [i] [j].getToken() == ' ')
                    return false;
            }
       }
         return true;
    }

   public boolean isWon(char token){
       //Checks if the game is won

       //check rows
       for (int i =0; i<3; i++)
           if ((cells[i][0].getToken()==token)
               && (cells [i][1].getToken() == token)
               && (cells [i][2].getToken()==token))
           {
               return true;
           }
       //check columns
         for (int j =0; j<3; j++)
           if ((cells[0][j].getToken()==token)
               && (cells [1][j].getToken() == token)
               && (cells [2][j].getToken()==token))
           {
               return true;
            }
       //check diagnals
       if ((cells[0][0].getToken()==token)
               && (cells [1][1].getToken() == token)
               && (cells [2][2].getToken()==token))
            {
               return true;
            }
        if ((cells[0][2].getToken()==token)
               && (cells [1][1].getToken() == token)
               && (cells [2][0].getToken()==token))
            {
               return true;
            }

       return false;
   }



   //defines what a Cell is on the gameboard
public class Cell extends JPanel {

    private char token= ' ';

    //constructor for Cell
    public Cell (){

        setBorder (new LineBorder (Color.BLACK,1));
        addMouseListener(new MyMouseListener());
    }

    //return value of token
    public char getToken(){
        return token;
    }

    //sets value of token
    public void setToken (char c){

        token = c;
        repaint();
    }

    @Override
    protected void paintComponent (Graphics g){

        super.paintComponent(g);

        if (token == 'X'){
            g.drawLine (10,10, getWidth() -10, getHeight()-10);
            g.drawLine(getWidth()-10, 10, 10,getHeight()-10);
            }

         else if (token == 'O'){
                g.drawOval(10, 10, getWidth()-20, getHeight()-20);
            }

}

    private class MyMouseListener extends MouseAdapter{

        @Override
        public void mouseClicked (MouseEvent e ){

            if (gameOver)
                return;

            //if cell is empty and game not over
            if (token == ' ' && turn != ' ')
                setToken(turn);

            if  (isWon(turn)){
                status.setText( turn + " WIN'S!");
                turn= ' ';
                gameOver = true;
                 }

            else if (isFull()){
                status.setText( "DRAW!");
                turn = ' ';
                gameOver = true;
            }

            else{
                turn = (turn =='X') ? 'O' : 'X';
                status.setText(turn + " 's turn!");
            }
        }
    }

}




}




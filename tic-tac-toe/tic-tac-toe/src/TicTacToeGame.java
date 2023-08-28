
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame {
    JButton[][] buttons;
    char currentPlayer;

    public TicTacToeGame() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        initializeButtons();
    }

    public void initializeButtons() {
        JPanel panel = new JPanel(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.PLAIN, 60));
                button.addActionListener(new ButtonClickListener(row, col));
                buttons[row][col] = button;
                panel.add(button);
            }
        }

        add(panel);
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][1].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[1][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    public class ButtonClickListener implements ActionListener {
       int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();

            if (buttonClicked.getText().equals("")) {
                buttonClicked.setText(String.valueOf(currentPlayer));
                buttonClicked.setEnabled(false);

                if (checkWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    dispose();  // Close the game window
                } else {
                    if (currentPlayer == 'X') {
                        currentPlayer = 'O';
                    }
                    else {
                        currentPlayer = 'X';
                    }
                    
                }
            }
        }
    }

    public static void main(String[] args) {
            TicTacToeGame game = new TicTacToeGame();
            game.setVisible(true);
        
    }
}










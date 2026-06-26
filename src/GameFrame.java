import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GameLogic gameLogic;
    private Player currentPlayer;
    private PlayerService playerService;

    public GameFrame(Player currentPlayer) {

        this.currentPlayer = currentPlayer;

        playerService = new PlayerService();
        gameLogic = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel board = new JPanel(
                new GridLayout(3, 3));

        JButton[] buttons =
                new JButton[9];

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton("");

            buttons[i].setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            40));

            int index = i;

            buttons[i].addActionListener(e -> {

                if (!gameLogic.makeMove(
                        index,
                        'X')) {
                    return;
                }

                buttons[index].setText("X");

                if (gameLogic.checkWinner('X')) {

                    playerService.updateStatistics(
                            currentPlayer,
                            "WIN");

                    JOptionPane.showMessageDialog(
                            this,
                            "You Win!");

                    dispose();

                    new MenuFrame(currentPlayer);

                    return;
                }

                if (gameLogic.isDraw()) {

                    playerService.updateStatistics(
                            currentPlayer,
                            "DRAW");

                    JOptionPane.showMessageDialog(
                            this,
                            "Draw!");

                    dispose();

                    new MenuFrame(currentPlayer);

                    return;
                }

                int computerMove =
                        gameLogic.computerMove();

                if (computerMove != -1) {

                    gameLogic.makeMove(
                            computerMove,
                            'O');

                    buttons[computerMove]
                            .setText("O");
                }

                if (gameLogic.checkWinner('O')) {

                    playerService.updateStatistics(
                            currentPlayer,
                            "LOSE");

                    JOptionPane.showMessageDialog(
                            this,
                            "Computer Wins!");

                    dispose();

                    new MenuFrame(currentPlayer);

                    return;
                }

                if (gameLogic.isDraw()) {

                    playerService.updateStatistics(
                            currentPlayer,
                            "DRAW");

                    JOptionPane.showMessageDialog(
                            this,
                            "Draw!");

                    dispose();

                    new MenuFrame(currentPlayer);
                }
            });

            board.add(buttons[i]);
        }

        add(board);

        setVisible(true);
    }
}
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameFrame extends JFrame {

    private GameLogic gameLogic;
    private Player currentPlayer;
    private PlayerService playerService;

    public GameFrame(Player player) {

        currentPlayer = player;
        playerService = new PlayerService();
        gameLogic = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(520, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color background = new Color(245, 247, 250);
        Color primary = new Color(52, 152, 219);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(background);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(background);
        topPanel.setBorder(new EmptyBorder(20,20,20,20));

        JLabel title = new JLabel("TIC TAC TOE");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(primary);

        topPanel.add(title);

        JPanel boardPanel = new JPanel(new GridLayout(3,3,8,8));
        boardPanel.setBackground(background);
        boardPanel.setBorder(new EmptyBorder(20,30,30,30));

        JButton[] buttons = new JButton[9];

        for(int i=0;i<9;i++){

            JButton button = new JButton("");

            button.setBackground(Color.WHITE);
            button.setFocusPainted(false);

            button.setFont(new Font(
                    "Segoe UI",
                    Font.BOLD,
                    60));

            int index = i;

            button.addActionListener(e->{

                if(!button.getText().equals(""))
                    return;

                if(gameLogic.makeMove(index,'X')){

                    button.setText("X");
                    button.setForeground(new Color(41,128,185));

                    if(gameLogic.checkWinner('X')){

                        playerService.updateStatistics(
                                currentPlayer,
                                "WIN");

                        JOptionPane.showMessageDialog(
                                this,
                                "🎉 You Win!");

                        dispose();
                        new MenuFrame(currentPlayer);
                        return;
                    }

                    if(gameLogic.isDraw()){

                        playerService.updateStatistics(
                                currentPlayer,
                                "DRAW");

                        JOptionPane.showMessageDialog(
                                this,
                                "🤝 Draw!");

                        dispose();
                        new MenuFrame(currentPlayer);
                        return;
                    }

                    int computerMove =
                            gameLogic.computerMove();

                    if(computerMove!=-1){

                        gameLogic.makeMove(
                                computerMove,
                                'O');

                        buttons[computerMove]
                                .setText("O");

                        buttons[computerMove]
                                .setForeground(
                                        Color.RED);

                        if(gameLogic.checkWinner('O')){

                            playerService.updateStatistics(
                                    currentPlayer,
                                    "LOSE");

                            JOptionPane.showMessageDialog(
                                    this,
                                    "😥 Computer Wins!");

                            dispose();
                            new MenuFrame(currentPlayer);
                            return;
                        }

                        if(gameLogic.isDraw()){

                            playerService.updateStatistics(
                                    currentPlayer,
                                    "DRAW");

                            JOptionPane.showMessageDialog(
                                    this,
                                    "🤝 Draw!");

                            dispose();
                            new MenuFrame(currentPlayer);
                        }

                    }

                }

            });

            buttons[i]=button;
            boardPanel.add(button);

        }

        JLabel info = new JLabel(
                "Player : "
                + currentPlayer.getUsername(),
                SwingConstants.CENTER);

        info.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                16));

        info.setBorder(
                new EmptyBorder(0,0,20,0));

        mainPanel.add(topPanel,
                BorderLayout.NORTH);

        mainPanel.add(boardPanel,
                BorderLayout.CENTER);

        mainPanel.add(info,
                BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);

    }

}
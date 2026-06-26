import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Tic Tac Toe");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color background = new Color(245, 247, 250);
        Color primary = new Color(52, 152, 219);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(background);
        panel.setBorder(new EmptyBorder(25, 35, 25, 35));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel title = new JLabel("TIC TAC TOE", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 34));
        title.setForeground(primary);

        JLabel subtitle = new JLabel("Login to continue", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(Color.GRAY);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JTextField userField = new JTextField();
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userField.setPreferredSize(new Dimension(0, 40));

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passField.setPreferredSize(new Dimension(0, 40));

        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        loginButton.setBackground(primary);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(0, 45));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridy++;
        panel.add(subtitle, gbc);

        gbc.gridy++;
        panel.add(Box.createVerticalStrut(15), gbc);

        gbc.gridy++;
        panel.add(userLabel, gbc);

        gbc.gridy++;
        panel.add(userField, gbc);

        gbc.gridy++;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy++;
        panel.add(passLabel, gbc);

        gbc.gridy++;
        panel.add(passField, gbc);

        gbc.gridy++;
        panel.add(Box.createVerticalStrut(20), gbc);

        gbc.gridy++;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            PlayerService service = new PlayerService();

            Player player = service.login(username, password);

            if (player != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome, " + player.getUsername() + "!"
                );

                new MenuFrame(player);
                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Username or Password is incorrect!"
                );
            }
        });

        add(panel);
        setVisible(true);
    }
}
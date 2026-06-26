import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Login Tic Tac Toe");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            PlayerService service =
                    new PlayerService();

            Player player =
                    service.login(username, password);

            if (player != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login berhasil!");

                new MenuFrame(player);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Username atau password salah!");
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }
}
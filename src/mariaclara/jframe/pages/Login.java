package mariaclara.jframe.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
   private JTextField usernameField;
   private JButton loginButton;
   private String username;

   public Login() {
       this.setTitle("Login");
       this.setSize(400, 200);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new GridLayout(3, 1));

       JLabel usernameLabel = new JLabel("Digite seu nome:");
       usernameField = new JTextField();
       loginButton = new JButton("Iniciar Jogo");
       loginButton.addActionListener(this);

       this.add(usernameLabel);
       this.add(usernameField);
       this.add(loginButton);

       this.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       if (e.getSource() == loginButton) {
           username = usernameField.getText();
           this.dispose();  // Fecha a janela de login
           new Jogo(username);  // Inicia o jogo com o nome do usuário
       }
   }
}
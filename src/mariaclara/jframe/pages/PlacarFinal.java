package mariaclara.jframe.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlacarFinal extends JFrame implements ActionListener {
    private JLabel resultLabel;
    private JButton playAgainButton, exitButton;

    public PlacarFinal(String username, int points, boolean userWon) {
        this.setTitle("Placar Final");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        if (userWon) {
            resultLabel = new JLabel("Parabéns, " + username + "! Você ganhou com " + points + " pontos!", SwingConstants.CENTER);
        } else {
            resultLabel = new JLabel("Você perdeu, " + username + ". Pontos: " + points, SwingConstants.CENTER);
        }

        playAgainButton = new JButton("Jogar Novamente");
        playAgainButton.addActionListener(this);
        exitButton = new JButton("Sair");
        exitButton.addActionListener(this);

        this.add(resultLabel);
        this.add(playAgainButton);
        this.add(exitButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgainButton) {
            this.dispose();
            new Login();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
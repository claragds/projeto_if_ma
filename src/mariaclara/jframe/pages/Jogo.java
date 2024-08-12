package mariaclara.jframe.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Jogo extends JFrame implements ActionListener {
    private String username;
    private JLabel userCarLabel, opponentCarLabel;
    private Timer timer;
    private int userCarY = 520, opponentCarY = 0;
    private int points = 0;
    private JButton accelerateButton;
    private JLabel background;

    public Jogo(String username) {
    	this.background = new JLabel(new ImageIcon(Jogo.class.getResource("/mariaclara/jframe/imagem_pista.png")));
    	background.setBounds(0, -92, 586, 945);
    	
    	
        this.username = username;
        this.setTitle("Corrida de Carros");
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Configurando carros
        userCarLabel = new JLabel(new ImageIcon(Jogo.class.getResource("/mariaclara/jframe/car__1.png")));
        userCarLabel.setBounds(153, 520, 50, 100);
        getContentPane().add(userCarLabel);

        opponentCarLabel = new JLabel(new ImageIcon(Jogo.class.getResource("/mariaclara/jframe/car__2.png")));
        opponentCarLabel.setBounds(385, 520, 50, 100);
        getContentPane().add(opponentCarLabel);

        // Botão de aceleração
        accelerateButton = new JButton("Acelerar");
        accelerateButton.setBounds(237, 594, 100, 50);
        accelerateButton.addActionListener(this);
        getContentPane().add(accelerateButton);

        // Timer para o jogo
        timer = new Timer(100, this);
        timer.start();

        getContentPane().add(background);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accelerateButton) {
            userCarY -= 10;
            points += 10;
            userCarLabel.setBounds(153, userCarY, 50, 100);
        }

        // Movimento do carro oponente
        opponentCarY += 5 + new Random().nextInt(5);  // Velocidade aleatória
        opponentCarLabel.setBounds(350, opponentCarY, 50, 100);

        // Verifica se o usuário ou oponente ganhou
        if (userCarY <= 0) {
            timer.stop();
            this.dispose();
            new PlacarFinal(username, points, true);
        } else if (opponentCarY >= 700) {
            timer.stop();
            this.dispose();
            new PlacarFinal(username, points, false);
        }
    }
}

package com.company;
import matrice.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    private static JTextField userText;
    private static JButton launch;
    private static final int w = 525;
    private static final int h = 525;

    public static void main(String[] args)
    {
            //GUI
            JFrame f = new JFrame();

            f.setSize(w,h);
            f.setTitle("Qr code");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setResizable(false);

            JPanel p = new JPanel();
            p.setBackground(new Color(87, 182, 255));

            f.add(p);

            p.setLayout(null);


            JLabel user = new JLabel("Rentrez votre texte à encoder");
            user.setFont(new Font("Arial",Font.PLAIN,25));
            user.setBounds(80,160,500,25);
            p.add(user);

            userText = new JTextField(20);
            userText.setBounds(160,200,165,25);
            p.add(userText);

            launch = new JButton("Qr code");
            launch.setBounds(200,240,80,25);
            launch.addActionListener(new Main());
            p.add(launch);

            f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == launch)
        {
            String input = userText.getText();
            System.out.println(input);

            try{
                // constructeur en prenant que la donnée que l'on veut encoder
                matrice matrice1 = new matrice(input);

                // méthodes pour définir la bonne taille de la matrice
                matrice1.FinalDataEncoded();
                int taille = matrice1.TailleMatrice();
                int [][] m = new int [taille][taille];
                matrice1.setTaille(taille);
                matrice1.setMatrice(m);

                // méthodes pour la construction de la matrice
                matrice1.InitMatrice();
                matrice1.MotifSensMatrice();
                matrice1.PiloteDeTailleMatrice();
                matrice1.DonneesMatrice();
                matrice1.AffichageMatrice();

                // graphisme
                int [][] matriceCouleur;
                matriceCouleur = matrice1.getMatrice();

                Drawing d = new Drawing(w, taille,matriceCouleur);

                JFrame f2 = new JFrame();

                f2.setSize(w,h);
                f2.setTitle("Qr code");
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                f2.add(d);
                f2.setVisible(true);
                f2.setLocationRelativeTo(null);
            }catch (DataLengthException ignored) {}

        }
    }
}

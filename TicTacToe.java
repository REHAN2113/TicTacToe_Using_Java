import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javafx.scene.layout.Pane;

public class TicTacToe extends JFrame implements MouseListener {

    JLabel l1, l2, gameName, l3, gameOver, xwin, owin;
    int n = 1, random, flag = 0;
    String s1;
    String[] o = new String[10];
    String[] x = new String[10];
    JButton exit, rematch;
    JPanel panel;
    ImageIcon xImg, oImg, ocross, overtical, odiagonal, odiagonal1, xcross, xvertical, xdiagonal, xdiagonal1;
    Image resizedX, resizedO, ocrossresized, overticalresized, odiagonalresized, odiagonal1resized, xcrossresized,
            xverticalresized, xdiagonalresized, xdiagonal1resized;
    JButton textFields[] = new JButton[10];
    Image backgroundImage;
    JPanel panel1;

    TicTacToe() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set frame size to 80% of the screen size
        int frameWidth = (int) (screenWidth * 0.5);
        int frameHeight = (int) (screenHeight * 0.9);

        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Tic-Tac-Toe");

        Image backgroundImage = new ImageIcon(getClass().getResource("/img/bg.jpg")).getImage();

        this.setIconImage(backgroundImage);
        panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel1.setLayout(null);

        xImg = new ImageIcon(getClass().getResource("/img/x2.png"));
        resizedX = xImg.getImage().getScaledInstance(frameHeight / 6 + 8, frameHeight / 6 + 8,
                DO_NOTHING_ON_CLOSE);
        xImg.setImage(resizedX);

        oImg = new ImageIcon(getClass().getResource("/img/oturn3.png"));
        resizedO = oImg.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        oImg.setImage(resizedO);

        ImageIcon oturn = new ImageIcon(getClass().getResource("/img/oturn1.png"));
        Image oturnresized = oturn.getImage().getScaledInstance(frameWidth / 5, frameHeight / 6, DO_NOTHING_ON_CLOSE);
        oturn.setImage(oturnresized);

        l1 = new JLabel();
        l1.setIcon(oturn);
        l1.setBounds(frameWidth / 6, frameHeight / 50, frameWidth / 5, frameHeight / 6);
        l1.setFont(new Font("serif", Font.BOLD, 30));
        panel1.add(l1);

        ImageIcon owinImg = new ImageIcon(getClass().getResource("/img/bbb.png"));
        Image owinImgresized = owinImg.getImage().getScaledInstance((frameHeight / 4) + 37, (frameHeight / 6) + 20,
                DO_NOTHING_ON_CLOSE);
        owinImg.setImage(owinImgresized);

        owin = new JLabel();
        owin.setIcon(owinImg);
        owin.setBounds(frameWidth / 3, (frameHeight / frameHeight) - 50, frameWidth / 3, frameHeight / 3);
        panel1.add(owin);
        owin.setVisible(false);

        ImageIcon xwinImg = new ImageIcon(getClass().getResource("/img/xwon1.png"));
        Image xwinImgresized = xwinImg.getImage().getScaledInstance((frameHeight / 3) - 24, (frameHeight / 6) + 20,
                DO_NOTHING_ON_CLOSE);
        xwinImg.setImage(xwinImgresized);

        xwin = new JLabel();
        xwin.setIcon(xwinImg);
        xwin.setBounds(frameWidth / 3, (frameHeight / frameHeight) - 50, frameWidth / 3, frameHeight / 3);
        panel1.add(xwin);
        xwin.setVisible(false);

        ImageIcon gmover = new ImageIcon(getClass().getResource("/img/gameover.png"));
        Image gmoverresized = gmover.getImage().getScaledInstance((frameHeight / 3) - 24, (frameHeight / 3) - 24,
                DO_NOTHING_ON_CLOSE);
        gmover.setImage(gmoverresized);

        gameOver = new JLabel();
        gameOver.setIcon(gmover);
        gameOver.setBounds(frameWidth / 3, frameHeight / 50, frameWidth / 3, frameHeight / 6);
        gameOver.setFont(new Font("serif", Font.BOLD, 40));
        gameOver.setForeground(Color.RED);
        gameOver.setBackground(Color.LIGHT_GRAY);
        panel1.add(gameOver);

        ImageIcon xturn = new ImageIcon(getClass().getResource("/img/xturn.png"));
        Image xturnresized = xturn.getImage().getScaledInstance(frameWidth / 6, frameHeight / 7, DO_NOTHING_ON_CLOSE);
        xturn.setImage(xturnresized);

        l2 = new JLabel();
        l2.setIcon(xturn);
        l2.setBounds(frameWidth * 2 / 3, frameHeight / 50, frameWidth / 5, frameHeight / 6);
        l2.setFont(new Font("serif", Font.BOLD, 30));
        panel1.add(l2);

        ocross = new ImageIcon(getClass().getResource("/img/ocross.png"));
        ocrossresized = ocross.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6, DO_NOTHING_ON_CLOSE);
        ocross.setImage(ocrossresized);

        overtical = new ImageIcon(getClass().getResource("/img/oVertical.png"));
        overticalresized = overtical.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        overtical.setImage(overticalresized);

        odiagonal = new ImageIcon(getClass().getResource("/img/oDiagonal.png"));
        odiagonalresized = odiagonal.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        odiagonal.setImage(odiagonalresized);

        odiagonal1 = new ImageIcon(getClass().getResource("/img/oDiagonal1.png"));
        odiagonal1resized = odiagonal1.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        odiagonal1.setImage(odiagonal1resized);

        xcross = new ImageIcon(getClass().getResource("/img/xcross.png"));
        xcrossresized = xcross.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6, DO_NOTHING_ON_CLOSE);
        xcross.setImage(xcrossresized);

        xvertical = new ImageIcon(getClass().getResource("/img/xVertical.png"));
        xverticalresized = xvertical.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        xvertical.setImage(xverticalresized);

        xdiagonal = new ImageIcon(getClass().getResource("/img/xDiagonal.png"));
        xdiagonalresized = xdiagonal.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        xdiagonal.setImage(xdiagonalresized);

        xdiagonal1 = new ImageIcon(getClass().getResource("/img/xDiagonal1.png"));
        xdiagonal1resized = xdiagonal1.getImage().getScaledInstance(frameHeight / 6, frameHeight / 6,
                DO_NOTHING_ON_CLOSE);
        xdiagonal1.setImage(xdiagonal1resized);

        for (int i = 0; i < 9; i++) {
            textFields[i] = new JButton();

        }
        for (int i = 0; i < 9; i++) {
            textFields[i].addMouseListener(this);
            textFields[i].setText("");
            textFields[i].setFocusable(false);
            textFields[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            textFields[i].setFocusPainted(false);
            textFields[i].setContentAreaFilled(false);
            textFields[i].setName("");
            textFields[i].setBorder(new LineBorder(Color.WHITE, 1));

        }

        panel = new JPanel(new GridLayout(3, 3));
        panel.setBounds(frameWidth / 4, frameHeight / 4, frameWidth / 2, frameWidth / 2);
        panel.setOpaque(false);
        for (int i = 0; i < 9; i++) {
            panel.add(textFields[i]);
        }

        l3 = new JLabel("Result :");
        l3.setBounds(30, 850, 100, 30);
        l3.setFont(new Font("serif", Font.BOLD, 35));

        exit = new JButton("EXIT");
        exit.setFocusPainted(false);
        exit.setOpaque(false);
        exit.setBounds(frameWidth * 3 / 6 + 50, frameHeight - 150, frameWidth / 5, frameHeight / 12);
        exit.setForeground(new Color(242, 47, 216, 255));
        exit.setBorder(new LineBorder(new Color(242, 47, 216, 255), 4));
        exit.setFont(new Font("calibri", Font.BOLD, 30));
        exit.setContentAreaFilled(false);

        panel1.add(exit);

        Font font = new Font("arial", Font.BOLD, 45);
        rematch = new JButton("REMATCH");

        rematch.setBounds(frameWidth / 2 - 250, frameHeight - 150, frameWidth / 5, frameHeight / 12);
        rematch.setFocusPainted(false);
        rematch.setOpaque(false);
        rematch.setBorder(new LineBorder(Color.CYAN, 4));

        rematch.setFont(new Font("calibri", Font.BOLD, 30));
        rematch.setForeground(Color.CYAN);
        rematch.setContentAreaFilled(false);
        panel1.add(rematch);
        rematch.addMouseListener(this);

        exit.addMouseListener(this);

        l3.setBackground(Color.WHITE);
        l3.setForeground(Color.BLACK);

        Random ran = new Random();

        random = ran.nextInt(2);
        if (random == 0) {
            l1.setVisible(true);
            l2.setVisible(false);
        } else {
            l1.setVisible(false);
            l2.setVisible(true);
        }
        gameOver.setVisible(false);

        panel1.add(panel);
        setLayout(new BorderLayout());
        add(panel1);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent fe) {
        if (random == 0) {

            if (n % 2 != 0) {
                for (int i = 0; i < 9; i++) {

                    if (fe.getSource() == textFields[i]) {
                        textFields[i].setIcon(oImg);
                        textFields[i].setName("O");

                        textFields[i].removeMouseListener(this);

                    }
                }
                l1.setVisible(false);
                l2.setVisible(true);

                ++n;

            }

            else {
                for (int i = 0; i < 9; i++) {

                    if (fe.getSource() == textFields[i]) {
                        textFields[i].setIcon(xImg);
                        textFields[i].setName("X");
                        textFields[i].removeMouseListener(this);
                    }
                }

                l2.setVisible(false);
                l1.setVisible(true);
                ++n;
            }

            for (int i = 0; i < 9; i++) {
                o[i] = textFields[i].getName();
            }
            for (int i = 0; i < 9; i++) {
                x[i] = textFields[i].getName();
            }

            if ((o[0].equals("O") && o[1].equals("O") && o[2].equals("O"))
                    || (o[0].equals("O") && o[3].equals("O") && o[6].equals("O"))
                    || (o[1].equals("O") && o[4].equals("O") && o[7].equals("O"))
                    || (o[2].equals("O") && o[5].equals("O") && o[8].equals("O"))
                    || (o[3].equals("O") && o[4].equals("O") && o[5].equals("O"))
                    || (o[6].equals("O") && o[7].equals("O") && o[8].equals("O"))
                    || (o[0].equals("O") && o[4].equals("O") && o[8].equals("O"))
                    || (o[2].equals("O") && o[4].equals("O") && o[6].equals("O"))) {
                l2.setVisible(false);

                if (textFields[0].getName().equals("O") && textFields[1].getName().equals("O")
                        && textFields[2].getName().equals("O")) {

                    for (int i = 0; i < 3; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 1 && i != 2) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[3].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[5].getName().equals("O")) {
                    for (int i = 3; i < 6; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 3 && i != 4 && i != 5) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[6].getName().equals("O") && textFields[7].getName().equals("O")
                        && textFields[8].getName().equals("O")) {
                    for (int i = 6; i < 9; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 6 && i != 7 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("O") && textFields[3].getName().equals("O")
                        && textFields[6].getName().equals("O")) {

                    textFields[0].removeMouseListener(this);
                    textFields[3].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);

                    textFields[0].setIcon(overtical);
                    textFields[3].setIcon(overtical);
                    textFields[6].setIcon(overtical);
                    for (int i = 0; i < 9; i++) {

                        if (i != 0 && i != 3 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[1].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[7].getName().equals("O")) {

                    textFields[1].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[7].removeMouseListener(this);
                    textFields[1].setIcon(overtical);
                    textFields[4].setIcon(overtical);
                    textFields[7].setIcon(overtical);

                    for (int i = 0; i < 9; i++) {
                        if (i != 1 && i != 4 && i != 7) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[2].getName().equals("O") && textFields[5].getName().equals("O")
                        && textFields[8].getName().equals("O")) {

                    textFields[2].removeMouseListener(this);
                    textFields[5].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);

                    textFields[2].setIcon(overtical);
                    textFields[5].setIcon(overtical);
                    textFields[8].setIcon(overtical);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 5 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[0].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[8].getName().equals("O")) {

                    textFields[0].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);
                    textFields[0].setIcon(odiagonal);
                    textFields[4].setIcon(odiagonal);
                    textFields[8].setIcon(odiagonal);

                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 4 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[2].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[6].getName().equals("O")) {

                    textFields[2].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);

                    textFields[2].setIcon(odiagonal1);
                    textFields[4].setIcon(odiagonal1);
                    textFields[6].setIcon(odiagonal1);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 4 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }

                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("")) {
                        textFields[i].removeMouseListener(this);
                    }

                }
                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("X")) {
                        textFields[i].setEnabled(false);
                        textFields[i].removeMouseListener(this);
                    }
                }
                owin.setVisible(true);

            } else if ((x[0].equals("X") && x[1].equals("X") && x[2].equals("X"))
                    || (x[0].equals("X") && x[3].equals("X") && x[6].equals("X"))
                    || (x[1].equals("X") && x[4].equals("X") && x[7].equals("X"))
                    || (x[2].equals("X") && x[5].equals("X") && x[8].equals("X"))
                    || (x[3].equals("X") && x[4].equals("X") && x[5].equals("X"))
                    || (x[6].equals("X") && x[7].equals("X") && x[8].equals("X"))
                    || (x[0].equals("X") && x[4].equals("X") && x[8].equals("X"))
                    || (x[2].equals("X") && x[4].equals("X") && x[6].equals("X"))) {
                l1.setVisible(false);

                if (textFields[0].getName().equals("X") && textFields[1].getName().equals("X")
                        && textFields[2].getName().equals("X")) {

                    for (int i = 0; i < 3; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 1 && i != 2) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[3].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[5].getName().equals("X")) {
                    for (int i = 3; i < 6; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 3 && i != 4 && i != 5) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[6].getName().equals("X") && textFields[7].getName().equals("X")
                        && textFields[8].getName().equals("X")) {
                    for (int i = 6; i < 9; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 6 && i != 7 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("X") && textFields[3].getName().equals("X")
                        && textFields[6].getName().equals("X")) {

                    textFields[0].removeMouseListener(this);
                    textFields[3].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);
                    textFields[0].setIcon(xvertical);
                    textFields[3].setIcon(xvertical);
                    textFields[6].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 3 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[1].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[7].getName().equals("X")) {

                    textFields[1].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[7].removeMouseListener(this);
                    textFields[1].setIcon(xvertical);
                    textFields[4].setIcon(xvertical);
                    textFields[7].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 1 && i != 4 && i != 7) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[2].getName().equals("X") && textFields[5].getName().equals("X")
                        && textFields[8].getName().equals("X")) {

                    textFields[2].removeMouseListener(this);
                    textFields[5].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);

                    textFields[2].setIcon(xvertical);
                    textFields[5].setIcon(xvertical);
                    textFields[8].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 5 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[8].getName().equals("X")) {

                    textFields[0].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);
                    textFields[0].setIcon(xdiagonal1);
                    textFields[4].setIcon(xdiagonal1);
                    textFields[8].setIcon(xdiagonal1);
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 4 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[2].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[6].getName().equals("X")) {

                    textFields[2].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);
                    textFields[2].setIcon(xdiagonal);
                    textFields[4].setIcon(xdiagonal);
                    textFields[6].setIcon(xdiagonal);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 4 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }

                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("")) {
                        textFields[i].removeMouseListener(this);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("O")) {
                        textFields[i].setEnabled(false);
                        textFields[i].removeMouseListener(this);
                    }
                }
                xwin.setVisible(true);

            }

        }

        if (random == 1) {

            if (n % 2 != 0) {
                for (int i = 0; i < 9; i++) {

                    if (fe.getSource() == textFields[i]) {
                        textFields[i].setIcon(xImg);
                        textFields[i].setName("X");
                        textFields[i].removeMouseListener(this);
                    }
                }
                l2.setVisible(false);
                l1.setVisible(true);
                ++n;

            }

            else {
                for (int i = 0; i < 9; i++) {

                    if (fe.getSource() == textFields[i]) {
                        textFields[i].setIcon(oImg);
                        textFields[i].setName("O");
                        textFields[i].removeMouseListener(this);
                    }
                }
                l1.setVisible(false);
                l2.setVisible(true);

                ++n;

            }
            for (int i = 0; i < 9; i++) {
                o[i] = textFields[i].getName();
            }
            for (int i = 0; i < 9; i++) {
                x[i] = textFields[i].getName();
            }
            if ((o[0].equals("O") && o[1].equals("O") && o[2].equals("O"))
                    || (o[0].equals("O") && o[3].equals("O") && o[6].equals("O"))
                    || (o[1].equals("O") && o[4].equals("O") && o[7].equals("O"))
                    || (o[2].equals("O") && o[5].equals("O") && o[8].equals("O"))
                    || (o[3].equals("O") && o[4].equals("O") && o[5].equals("O"))
                    || (o[6].equals("O") && o[7].equals("O") && o[8].equals("O"))
                    || (o[0].equals("O") && o[4].equals("O") && o[8].equals("O"))
                    || (o[2].equals("O") && o[4].equals("O") && o[6].equals("O"))) {
                l2.setVisible(false);

                if (textFields[0].getName().equals("O") && textFields[1].getName().equals("O")
                        && textFields[2].getName().equals("O")) {

                    for (int i = 0; i < 3; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 1 && i != 2) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[3].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[5].getName().equals("O")) {
                    for (int i = 3; i < 6; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 3 && i != 4 && i != 5) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[6].getName().equals("O") && textFields[7].getName().equals("O")
                        && textFields[8].getName().equals("O")) {
                    for (int i = 6; i < 9; i++) {
                        textFields[i].setIcon(ocross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 6 && i != 7 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("O") && textFields[3].getName().equals("O")
                        && textFields[6].getName().equals("O")) {

                    textFields[0].removeMouseListener(this);
                    textFields[3].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);

                    textFields[0].setIcon(overtical);
                    textFields[3].setIcon(overtical);
                    textFields[6].setIcon(overtical);
                    for (int i = 0; i < 9; i++) {

                        if (i != 0 && i != 3 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[1].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[7].getName().equals("O")) {

                    textFields[1].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[7].removeMouseListener(this);
                    textFields[1].setIcon(overtical);
                    textFields[4].setIcon(overtical);
                    textFields[7].setIcon(overtical);

                    for (int i = 0; i < 9; i++) {
                        if (i != 1 && i != 4 && i != 7) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[2].getName().equals("O") && textFields[5].getName().equals("O")
                        && textFields[8].getName().equals("O")) {

                    textFields[2].removeMouseListener(this);
                    textFields[5].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);

                    textFields[2].setIcon(overtical);
                    textFields[5].setIcon(overtical);
                    textFields[8].setIcon(overtical);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 5 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[0].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[8].getName().equals("O")) {

                    textFields[0].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);
                    textFields[0].setIcon(odiagonal);
                    textFields[4].setIcon(odiagonal);
                    textFields[8].setIcon(odiagonal);

                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 4 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[2].getName().equals("O") && textFields[4].getName().equals("O")
                        && textFields[6].getName().equals("O")) {

                    textFields[2].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);

                    textFields[2].setIcon(odiagonal1);
                    textFields[4].setIcon(odiagonal1);
                    textFields[6].setIcon(odiagonal1);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 4 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }

                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("")) {
                        textFields[i].removeMouseListener(this);
                    }

                }
                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("X")) {
                        textFields[i].setEnabled(false);
                        textFields[i].removeMouseListener(this);
                    }
                }
                owin.setVisible(true);

            } else if ((x[0].equals("X") && x[1].equals("X") && x[2].equals("X"))
                    || (x[0].equals("X") && x[3].equals("X") && x[6].equals("X"))
                    || (x[1].equals("X") && x[4].equals("X") && x[7].equals("X"))
                    || (x[2].equals("X") && x[5].equals("X") && x[8].equals("X"))
                    || (x[3].equals("X") && x[4].equals("X") && x[5].equals("X"))
                    || (x[6].equals("X") && x[7].equals("X") && x[8].equals("X"))
                    || (x[0].equals("X") && x[4].equals("X") && x[8].equals("X"))
                    || (x[2].equals("X") && x[4].equals("X") && x[6].equals("X"))) {
                l1.setVisible(false);

                if (textFields[0].getName().equals("X") && textFields[1].getName().equals("X")
                        && textFields[2].getName().equals("X")) {

                    for (int i = 0; i < 3; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 1 && i != 2) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[3].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[5].getName().equals("X")) {
                    for (int i = 3; i < 6; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != 3 && i != 4 && i != 5) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[6].getName().equals("X") && textFields[7].getName().equals("X")
                        && textFields[8].getName().equals("X")) {
                    for (int i = 6; i < 9; i++) {
                        textFields[i].setIcon(xcross);
                        textFields[i].removeMouseListener(this);
                    }

                    for (int i = 0; i < 9; i++) {
                        if (i != 6 && i != 7 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("X") && textFields[3].getName().equals("X")
                        && textFields[6].getName().equals("X")) {

                    textFields[0].removeMouseListener(this);
                    textFields[3].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);
                    textFields[0].setIcon(xvertical);
                    textFields[3].setIcon(xvertical);
                    textFields[6].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 3 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[1].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[7].getName().equals("X")) {

                    textFields[1].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[7].removeMouseListener(this);
                    textFields[1].setIcon(xvertical);
                    textFields[4].setIcon(xvertical);
                    textFields[7].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 1 && i != 4 && i != 7) {
                            textFields[i].setEnabled(false);
                        }
                    }

                }
                if (textFields[2].getName().equals("X") && textFields[5].getName().equals("X")
                        && textFields[8].getName().equals("X")) {

                    textFields[2].removeMouseListener(this);
                    textFields[5].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);

                    textFields[2].setIcon(xvertical);
                    textFields[5].setIcon(xvertical);
                    textFields[8].setIcon(xvertical);
                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 5 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[0].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[8].getName().equals("X")) {

                    textFields[0].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[8].removeMouseListener(this);
                    textFields[0].setIcon(xdiagonal1);
                    textFields[4].setIcon(xdiagonal1);
                    textFields[8].setIcon(xdiagonal1);
                    for (int i = 0; i < 9; i++) {
                        if (i != 0 && i != 4 && i != 8) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }
                if (textFields[2].getName().equals("X") && textFields[4].getName().equals("X")
                        && textFields[6].getName().equals("X")) {

                    textFields[2].removeMouseListener(this);
                    textFields[4].removeMouseListener(this);
                    textFields[6].removeMouseListener(this);
                    textFields[2].setIcon(xdiagonal);
                    textFields[4].setIcon(xdiagonal);
                    textFields[6].setIcon(xdiagonal);

                    for (int i = 0; i < 9; i++) {
                        if (i != 2 && i != 4 && i != 6) {
                            textFields[i].setEnabled(false);
                        }
                    }
                }

                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("")) {
                        textFields[i].removeMouseListener(this);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if (textFields[i].getName().equals("O")) {
                        textFields[i].setEnabled(false);
                        textFields[i].removeMouseListener(this);
                    }
                }
                xwin.setVisible(true);

            }

        }

        if (n > 9 && !owin.isVisible() && !xwin.isVisible()) {

            gameOver.setVisible(true);
            for (int i = 0; i < 9; i++) {
                textFields[i].setEnabled(false);
            }
            for (int i = 0; i < 9; i++) {
                o[i] = textFields[i].getName();
            }
            for (int i = 0; i < 9; i++) {
                x[i] = textFields[i].getName();
            }

            if ((o[0].equals("O") && o[1].equals("O") && o[2].equals("O"))
                    || (o[0].equals("O") && o[3].equals("O") && o[6].equals("O"))
                    || (o[1].equals("O") && o[4].equals("O") && o[7].equals("O"))
                    || (o[2].equals("O") && o[5].equals("O") && o[8].equals("O"))
                    || (o[3].equals("O") && o[4].equals("O") && o[5].equals("O"))
                    || (o[6].equals("O") && o[7].equals("O") && o[8].equals("O"))
                    || (o[0].equals("O") && o[4].equals("O") && o[8].equals("O"))
                    || (o[2].equals("O") && o[4].equals("O") && o[6].equals("O"))) {

            } else if ((x[0].equals("X") && x[1].equals("X") && x[2].equals("X"))
                    || (x[0].equals("X") && x[3].equals("X") && x[6].equals("X"))
                    || (x[1].equals("X") && x[4].equals("X") && x[7].equals("X"))
                    || (x[2].equals("X") && x[5].equals("X") && x[8].equals("X"))
                    || (x[3].equals("X") && x[4].equals("X") && x[5].equals("X"))
                    || (x[6].equals("X") && x[7].equals("X") && x[8].equals("X"))
                    || (x[0].equals("X") && x[4].equals("X") && x[8].equals("X"))
                    || (x[2].equals("X") && x[4].equals("X") && x[6].equals("X"))) {

            } else {
                l1.setVisible(false);
                l2.setVisible(false);

            }

        }
        if (fe.getSource() == exit) {
            dispose();
        }
        if (fe.getSource() == rematch) {
            dispose();
            new TicTacToe();
        }

    }

    public void mousePressed(MouseEvent fe) {

    }

    public void mouseReleased(MouseEvent fe) {

    }

    public void mouseEntered(MouseEvent fe) {

    }

    public void mouseExited(MouseEvent fe) {

    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}

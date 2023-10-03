import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JTextArea textArea;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JScrollPane scrollPane;
    JButton quitBtn;
    JButton rock;
    JButton paper;
    JButton scissors;
    int pWins = 0;
    int cWins = 0;
    int ties = 0;
    int pick;

    public RockPaperScissorsFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setTitle("Rock Paper Scissors Game");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize((int) (screenSize.width*.75),(int) (screenSize.height*.75));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void createTopPanel(){
        topPnl = new JPanel();
        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");
        quitBtn = new JButton("Quit");

        topPnl.add(rock);
        topPnl.add(paper);
        topPnl.add(scissors);
        topPnl.add(quitBtn);

        rock.addActionListener((ActionEvent ae) -> {
            pick = 1;
            int cPick = computerPick();
            if(pick==cPick) {
                ties++;
                textField3.setText(Integer.toString(ties));
                textArea.append("Rock is rock (Tie game)\n");
            } else if (cPick==2) {
                cWins++;
                textField2.setText(Integer.toString(cWins));
                textArea.append("Paper covers rock (Computer wins)\n");
            } else if (cPick==3) {
                pWins++;
                textField1.setText(Integer.toString(pWins));
                textArea.append("Rock breaks scissors (Player wins)\n");
            }
        });
        paper.addActionListener((ActionEvent ae) -> {
            pick = 2;
            int cPick = computerPick();
            if(pick==cPick) {
                ties++;
                textField3.setText(Integer.toString(ties));
                textArea.append("Paper is paper (Tie game)\n");
            } else if (cPick==1) {
                pWins++;
                textField1.setText(Integer.toString(pWins));
                textArea.append("Paper covers rock (Player wins)\n");
            } else if (cPick==3) {
                cWins++;
                textField2.setText(Integer.toString(cWins));
                textArea.append("Scissors cuts paper (Computer wins)\n");
            }
        });
        scissors.addActionListener((ActionEvent ae) -> {
            pick = 3;
            int cPick = computerPick();
            if(pick==cPick) {
                ties++;
                textField3.setText(Integer.toString(ties));
                textArea.append("Scissors are scissors (Tie game)\n");
            } else if (cPick==1) {
                pWins++;
                textField1.setText(Integer.toString(pWins));
                textArea.append("Scissors cuts paper (Player wins)\n");
            } else if (cPick==2) {
                cWins++;
                textField2.setText(Integer.toString(cWins));
                textArea.append("Rock breaks scissors (Computer wins)\n");
            }
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

    }
    private void createMiddlePanel(){
        middlePnl = new JPanel();
        textField1 = new JTextField("  0  ");
        textField2 = new JTextField("  0  ");
        textField3 = new JTextField("  0  ");
        label1 = new JLabel("Player Wins");
        label2 = new JLabel("Computer Wins");
        label3 = new JLabel("Ties");

        middlePnl.add(label1);
        middlePnl.add(textField1);
        middlePnl.add(label2);
        middlePnl.add(textField2);
        middlePnl.add(label3);
        middlePnl.add(textField3);



    }
    private void createBottomPanel(){
        bottomPnl = new JPanel();
        textArea = new JTextArea(6,50);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.createVerticalScrollBar();

        bottomPnl.add(scrollPane);
    }

    public int computerPick(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
}

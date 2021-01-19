package ncs7;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame{
    JTextField javaScore = new JTextField(10);
    JTextField sqlScore = new JTextField(10);
    JTextField total = new JTextField(10);
    JTextField average = new JTextField(10);
    public ScoreFrame(){
        this.setTitle("문제 7");
        this.setSize(400,300);
        JPanel pan0 = new JPanel();
        pan0.setLayout(new GridLayout(1,1));

        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();

        JLabel label = new JLabel("점수를 입력하세요");
        label.setFont(label.getFont().deriveFont(40.0f));
        label.setHorizontalAlignment(JLabel.CENTER);
        pan0.add(label);




        JLabel jScore = new JLabel("자바: ");
        JLabel sScore = new JLabel("SQL: ");
        JLabel sum = new JLabel("총점: ");
        JLabel avg = new JLabel("평균: ");


        pan1.add(jScore);
        pan1.add(javaScore);
        pan1.add(sScore);
        pan1.add(sqlScore);

        JButton cal = new JButton("계산하기");
        cal.setSize(30,5);
        pan2.add(cal);

        cal.addActionListener(new ActionHandler());


        pan3.add(sum);
        pan3.add(total);
        pan3.add(avg);
        pan3.add(average);

        this.setLayout(new GridLayout(4,1));
        this.add(pan0);
        this.add(pan1);
        this.add(pan2);
        this.add(pan3);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int score1 = Integer.parseInt(javaScore.getText());
            int score2 = Integer.parseInt(sqlScore.getText());


            total.setText(score1+score2+"");
            average.setText((score1+score2)/2 + "");
        }
    }
}
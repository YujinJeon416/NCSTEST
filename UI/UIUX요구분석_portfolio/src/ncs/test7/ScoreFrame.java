package ncs.test7;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ScoreFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField java;
	private JTextField sql;
	private JTextField sum;
	private JTextField avg;
	

	public ScoreFrame() {
		
		super("문제7");
		setLayout(null);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1.헤더
		JLabel title = new JLabel("점수를 입력하세요");
		title.setBounds(0, 0, 400, 40);
		title.setHorizontalAlignment(SwingConstants.CENTER);//가운데정렬
		title.setFont(new Font("고딕", Font.BOLD, 30));
		
		//2.라벨 & 텍스트필드
		JLabel javaLabel = new JLabel("자바:");
		JLabel sqlLabel = new JLabel("SQL:");
		JLabel sumLabel = new JLabel("총점:");
		JLabel avgLabel = new JLabel("평균:");
		JButton calcBtn = new JButton("계산하기");
		//이벤트리스너에서 접근하기 위해 필드로 선언후 객체할당.
		java = new JTextField();
		sql = new JTextField();
		sum = new JTextField();
		avg = new JTextField();
		
		//위치선정
		javaLabel.setBounds(10, 70, 40, 20);
		java.setBounds(50, 70, 110, 20);
		sqlLabel.setBounds(200, 70, 40, 20);
		sql.setBounds(240, 70, 110, 20);
		sumLabel.setBounds(10, 200, 40, 20);
		sum.setBounds(50, 200, 110, 20);
		avgLabel.setBounds(200, 200, 40, 20);
		avg.setBounds(240, 200, 110, 20);
		calcBtn.setBounds(155, 135, 90, 30);
		
		//읽기전용으로 설정
		sum.setEditable(false);
		avg.setEditable(false);
		
		//3.버튼 이벤트핸들러 바인딩
		calcBtn.addActionListener(new ActionHandler());
		
		//4.프레임에 요소추가
		add(title);
		add(javaLabel);
		add(java);
		add(sqlLabel);
		add(sql);
		add(sumLabel);
		add(sum);
		add(avgLabel);
		add(avg);
		add(calcBtn);
		
		//5.시각화처리
		setVisible(true);
	}


	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int javaScore = Integer.parseInt(java.getText());
				int sqlScore = Integer.parseInt(sql.getText());
				
				sum.setText(String.valueOf(javaScore + sqlScore));
				avg.setText(String.valueOf((javaScore + sqlScore) / 2));
				
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "입력값은 정수만 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
				java.setText("");
				java.requestFocus();
				sql.setText("");
			}
		}
	}
}

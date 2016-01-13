import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtShortedUrl;
	private JLabel urlNewLabel;
	private String textFieldString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
	
		textField.setText("Enter URL");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		txtShortedUrl = new JTextField();
		txtShortedUrl.setText("Decode URL");
		txtShortedUrl.setColumns(10);
		urlNewLabel = new JLabel("URL");
		
		
		JButton btnShorten = new JButton("Shorten");
		btnShorten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldString = textField.getText();
				String shrturl = UrlS.shortURL(textFieldString);
				urlNewLabel.setText(shrturl);
				
			}
		});
		
		
		//button
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataFrame dFrame = new DataFrame();
				dFrame.setVisible(true);
			}
		});
		
		JButton btnShow = new JButton("Show URL");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shortedURL = txtShortedUrl.getText();
				String lngurl = UrlS.longURL(shortedURL);
				urlNewLabel.setText(lngurl);
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnShowAll)
								.addGap(15))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnShow)
									.addComponent(txtShortedUrl, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
								.addGap(142))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnShorten)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(142, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(urlNewLabel)
							.addGap(183))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(urlNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShorten)
					.addGap(18)
					.addComponent(txtShortedUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShow)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(btnShowAll)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

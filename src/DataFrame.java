import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DataFrame extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch JFrame for showing data from database
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataFrame frame = new DataFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		showFromTable();
	}
	static Connection conn = null;
	static Statement stm = null;
	public static void showFromTable(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/urlData");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stm = conn.createStatement();
			String showQuery = "SELECT * FROM urlTable";
			ResultSet rs = stm.executeQuery(showQuery);			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e){
			System.out.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}finally{
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	/**
	 * Create the frame.
	 */
	DataFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 6, 419, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFromTable();
			}
		});
		btnRefresh.setBounds(6, 227, 99, 29);
		contentPane.add(btnRefresh);
	}
}

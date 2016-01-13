import java.sql.*;


public class SQLiteData {
	private static Connection c = null;
    private static Statement stmn = null;
   // private static ResultSet rs = null;
	
	
	public static void getConnection(){
		 try {
		      
		     Class.forName("com.mysql.jdbc.Driver");
		     c = DriverManager.getConnection("jdbc:mysql://localhost:3306/urlData");
		     System.out.println("Opened database successfully");
			  
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public static void insertToTable(int id, String url, String surl) {
		try{
		getConnection();
		PreparedStatement insertStmn = c.prepareStatement("insert into urlTable values(?,?,?)");
		insertStmn.setInt(1, id);
		insertStmn.setString(2, url);
		insertStmn.setString(3, surl);
		insertStmn.executeUpdate();
		
		}catch (SQLException e){
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}finally{
			if (c!=null){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	
	public static int getMaxId(){

		try {
			getConnection();
			stmn = c.createStatement();
			String showIdQuery = "SELECT MAX(id) id FROM urlTable";
			ResultSet rs = stmn.executeQuery(showIdQuery);
			while (rs.next()){
			int maxId = rs.getInt("id");
			
			System.out.println("class.getMaxId = " + maxId);
			return maxId;
			}
		}catch (SQLException e){
			System.out.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		} finally{
			if (c!=null){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
		
	}
	public static String getUrlName(int id){
		try {
			getConnection();
			stmn = c.createStatement();
			String getNameQuery = "SELECT urlName FROM urlTable WHERE id = 2";

			ResultSet rs2 = stmn.executeQuery(getNameQuery);
			while (rs2.next()) {
				String urlName = rs2.getString("urlName");
				//System.out.println("class.getUrlName = " + urlName);
				return urlName;
			}
		} catch (SQLException e){
			System.out.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		} finally{
			if (c!=null){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	}
	
	
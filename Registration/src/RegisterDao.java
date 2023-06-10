import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class RegisterDao {
 private String dburl = "jdbc:mysql://localhost:3306/userdb";
 private String dbuname = "root";
 private String dbpassword = "root";
 private static String dbdriver = "com.mysql.cj.jdbc.Driver";
 
 public static void loadDriver(String dbDriver)
 {
	 			try {
	 					Class.forName(dbDriver);
	 				} catch (ClassNotFoundException e) {
	 						// TODO Auto-generated catch block
	 					e.printStackTrace();
	 				}
 					}
 						public Connection getConnection() {
 							Connection con = null;
 							try {
 								con = DriverManager.getConnection(dburl, dbuname, dbpassword);
 							} catch (SQLException e) {
 								// TODO Auto-generated catch block
 								e.printStackTrace();
 								}
 							return con;
 							}
 
 					public String insert(Member member) {
 								loadDriver(dbdriver);
 								Connection con = getConnection();
 								String sql = "insert into member values(?,?,?,?)";
 								String result="Data Entered Successfully";
 								
 								try {
 									PreparedStatement ps = con.prepareStatement(sql);
 									ps.setString(1, member.getUname());
 									ps.setString(2, member.getPassword());
 									ps.setString(3, member.getEmail());
 									ps.setNString(4, member.getPhone());
 									ps.executeUpdate();
 								} catch (SQLException e) {
 									// TODO Auto-generated catch block
 									result="Data Not Entered Successfully";
 										e.printStackTrace();
 								}
 								return result;
 
 							}
 
 					  public List<Member> getAllUserData(){
                    	   List<Member> list=new ArrayList<Member>();
                    	   loadDriver(dbdriver);
                    	   Connection con=getConnection();
                    	   String sql="select * from member";
                    	   try {
							PreparedStatement ps=con.prepareStatement(sql);
							
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								Member member=new Member();
								member.setUname(rs.getString(1));
								member.setPassword(rs.getString(2));
								member.setEmail(rs.getString(3));
								member.setPhone(rs.getString(4));
								list.add(member);
							}
						} 
                    	   
                    	   catch (SQLException e)
                    	   {
							
							e.printStackTrace();
						   }
                    	   
                    	 return list;  
                    	   
                        }
 					  
 					  
 				
}
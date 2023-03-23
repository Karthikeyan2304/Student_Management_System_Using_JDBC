package package_jdbc.com;
import java.sql.*;
import java.util.Scanner;
public class Stud_Management_Using_Db
{	
	static Connection con;
static	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException 
	{
		
	 
	
   	
boolean flag=true;
while(flag)
{
System.out.println("Select AnyOne Option \n"
		+ "1:Create The Student Table\n"
		+ "2:Insert The Values For The Student\n"
		+ "3:Update The Student Mark\n"
		+ "4:Delete Particular Student Record\n"
		+ "5:Show All The Students Details\n"
		+ "6:Exit");	
int option=sc.nextInt();
switch(option)
{
case 1:create_Table();break;
case 2:insert_Table();break;
case 3:update_Table();break;
case 4: Delete_Table();break;
case 5:	Show_Table(); break;
case 6:flag=false;System.out.println("\n*******************Thanks For Using The App******************"); break;
default:System.out.println("\n!!!!!!!!!!!!! Invaild Input !!!!!!!!!!!!!\n");
}
}

	
	
	
                                        //Connection	
	try 
	{
//		Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
	
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	
	
	
                          //Create Table Method	
public static void create_Table()
{
try 
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");

	String CreateTableQuery="create table Student_2(Student_ID int,Student_Name varchar(50),Student_Mark int)";
	PreparedStatement ps=con.prepareStatement(CreateTableQuery);
	ps.execute();
	System.out.println("\n**************Table Created Successfully****************\n");
	con.close();
}
catch (SQLException e)
{
e.printStackTrace();
}	
}

                                    //Insert Value                                       
public static void insert_Table()
{
try 
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");

	String InsertQuery="insert into Student_2 values(?,?,?)";
	PreparedStatement ps=con.prepareStatement(InsertQuery);
System.out.println("Enter the Student_ID");
	ps.setInt(1, sc.nextInt());
	System.out.println("Enter the Student_Name");
	ps.setString(2, sc.next());
	System.out.println("Enter the  Student_Mark");
ps.setInt(3,sc.nextInt());
ps.executeUpdate();
	System.out.println("\n**************Table Inserted Successfully****************\n");
	con.close();
}
catch (SQLException e)
{
e.printStackTrace();
}	
}


                                            // Update Table
public static void update_Table()
{
try 
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");

	String UpdateQuery="update Student_2 set Student_Mark=? where Student_ID=?";
	PreparedStatement ps=con.prepareStatement(UpdateQuery);
System.out.println("Enter The Mark You Want To Update");
	ps.setInt(1, sc.nextInt());
	System.out.println("Enter The Student_ID Of The Student You Wants To Update This Mark ");
ps.setInt(2,sc.nextInt());
ps.executeUpdate();
	System.out.println("\n**************Table Updated Successfully****************\n");
con.close();
}
catch (SQLException e)
{
e.printStackTrace();
}	
}


//                               Delete Record
public static void Delete_Table()
{
try 
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");

	String DeleteQuery="Delete from  Student_2  where Student_ID=?";
	PreparedStatement ps=con.prepareStatement(DeleteQuery);
System.out.println("Enter The Student_ID Of The Student You Wants To Delete");
ps.setInt(1,sc.nextInt());
ps.executeUpdate();
	System.out.println("\n**************Record Deleted Successfully****************\n");
	con.close();
}
catch (SQLException e)
{
e.printStackTrace();
}	
}


                                //Show Details
public static void Show_Table()
{
try 
{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");

	String SelectQuery="Select * from Student_2";
	PreparedStatement ps=con.prepareStatement(SelectQuery);
	ResultSet rs=ps.executeQuery("Select * from Student_2");
while(rs.next())
{
System.out.println("\n" +rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\n");

}con.close();
}
catch (SQLException e)
{
e.printStackTrace();
}	
}
}





import java.sql.*;
class Update{
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Harsh@123";
        String query = "UPDATE employees SET job_title = 'Fullstack Developer', salary = 70000.0 WHERE id = 2";

        try{
            Class.forName("com.mysql.jdbc.driver"); //-------------(1)
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver loaded successful!!!");
        }


        try{
            Connection con = DriverManager.getConnection(url, username, password); //-----------(2)
            System.out.println("Connection Establish Successful");
            Statement stmt = con.createStatement(); //----------------(3)
            int rowsaffected = stmt.executeUpdate(query); //----------(4)
            if(rowsaffected > 0){
                System.out.println("UPDATION successfully. " + rowsaffected + " row(s) affected!");
            }else{
                System.out.println("UPDATION data Failed!!!");
            }

            stmt.close(); //-------(5)
            con.close(); //-------(5)
            System.out.println("Connection closed successfully!!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }




    }
}
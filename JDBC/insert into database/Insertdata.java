import java.sql.*;
class Insertdata{
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Harsh@123";
        String query = "INSERT INTO EMPLOYEES(id, name, job_title, salary)values(4, 'Ujjwal', 'react developer', '77000.0')";

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
                System.out.println("Insert successfully. " + rowsaffected + " row(s) affected!");
            }else{
                System.out.println("Insertion data Failed!!!");
            }

            stmt.close(); //-------(5)
            con.close(); //-------(5)
            System.out.println("Connection closed successfully!!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }




    }
}
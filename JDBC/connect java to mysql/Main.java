import java.sql.*;
class Main{
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Harsh@123";
        String query = "SELECT * FROM EMPLOYEES";

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
            ResultSet rs = stmt.executeQuery(query); //--------------------(4)

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println();
                System.out.println("===============");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + job_title);
                System.out.println("Salary: " + salary);
            }

            rs.close();
            stmt.close();
            con.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }




    }
}
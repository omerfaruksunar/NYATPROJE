import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class VeriTabani {
    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Users", "postgres","xsbx5q42");
            if (conn != null)
                System.out.println("*** Veri Tabani Baglantisi Basarili ***");
            else
                System.out.println("!!!Veri Tabani Baglantisi Basarisiz!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean login(String user,String pass){

        String sql = "SELECT * FROM \"public\".\"Users\" WHERE \"Adi\" = \'" + user +  "\' AND \"Sifre\" = \'" + pass + "\'";
        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            if(rs.next())
            {

                rs.close();
                stmt.close();
                System.out.println("Giris Yapiliyor...");
                return true;
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}

package pe.isil.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        //Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Crear conexion
        Connection conexion =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg",
                        "root",
                        "root");

        //Crear Statement
        //Statement st = conexion.createStatement();
       // PreparedStatement pt= conexion.prepareStatement("SELECT * FROM USERS WHERE ID = ? and USERNAME=?");
        //pt.setInt(1,2);
        //pt.setString(2,"DNI45869274");

        CallableStatement callsp=conexion.prepareCall("{call validarLogin(?,?,?)}");
        callsp.setString(1,"DNI73267572");
        callsp.setString(2,"654321");
        callsp.registerOutParameter(3,Types.INTEGER);

        //Ejecutar sentencia
        callsp.executeQuery();


        int resultado = callsp.getInt(3);

        if(resultado==1){
            System.out.println("Login exitoso");
        }else {
            System.out.println("Usuario o clave incorrecto");
        }



        CallableStatement callsp2 = conexion.prepareCall(" {call listarAllUsers()}");
        ResultSet resultadoSP2 = callsp2.executeQuery();

        while (resultadoSP2.next()){
            System.out.println(resultadoSP2.getString("username"));
        }

        CallableStatement callSp3 = conexion.prepareCall("{call listaUserPerId(?)}");
        callSp3.setInt(1,2);
        ResultSet resultadoSP3 = callSp3.executeQuery();

        while (resultadoSP3.next()){
            System.out.println(resultadoSP3.getString("name"));
        }

        //Recorrer el resultado
        //while (resultado.next()){
            //System.out.println(resultado.getString("name"));
        //}


    }

}

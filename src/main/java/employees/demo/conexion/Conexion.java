/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees.demo.conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author chiri
 */
public class Conexion {

    public Connection conectar() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=GMT&characterEncoding=UTF-8",
                    "root","root");
            return con;
        } catch (Exception e) {
            e.printStackTrace (); // Esta excepción arroja poco significado
            return null;
        }
    }
}

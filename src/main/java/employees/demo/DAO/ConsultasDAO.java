package employees.demo.DAO;


import employees.demo.conexion.Conexion;
import org.json.*;
import javax.json.*;
import java.sql.*;

public class ConsultasDAO {
    Conexion conexion = new Conexion();

    public String primeraConsulta(){
        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select count(e.EMPLOYEE_ID) from employees e where e.SALARY < 3000;";
            ResultSet rs = stm.executeQuery(sql);
            JSONObject myObject = new JSONObject();
            while (rs.next()){
                try {
                    myObject.put("resultado", new String(rs.getString(1)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            con.close();
            return myObject.toString();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public String segundaConsulta(){
        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select count(e.EMPLOYEE_ID) from employees e where e.SALARY >= 3000 and e.SALARY <= 8000;";
            ResultSet rs = stm.executeQuery(sql);
            JSONObject myObject = new JSONObject();
            while (rs.next()){
                try {
                    myObject.put("resultado", new String(rs.getString(1)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            con.close();
            return myObject.toString();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public String terceraConsulta(){
        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select count(e.EMPLOYEE_ID) from employees e where e.SALARY >= 8000;";
            ResultSet rs = stm.executeQuery(sql);
            JSONObject myObject = new JSONObject();
            while (rs.next()){
                try {
                    myObject.put("resultado", new String(rs.getString(1)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            con.close();
            return myObject.toString();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public String cuartaConsulta(){

    try {
        Connection con = conexion.conectar();
        Statement stm = con.createStatement();
        String sql = "select d.DEPARTMENT_NAME, count(e.EMPLOYEE_ID) from departments d inner join employees e where d.DEPARTMENT_ID = e.DEPARTMENT_ID and e.SALARY < 3000 group by d.DEPARTMENT_NAME;";
        ResultSet rs = stm.executeQuery(sql);
        String response = "";
        while (rs.next()) {
            JSONObject myObject = new JSONObject();
            myObject.put("Departamento", rs.getString(1));
            myObject.put("CantiadEmpleados", rs.getString(2));
            response = response + myObject.toString();
            System.out.println(response);
        }
        return response;
    } catch (Exception e){
    return null;
    }
    }
    public String quintaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select d.DEPARTMENT_NAME, count(e.EMPLOYEE_ID) from departments d inner join employees e where d.DEPARTMENT_ID = e.DEPARTMENT_ID and e.SALARY >= 3000 and e.SALARY <= 8000 group by d.DEPARTMENT_NAME;";
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Departamento", rs.getString(1));
                myObject.put("CantiadEmpleados", rs.getString(2));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public String sextaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select d.DEPARTMENT_NAME, count(e.EMPLOYEE_ID) from departments d inner join employees e where d.DEPARTMENT_ID = e.DEPARTMENT_ID and e.SALARY >= 8000 group by d.DEPARTMENT_NAME;";
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Departamento", rs.getString(1));
                myObject.put("CantiadEmpleados", rs.getString(2));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public String novenaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select * from (select d.DEPARTMENT_NAME, count(e.EMPLOYEE_ID) as many , " +
                    "avg(e.SALARY) as salary_AVG from departments d inner join employees e on d.DEPARTMENT_ID = e.DEPARTMENT_ID  group by d.DEPARTMENT_NAME) t where t.many > 10;";
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Departamento", rs.getString(1));
                myObject.put("CantiadEmpleados", rs.getString(2));
                myObject.put("SuledoPromedio", rs.getString(3));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public String septimaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select d.DEPARTMENT_NAME, e.FIRST_NAME, e.LAST_NAME, e.EMAIL, " +
                    "max(e.SALARY) as Salary from departments d inner join employees e where d.DEPARTMENT_ID = e.DEPARTMENT_ID  group by d.DEPARTMENT_NAME;";
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Departamento", rs.getString(1));
                myObject.put("Nombre", rs.getString(2));
                myObject.put("Apellido", rs.getString(3));
                myObject.put("eMail", rs.getString(4));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public String octavaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select e.FIRST_NAME , e.last_name from employees e " +
                    "inner join departments d on d.MANAGER_ID = e.EMPLOYEE_ID where timestampdiff(year,e.HIRE_DATE, now()) > 15;";
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Nombre", rs.getString(1));
                myObject.put("Apellido", rs.getString(2));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public String decimaConsulta(){

        try {
            Connection con = conexion.conectar();
            Statement stm = con.createStatement();
            String sql = "select c.COUNTRY_NAME, count(e.EMPLOYEE_ID) as employees, min(e.SALARY) as Min_salary, max(e.SALARY) as max_salary, avg(e.SALARY) as AVG_salary, avg(timestampdiff(year,e.HIRE_DATE, now())) as AVG_hire from countries c inner join locations l on c.COUNTRY_ID = l.COUNTRY_ID inner join departments d " +
                    "on d.LOCATION_ID = l.LOCATION_ID inner join employees e on e.DEPARTMENT_ID = d.DEPARTMENT_ID group by c.COUNTRY_NAME ;" ;
            ResultSet rs = stm.executeQuery(sql);
            String response = "";
            while (rs.next()) {
                JSONObject myObject = new JSONObject();
                myObject.put("Pais", rs.getString(1));
                myObject.put("CantiadEmpleados", rs.getString(2));
                myObject.put("SalarioMIn", rs.getString(3));
                myObject.put("SalarioMax", rs.getString(4));
                myObject.put("SalarioAvg", rs.getString(5));
                myObject.put("AntiguedadAvg", rs.getString(6));
                response = response + myObject.toString();
                System.out.println(response);
            }
            return response;
        } catch (Exception e){
            return null;
        }
    }



}


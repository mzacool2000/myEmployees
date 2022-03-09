package employees.demo.controller;

import employees.demo.DAO.ConsultasDAO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultasController {

    private ConsultasDAO consultasDAO = new ConsultasDAO();

    @GetMapping("/1")
    public String primera() {
        return consultasDAO.primeraConsulta();
    }
    @GetMapping("/2")
    public String segunda() {
        return consultasDAO.segundaConsulta();
    }
    @GetMapping("/3")
    public String tercera() {
        return consultasDAO.terceraConsulta();
    }
    @GetMapping("/4")
    public String cuarta() {
        return consultasDAO.cuartaConsulta();
    }
    @GetMapping("/5")
    public String quinta() {
        return consultasDAO.quintaConsulta();
    }
    @GetMapping("/6")
    public String secta() {
        return consultasDAO.sextaConsulta();
    }
    @GetMapping("/7")
    public String septima() {
        return consultasDAO.septimaConsulta();
    }
    @GetMapping("/8")
    public String octava() {
        return consultasDAO.octavaConsulta();
    }
    @GetMapping("/9")
    public String novena() {
        return consultasDAO.novenaConsulta();
    }
    @GetMapping("/10")
    public String decima() {
        return consultasDAO.decimaConsulta();
    }

}

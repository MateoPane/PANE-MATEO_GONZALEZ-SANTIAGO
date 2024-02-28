package dao.implementation;

import dao.BD;
import dao.iDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGO(MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";

    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGO";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Estamos guardando un odontologo");
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());

            psInsert.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
       LOGGER.info("Estamos trayendo todos los odontologos");
       Connection connection = null;
       List<Odontologo> odontologoList = new ArrayList<>();
       Odontologo odontologo = null;

       try {
           connection = BD.getConnection();
           PreparedStatement psSelect = connection.prepareStatement(SELECT_ALL);
           ResultSet rs = psSelect.executeQuery();

           while(rs.next()){
               odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

               odontologoList.add(odontologo);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
               connection.close();
           }catch (Exception e) {
               e.printStackTrace();
           }
       }
       LOGGER.info("Esta es la lista de odontologos: " + odontologoList);
       return odontologoList;
    }
}

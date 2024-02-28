import dao.OdontologoDAOArrayList;
import model.Odontologo;
import org.junit.jupiter.api.Test;
import services.OdontologoService;

import java.util.List;

public class OdontologoTest {
    @Test
    public void casoUno() {
        OdontologoService odontologoService = new OdontologoService();

        Odontologo odontologo1 = new Odontologo(1, "1313", "Juan", "Sanchez");
        Odontologo odontologo2 = new Odontologo(2, "2354", "Mateo", "Ferreira");

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        odontologoService.listarTodos();
    }

    @Test
    public void casoDos() {
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOArrayList());

        Odontologo odontologo1 = new Odontologo(1, "499", "Pedro", "PicaPiedra");
        Odontologo odontologo2 = new Odontologo(2, "421", "Santigo", "Perez");

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarTodos();
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo);
        }
    }
}

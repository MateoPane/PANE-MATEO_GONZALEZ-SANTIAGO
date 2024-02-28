import dao.BD;
import model.Odontologo;
import services.OdontologoService;

public class Main {
    public static void main(String[] args) {
    BD.createTable();
        OdontologoService odontologoService = new OdontologoService();


        Odontologo odontologo1 = new Odontologo(1, "1313", "Juan", "Sanchez");
        Odontologo odontologo2 = new Odontologo(2, "2354", "Mateo", "Ferreira");

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        System.out.println(odontologo1);
        System.out.println(odontologo2);

        System.out.println(odontologoService.listarTodos());

    }
}

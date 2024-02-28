package services;

import dao.iDao;
import dao.implementation.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> idao;
    public OdontologoService(iDao<Odontologo> idao) {
        this.idao = idao;
    }

    public OdontologoService(){
        this.idao = new OdontologoDAOH2();
    }
    public Odontologo guardar(Odontologo odontologo){
        return idao.guardar(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return idao.listarTodos();
    }
}

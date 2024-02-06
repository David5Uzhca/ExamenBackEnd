package examen.recarga.bussines;

import java.util.List;

import examen.recarga.DAO.RecargaDAO;
import examen.recarga.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {

	@Inject
	private RecargaDAO daoRecarga;

	public void guardarRecargas(Recarga recarga) {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if (cli != null){
			daoRecarga.update(recarga);
		}else {
			daoRecarga.insert(recarga);
		}
	}
	
	public void actualizarRecarga(Recarga recarga) throws Exception {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if (cli != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Recarga no existe");
		}
	}
	
	public Recarga getRecargaPorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		//return daoRecarga.getRecargaPorCedula(cedula);
		return daoRecarga.getSaldoYDniPorId(cedula);
	}
	
	public void borrarRecarga(int codigo){
		
		daoRecarga.remove(codigo);
	}
	
	public List<Recarga> getRecargas(){
		return daoRecarga.getAll();
	}
	
    /*public Recarga getSaldoYDniPorId(String id) {
        return daoRecarga.getSaldoYDniPorId(id);
    }*/
}

package examen.recarga.bussines;

import java.util.Date;
import java.util.List;

import examen.recarga.DAO.ClienteDAO;
import examen.recarga.DAO.RecargaDAO;
import examen.recarga.model.Cliente;
import examen.recarga.model.Recarga;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private RecargaDAO recargaDAO;
	
	@PostConstruct
	public void init() {
        System.out.println("************* SERVICIOS **************");
//----------------------------------------INGRESO DE RECARGAS----------------------------------------
        Recarga recarga = new Recarga();
        recarga.setCelular("0998548609");
        recarga.setOperador("Movistar");
        recarga.setMonto(10.20);
        recarga.setFechaEmision(new Date());
        recargaDAO.insert(recarga);
        
        
        
        Cliente cliente = new Cliente();
        cliente.setDni("0302447347");
        cliente.setRecarga(recarga);
        cliente.setNombre("Juan Uzhca");
        cliente.setSaldo(recarga.getMonto());
        clienteDAO.insert(cliente);
        
        
        
        
        
        System.out.println(" LISTA CLIENTES ");
        List<Cliente> clientes = clienteDAO.getAll();
        for(Cliente c : clientes){
            System.out.println(c);
        }

        
        
	}
	
}

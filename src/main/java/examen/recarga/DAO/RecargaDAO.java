package examen.recarga.DAO;

import java.util.List;

import examen.recarga.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga recarga) {
		em.persist(recarga);
	}
	
	public void update(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void remove(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		em.remove(recarga);
	}
	
	public Recarga read(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
	}
	
	public List<Recarga> getAll(){
		String jpql = "SELECT c FROM Recarga c";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
	
	public Recarga getRecargaPorCedula(String cedula){
		String jpql = "SELECT c FROM Recarga c WHERE c.dni = :cedula";
		Query q = em.createQuery(jpql, Recarga.class);
		q.setParameter("cedula", cedula);
		List<Recarga> recargas = q.getResultList();
		if(recargas.size()>0)
			return recargas.get(0);
		return null;
	}
    public Recarga getSaldoYDniPorId(String id) {
        String jpql = "SELECT NEW examen.recarga.model.Recarga(c.fechaEmision, c.celular, c.monto) FROM Recarga c WHERE c.celular = :celular";
        Query q = em.createQuery(jpql, Recarga.class);
        q.setParameter("celular", id);
        List<Recarga> clientes = q.getResultList();
        if (clientes.size() > 0) {
            return clientes.get(0);
        }
        return null;
    }
}

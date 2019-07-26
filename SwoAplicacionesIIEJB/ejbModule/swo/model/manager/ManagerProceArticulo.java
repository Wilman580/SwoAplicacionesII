package swo.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import swo.model.entities.SwoArticulo;
import swo.model.entities.SwoProceArticulo;
import swo.model.entities.SwoProcedimiento;

/**
 * Session Bean implementation class ManagerProceArticulo
 */
@Stateless
@LocalBean
public class ManagerProceArticulo {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerProceArticulo() {
        // TODO Auto-generated constructor stub
    }
    public List<SwoProceArticulo> listarProceArticulo(){
		String sentencia = "SELECT s FROM SwoProceArticulo s";
		Query q = em.createQuery(sentencia,SwoProceArticulo.class);
		return q.getResultList();
	}
	   public SwoProceArticulo buscarporProceArticulo(int codigoProArt){
	        return em.find(SwoProceArticulo.class, codigoProArt);
	    }
	   
	   
	   
		public List<SwoArticulo> listarArticulo(){
			Query q;
			String sentencia = "SELECT s FROM SwoArticulo s";
			q = em.createQuery(sentencia,SwoArticulo.class);
			return q.getResultList();
		}
	
	  	   public SwoArticulo buscarPorCodigoA(int codArticulo) {
	  		   SwoArticulo articulo = em.find(SwoArticulo.class, codArticulo);
	  		   return articulo;
	   }
	  	   
			public List<SwoProcedimiento> listarProcedimiento(){
				Query q;
				String sentencia = "SELECT s FROM SwoProcedimiento s";
				q = em.createQuery(sentencia,SwoProcedimiento.class);
				return q.getResultList();
			}
		
		  	   public SwoProcedimiento buscarPorCodigoP(int codProcedimiento) {
		  		   SwoProcedimiento procedimiento = em.find(SwoProcedimiento.class, codProcedimiento);
		  		   return procedimiento;
		   }	   
	  	   
	  	   
	   
	   public void insertarProceArticulo(int codArticulo, int codProcedimiento) {
	    	SwoProceArticulo proceArticulo= new SwoProceArticulo();
	    	SwoArticulo articulo= buscarPorCodigoA(codArticulo);
	    	SwoProcedimiento procedimiento = buscarPorCodigoP(codProcedimiento);
	    	
	    	proceArticulo.setSwoArticulo(articulo);
	    	proceArticulo.setSwoProcedimiento(procedimiento);
	    	em.persist(proceArticulo);
	    }
	   
	  
	    
	    public void eliminarProcedimiento(int codigoProArt) {
	    	SwoProceArticulo procedimiento= buscarporProceArticulo(codigoProArt);
	    	if(procedimiento!=null)
	    		em.remove(procedimiento);
	    }
	    
	    public void actualizarProceArticulo(SwoProceArticulo procedimiento) throws Exception {
	    	SwoProceArticulo e = buscarporProceArticulo(procedimiento.getCodigoProArt());
	    	if(e==null)
	    		throw new Exception("No existe el tratamiento especificada.");
	    	e.setSwoArticulo(procedimiento.getSwoArticulo());
	    	e.setSwoProcedimiento(procedimiento.getSwoProcedimiento());
	    	em.merge(e);
	    	
	    }

}

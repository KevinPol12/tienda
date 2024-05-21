//package com.latam.alura.tienda.dao;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import com.latam.alura.tienda.modelo.ItemsPedido;
//
//public class ItemsPedidoDao {
//	
//
//	private EntityManager em;
//
//	public ItemsPedidoDao(EntityManager em) {
//		this.em = em;
//	}
//	
//	public void guardar(List<ItemsPedido> itemsPedido) {
//		for (ItemsPedido item : itemsPedido) {
//			em.persist(item);
//		}
//		
//	}
//
//	public ItemsPedido consultaPorId(Long id) {
//		return em.find(ItemsPedido.class, id);
//	}
//	
//	public List<ItemsPedido> consultarTodos(){
//		String jpql = "SELECT P FROM ItemsPedido AS P";
//		return em.createQuery(jpql,ItemsPedido.class).getResultList();
//	}
//	
//	public List<ItemsPedido> consultaPorNombre(String nombre){
//		String jpql = "SELECT P FROM ItemsPedido AS P WHERE P.nombre=:nombre";
//		return em.createQuery(jpql).setParameter("nombre", nombre).getResultList();
//		
//	}
//	
//	public List<ItemsPedido> consultaPorNombreDeCategoria(String nombre){
//		String jpql = "SELECT P FROM ItemsPedido AS P WHERE P.categoria.nombre=:nombre";
//		return em.createQuery(jpql).setParameter("nombre", nombre).getResultList();
//	}
//	
//	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
//		String jpql = "SELECT P.precio FROM ItemsPedido AS P WHERE P.nombre=:nombre";
//		
//		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
//		
//	}
//	
//}

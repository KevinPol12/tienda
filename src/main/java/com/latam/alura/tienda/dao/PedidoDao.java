package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.vo.RelatorioDeVenta;

public class PedidoDao {
	

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jpql = "SELECT P FROM Pedido AS P";
		return em.createQuery(jpql,Pedido.class).getResultList();
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT MAX(P.valorTotal) FROM Pedido AS P";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVenta> relatorioDeVentasVO(){
		String jpql = "SELECT new com.latam.alura.tienda.vo.RelatorioDeVenta(producto.nombre, SUM(item.cantidad), MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				
				+ "GROUP BY producto.nombre "
				+ "ORDER BY SUM(item.cantidad) DESC";
		return em.createQuery(jpql,RelatorioDeVenta.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Long id) {
		String jpql = "SELECT P FROM PEDIDO P JOIN FETCH P.cliente WHERE P.id=:id";
		return em.createQuery(jpql,Pedido.class).setParameter("id", id).getSingleResult();
	}
	
}

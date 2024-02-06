package examen.recarga.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Recarga {
	@Id
	@GeneratedValue
	private int codigo;
	private String celular;
	private String operador;
	private double monto;
	private Date fechaEmision;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", celular=" + celular + ", operador=" + operador + ", monto=" + monto
				+ ", fechaEmision=" + fechaEmision + "]";
	}
	public Recarga(int codigo, String celular, String operador, double monto, Date fechaEmision) {
		super();
		this.codigo = codigo;
		this.celular = celular;
		this.operador = operador;
		this.monto = monto;
		this.fechaEmision = fechaEmision;
	}
	public Recarga() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

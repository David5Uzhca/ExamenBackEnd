package examen.recarga.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private int codigo;
	private String dni;
	private String nombre;
	private double saldo;
    
	@Transient
    private int codigoRecarga;

    public int getCodigoRecarga() {return codigoRecarga;}
    public void setCodigoRecarga(int codigoRecarga) {this.codigoRecarga = codigoRecarga;}

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_recarga", insertable = false, updatable = false)
    private Recarga recarga;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Recarga getRecarga() {
		return recarga;
	}
	public void setRecarga(Recarga recarga) {
		this.recarga = recarga;
	}
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", saldo=" + saldo
				+ ", codigoRecarga=" + codigoRecarga + ", recarga=" + recarga + "]";
	}
	
}

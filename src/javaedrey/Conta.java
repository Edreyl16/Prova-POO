package javaedrey;

/**
 * @author �drey Lucas
 *
 */
public class Conta {
	private String numero;
	private Banco banco;
	private Cliente cliente;
	private double saldo;

	public Conta(String numero, Banco banco, Cliente cliente, double saldo) {
		this.numero = numero;
		this.banco = banco;
		this.cliente = cliente;
		this.saldo = saldo;

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar (double valorDeposito) {
		this.saldo = this.saldo + valorDeposito; 

	}
}

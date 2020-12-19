package javaedrey;

/**
 * @author Édrey Lucas
 *
 */

public class Poupanca extends Conta {
	private double juros;
	
	public Poupanca(String numero, Banco banco, Cliente cliente, double saldo) {
		super(numero, banco, cliente, saldo);
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	public void renderJuros() {
		this.juros = (super.getSaldo() * 2.0) / 100;
		super.setSaldo(super.getSaldo() + this.juros);  
	}
}

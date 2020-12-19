package javaedrey;

/**
 * @author Édrey Lucas
 *
 */

public class Banco {
	private String nomedaAgencia;
	private String numerodaAgencia;

	public Banco(String nomedaAgencia, String numerodaAgencia) {
		this.nomedaAgencia = nomedaAgencia;
		this.numerodaAgencia = numerodaAgencia;
	}

	public String getNomedaAgencia() {
		return nomedaAgencia;
	}

	public void setNomedaAgencia(String nomedaAgencia) {
		this.nomedaAgencia = nomedaAgencia;
	}

	public String getNumerodaAgencia() {
		return numerodaAgencia;
	}

	public void setNumerodaAgencia(String numerodaAgencia) {
		this.numerodaAgencia = numerodaAgencia;
	}
	
}

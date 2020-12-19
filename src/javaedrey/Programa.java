package javaedrey;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {

		String opcao;
		List<Conta> listaContas = new ArrayList<Conta>();

		while (true) {
			opcao = JOptionPane.showInputDialog(" 1. Cadastrar Conta ou Poupan�a" + "	\n 2. Realizar dep�sito"
					+ "	\n 3. Render Juros" + "	\n 4. Consultar n�mero e nome da ag�ncia"
					+ "	\n 5. Alterar o n�mero e nome da ag�ncia" + " \n 0. Sair");

			if (opcao.equals("1")) {
				String cadastrarConta = JOptionPane
						.showInputDialog(" 1. Cadastrar Conta" + " \n 2. Cadastrar Poupan�a");
				if (cadastrarConta.equals("1")) {
					String nomedaAgencia = JOptionPane.showInputDialog(" Digite o Nome da Ag�ncia:");
					String numerodaAgencia = JOptionPane.showInputDialog(" Digite o N�mero da Ag�ncia:");
					String numero = JOptionPane.showInputDialog(" Digite o N�mero da Sua Conta:");
					Banco banco = new Banco(nomedaAgencia, numerodaAgencia);
					String nome = JOptionPane.showInputDialog(" Digite o Seu Nome:");
					String cpf = JOptionPane.showInputDialog(" Digite o N�mero do seu CPF:");
					Cliente cliente = new Cliente(nome, cpf);
					double saldo = Double.parseDouble(JOptionPane.showInputDialog(" Digite o Saldo da Conta:"));
					Conta conta = new Conta(numero, banco, cliente, saldo);
					listaContas.add(conta);
				} else if (cadastrarConta.equals("2")) {
					String nomedaAgencia = JOptionPane.showInputDialog(" Digite o Nome da Ag�ncia:");
					String numerodaAgencia = JOptionPane.showInputDialog(" Digite o N�mero da Ag�ncia:");
					String numero = JOptionPane.showInputDialog(" Digite o N�mero da Sua Poupan�a:");
					Banco banco = new Banco(nomedaAgencia, numerodaAgencia);
					String nome = JOptionPane.showInputDialog(" Digite o Seu Nome:");
					String cpf = JOptionPane.showInputDialog(" Digite o N�mero do seu CPF:");
					Cliente cliente = new Cliente(nome, cpf);
					double saldo = Double.parseDouble(JOptionPane.showInputDialog(" Digite o Saldo da Poupan�a:"));
					Poupanca poupanca = new Poupanca(numero, banco, cliente, saldo);
					listaContas.add(poupanca);
				} else {
					JOptionPane.showMessageDialog(null, "Op��o Incorreta!");
				}

			} else if (opcao.equals("2")) {
				String texto = "";
				String numeroCPF = JOptionPane.showInputDialog(" Digite o N�mero do seu CPF:");
				if (listaContas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "N�o Existe Contas Cadastradas!");
				} else {
					for (int i = 0; i < listaContas.size(); i++) {
						if (listaContas.get(i).getCliente().getCpf().equals(numeroCPF)) {
							double valorDeposito = Double
									.parseDouble(JOptionPane.showInputDialog("Qual o Valor do Dep�sito: "));
							listaContas.get(i).depositar(valorDeposito);
							JOptionPane.showMessageDialog(null, "Seu Novo Saldo �: " + listaContas.get(i).getSaldo());
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Intru��o inv�lida!");
							break;
						}
					}
				}

			} else if (opcao.equals("3")) {
				String texto = "";
				String numeroCPF = JOptionPane.showInputDialog(" Digite o N�mero do seu CPF:");
				if (listaContas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "N�o Existe Contas Cadastradas!");
				} else {
					for (int i = 0; i < listaContas.size(); i++) {
						if (listaContas.get(i).getCliente().getCpf().equals(numeroCPF)) {
							if (listaContas.get(i) instanceof Poupanca) {
								Poupanca poupanca = (Poupanca) listaContas.get(i);
								poupanca.renderJuros();
								JOptionPane.showMessageDialog(null, "Saldo:" + poupanca.getSaldo());
							} else {
								JOptionPane.showMessageDialog(null, "Conta Poupan�a Inexistente!");
							}
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Intru��o inv�lida!");
							break;
						}
					}
				}

			} else if (opcao.equals("4")) {
				String texto = "";
				String numeroConta = JOptionPane.showInputDialog(" Digite o N�mero da Conta:");
				for (int i = 0; i < listaContas.size(); i++) {
					if (listaContas.get(i).getNumero().equals(numeroConta)) {
						texto += "Nome da Ag�ncia: " + listaContas.get(i).getBanco().getNomedaAgencia()
								+ "\n N�mero da Ag�ncia: " + listaContas.get(i).getBanco().getNumerodaAgencia()
								+ "\n  Nome do Cliente: " + listaContas.get(i).getCliente().getNome() + "\n CPF:"
								+ listaContas.get(i).getCliente().getCpf();
						JOptionPane.showMessageDialog(null, texto);
						break;
					} else {
						JOptionPane.showMessageDialog(null, "N�o existe conta para o n�mero informado!");
						break;
					}
				}

			} else if (opcao.equals("5")) {
				String texto = "";
				String nome = JOptionPane.showInputDialog(" Digite o Seu Nome:");
				if (listaContas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "N�o Existe Contas Cadastradas!");
				} else {
					for (int i = 0; i < listaContas.size(); i++) {
						if (listaContas.get(i).getCliente().getNome().equals(nome)) {
							String nomedaAgencia = JOptionPane.showInputDialog(" Digite o Novo Nome da Ag�ncia:");
							String numerodaAgencia = JOptionPane.showInputDialog(" Digite o Novo N�mero da Ag�ncia:");
							Banco banco = new Banco(nomedaAgencia, numerodaAgencia);
							listaContas.get(i).setBanco(banco);
							JOptionPane.showMessageDialog(null, "Novo Nome:" + listaContas.get(i).getBanco().getNomedaAgencia() + "\n Novo N�mero:"
											+ listaContas.get(i).getBanco().getNumerodaAgencia());
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Intru��o inv�lida!");
							break;
						}
					}
				}

			} else if (opcao.equals("0")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Op��o Incorreta!");
			}
		}

	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {
	private List<Cliente> clientes = new ArrayList<>();
	private Scanner s;

	public CadastroCliente(Scanner s) {
		this.s = s;
	}

	public Cliente cadastrar() {
		System.out.println("Cadastro de Cliente\n");

		String nome = lerCampo("Nome: ");
		while (nome.isEmpty()) {
			System.out.println("Nome nao pode ser vazio!");
			nome = lerCampo("Nome: ");
		}

		String cpf = lerCampo("CPF (somente numeros): ");
		while (!cpfValido(cpf) || buscarPorCpf(cpf) != null) {
			if (!cpfValido(cpf)) {
				System.out.println("CPF invalido! Informe 11 digitos.");
			} else {
				System.out.println("Ja existe cliente cadastrado com este CPF!");
			}
			cpf = lerCampo("CPF (somente numeros): ");
		}

		String email = lerCampo("Email: ");
		while (!email.contains("@")) {
			System.out.println("Email invalido!");
			email = lerCampo("Email: ");
		}

		Cliente cliente = new Cliente(nome, cpf, email);
		clientes.add(cliente);
		System.out.println("Cliente cadastrado com sucesso!");
		System.out.println(cliente);
		return cliente;
	}

	public Cliente buscarPorCpf(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	private boolean cpfValido(String cpf) {
		return cpf.matches("\d{11}");
	}

	private String lerCampo(String rotulo) {
		System.out.println(rotulo);
		return s.nextLine().trim();
	}
}

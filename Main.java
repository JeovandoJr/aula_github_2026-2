import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar Cliente", "Voltar"));
		Menu operacoesMenu = new Menu("Menu Operacoes", Arrays.asList("Saque", "Voltar"));
		CadastroCliente cadastroCliente = new CadastroCliente(Menu.scanner);
		Operacoes operacoes = new Operacoes(Menu.scanner);

		// Conta de exemplo enquanto nao existe cadastro de conta
		operacoes.adicionarConta(new Conta(1, new Cliente("Cliente Exemplo", "00000000000", "exemplo@email.com"), 500.0));

		int op = 0;
		while (op != 4) {
			op = mainMenu.getSelection();
			switch (op) {
				case 2:
					if (clienteMenu.getSelection() == 1) {
						cadastroCliente.cadastrar();
					}
					break;
				case 3:
					if (operacoesMenu.getSelection() == 1) {
						operacoes.sacar();
					}
					break;
				case 4:
					break;
				default:
					System.out.println(op + " foi selecionada");
			}
		}
		System.out.println("Fim");
	}

}

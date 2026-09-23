import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar Cliente", "Voltar"));
		CadastroCliente cadastroCliente = new CadastroCliente(Menu.scanner);

		int op = 0;
		while (op != 4) {
			op = mainMenu.getSelection();
			switch (op) {
				case 2:
					if (clienteMenu.getSelection() == 1) {
						cadastroCliente.cadastrar();
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

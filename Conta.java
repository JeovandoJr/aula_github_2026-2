public class Conta {
	private int numero;
	private Cliente titular;
	private double saldo;

	public Conta(int numero, Cliente titular, double saldoInicial) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldoInicial;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void sacar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor do saque deve ser maior que zero!");
		}
		if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente!");
		}
		saldo -= valor;
	}

	@Override
	public String toString() {
		return "Conta: " + numero + " | Titular: " + titular.getNome() + " | Saldo: R$ " + String.format("%.2f", saldo);
	}
}

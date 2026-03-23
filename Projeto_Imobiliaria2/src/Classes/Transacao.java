package Classes;

import java.time.LocalDate;

public class Transacao {
    private static int contador = 0;

    private int numeroContrato;
    private LocalDate data;
    private TipoTransacao tipo;
    private Imovel imovel;
    private ClienteUsuario cliente;
    private Funcionario funcionario;
    private double valorTotal;
    private double valorComissaoFuncionario;
    private double valorComissaoImobiliaria;

    public Transacao(Imovel imovel, ClienteUsuario cliente, Funcionario funcionario, double valorTotal, TipoTransacao tipo) {
        contador++;
        this.numeroContrato = contador;
        this.data = LocalDate.now();
        this.tipo = tipo;
        this.imovel = imovel;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
    }

    public void calcularComissoes(double percentualFuncionario, double percentualImobiliaria) {
        this.valorComissaoFuncionario = valorTotal * percentualFuncionario;
        this.valorComissaoImobiliaria = valorTotal * percentualImobiliaria;
    }

    public void aplicarTransacao() {
        if (tipo == TipoTransacao.VENDA) {
            imovel.vender(valorTotal);
        } else {
            imovel.alugar(valorTotal);
        }

        funcionario.adicionarTransacao(this);
    }

    public boolean isVenda() {
        return tipo == TipoTransacao.VENDA;
    }

    public boolean isLocacao() {
        return tipo == TipoTransacao.LOCACAO;
    }

    public double getValorLiquidoImobiliaria() {
        return valorComissaoImobiliaria;
    }

    public String resumo() {
        return "Contrato #" + numeroContrato +
                " | Tipo: " + tipo +
                " | Valor: " + valorTotal +
                " | Cliente: " + cliente.getNome();
    }

    @Override
    public String toString() {
        return "Contrato #" + numeroContrato +
                "\nTipo: " + tipo +
                "\nData: " + data +
                "\nImóvel ID: " + imovel.getId() +
                "\nCliente: " + cliente.getNome() +
                "\nFuncionário: " + funcionario.getNome() +
                "\nValor Total: " + valorTotal +
                "\nComissão Funcionário: " + valorComissaoFuncionario +
                "\nComissão Imobiliária: " + valorComissaoImobiliaria +
                "\n-------------------------";
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Transacao.contador = contador;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public ClienteUsuario getCliente() {
        return cliente;
    }

    public void setCliente(ClienteUsuario cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorComissaoFuncionario() {
        return valorComissaoFuncionario;
    }

    public void setValorComissaoFuncionario(double valorComissaoFuncionario) {
        this.valorComissaoFuncionario = valorComissaoFuncionario;
    }

    public double getValorComissaoImobiliaria() {
        return valorComissaoImobiliaria;
    }

    public void setValorComissaoImobiliaria(double valorComissaoImobiliaria) {
        this.valorComissaoImobiliaria = valorComissaoImobiliaria;
    }
}

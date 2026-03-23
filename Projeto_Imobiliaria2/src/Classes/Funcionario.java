package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salarioBase;
    private String usuario;
    private String senha;
    private LocalDate dataIngresso;
    private List<Transacao> transacoes;

    public Funcionario(String cpf, String nome, String email, String sexo, String estadoCivil, String profissao, Endereco endereco, String cargo, double salarioBase, String usuario, String senha, LocalDate dataIngresso) {
        super(cpf, nome, email, sexo, estadoCivil, profissao, endereco);
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.usuario = usuario;
        this.senha = senha;
        this.dataIngresso = dataIngresso;
        this.transacoes = new ArrayList<>();
    }

    public Double calcularSalario(){
        double totalComissoes = 0;

        for (Transacao t : transacoes) {
            totalComissoes += t.getValorComissaoFuncionario();
        }

        return this.salarioBase + totalComissoes;
    }

    public boolean testarSenha(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    public void adicionarTransacao(Transacao t) {
        this.transacoes.add(t);
    }


    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada.");
            return;
        }

        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }

    public double getTotalComissoes() {
        double total = 0;
        for (Transacao t : transacoes) {
            total += t.getValorComissaoFuncionario();
        }
        return total;
    }

    public int getQuantidadeTransacoes() {
        return transacoes.size();
    }

    public Transacao buscarTransacaoPorNumero(int numeroContrato) {
        for (Transacao t : transacoes) {
            if (t.getNumeroContrato() == numeroContrato) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nCargo: " + cargo +
                "\nSalário Base: " + salarioBase +
                "\nTotal Comissões: " + getTotalComissoes() +
                "\nTotal Transações: " + getQuantidadeTransacoes() +
                "\n-------------------------";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}

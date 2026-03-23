package Classes;

import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
    private String nome;
    private String cnpj;
    private List<Imovel> imoveis;
    private List<Funcionario> funcionarios;
    private List<Transacao> transacoes;
    private List<ClienteUsuario> clientesUsuarios;
    private List<ClienteProprietario> clientesProprietarios;

    public Imobiliaria(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.imoveis = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        this.clientesUsuarios = new ArrayList<>();
        this.clientesProprietarios = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void adicionarClienteUsuario(ClienteUsuario c){
        clientesUsuarios.add(c);
    }

    public void adicionarClienteProprietario(ClienteProprietario c){
        clientesProprietarios.add(c);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }


    public Imovel buscarImovelPorId(int id) {
        for (Imovel i : imoveis) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public ClienteUsuario buscarClienteUsuarioPorCpf(String cpf){
        for (ClienteUsuario c : clientesUsuarios) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public ClienteProprietario buscarClienteProprietarioPorCpf(String cpf){
        for (ClienteProprietario c : clientesProprietarios) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) return f;
        }
        return null;
    }

    public Transacao buscarTransacaoPorNumero(int numero) {
        for (Transacao t : transacoes) {
            if (t.getNumeroContrato() == numero) return t;
        }
        return null;
    }


    public List<Imovel> listarImoveisDisponiveis() {
        List<Imovel> disponiveis = new ArrayList<>();

        for (Imovel i : imoveis) {
            if (i.estaDisponivel()) {
                disponiveis.add(i);
            }
        }

        return disponiveis;
    }

    public List<Transacao> listarTransacoes() {
        return transacoes;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }


    public void registrarVenda(int idImovel, String cpfCliente, String cpfFuncionario, double valorFinal) {

        Imovel imovel = buscarImovelPorId(idImovel);
        ClienteUsuario cliente = buscarClienteUsuarioPorCpf(cpfCliente);
        Funcionario funcionario = buscarFuncionarioPorCpf(cpfFuncionario);

        if (imovel == null) throw new IllegalArgumentException("Imóvel não encontrado");
        if (cliente == null) throw new IllegalArgumentException("Cliente não encontrado");
        if (funcionario == null) throw new IllegalArgumentException("Funcionário não encontrado");

        if (!imovel.estaDisponivel()) {
            throw new IllegalStateException("Imóvel não está disponível");
        }
        Transacao t = new Transacao(imovel, cliente, funcionario, valorFinal, TipoTransacao.VENDA);

        t.calcularComissoes(0.05, 0.10);
        t.aplicarTransacao();
        funcionario.adicionarTransacao(t);
        transacoes.add(t);
    }

    public void registrarLocacao(int idImovel, String cpfCliente, String cpfFuncionario, double valorFinal) {

        Imovel imovel = buscarImovelPorId(idImovel);
        ClienteUsuario cliente = buscarClienteUsuarioPorCpf(cpfCliente);
        Funcionario funcionario = buscarFuncionarioPorCpf(cpfFuncionario);

        if (imovel == null) throw new IllegalArgumentException("Imóvel não encontrado");
        if (cliente == null) throw new IllegalArgumentException("Cliente não encontrado");
        if (funcionario == null) throw new IllegalArgumentException("Funcionário não encontrado");

        if (!imovel.estaDisponivel()) {
            throw new IllegalStateException("Imóvel não está disponível");
        }

        Transacao t = new Transacao(
                imovel, cliente, funcionario, valorFinal, TipoTransacao.LOCACAO
        );

        t.calcularComissoes(0.05, 0.10);
        t.aplicarTransacao();
        funcionario.adicionarTransacao(t);
        transacoes.add(t);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public List<Imovel> getImoveis() { return imoveis; }
    public void setImoveis(List<Imovel> imoveis) { this.imoveis = imoveis; }

    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios = funcionarios; }

    public List<Transacao> getTransacoes() { return transacoes; }
    public void setTransacoes(List<Transacao> transacoes) { this.transacoes = transacoes; }

    public List<ClienteUsuario> getClientesUsuarios() { return clientesUsuarios; }
    public List<ClienteProprietario> getClientesProprietarios() { return clientesProprietarios; }
}
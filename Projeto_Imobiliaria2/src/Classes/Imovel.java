package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Imovel {
    private int id;
    private LocalDate dataConstrucao;
    private LocalDate dataCadastro;
    private LocalDate dataDisponibilizacao;
    private LocalDate dataFinalizacao;
    private List<ClienteProprietario> proprietarios;
    private StatusImovel status;
    private Double valorSugerido;
    private Double valorReal;
    private Endereco endereco;

    public Imovel(int id, LocalDate dataConstrucao, LocalDate dataCadastro,
                  LocalDate dataDisponibilizacao, LocalDate dataFinalizacao,
                  StatusImovel status, Double valorSugerido, Double valorReal,
                  Endereco endereco) {

        this.id = id;
        this.dataConstrucao = dataConstrucao;
        this.dataCadastro = dataCadastro;
        this.dataDisponibilizacao = dataDisponibilizacao;
        this.dataFinalizacao = dataFinalizacao;
        this.status = status;
        this.valorSugerido = valorSugerido;
        this.valorReal = valorReal;
        this.endereco = endereco;
        this.proprietarios = new ArrayList<>();
    }



    public void adicionarProprietario(ClienteProprietario p) {
        if (p != null) {
            proprietarios.add(p);
        }
    }

    public List<ClienteProprietario> getProprietarios() {
        return proprietarios;
    }



    public void colocarParaVenda(Double valor) {
        this.status = StatusImovel.DISPONIVEL_VENDA;
        this.valorSugerido = valor;
        this.dataDisponibilizacao = LocalDate.now();
    }

    public void colocarParaLocacao(Double valor) {
        this.status = StatusImovel.DISPONIVEL_LOCACAO;
        this.valorSugerido = valor;
        this.dataDisponibilizacao = LocalDate.now();
    }

    public void vender(Double valorFinal) {
        if (status != StatusImovel.DISPONIVEL_VENDA) {
            throw new IllegalStateException("Imóvel não está disponível para venda");
        }

        this.status = StatusImovel.VENDIDO;
        this.valorReal = valorFinal;
        this.dataFinalizacao = LocalDate.now();
    }

    public void alugar(Double valorFinal) {
        if (status != StatusImovel.DISPONIVEL_LOCACAO) {
            throw new IllegalStateException("Imóvel não está disponível para locação");
        }

        this.status = StatusImovel.ALUGADO;
        this.valorReal = valorFinal;
        this.dataFinalizacao = LocalDate.now();
    }

    public boolean estaDisponivel() {
        return status == StatusImovel.DISPONIVEL_VENDA ||
                status == StatusImovel.DISPONIVEL_LOCACAO;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                "\nStatus: " + status +
                "\nValor Sugerido: " + valorSugerido +
                "\nValor Real: " + valorReal +
                "\nBairro: " + (endereco != null ? endereco.getBairro() : "N/A") +
                "\nQtd Proprietários: " + proprietarios.size() +
                "\n-------------------------";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDataConstrucao() { return dataConstrucao; }
    public void setDataConstrucao(LocalDate dataConstrucao) { this.dataConstrucao = dataConstrucao; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDate getDataDisponibilizacao() { return dataDisponibilizacao; }
    public void setDataDisponibilizacao(LocalDate dataDisponibilizacao) { this.dataDisponibilizacao = dataDisponibilizacao; }

    public LocalDate getDataFinalizacao() { return dataFinalizacao; }
    public void setDataFinalizacao(LocalDate dataFinalizacao) { this.dataFinalizacao = dataFinalizacao; }

    public StatusImovel getStatus() { return status; }
    public void setStatus(StatusImovel status) { this.status = status; }

    public Double getValorSugerido() { return valorSugerido; }
    public void setValorSugerido(Double valorSugerido) { this.valorSugerido = valorSugerido; }

    public Double getValorReal() { return valorReal; }
    public void setValorReal(Double valorReal) { this.valorReal = valorReal; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
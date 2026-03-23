package Classes;

import java.time.LocalDate;

public class SalaComercial extends Imovel{
    private Double area;
    private int qtdBanheiros;
    private int qtdComodos;

    public SalaComercial(int id, LocalDate dataConstrucao, LocalDate dataCadastro, LocalDate dataDisponibilizacao, LocalDate dataFinalizacao, StatusImovel status, Double valorSugerido, Double valorReal, Endereco endereco, Double area, int qtdBanheiros, int qtdComodos) {
        super(id, dataConstrucao, dataCadastro, dataDisponibilizacao, dataFinalizacao, status, valorSugerido, valorReal, endereco);
        this.area = area;
        this.qtdBanheiros = qtdBanheiros;
        this.qtdComodos = qtdComodos;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public int getQtdBanheiros() {
        return qtdBanheiros;
    }

    public void setQtdBanheiros(int qtdBanheiros) {
        this.qtdBanheiros = qtdBanheiros;
    }

    public int getQtdComodos() {
        return qtdComodos;
    }

    public void setQtdComodos(int qtdComodos) {
        this.qtdComodos = qtdComodos;
    }
}

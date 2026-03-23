package Classes;

import java.time.LocalDate;

public class Apartamento extends Imovel{
    private int quartos;
    private int suites;
    private int salasEstar;
    private int salasJantar;
    private int vagasGaragem;
    private double area;
    private boolean armarioEmbutido;
    private String descricao;
    private int andar;
    private double valorCondominio;
    private boolean portaria24h;

    public Apartamento(int id, LocalDate dataConstrucao, LocalDate dataCadastro, LocalDate dataDisponibilizacao, LocalDate dataFinalizacao, StatusImovel status, Double valorSugerido, Double valorReal, Endereco endereco, int quartos, int suites, int salasEstar, int salasJantar, int vagasGaragem, double area, boolean armarioEmbutido, String descricao, int andar, double valorCondominio, boolean portaria24h) {
        super(id, dataConstrucao, dataCadastro, dataDisponibilizacao, dataFinalizacao, status, valorSugerido, valorReal, endereco);
        this.quartos = quartos;
        this.suites = suites;
        this.salasEstar = salasEstar;
        this.salasJantar = salasJantar;
        this.vagasGaragem = vagasGaragem;
        this.area = area;
        this.armarioEmbutido = armarioEmbutido;
        this.descricao = descricao;
        this.andar = andar;
        this.valorCondominio = valorCondominio;
        this.portaria24h = portaria24h;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getSalasEstar() {
        return salasEstar;
    }

    public void setSalasEstar(int salasEstar) {
        this.salasEstar = salasEstar;
    }

    public int getSalasJantar() {
        return salasJantar;
    }

    public void setSalasJantar(int salasJantar) {
        this.salasJantar = salasJantar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isArmarioEmbutido() {
        return armarioEmbutido;
    }

    public void setArmarioEmbutido(boolean armarioEmbutido) {
        this.armarioEmbutido = armarioEmbutido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public boolean isPortaria24h() {
        return portaria24h;
    }

    public void setPortaria24h(boolean portaria24h) {
        this.portaria24h = portaria24h;
    }
}

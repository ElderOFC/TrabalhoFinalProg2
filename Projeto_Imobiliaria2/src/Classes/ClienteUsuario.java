package Classes;

import java.util.ArrayList;
import java.util.List;

public class ClienteUsuario extends Cliente{
    private List<Pessoa> fiadores;
    private List<Pessoa> indicacoes;

    public ClienteUsuario(String cpf, String nome, String email, String sexo, String estadoCivil, String profissao, Endereco endereco) {
        super(cpf, nome, email, sexo, estadoCivil, profissao, endereco);
        this.fiadores = new ArrayList<>();
        this.indicacoes = new ArrayList<>();
    }

    public List<Pessoa> getFiadores() {
        return fiadores;
    }

    public void setFiadores(List<Pessoa> fiadores) {
        this.fiadores = fiadores;
    }

    public List<Pessoa> getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(List<Pessoa> indicacoes) {
        this.indicacoes = indicacoes;
    }
}

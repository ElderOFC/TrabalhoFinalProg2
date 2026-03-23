package Classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String email;
    protected String sexo;
    protected String estadoCivil;
    protected String profissao;
    protected List<String> telefones;
    protected Endereco endereco;

    public Pessoa(String cpf, String nome, String email, String sexo, String estadoCivil, String profissao, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.telefones = new ArrayList<>();
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

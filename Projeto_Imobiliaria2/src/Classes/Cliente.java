package Classes;

public class Cliente extends Pessoa{
    public Cliente(String cpf, String nome, String email, String sexo, String estadoCivil, String profissao, Endereco endereco) {
        super(cpf, nome, email, sexo, estadoCivil, profissao, endereco);
    }
}

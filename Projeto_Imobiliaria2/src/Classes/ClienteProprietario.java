package Classes;

public class ClienteProprietario extends Cliente{
    public ClienteProprietario(String cpf, String nome, String email, String sexo, String estadoCivil, String profissao, Endereco endereco) {
        super(cpf, nome, email, sexo, estadoCivil, profissao, endereco);
    }
}

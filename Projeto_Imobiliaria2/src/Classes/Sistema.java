package Classes;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {

    private static Scanner sc = new Scanner(System.in);
    private static Imobiliaria imobiliaria = new Imobiliaria("Imobiliária Seu Imóvel", "12345678000101");

    void main() {
        Funcionario admin = new Funcionario("000", "Administrador", "admin@email.com", "M",
                "Solteiro", "Gerente", new Endereco("Rua A", "0", "Centro", "Cidade", "Estado"),
                "Gerente", 5000.0, "admin", "123", LocalDate.now());

        imobiliaria.adicionarFuncionario(admin);

        Funcionario logado = null;

        while (logado == null) {
            logado = login(imobiliaria, sc);
        }

        int opcao;

        do {
            IO.println("\n===== SISTEMA IMOBILIÁRIA =====");
            IO.println("1 - Cadastrar Imóvel");
            IO.println("2 - Cadastrar Cliente Usuário");
            IO.println("3 - Cadastrar Cliente Proprietário");
            IO.println("4 - Cadastrar Funcionário");
            IO.println("5 - Listar Imóveis Disponíveis");
            IO.println("6 - Registrar Venda");
            IO.println("7 - Registrar Locação");
            IO.println("8 - Listar Transações");
            IO.println("0 - Sair");
            IO.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarImovel();
                case 2 -> cadastrarClienteUsuario();
                case 3 -> cadastrarClienteProprietario();
                case 4 -> cadastrarFuncionario();
                case 5 -> listarImoveis();
                case 6 -> registrarVenda();
                case 7 -> registrarLocacao();
                case 8 -> listarTransacoes();
                case 0 -> IO.println("Encerrando...");
                default -> IO.println("Opção inválida!");
            }

        } while (opcao != 0);
    }


    private static void cadastrarImovel() {

        IO.println("Tipo de imóvel:");
        IO.println("1 - Casa");
        IO.println("2 - Apartamento");
        IO.println("3 - Terreno");
        IO.println("4 - Sala Comercial");
        int tipo = sc.nextInt();
        sc.nextLine();

        IO.print("ID: ");
        int id = sc.nextInt();

        IO.print("Valor sugerido: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Endereco endereco = lerEndereco();

        Imovel imovel = null;

        switch (tipo) {

            case 1 -> {
                IO.print("Quartos: ");
                int quartos = sc.nextInt();

                IO.print("Suítes: ");
                int suites = sc.nextInt();

                IO.print("Salas estar: ");
                int salasEstar = sc.nextInt();

                IO.print("Salas jantar: ");
                int salasJantar = sc.nextInt();

                IO.print("Vagas garagem: ");
                int vagas = sc.nextInt();

                IO.print("Área: ");
                double area = sc.nextDouble();

                IO.print("Armário embutido (true/false): ");
                boolean armario = sc.nextBoolean();
                sc.nextLine();

                IO.print("Descrição: ");
                String desc = sc.nextLine();

                imovel = new Casa(
                        id, LocalDate.now(), LocalDate.now(), LocalDate.now(), null,
                        StatusImovel.DISPONIVEL_VENDA, valor, null, endereco,
                        quartos, suites, salasEstar, salasJantar, vagas,
                        area, armario, desc
                );
            }

            case 2 -> {
                IO.print("Quartos: ");
                int quartos = sc.nextInt();

                IO.print("Andar: ");
                int andar = sc.nextInt();

                IO.print("Valor condomínio: ");
                double cond = sc.nextDouble();

                IO.print("Portaria 24h (true/false): ");
                boolean portaria = sc.nextBoolean();
                sc.nextLine();

                imovel = new Apartamento(
                        id, LocalDate.now(), LocalDate.now(), LocalDate.now(), null,
                        StatusImovel.DISPONIVEL_VENDA, valor, null, endereco,
                        quartos, 0, 1, 1, 1,
                        50, false, "Apartamento",
                        andar, cond, portaria
                );
            }

            case 3 -> {
                IO.print("Área: ");
                double area = sc.nextDouble();

                IO.print("Largura: ");
                double largura = sc.nextDouble();

                IO.print("Comprimento: ");
                double comprimento = sc.nextDouble();

                IO.print("Aclive/Declive (true/false): ");
                boolean aclive = sc.nextBoolean();

                imovel = new Terreno(
                        id, LocalDate.now(), LocalDate.now(), LocalDate.now(), null,
                        StatusImovel.DISPONIVEL_VENDA, valor, null, endereco,
                        area, largura, comprimento, aclive
                );
            }

            case 4 -> {
                IO.print("Área: ");
                double area = sc.nextDouble();

                IO.print("Banheiros: ");
                int banheiros = sc.nextInt();

                IO.print("Cômodos: ");
                int comodos = sc.nextInt();

                imovel = new SalaComercial(
                        id, LocalDate.now(), LocalDate.now(), LocalDate.now(), null,
                        StatusImovel.DISPONIVEL_VENDA, valor, null, endereco,
                        area, banheiros, comodos
                );
            }

            default -> {
                IO.println("Tipo inválido!");
                return;
            }
        }
        char opc;
        boolean temProprietario = false;

        do {
            sc.nextLine();
            IO.print("CPF do proprietário: ");
            String cpf = sc.nextLine();

            ClienteProprietario prop =
                    imobiliaria.buscarClienteProprietarioPorCpf(cpf);

            if (prop != null) {
                imovel.adicionarProprietario(prop);
                temProprietario = true;
            } else {
                IO.println("Proprietário não encontrado!");
            }

            IO.print("Adicionar outro proprietário? (s/n): ");
            opc = sc.nextLine().charAt(0);

        } while (opc == 's' || opc == 'S');

        if (!temProprietario) {
            IO.println("Imóvel deve ter pelo menos um proprietário!");
            return;
        }

        imobiliaria.adicionarImovel(imovel);
        IO.println(" Imóvel cadastrado com sucesso!");

    }

    private static void cadastrarClienteUsuario() {

        IO.print("CPF: ");
        String cpf = sc.nextLine();

        IO.print("Nome: ");
        String nome = sc.nextLine();

        IO.print("Email: ");
        String email = sc.nextLine();

        IO.print("Sexo: ");
        String sexo = sc.nextLine();

        IO.print("Estado civil: ");
        String estadoCivil = sc.nextLine();

        IO.print("Profissão: ");
        String profissao = sc.nextLine();

        Endereco endereco = lerEndereco();

        ClienteUsuario c = new ClienteUsuario(
                cpf, nome, email, sexo, estadoCivil, profissao, endereco
        );

        char opc;

        do {
            IO.print("Deseja adicionar fiador? (s/n): ");
            opc = sc.nextLine().charAt(0);

            if (opc == 's' || opc == 'S') {

                IO.print("Nome do fiador: ");
                String nome2 = sc.nextLine();

                IO.print("CPF do fiador: ");
                String cpf2 = sc.nextLine();

                PessoaSimples fiador = new PessoaSimples(cpf2, nome2);

                c.getFiadores().add(fiador);
            }

        } while (opc == 's' || opc == 'S');

        do {
            IO.print("Deseja adicionar indicação? (s/n): ");
            opc = sc.nextLine().charAt(0);

            if (opc == 's' || opc == 'S') {

                IO.print("Nome da indicação: ");
                String nome3 = sc.nextLine();

                IO.print("CPF da indicação: ");
                String cpf3 = sc.nextLine();

                PessoaSimples indicacao = new PessoaSimples(cpf3, nome3);

                c.getIndicacoes().add(indicacao);
            }

        } while (opc == 's' || opc == 'S');

        imobiliaria.adicionarClienteUsuario(c);
        IO.println("Cliente usuário cadastrado!");
    }

    private static void cadastrarClienteProprietario() {

        IO.print("CPF: ");
        String cpf = sc.nextLine();

        IO.print("Nome: ");
        String nome = sc.nextLine();

        IO.print("Email: ");
        String email = sc.nextLine();

        IO.print("Sexo: ");
        String sexo = sc.nextLine();

        IO.print("Estado civil: ");
        String estadoCivil = sc.nextLine();

        IO.print("Profissão: ");
        String profissao = sc.nextLine();

        Endereco endereco = lerEndereco();

        ClienteProprietario c = new ClienteProprietario(
                cpf, nome, email, sexo, estadoCivil, profissao, endereco
        );

        imobiliaria.adicionarClienteProprietario(c);
        IO.println("Cliente proprietário cadastrado!");
    }


    private static void cadastrarFuncionario() {

        IO.print("CPF: ");
        String cpf = sc.nextLine();

        IO.print("Nome: ");
        String nome = sc.nextLine();

        IO.print("Email: ");
        String email = sc.nextLine();

        IO.print("Sexo: ");
        String sexo = sc.nextLine();

        IO.print("Estado civil: ");
        String estadoCivil = sc.nextLine();

        IO.print("Profissão: ");
        String profissao = sc.nextLine();

        IO.print("Cargo: ");
        String cargo = sc.nextLine();

        IO.print("Salário base: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        IO.print("Usuário: ");
        String usuario = sc.nextLine();

        IO.print("Senha: ");
        String senha = sc.nextLine();

        Endereco endereco = lerEndereco();

        Funcionario f = new Funcionario(cpf, nome, email, sexo, estadoCivil, profissao,
                endereco, cargo, salario, usuario, senha, LocalDate.now());

        imobiliaria.adicionarFuncionario(f);

        IO.println("Funcionário cadastrado!");
    }

    public static Funcionario login(Imobiliaria imobiliaria, Scanner sc) {

        IO.println("=== LOGIN FUNCIONÁRIO ===");

        IO.print("Usuário: ");
        String usuario = sc.nextLine();

        IO.print("Senha: ");
        String senha = sc.nextLine();

        for (Funcionario f : imobiliaria.getFuncionarios()) {
            if (f.getUsuario().equals(usuario) && f.testarSenha(senha)) {
                IO.println("Login realizado!");
                return f;
            }
        }

        IO.println("Usuário ou senha inválidos!");
        return null;
    }


    private static void listarImoveis() {
        for (Imovel i : imobiliaria.listarImoveisDisponiveis()) {
            IO.println(i);
        }
    }

    private static void listarTransacoes() {
        for (Transacao t : imobiliaria.listarTransacoes()) {
            IO.println(t);
        }
    }


    private static void registrarVenda() {

        IO.print("ID do imóvel: ");
        int id = sc.nextInt();
        sc.nextLine();

        IO.print("CPF do cliente: ");
        String cpfCliente = sc.nextLine();

        IO.print("CPF do funcionário: ");
        String cpfFuncionario = sc.nextLine();

        IO.print("Valor final: ");
        double valor = sc.nextDouble();

        try {
            imobiliaria.registrarVenda(id, cpfCliente, cpfFuncionario, valor);
            IO.println("Venda realizada!");
        } catch (Exception e) {
            IO.println("Erro: " + e.getMessage());
        }
    }

    private static void registrarLocacao() {

        IO.print("ID do imóvel: ");
        int id = sc.nextInt();
        sc.nextLine();

        IO.print("CPF do cliente: ");
        String cpfCliente = sc.nextLine();

        IO.print("CPF do funcionário: ");
        String cpfFuncionario = sc.nextLine();

        IO.print("Valor final: ");
        double valor = sc.nextDouble();

        try {
            imobiliaria.registrarLocacao(id, cpfCliente, cpfFuncionario, valor);
            IO.println("Locação realizada!");
        } catch (Exception e) {
            IO.println("Erro: " + e.getMessage());
        }
    }

    private static Endereco lerEndereco() {

        IO.print("Rua: ");
        String rua = sc.nextLine();

        IO.print("Número: ");
        String numero = sc.nextLine();

        IO.print("Bairro: ");
        String bairro = sc.nextLine();

        IO.print("Cidade: ");
        String cidade = sc.nextLine();

        IO.print("Estado: ");
        String estado = sc.nextLine();

        return new Endereco(rua, numero, bairro, cidade, estado);
    }
}
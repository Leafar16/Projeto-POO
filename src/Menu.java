import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static int MenuInicial() {
        clearWindow();
        StringBuilder sb = new StringBuilder("-----------MENU INICIAL-----------\n\n");
        sb.append("1) Iniciar sessão.\n");
        sb.append("2) Registar novo utilizador.\n");
        sb.append("3) Registar nova atividade.\n");
        sb.append("4) Carregar logs.\n");
        sb.append("5) Guardar estado.\n");
        sb.append("6) Carregar estado.\n");
        sb.append("7) Estatísticas.\n");
        sb.append("0) Sair.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void clearWindow() {
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    public static int menuUtilizador(){
        StringBuilder sb = new StringBuilder("-----------MENU UTILIZADOR-----------\n\n");
        sb.append("1) Efetuar uma compra.\n");
        sb.append("2) Solicitar entrega de uma encomenda.\n");
        sb.append("3) Verificar ofertas de transportadora.\n");
        sb.append("4) Histórico de encomendas [Por entidade de transporte e período de tempo].\n");
        sb.append("5) Classificar voluntário ou transportadora.\n");
        sb.append("6) Número de encomendas transportadas.\n");
        sb.append("0) Logout.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int menuProfissional(){
        StringBuilder sb = new StringBuilder("-----------MENU PROFISSIONAL-----------\n\n");
        sb.append("1) Realizar atividade.\n");
        sb.append("2) Registar entrega de uma encomenda.\n");
        sb.append("3) Verificar classificação atual.\n");
        sb.append("4) Histórico de encomendas entregues.\n");
        sb.append("0) Logout.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int atInfo(Map<String, String> atInfo) {
        clearWindow();
        StringBuilder sb = new StringBuilder("-----------ATIVIDADES-----------\n\n");
        sb.append("Cod. Atividade ------ Nome da Atividade.\n");

        for (Map.Entry<String, String> entry : atInfo.entrySet()) {
            sb.append("  ").append(entry.getKey()).append("                ").append(entry.getValue()).append("\n");
        }

        sb.append("1) Escolher atividade a realizar;\n0) Retroceder;\nSelecione a opção pretendida: ");
        System.out.println(sb.toString());

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String menuAtData(int i){
        clearWindow();
        StringBuilder sb = new StringBuilder("-----------REALIZAR ATIVIDADE-----------\n\n");
        if (i == 1) sb.append("Digite um código de atividade:\n ");

        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String menuLogin(boolean errorMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append("------------INICIAR SESSAO---------").append("\n\n");
        if(errorMessage) sb.append("Erro - Dados inválidos! Tente novamente!\n\n");
        sb.append("Introduza o seu código de utilizador: ");

        System.out.print(sb.toString());

        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        return codigo;
    }


    public static TipoUtilizador menuRegisto() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------REGISTAR NOVA CONTA------------").append("\n");
        sb.append("Como se deseja registar?\n\n");
        sb.append("1) Profissional\n");
        sb.append("2) Amador\n");
        sb.append("3) Praticante Ocasional\n");
        sb.append("Introduza a opção pretendida: ");

        System.out.println(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int opção = scanner.nextInt();

        switch(opção) {
            case 1: return TipoUtilizador.Profissional;
            case 2: return TipoUtilizador.Amador;
            case 3: return TipoUtilizador.PratOcasional;
            default: return null;
        }
    }

    public static TipoAtividade menuTipoAtividade() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------REGISTAR ATIVIDADE------------").append("\n");
        sb.append("Que tipo de atividade pretende adicionar/registar?\n\n");
        sb.append("1) Altimetria e Distância\n");
        sb.append("2) Distância\n");
        sb.append("3) Repetições\n");
        sb.append("4) Repetições com pesos\n");
        sb.append("Introduza a opção pretendida: ");

        System.out.println(sb.toString());

        Scanner scanner = new Scanner(System.in);
        int opção = scanner.nextInt();

        switch(opção) {
            case 1: return TipoAtividade.DistAlt;
            case 2: return TipoAtividade.Dist;
            case 3: return TipoAtividade.Reps;
            case 4: return TipoAtividade.Pesos;
            default: return null;
        }
    }

    public static Atividade menuRegistoDistAlt(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR DISTALT---------\n\n");
        sb.append("Introduza o nome da atividade a inserir.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Código atribuido a atividade: " + codigo + "\n");

        return new DistAlt(codigo, nome);
    }

    public static Atividade menuSetDistAlt(String codigo, String nome) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR ATIVIDADE DISTALT---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Altitude (em metros): ");

        System.out.print(sb.toString());
        Double altitude  = scanner.nextDouble();

        System.out.print("Distância (em metros): ");
        Double dist = scanner.nextDouble();

        System.out.print("Tempo dispendido (em segundos): ");
        Double tempo = scanner.nextDouble();

        return new DistAlt(codigo, nome, altitude, dist, tempo);
    }

    public static Atividade menuRegistoDist(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR DIST---------\n\n");
        sb.append("Introduza o nome da atividade a inserir.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Código atribuido a atividade: " + codigo + "\n");

        return new Dist(codigo, nome);
    }

    public static Atividade menuSetDist(String codigo, String nome) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR ATIVIDADE DIST---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Distância (em metros): ");

        System.out.print(sb.toString());
        Double dist  = scanner.nextDouble();

        System.out.print("Tempo dispendido (em segundos): ");
        Double tempo = scanner.nextDouble();

        return new Dist(codigo, nome, dist, tempo);
    }

    public static Atividade menuRegistoReps(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR DISTALT---------\n\n");
        sb.append("Introduza o nome da atividade a inserir.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Código atribuido a atividade: " + codigo + "\n");

        return new Reps(codigo, nome);


    }

    public static Atividade menuSetReps(String codigo, String nome) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR ATIVIDADE DISTALT---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Número de séries: ");

        System.out.print(sb.toString());
        int series  = scanner.nextInt();

        System.out.print("Repetições: ");
        int reps = scanner.nextInt();

        System.out.print("Tempo dispendido (em segundos): ");
        Double tempo = scanner.nextDouble();

        return new Reps(codigo, nome, series, reps, tempo);

    }

    public static Atividade menuRegistoPesos(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR DISTALT---------\n\n");
        sb.append("Introduza o nome da atividade a inserir.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Código atribuido a atividade: " + codigo + "\n");

        return new Pesos(codigo, nome);


    }

    public static Atividade menuSetPesos(String codigo, String nome) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR ATIVIDADE DISTALT---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Número de séries: ");

        System.out.print(sb.toString());
        int series  = scanner.nextInt();

        System.out.print("Repetições: ");
        int reps = scanner.nextInt();

        System.out.print("Peso (em kg): ");
        Double peso = scanner.nextDouble();

        System.out.print("Tempo dispendido (em segundos): ");
        Double tempo = scanner.nextDouble();

        return new Pesos(codigo, nome, series, reps, peso, tempo);

    }

    public static Utilizador menuRegistoProfissional(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR PROFISSIONAL---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Endereço de e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Frequência Cardíaca média: ");
        int freqcardiaca = scanner.nextInt();

        System.out.print("Altura (em cm): ");
        int altura = scanner.nextInt();

        System.out.print("Peso: ");
        int peso = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Modalidade que pratica: ");
        String modalidade = scanner.nextLine();

        System.out.print("Codigo atribuido a sua conta: " + codigo + "\n");

        return new Profissional(codigo, nome, morada , email, freqcardiaca, altura, peso, modalidade);
    }

    // temporario

    public static Utilizador menuRegistoAmador(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR PROFISSIONAL---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Endereço de e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Frequência Cardíaca média: ");
        int fcardiaca = scanner.nextInt();

        System.out.print("Altura (em cm): ");
        int altura = scanner.nextInt();

        System.out.print("Peso: ");
        int peso = scanner.nextInt();

        System.out.print("Frequência Cardíaca média: ");
        int freqcardiaca = scanner.nextInt();

        System.out.print("Modalidade que pratica: ");
        String modalidade = scanner.nextLine();

        System.out.print("Codigo atribuido a sua conta: " + codigo + "\n");

        return new Profissional(codigo, nome, morada , email, freqcardiaca, altura, peso, modalidade);
    }

    public static Utilizador menuRegistoPratOcasional(String codigo) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("------------REGISTAR PROFISSIONAL---------\n\n");
        sb.append("Introduza os dados a seguir pedidos.\n\n");
        sb.append("Nome: ");

        System.out.print(sb.toString());
        String nome = scanner.nextLine();

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Endereço de e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Frequência Cardíaca média: ");
        int freqcardiaca = scanner.nextInt();

        System.out.print("Altura (em cm): ");
        int altura = scanner.nextInt();

        System.out.print("Peso: ");
        int peso = scanner.nextInt();

        System.out.print("Modalidade que pratica: ");
        String modalidade = scanner.nextLine();

        System.out.print("Código atribuido a sua conta: " + codigo + "\n");

        return new Profissional(codigo, nome, morada , email, freqcardiaca, altura, peso, modalidade);
    }

    public static void errors (int i){
        StringBuilder sb = new StringBuilder();
        if (i == 1) sb.append("****Ficheiro não encontrado***").append("\n");
        else if (i == 2) sb.append("****Não foi possivel guardar o Estado****").append("\n");
        else if (i == 3) sb.append("****Erro ao ler para as estruturas de dados****").append("\n");
        else if (i == 4) sb.append("****Código inválido****").append("\n");
        else if (i == 5) sb.append("****Datas inválidas****").append("\n");
        else if (i == 6) sb.append("****Não foi possivel carregar o Estado****").append("\n");
        else if (i == 7) sb.append("****Entidade indisponível****").append("\n");
        else if (i == 8) sb.append("****Não existe encomenda a transportar****").append("\n");
        else if (i == 9) sb.append("****A encomenda não foi solicitada****").append("\n");
        else if (i == 10) sb.append("****Não existem encomendas a entregar pela transportadora em questão****").append("\n");
        else if (i == 11) sb.append("****Não existem encomendas para solicitar****").append("\n");
        else if (i == 12) sb.append("****Não existem encomendas para entregar pela entidade****").append("\n");
        else if (i == 13) sb.append("****A entidade não pode transportar a encomenda selecionada****").append("\n");
        else if (i == 14) sb.append("****Não existem encomendas dentro dos requisitos obrigatórios****").append("\n");
        else if (i == 15) sb.append("****Nenhuma transportadora pediu para transportar encomendas suas****").append("\n");
        else if (i == 16) sb.append("****Credenciais inválidas!****").append("\n");
        else if (i == 17) sb.append("****Encomenda não se encontra na loja!****").append("\n");
        else if (i == 18) sb.append("****\nEmail já existente!****").append("\n");
        sb.append("\nPressione enter para continuar...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearWindow();
    }



}

public class ControllerUtilizador {
    public static void run(TrazAqui trazAqui){
        boolean exit = false;
        while(!exit){
            int opcao = -1;
            while(opcao < 0 || opcao > 4) {
                opcao = Menu.menuUtilizador();
            }
            switch(opcao) {
                case 1:
                    String tipoAtividade = null;
                    while (tipoAtividade == null) tipoAtividade = Menu.menuTipoAtividade();

                    Atividade atividade;

                    atividade = Menu.menuRegistoAtividade(trazAqui.getNewCodeAt(), tipoAtividade);
                    Atividade add = trazAqui.addAtividadeUtilizador(atividade);
                    trazAqui.registoAtividade(add);

                    String atividadeString = add.toString();
                    System.out.println("Atividade adicionada: \n");
                    System.out.println(atividadeString);

                    break;

                case 2:
                    String atividades;

                    atividades = trazAqui.getUserAtividades();

                    System.out.println(atividades);

                    break;

                case 3:

                    System.out.println("Frequência cardíaca: \n");
                    System.out.println(trazAqui.getFCUser());

                    break;

                case 4:

                    break;
                case 0:
                    exit = true;
                    Menu.clearWindow();
                    break;
            }
        }
    }
}

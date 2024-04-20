import java.util.Map;

public class ControllerProfissional {
    public static void run(TrazAqui trazAqui){
        boolean exit = false;
        while(!exit){
            int opcao = -1;
            while(opcao < 0 || opcao > 4) {
                opcao = Menu.menuProfissional();
            }
            switch(opcao) {
                case 1:
                    TipoAtividade tipoAtividade = null;
                    while (tipoAtividade == null) tipoAtividade = Menu.menuTipoAtividade();

                    int op2 = -1;
                    Map<String,String> at = trazAqui.AtInfo(tipoAtividade);
                    if (!at.isEmpty()) {
                        while (op2 != 1 && op2 != 0) op2 =Menu.atInfo(at);

                        if (op2 == 1) {
                            String codAt = Menu.menuAtData(1);
                            if (trazAqui.isValidCodeAt(codAt,tipoAtividade)) {
                                Atividade trazAtividade = trazAqui.AtAdd(codAt,tipoAtividade);
                                Atividade add = trazAqui.addAtividadePro(trazAtividade, tipoAtividade);
                                String atividadeString = add.toString();
                                System.out.println("Atividade adicionada: \n");
                                System.out.println(atividadeString);
                            } else Menu.errors(9);
                        } else Menu.errors(4);
                    } else Menu.errors(12);
                    break;

                case 2:

                    break;

                case 3:

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

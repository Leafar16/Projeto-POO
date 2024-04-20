import java.util.AbstractMap;

public class Controller {
    public static void run() {
        TrazAqui trazAqui = new TrazAqui();

        boolean errorMessage = false;
        while(true){
            int opcao = -1;
            while(opcao < 0 || opcao > 7) {
                opcao = Menu.MenuInicial();
            }

            switch(opcao) {

                case 1:
                    String codigo = Menu.menuLogin(errorMessage);
                    if(!trazAqui.login(codigo)) Menu.errors(16);
                    else{
                        Menu.clearWindow();
                        TipoUtilizador tc = trazAqui.getTipoConta();
                        if (tc.equals(TipoUtilizador.Profissional)) ControllerProfissional.run(trazAqui);
                        else if (tc.equals(TipoUtilizador.Amador)) ControllerAmador.run(trazAqui);
                        else ControllerPratOcasional.run(trazAqui);
                    }
                    break;

                case 2:

                    TipoUtilizador tipoUtilizador = null;
                    while (tipoUtilizador == null) tipoUtilizador = Menu.menuRegisto();

                    Utilizador utilizador;

                    if (tipoUtilizador.equals(TipoUtilizador.Profissional)) utilizador = Menu.menuRegistoProfissional(trazAqui.getNewCodeUser(TipoUtilizador.Profissional));
                    else if (tipoUtilizador.equals(TipoUtilizador.Amador)) utilizador = Menu.menuRegistoAmador(trazAqui.getNewCodeUser(TipoUtilizador.Amador));
                    else utilizador = Menu.menuRegistoPratOcasional(trazAqui.getNewCodeUser(TipoUtilizador.PratOcasional));

                    if (!trazAqui.freeEmail(utilizador.getEmail())) Menu.errors(18);

                    else{
                        trazAqui.registoUser(utilizador);

                        System.out.println("Utilizador registered successfully:");
                        System.out.println(utilizador);

                        if (tipoUtilizador.equals(TipoUtilizador.Profissional)) ControllerProfissional.run(trazAqui);
                        else if (tipoUtilizador.equals(TipoUtilizador.Amador)) ControllerAmador.run(trazAqui);
                        else ControllerPratOcasional.run(trazAqui);
                    }

                    break;

                case 3:

                    TipoAtividade tipoAtividade = null;
                    while (tipoAtividade == null) tipoAtividade = Menu.menuTipoAtividade();

                    Atividade atividade;

                    if (tipoAtividade.equals(TipoAtividade.DistAlt)) atividade = Menu.menuRegistoDistAlt(trazAqui.getNewCodeAt(TipoAtividade.DistAlt));
                    else if (tipoAtividade.equals(TipoAtividade.Dist)) atividade = Menu.menuRegistoDist(trazAqui.getNewCodeAt(TipoAtividade.Dist));
                    else if (tipoAtividade.equals(TipoAtividade.Reps)) atividade = Menu.menuRegistoReps(trazAqui.getNewCodeAt(TipoAtividade.Reps));
                    else atividade = Menu.menuRegistoPesos(trazAqui.getNewCodeAt(TipoAtividade.Pesos));

                    trazAqui.registoAtividade(atividade);
                    break;

                case 4:
                    System.exit(0);
                    break;

                case 5:
                    System.exit(0);
                    break;

                case 6:
                    System.exit(0);
                    break;

                case 7:
                    System.exit(0);
                    break;

                case 0:
                    System.exit(0);
                    break;

            }
        }
    }
}
import java.io.FileNotFoundException;
import java.io.IOException;

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
                        ControllerUtilizador.run(trazAqui);
                    }
                    break;

                case 2:

                    String tipoUtilizador = null;
                    while (tipoUtilizador == null) tipoUtilizador = Menu.menuTipoUtilizador();

                    Utilizador utilizador;

                    utilizador = Menu.menuRegistoUtilizador(trazAqui.getNewCodeUser(tipoUtilizador), tipoUtilizador);

                    if (!trazAqui.freeEmail(utilizador.getEmail())) Menu.errors(18);

                    else{

                        trazAqui.registoUser(utilizador);

                        System.out.println("Utilizador registered successfully:");
                        System.out.println(utilizador);

                        ControllerUtilizador.run(trazAqui);
                    }

                    break;

                case 3:
                    /*
                    TipoAtividade tipoAtividade = null;
                    while (tipoAtividade == null) tipoAtividade = Menu.menuTipoAtividade();

                    Atividade atividade;

                    if (tipoAtividade.equals(TipoAtividade.DistAlt)) atividade = Menu.menuRegistoDistAlt(trazAqui.getNewCodeAt(TipoAtividade.DistAlt));
                    else if (tipoAtividade.equals(TipoAtividade.Dist)) atividade = Menu.menuRegistoDist(trazAqui.getNewCodeAt(TipoAtividade.Dist));
                    else if (tipoAtividade.equals(TipoAtividade.Reps)) atividade = Menu.menuRegistoReps(trazAqui.getNewCodeAt(TipoAtividade.Reps));
                    else atividade = Menu.menuRegistoPesos(trazAqui.getNewCodeAt(TipoAtividade.Pesos));

                    trazAqui.registoAtividade(atividade);
                     */
                    break;

                case 4:
                    try {
                        trazAqui.guardaEstadoObj("Estado.obj");
                        System.out.println("Estado guardado com sucesso.\n");
                    } catch (FileNotFoundException e) {
                        System.out.println("*Ficheiro não encontrado.*\n");
                    } catch (IOException e) {
                        System.out.println("*Não foi possível guardar o estado*\n");
                    }
                    Menu.pressEnter();
                    break;

                case 5:
                    try {
                        trazAqui.carregaEstadoObj("Estado.obj");
                        System.out.println("Estado carregado com sucesso.\n");
                    } catch (FileNotFoundException e) {
                        System.out.println("*Ficheiro não encontrado.*\n");
                    } catch (IOException e) {
                        System.out.println("*Não foi possível carregar o estado.*\n");
                    } catch (ClassNotFoundException e) {
                        System.out.println("*Erro ao carregar os objetos para a estrutura de dados*\n");
                    }
                    Menu.pressEnter();
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
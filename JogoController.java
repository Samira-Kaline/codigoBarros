package refatoracao;

import java.util.Scanner;

public class JogoController{

    private final Scanner s = new Scanner(System.in);
    private final Exception e = new Exception();

    public void inicarJogo(Jogador jogador1,Jogador jogador2){
      Jogo jogo = new Jogo(jogador1,jogador2);
      jogo.jogar();
    }
    
    public Campo criarCampo(){
        Campo campo = new Campo();
        int i = 0;
        
        while (i<=6) {
            String tipo = null,linha = null;
            int coluna = -1;
            
            campo.printCampo();
            
            if(campo.cheio()){
                    System.out.println("Já foram adcionados todos os navios");
                    break;
                }
            
            while (true){
                System.out.println("Digite o tipo de navio que deseja adicionar: ");
                tipo = s.next();
                
                if(this.e.verificarNavios(tipo)){
                    break;  
                }
                System.out.println("Tipo invalido!");
                System.out.println("Valido somente: submarino, cruzador ou porta-avioes");
            }
            
            
            while (true){
                
                System.out.println("Digite a posicao da linha que deseja adicionar: ");
                System.out.println("Letra de A a H: ");
                linha = s.next();
                
                if(this.e.verificarLinha(linha)){
                    break;  
                }
                System.out.println("Intervalo invalido!");
            }
            
            while (true){
                
                System.out.println("Digite a posicao da coluna que deseja adicionar: ");
                System.out.println("Numero de 1 a 8: ");
                coluna =s.nextInt();
                
                if(this.e.verificarColuna(coluna)){
                    break;  
                }
                System.out.println("Intervalo invalido!");
            }

            int linhac;
            linhac = e.converter(linha);

            campo.adicionarArma(tipo, linhac-1, coluna-1);
            if (!campo.cheio()){
                i++;
            }
        }
        campo.printCampo();
        return campo;
    }
    
    public Jogador criarJogador(){
        String nome;
        while (true){
            System.out.println("Digite o nome do jogador: ");
            nome = s.next();
            
            if(this.e.verificarNome(nome)){
                break;
            }
            else{
                System.out.println("Digite o nome apenas com letras: ");
            }
        }
        Campo campo = this.criarCampo();
        Jogador jogador = new Jogador(nome,campo);
        return jogador;
    }

    public void printMenu(){
      System.out.println("--------------------------MENU--------------------------");
      System.out.println("|  Digite 1 para criar um jogador:                      |");
      System.out.println("|  Digite 2 para jogar:                                |");
      System.out.println("|  Digite 3 para sair                                  |");
      System.out.println("--------------------------------------------------------");
  }
}
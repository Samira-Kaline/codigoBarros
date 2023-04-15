package refatoracao;

import java.util.Scanner;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private final Scanner s = new Scanner(System.in);
    private final Exception e = new Exception();

    public Jogo(Jogador jogador1,Jogador jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public void jogar() {
        int rodadas = 1;
        while (true){
            
            System.out.println("Rodada " + rodadas);
            
            System.out.println("É a vez de " + this.jogador1.getNome());
            String linha ;
            int coluna;
            this.jogador1.getCampoinimigo().printCampo();
            for(int i=0;i<2;i++){
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
                
                int linhac = e.converter(linha);
                this.jogador1.registrarTiro(linhac-1, coluna-1,this.jogador2.getMeucampo());
                this.jogador1.getCampoinimigo().printCampo();
                
            }
            
            if (this.jogador1.venceu() ){
                
                System.out.println("O Vencedor foi: " + this.jogador1.getNome());
                break;
                
            }
            // Jogada do jogador 2
            
            System.out.println("É a vez de " + this.jogador2.getNome());
            
            this.jogador2.getCampoinimigo().printCampo();
            for(int i=0;i<2;i++){
                
                while (true){
                
                System.out.println("Digite a posicao da linha que deseja adicionar: ");
                System.out.println("Letra de A a H: ");
                linha = s.next();
                
                if(e.verificarLinha(linha)){
                    break;  
                }
                System.out.println("Intervalo invalido!");
            }
            
            while (true){
                
                System.out.println("Digite a posicao da coluna que deseja adicionar: ");
                System.out.println("Numero de 1 a 8: ");
                coluna =s.nextInt();
                
                if(e.verificarColuna(coluna)){
                    break;  
                }
                System.out.println("Intervalo invalido!");
            }

                int linhac = e.converter(linha);
                this.jogador2.registrarTiro(linhac-1, coluna-1,this.jogador1.getMeucampo());
                this.jogador2.getCampoinimigo().printCampo();
            }
            
            if (this.jogador2.venceu() ){
                
                System.out.println("O Vencedor foi: " + this.jogador2.getNome());
                break;     
                
            }
            rodadas++;
        }
        
    }
    
}
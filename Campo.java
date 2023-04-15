package refatoracao;

public class Campo {
    private final  char[][] campo;
    private int quantSub = 3;
    private int quantCruz = 2;
    private int quantPa = 1;
    private final String[] linhas;
    private final Exception e = new Exception();
    Armas navio = new Submarino();

    public Campo(){
        this.campo = new char[8][8];
        this.linhas = new String[8];
        for (char[] campo1 : campo) {
            for (int j = 0; j < campo1.length; j++) {
                campo1[j] = ' ';
            }
        }
    }
    
    public char[][] getCampo(){
        return campo;
    }
    
    public char getPosicao(int linha,int coluna){
        return campo[linha][coluna];
    }
    
    public boolean cheio(){
        return (this.quantCruz+this.quantPa+this.quantSub) ==0;
    }
    
    public void setPosicao(int linha,int coluna,char valor){
        this.campo[linha][coluna] = valor;
    }
    
    public void adicionarArma(String tipo, int linha, int coluna) {
        Armas navio;
        switch (tipo) {
            case "submarino":
                if (quantSub <= 0) {
                    System.out.println("Já foram adicionados todos os submarinos");
                    return;
                }
                navio = new Submarino();
                break;
            case "cruzador":
                if (quantCruz <= 0) {
                    System.out.println("Já foram adicionados todos os cruzadores");
                    return;
                }
                navio = new Cruzador();
                break;
            case "porta-avioes":
                if (quantPa <= 0) {
                    System.out.println("Já foram adicionados todos os porta-aviões");
                    return;
                }
                navio = new PortaAvioes();
                break;
            default:
                System.out.println("Tipo de navio inválido");
                return;
        }
        if (navio.posicionar(campo, linha, coluna)) {
            switch (tipo) {
                case "submarino":
                    quantSub--;
                    break;
                case "cruzador":
                    quantCruz--;
                    break;
                case "porta-avioes":
                    quantPa--;
                    break;
            }
        } else {
            System.out.println("Não pode adicionar navio");
        }
    }
    
    public void printCampo(){
        System.out.println("==========================================");
        System.out.println("               Batalha Naval              ");
        System.out.println("==========================================\n");
        System.out.println("    1   2   3   4   5   6   7   8  ");
        for (int i=0;i<campo.length;i++){
            System.out.print(" "+ e.getLinha(i) +" ");
            for(int j=0;j<campo[i].length;j++){
                if(campo[i][j]!=' ' ){
                    System.out.print("|"+ campo[i][j] + "| ");
                }
                else{
                    System.out.print("| | ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("");  
        
    }

    @Override
    public String toString() {
        
        
        return "Campo{" + '}';
    }
    
    
}
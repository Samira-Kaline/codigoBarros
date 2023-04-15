package refatoracao;

public class Submarino implements Armas {
    private static int quantidadeNavios = 3;

    @Override
    public boolean posicionar(char[][] campo, int linha, int coluna) {
        if (quantidadeNavios > 0) {
            if (linha >= 0 && linha < campo.length && coluna >= 0 && coluna < campo[0].length) {
                if (campo[linha][coluna] == ' ') {
                    campo[linha][coluna] = 's';
                    // quantidadeNavios--;
                    return true;
                }
            }
        }
        return false;
    }
}

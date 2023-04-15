package refatoracao;

public class Cruzador implements Armas {
    private static int quantidadeNavios = 2;

    @Override
    public boolean posicionar(char[][] campo, int linha, int coluna) {
        if (quantidadeNavios <= 0) {
            return false;
        }
        if (linha < 0 || linha >= campo.length || coluna < 0 || coluna + 1 >= campo[0].length) {
            return false;
        }
        if (campo[linha][coluna] != ' ' || campo[linha][coluna + 1] != ' ') {
            return false;
        }
        campo[linha][coluna] = 'c';
        campo[linha][coluna + 1] = 'c';
        // quantidadeNavios--;
        return true;
    }
}

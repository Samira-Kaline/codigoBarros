package refatoracao;

public class PortaAvioes implements Armas {
    private static int quantidadeNavios = 1;

    @Override
    public boolean posicionar(char[][] campo, int linha, int coluna) {
        if (quantidadeNavios > 0) {
            if (linha >= 0 && linha < campo.length && coluna >= 0 && coluna + 4 < campo[0].length) {
                boolean posicaoValida = true;
                for (int i = coluna; i <= coluna + 4; i++) {
                    if (campo[linha][i] != ' ') {
                        posicaoValida = false;
                        break;
                    }
                }
                if (posicaoValida) {
                    for (int i = coluna; i <= coluna + 4; i++) {
                        campo[linha][i] = 'p';
                    }
                    // quantidadeNavios--;
                    return true;
                }
            }
        }
        return false;
    }
}

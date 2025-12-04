package trabalho_ed;

import java.util.ArrayList;
import java.util.List;

public class MapaVetor<K extends Comparable<K>, V> implements Mapa<K, V> {

    private class Par {
        K chave;
        V valor;
        public Par(K c, V v) { this.chave = c; this.valor = v; }
    }

    private List<Par> vetor;

    public MapaVetor() {
        this.vetor = new ArrayList<>();
    }

    @Override
    public void inserir(K chave, V valor) {
        // COMPLEXIDADE: O(n) - Linear
        // Precisa varrer o vetor para ver se a chave já existe.
        for (Par p : vetor) {
            if (p.chave.equals(chave)) {
                p.valor = valor; // Atualiza
                return;
            }
        }
        vetor.add(new Par(chave, valor));
    }

    @Override
    public V buscar(K chave) {
        // COMPLEXIDADE: O(n) - Linear
        // Percorre um por um até achar (ou não).
        for (Par p : vetor) {
            if (p.chave.equals(chave)) {
                return p.valor;
            }
        }
        return null;
    }

    @Override
    public int tamanho() {
        return vetor.size();
    }
}
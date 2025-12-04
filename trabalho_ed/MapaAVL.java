package trabalho_ed;

public class MapaAVL<K extends Comparable<K>, V> implements Mapa<K, V> {

    private class No {
        K chave;
        V valor;
        int altura;
        No esq, dir;

        No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
            this.altura = 1;
        }
    }

    private No raiz;
    private int tamanho = 0;

    // --- Métodos Auxiliares da AVL ---
    private int altura(No n) { return n == null ? 0 : n.altura; }
    
    private int getFator(No n) { return n == null ? 0 : altura(n.esq) - altura(n.dir); }

    // Rotação à Direita (Corrige peso na esquerda)
    private No rotacaoDireita(No y) {
        No x = y.esq;
        No T2 = x.dir;
        
        x.dir = y;
        y.esq = T2;
        
        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;
        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;
        
        return x;
    }

    // Rotação à Esquerda (Corrige peso na direita)
    private No rotacaoEsquerda(No x) {
        No y = x.dir;
        No T2 = y.esq;
        
        y.esq = x;
        x.dir = T2;
        
        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;
        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;
        
        return y;
    }

    @Override
    public void inserir(K chave, V valor) {
        // COMPLEXIDADE: O(log n) - Logarítmica
        raiz = inserirRec(raiz, chave, valor);
    }

    private No inserirRec(No no, K chave, V valor) {
        if (no == null) {
            tamanho++;
            return new No(chave, valor);
        }

        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) no.esq = inserirRec(no.esq, chave, valor);
        else if (cmp > 0) no.dir = inserirRec(no.dir, chave, valor);
        else { no.valor = valor; return no; } // Atualiza valor

        // Atualiza altura e balanceia
        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
        int balance = getFator(no);

        // Casos de Rotação
        if (balance > 1 && chave.compareTo(no.esq.chave) < 0) return rotacaoDireita(no);
        if (balance < -1 && chave.compareTo(no.dir.chave) > 0) return rotacaoEsquerda(no);
        if (balance > 1 && chave.compareTo(no.esq.chave) > 0) {
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }
        if (balance < -1 && chave.compareTo(no.dir.chave) < 0) {
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }
        return no;
    }

    @Override
    public V buscar(K chave) {
        // COMPLEXIDADE: O(log n) - Logarítmica
        return buscarRec(raiz, chave);
    }

    private V buscarRec(No no, K chave) {
        if (no == null) return null;
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) return buscarRec(no.esq, chave);
        else if (cmp > 0) return buscarRec(no.dir, chave);
        else return no.valor;
    }

    @Override
    public int tamanho() { return tamanho; }
}
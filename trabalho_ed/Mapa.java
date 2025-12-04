package trabalho_ed;

// K extends Comparable<K> obriga a chave a ser comparável (para a árvore saber o que é maior/menor)
public interface Mapa<K extends Comparable<K>, V> {
    
    // Insere um par chave/valor. Se a chave já existir, atualiza o valor.
    void inserir(K chave, V valor);
    
    // Busca o valor associado à chave. Retorna null se não encontrar.
    V buscar(K chave);
    
    // Retorna a quantidade de itens no mapa.
    int tamanho();
}
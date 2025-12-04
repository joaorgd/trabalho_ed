package trabalho_ed;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== APRESENTACAO AO VIVO: MAPA (VETOR vs AVL) ===\n");

        // Teste 1: Vetor
        System.out.println("--- TESTE 1: Mapa Baseado em VETOR ---");
        Mapa<String, String> mapaVetor = new MapaVetor<>();
        executarTeste(mapaVetor);

        System.out.println("\n--------------------------------------\n");

        // Teste 2: AVL
        System.out.println("--- TESTE 2: Mapa Baseado em ARVORE AVL ---");
        Mapa<String, String> mapaAVL = new MapaAVL<>();
        executarTeste(mapaAVL);
    }

    // Método auxiliar para rodar os mesmos testes em qualquer implementação
    public static void executarTeste(Mapa<String, String> mapa) {
        long inicio = System.nanoTime();

        // 1. Inserção
        mapa.inserir("M", "Mamba Mentality");
        mapa.inserir("J", "Java");
        mapa.inserir("E", "Estrutura de Dados");
        mapa.inserir("Z", "Zelda"); // Forçando final do alfabeto
        
        // 2. Atualização (Colisão de chave)
        mapa.inserir("J", "Java Spring Boot"); // Atualizando valor

        // 3. Resultados
        System.out.println("Tamanho do mapa: " + mapa.tamanho());
        System.out.println("Busca 'M': " + mapa.buscar("M"));
        System.out.println("Busca 'J': " + mapa.buscar("J"));
        System.out.println("Busca 'X' (Inexistente): " + mapa.buscar("X"));

        long fim = System.nanoTime();
        System.out.println("Tempo de execucao (nanosegundos): " + (fim - inicio));
    }
}
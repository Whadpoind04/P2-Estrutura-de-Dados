
@SuppressWarnings("unchecked")
public class NossoHash<K, V> {

    private static final int CAPACIDADE_INICIAL = 16;

    private Entrada<K, V>[] tabela;
    private int capacidade;
    private int tamanho;     

    public NossoHash() {
        capacidade = CAPACIDADE_INICIAL;
        tabela     = new Entrada[capacidade];
        tamanho    = 0;
    }
  
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacidade;
    }

   
    public void put(K key, V value) {
        int pos = hash(key);
        Entrada<K, V> nova = new Entrada<>(key, value);
        nova.proximo = tabela[pos];  
        tabela[pos]  = nova;
        tamanho++;
    }

    public V get(K key) {
        int pos = hash(key);
        Entrada<K, V> atual = tabela[pos];
        while (atual != null) {
            if (atual.key.equals(key)) return atual.value;
            atual = atual.proximo;
        }
        return null;
    }

    
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    
    public boolean containsValue(V value) {
        for (int i = 0; i < capacidade; i++) {
            Entrada<K, V> atual = tabela[i];
            while (atual != null) {
                if (atual.value.equals(value)) return true;
                atual = atual.proximo;
            }
        }
        return false;
    }

    
    public void exibeMap() {
        System.out.println("=== NossoHash (capacidade=" + capacidade +
                           ", entradas=" + tamanho + ") ===");
        for (int i = 0; i < capacidade; i++) {
            System.out.printf("  [%02d] ", i);
            if (tabela[i] == null) {
                System.out.println("(vazio)");
            } else {
                Entrada<K, V> atual = tabela[i];
                StringBuilder sb = new StringBuilder();
                while (atual != null) {
                    sb.append(atual);
                    if (atual.proximo != null) sb.append(" -> ");
                    atual = atual.proximo;
                }
                System.out.println(sb);
            }
        }
        System.out.println("==========================================");
    }

    public int tamanho()    { return tamanho; }
    public int capacidade() { return capacidade; }
}

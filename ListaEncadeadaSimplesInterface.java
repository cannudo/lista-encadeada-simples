public interface LinkedListInterface {

    void append(Nodo dado); /* insere um elemento no final da lista */

    void insert(int index, Nodo dado); /* insere um elemento na posição especificada por index */

    void remove(int index); /* remove um elemento na posição especificada por index */

    int size(); /* @return int: tamanho da lista */

    boolean isEmpty(); /* @return boolean: a lista está vazia? */

    Nodo get(int index); /* @return Nodo: objeto Nodo na posição especificada por index */

    boolean contains(Nodo data); /* @return boolean: o nodo T existe dentro da lista? */

    String toString(); /* @return String: representação textual da lista */

    void clear(); /* remove todos os elementos da lista */

}
public interface LinkedListInterface<TipoGenerico> {

    void append(TipoGenerico dado); /* insere um elemento no final da lista */

    void insert(int index, TipoGenerico dado); /* insere um elemento na posição especificada por index */

    void remove(int index); /* remove um elemento na posição especificada por index */

    int size(); /* @return int: tamanho da lista */

    boolean isEmpty(); /* @return boolean: a lista está vazia? */

    TipoGenerico get(int index); /* @return TipoGenerico: objeto Nodo na posição especificada por index */

    boolean contains(TipoGenerico data); /* @return boolean: o nodo data existe dentro da lista? */

    String toString(); /* @return String: representação textual da lista */

    void clear(); /* remove todos os elementos da lista */

}
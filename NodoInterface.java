public interface NodoInterface<TipoGenerico> {

    TipoGenerico getData(); /* @return TipoGenerico: objeto armazenado no nodo */ 

    void setData(TipoGenerico data); /* define o objeto armazenado no nodo */

    Nodo<TipoGenerico> obterProximoNodo(); /* @return NodeInterface<TipoGenerico>: referência para o próximo nó na lista */

    void setProximoNodo(Nodo<TipoGenerico> proximoNodo); /* define a referência para o próximo nó na lista */
}

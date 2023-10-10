public class Nodo<TipoGenerico> implements NodoInterface<TipoGenerico> {
    private TipoGenerico dado;
    private Nodo<TipoGenerico> proximoNodo;

    public Nodo(TipoGenerico dado) {
        this.dado = dado;
        this.proximoNodo = null;
    }

    public TipoGenerico obterDado() {
        return dado;
    }

    public void setData(TipoGenerico dado) {
        this.dado = dado;
    }

    public Nodo<TipoGenerico> obterProximoNodo() {
        return proximoNodo;
    }

    public void setProximoNodo(Nodo<TipoGenerico> proximoNodo) {
        this.proximoNodo = proximoNodo;
    }

}
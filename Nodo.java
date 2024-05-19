public class Nodo<TipoGenerico> {
    private TipoGenerico dado;
    private Nodo<TipoGenerico> proximoNodo;

    public Nodo(TipoGenerico dado) {
        this.dado = dado;
        this.proximoNodo = null;
    }

    public TipoGenerico getDado() {
        return dado;
    }

    public void setDado(TipoGenerico dado) {
        this.dado = dado;
    }

    public Nodo<TipoGenerico> getProximoNodo() {
        return proximoNodo;
    }

    public void setProximoNodo(Nodo<TipoGenerico> proximoNodo) {
        this.proximoNodo = proximoNodo;
    }

    public String toString() {
        StringBuilder fragmento = new StringBuilder();
        fragmento.append("<< ");
        fragmento.append(this.dado);
        fragmento.append(" >>");
        return fragmento.toString();
        }
}
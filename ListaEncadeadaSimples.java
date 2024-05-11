public class ListaEncadeadaSimples<TipoGenerico> {
    private Nodo<TipoGenerico> cabeca;
    private int tamanho;

    public ListaEncadeadaSimples() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public ListaEncadeadaSimples(Nodo<TipoGenerico> primeiroNodo) {
        this.cabeca = primeiroNodo;
        this.tamanho = 1;
    }

    public Nodo<TipoGenerico> getCabeca() {
        return this.cabeca;
    }

    public void adicionarNovoNodo(Nodo<TipoGenerico> novoNodo) {
        
    }
}
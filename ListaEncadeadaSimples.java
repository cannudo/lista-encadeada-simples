public class ListaEncadeadaSimples<TipoGenerico> {
    private Nodo<TipoGenerico> cabeca;
    private Nodo<TipoGenerico> cauda;
    private int tamanho;

    public ListaEncadeadaSimples() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public ListaEncadeadaSimples(Nodo<TipoGenerico> primeiroNodo) {
        this.cabeca = primeiroNodo;
        this.cauda = primeiroNodo;
        this.tamanho = 1;
    }

    public Nodo<TipoGenerico> getCabeca() {
        return this.cabeca;
    }

    public Nodo<TipoGenerico> getCauda() {
        return this.cauda;
    }

    public void setCauda(Nodo<TipoGenerico> nodo) {
        this.cauda = nodo;
    }

    public void setCabeca(Nodo<TipoGenerico> nodo) {
        this.cabeca = nodo;
    }

    public void incrementarTamanho() {
        this.tamanho++;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public void adicionarNovoNodo(TipoGenerico dado) {
        Nodo<TipoGenerico> novoNodo = new Nodo<TipoGenerico>(dado);
        if(this.estaVazia()) {
            this.setCabeca(novoNodo);
            this.setCauda(novoNodo);
        } else {
            this.cauda.setProximoNodo(novoNodo);
            this.setCauda(novoNodo);
        }
        this.incrementarTamanho();
    }
}
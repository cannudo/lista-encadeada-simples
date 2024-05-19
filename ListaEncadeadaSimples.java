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

    public void limparLista() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void setCauda(Nodo<TipoGenerico> nodo) {
        boolean pode = this.esteNodoPodeSerCauda(nodo);
        if(pode) {
            this.cauda = nodo;
        } else {
            throw new EsteNodoNaoPodeSerCaudaException("setCauda(): `this.getProximoNodo()` deve ser null!");
        }
    }

    public void setCabeca(Nodo<TipoGenerico> nodo) {
        this.cabeca = nodo;
    }

    public void incrementarTamanho() {
        this.tamanho++;
    }

    public void decrementarTamanho() {
        this.tamanho--;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public boolean esteNodoPodeSerCauda(Nodo<TipoGenerico> nodo) {
        return nodo.getProximoNodo() == null;
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

    public void adicionarNovoNodo(Nodo<TipoGenerico> novoNodo) {
        if(this.estaVazia()) {
            boolean pode = this.esteNodoPodeSerCauda(novoNodo);

            if(pode) {
            this.setCabeca(novoNodo);
            this.setCauda(novoNodo);
            } else {
                throw new EsteNodoNaoPodeSerCaudaException("adicionarNovoNodo(): `this.getProximoNodo()` deve ser null!");
            }
        } else {
            this.cauda.setProximoNodo(novoNodo);
            this.setCauda(novoNodo);
        }
        this.incrementarTamanho();
    }

    public Nodo<TipoGenerico> buscarCauda() {
        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        while(nodoAtual.getProximoNodo() != null) {
            nodoAtual = nodoAtual.getProximoNodo();
        }
        return nodoAtual;
    }

    public void removerCauda() {
        if(this.estaVazia()) {
            throw new ListaVaziaException("removerCauda(): a lista está vazia!");
        } else {
            boolean aListaPossuiApenasUmNodo = this.tamanho == 1;
            if(aListaPossuiApenasUmNodo) {
                this.limparLista();
            } else {
                Nodo<TipoGenerico> nodoAtual = this.cabeca;
                while(nodoAtual.getProximoNodo() != this.cauda) {
                    nodoAtual = nodoAtual.getProximoNodo();
                }
                nodoAtual.setProximoNodo(null);
                this.setCauda(nodoAtual);
            }
            
        }
    }

    public void status() {
        System.out.println("--- início do estado atual da lista ---\n");

        System.out.println("this.cabeca: " + this.cabeca);
        System.out.println("this.cauda: " + this.cauda);
        System.out.println("this.tamanho: " + this.tamanho);
        System.out.println("this.estaVazia(): " + this.estaVazia());
        System.out.println("\nthis.toString(): " + this.toString());

        System.out.println("\n--- fim do estado atual da lista ---");
    }

    public String toString() {
        boolean aListaEstaVazia = this.estaVazia();
        
        if(aListaEstaVazia) {
            return "[]";
        }

        StringBuilder fragmento = new StringBuilder();
        fragmento.append("[ ");
        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        while(nodoAtual.getProximoNodo() != null) {
            fragmento.append(nodoAtual.toString());
            fragmento.append(", ");
            nodoAtual = nodoAtual.getProximoNodo();
        }
        fragmento.append(nodoAtual.toString());
        fragmento.append(" ]");
        return fragmento.toString();
    }
}
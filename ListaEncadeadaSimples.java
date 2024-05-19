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

    public void removerNodo() {
        /* Os testes da minha cabeça aguardam um cannudo do futuro.
         * :gnu:
         * 
         * [VOLTAR À MESA DO DEBUG DA PRÓXIMA VEZ QUE ESTA FUNÇÃO FOR INVOCADA]
         */
        Nodo<TipoGenerico> cabeca = this.cabeca;
        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        Nodo<TipoGenerico> cauda = this.cauda;
        Nodo<TipoGenerico> proximoNodo = nodoAtual.getProximoNodo();
        int tamanho = this.tamanho;
        boolean oProximoNodoEhCauda = false;
        for(int i = 0; i < tamanho; i++) {
            oProximoNodoEhCauda = proximoNodo == cauda;
            if(oProximoNodoEhCauda) {
                nodoAtual.setProximoNodo(null);
                this.cauda = nodoAtual;
                this.decrementarTamanho();
                break;              
            } else {
                nodoAtual = nodoAtual.getProximoNodo();
                proximoNodo = nodoAtual.getProximoNodo();
            }
        }
        System.out.println();
    }
}
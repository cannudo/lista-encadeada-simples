public class ListaEncadeadaSimples<TipoGenerico> implements ListaEncadeadaSimplesInterface<TipoGenerico> {
    private Nodo<TipoGenerico> cabeca;
    private Nodo<TipoGenerico> cauda;
    private int tamanho;

    public ListaEncadeadaSimples() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }


    public void append(TipoGenerico dado) {
        Nodo<TipoGenerico> novoNodo = new Nodo<TipoGenerico>(dado);
        if (this.isEmpty()) {
            this.cabeca = novoNodo;
            this.cauda = novoNodo;
        } else {
            this.cauda.setProximoNodo(novoNodo);
            this.cauda = novoNodo;
        }
        this.tamanho++;
    }

    public boolean estaForaDosLimites(int index) {
            return index < 0 || index > this.tamanho;
    }

    public void insert(int index, TipoGenerico dado) {
        if(estaForaDosLimites(index)) {
            throw new IndexOutOfBoundsException("estaForaDosLimites(int index): parâmetro index fora dos limites.");
        }

        Nodo<TipoGenerico> novoNo = new Nodo<TipoGenerico>(dado);
        if (index == 0) {
            novoNo.setProximoNodo(this.cabeca);
            this.cabeca = novoNo;
            if (this.isEmpty()) {
                this.cauda = novoNo;
            }
        } else if (index == this.tamanho) {
            this.cauda.setProximoNodo(novoNo);
            this.cauda = novoNo;
        } else {
            Nodo<TipoGenerico> nodoAnterior = this.cabeca;
            for (int i = 0; i < index - 1; i++) {
                nodoAnterior = nodoAnterior.obterProximoNodo();
            }
            novoNo.setProximoNodo(nodoAnterior.obterProximoNodo());
            nodoAnterior.setProximoNodo(novoNo);           
        }
        this.tamanho++;
    }

    public void remove(int index) {
        if(estaForaDosLimites(index)) {
            throw new IndexOutOfBoundsException("estaForaDosLimites(int index): parâmetro index fora dos limites.");
        }

        if (index == 0) {
            this.cabeca = this.cabeca.obterProximoNodo();
            if (this.cabeca == null) {
                this.cauda = null;
            }
        } else {
            Nodo<TipoGenerico> nodoAnterior = this.cabeca;
            for (int i = 0; i < index - 1; i++) {
                nodoAnterior = nodoAnterior.obterProximoNodo();
            }
            nodoAnterior.setProximoNodo(nodoAnterior.obterProximoNodo().obterProximoNodo());
            if (nodoAnterior.obterProximoNodo() == null) {
                this.cauda = nodoAnterior;
            }
        }
        this.tamanho--;
    }

    public int size() {
        return this.tamanho;
    }

    public TipoGenerico get(int index) {
        if(estaForaDosLimites(index)) {
            throw new IndexOutOfBoundsException("estaForaDosLimites(int index): parâmetro index fora dos limites.");
        }

        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        for (int i = 0; i < index; i++) {
            nodoAtual = nodoAtual.obterProximoNodo();
        }
        return nodoAtual.obterDado();
    }

    public boolean contains(TipoGenerico data) {
        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        while (nodoAtual != null) {
            if (nodoAtual.obterDado().equals(data)) {
                return true;
            }
            nodoAtual = nodoAtual.obterProximoNodo();
        }
        return false;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<TipoGenerico> nodoAtual = this.cabeca;
        while (nodoAtual.obterProximoNodo() != null) {
            sb.append(nodoAtual.obterDado());
            sb.append(", ");
            nodoAtual = nodoAtual.obterProximoNodo();
        }
        sb.append(nodoAtual.obterDado());
        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.cabeca == null;
    }

    public void status() {
        System.out.println("ListaEncadeadaSimples: " + this.toString());
        System.out.println("Tamanho: " + this.size());
        System.out.println("Vazia? " + this.isEmpty());
    }

}
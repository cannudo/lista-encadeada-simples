import java.util.Scanner;

public class ListaEncadeada<TipoGenerico> {
    private No<TipoGenerico> cabeca;
    private No<TipoGenerico> cauda;
    private int tamanho;

    public ListaEncadeada(No<TipoGenerico> primeiroNo) {
        this.adicionarNoAoInicio(primeiroNo);
    }

    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;        
    }

    public void zerarLista() {
        this.setTamanho(0);
        this.setCabeca(null);
        this.setCauda(null);
    }

    public No<TipoGenerico> getCabeca() {
        return this.cabeca;
    }

    public void setCabeca(No<TipoGenerico> novaCabeca) {
        this.cabeca = novaCabeca;
    }

    public No<TipoGenerico> getCauda() {
        return this.cauda;
    }

    public void setCauda(No<TipoGenerico> novaCauda) {
        this.cauda = novaCauda;
    }

    public ListaEncadeada<TipoGenerico> clone() {
        ListaEncadeada<TipoGenerico> retorno = new ListaEncadeada<>();
        No<TipoGenerico>[] array = (No<TipoGenerico>[]) new No[this.getTamanho()];
        No<TipoGenerico> noArbritario = new No();
        if(this.estaVazia()) {
            return retorno;
        }
        if(this.aListaTemUmUnicoNo()) {
            retorno.adicionarNoAoInicio(this.getCabeca());
            return retorno;
        }
        for(int i = 0; i <= this.indiceDaCauda(); i++) {
            noArbritario = this.buscarNoNoIndice(i);
            array[i] = noArbritario;
        }
        noArbritario = new No();
        for(int j = 0; j <= this.indiceDaCauda(); j++)  {
            noArbritario = array[j];
            retorno.adicionarNoAoFimDaLista(noArbritario);
        }
        return retorno;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    private void setTamanho(int novoTamanho) {
        this.tamanho = novoTamanho;
    }

    private void incrementarTamanho() {
        this.tamanho++;
    }

    private void decrementarTamanho() {
        this.tamanho--;
    }

    public boolean temCabeca() {
        return this.cabeca != null;
    }

    public boolean temCauda() {
        return this.cauda != null;
    }

    public boolean estaVazia() {
        return !this.temCabeca() && !this.temCauda();
    }

    public boolean aListaTemUmUnicoNo() {
        return (this.getCabeca() == this.getCauda()) && this.getTamanho() == 1;
    }

    public int indiceDaCauda() {
        return this.getTamanho() - 1;
    }

    public boolean oNoEhCabeca(No<TipoGenerico> no) {
        return no == this.cabeca;
    }

    public boolean oNoEhCauda(No<TipoGenerico> no) {
        return no == this.cauda;
    }

    public void adicionarNoAoFimDaLista(No<TipoGenerico> novoNo) {
        if(this.estaVazia()) {
            this.setCabeca(novoNo);
            this.setCauda(novoNo);
        } else {
            this.getCauda().setProximoNo(novoNo);
            this.setCauda(novoNo);
        }
        this.incrementarTamanho();
    }

    public void adicionarNoAoInicio(No<TipoGenerico> novaCabeca) {
        novaCabeca.setProximoNo(this.getCabeca());
        if(this.estaVazia()) {
            this.setCauda(novaCabeca);
        }
        this.setCabeca(novaCabeca);
        this.incrementarTamanho();
    }

    public No<TipoGenerico> removerNoNoIndice(int indice) {
        /*
        Por enquanto, a implementação deste método não é necessária.
        Quando voltar, revisar a parte do commit e3e13d666946a17e47899f397d9b0410b222811f
        que inclui a função zerarLista() (que parece gambiarra demais)
        */
        if(this.estaVazia()) {
            throw new ListaVaziaException("Mulher, tá vazia essa lista");
        }
        if(!this.oIndiceEstaDentroDosLimites(indice)) {
            throw new OIndiceEstaForaDosLimitesException("O índice " + indice + " está fora dos limites da lista (0 à " + (this.indiceDaCauda()) + ").");
        }

        No<TipoGenerico> candidatoARemocao = null;
        No<TipoGenerico> novaCauda = null;
        No<TipoGenerico> noAnterior = null;

        if(this.temCauda() && this.indiceDaCauda() == 0 && indice == 0) {
            candidatoARemocao = this.getCauda();
            this.zerarLista();
        } else {
            candidatoARemocao = this.buscarNoNoIndice(indice);
            noAnterior = this.buscarNoNoIndice(indice - 1);
            novaCauda = candidatoARemocao.getProximoNo();
            noAnterior.setProximoNo(novaCauda);
            System.out.println("Debug");
        }
        return candidatoARemocao;
    }

    public No<TipoGenerico> removerUltimoNo() {
        if(this.estaVazia()) {
            throw new ListaVaziaException("Mulher, tá vazia essa lista");
        } else {
            No<TipoGenerico> novoNoCauda = null;
            No<TipoGenerico> noRemovido = null;
            try {
                novoNoCauda = this.buscarNoNoIndice(this.indiceDaCauda() - 1);
                novoNoCauda.setProximoNo(null);
                noRemovido = this.cauda;
                this.setCauda(novoNoCauda);
                this.decrementarTamanho();
            } catch (OIndiceEstaForaDosLimitesException e) { /* Ele sempre vai cair aqui quando a lista só tiver um nó */
                noRemovido = this.cauda;
                this.zerarLista();
            }
            return noRemovido;
        }
    }

    public No<TipoGenerico> removerNoDoInicio() {
        No<TipoGenerico> noRemovido = null;
        if(this.estaVazia()) {
            throw new ListaVaziaException("Deixa de ser maluca, garota. Tá vazia essa lista. Tú quer remover que diaxo de nó aqui que não tem?");
        } else {
            noRemovido = this.getCabeca();
            if(this.aListaTemUmUnicoNo()) {
                this.zerarLista();
           } else {
                No<TipoGenerico> novaCabeca = this.getCabeca().getProximoNo();
                this.setCabeca(novaCabeca);
                this.decrementarTamanho();
           }
        }
        return noRemovido;
    }

    public boolean oIndiceEstaDentroDosLimites(int indice) {
        return indice >= 0 && indice <= this.indiceDaCauda();
    }

    public No<TipoGenerico> buscarNoNoIndice(int indice) {
        if(this.estaVazia()) {
            throw new ListaVaziaException("Tá vazia essa lista, bixaa");
        }
        if(this.oIndiceEstaDentroDosLimites(indice)) {
            No<TipoGenerico> noAtual = this.cabeca;
            for(int i = 0; i < indice; i++) {
                if(noAtual.getProximoNo() != null) {
                    noAtual = noAtual.getProximoNo();
                }
            }
            return noAtual;
        } else {
            throw new OIndiceEstaForaDosLimitesException("O índice " + indice + " está fora dos limites da lista (0 à " + (this.indiceDaCauda()) + ").");
        }
    }

    public String toString() {
        String retorno = "{ ";

        if(!this.estaVazia()) {
            No<TipoGenerico> noAtual = this.cabeca;
            
            while(noAtual != null) {
                if(!this.oNoEhCauda(noAtual)) {
                    retorno += noAtual.toString() + " , ";                    
                } else {
                    retorno += noAtual.toString();
                }
                noAtual = noAtual.getProximoNo();
            }
        }
        retorno += " }";
        return retorno;
    }

    public static void main(String[] args) {
        int indice, opcao = 99;
        String dado;
        
        Scanner leitor = new Scanner(System.in);

        ListaEncadeada<String> lista = new ListaEncadeada<>();

        while(opcao != 0) {
            System.out.println("\nMenu:");
            System.out.println("0 - Sair");
            System.out.println("1 - Listar nós");
            System.out.println("2 - Adicionar nó ao fim da lista");
            System.out.println("3 - Buscar nó pelo índice");
            System.out.println("4 - Remover último nó");
            System.out.println("5 - Adicionar nó ao início");
            System.out.println("6 - Remover nó do início");
            System.out.println("7 - Clonar lista");
            System.out.print("--> ");
            opcao = leitor.nextInt();
            leitor.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println(lista.toString());
                    break;
                case 2:
                    System.out.print("Digite um dado string: ");
                    dado = leitor.nextLine();
                    No<String> novoNo = new No<String>(dado);
                    lista.adicionarNoAoFimDaLista(novoNo);
                    break;
                case 3:
                    if(lista.estaVazia()) {
                        System.out.println("A lista tá vazia, bixa");
                        break;
                    }
                    System.out.print("Qual índice? ");
                    indice = leitor.nextInt();
                    leitor.nextLine();
                    try {
                        No<String> no = lista.buscarNoNoIndice(indice);
                        System.out.println(no.toString());
                    } catch (OIndiceEstaForaDosLimitesException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Nó removido: " + lista.removerUltimoNo());                        
                    } catch (ListaVaziaException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Digite um dado string: ");
                    dado = leitor.nextLine();
                    No<String> novoNoGambiarra = new No<String>(dado);
                    lista.adicionarNoAoInicio(novoNoGambiarra);
                    break;
                case 6:
                    try {
                        System.out.println("Nó removido: " + lista.removerNoDoInicio());
                    } catch (ListaVaziaException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Original: " + lista.toString() + "\nClone: " + lista.clone());
                    break;
                default:
                    break;
            }
        }
        System.out.println("Saindo.");
    }

}
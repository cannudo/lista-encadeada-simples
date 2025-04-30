import java.util.Scanner;

public class ListaEncadeada<TipoGenerico> {
    private No<TipoGenerico> cabeca;
    private No<TipoGenerico> cauda;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;        
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

    public void adicionarNo(No<TipoGenerico> novoNo) {
        if(this.estaVazia()) {
            this.setCabeca(novoNo);
            this.setCauda(novoNo);
        } else {
            this.getCauda().setProximoNo(novoNo);
            this.setCauda(novoNo);
        }
        this.incrementarTamanho();
    }

    public String toString() {
        String retorno = "{ ";

        if(!this.estaVazia()) {
            No<TipoGenerico> noAtual = this.cabeca;

            while(noAtual != null) {
                retorno += noAtual.getDado() + " ➞ ";
                noAtual = noAtual.getProximoNo();
            }
        }
        retorno += "∅";
        retorno += " }";
        return retorno;
    }

    public static void main(String[] args) {
        int opcao = 0;
        String dado;
        
        Scanner leitor = new Scanner(System.in);

        ListaEncadeada<String> lista = new ListaEncadeada<>();
        String[] alfabeto = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
        };
        for (String letra : alfabeto) {
            No<String> letraDoAlfabeto = new No<String>(letra);
            lista.adicionarNo(letraDoAlfabeto);
        }
        System.out.println(lista.toString());

        while(opcao != 0) {
            System.out.println("\nMenu:");
            System.out.println("0 - Sair");
            System.out.println("1 - Listar nós");
            System.out.println("2 - Adicionar nó");
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
                    lista.adicionarNo(novoNo);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Saindo.");
    }

}
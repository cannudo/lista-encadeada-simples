import java.util.Scanner;

public class No<TipoGenerico> {
    private TipoGenerico dado;
    private No<TipoGenerico> proximoNo;

    public No(TipoGenerico dado) {
        this.dado = dado;
        this.proximoNo = null;
    }

    public TipoGenerico getDado() {
        return this.dado;
    }

    public void setDado(TipoGenerico novoDado) {
        this.dado = novoDado;
    }

    public No<TipoGenerico> getProximoNo() {
        return this.proximoNo;
    }

    public void setProximoNo(No<TipoGenerico> novoNo) {
        this.proximoNo = novoNo;
    }

    public static void main(String args[]) {
        int opcao = 99;
        String dado;
        
        Scanner leitor = new Scanner(System.in);
        
        No<String> primeiroNo = new No<>("A");
        No<String> ultimoNo = primeiroNo;
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
                    System.out.print("Saindo.");
                    break;
                case 1:
                    No<String> atual = primeiroNo;
                    while(atual != null) {
                        System.out.print(atual.getDado() + " - ");
                        atual = atual.getProximoNo();
                    }                    
                    break;
                case 2:
                    System.out.print("Digite um dado string: ");
                    dado = leitor.nextLine();
                    No<String> novoNo = new No<>(dado);
                    ultimoNo.setProximoNo(novoNo);
                    ultimoNo = novoNo;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
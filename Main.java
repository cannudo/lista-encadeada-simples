import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<String>();

        Scanner leitor = new Scanner(System.in);
        int opcao = 99;
        while(true) {
            lista.status();
            System.out.println("0 - Sair");
            System.out.println("1 - Ver estado atual da lista");
            System.out.println("2 - Adicionar nodo");
            System.out.println("3 - Remover cauda");
            System.out.print(">> ");  
            opcao = leitor.nextInt();
            leitor.nextLine();
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    lista.status();
                    break;
                case 2:
                    System.out.print("Digite o valor do nodo a ser adicionado: ");
                    String valor = leitor.nextLine();
                    lista.adicionarNovoNodo(valor);
                    break;
                case 3:
                    lista.removerCauda();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
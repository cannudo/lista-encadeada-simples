class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<String>();
        lista.adicionarNovoNodo("O primeiro a entrar (this)");
        lista.adicionarNovoNodo("deve ser o primeiro a sair.");
        lista.adicionarNovoNodo("Este nó deve ser a cauda, e será o último a sair.");
        System.out.println();
    }
}
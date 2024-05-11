class Main {
    public static void main(String[] args) {
        Nodo<String> novoNo = new Nodo("O primeiro a entrar (this)");
        Nodo<String> proximoNo = new Nodo("deve ser o primeiro a sair.");
        novoNo.setProximoNodo(proximoNo);

        /* Beleza. Mas setProximoNodo() deve ser chamado dentro de ListaEncadeadaSimples() */

        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<String>(novoNo);
        System.out.println();
    }
}
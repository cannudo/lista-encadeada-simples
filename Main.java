class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> listaVazia = new ListaEncadeadaSimples<String>();
        listaVazia.status();
        /* OK    */

        ListaEncadeadaSimples<String> listaDeUnicoNo = new ListaEncadeadaSimples<String>();
        Nodo<String> noCabecaECauda = new Nodo<String>("único nó na lista"); // ou seja, este nó será lista.getCabeca() e lista.getCauda()
        listaDeUnicoNo.adicionarNovoNodo(noCabecaECauda);
        /* OK */

        ListaEncadeadaSimples<Integer> listaParaDemaisTestes = new ListaEncadeadaSimples<Integer>();
        listaDeUnicoNo.status();
        /* OK */

        listaParaDemaisTestes.adicionarNovoNodo(1);
        listaParaDemaisTestes.adicionarNovoNodo(2);
        listaParaDemaisTestes.adicionarNovoNodo(3);
        listaParaDemaisTestes.adicionarNovoNodo(4);
        listaParaDemaisTestes.adicionarNovoNodo(5);
        listaParaDemaisTestes.status();
        System.out.println();
    }
}
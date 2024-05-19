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
        listaParaDemaisTestes.status();
        /* OK */
        listaParaDemaisTestes.removerCauda();
        listaParaDemaisTestes.status();
        /* OK */

        listaParaDemaisTestes.removerCauda();
        /* OK */

        System.out.println();
    }
}
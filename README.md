# lista-encadeada-simples
Implementação em Java de uma lista encadeada simples

## O que é uma lista encadeada simples

É uma estrutura de dados que armazena uma coleção de elementos. Consiste em uma série de nós, onde cada um deles possui duas informações principais: o dado guardado pelo nó e o endereço do próximo nó na lista. Perceba que deve haver apenas uma referência em cada nó: a referência para o próximo nó. Por isso é chamada de lista encadeada simples.

Existe uma outra estrutura chamada lista duplamente encadeada, onde cada nó possui duas referências: uma para o próximo nó da lista e outra para o nó anterior.

## Como funciona

Em primeiro lugar, quando uma lista encadeada simples é instanciada, ela deve ter dois nós configurados: um nó chamado de cabeça (head) e outro chamado de cauda (tail). O nó cabeça é o primeiro nó da lista e o nó cauda é o último nó da lista. Ambos são nulos quando a lista é instanciada.

## Execução local

Para executar o projeto localmente, precisaremos __compilar__ os códigos-fonte e __rodar__ os arquivos gerados pela compilação.
Os comandos abaixo foram executados em uma máquina que utiliza Debian GNU/Linux.

```terminal
# Compilação
@cannudo ➜ /workspaces/lista-encadeada-simples (main) $ javac *.java
```

> O comando `javac` executa a compilação dos arquivos com extensão `.java` e gera os arquivos compilados com extensão `.class`. Para executar os arquivos `.class`, precisaremos utilizar o comando `java`.

```terminal
# Execução
@cannudo ➜ /workspaces/lista-encadeada-simples (main) $ java Main
```
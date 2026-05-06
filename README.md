# Exercicios-POO-JAVA-JAVA-SWING-e-POSTGRESQL
Exercicio Grud com JAVA POO, JAVA SWING E POSTGRES 

Exercício 1. (CadLivro GRUD)
Crie um programa que implemente a classe Livro. Esta classe deve conter o título
do livro, nome do autor, editora e quantidade de páginas. Adicione um atributo que
armazene a página atual (paginaAtual), para apresentação em um dispositivo eletrô-
nico de leitura. Crie um método virarPagina, que incrementa o valor armazenado em
paginaAtual. Após isso, crie uma segunda classe chamada Main (classe principal) que
conterá o método main. Nesta classe, crie um objeto Livro e preencha seus atributos com
valores lidos do usuário. Após isso, chame o método para virar uma página e apresente
o objeto (seu estado) em tela. A classe Livro é apresentada abaixo.
Livro
– titulo: String
– autor: String
– editora: String
– numPags: int
– pagAtual: int = 0
+ métodos construtores
+ métodos set() e get()
+ virarPagina(): void
Exercício 2 (ListaLivros)
Usando a classe Livro, criada no exercício anterior, crie uma lista para armazenar dife-
rentes livros. Esta lista pode ser criada usando a coleção ArrayList. Crie um conjunto
de objetos, solicite ao usuário o valor dos seus atributos e armazene-os na lista. Após
isso, apresente o título e o número de páginas de cada livro armazenado. Utilize uma
lista global e diferentes métodos para a criação dos objetos e sua apresentação.
Exercício 2.3. (ConsultaLivro)
Com base no exercício anterior, crie um método para a consulta de livros. O usuário
informa o título do livro desejado, o sistema faz a busca na lista de livros e apresenta
seus dados, caso o encontre. Caso contrário, o sistema deve apresentar a mensagem "Livro
não encontrado".
Exercício 2 (ExcluiLivro)
Com base no exercício anterior, crie um método para exclusão de livros. O usuário
informa o título do livro que deseja excluir, o sistema faz a busca do livro e o remove da
lista, caso o encontre. Caso contrário, o sistema deve apresentar a mensagem "Livro não
encontrado".
Exercício 2 (AlteraLivro)
Com base no exercício anterior, crie um método para alteração de livros. O usuário
informa o título do livro que deseja alterar, o sistema faz a busca do livro e, caso o encon-
tre, solicita as novas informações ao usuário, atualizando seus campos. Caso contrário. o
sistema deve apresentar a mensagem "Livro não encontrado".
Exercício 2.6. (LivrosCompleto)
Com base nos métodos criados nos exercícios anteriores, crie um programa que apresente
ao usuário um menu com todas as opções (cadastro de livro, alteração, exclusão, consulta
por título, consulta completa e sair). O usuário pode selecionar as opções desejadas e, ao
terminar, seleciona a opção sair, que finaliza a execução do programa.

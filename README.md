📚 Exercícios POO - JAVA, JAVA SWING e POSTGRESQL

Este repositório foi criado para documentar e organizar a resolução do roteiro de exercícios de Programação Orientada a Objetos (POO) em Java. O projeto evolui de uma lógica simples de console para um sistema completo de gerenciamento de livros (GRUD/CRUD), utilizando interface gráfica profissional e persistência real em banco de dados.
🛠️ Tecnologias e Conceitos Utilizados

    Java SE (JDK): Linguagem base para a criação das classes, métodos estruturados e aplicação dos pilares de POO (Encapsulamento, Objetos e Métodos).

    Java Swing (GUI): Biblioteca gráfica utilizada para criar as janelas do sistema. O gerenciamento de telas é controlado via CardLayout, permitindo alternar entre 5 painéis diferentes dentro de um único Frame central.

    PostgreSQL: Banco de dados relacional robusto utilizado para substituir listas temporárias em memória (ArrayList), garantindo que os livros cadastrados permaneçam salvos mesmo após fechar o programa.

    Padrão Arquitetural MVC: Divisão do projeto em camadas isoladas:

        Model: Representação da entidade Livro e suas regras.

        DAO (Data Access Object): Camada de persistência responsável pelos comandos SQL (INSERT, SELECT, UPDATE, DELETE).

        View: Interface visual que interage diretamente com o usuário.

🗺️ Mapeamento de Telas vs Exercícios

O sistema unifica todas as demandas do roteiro através de 5 telas dinâmicas acessadas pelo menu de navegação superior:
Tela no CardLayout	Operação do Sistema	Objetivo Técnico	Exercício Base
Tela 1	Cadastro de Livros	Captura os campos através de caixas de texto e insere um novo objeto Livro no PostgreSQL.	Exercício 1 e 2
Tela 2	Consulta por Título	O usuário digita o título do livro. O sistema varre o banco e exibe as informações detalhadas ou a mensagem "Livro não encontrado".	Exercício 2.3
Tela 3	Exclusão de Livros	Localiza o livro alvo pelo título e realiza a remoção física do registro na base de dados.	Exercício 2.4
Tela 4	Atualização Geral	Permite buscar um livro existente, carrega os dados atuais nos campos e disponibiliza a edição de qualquer atributo via botão "Atualizar".	Exercício 2.5
Tela 5	Visão Geral (Completa)	Exibe uma tabela estruturada (JTable) listando todos os livros salvos e seus respectivos atributos em tempo real.	Exercício 2.6
🚀 Como este repositório está organizado

A estrutura de pacotes dentro da pasta src/ segue estritamente as boas práticas de desenvolvimento Java:

    br.com.cadlivro.model: Contém a classe Livro.java com atributos como título, autor, editora, total de páginas e a lógica do método virarPagina().

    br.com.cadlivro.database: Armazena a classe de conexão JDBC (ConexaoBanco.java) responsável por autenticar e comunicar o Java com o servidor PostgreSQL.

    br.com.cadlivro.dao: Concentra as instruções SQL preparadas (PreparedStatement) para transacionar com segurança as operações do CRUD.

    br.com.cadlivro.view: Agrupa a janela principal MainFrame.java com a barra de menus e os subpainéis que dão vida à interface gráfica.

    💡 Nota de Execução: Para rodar este projeto localmente, certifique-se de possuir o driver JDBC do PostgreSQL (postgresql-42.x.x.jar) adicionado às bibliotecas do seu ambiente de desenvolvimento e configure as credenciais de acesso no arquivo de conexão do banco de dados.

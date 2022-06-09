# Projeto-SpringBoot

Um projeto feito para fins de avaliação, da matéria lógica e pensamento computacional, do 2º módulo, do curso técnico em desenvolvimento de sistemas.

Um projeto para praticar e desenvolver aprendizado com desenvolvimento de aplicações utilizando Spring boot.

Material de apoio (Curso Spring Boot, Hibernate, REST, Ionic, JWT, S3, MySQL, MongoDB do professor Nélio Alves).

O QUE ESSE PROJETO FAZ:
  
O projeto trata-se de uma aplicação onde é possivel inserir usuarios em um banco de dados em memória(h2 - hibernate - ORM), implementação de CRUD(create/read/update/delete), com verificação e testes de endpoints por meio do Postman.

Cada Usuário possui os seguintes atributos: Id - Nome - Email - Sequencia de digitos - digito único e lista de digitos únicos ja calculados.

(CRUD):

Metodo GET - é possivel buscar por um usuário específico digitando usuario/(o id do usuario desejado).

Metodo GET - é possivel buscar todos os usuários cadastrados no banco de dados, porem so são mostrados os atributos nome e email de cada usuário, pois esse metodo GET busca usuário DTO.

Metodo POST - é o metodo responsável pelo cadastro de usuários no banco de dados, onde é necessário informar apenas os atributos (nome, email, e a sequencia de digitos, pois o ID e o digito verificador e preenchido automáticamente. 

Metodo PUT - responsável pela atualização de dados cadastrados de um usuário.

Metodo DELETE = responsável ppor deletar usuários ja cadastrados no banco de dados.

O projeto possui uma função capaz de pegar uma sequencia de digitos fornecida pelo usuario e trata-la para obtenção do digito verificador, que consiste na seguinte lógica: o usuario fornece uma sequencia de digitos e o programa e capaz de efetuar a soma de todos os numeros ate que reste apenas um digito como resposta. 

### sequencia de digitos: 5869574 -> soma-se todos os números fornecidos -> 5 + 8 + 6 + 9 + 5 + 7 + 4 = 44 continua a soma ate restar apenas um digito -> 4 + 4 = 8

O projeto conta com implementação do LOMBOK um framework java que visa eliminar a verbosidade do codigo, deixando-o mais limpo.

# Atividade_Backend_Kabum
Desafio de backend da Kabum!

API REST de consulta de valores de frete para cada transportadora existente. (Entrega Ninja e Entrega KaBuM)

# Primeiros passos

Para executar a aplicação, é necessário ter
o Java JDK 17 instalado na sua máquina.A aplicação pode ser executada pela classe Application que possui
um método main. Caso queira executar pelo terminal, vá até o diretório principal do projeto e execute o comando
.\mvnw spring-boot:run

# Banco de dados
O banco de dados utilizado neste projeto foi o H2, 
um banco de dados em memória do Java. Para ver a listagem
das opções de frete, rode os scripts SQL que estão no arquivo
scripts.sql (INSERT INTO) na pasta resources. Os scripts devem ser executados no
console do H2, e ele deve ser acesso neste link: http://localhost:8080/h2-console.
O arquivo import.sql contém também o script da tabela opcoes_frete, mas não é
necessário executá-lo no banco. O Hibernate irá mapear a classe OpcoesFrete e criar
a tabela automaticamente.


# Consulta de frete
Para realizar uma consulta na API, utilize algum software que 
permita manipular requisições HTTP, como Postman ou Insomnia.
No Postman, por exemplo, você deverá selecionar a opção POST ao lado do campo
de URL, e neste campo você deverá inserir este link: http://localhost:8080. Depois disso selecione
as opções Body -> raw -> JSON e insira os dados para consulta no body da requisição em formato JSON, 
conforme o exempo abaixo:

{
"dimensao": {
"altura":102,
"largura":40
},
"peso":400
}

Ao clicar no botão 'Send', a API irá retornar um JSON contendo uma lista de
transportadoras que realizam frete daquele produto, o valor do frete e o
prazo de entrega do produto em dias. 

Exemplo de retorno:

[
{
"nome":"Entrega Ninja",
"valor_frete": 12.00,
"prazo_dias": 6
},
{
"nome":"Entrega KaBuM",
"valor_frete": 8.00,
"prazo_dias": 4
}
]


# Opções de frete
Para que a API retorne uma lista com as opções de frete, é necessário ter
executado os scripts SQL descritos no item 'Banco de dados'. Acessando o link
http://localhost:8080/opcoes-frete, uma lista com as opções de frete deverá ser retornada.
O método http utilizado neste caso é o GET, e a URL pode ser acessada também pelo browser.

# Swagger UI
A API disponibiliza uma interface do Swagger (OpenAPI), 
onde você encontrará uma breve descrição de cada endpoint e
conseguirá testar esses endpoints pela própria interface.
Em 'Schemas', você encontrará uma visualização de algumas entidades 
da API, como a classe Produto, OpcoesFrete e também o record DimensaoDTO.
A interface do Swagger pode ser acessada neste link: http://localhost:8080/swagger-ui/index.html#/

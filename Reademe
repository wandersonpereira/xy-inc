# xy-inc
Projeto para cadastro de coordenadas e seus respectivos estabelecimentos

Pré Requisitos
  - Docker
  - Docker-compose

### Iniciar projeto ambiente "Prod"
Para iniciar o projeto já com o docker-compose instalado, acesse a pasta raiz do projeto e execute o comando abaixo:
```
docker-compose up
```
Este comando iniciará o projeto usando o .jar gerado pelo build do Maven

### Iniciar projeto ambiente "Dev"
Para rodar o projeto como ambiente de desenvolvimento, execute o comando abaixo:
```
docker-compose-dev.yml
```
Este comando iniciára o projeto como dev, usando o do maven "mvn spring-boot:run", para que ao alterar algo no código ele reflita na API Rest

### Executando testes
Com o docker-compose de pé, rode o comando abaixo:
```
docker exec -it poi_web_1 bash -c "mvn test"
```

### EndPoint Rest
Os Endpoint Rest são usados para listar e cadastrar os pois

EndPoints:

Lista todos os POIs cadastrados
```
GET - http://localhost:8080/poi
```

Cadastra um novo Poi
```
POST - http://localhost:8080/poi
# Body da requisição
# Espera um JSON, com os dados de cadastro dos pois
{
	"name":"Churrascaria",
	"coordinatex": 28,
	"coordinatey": 2
}
```
Lista todos os POIs cadastrados, passando como parâmetro, cordenada_x, coordenada_y e distância
```
GET - http://localhost:8080/poi/20/10/10
# Primeiro parâmetro coordenada_x
# Segundo parâmetro coordenada_y
# Terceiro parâmetro distância
```

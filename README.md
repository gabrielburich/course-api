# course-api

API de cursos com persistencia em memória com banco H2. 
Para executar basta apenas rodar o projeto.

[Link do desafio](https://efficient-sloth-d85.notion.site/Desafio-01-62ef2545d8da445cb27781fadebba610) com a especificação desta API.

# cURLs

#### save

```shell
curl --request POST \
  --url http://localhost:8080/courses \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Curso Java",
	"category": "BEGINNER"
}'
```

#### list

```shell
curl --request GET --url 'http://localhost:8080/courses?category=BEGINNER&name=Curso%20Java' 
```

#### update

```shell
curl --request PUT \
  --url http://localhost:8080/courses/{id} \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Curso Java editado",
	"category": "BEGINNER"
}'
```

#### delete

```shell
curl --request DELETE \
  --url http://localhost:8080/courses/{id} 
```

#### patch

```shell
curl --request PATCH \
  --url http://localhost:8080/courses/{id}/active 
```
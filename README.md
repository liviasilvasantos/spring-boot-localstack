# spring-boot-localstack
Demo spring boot com localstack

## Subir localstack

```bash
docker compose up
```

## Criar profile localstack

```bash
aws configure --profile localstack
```

## Adicionar no parameter store

```bash
cd localstack
./localstack.sh
```

## Consultar no parameter store

```bash
aws --endpoint http://localhost:4566 ssm get-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --profile localstack
```

## Swagger

> http://localhost:8080/swagger-ui/index.html
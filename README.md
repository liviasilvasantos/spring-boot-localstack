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

## Listar identity do profile  
```bash
aws --endpoint http://localhost:4566 --profile localstack sts get-caller-identity  
```

## Listar todos os parameters do parameter store  
```bash
aws --endpoint http://localhost:4566 --profile localstack ssm describe-parameters
```

## Consultar no parameter store  
```bash
aws --endpoint http://localhost:4566 --profile localstack ssm get-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" 
```

## Listar todas as secrets do secret manager  
```bash
aws --endpoint http://localhost:4566 --profile localstack secretsmanager list-secrets
```

## Swagger  
> http://localhost:8080/swagger-ui/index.html
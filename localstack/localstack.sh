#! /bin/bash

# cria parameter - parameter store
echo $(aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack/helloWorld" --value "Hello World Parameter Store" --type String)

# cria secrets - secrets manager
echo $(aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 1\",\"valor2\":\"Hello World 1\",\"valor3\":\"Hola Mundo 1\"}")
echo $(aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 2\",\"valor2\":\"Hello World 2\",\"valor3\":\"Hola Mundo 2\"}")
echo $(aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 3\",\"valor2\":\"Hello World 3\",\"valor3\":\"Hola Mundo 3\"}")
echo $(aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 4\",\"valor2\":\"Hello World 4\",\"valor3\":\"Hola Mundo 4\"}")

# cria S3 bucket
echo $(aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://helloworld)

# lista S3 Buckets
echo $(aws --endpoint http://localhost:4566 --profile localstack s3 ls)
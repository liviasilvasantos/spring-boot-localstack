#! /bin/bash
# cria parameter - parameter store
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String

# cria secrets - secrets manager
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 1\",\"valor2\":\"Hello World 1\",\"valor3\":\"Hola Mundo 1\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 2\",\"valor2\":\"Hello World 2\",\"valor3\":\"Hola Mundo 2\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 3\",\"valor2\":\"Hello World 3\",\"valor3\":\"Hola Mundo 3\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 4\",\"valor2\":\"Hello World 4\",\"valor3\":\"Hola Mundo 4\"}"

# cria bucket
aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://helloworld
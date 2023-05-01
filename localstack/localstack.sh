#! /bin/bash

readonly LOCALSTACK_URL=http://localhost:4566
readonly LOCALSTACK_PROFILE=localstack

sleep 1;

echo '### Configurando profile localstack'
echo $(aws configure set aws_access_key_id localAccessKey --profile $LOCALSTACK_PROFILE)
echo $(aws configure set aws_secret_access_key localSecretAccessKey --profile $LOCALSTACK_PROFILE)
echo $(aws configure set region us-east-1 --profile $LOCALSTACK_PROFILE)

echo '### Criando Segredos no AWS Secret Manager do LocalStack'
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String)

echo '### Criando Chaves no AWS Parameter Store do LocalStack'
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE secretsmanager create-secret --name /secret/spring-boot-localstack_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 1\",\"valor2\":\"Hello World 1\",\"valor3\":\"Hola Mundo 1\"}")
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 2\",\"valor2\":\"Hello World 2\",\"valor3\":\"Hola Mundo 2\"}")
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE secretsmanager create-secret --name /secret/application --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 3\",\"valor2\":\"Hello World 3\",\"valor3\":\"Hola Mundo 3\"}")
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE secretsmanager create-secret --name /secret/application_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo 4\",\"valor2\":\"Hello World 4\",\"valor3\":\"Hola Mundo 4\"}")

echo '### Criando Bucket no S3 do LocalStack'
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE s3 mb s3://helloworld)

echo '### Listando todos os buckets do localstack'
echo $(aws --endpoint $LOCALSTACK_URL --profile $LOCALSTACK_PROFILE s3 ls)
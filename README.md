# Avaliação_Full_Stack
____

### Autor:
> Danilo Luiz da Silva

### Criado em:
> 30/06/2022

### Introdução
> Esse é um projeto web desenvolvido para realizar transações financeiras agendadas, como principais objetivos:
> - Cadastrar Nova Transação
> - Mostrar todas as transações



## Informações do Projeto
O projeto utiliza Angular e BootStrap no frontend e Java 11, Spring Boot, Spring Data e banco de dados H2 no backend.

> Inicie o backend primeiro: 
> - Para isso, importe o projeto (Maven) utilizando seu IDE preferido.
> - Depois Execute a classe "EvaluationBackendApplication" dentro da IDE


> Para iniciar o Frontend:
> - Navegue no terminal até a pasta 'evaluation-frontend'.
> - utilize o seguinte código no terminal:

    evaluation-frontend>ng serve --open

Assim, serão expostos os seguintes endereços:

 - **evaluation-backend** -> localhost:8080
 - **evaluation-frontend** -> localhost:4200 (automático)

## Detalhes do Backend:
O backend foi desenvolvido aplicando uma arquitetura MVC que trabalha em três camadas (Controller, Service e Repository) e expõe as seguintes rotas:

## Paths:
> localhost:8080/api/v1/userFinancialTransfer/create
> - Cria novo Registro


> localhost:8080/api/v1/userFinancialTransfer/get
> - Busca todos os registros


## Detalhes do Frontend:

Toda chamada para API é feita no Angular.

Foi utilizado Bootstrap Na tabela de resultados.

Foi utilizado Bootstrap no formulario principal.


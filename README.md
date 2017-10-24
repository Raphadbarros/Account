# Account-api
Projeto conta e transações Java.

# Aplicação Java com as seguintes características:
---
* Endpoints CRUD para contas;
* Endpoints para realizar transações e estorno;
* Execute o projeto para criar as tabelas no banco de dados H2 automaticamente;

## Ambiente de Desenvolvimento
*   Clone este repositorio
*   Execute os comandos abaixo dentro do diretório do projeto
* O Projeto estara disponivel em `http://localhost:8080`
* Execute o script do banco para cadastrar contas e transacoes


## Configurações do ambiente
* Java 
* Marven
* Banco de dados: H2


# Documentação da API de contas

## Criar conta
#### **POST /accounts** 

* ###### HTTP/1.1 201 Created
```json
    {
	"parentID": 0,
    	"nome": "Ramos Oliveira"
    }
```
**Aguarde o retorno do código 201**:

---
### **Visualizar uma conta**
#### GET /accounts/1  
**informar número da conta na url**
> 
```json
    {
        "id": 1,
        "parentID": 0,
        "tipo": null,
        "dataCreat": 2017-01-01,
        "nome": "Ramos Oliveira",
        "situacao": 1,
        "saldo": 0
    }

        
```
---
### **Busca Todas as contas**
#### GET /accounts   
**Retorna todos os as contas cadastradas**
> 
```json
      {
        "id": 1,
        "parentID": 0,
        "tipo": null,
        "dataCreat": 2017-01-01,
        "nome": "Ramos Oliveira",
        "situacao": 1,
        "saldo": 0
    }
```

---
### **Alterar dados na accounts**
#### PUT /accounts 
**Informe os dados da ultima atualização no body do envio**
```json
      {
        "id": 1,
        "nome": "Ramos Silva"
    }
```
---
### **Deletar uma conta**
#### Delete /accounts
**Informe o ID da Conta**

----
# Documentação da API de Transações

## Criar trasação
#### **POST /transacoes** 

* ###### HTTP/1.1 201 Created
```json
   {
 	"valor": 200,
        "contaDestino": 1,
        "contaOrigen": 2,
        "tipo":"DOC",
        "ParentId": 1
  }
```
**Aguarde o retorno do código 201**:

---
### **Visualizar uma conta**
#### GET /transacoes/{id} 
**Retorna uma transacão cadastrada**
> 
```json
   {
 	"id":1,
 	"valor": 20,
        "contaDestino": 1,
        "contaOrigen": 2,
        "tipo":"DOC",
        "ParentId": 1
    }

        
```
---
### **Busca Todas as contas**
#### GET /transacoes   
**Retorna todos os as contas cadastradas**
> 
```json
   {
 	"id":1,
	"valor": 200,
        "contaDestino": 1,
        "contaOrigen": 2,
        "tipo":"ESTORNO",
        "ParentId": 1
   }
```

---
### **Alterar última localização de caminhoneiro**
#### POST /transacoes 
**Realiza o Estorno da Transação conforme informações no body**
```json
     {
 	"id":1,
 	"valor": 200,
        "contaDestino": 1,
        "contaOrigen": 2,
        "tipo":"ESTORNO",
        "ParentId": 1
     }
```

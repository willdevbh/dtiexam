# DTI Exam

Projeto criado com o intuito de demonstração de empenho em construir uma API Rest Básica para a Entidade produto.
A API foi desenvolvida em Java Utilizando o NetBeans com uso de Spring Boot como pode ser visto no arquivo POM do projeto
Como está em desenvolvimento a propriedade "spring.jpa.hibernate.ddl-auto" está como create-drop mas pode ser mudada para Update
para que os dados não sejam perdidos.

Foi utilizado Banco de Dados SQL Server 2017

Com base nas dependências utilizadas no projeto, a estrutura é gerada automaticamente, contudo
como foi pedido a DDL é a seguinte.

##### DDL  de Criação do Banco de Dados
```yaml
CREATE DATABASE dti
GO
USE [dti]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[produtos](
  [cd_produto] [int] NOT NULL,
  [nm_produto] [varchar](255) NOT NULL,
  [qt_produto] [int] NOT NULL,
  [vlr_prodc] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[cd_produto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
```

### A entidade tem a seguinte estrutura:

Nome do Produto ( nmProduto String )
Quantidade do Produto em estoque ( qtProduto Inteiro )
Valor Unitário do Produto ( vlrProdC Inteiro ) em Centavos

Para armazenagem no banco foi feito um ID simples o qual foi chamado de "cdProduto" do tipo Inteiro.
O mesmo no banco de dados é chave primária gerado automaticamente na inserção ao não informá-lo no JSON enviado.

Contém as seguintes implementações

**GET /produtos**
Retorna todos os produtos cadastrados

**GET /produtos/{id}**
Retorna o recurso correspondente ao {id} se existir

**POST /produtos**
Insere um produto seguindo a seguinte estrutura JSON

```yaml
{
  "nmProduto": "Mouse Optico Razer 3000",
  "qtProduto": 20,
  "vlrProdC": 7500
}
```

**PUT /produtos/{id}**
Substitui inteiramente os dados do recurso exceto o {id},
Se não existir recurso com esse {id} ele faz a inserção do ítem gerando um novo {id},
desconsiderando o informado e utilizando o sequencial interno.

**PATCH /produtos/{id}***
Edita atributos do recurso de identificador {id} de acordo com o que é enviado
favorecendo alterações parciais economizando tráfego de rede

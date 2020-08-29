# PDV BACK-END

Ex do Json para inserir um documento fiscal no banco

-------------------------Venda Normal-----------------------------------
{
  "operacao": {
    "cdOperacao": 2
  },
  "filial": {
    "cdFilial": 1
  },
  "cliente": {
    "idCliente": 3
  },
  
  "dataAbertura": "2020-01-01T00:00:00.000+00:00",
  "dataFechamento": "2020-01-01T00:00:00.000+00:00",
  "flagNota": 1,
  "valorDocumento": 20.0,
  "numeroCaixa": 1,
  "itens": [
    {
      "numItemDoc": 1,
      "produto": {
        "cdProduto": 4
        
      },
      "qtdItem": 2,
      "valorItem": 5.75,
      "porcentoIcms": 0.05,
      "valorIcms": 0.1
    }
  ]
}

----------------------------Recarga------------------------------------
{
  "operacao": {
    "cdOperacao": 2
  },
  "filial": {
    "cdFilial": 1
  },
  "recarga": {
   "idRecarga": 2,
   "numeroTelefone":"(11)91111-1111",
   "valorRecarga": 20.0,
   "operadora": {
       "idOperadora":2
   }
  },
  "dataAbertura": "2020-01-01T00:00:00.000+00:00",
  "dataFechamento": "2020-01-01T00:00:00.000+00:00",
  "flagNota": 1,
  "valorDocumento": 20.0,
  "numeroCaixa": 1
}

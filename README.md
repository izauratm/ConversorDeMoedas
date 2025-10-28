# <h1 align="center">🪙 Conversor de Moedas 🪙</h1> 
Um projeto Java que permite converter valores entre diferentes moedas utilizando uma API de taxas de câmbio em tempo real. 
Desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**, curso **ONE | TECH FOUNDATION - G9**, especialização **Back-End**.

---
## 📌 Funcionalidades
- ✅ Conversão entre moedas pré-definidas (BRL, USD, EUR, ARS, MXN, COP),
- 🌍 Suporte para conversões personalizadas entre qualquer moeda disponível na API,
- 📜 Histórico de conversões realizadas durante a sessão,
- 🕒 Registro de data e hora de cada conversão usando java.time,
- 📁 Exportação de dados em formato JSON completo,
- ❌ Tratamento de erros e validação de entrada.

## 🧰 Tecnologias utilizadas
- Java 17+ 
- Gson (para manipulação de JSON) 
- HttpClient (para chamadas à API)
- API ExchangeRate
- Maven (opcional, para gerenciamento de dependências)

## 🚀 Como Executar
1. Clone o repositório:

``` git clone https://github.com/seu-usuario/ConversorDeMoedas.git```

2. Navegue até o diretório:
```
cd ConversorDeMoedas
```
3. Compile e execute:
 ```
javac src/conversordemoedas/*.java
java src/conversordemoedas.Principal
   ```

### 💡 Certifique-se de configurar sua chave da API no arquivo CurrencyService.java.

## 🔳 Exemplos de uso:
- Real brasileiro para Dólar:
```
1 BRL equivale a 0.20 USD
```
- Conversão personalizada:
```
Digite a moeda de origem: EUR
Digite a moeda de destino: JPY
Resultado: 1 EUR equivale a 157.32 JPY

```

## 📂 Estrutura do projeto
```
ConversorDeMoedas/
├── src/
│   └── conversordemoedas/
│       ├── Principal.java
│       ├── service/
│       │   └── CurrencyService.java
│       ├── util/
│       │   ├── Menu.java
│       │   └── JsonExporter.java
│       └── model/
│           └── ExchangeRatesFullResponse.java
├── README.md
└── .gitignore

```

## 👩‍💻 Desenvolvedora
Izaura TM - responsável pelo projeto.

## 📫 Contribuições
Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, sugestões ou novas funcionalidades!

> Este projeto foi desenvolvido como parte do programa **FASE 3 DO ONE: TECH FOUNDATION- Java e Orientação a Objetos ** - Desafio Challenge Conversor de Moedas da plataforma Oracle Next Education em parceria com Alura.

---

 ### 💡Links de Referência:
- [Java Oracle](https://www.oracle.com/br/java/technologies/downloads/)
- [Biblioteca GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0)
- [Postman](https://www.postman.com/downloads/)
- [API ExchangeRate](https://www.exchangerate-api.com/)
- [IntelliJ](https://www.jetbrains.com/pt-br/)
- [Oracle Next Education](https://www.oracle.com/br/education/oracle-next-education/)
  
📎 Link para cursos ALURA: [Alura](https://www.alura.com.br/) 

---

### Licença

Este projeto está licenciado sob os termos da [Licença MIT](LICENSE).

<img alt="Static Badge" src="https://img.shields.io/badge/license-MIT-green">

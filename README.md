# tetraTech

API - Serviço que projeta a estimativa de uma determinada população com base em um data futura.

Tecnologia: Linguagem Java 8
            FrameWork Spring Boot
               
               
Necessário para o build do projeto:
  JDK 1.8
  
Como baixar e construir o projeto:
  
  Escolha uma pasta de sua preferência e execute:
    git clone https://github.com/carloses0/tetraTech.git
    
  Abra o projeto -> tetraTech
    
  Instale todas as dependências nescessárias executando:
    mvn install
  
  E por fim dê "run" no arquivo: "ProjecaoServiceApplication" que se encontra no caminho: 
  
  projecaoService -> src -> main -> java -> com.tetraTech.projecaoService.ProjecaoServiceApplication
    
    
Utilização da API
  
   End-point: "projecao" para recever a Quantidade estimada da população
    Exemplo de requisição para acessá-lo: "http://localhost:8080/projecao/13-11-2029 20:33:12"
    
   End-point: "log" para ver as 10 últimas chamadas do serviço: "projecao"
    Exemplo de requisição para acessá-lo: "http://localhost:8080/projecao/log"

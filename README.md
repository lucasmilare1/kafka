<h1 align="center">Apache Kafka</h1>


O Apache Kafka é uma plataforma de streaming distribuída desenvolvida para lidar com fluxos de dados em tempo real de forma escalável, durável e tolerante a falhas. Ele foi originalmente desenvolvido pelo LinkedIn e posteriormente tornou-se um projeto de código aberto mantido pela Apache Software Foundation.

Kafka é projetado para lidar com uma variedade de casos de uso, desde simples pipelines de dados até aplicativos de streaming sofisticados. Ele permite que os desenvolvedores publiquem, armazenem e processem fluxos de dados em tempo real em larga escala.

Principais conceitos do Kafka incluem:

✅ Tópicos: Canais de comunicação que representam fluxos de dados.
<h1></h1>
✅ Partições: Divisões de tópicos que permitem a distribuição paralela de dados.
<h1></h1>
✅ Produtores: Aplicativos que publicam mensagens em tópicos.
<h1></h1>
✅ Consumidores: Aplicativos que recebem mensagens de tópicos.
<h1></h1>
✅ ZooKeeper: Sistema de coordenação distribuída usado para gerenciar e coordenar os nós do Kafka.
<h1></h1>
O Kafka oferece várias garantias de processamento de mensagens, como persistência de dados em disco e replicação para tolerância a falhas. Sua arquitetura distribuída permite escalabilidade horizontal, permitindo que os clusters Kafka cresçam conforme a demanda.

<h2 align="center">Finalidade do projeto</h2>
Este simples projeto tem como objetivo compreender e aprofundar o conhecimento em mensageria com kafka

<h2 align="center">Como executar em sua maquina ?</h2>

1º - Clone o projeto em sua maquina


2º - Navegue no terminal até o diretório onde o projeto foi clonado.


3º - No terminal, execute o comando. ``` docker compose up -d ```  


4º - Após o êxito do build do docker compose, crie o seu tópico Kafka com o seguinte comando no terminal:
      ``` docker-compose exec broker kafka-topics --create \
    --bootstrap-server broker:9092 \
    --topic eventRegister \
    --partitions 3 \
    --replication-factor 1 ```

5º - Em sua IDE, execute a classe ```ApplicationConsumer``` que está dentro do modulo ```kafka-consumer```, a mesma é responsavel por receber as mensagens que estão no seu topico ```eventRegister```

6º - No modulo ```kafka-producer``` execute a classe ```ApplicationProducer``` ela eviará uma mensagem concatenada da data atual com um UUID para o tópico ```eventRegister``` e a mesma vai ser consumida pelo ```ApplicationConsumer```.
Exemplo de response:
![image](https://github.com/lucasmilare1/kafka/assets/65171151/8d20551c-b930-421e-be70-514f7c0bad01)


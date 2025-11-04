# Atividade Prática: Comparação de Desempenho entre Modelos de Threads N:M e 1:1
- **Disciplina:** Performance em Sistemas Ciberfísicos
- **Instituição:** Pontifícia Universidade Católica do Paraná    
- **Professor:** Andrey Cabral Meira
- **Alunos:**
  - Bruno Danguy Bortolini — [@snowpuf](https://github.com/snowpuf)   
  - Victor Augusto Esmaniotto — [@Vitinnn123](https://github.com/Vitinnn123)  
---

## Objetivo
O objetivo dessa atividade é comparar o desempenho entre os modelos de threads N:M e 1:1 em Java, analisando como o mapeamento de múltiplas threads de usuário para threads do sistema operacional influencia o tempo total de execução e a eficiência na execução concorrente de tarefas.

---

## Estrutura do Projeto

```
/Atividade Comparação Threads
└── README.md (Documentação da Atividade)
  /Código completo
  ├──TarefaTeste.java
  ├──Threads1pra1.java
  └──ThreadsNM.java
```

---

## Relatório Crítico — Comparação de Modelos de Threads (1:1 vs N:M)

### Desempenho
O modelo **N:M foi bem mais rápido**, principalmente quando a carga aumentou.  
Enquanto o **1:1** piorou o tempo com muitas threads, o **N:M** manteve o desempenho praticamente constante.
Isso acontece porque o **1:1** depende totalmente do sistema operacional pra gerenciar cada thread e isso gera muito **overhead** (criação, agendamento e troca de contexto).  
Já o **N:M** gerencia várias tarefas dentro de poucas threads do sistema, o que torna tudo mais leve e eficiente.

---

### Escalabilidade
O **N:M escala muito melhor**.  
Mesmo com 1000 tarefas, o tempo não aumentou.  
O **1:1**, por outro lado, começa a sofrer quando passa de algumas centenas de threads, porque o sistema simplesmente não lida bem com tantas ao mesmo tempo.

---

### Overhead e Eficiência
O modelo N:M tem **baixo consumo de recursos** e **alta eficiência**.  
O 1:1 é mais simples, mas paga caro por isso: cada thread extra significa mais custo pro sistema gerenciar.
Um ponto curioso é que o 1:1 foi mais rápido com 100 threads do que com 10 isso provavelmente é porque, com poucas threads, ainda não havia paralelismo suficiente pra saturar a CPU.  
Mas quando passa de 100, o contexto começa a “trocar demais” e o ganho vai embora.

---

### Estabilidade
O **N:M** mostrou um comportamento muito mais **estável e previsível**.  
Ele se mantém constante mesmo com muitas tarefas simultâneas, o que é ideal pra sistemas que trabalham com alta concorrência (como servidores, apps de rede, etc).

---

## Conclusão

| Aspecto | N:M | 1:1 |
|:--|:--|:--|
| **Tempo médio** | Mais rápido | Mais lento |
| **Escalabilidade** | Alta | Limitada |
| **Overhead** | Baixo | Alto |
| **Uso de recursos** | Eficiente | Exagerado |
| **Ideal para** | Muitas tarefas pequenas | Poucas tarefas pesadas |

- O **N:M** é ideal quando o sistema precisa lidar com **muitas tarefas pequenas e simultâneas** (ex: servidores web, processamento assíncrono, I/O concorrente).  
- O **1:1** ainda tem valor em casos que exigem **isolamento total** entre threads ou quando o número delas é previsível e pequeno.  
- É por isso que muitas linguagens modernas (como **Go** e **Erlang**) adotam estratégias parecidas com o modelo **N:M** justamente por essa eficiência e escalabilidade.

---

## Gráficos

**Modelo N:M**
Threads do Sistema (M): 10
Iterações por Tarefa: 1000000
| Nº de Tarefas  | Tempo Total (ms) |
| -----------------: | ----------: |
|                 10 |          15 |
|                100 |           9 |
|                500 |           2 |
|               1000 |           2 |



  **Modelo 1:1** 
  Iterações por Thread: 1000000
| Nº de Threads | Tempo Total (ms) |
| ------------: | ---------------: |
|            10 |               41 |
|           100 |                7 |
|           500 |               32 |
|          1000 |               60 |

---

## Licença

Este projeto foi desenvolvido **exclusivamente para fins educacionais** na disciplina de *Performance em Sistemas Ciberfísicos* da Pontifícia Universidade Católica do Paraná.
Não possui finalidade comercial e não concede direitos de uso além do contexto acadêmico.



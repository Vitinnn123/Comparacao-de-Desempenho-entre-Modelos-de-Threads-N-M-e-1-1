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



---

## Licença

Este projeto foi desenvolvido **exclusivamente para fins educacionais** na disciplina de *Performance em Sistemas Ciberfísicos* da Pontifícia Universidade Católica do Paraná.
Não possui finalidade comercial e não concede direitos de uso além do contexto acadêmico.


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


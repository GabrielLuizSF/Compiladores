# Compiladores

## História
- Linguagem de Máquina foi rapidamente substituída para Linguagem de Montagem.
 - Instruções e Endereços de memória adotam uma forma simbólica.

```bash

MOV X , 2 => X é 0000

```
## Vantagens (Linguagem de Montagem)

- Mais "fácil de programar".
- Aumenta a velocidade e precisão em que os programas são escritos.
- Ainda são utilizadas.

## Desvantagens (Linguagem de Montagem)

- Dependente da máquina
- Não é facil de escrever
- Difícil de entender

## Finalmente Linguagem de Alto Nível = + Produtividade

- Mais semelhante com a notação matemática ou linguagem natural.

```bash

x = 2

```

- Primeiros compiladores começaram a surgir no ínicio dos anos 50
- Diversos experimentos e implementações realizados independentemente
- Trabalhos iniciais: tradução de fórmulas aritiméticas em código de máquina.
- Compiladores eram considerados difíceis de construir.

## Exigências da compilação

- Tem que gerar código correto
- Ser capaz de tratar softwares de qualquer tamanho
- Velocidade de compilação(não é obrigatório)
- Tamanho do compilador não é mais um problema

- User-Friendliness se mede pela qualidade das mensagens de erros;
- A importância da velocidade e do tamanho do código gerado depende do propósito do compilador - velocidade vem em primeiro lugar.

## E as linguagens funcionais?

- Linguagens funcionais (LISP) e lógicas (Prolog) requerem técnicas diferentes.

1- Em geral são interpretadas

2- Abstração ao máximo

3- Sobrecarregar o interpretador de funções

## Estrutura dos processos do Compilador

<img src="https://github.com/GabrielLuizSF/Compiladores/blob/main/example/png/Compilador.drawio.png"></img>
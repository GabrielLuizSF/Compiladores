# Análise Léxica

- Primeira Etapa de um Compilador

## Função

- Ler o arquivo com código 
- Indentificar os tokens correspondentes
- Relatar erros.

## Exemplos de tokens:

- Indentificadores
- Palavras reservadas e símbolos especiais
- Números


### Exemplo:

```pascal

x := y * 2

```

### Fragmento de Gramática

```c

cmd => if expr then cmd

expr => termo relop termo / termo

termo => id | num
```

#### Regras de Formação de Itens Léxicos:

```c

if    => if
then  => then
else  => else
relop => <| <= | = | <> | > | >=
id    => letra(letra | digito)*
num   => digito*(.digito+)?(E(+|-)?digito*)?

```

### Analisador Léxico 

#### Deve ser subordinado ao analisador sintático:

- Sub-rotina do analisador sintático: a cada chamada, o analisador léxico retorna para o analisador sintático uma cadeia lida e o token correspondente.

- O Analisador Sintático combina os tokens e verifica a boa formação da (sintaxe) do código-fonte  usando a gramática da linguagem

#### Exemplo:

<img src="https://github.com/GabrielLuizSF/Compiladores/blob/main/example/png/Analisador_L%C3%A9xico.drawio.png"></img>


----

## Expressões Regulares

### Determinam conjuntos de cadeias válidas:

- Linguagem

### Exemplos:

- Identificador: letra(letra | dígito)*
- Número inteiro  sem sinal: dígito+
- Número inteiro com sinal: (+ | -)dígito+



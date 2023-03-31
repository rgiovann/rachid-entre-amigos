<h3>RACHID ENTRE AMIGOS</h3>

#### Este programa feito em Java calcula os valores que devem ser pagos entre amigos em uma situação que os pagamentos não são realizados pela mesma pessoa. Mas a soma de todos os pagamentos devem ser rachados entre partes iguais.

#### Exemplo:

#### 3 amigos, João, José, Mário resolvem acertar contas pagas por diferentes pessoas:

| Pagamento | Pessoa  | Valor     |
| --------- | ------- | --------- |
| PGTO 1    | Antônio | R$ 170,00 |
| PGTO 2    | José    | R$ 75,00  |
| PGTO 3    | José    | R$ 25,00  |

#### Ao final das contas em relação aos pagamentos:

#### - Antônio tem a receber 2/3 de 170 reais, mas a pagar 1/3 de 75 e 25 reais.

#### - Jose tem a receber 2/3 de 75 reais e 25 reais mas tem que pagar 1/3 de 170 reais

#### - Mário tem que pagar 1/3 de 170, 75 e 25 reais e tem nada a receber.

#### Logo Antônio precisa receber 56,67 reais de Mário e (56-33,33) = 23,33 reais de José.

#### E José precisa receber 33,33 reais de Mário.

#### Abaixo segue um print screen do programa exibindo o mesmo resultado. Este programa não tem a função de calcular o valor da contas de amigos tomando uma cerveja no bar pois o pagamento é único. É mais apropriado para um cenário onde um grupo de pessoas (sócios de uma empresa, irmãos) realizam pagamentos independentes e no final equalizam os valores a receber e a pagar de forma que todos paguem o mesmo valor.

![print screen](https://github.com/rgiovann/image-repo/blob/main/PRINT_SCREEN1.jpg)

#### O programa calcula os valores para qualquer número de pessoas maiores ou iguais a 2. Para encerrar o número de pessoas a fazer o rachid digite END ou a tecla ENTER, mesma coisa para os pagamentos.

#### Para executar o programa execute o comando:
```sh
java -jar rachid_v1.jar
```

package rachid.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import rachid.entities.Pagamento;
import rachid.entities.Pessoa;

public class Application {

    public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";

    public Application()
	{
	    // TODO Auto-generated constructor stub
	}

    public static void main(String[] args)
	{
	    System.setProperty("file.encoding", "ISO-8859-1");
	    Locale.setDefault(Locale.getDefault());
	    Scanner sc = new Scanner(System.in);
	    List<Pagamento> listaPagamentos = new ArrayList<>();
	    String nomePessoa = "";
	    String descricao = "";
	    Map<String, Pessoa> listaPessoas = new HashMap<String, Pessoa>();
	    List<String> nomeDasPessoas = new ArrayList<String>();
	    double valor = 0;

	    System.out.print("*** SISTEMA RACHID Para finalizar os cadastros digite END ou tecla <ENTER> ***\n\n");

	    System.out.print("***CADASTRO DAS PESSOAS A FAZEREM PARTE DO RACHID***\n\n");

	    while (true)
		{
		    System.out.print("Entre com o nome das pessoas que vão fazer o rachid [até 5 letras]: ");

		    nomePessoa = sc.nextLine();

		    if (nomePessoa.equals("END") || nomePessoa.isBlank())
			{
			    break;
			}

		    if (nomePessoa.length() > 5)
			{
			    System.out.print("Atenção, nome da pessoa com mais de 5 letras!\n");

			} else if (listaPessoas.containsKey(nomePessoa))
			{

			    System.out.print("Atenção, você ja informou o nome desta pessoa!\n");

			} else if (!nomePessoa.isBlank())
			{
			    listaPessoas.put(nomePessoa, new Pessoa(nomePessoa));
			    nomeDasPessoas.add(nomePessoa);
			}

		}

	    String tokenPessoas = "[";
	    String barra = "";
	    for (Map.Entry<String, Pessoa> entry : listaPessoas.entrySet())
		{
		    String key = entry.getKey();
		    tokenPessoas = tokenPessoas + barra + key;
		    barra = "/";
		    listaPessoas.get(key).inicializaMap(nomeDasPessoas);
		}

	    if (!listaPessoas.isEmpty())

		{
		    System.out.print("\n\n***CADASTRO DE PAGAMENTOS***\n\n");

		    while (true)
			{

			    System.out.print("Entre quem pagou " + tokenPessoas + " *case sensitive* ] : ");

			    nomePessoa = sc.nextLine();

			    if (nomePessoa.equals("END") || nomePessoa.isBlank())
				{
				    break;
				}
			    if (listaPessoas.get(nomePessoa) != null)
				{
				    System.out.print("Entre com a descrição do pagamento: ");

				    descricao = sc.nextLine();

				    System.out.print("Entre com o valor do pagamento: ");

				    valor = sc.nextDouble();

				    sc.nextLine();

				    listaPagamentos.add(new Pagamento(valor, descricao, nomePessoa));

				} else
				{
				    System.out.print("Atenção, você não informou este nome no cadastro de pessoas!\n");

				}

			}
		}

	    sc.close();

	    if (!listaPagamentos.isEmpty())
		{
		    for (Pagamento pgto : listaPagamentos)
			{
			    nomePessoa = pgto.getQuemPagou();

			    // Na lista de entidades pessoas, identifica as pessoas que não realizaram o
			    // pagamento e atualiza o quanto deve à pessoa que pagou
			    for (Map.Entry<String, Pessoa> entry : listaPessoas.entrySet())
				{
				    String key = entry.getKey();
				    // essa pessoa realizou pagamento,não está devendo nada,
				    // atualiza valores a pagar para as outras pessoas
				    if (!nomePessoa.equals(key))
					{
					    listaPessoas.get(key).atualizaValoresQueDevoPagar(nomePessoa,
						    pgto.getValor() / listaPessoas.size());
					}

				}

			}

		    System.out.print("\n***LISTA DE PAGAMENTOS EFETUADO***\n\n");
		    for (Pagamento pgto : listaPagamentos)
			{
			    System.out.println(pgto);
			}

		    System.out.print("\n***RACHID CONSOLIDADO***\n\n");

		    // processa valores a receber
		    for (String p : nomeDasPessoas)
			{

			    for (Map.Entry<String, Pessoa> entry : listaPessoas.entrySet())
				{
				    double valorAReceber;
				    String key = entry.getKey();
				    Pessoa value = entry.getValue();
				    if (!p.equals(key))
					{
					    valorAReceber = value.getaPagar().get(p); // verifico o quanto tenho que
										      // pagar
					    listaPessoas.get(p).getaReceber().put(key, valorAReceber); // atualizo o a
												       // receber
												       // da pessoa

					}
				}
			}

		    // imprime valores devidos
		    for (String p : nomeDasPessoas)
			{

			    for (Map.Entry<String, Pessoa> entry : listaPessoas.entrySet())
				{
				    String key = entry.getKey();
				    Pessoa value = entry.getValue();

				    if (!p.equals(key))
					{
					    double aReceber = value.getaPagar().get(p);
					    double aPagar;
					    aPagar = listaPessoas.get(p).getaPagar().get(key);
					    double valorConsolidado = aPagar - aReceber;
					    if (valorConsolidado > 0)
						{
						    System.out.printf(p + " deve a " + key + " o valor de R$ %.2f \n",
							    valorConsolidado);
						} else if (valorConsolidado < 0)
						{
						    System.out.printf(key + " deve a " + p + " o valor de R$ %.2f \n",
							    -1 * valorConsolidado);
						} else
						{
						    System.out.printf(p + " e " + key + " estão quites\n");
						}

					}
				}

			    listaPessoas.remove(p);

			}
		}
	    System.out.println("\nPROGRAMA FINALIZADO\n");

	}
}

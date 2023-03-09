package rachid.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private Map<String, Double> aPagar = new HashMap<String, Double>();
    private Map<String, Double> aReceber = new HashMap<>();

    public Pessoa(String nome)
	{
	    super();
	    this.nome = nome;
	}

    public void atualizaValoresQueDevoPagar(String nome, double valor)
	{
	    double valorAtual = this.aPagar.get(nome);
	    this.aPagar.put(nome, valorAtual + valor);
	}

    public void atualizaValoresQueDevoReceber(String nome, double valor)
	{
	    double valorAtual = this.aReceber.get(nome);
	    this.aReceber.put(nome, valorAtual + valor);
	}

    public void inicializaMap(List<String> nomeDasPessoas)
	{
	    for (String nome : nomeDasPessoas)
		{
		    if (!nome.equals(this.nome))
			{
			    this.aPagar.put(nome, 0.0);
			}
		}
	}

    @Override
    public int hashCode()
	{
	    return Objects.hash(this.nome);
	}

    @Override
    public boolean equals(Object obj)
	{
	    if (this == obj)
		{
		    return true;
		}
	    if (obj == null)
		{
		    return false;
		}
	    if (this.getClass() != obj.getClass())
		{
		    return false;
		}
	    Pessoa other = (Pessoa) obj;
	    return Objects.equals(this.nome, other.nome);
	}

    public String getNome()
	{
	    return this.nome;
	}

    public void setNome(String nome)
	{
	    this.nome = nome;
	}

    public Map<String, Double> getaPagar()
	{
	    return this.aPagar;
	}

    public Map<String, Double> getaReceber()
	{
	    return this.aReceber;
	}

}

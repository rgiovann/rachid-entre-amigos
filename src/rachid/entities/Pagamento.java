package rachid.entities;

import java.util.Objects;

public class Pagamento {
    private double valor = 0;
    private String descricao = null;
    private String quemPagou = null;

    public Pagamento(double valor, String descricao, String quemPagou)
	{
	    super();
	    this.valor = valor;
	    this.descricao = descricao;
	    this.quemPagou = quemPagou;
	}

    public double getValor()
	{
	    return this.valor;
	}

    public void setValor(double valor)
	{
	    this.valor = valor;
	}

    public String getDescricao()
	{
	    return this.descricao;
	}

    public void setDescricao(String descricao)
	{
	    this.descricao = descricao;
	}

    public String getQuemPagou()
	{
	    return this.quemPagou;
	}

    public void setQuemPagou(String quemPagou)
	{
	    this.quemPagou = quemPagou;
	}

    @Override
    public int hashCode()
	{
	    return Objects.hash(this.quemPagou);
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
	    Pagamento other = (Pagamento) obj;
	    return Objects.equals(this.quemPagou, other.quemPagou);
	}

    @Override
    public String toString()
	{
	    return "Pagamento [valor=" + this.valor + ", descricao=" + this.descricao + ", quemPagou=" + this.quemPagou
		    + "]";
	}

}

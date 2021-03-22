package entities;

import java.util.Calendar;
import java.util.Date;

public class LancamentoVenda {
    private double valor;
    private int nParcela;
    private Date dataVencimento;
    private Venda venda;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getnParcela() {
        return nParcela;
    }

    public void setnParcela(int nParcela) {
        this.nParcela = nParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public LancamentoVenda(double valor, int nParcela, Date dataVencimento, Venda venda) {
        this.valor = valor;
        this.nParcela = nParcela;
        this.dataVencimento = dataVencimento;
        this.venda = venda;
    }
}

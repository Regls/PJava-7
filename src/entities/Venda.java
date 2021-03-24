package entities;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Venda {

    private int QuantidadedeParcelas;
    private double ValorTotal;
    private int id;
    private String dataHoraAtual;
    private Cliente cliente;

    List<LancamentoVenda> lancamentoVendas = new ArrayList<>();

    public int getQuantidadedeParcelas() {
        return QuantidadedeParcelas;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double valorTotal) {
        ValorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda(int quantidadedeParcelas, double valorTotal, int id, Cliente cliente, String dataHoraAtual) {
        this.QuantidadedeParcelas = quantidadedeParcelas;
        this.ValorTotal = valorTotal;
        this.id = id;
        this.cliente = cliente;
        this.dataHoraAtual = dataHoraAtual;
    }
    public String toString() {
        return "\nVenda do cliente " +cliente.getName()+ " ## Quantidade de Parcelas " +QuantidadedeParcelas+
                ", Valor Total: " +ValorTotal+ ", ID da Venda: " +id+ ", Data e Hora Atual: "+dataHoraAtual;
    }
    public List<LancamentoVenda> getLancamentoVendas(){
        return lancamentoVendas;
    }
    public void lancarVenda(){
        double valor = getValorTotal() / getQuantidadedeParcelas();
        Calendar calendar = Calendar.getInstance();
        int hoje = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, getCliente().getDiaVencimento());

        if (hoje > cliente.getDiaVencimento()){
            calendar.add(Calendar.MONTH, 1);
        }
        int i;
        for (i=0; i<QuantidadedeParcelas; i++){
            LancamentoVenda lancamentoVenda = new LancamentoVenda(valor, i+1, calendar.getTime(), this);
            lancamentoVendas.add(lancamentoVenda);
            calendar.add(Calendar.MONTH, 1);
        }
    }
}

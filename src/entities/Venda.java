package entities;

import java.util.ArrayList;
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
        return "Venda do cliente " +cliente.getName()+ " ## Quantidade de Parcelas " +QuantidadedeParcelas+
                ", Valor Total: " +ValorTotal+ ", ID da Venda: " +id+ ", Data e Hora Atual: "+dataHoraAtual;
    }
    public List<LancamentoVenda> getLancamentoVendas(){
        return lancamentoVendas;
    }
}

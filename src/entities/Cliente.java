package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {

    private String name;
    private String cpf;
    private int diaVencimento;
    private int id;
    private final List<Venda> vendas = new ArrayList<>();

    public void adicionarVenda(Venda venda){
        vendas.add(venda);
    }

    public void excluirVenda(Venda venda){
        vendas.remove(venda);
    }

    public Cliente(String name, String cpf, int diaVencimento, int id) {
        this.name = name;
        this.cpf = cpf;
        this.diaVencimento = diaVencimento;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Cliente ## NOME: " +name+ ", CPF: " +cpf+ ", Dia Vencimento: " +diaVencimento+ ", ID: "+id;
    }

    public List<Venda> getVendas() {
        return vendas;
    }
}

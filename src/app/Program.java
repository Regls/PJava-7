package app;

import java.text.DateFormat;
import java.util.*;

import entities.Cliente;
import entities.LancamentoVenda;
import entities.Venda;


public class Program {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);
        Date hoje = new Date();
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);

/*
        Cliente c1 = new Cliente("Renan", "02312", 15, 34);
        Venda venda = new Venda(4, 400, 34, c1, DateFormat.getInstance().format(hoje));
        c1.adicionarVenda(venda);
        System.out.println(c1);
        System.out.println(c1.getVendas());
        System.out.printf("Lancamentos da Venda (ID: %d) \n\n", venda.getId());
        double precodiv = venda.getValorTotal() / venda.getQuantidadedeParcelas();
        if (dia < c1.getDiaVencimento()) {
            for (int i = 0; i < venda.getQuantidadedeParcelas(); i++) {
                System.out.printf("- Lancamento %d -\n", i + 1);
                System.out.printf("Valor: %.2f\n", precodiv);
                System.out.printf("Parcela Nº%d\n", i + 1);
                System.out.printf("Data Vencimento: %d/%d/%d\n\n", c1.getDiaVencimento(), mes + 1,
                        data.get(Calendar.YEAR));
                mes++;
            }
        } else {
            mes++;
            for (int i = 0; i < venda.getQuantidadedeParcelas(); i++) {
                System.out.printf("- Lancamento %d -\n", i + 1);
                System.out.printf("Valor: %.2f\n", precodiv);
                System.out.printf("Parcela Nº%d\n", i + 1);
                System.out.printf("Data Vencimento: %d/%d/%d\n\n", c1.getDiaVencimento(), mes + 1,
                        data.get(Calendar.YEAR));
                mes++;
            }
        }

 */
        List<Cliente> listClientes = new ArrayList<>();

        System.out.println("Número de cadastro de clientes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Nome do cliente: ");
            String name = sc.nextLine();
            System.out.println("CPF do cliente: ");
            String cpf = sc.nextLine();
            System.out.println("Dia do vencimento: ");
            int diaVencimento = sc.nextInt();
            cal.set(Calendar.DAY_OF_MONTH, diaVencimento);
            System.out.println("Id do cliente: ");
            int id = sc.nextInt();

            Cliente clientes = new Cliente(name, cpf, diaVencimento, id);

            listClientes.add(clientes);
        }
        System.out.println();
        System.out.println("Lista dos Clientes:");
        for (Cliente clientes : listClientes) {
            System.out.println(clientes);
        }
        System.out.println("Digite o ID do cliente para acessar suas vendas: ");
        int id = sc.nextInt();
        for (Cliente cliente : listClientes) {
            if (id == cliente.getId()) {
                System.out.println("Vendas do Cliente:");
                System.out.println(cliente.getVendas());
                System.out.println("Deseja adicionar vendas? (y/n)");
                sc.nextLine();
                String resp = sc.nextLine();
                if (resp.equals("y")) {
                    System.out.println("Quantas vendas para adicionar: ");
                    int qtd = sc.nextInt();
                    for (int i = 0; i < qtd; i++) {
                        System.out.println("Quantidade de parcelas: ");
                        int qtdP = sc.nextInt();
                        System.out.println("Valor Total: ");
                        double vL = sc.nextDouble();
                        System.out.println("ID da Venda: ");
                        int idV = sc.nextInt();

                        Venda newVenda = new Venda(qtdP, vL, idV, cliente, DateFormat.getInstance().format(hoje));
                        cliente.adicionarVenda(newVenda);
                    }
                } else {
                    break;
                }
                System.out.println(cliente.getVendas());
                System.out.println();
                System.out.println("Selecione o ID da Venda para acessar seus lançamentos: ");
                int idV = sc.nextInt();
                System.out.println("Lançamentos dessa venda: ");
                for (Venda venda : cliente.getVendas()) {
                    if (idV == venda.getId()) {
                        venda.lancarVenda();
                        System.out.println(venda.getLancamentoVendas());
                    }
                        /*
                        if (dia < cliente.getDiaVencimento()) {
                            for (int i = 0; i < venda.getQuantidadedeParcelas(); i++) {
                                System.out.printf("- Lancamento %d -\n", i + 1);
                                System.out.printf("Valor: %.2f\n", venda.getValorTotal() /
                                        venda.getQuantidadedeParcelas());
                                System.out.printf("Parcela Nº%d\n", i + 1);
                                System.out.printf("Data Vencimento: %d/%d/%d\n\n",
                                        cliente.getDiaVencimento(), mes + 1, cal.get(Calendar.YEAR));
                                mes++;
                            }
                        } else {
                            mes++;
                            for (int i = 0; i < venda.getQuantidadedeParcelas(); i++) {
                                System.out.printf("- Lancamento %d -\n", i + 1);
                                System.out.printf("Valor: %.2f\n", venda.getValorTotal() /
                                        venda.getQuantidadedeParcelas());
                                System.out.printf("Parcela Nº%d\n", i + 1);
                                System.out.printf("Data Vencimento: %d/%d/%d\n\n",
                                        cliente.getDiaVencimento(), mes + 1, cal.get(Calendar.YEAR));
                                mes++;
                            }
                        }
                    }

                         */
                }
            }
        }
        System.out.println("Digite um mês especifico para retornar os lançamentos deste mês: ");
        int mesEsp = sc.nextInt();
        for (Cliente cliente : listClientes) {
            for (Venda venda : cliente.getVendas()) {
                for (LancamentoVenda lancamentoVenda : venda.getLancamentoVendas()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(lancamentoVenda.getDataVencimento());
                    if (calendar.get(Calendar.MONTH)+1 == mesEsp) {
                        System.out.println(lancamentoVenda);
                    }
                }
            }
        }
        System.out.println("Digite um dia especifico para retornar as vendas deste dia: ");
        int diaEsp = sc.nextInt();
        for (Cliente cliente : listClientes){
            for (Venda venda : cliente.getVendas()){
                if (cal.get(Calendar.DAY_OF_MONTH) == diaEsp){
                    System.out.println(venda);
                }
            }
        }
        sc.close();
    }
}



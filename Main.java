import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor do Empréstimo: ");
        double GetValorEmprestimo = Double.parseDouble(scanner.nextLine().trim());
        while (GetValorEmprestimo < 0) {
            System.out.print("[ERROR] Digite um valor válido: ");
            GetValorEmprestimo = Double.parseDouble(scanner.nextLine().trim());
        }
        String GetClass = GetValorEmprestimo > 10_000 ? "Rico" : "Pobre";
        System.out.println("Voce é " + GetClass);
        System.out.print("Taxa de juros anual: ");
        float GetTaxaJurosAnual =  Float.parseFloat(scanner.nextLine().trim());
        System.out.print("Periodo (Anos): ");
        double GetPeriodoAnos =  Double.parseDouble(scanner.nextLine().trim());
        double TaxaJurosMensal = (GetTaxaJurosAnual/(byte)100)/(byte)12;
        double PeriodoMes = GetPeriodoAnos * (byte)12;
        //double PrimeiroResultado = Math.pow((1 + TaxaJurosMensal), PeriodoMes);
        // double SegundoResultado = Math.pow((1 + TaxaJurosMensal), PeriodoMes);
        // double FinalResultado = (TaxaJurosMensal*PrimeiroResultado)/(SegundoResultado - 1);
        double Mortgage = GetValorEmprestimo*(TaxaJurosMensal*(Math.pow(((byte)1 + TaxaJurosMensal), PeriodoMes))/((Math.pow(((byte)1 + TaxaJurosMensal), PeriodoMes)) - (byte)1));
        String MortgageCurrency = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage: " + MortgageCurrency);
    }
}
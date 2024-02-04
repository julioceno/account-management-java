import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Entre com os dados da conta: ");
            System.out.print("Número: ");
            Integer number = sc.nextInt();
            sc.nextLine();
            System.out.print("Titular da conta: ");
            String holder = sc.next();
            sc.nextLine();
            System.out.print("Depósito inicial: ");
            Double initialBalance = sc.nextDouble();
            sc.nextLine();
            System.out.print("Valor máximo de saque: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println("\n");
            System.out.print("Quanto deseja retirar de sua conta?: ");
            Double withdraw = sc.nextDouble();
            account.withdraw(withdraw);

            System.out.println(account.toString());
        }
        catch (DomainException e) {
            System.out.println("Erro no saque: "+ e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Ocorreu algum erro inesperado");
        }

        sc.close();
    }
}
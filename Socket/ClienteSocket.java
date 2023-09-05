package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Esta classe representa o cliente socket para enviar mensagens para o servidor.
 */

public class ClienteSocket {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        String texto;
        Socket cliente = null;
        PrintStream saida;

        try {
            cliente = new Socket("192.168.100.34", 7000);
            saida = new PrintStream(cliente.getOutputStream());

            // Thread para receber mensagens do servidor
            Thread threadReceber = new Thread(new ReceberMensagens(cliente));
            threadReceber.start();

            do {
                texto = entrada.nextLine();
                saida.println(texto);
            } while (!"sair".equals(texto));
        } catch (IOException e) {
            System.out.println("Algo errado aconteceu");
        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }
}

class ReceberMensagens implements Runnable {
    private final Socket cliente;

    public ReceberMensagens(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String mensagem;

            while ((mensagem = entrada.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException e) {
            System.out.println("Erro ao receber mensagem do servidor: " + e.getMessage());
        }
    }
}

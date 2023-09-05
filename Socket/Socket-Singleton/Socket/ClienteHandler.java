package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClienteHandler implements Runnable {
    private Socket conexao;
    private List<Socket> conexoes;

    public ClienteHandler(Socket conexao, List<Socket> conexoes) {
        this.conexao = conexao;
        this.conexoes = conexoes;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            do {
                String texto = entrada.readLine();
                if (texto == null || "sair".equals(texto)) {
                    break;
                }

                String nomeUsuario = ServidorSocket.socketToUserMap.get(conexao);
                System.out.println("Mensagem recebida de " + nomeUsuario + ": " + texto);

                for (Socket cliente : conexoes) {
                    if (cliente != conexao) {
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
                        writer.println(nomeUsuario + ": " + texto);
                        writer.flush();
                    }
                }
            } while (true);
        } catch (IOException e) {
            System.out.println("Erro ao processar mensagem do cliente: " + e.getMessage());
        } finally {
            try {
                conexao.close();
                conexoes.remove(conexao);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

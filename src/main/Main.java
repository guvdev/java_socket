package main;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Digite o endereço (ex: www.google.com.br): ");
            String endereco = teclado.nextLine();

            System.out.print("Digite a porta (ex: 80): ");
            int porta = teclado.nextInt();

            System.out.println("Conectando em " + endereco + " na porta " + porta + "...");
            Socket conexao = new Socket(endereco, porta);

            PrintWriter enviar = new PrintWriter(conexao.getOutputStream(), true);

            BufferedReader receber = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            enviar.println("GET / HTTP/1.0\n");

            String resposta;
            while ((resposta = receber.readLine()) != null) {
                System.out.println(resposta);
            }

            receber.close();
            enviar.close();
            conexao.close();
            teclado.close();

        } catch (IOException e) {
            System.out.println("Erro de comunicação: " + e.getMessage());
        }
    }
}

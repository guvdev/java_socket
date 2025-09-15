/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.java.search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class NavegadorSimples extends JFrame {

    private JTextField enderecoTxt;
    private JEditorPane editorPagina;

    public NavegadorSimples() {
        super("Navegador Simples");

        enderecoTxt = new JTextField("https://stackoverflow.com", 30);
        JButton abrirBtn = new JButton("Abrir");
        JButton fecharBtn = new JButton("Fechar");

        editorPagina = new JEditorPane();
        editorPagina.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPagina);

        JPanel painelSuperior = new JPanel();
        painelSuperior.add(enderecoTxt);
        painelSuperior.add(abrirBtn);
        painelSuperior.add(fecharBtn);

        add(painelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        abrirBtn.addActionListener(e -> {
            try {
                editorPagina.setPage(new URL(enderecoTxt.getText()));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao abrir a página: " + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        fecharBtn.addActionListener(e -> System.exit(0));

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NavegadorSimples::new);
    }
}

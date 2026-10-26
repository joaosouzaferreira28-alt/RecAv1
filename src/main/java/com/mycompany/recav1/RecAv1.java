/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recav1;

import javax.lang.model.SourceVersion;

/**
 *
 * @author guest-rq76am
 */
public class RecAv1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_26;
    }
}





public class RecAv1 extends JFrame {

    private JTextField lado1 = new JTextField("6");
    private JTextField lado2 = new JTextField("6");
    private JTextField lado3 = new JTextField("6");

    public RecAv1() {
        setTitle("Verificar Triangulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        painel.add(new JLabel("Lado 1:"));
        painel.add(lado1);

        painel.add(new JLabel("Lado 2:"));
        painel.add(lado2);

        painel.add(new JLabel("Lado 3:"));
        painel.add(lado3);

        JButton verificar = new JButton("Verificar Tipo");
        painel.add(new JLabel(""));
        painel.add(verificar);

        add(painel);

        verificar.addActionListener(e -> verificarTriangulo());
    }

    private void verificarTriangulo() {
        try {
            double a = Double.parseDouble(
                lado1.getText().trim().replace(',', '.')
            );
            double b = Double.parseDouble(
                lado2.getText().trim().replace(',', '.')
            );
            double c = Double.parseDouble(
                lado3.getText().trim().replace(',', '.')
            );

            if (a <= 0 || b <= 0 || c <= 0) {
                mostrar("Os lados devem ser maiores que zero.");
            } else if (a + b <= c || a + c <= b || b + c <= a) {
                mostrar("As medidas nao formam um triangulo.");
            } else if (a == b && b == c) {
                mostrar("Triangulo EQUILATERO!");
            } else if (a == b || a == c || b == c) {
                mostrar("Triangulo ISOSCELES!");
            } else {
                mostrar("Triangulo ESCALENO!");
            }

        } catch (NumberFormatException erro) {
            mostrar("Digite numeros validos nos tres campos.");
        }
    }

    private void mostrar(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RecAv1().setVisible(true);
        });
    }
}

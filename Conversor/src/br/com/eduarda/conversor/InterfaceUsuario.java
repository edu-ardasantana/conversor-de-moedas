package br.com.eduarda.conversor;

import javax.swing.JOptionPane;

public class InterfaceUsuario {
    
	public static void main(String[] args) {
        exibirOpcoes();
    }

    public static void exibirOpcoes() {
        String[] opcoes = {"Converter Moeda", "Converter Temperatura", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Conversor", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                ConversorMoeda.mostrarMenu();
                break;
            case 1:
                ConversorTemperatura.mostrarMenu();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Até logo!", "Conversor", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
    }
	
}

package br.com.eduarda.conversor;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.swing.JOptionPane;

	public class ConversorMoeda {

	    public static void mostrarMenu() {
	        Moeda[] moedas = Moeda.values();
	        String[] opcoesMoedas = new String[moedas.length];
	        for (int i = 0; i < moedas.length; i++) {
	            opcoesMoedas[i] = moedas[i].getNome();
	        }

	        while (true) {
	            String escolhaMoeda = (String) JOptionPane.showInputDialog(
	                    null, 
	                    "Escolha a convers�o:", 
	                    "Conversor de Moeda",
	                    JOptionPane.QUESTION_MESSAGE, 
	                    null, 
	                    opcoesMoedas, 
	                    opcoesMoedas[0]);

	            if (escolhaMoeda == null) {
	                
	                JOptionPane.showMessageDialog(null, "Programa conclu�do", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
	                return;
	            }

	            double valorEntrada = 0.0;

	            
	            while (true) {
	                String input = JOptionPane.showInputDialog("Digite o valor a ser convertido:");
	                try {
	                    
	                    valorEntrada = Double.parseDouble(input);
	                    break; 
	                } catch (NumberFormatException e) {
	                    
	                    JOptionPane.showMessageDialog(null, "Valor inv�lido! Por favor, digite apenas n�meros.", "Erro", JOptionPane.ERROR_MESSAGE);
	                }
	            }

	            Moeda moedaConvertida = null;
	            for (Moeda moeda : moedas) {
	                if (moeda.getNome().equals(escolhaMoeda)) {
	                    moedaConvertida = moeda;
	                    break;
	                }
	            }

	            if (moedaConvertida != null) {
	               
	                double valorConvertido = converterMoeda(moedaConvertida, valorEntrada);

	                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
	                nf.setCurrency(Currency.getInstance(moedaConvertida.getSimboloMoedaDestino()));
	                String valorFormatado = nf.format(valorConvertido);

	                JOptionPane.showMessageDialog(
	                        null,
	                        "Resultado da convers�o: " + valorFormatado,
	                        "Convers�o de Moeda", 
	                        JOptionPane.INFORMATION_MESSAGE);

	                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar outra convers�o?", "Continuar?", JOptionPane.YES_NO_CANCEL_OPTION);
	                if (resposta == JOptionPane.YES_OPTION) {
	                    continue;
	                } else if (resposta == JOptionPane.NO_OPTION) {
	                    JOptionPane.showMessageDialog(null, "Programa finalizado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
	                    return;
	                } else if (resposta == JOptionPane.CANCEL_OPTION) {
	                    JOptionPane.showMessageDialog(null, "Programa conclu�do", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
	                    return;
	                }
	            }
	        }
	    }

	    private static double converterMoeda(Moeda moeda, double valorEntrada) {
	        if (moeda == null) {
	            return 0.0; 
	        }

	        double valorConvertido = valorEntrada * moeda.getTaxaConversao();

	        return valorConvertido;
	    }
	}

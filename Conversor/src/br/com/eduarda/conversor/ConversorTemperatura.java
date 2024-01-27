package br.com.eduarda.conversor;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
	
	public static void mostrarMenu() {
        String[] temperaturas = {"Celsius para Fahrenheit", "Fahrenheit para Celsius", "Celsius para Kelvin", "Kelvin para Celsius"};
        String escolhaTemperatura = (String) JOptionPane.showInputDialog(null, "Escolha a conversão:", "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]);

        if (escolhaTemperatura != null) {
            double valorEntrada = 0.0;
            boolean valorValido = false;

            while (!valorValido) {
                try {
                    String entrada = JOptionPane.showInputDialog("Digite o valor a ser convertido:");
                    if (entrada == null) {
                        JOptionPane.showMessageDialog(null, "Programa concluído", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    valorEntrada = Double.parseDouble(entrada);
                    valorValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, insira apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            double resultado = converterTemperatura(escolhaTemperatura, valorEntrada);

            JOptionPane.showMessageDialog(null, "Resultado da conversão: " + resultado, "Conversão de Temperatura", JOptionPane.INFORMATION_MESSAGE);

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja fazer outra conversão?", "Escolha", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opcao == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Programa finalizado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Programa concluído", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static double converterTemperatura(String escolhaTemperatura, double valorEntrada) {
        double resultado = 0.0;

        switch (escolhaTemperatura) {
            case "Celsius para Fahrenheit":
                resultado = celsiusParaFahrenheit(valorEntrada);
                break;
            case "Fahrenheit para Celsius":
                resultado = fahrenheitParaCelsius(valorEntrada);
                break;
            case "Celsius para Kelvin":
                resultado = celsiusParaKelvin(valorEntrada);
                break;
            case "Kelvin para Celsius":
                resultado = kelvinParaCelsius(valorEntrada);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha de conversão inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    private static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double celsiusParaKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double kelvinParaCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}



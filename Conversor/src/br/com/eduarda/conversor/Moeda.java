package br.com.eduarda.conversor;

public enum Moeda {

    // Cotação em 26/01/24
    REAL_PARA_DOLAR(1 / 4.92, "USD", "BRL", "Real para Dólar"),
    REAL_PARA_EURO(1 / 5.34, "BRL", "EUR", "Real para Euro"),
    REAL_PARA_LIBRAS(1 / 6.25, "BRL", "GBP", "Real para Libras"),
    REAL_PARA_ARGENTINO(1 / 0.006, "BRL", "ARS", "Real para Peso Argentino"),
    REAL_PARA_CHILENO(1 / 0.0053, "BRL", "CLP", "Real para Peso Chileno"),

    DOLAR_PARA_REAL(4.92, "BRL", "USD", "Dólar para Real"),
    EURO_PARA_REAL(5.34, "EUR", "BRL", "Euro para Real"),
    LIBRAS_PARA_REAL(6.25, "GBP", "BRL", "Libras para Real"),
    ARGENTINO_PARA_REAL(0.006, "ARS", "BRL", "Peso Argentino para Real"),
    CHILENO_PARA_REAL(0.0053, "CLP", "BRL", "Peso Chileno para Real");

    private final double taxaConversao;
    private final String simboloMoedaOrigem;
    private final String simboloMoedaDestino;
	private final String nome;

    Moeda(double taxaConversao, String simboloMoedaOrigem, String simboloMoedaDestino, String nome) {
        this.taxaConversao = taxaConversao;
        this.simboloMoedaOrigem = simboloMoedaOrigem;
        this.simboloMoedaDestino = simboloMoedaDestino;
        this.nome = nome;
    }

    public double getTaxaConversao() {
        return taxaConversao;
    }

    public String getSimboloMoedaOrigem() {
        return simboloMoedaOrigem;
    }

    public String getSimboloMoedaDestino() {
        return simboloMoedaDestino;
    }
    
    public String getNome() {
        return nome;
    }
}

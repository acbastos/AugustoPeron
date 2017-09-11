package br.org.cpb.UTIL;

/**
 * Utilitário para CNPJ.
 *
 * @author Marlon Silva Carvalho
 * @since 06/05/2010
 */
final class GeradoraCNPJ {

    private static String obterDVBase10(String fonte, boolean dezPorX) {
        char subUm = '0';
        if (dezPorX) {
            subUm = 'X';
        }
        return obterDVBaseParametrizada(fonte, 10, '0', subUm);
    }

    /**
     * Calcular um dígito verificador a partir de uma sequência de números
     * enviada.
     * O maior peso usado atinge a base, retorna a 2
     *
     * @param fonte   Sequência de números para cálculo do DV
     * @param base    Valor da base que se deseja usar para o cálculo do DV
     * @param subZero Caracter que deve substituir o resultado quando o resto for 0
     * @param subUm   Caracter que deve substituir o resultado quando o resto for 1
     * @return DV gerado.
     */
    private static String obterDVBaseParametrizada(String fonte, int base,
                                                   char subZero, char subUm) {
        int peso = 2;
        int dv = 0;
        for (int i = fonte.length() - 1; i >= 0; i--) {
            dv += Integer.parseInt(fonte.substring(i, i + 1)) * peso;
            if (peso == base - 1) {
                peso = 2;
            } else {
                peso++;
            }
        }
        dv = dv % 11;
        if (dv > 1) {
            return String.valueOf(11 - dv);
        } else if (dv == 1) {
            return String.valueOf(subUm);
        }
        return String.valueOf(subZero);

    }

    private static String obterDVBase10(String fonte, boolean dezPorX, int quantidadeDigitos) {
        char subUm = '0';
        if (dezPorX) {
            subUm = 'X';
        }
        return obterDVBaseParametrizada(fonte, 10, '0', subUm, quantidadeDigitos);
    }

    private static String obterDVBaseParametrizada(String fonte, int base,
                                                   char subZero, char subUm, int quantidadeDigitos) {
        if (quantidadeDigitos > 1) {
            String parcial = obterDVBaseParametrizada(fonte, base, subZero, subUm);
            return parcial + obterDVBaseParametrizada(fonte + parcial, base, subZero, subUm, --quantidadeDigitos);
        } else {
            return obterDVBaseParametrizada(fonte, base, subZero, subUm);
        }
    }

    /**
     * Gerar um número de CNPJ válido.<br>
     * Um número de CNPJ que é vélido não significa que exista.
     *
     * @return CNPJ gerado.
     */
    public String geraCNPJComMask() {
        StringBuilder iniciais = new StringBuilder();
        Integer numero;
        for (int i = 0; i < 12; i++) {
            numero = Integer.valueOf((int) (Math.random() * 10));
            iniciais.append(numero.toString());
        }
        return formatar(iniciais.toString() + gerarDigitoVerificador(iniciais.toString()));
    }

    public String geraCNPJSemMask() {
        StringBuilder iniciais = new StringBuilder();
        Integer numero;
        for (int i = 0; i < 12; i++) {
            numero = Integer.valueOf((int) (Math.random() * 10));
            iniciais.append(numero.toString());
        }
        return (iniciais.toString() + gerarDigitoVerificador(iniciais.toString()));
    }

    private String formatar(String cnpj) {
        StringBuilder s = new StringBuilder();
        String soNumeros = cnpj;

        s.append(soNumeros.substring(0, 2));
        s.append(".");
        s.append(soNumeros.substring(2, 5));
        s.append(".");
        s.append(soNumeros.substring(5, 8));
        s.append("/");
        s.append(soNumeros.substring(8, 12));
        s.append("-");
        s.append(soNumeros.substring(12, 14));
        return s.toString();
    }

    /**
     * Dado um conjunto de 12 números, gerar um dígito verificador.
     *
     * @param cnpj CNPJ com 12 números.
     * @return Dígito verificador.
     */
    private String gerarDigitoVerificador(String cnpj) {
        return obterDVBase10(cnpj, false, 2);
    }
}
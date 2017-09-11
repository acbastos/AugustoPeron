package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import java.util.List;

public interface TestUtilInterface {

    //==================== M�todos �teis =======================

    /**
     * Aguardo o Elemento HTML ser carregado na tela.
     *
     * @param id
     */
    void aguardarElementoPorID(String id);

    /**
     * Maximiza a Janela do Browser.
     */
    void maximizarJanela();

    /**
     * Aguardo o Elemento HTML ser carregado na tela,
     * informando o par�metro de busca e o valor.
     *
     * @param by
     */
    void aguardarElemento(By by);

    /**
     * Aguardar o tempo
     *
     * @int timeMilesegundos
     */
    void aguardar(int timeMilesegundos);

    /**
     * Aguarda o tempo padr�o definido para o script pela vari�vel tempoDeEspera
     */
    void aguardar();

    /**
     * Aguarda o tempo padr�o definido para o script pela vari�vel tempoDeEsperaCurto
     */
    void aguardarCurto();

    /**
     * Seleciona uma janela ou aba aberta permitindo a execu��o/continua��o do teste na janela selecionada
     *
     * @param janela
     */

    void changeWindow(int janela);

    /**
     * Leva o cursor at� o menu selecionado
     *
     * @param elemento
     */

    void moveCursor(By elemento);

    /**
     * Arrasta um webelemente de uma �rea a outra
     */
    void dragAndDrop(By elementoOrigem, By elementoDestino);


    //=================== Campos tipos Select =============================

    /**
     * @param by
     * @param valorParcial
     * @return
     */

    public String getTextoPorValorParcial(By by, String valorParcial);

    /**
     * Seleciona um valor de uma combo aletoriamente
     *
     * @param by
     */
    void slcCmbAleatoriamente(By by);

    /**
     * Seleciona um item da Combo pelo Name HTML e Value HTML
     *
     * @param name
     * @param value
     */
    void slcCmbNameValue(String name, String value);

    /**
     * Seleciona um item da Combo pelo By passado e Texto exibido
     *
     * @param texto
     * @param by
     */
    void slcCmbByeTexto(By by, String texto);

    /**
     * Seleciona um item da Combo pelo By passado e Texto exibido
     *
     * @param by
     * @param value
     */
    void slcCmbByeValue(By by, String value);

    /**
     * Seleciona um item da Combo pelo Name HTML e Texto exibido
     *
     * @param name
     * @param texto
     */
    void slcCmbNameTexto(String name, String texto);

    /**
     * Seleciona um item da Combo pelo ID HTML e Value HTML
     *
     * @param id
     * @param value
     */
    void slcCmbIdValue(String id, String value);

    /**
     * Seleciona um item da Combo pelo ID HTML e Texto exibido
     *
     * @param id
     * @param texto
     */
    void slcCmbIdTexto(String id, String texto);

    /**
     * Seleciona um item da Combo pelo ID HTML e Texto exibido.
     *
     * @param by
     * @param textoCombo
     * @return True se o valor existe na combo ou false caso n�o
     */
    boolean isValorComboExiste(By by, String textoCombo);

    /**
     * Seleciona um item da Combo por qualquer refer�ncia
     *
     * @param by
     * @param texto
     */
    void slc(By by, String texto);

    /**
     * Seleciona um radioButton por ID.
     *
     * @param id
     */
    void slcRadioBtnID(String id);

    /**
     * Seleciona um radioButton por ID.
     *
     * @param value
     */
    void slcRadioBtnValue(String value);

    /**
     * Seleciona um radioButton por qualquer refer�ncia.
     * Caso a consulta seja por xpath usar: Exemplo: By.xpath("//input[@value='" + value + "']")
     *
     * @param by
     * @param value
     */
    void slcRadioBtn(By by, String value);

    void slcChkBoxID(String id, boolean check);

    void slcChkboxXpath(String xPath, boolean check);

    void slcChkBoxName(String name, boolean check);

    /**
     * Seleciona um radioButton por qualquer refer�ncia.
     * Caso a busca seja por cssSelector usar: Exemplo: By.cssSelector("input[name='" + name + "']")
     *
     * @param by
     * @param check
     */
    void slcChkBoxName(By by, boolean check);

    /**
     * Limpa campos do tipo input da tela
     */
    void limpaCamposInput();

    /**
     * Verifica se existe o texto na tela, caso n�o exista o caso de teste � marcado como Fail.
     *
     * @param texto
     */
    void assertTextoExiste(String texto);

    /**
     * Verificar se o elemento est� presente na tela atraves do xPath
     *
     * @param xPath
     */

    boolean isElementoPresente(String xPath);

    /**
     * Verificar se o elemento est� presente na tela atraves do valor, sendo localizado pelo id
     *
     * @param valor
     */
    boolean isElementoPresenteIdValor(String id, String valor);

    /**
     * Verificar se o elemento est� presente na tela conforme o By passado
     *
     * @param by
     * @return true se encontrato e false caso n�o
     */
    boolean isElementoPresente(By by);

    /**
     * Verificar se o elemento est� presente na tela atraves do CSS
     *
     * @param css
     * @return true se encontrato e false caso n�o
     */

    boolean isElementoPresenteCss(String css);


    /**
     * Quando existe uma nova aba ou janela � necessario utilizar esse metodo
     * para n�o perder a janela que o driver est� utilizando.
     *
     * @return true se encontrato e false caso n�o
     */
    void trocadeJanela();

    /**
     * Verifica se existe o texto na tela, caso n�o exista ele retorna falso.
     *
     * @param texto
     */
    public boolean isTextoExiste(String texto);

    /**
     * Retorno o WebElement (elemento HTML) para interagir com este
     *
     * @param id
     * @return
     */
    WebElement getWebElement(String id);

    /**
     * Retorno o WebElement (elemento HTML) para interagir com este
     *
     * @param name
     * @return
     */
    WebElement getWebElementPorName(String name);

    /**
     * Retorno o WebElement (elemento HTML) para interagir com este
     *
     * @param xPath
     * @return
     */
    WebElement getWebElementPorXpath(String xPath);

    /**
     * Retorno o WebElement (elemento HTML) para interagir com este
     *
     * @param classe
     * @return
     */
    WebElement getWebElementPorCSS(String classe);

    /**
     * Retorna o WebElement usando qualquer refer�ncia
     *
     * @param by
     */
    WebElement getWebElement(By by);

    /**
     * Limpa o elemento com o Id HTML passado.
     *
     * @param id
     */
    void limpaCampoPorId(String id);

    /**
     * Limpa o elemento com o NAME HTML passado.
     *
     * @param name
     */
    void limpaCampoPorName(String name);

    /**
     * clica no elemento com o xPath HTML passado.
     *
     * @param xpath
     */
    void limpaCampoPorXpath(String xpath);

    //==================== Preenchimento de campos =======================

    /**
     * Digita o <code>texto</code> no elemento com o <code>id</code> passado.
     *
     * @param id
     * @param texto
     */
    void preencheCampoPorId(String id, String texto);

    /**
     * Digita o <code>texto</code> no elemento com o <code>id</code> passado. Por�m n�o limpa o campo por conta da mascara.
     *
     * @param id
     * @param texto
     */
    void preencheCampoPorIdParaData(String id, String texto);

    /**
     * Digita o <code>texto</code> no elemento com o <code>id</code> passado.
     *
     * @param name
     * @param texto
     */
    void preencheCampoPorName(String name, String texto);

    /**
     * Digita o <code>texto</code> no elemento com o <code>id</code> passado.
     *
     * @param xPath
     * @param texto
     */
    void preencheCampoPorXpath(String xPath, String texto);

    /**
     * Preenche o <code>texto</code> no elemento qualquer refer�ncia.
     *
     * @param by
     * @param texto
     */
    void preencheCampo(By by, String texto);

    //================================================================================

    //=========================== Cliques ===========================================

    /**
     * clica em alerta do browser, onde n�o possui elemento especifico. E n�o aceita o alerta.
     */
    void clickElementoBrowserDismiss();

    /**
     * clica em alerta do browser, onde n�o possui elemento especifico.
     * E aceita o alerta.
     */
    void clickElementoBrowserAccept();

    /**
     * clica no elemento com o Id HTML passado.
     *
     * @param id
     */
    void clickPorId(String id);

    /**
     * clica no elemento com o Name HTML passado.
     *
     * @param name
     */
    void clickPorName(String name);

    /**
     * clica no elemento com o link HTML passado.
     *
     * @param link
     */
    void clickPorLink(String link);

    /**
     * clica no elemento com o link HTML passado.
     *
     * @param xPath
     */
    void clickPorXPath(String xPath);

    /**
     * clica no elemento com o CSS passado.
     *
     * @param classe
     */
    void clickPorCss(String classe);

    /**
     * clica no elemento usando qualquer refer�ncia
     *
     * @param by
     */
    void click(By by);

    //====================================================================

    //================ Limpeza de campos =================================

    /**
     * Limpa o campo com qualquer referencia.
     * O campo precisa esta habilitado e visivel na tela
     *
     * @param by
     */
    void limpaCampo(By by);

    /**
     * M�todo que Marca em vermelho o elemento HTML da tela para auxiliar em Prints
     * e aguarda o TEMPO_DE_ESPERA definido.
     *
     * @param element
     * @throws InterruptedException
     */
    void destaque(WebElement element);

    /**
     * Destaca o elemento com o ID passado.
     * Indicado para campos input
     *
     * @param idElemento
     */
    void destaque(String idElemento);

    /**
     * Destaca o elemento com o ID passado.
     * Indicado para campos input
     *
     * @param formaDeCaptura
     */
    void destaque(By formaDeCaptura);

    /**
     * Destaca na tela o elementos com os IDs passados.
     * Pode ser passado quando elemento for necess�rio
     * ex: destaque("id1","id2","id3","id4")
     *
     * @param ids
     */
    void destaque(String... ids);

    //=========================== Prints =================================

    /**
     * Efetua o print e salva no local definido Evidencias\pastaEvidencias
     */
    void print();

    /**
     * Efetua o print e salva no local definido
     * Evidencias\pastaEvidencias com o nome informado
     */
    void print(String nomeArquivo);


    //========================= Tabelas html =============================

    /**
     * Retorna o elemento da linha da tabela passada com a Class informada.
     * Ex: Usar para selecionar um icone de alterar em uma tabela com v�rios registros
     *
     * @param idTable      id HTML da tabela
     * @param textoDaLinha texto unico para selecionar a linha
     * @param iconeClass
     * @return
     */
    public WebElement clickIconeTable(String idTable, String textoDaLinha, String iconeClass);

    /**
     * Localiza c�lulas em uma tabela baseando-se em um texto.
     * O m�todo percorre todas as linhas da tabela.
     * Exemplo:  findElementOnTable("form:table", "2ChevroletCorvette", "rf-dt-c", 6);
     *
     * @param idTable          - ID da tabela referenciada
     * @param textFind         - Texto a ser localizado
     * @param tdClass          - A classe CSS da linha (td)
     * @param indexColunReturn - N�mero da coluna que deve retornar
     */
    List<WebElement> findElementOnTable(String idTable, String textFind,
                                        String tdClass, int indexColunReturn);

    /**
     * Localiza icones em uma tabela baseando-se em um texto.
     * O m�todo percorre todas as linhas da tabela.
     * Exemplo:  findElementOnTable("form:table", "2ChevroletCorvette", "rf-dt-c", "delete", 6);
     *
     * @param idTable          - ID da tabela referenciada
     * @param textFind         - Texto a ser localizado
     * @param tdClass          - A classe CSS da linha (td)
     * @param icone            - Refer�ncia textual do �cone ou img
     * @param indexColunReturn - N�mero da coluna que deve retornar
     */
    WebElement findElementOnTable(String idTable, String textFind,
                                  String tdClass, String icone, int indexColunReturn);

    /**
     * Define e recupera driver de conex�o do Browser
     */
    WebDriver getDriver();

    void setDriver(WebDriver driver);

    /**
     * Define e recupera URL Base da aplica��o alvo
     */
    String getBaseUrl();

    void setBaseUrl(String baseUrl);

    int getTempoDeEspera();

    void setTempoDeEspera(int tempoDeEspera);

    String getPastaEvidencias();

    void setPastaEvidencias(String pastaEvidencias);

    void setTirarPrintErro(boolean isTirarPrintErro);

    void setTmpEsperaElemento(int tmpEsperaElemento);

    Logger getLogger();

}
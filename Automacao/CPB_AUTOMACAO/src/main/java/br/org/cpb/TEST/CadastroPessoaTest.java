package br.org.cpb.TEST;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.org.cpb.PO.CadastroPessoaPO;
import br.org.cpb.PO.ClassificacaoEsportivaPO;
import br.org.cpb.PO.LoginPO;
import br.org.cpb.UTIL.MassaUtil;
import br.org.cpb.UTIL.BaseUtil;

public class CadastroPessoaTest {

	LoginPO login;
	BaseUtil paginaBase;
	CadastroPessoaPO cadastro;
	WebDriver driver;
	MassaUtil massa;
	ClassificacaoEsportivaPO classificacao;
	
	@Before
	public void antesDeTudo(){
		paginaBase = new BaseUtil(driver);
		login = new LoginPO();
		cadastro = new CadastroPessoaPO();
		massa = new MassaUtil();
		classificacao = new ClassificacaoEsportivaPO();
		
	}
	
	@Test
	public void cadastrarPessoa() throws InterruptedException{
		
		    //Gerando nome para teste
		    String nome = "Augusto Teste" + massa.gerarNumeroAleatorio3();
			paginaBase.abreNavegadorChrome();
		    //paginaBase.abreNavegadorHtmlUnitDriver();
			paginaBase.acessarUrl("http://localhost:8080/cadastro-geral-web/");
			login.realizarLogin("danillo", "1");
			cadastro.acessarMenuPessoa();
			cadastro.preenchendoAbaDocumentos();
			cadastro.preenchendoAbaDadosPessoais(nome);
			cadastro.preenchendoAbaDadosProfissionais();
			cadastro.preenchendoAbaDeficiencia();
			cadastro.preenchendoAbaDadosDeContato();
			cadastro.preenchendoAbaDadosBancarios();
			cadastro.preenchendoAbaDependentes();
			cadastro.preenchendoAbaPassaporte();
			cadastro.preenchendoAbaVistos();
			cadastro.preenchendoAbaUniformes();
			cadastro.preenchendoAbaEquipamentos();
			cadastro.preenchendoAbaClassificacao();
			cadastro.preenchendoAbaDadosComplementares();
			cadastro.preenchendoAbaOcorrencias();
			cadastro.preenchendoAbaAnexos();
			cadastro.finalizarCadastro();
			classificacao.incluirClassificacaoEsportiva(nome);
			//paginaBase.fecharNavegador();
	}
	
	@After
	public void depoisDeTudo(){
		
		
			
	}
}

package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import funcionalidades.Login.help.HelpLogin;
import funcionalidades.Login.model.Cliente;
import setup.Capabilities;

public class StepDefinitions {

	HelpLogin hp;
	Cliente cliente;
	public Scenario scenario;
	
	public StepDefinitions() {
		hp = new HelpLogin();
		cliente = hp.gerarCliente();
	}
	
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
	
    @Given("^Desejo acessar a url \"([^\"]*)\"$")
    public void acessarPagina(String url) throws Throwable {
    	Capabilities.acessaAplicacao(url);
    }
    
    @Then("^Tenho acesso a tela inicial do sistema$")
    public void aguardarTelaInicial() throws Throwable {
    	hp.aguardaTelaInicial();
    }

    @Given("^Cadastro um Cliente$")
    public void preCondicaoCadastro() throws Throwable {
    	hp.preCondicaoCadastroCliente(cliente);
    }
    
    
    @When("^Acesso a tela de Login$")
    public void acessarTelaLogin() throws Throwable {
    	hp.acessaTelaLogin();
    }
    
    @And("^Preencho o Login Valido$")
    public void preencherLoginValido() throws Throwable {
    	hp.preencherEmailLogin(cliente.email);
    }
    
    @And("^Preencho a Senha Valida$")
    public void preencherSenhaValida() throws Throwable {
    	hp.preencherSenha(cliente.senha);
    }
    
    @And("^Preencho o Login Invalido \"([^\"]*)\"$")
    public void preencherLogin(String login) throws Throwable {
    	hp.preencherEmailLogin(login);
    }
    
    @And("^Preencho a Senha Invalida \"([^\"]*)\"$")
    public void preencherSenha(String senha) throws Throwable {
    	hp.preencherSenha(senha);
    }
    
    @And("^Aciono o botao Sign In$")
    public void acionarBotaoLogar() throws Throwable {
    	hp.acionarSingIn();
    }
    
    @Then("^O sistema valida os dados e apresenta a mensagem \"([^\"]*)\"$")
    public void validarLogin(String mensagem) throws Throwable {
    	String casoTeste = scenario.getName();
    	hp.validarLogin(casoTeste, mensagem);
    }
}
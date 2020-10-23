package funcionalidades.Login.help;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import funcionalidades.Login.Title;
import funcionalidades.Login.model.Cliente;
import funcionalidades.Login.pgo.PgoLogin;
import setup.Suporte;
import util.GeradorEmail;

public class HelpLogin extends Suporte{
	
	private PgoLogin pg;
	
	public HelpLogin() {
		pg = new PgoLogin();
	}
	
	public Cliente gerarCliente() {
		return new Cliente(Title.MR, 
				"Nome Cliente", 
				"Sobrenome Cliente", 
				new GeradorEmail().gerarEmailAleatorio(), 
				"12345", 
				"22/5/1990", 
				"Ame Digital", 
				"Quadra 01 Casa 02", 
				"San Francisco", 
				"California", 
				"United States", 
				"12345", 
				"61999999999",
				"Cliente Ame Digital");
	}
	
	public void aguardaTelaInicial() {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.LOGO_TELA_INICIAL));
	}
	
	public void acessaTelaLogin() {
		click(pg.MENU_SIGN_IN);
	}
	
	public void sairAplicacao() {
		click(pg.MENU_SIGN_OUT);
	}
	
	public void acionarCreateAccount() {
		click(pg.BTN_CREATE_ACCOUNT);
	}
	
	public void acionarSingIn() {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.BTN_SIGN_IN));
		click(pg.BTN_SIGN_IN);
	}
	
	public void acionarRegister() {
		click(pg.BTN_REGISTER);
	}
	
	public void preencherEmailRegistro(String email) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_EMAIL_CADASTRO));
		preencheCampo(pg.CMP_EMAIL_CADASTRO, email);
	}
	
	public void preencherEmailLogin(String email) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_EMAIL));
		preencheCampo(pg.CMP_EMAIL, email);
	}
	
	public void preencherSenha(String senha) {
		preencheCampo(pg.CMP_SENHA, senha);
		acoesTeclado(Keys.TAB);
	}
	
	public void selecionarGenero(Title genero) {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.CMP_RADIO_MR));
		switch (genero) {
		case MR:
			click(pg.CMP_RADIO_MR);
			break;
		case MRS:
			click(pg.CMP_RADIO_MRS);
			break;
		}
	}
	
	public void preencherNome(String nome) {
		preencheCampo(pg.CMP_FIRST_NAME, nome);
	}
	
	public void preencherSobrenome(String sobrenome) {
		preencheCampo(pg.CMP_LAST_NAME, sobrenome);
	}
	
	public void selecionarDataNascimento(String data) {
		String[] d = data.split("/");
		selecionarComboBoxValue(pg.CMP_DAY, d[0]);
		selecionarComboBoxValue(pg.CMP_MONTH, d[1]);
		selecionarComboBoxValue(pg.CMP_YEAR, d[2]);
	}
	
	public void preencherEmpresa(String empresa) {
		preencheCampo(pg.CMP_COMPANY, empresa);
	}
	
	public void preencherEndereco(String endereco) {
		preencheCampo(pg.CMP_ADDRESS, endereco);
	}
	
	public void preencherCidade(String cidade) {
		preencheCampo(pg.CMP_CITY, cidade);
	}
	
	public void selecionarEstado(String estado) {
		selecionarComboBoxText(pg.CMP_STATE, estado);
	}
	
	public void preencherCaixaPostal(String CEP) {
		preencheCampo(pg.CMP_POSTAL_CODE, CEP);
	}
	
	public void selecionarPais(String pais) {
		selecionarComboBoxText(pg.CMP_COUNTRY, pais);
	}
	
	public void preencherTelefone(String telefone) {
		preencheCampo(pg.CMP_PHONE_MOBILE, telefone);
	}
	
	public void preencherAlias(String alias) {
		limparCampo(pg.CMP_ALIAS);
		preencheCampo(pg.CMP_ALIAS, alias);
	}
	
	public void validarLogin(String casoTeste, String mensagem) {
		if (casoTeste.contains("Sucesso")) {
			aguardaElemento(ExpectedConditions.visibilityOf(pg.WELCOME_MESSAGE));
			verificacao(pg.WELCOME_MESSAGE, mensagem);
			sairAplicacao();
		}else {
			aguardaElemento(ExpectedConditions.visibilityOf(pg.ALERT_MESSAGE));
			verificacao(pg.ALERT_MESSAGE, mensagem);
		}
	}
	
	public void preCondicaoCadastroCliente(Cliente cliente) {
		acessaTelaLogin();
		preencherEmailRegistro(cliente.email);
		acionarCreateAccount();
		selecionarGenero(cliente.genero);
		preencherNome(cliente.nome);
		preencherSobrenome(cliente.sobrenome);
		preencherSenha(cliente.senha);
		selecionarDataNascimento(cliente.dataNascimento);
		preencherEmpresa(cliente.empresa);
		preencherEndereco(cliente.endereco);
		preencherCidade(cliente.cidade);
		selecionarEstado(cliente.estado);
		preencherCaixaPostal(cliente.CEP);
		selecionarPais(cliente.pais);
		preencherTelefone(cliente.telefone);
		preencherAlias(cliente.alias);
		acionarRegister();
		aguardaElemento(ExpectedConditions.visibilityOf(pg.LOGO_TELA_INICIAL));
		sairAplicacao();
	}
}
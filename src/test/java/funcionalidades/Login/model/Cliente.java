package funcionalidades.Login.model;

import funcionalidades.Login.Title;

public class Cliente {
	
	public String nome, sobrenome, email, senha, dataNascimento, empresa, endereco, cidade, estado, pais, CEP, telefone, alias;
	public Title genero;
	
	public Cliente(Title genero, String nome, String sobrenome, String email, String senha, 
			String dataNascimento, String empresa, String endereco, String cidade, 
			String estado, String pais, String CEP, String telefone, String alias) {
		this.genero = genero;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.empresa = empresa;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.CEP = CEP;
		this.telefone = telefone;
		this.alias = alias;
	}
}

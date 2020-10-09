package com.example.project;

public class Loja {

    private String nomeLoja;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, String logradouro, int numero, String complemento, String bairro, String municipio,
            String estado, String cep, String telefone, String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String dadosLoja() {

        validarCamposObrigatorios();

		String _NUMERO = "s/n";
		if (this.getNumero() > 0){
			_NUMERO = Integer.toString(this.getNumero());
		}
		
		String _COMPLEMENTO = "";
		if (!isEmpty(this.getComplemento())){
			_COMPLEMENTO = " " + this.getComplemento();
		}
	
		String _BAIRRO = "";
		if(!isEmpty(this.getBairro())){
			_BAIRRO = this.getBairro() + " - " ;
		}
	
		String _CEP = "";
		if(!isEmpty(this.getCep())){
			_CEP = "CEP:" + this.getCep();
		}
		
		String _TELEFONE = "";
		if(!isEmpty(this.getTelefone())){
			_TELEFONE = "Tel " + this.getTelefone();

			if(!isEmpty(this.getCep())){
				_TELEFONE = " " + _TELEFONE;
			}
		}		
	
		String _OBSERVACAO = "";
		if (!isEmpty(this.getObservacao())){
			_OBSERVACAO = this.getObservacao();
		}

		String BREAK = System.lineSeparator();

		String nota = String.format("%s",this.getNomeLoja()) + BREAK;
		nota += String.format("%s, %s%s",this.getLogradouro(),_NUMERO,_COMPLEMENTO) + BREAK;
		nota += String.format("%s%s - %s",_BAIRRO,this.getMunicipio(),this.getEstado()) + BREAK;
		nota += String.format("%s%s",_CEP,_TELEFONE) + BREAK;
		nota += String.format("%s",_OBSERVACAO) + BREAK;
		nota += String.format("CNPJ: %s",this.getCnpj()) + BREAK;
		nota += String.format("IE: %s",this.getInscricaoEstadual()) + BREAK;
	
        return nota;
    }

    public void validarCamposObrigatorios(){
        if (isEmpty(this.getNomeLoja())) {
			throw new RuntimeException("O campo nome da loja é obrigatório");		
		}
		if (isEmpty(this.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}		
		if (isEmpty(this.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		if (isEmpty(this.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		} 
		if (isEmpty(this.getCnpj())){
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		} 
		if (isEmpty(this.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}
    }
    private static boolean isEmpty(String s){
		if (s == null) return true;
		if (s.equals("")) return true;
		return false;
	}

}
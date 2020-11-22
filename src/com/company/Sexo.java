package com.company;

public enum Sexo {
    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino"),
    OUTROS("O", "Outros");

    private final String sigla;
    private final String descricao;
    //Construtor-----------------------------------------------------------------------------------------------4
    Sexo(String sigla, String descricao){
        this.sigla = sigla;
        this.descricao =  descricao;
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public String getSigla() {
        return sigla;
    }
    public String getDescricao() {
        return descricao;
    }
    //Função toString()----------------------------------------------------------------------------------------------
}

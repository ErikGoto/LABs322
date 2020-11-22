package com.company;

public enum Label {
    TO_DO("Planejar", "Vermelho"),
    DOING("Importante", "Amarelo"),
    DONE("Feito", "Verde");

    private final String rotulo;
    private final String cor;
    //Construtor-----------------------------------------------------------------------------------------------
    Label(String rotulo, String cor){
        this.rotulo = rotulo;
        this.cor = cor;
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public String getRotulo() {
        return rotulo;
    }
    public String getCor() {
        return cor;
    }
    //Função toString()-----------------------------------------------------------------------------------------------
}

package com.wenxin.datastructure.adt.enums;

public enum BooleanType {
    True("T",true),
    False("False",false);

    public String charCode;
    public Boolean bool;

    BooleanType(String charCode,Boolean bool){
        this.charCode = charCode;
        this.bool = bool;
    }

}

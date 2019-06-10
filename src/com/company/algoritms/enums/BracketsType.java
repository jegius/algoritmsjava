package com.company.algoritms.enums;

import static com.company.algoritms.Constants.FIRST;

public enum BracketsType {
    START_BRACE ("{"),
    END_BRACE ("}"),
    START_SQUARE ("["),
    END_SQUARE ("]"),
    START_PARENTHESIS ("("),
    END_PARENTHESIS (")");

    private String bracketType;

    BracketsType(String bracketType) {
        this.bracketType = bracketType;
    }

    public char getAsChar() {
        return this.bracketType.charAt(FIRST);
    }
}

package com.company.algoritms.examples;

import com.company.algoritms.enums.ShowCaseType;
import com.company.algoritms.examples.stack.BracketChecker;
import com.company.algoritms.examples.stack.infix.InfixToPostfix;

public class ShowCaseFactory {
    public ShowCase createShowCase(ShowCaseType type, String input) {
        ShowCase createdShowCase;
        switch (type) {
            case BRACKETS_CHECKER:
                createdShowCase = new BracketChecker(input);
                break;
            case INFIX_CONVERTER:
                createdShowCase = new InfixToPostfix(input);
                break;
            default:
                throw new IllegalArgumentException("Wrong show case type:" + type);
        }
        return createdShowCase;
    }
}

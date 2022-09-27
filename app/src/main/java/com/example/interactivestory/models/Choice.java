package com.example.interactivestory.models;

public class Choice {

    //region *** properties ***
    private int textId;
    private int nextPage;
    //endregion

    //region *** constructor***
    public Choice(int textId, int nextPage) {
        this.textId = textId;
        this.nextPage = nextPage;
    }

    public Choice() {
    }
    //endregion

    //region *** getter & setter ***
    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    //endregion

}

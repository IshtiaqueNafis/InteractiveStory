package com.example.interactivestory.models;

public class Page {

    //region ***Properties***
    private int imageId; // this will show what kind of imagethe picture will have.
    private int textId;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;
    //endregion



    //region ***constructors***
    public Page() {
    }

    public Page(int imageId, int textId) {
        this.imageId = imageId;
        this.textId = textId;
        this.isFinalPage = true;
    }

    public Page(int imageId, int textId, Choice choice1, Choice choice2) {
        this.imageId = imageId;
        this.textId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }
    //endregion

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }


    public Choice getChoice1() {
        return choice1;
    }
    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

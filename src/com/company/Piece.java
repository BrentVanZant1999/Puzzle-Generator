package com.company;

public class Piece {
    private int colorVal;
    private boolean changed;
    private boolean valid;

    public Piece() {
        this.colorVal = -1;
        this.changed = false;
        this.valid = false;
    }
    public Piece(int initialVal) {
        this.colorVal = initialVal;
        this.changed = false;
        this.valid = false;
    }
    public void print(){
        System.out.print(this.colorVal+" ");
    }

    public boolean isChanged() {
        return changed;
    }

    public boolean isValid() {
        return valid;
    }

    public int getColorVal() {
        return colorVal;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void setColorVal(int colorVal) {
        this.colorVal = colorVal;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void colorSwitch(int wheelValue) {
        //value management
        int temp = this.getColorVal();
        temp++;
        if (temp > wheelValue){
            temp = 1;
        }
        this.setColorVal(temp);
        //boolean management
        if (!this.isChanged()){
            setChanged(true);
        }
    }

}

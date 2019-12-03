package ru.jsf;

public class Dot {
    private String coordinateX = "";
    private String coordinateY = "";
    private String parametrR = "";
    private String result =  "";

    public Dot(String coordinateX, String coordinateY, String parametrR, String result){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.parametrR = parametrR;
        this.result = result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setParametrR(String parametrR) {
        this.parametrR = parametrR;
    }

    public String getParametrR() {
        return parametrR;
    }
}

package ru.jsf;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class MainBean {
    private List<Dot> history = new ArrayList<>();
    private String x;
    private String y;
    private String R;
    private String res;
    private String testX;
    private String testY;
    private String testR;


    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getTestR() {
        return testR;
    }

    public void setTestR(String testR) {
        this.testR = testR;
    }

    public String getTestY() {
        return testY;
    }

    public void setTestY(String textY) {
        this.testY = textY;
    }

    public String getTestX() {
        return testX;
    }

    public void setTestX(String testX) {
        this.testX = testX;
    }

    public List<Dot> getHistory() {
        return history;
    }


    public void setCoordinateX(String coordinateX) {
        this.x = coordinateX;
    }


    public void setCoordinateY(String coordinateY) {
        this.y = coordinateY;
    }

    public String getCoordinateY() {
        return y;
    }

    public void setParametrR(String parametrR) {
        this.R = parametrR;
    }

    public void sendData() {
        //Проверка, что введены данные и корректны

        Double x = Double.parseDouble(this.x);
        Double y = Double.parseDouble(this.y.replace(",","."));
        Double R = Double.parseDouble(this.R);

        if ((0.0 <= x && x <= R / 2 && 0.0 <= y && y <= R) || (x <= 0.0 && y <= 0.0 && (x * x + y * y) <= R * R) || (x <= 0 && 0 <= y && y <= x + R)) {
            res = "Попадание";
            history.add(new Dot(this.x, this.y, this.R, this.res));
        } else {
            res = "Промах";
            history.add(new Dot(this.x, this.y, this.R, this.res));
        }
    }



    public String getDrawingDot(){
        return "showData()";
    }



    public void check (javax.faces.context.FacesContext context, UIComponent component, Object o){
        try {
            if (Double.parseDouble(o.toString()) >= 3 || Double.parseDouble(o.toString()) <= -3  ){
                FacesMessage msg = new FacesMessage("Неверное значение координат");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage("Неверное значение координат");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }


    public void sendDot() {
        Double x = Double.parseDouble(this.testX);
        Double y = Double.parseDouble(this.testY);
        Double R = Double.parseDouble(this.testR);
        this.testX = testX.replace(".", ",");
        this.testY = testY.replace(".", ",");
        if ((0.0 <= x && x <= R / 2 && 0.0 <= y && y <= R) || (x <= 0.0 && y <= 0.0 && (x * x + y * y) <= R * R) || (x <= 0 && 0 <= y && y <= x + R)) {
            res = "Попадание";
            history.add(new Dot(testX, testY, testR, this.res));
        } else {
            res = "Промах";
            history.add(new Dot(testX, testY, testR, this.res));
        }
    }

}



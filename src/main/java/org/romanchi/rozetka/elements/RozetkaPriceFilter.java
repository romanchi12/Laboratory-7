package org.romanchi.rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.romanchi.rozetka.elements.PageObject;

import javax.xml.soap.Text;

public class RozetkaPriceFilter extends PageObject {
    WebElement filterElement;
    TextField minField;
    TextField maxField;
    Button submitButton;
    public RozetkaPriceFilter(WebElement filterElement) {
        this.filterElement = filterElement;
        WebElement minElement = filterElement.findElement(By.id("price[min]"));
        WebElement maxElement = filterElement.findElement(By.id("price[max]"));
        WebElement submitButton = filterElement.findElement(By.id("submitprice"));
        System.out.println(submitButton.getText());
        minField = new TextField(minElement);
        maxField = new TextField(maxElement);
        this.submitButton = new Button(submitButton);
    }

    public void setMinPrice(int minPrice){
        minField.sendKeys(String.valueOf(minPrice));
    }
    public void setMaxPrice(int maxPrice){

        maxField.sendKeys(String.valueOf(maxPrice));
    }

    public void submit(){
        submitButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

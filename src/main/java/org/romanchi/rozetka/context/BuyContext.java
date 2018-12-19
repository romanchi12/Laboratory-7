package org.romanchi.rozetka.context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.romanchi.rozetka.Rozetka;
import org.romanchi.rozetka.elements.RozetkaGoodTile;
import org.romanchi.rozetka.elements.RozetkaPriceFilter;
import org.romanchi.rozetka.elements.TextField;

public class BuyContext implements Context{
    private Rozetka rozetka;
    private String toBuy;
    private int minPrice = 0;
    private int maxPrice = 0;

    @Override
    public void execute() {
        rozetka.search(toBuy);
        RozetkaPriceFilter priceFilter = rozetka.getPriceFilter();
        priceFilter.setMaxPrice(maxPrice);
        priceFilter.setMinPrice(minPrice);
        priceFilter.submit();
        RozetkaGoodTile tile = rozetka.getFirstSetGoods().get(0);
        tile.buy();
        rozetka.getDriver().findElement(By.id("popup-checkout")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement recieverNameElement = rozetka.getDriver().findElement(By.id("reciever_name"));
        recieverNameElement.sendKeys("Роман Малярчук");
        WebElement recieverPhoneElement = rozetka.getDriver().findElement(By.id("reciever_phone"));
        recieverPhoneElement.sendKeys("+380665894566");
        WebElement recieverEmailElement = rozetka.getDriver().findElement(By.id("reciever_email"));
        recieverEmailElement.sendKeys("romanchi60140@gmail.com");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rozetka.getDriver().findElements(By.cssSelector("[name=next_step]")).get(1).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement lastName = rozetka.getDriver().findElement(By.cssSelector("[name='order[1][additional_fields][last_name]']"));
        WebElement firstName = rozetka.getDriver().findElement(By.cssSelector("[name='order[1][additional_fields][first_name]']"));
        lastName.sendKeys("Малярчук");
        firstName.sendKeys("Роман");
        WebElement makeOrder = rozetka.getDriver().findElement(By.id("make-order"));
        if(makeOrder.isEnabled()){
            System.out.println("Make order");
        }else{
            try {
                throw new Exception("Make order button is disabled");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setRozetka(Rozetka rozetka) {
        this.rozetka = rozetka;
    }

    public String getToBuy() {
        return toBuy;
    }

    public void setToBuy(String toBuy) {
        this.toBuy = toBuy;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}

import java.util.ArrayList;
import java.util.List;

interface StockObserver {
    void update(float price);
}

class StockMarket {
    private List<StockObserver> observers = new ArrayList<>();
    private float stockPrice;

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockPrice);
        }
    }
}
class Broker implements StockObserver {
    private String brokerName;

    public Broker(String name) {
        this.brokerName = name;
    }

    @Override
    public void update(float price) {
        System.out.println("Broker " + brokerName + " is notified about the new stock price: $" + price);
    }
}
public class Main1 {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Broker broker1 = new Broker("Alice");
        Broker broker2 = new Broker("Bob");

        // Brokers subscribing to stock market updates
        stockMarket.addObserver(broker1);
        stockMarket.addObserver(broker2);

        // Stock price changes, and brokers get notified
        stockMarket.setStockPrice(10.8f);
        stockMarket.setStockPrice(11.5f);

        stockMarket.removeObserver(broker1);
        stockMarket.setStockPrice(13.1f);
    }
}

interface PaymentGateway {
    void processPayment(double amount);
}
class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment through PayPal: $" + amount);
    }
}
class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment through Stripe: $" + amount);
    }
}
class PayPalAdapter implements PaymentGateway {
    private PayPalGateway paypalGateway;

    public PayPalAdapter(PayPalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.sendPayment(amount);
    }
}
class StripeAdapter implements PaymentGateway {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }
}
public class Main5 {
    public static void main(String[] args) {

        PayPalGateway paypal = new PayPalGateway();
        PaymentGateway paypalAdapter = new PayPalAdapter(paypal);
        paypalAdapter.processPayment(158.0); 


        StripeGateway stripe = new StripeGateway();
        PaymentGateway stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(296.0); 
    }
}

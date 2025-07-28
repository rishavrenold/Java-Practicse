package CreationalDesignPattern.AbstractFactoryPattern;

interface PaymentGateway {
    void processPayment(double amount);
}
interface Invoice{
    void generateInvoice();
}

// Indian payment implementation

class RazorpayGateway implements PaymentGateway
{

    @Override
    public void processPayment(double amount) {
        System.out.println("Your amount has been deducted"+ amount);
    }   
}

class PayTmGateway implements PaymentGateway
{

    @Override
    public void processPayment(double amount) {
        System.out.println("Your amount has been deducted"+ amount);
    }   
}

class GstInvoice implements Invoice{

    @Override
    public void generateInvoice() {
        System.out.println("The Invoice has been generate for GST");
    }
    
}
// US based Payment Implementation 
class PayPal implements PaymentGateway
{
    @Override
    public void processPayment(double amount) {
       System.out.println("Your Amount has been deducted"+amount);
    }
}

class Stripe implements PaymentGateway
{
     @Override
    public void processPayment(double amount) {
       System.out.println("Your Amount has been deducted"+amount);
    }
}

class USInvoice implements Invoice
{
    @Override
    public void generateInvoice() {
        System.out.println("The Invoice has been generate for GST");
    }
}

// Abstract Factory 
interface RegionFactory{
    PaymentGateway createPayementGateway(String gateWayType);
    Invoice creatInvoice();
}

// Concrete Factories

class IndiaFactory implements RegionFactory{

    @Override
    public PaymentGateway createPayementGateway(String gateWayType) {
       if(gateWayType.equals("razorpay"))
       {
            return new RazorpayGateway();
       }
       else if (gateWayType.equals("paytm"))
       {
            return new PayTmGateway();
       }
       return null;
    }

    @Override
    public Invoice creatInvoice() {
        return new GstInvoice();
    }
    
}

class USFactory implements RegionFactory{
    @Override
    public PaymentGateway createPayementGateway(String gateWayType) {
       if(gateWayType.equals("paypal"))
       {
            return new PayPal();
       }
       else if (gateWayType.equals("stripe"))
       {
            return new Stripe();
       }
       return null;
    }

    @Override
    public Invoice creatInvoice() {
        return new USInvoice();
    }
}

class CheckoutService{
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gateWayType;

    public CheckoutService(RegionFactory factory,String gateWayType)
    {
        this.gateWayType=gateWayType;
        this.paymentGateway=factory.createPayementGateway(gateWayType);
        this.invoice=factory.creatInvoice();
    }
    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        // Using Razorpay in India
        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(1999.0);

        System.out.println("---");

        // Using PayPal in US
        CheckoutService usCheckout = new CheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);
    }
 }


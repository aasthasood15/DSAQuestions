
package org.hld;

import java.util.ArrayList;
import java.util.List;

// =====================================================
// 1. STRATEGY PATTERN
// =====================================================

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

class FestiveDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% discount
    }
}

class CashbackDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount - 100; // Rs. 100 cashback
    }
}


// =====================================================
// 2. FACTORY PATTERN
// =====================================================

interface Payment {
    void pay(double amount);
}

class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class NetBankingPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Net Banking");
    }
}

class PaymentFactory {

    public static Payment getPayment(String type) {

        if ("upi".equalsIgnoreCase(type)) {
            return new UpiPayment();

        } else if ("card".equalsIgnoreCase(type)) {
            return new CardPayment();

        } else if ("netbanking".equalsIgnoreCase(type)) {
            return new NetBankingPayment();
        }

        throw new IllegalArgumentException(
                "Unsupported payment type: " + type
        );
    }
}


// =====================================================
// 3. OBSERVER PATTERN
// =====================================================

interface PaymentObserver {
    void update(String message);
}

class EmailObserver implements PaymentObserver {

    private final String email;

    public EmailObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println(
                "Email sent to " + email + ": " + message
        );
    }
}

class SmsObserver implements PaymentObserver {

    private final String mobile;

    public SmsObserver(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void update(String message) {
        System.out.println(
                "SMS sent to " + mobile + ": " + message
        );
    }
}

class PaymentNotificationService {

    private final List<PaymentObserver> observers =
            new ArrayList<>();

    public void subscribe(PaymentObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(PaymentObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {

        for (PaymentObserver observer : observers) {
            observer.update(message);
        }
    }
}


// =====================================================
// 4. ADAPTER PATTERN
// =====================================================

// Interface expected by our application
interface PaymentGateway {

    void makePayment(double amount);
}


// Third-party Razorpay API
// Assume we cannot modify this class.
class RazorpayGateway {

    public void processTransaction(double amount) {

        System.out.println(
                "Razorpay processed payment of Rs. " + amount
        );
    }
}


// Adapter converts Razorpay API
// into our PaymentGateway interface.
class RazorpayAdapter implements PaymentGateway {

    private final RazorpayGateway razorpayGateway;

    public RazorpayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    @Override
    public void makePayment(double amount) {

        razorpayGateway.processTransaction(amount);
    }
}


// Third-party Stripe API
class StripeGateway {

    public void executePayment(double amount) {

        System.out.println(
                "Stripe processed payment of Rs. " + amount
        );
    }
}


// Adapter converts Stripe API
// into our PaymentGateway interface.
class StripeAdapter implements PaymentGateway {

    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void makePayment(double amount) {

        stripeGateway.executePayment(amount);
    }
}


// =====================================================
// COMBINED CHECKOUT FLOW
// =====================================================

class CheckoutService {

    private final DiscountStrategy discountStrategy;
    private final PaymentNotificationService notificationService;

    public CheckoutService(
            DiscountStrategy discountStrategy,
            PaymentNotificationService notificationService) {

        this.discountStrategy = discountStrategy;
        this.notificationService = notificationService;
    }

    public void checkout(
            double originalAmount,
            String paymentType,
            String gatewayType) {

        // ---------------------------------------------
        // 1. Strategy Pattern
        // ---------------------------------------------

        double finalAmount =
                discountStrategy.applyDiscount(originalAmount);

        System.out.println(
                "Original Amount: " + originalAmount
        );

        System.out.println(
                "Final Amount: " + finalAmount
        );


        // ---------------------------------------------
        // 2. Factory Pattern
        // ---------------------------------------------

        Payment payment =
                PaymentFactory.getPayment(paymentType);

        payment.pay(finalAmount);


        // ---------------------------------------------
        // 3. Adapter Pattern
        // ---------------------------------------------

        PaymentGateway paymentGateway;

        if ("razorpay".equalsIgnoreCase(gatewayType)) {

            paymentGateway =
                    new RazorpayAdapter(
                            new RazorpayGateway()
                    );

        } else if ("stripe".equalsIgnoreCase(gatewayType)) {

            paymentGateway =
                    new StripeAdapter(
                            new StripeGateway()
                    );

        } else {

            throw new IllegalArgumentException(
                    "Unsupported gateway: " + gatewayType
            );
        }

        paymentGateway.makePayment(finalAmount);


        // ---------------------------------------------
        // 4. Observer Pattern
        // ---------------------------------------------

        notificationService.notifyObservers(
                "Payment of Rs. "
                        + finalAmount
                        + " completed successfully."
        );
    }
}


// =====================================================
// MAIN
// =====================================================

public class CombinedDesignPatternsExample {

    public static void main(String[] args) {

        // Observer Pattern
        PaymentNotificationService notificationService =
                new PaymentNotificationService();

        notificationService.subscribe(
                new EmailObserver("aastha@example.com")
        );

        notificationService.subscribe(
                new SmsObserver("9876543210")
        );


        // Strategy Pattern
        DiscountStrategy discountStrategy =
                new FestiveDiscount();


        // Checkout Service
        CheckoutService checkoutService =
                new CheckoutService(
                        discountStrategy,
                        notificationService
                );


        // Checkout
        checkoutService.checkout(
                1000,
                "upi",
                "razorpay"
        );
    }
}

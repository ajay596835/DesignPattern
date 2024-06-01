package behavioural.mediator;

// Mediator Interface
interface AuctionMediator {
    void bid(int amount, Bidder bidder);
}

// Concrete Mediator
class Auctioneer implements AuctionMediator {
    @Override
    public void bid(int amount, Bidder bidder) {
        System.out.println(bidder.getName() + " bids $" + amount);
    }
}

// Colleague Interface
interface Bidder {
    void placeBid(int amount);
    String getName();
}

// Concrete Colleague
class AuctionBidder implements Bidder {
    private String name;
    private AuctionMediator mediator;

    public AuctionBidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void placeBid(int amount) {
        mediator.bid(amount, this);
    }

    @Override
    public String getName() {
        return name;
    }
}

// Client
public class Mediator {
    public static void main(String[] args) {
        AuctionMediator mediator = new Auctioneer();

        Bidder bidder1 = new AuctionBidder("Alice", mediator);
        Bidder bidder2 = new AuctionBidder("Bob", mediator);

        bidder1.placeBid(100);
        bidder2.placeBid(150);
        bidder1.placeBid(200);
    }
}

/*
The Mediator Design Pattern is a behavioral design pattern that defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly and allows for more flexible and reusable code.

Intent:
Define an object that encapsulates how a set of objects interact.
Promote loose coupling by reducing the direct interactions between objects.
Allow for changes to the interaction between objects without modifying them.
Structure:
Mediator: Defines an interface for communicating with colleague objects and manages their interactions.
Concrete Mediator: Implements the Mediator interface and coordinates communication between colleague objects.
Colleague: Defines an interface for interacting with other colleague objects through the mediator.
Concrete Colleague: Implements the Colleague interface and communicates with other colleagues through the mediator.
*/

package behavioural.chainofresponsibility;

// Handler interface


// ConcreteHandler1
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(Request request) {
        if (request.getLevel() == 1) {
            System.out.println("Level 1 Support: Handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for the request.");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// ConcreteHandler2
class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(Request request) {
        if (request.getLevel() == 2) {
            System.out.println("Level 2 Support: Handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for the request.");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// ConcreteHandler3
class Level3SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(Request request) {
        if (request.getLevel() == 3) {
            System.out.println("Level 3 Support: Handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for the request.");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Request class
class Request {
    private int level;

    public Request(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

// Client
public class ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        Request request1 = new Request(2); // Request at Level 2
        Request request2 = new Request(4); // Request not handled by any handler

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
    }
}


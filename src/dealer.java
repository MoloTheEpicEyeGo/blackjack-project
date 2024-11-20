public class dealer implements actions {
    int money;

    // Hit
    @Override
    public void hit() {
        // Dealer logic for hitting
    }

    // Stand
    @Override
    public void stand() {
        // Dealer logic for standing
    }

    // Split
    @Override
    public void split() {
        // Dealer logic for splitting (optional for dealer, as rules vary)
    }

    // Double down
    @Override
    public void doubleDown() {
        // Dealer logic for doubling down (if applicable)
    }

    // Check if dealer || player goes over 21
    @Override
    public boolean over21() {
        // Logic to check if dealer's total is over 21
        return false;
    }
}

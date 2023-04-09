class StockRecord {
    private String symbol;
    private int sharesBought;
    private double purchasePrice;


    public StockRecord(String symbol, int sharesBought, double purchasePrice) {
        this.symbol = symbol;
        this.sharesBought = sharesBought;
        this.purchasePrice = purchasePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSharesBought() {
        return sharesBought;
    }

    public void setSharesBought(int sharesBought) {
        this.sharesBought = sharesBought;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}

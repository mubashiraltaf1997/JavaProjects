import java.util.LinkedList;

class LifoStack {
    LinkedList<StockRecord> records;

    public LifoStack() {
        records = new LinkedList<>();
    }

    public void addRecord(StockRecord record) {
        records.addFirst(record);
    }

    public double getLifoPrice(int numShares) {
        int sharesLeft = numShares;
        double totalPrice = 0.0;

        for (StockRecord record : records) {
            if (sharesLeft <= 0) {
                break;
            }

            int sharesToUse = Math.min(sharesLeft, record.getSharesBought());
            totalPrice += sharesToUse * record.getPurchasePrice();
            sharesLeft -= sharesToUse;
        }

        return totalPrice / numShares;
    }
}

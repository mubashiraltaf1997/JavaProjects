import java.util.LinkedList;


class FifoQueue {
    LinkedList<StockRecord> records;

    public FifoQueue() {
        records = new LinkedList<>();
    }

    public void addRecord(StockRecord record) {
        records.add(record);
    }

    public double getFifoPrice(int numShares) {
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

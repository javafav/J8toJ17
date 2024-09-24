package oop.encapsulation;

public class Printer {
    private int tonerLevel;
    private int pagePrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.pagePrinted = 0;
        this.tonerLevel = (tonerLevel >= 100 && tonerLevel <= 0) ? tonerLevel : -1;
        this.duplex = duplex;

    }

    public int addToner(int tonerAmount) {
        int tempAmount = tonerLevel + tonerAmount;
        if (tempAmount > 100 || tempAmount < 0) {
            return -1;
        }
        return tonerLevel;
    }

    public int printPages(int pages) {
        int jobPages = (duplex) ? (pages / 2 ) + (pages % 2 ) : pages;
        pagePrinted += jobPages;
        return jobPages;
    }

    public int getPagePrinted() {
        return pagePrinted;
    }
}

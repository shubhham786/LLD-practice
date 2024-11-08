public enum Symbol {
    
     CROSS("X"),
     OVAL("O"),
     EMPTY("_");
     
     private String symbol;

    Symbol(String s) {
        this.symbol = s;
    }

    public String getSymbol() {
        return symbol;
    }
}

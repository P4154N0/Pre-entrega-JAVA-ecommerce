package HPGECOMERCEPROJECT.com.hpglab.exeptions;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
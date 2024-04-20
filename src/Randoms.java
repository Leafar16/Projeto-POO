import java.util.Random;

public interface Randoms {
    default int calculaFrqCardiaca() {
        int f;
        f = (int) (Math.random() * (100 - 60)) + 60;
        return f;
    }
}

import java.util.UUID;

public class GeneradorID {

    public static String generarID() {
        return UUID.randomUUID().toString();
    }

}


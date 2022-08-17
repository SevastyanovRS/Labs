package utils;

public class SneakyThrow {

    public static <T extends Throwable> void sneaky(Throwable e) throws T { // looks like runtime
        throw (T) e;
    }

    public void thowableble() {
        if (true) {
            sneaky(new Exception()); //throw not runtime
        }
    }

}

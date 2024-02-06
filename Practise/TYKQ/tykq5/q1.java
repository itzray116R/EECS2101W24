public class q1 {
    public String aMethod(int v, int u) {
        v = v - 1;
        if (v == 0) {
            return u % 2 + "$";
        }
        return aMethod(v, u / 2) + u % 2 + "$";
    }

    public static void main(String[] args) {
        q1 instance = new q1();
        System.err.println(instance.aMethod(7, 76));
    }
}


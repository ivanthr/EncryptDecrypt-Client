public static boolean toPrimitive(Boolean b) {
    boolean b2 = false;
    if(b != null && !b.equals(false)) {
        b2 = true;
    }
    return b2;
}
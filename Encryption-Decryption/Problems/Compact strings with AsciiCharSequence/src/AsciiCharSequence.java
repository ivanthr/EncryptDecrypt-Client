public class AsciiCharSequence implements java.lang.CharSequence {

    byte[] seq;

    public AsciiCharSequence(byte[] seq) {
        this.seq = seq;
    }

    @Override
    public int length() {
        return seq.length;
    }

    @Override
    public char charAt(int index) {
        return (char) seq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subSequence = new byte[end-start];
        int j=0;
        for(int i=start; i<end; i++) {
            subSequence[j++] = this.seq[i];
        }
        return new AsciiCharSequence(subSequence);
    }

    @Override
    public String toString() {
        String s = new String();
        for(byte b : seq) {
            s += (char) b;
        }
        return s;
    }
}
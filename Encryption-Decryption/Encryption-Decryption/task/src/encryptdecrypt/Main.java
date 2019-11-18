package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String operation = "enc";
        String alg = "";
        String data = "";
        String in = "";
        String out = "";
        int key = 0;
        for(int i=0; i<args.length-1; i++) {
            String s = args[i];
            switch (s) {
                case "-mode":
                    operation = args[i+1];
                    if (operation.equals("enc") || operation.equals("dec")) {
                        continue;
                    } else {
                        operation = "enc";
                    }
                    break;
                case "-key":
                    key = Integer.parseInt(args[i+1]);
                    break;
                case "-data":
                    data = args[i+1];
                    break;
                case "-in":
                    in = args[i+1];
                    try {
                        File f = new File(in);
                        data = readFileAsString(f.getPath());
                    } catch (Exception e) {

                    }
                    break;
                case "-out":
                    out = args[i+1];
                    break;
                case "-alg":
                    alg = args[i+1];
                    break;
                default:
                    break;
            }
        }
        // enc or dec
        Algorithm algorithm = null;
        switch (alg.toLowerCase()) {
            case "unicode":
                algorithm = new UnicodeAlgo();
                break;
            case "shift":
                algorithm = new ShiftAlgo();
                break;
            default:
                algorithm = new ShiftAlgo();
                break;
        }
        Processor p = new Processor(algorithm);
        String data2 = p.process(operation, data, key);

        // write to file or system.out
            try (FileWriter fw = new FileWriter(out)) {
                fw.write(data2);
            } catch (Exception e) {
                System.out.println(data2);
            }

    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}

class Processor {

    Algorithm algorithm;

    public Processor(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String process(String op, String s, int k) {
        switch (op.toLowerCase()) {
            case "enc":
                return algorithm.encode(s, k);
            case "dec":
                return algorithm.decode(s, k);
            default:
                return null;
        }
    }
}

interface Algorithm {
    String encode(String s, int k);
    String decode(String s, int k);
}

// a-z 97 - 122
// A-Z 65 - 90
class ShiftAlgo implements Algorithm {

    @Override
    public String encode(String s, int k) {
        String encodedData = "";
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if ( (cc >= 'a' && cc <= 'z') || (cc >= 'A' && cc <= 'Z') ) {
                if (Character.isLowerCase(cc)) {
                    int index = ((cc - 97 + k) % 26) + 97;
                    char nc = (char) index;
                    encodedData += "" + nc;
                } else {
                    int index = ((cc - 65 + k) % 26) + 65;
                    char nc = (char) index;
                    encodedData += "" + nc;
                }
            } else {
                encodedData += "" + cc;
            }
        }
        return encodedData;
    }

    @Override
    public String decode(String s, int k) {
        String decodedData = "";
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if ( (cc >= 'a' && cc <= 'z') || (cc >= 'A' && cc <= 'Z') ) {
                if (Character.isLowerCase(cc)) {
                    int index = (cc - 97 - k);
                    if (index < 0) {
                        index += 26;
                    }
                    index += 97;
                    char nc = (char) index;
                    decodedData += "" + nc;
                } else {
                    int index = (cc - 65 - k);
                    if (index < 0) {
                        index += 26;
                    }
                    index += 65;
                    char nc = (char) index;
                    decodedData += "" + nc;
                }
            } else {
                decodedData += "" + cc;
            }
        }
        return decodedData;
    }
}

class UnicodeAlgo implements Algorithm {

    @Override
    public String encode(String s, int k) {
        String encodedData = "";
        int cc;
        for(int i=0; i<s.length(); i++) {
            cc = s.charAt(i);
            encodedData += (char) (cc + k);
        }
        return encodedData;
    }

    @Override
    public String decode(String s, int k) {
        String decodedData = "";
        int cc;
        for(int i=0; i<s.length(); i++) {
            cc = s.charAt(i);
            decodedData += (char) (cc - k);
        }
        return decodedData;
    }
}
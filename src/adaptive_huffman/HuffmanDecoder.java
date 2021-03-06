package adaptive_huffman;

import rle.RunLengthAlphabetUtil;
import util.AlphabetUtil;
import util.BinaryFileInputStream;
import util.BinaryFileOutputStream;
import util.IllegalCharacterException;

import java.io.IOException;

public class HuffmanDecoder {
    public static void main(String[] args) {
        huffmanDecode(args[0], args[1], new RunLengthAlphabetUtil());
    }

    public static void huffmanDecode(String inPath, String outPath, AlphabetUtil alphabetUtil) {
        try (BinaryFileInputStream input = new BinaryFileInputStream(inPath);
             BinaryFileOutputStream output = new BinaryFileOutputStream(outPath)) {
            new HuffmanTree(alphabetUtil).decode(input, output);
        } catch (IllegalCharacterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

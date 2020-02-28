package io.zipcoder.casino;

public class AsciiHolder {

    public static void mainAscii() throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        System.out.println();
        artGen.printTextArt("C a s i n o", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_MONO,"$");
        System.out.println();
    }
    /*
     - - -
    |     |
    |     |
    |     |
     - - -
     */
//    public static void printCard(String value, String suite){
//        System.out.print(" - - -\n|  " +value+ "  |\n|  "+suite.charAt()+"  |\n|  "+value+"  |\n - - -");
//    }
//    public String toString()
//    {
//        return rank + " of " + suit + "(" + cardValue() + ")";
//    }
}

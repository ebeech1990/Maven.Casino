package io.zipcoder.casino;

public class AsciiHolder {

    private static final String U = "";

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
    public static void printCard(String value, String suite){
        Character symbol = '0';
        if(suite.equals("S")) {
            symbol = '\u2660';
        }
        else if(suite.equals("D")){
            symbol = '\u2666';
        }
        else if(suite.equals("H")){
            symbol = '\u2764';
        }
        else if(suite.equals("C")){
            symbol = '\u2663';
        }
        else{
            System.out.println("invalid input");
        }
        System.out.print(" - - -\n|  " +value+ "  |\n|  "+symbol+"  |\n|  "+value+"  |\n - - -");
    }
//    public String toString()
//    {
//        return rank + " of " + suit + "(" + cardValue() + ")";
//    }
}

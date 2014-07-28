
public class Foothill
{
   public static void main(String[] args)
   {
      String[] sImageIn = 
      { 
            "                                      ",
            "                                      ",
            "                                      ",
            "* * * * * * * * * * * * * * * * *     ",
            "*                                *    ",
            "**** * ****** ** ****** *** ****      ",
            "* ********************************    ",
            "*    *   *  * *  *   *  *   *  *      ",
            "* **    *      *   **    *       *    ",
            "****** ** *** **  ***** * * *         ",
            "* ***  ****    * *  **        ** *    ",
            "* * *   * **   *  *** *   *  * **     ",
            "**********************************    "
      };
      
      String[] sImageIn_2 = 
      { 
            "                                          ",
            "                                          ",
            "* * * * * * * * * * * * * * * * * * *     ",
            "*                                    *    ",
            "**** *** **   ***** ****   *********      ",
            "* ************ ************ **********    ",
            "** *      *    *  * * *         * *       ",
            "***   *  *           * **    *      **    ",
            "* ** * *  *   * * * **  *   ***   ***     ",
            "* *           **    *****  *   **   **    ",
            "****  *  * *  * **  ** *   ** *  * *      ",
            "**************************************    "
      };
      
      BarcodeImage bc = new BarcodeImage(sImageIn);
      DataMatrix dm = new DataMatrix(bc);
     
      // First secret message
      dm.translateImageToText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
      
      // second secret message
      bc = new BarcodeImage(sImageIn_2);
      dm.scan(bc);
      dm.translateImageToText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
      
      // create your own message
      dm.readText("This is a test of the text to image function.");
      dm.generateImageFromText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
   }
}


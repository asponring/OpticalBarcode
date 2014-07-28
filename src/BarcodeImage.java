

public class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] image_data;
   
   public BarcodeImage()
   {
    //chain the constructors, sending this on up with a dummy string array
      this(new String[0]); 
   }
   
   public BarcodeImage(String[] data)
   {
      int row, col, displayRow;
      
      //instantiate the data and set all to false
      image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];
      for (row = 0; row < image_data.length; row++)
      {
         for (col = 0; col < image_data[row].length; col++)
            image_data[row][col] = false;
      }
      
      //sanity check the length of the data, if ok populate the array
      if (checkSize(data))
      {
         for (row = 0, displayRow = image_data.length - data.length; 
               displayRow < image_data.length; row++, displayRow++)
         {
            for (col = 0; col < data[row].length(); col++)
            {
               if (data[row].charAt(col) == DataMatrix.WHITE_CHAR)
                  setPixel(displayRow, col, false);
               else
                  setPixel(displayRow, col, true);
            }
         }
      }
   }
   
   public Object clone() throws CloneNotSupportedException
   {
      //cloning in the standard way
      int row, col;
      BarcodeImage newObject = (BarcodeImage)super.clone();
      
      //the image data needs to me moved over manually
      newObject.image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];
      for ( row = 0; row < MAX_HEIGHT; row++ )
         for ( col = 0; col < MAX_WIDTH; col++ )
            newObject.image_data[row][col] = this.image_data[row][col];
      
      return newObject;
   }
   
   public void displayToConsole()
   {
      int row, col;
      char temp;
      
      // this method takes much from the TwoDimImage class
      //top border first
      System.out.println();
      for ( col = 0; col < MAX_WIDTH + 2; col++ )
         System.out.print("-");
      System.out.println();
      
      // then fill in the middle
      for (row = 0; row < MAX_HEIGHT; row++)
      {
         System.out.print("|");
         for (col = 0; col < MAX_WIDTH; col++)
         {
            temp = DataMatrix.boolToChar(image_data[row][col]);
            System.out.print(temp);
         }
         System.out.println("|");
      }
      
      // bottom
      for ( col = 0; col < MAX_WIDTH + 2; col++ )
         System.out.print("-");
      System.out.println();
   }
   
   public boolean getPixel(int row, int col)
   {
      try 
      {
         return image_data[row][col];   
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         return false;
      }
   }
   
   public boolean setPixel(int row, int col, boolean value)
   {
      try 
      {
         image_data[row][col] = value;
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         return false;
      }
      return true;
   }
   
   private boolean checkSize(String[] data)
   {
      //important method to make sure the string is not too long
      if (data == null || data.length > MAX_HEIGHT)
         return false;
      for (int k = 0; k < data.length; k++)
      {
         if (data[k] == null || data[k].length() > MAX_WIDTH)
            return false;
      }
      return true;
   }
}


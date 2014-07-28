OpticalBarcode
==============

This is a cute demo of an optical barcode reader and writer.

Individual characters are represented as a vertical column of asterisks and spaces, corresponding to the 1s and 0s of
the 8-bit character. 

1. Foothill.java is the main class, run this to get a show of translating text to and from the optical barcode
2. BarcodeIO.java contains a helpful interface 
3. DataMaxtrix.java wraps the optical barcode in a frame, it also has methods to convert a barcode to text and vice versa
4. BarcodeImage.java actually generates the 8-bit representation of the text. It also has a clone method

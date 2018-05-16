package TestPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

public class JpgToPng {
	
	public static void main(String[] args) throws IOException {
		
		File path = new File("C:/Users/Brian/Pictures/ThumbnailGenerator/Melee Thumbnails");
		File[] files = path.listFiles();
		String inputFile;
		String outputFile;
		for(int x = 0; x < files.length; x++)
		{
			inputFile = files[x].getAbsolutePath();
			System.out.println(inputFile);
			outputFile = files[x].getPath();
			//takes off the .jpg and adds the .png suffix, gets saved as a PNG file in the write section.
			//This code would fail if the file did not have an end type, however then the inputfile would not be a .jpg
			outputFile = outputFile.substring(0, outputFile.lastIndexOf('.')) + ".png";
			System.out.println(outputFile);
			
			//read image
			BufferedImage bufferedImage = ImageIO.read(new File(inputFile));
			
			//write image
			ImageIO.write(bufferedImage, "png", new File(outputFile));
			
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", byteArrayOut);
			byte[] resultingBytes = byteArrayOut.toByteArray();
			
		}
	}

}

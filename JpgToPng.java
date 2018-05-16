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
			outputFile = outputFile.substring(0, outputFile.lastIndexOf('.')) + ".png";
			System.out.println(outputFile);
			
			// read a jpeg from a inputFile
			BufferedImage bufferedImage = ImageIO.read(new File(inputFile));

			// write the bufferedImage back to outputFile
			ImageIO.write(bufferedImage, "png", new File(outputFile));

			// this writes the bufferedImage into a byte array called resultingBytes
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", byteArrayOut);
			byte[] resultingBytes = byteArrayOut.toByteArray();
			
		}
	}

}

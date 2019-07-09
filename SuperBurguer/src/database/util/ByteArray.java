package database.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import javafx.scene.image.Image;

public class ByteArray {

	public static byte[] parseToByteArray(File file) {
		try {
			BufferedImage bufferedImage = ImageIO.read(file);

			BufferedImage convertedImg = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_USHORT_565_RGB);
		    convertedImg.getGraphics().drawImage(bufferedImage, 0, 0, null);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(convertedImg, "jpg", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			
			return imageInByte;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static Image parseToImage(byte[] byteArray) {
		return new Image(new ByteArrayInputStream(byteArray));
	}

	public static byte[] parseToByteArray(Blob blob) {
		try {
			if(blob!=null)
				return blob.getBytes(1, ((int)blob.length()) );
		} catch (SQLException ex) {
			System.err.println("Não foi possível converter em array de byte.");
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static Blob parseToBlob(byte[] byteArray) {
		try {
			return new SerialBlob(byteArray);
		} catch (Exception ex) {
			System.err.println("Não foi possível converter em tipo Blob.");
			ex.printStackTrace();
		}
		
		return null;
	}

}

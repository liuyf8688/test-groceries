import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class DownLoad {

	private static final int CHAPTER = 147;
	private static final String ROOT_URI = "http://www.omgbeaupeep.com/comics/The_Walking_Dead/" + CHAPTER + "/";
	private static final String DEST_DIR = "C:\\The_Walking_Dead\\" + CHAPTER + "\\";
	
	public static void main(String[] args) {
		
		int i = 1;
		File directory = new File(DEST_DIR);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		while (true) {
			OutputStream outputStream = null;
			try {
				URLConnection connection = new URL(ROOT_URI + i).openConnection();
				File dest = new File(DEST_DIR + i + ".jpeg");
				if (!dest.exists()) {
					dest.createNewFile();
				}
				System.out.println("================== " + CHAPTER + "   " + dest.getName() + " done !!!");
				outputStream = new FileOutputStream(dest);
				connection.connect();
				IOUtils.write(IOUtils.toCharArray(connection.getInputStream()), outputStream);
				i ++;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

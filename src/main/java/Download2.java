import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Download2 {

	public static void main(String[] args) throws MalformedURLException {

		int max = 136;
		for (int c = 4; c <= max; c ++) { 
			String chapter = StringUtils.leftPad(c + "", 3, "0");
			// 启始编号
			int start = 1;
			// 结束编号
			int end = 55;
			// url中去除最后的文件名的部分
	//		String prefix = "http://www.omgbeaupeep.com/comics/mangas/The%20Walking%20Dead/" + chapter + "%20-%20The%20Walking%20Dead%20147%20(2015)/";
			String prefix = "http://www.omgbeaupeep.com/comics/mangas/The%20Walking%20Dead/" + chapter + "%20-%20The%20Walking%20Dead%20" + chapter + "/";
			// 有规则的文件名称
	//		String pattern = "2-{x}.mp3";
	//		String pattern = "Read-The-Walking-Dead-Comics-Online-{x}.jpg";
			String pattern = "The-Walking-Dead-Comic-{x}.jpg";
			// pattern中，x的位置。是否需要补充空格
			int bitNum = 3;
	
			String fileName = "";
			String urlStr = "";
	
			String dest = "C:\\The_Walking_Dead\\" + chapter;
			String destFile = "";
			InputStream inputStream = null;
			OutputStream outputStream = null;
			CloseableHttpClient httpClient = null;
			CloseableHttpResponse response = null;
			
			File direcotry = new File(dest);
			if (!direcotry.exists()) {
				direcotry.mkdirs();
			}
			byte[] buffer = new byte[4096];
	
			for (int i = start; i <= end; i++) {
	
				//
				fileName = pattern.replaceAll("\\{x\\}", StringUtils.leftPad(i + "", bitNum, "0"));
				urlStr = prefix + fileName;
				HttpGet get = new HttpGet(urlStr);
	
				destFile = dest + "\\" + fileName;
				try {
	
					System.out.println(urlStr);
					httpClient = HttpClients.createDefault();
					response = httpClient.execute(get);
					inputStream = response.getEntity().getContent();
					outputStream = new FileOutputStream(destFile);
	
					int bytesRead = -1;
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
	
					System.out.println("downloaded!" + destFile);
					System.out.println();
					System.out.println(" --- ");
					System.out.println();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
	
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	
					if (outputStream != null) {
						try {
							outputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	
					if (response != null) {
						try {
							response.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	
					if (httpClient != null) {
						try {
							httpClient.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
	
			}
		}
	}

}

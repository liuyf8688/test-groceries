import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class FreemarkerDemo {

	public static void main(String[] args) throws IOException, TemplateException {
		
		String baseDirPath = "C:\\CompanyProjects\\fairgarage\\Git_ws\\uv-fg-be-foundation\\smp-content\\src\\main\\content\\mails";
		
		Configuration config = new Configuration();
		config.setTemplateLoader(new FileTemplateLoader(new File(baseDirPath)));
		
//		Files.walk(Paths.get(baseDirPath)).forEach(filePath -> {
//			if (Files.isRegularFile(filePath)) {
//				File file = filePath.toFile();
//				String path = file.getAbsolutePath().substring(baseDirPath.length());
//				try {
//					config.getTemplate(path);
//				} catch (Exception e) {
//					System.out.println(baseDirPath + path);
//					System.out.println(e.getMessage());
//				}
//			}
//		});
		
		final File folder = new File(baseDirPath);
		List<File> files = listFilesForFolder(folder);
		
		System.out.println("sum of files: " + files.size());
		System.out.println();
		System.out.println();
		
		for (File file : files) {
			String path = file.getAbsolutePath().substring(baseDirPath.length());
			try {
				config.getTemplate(path);
			} catch (Exception e) {
				System.out.println(baseDirPath + path);
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<File> listFilesForFolder(final File folder) {
		List<File> files = new ArrayList<>();
		for (final File file : folder.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(listFilesForFolder(file));
			} else {
				files.add(file);
			}
		}
		
		return files;
	}

}

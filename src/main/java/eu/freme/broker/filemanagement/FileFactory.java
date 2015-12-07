package eu.freme.broker.filemanagement;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

public class FileFactory {

	
	public static File generateFileInstance(String path) throws IOException {
		
		try{ 
			//Test if it is http file
			if(path.startsWith("http")){
				UrlResource ur = new UrlResource(path);
				if(ur!=null && ur.exists()){
					return ur.getFile();
				}
				else{
					throw new IOException("HTTP file not found or not accesible.");
				}
			}
			else if(path.startsWith("ftp")){
				UrlResource ur = new UrlResource(path);
				//TODO Authentication needed
				if(ur!=null && ur.exists()){
					return ur.getFile();
				}
				else{
					throw new IOException("FTP file not found or not accesible.");
				}
			}
			else{
				//The rest of the possibilities: classpath, filesystem or network storage
				ClassPathResource cpr = new ClassPathResource(path);
				if(cpr!=null && cpr.exists()){
					return cpr.getFile();
				}
				else{
					FileSystemResource fsr = new FileSystemResource(path);
					if(fsr!=null && fsr.exists()){
						return fsr.getFile();
					}
					else{
						//Network storage
						UrlResource ur = new UrlResource(path);
						if(ur!=null && ur.exists()){
							return ur.getFile();
						}
						else{
							throw new IOException("Network file not found or not accesible.");
						}
					}
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
			throw e;
		}
	}
}

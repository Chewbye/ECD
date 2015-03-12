import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ARFF {

	public String  arffContent;
	
	public ARFF(String filePath, String nomClasse, String targetPath){
		arffContent = "\n\n@relation series";
		arffContent += "\n\n@attribute nom_fichier string";
		arffContent += "\n@attribute contenu string";
		arffContent += "\n@attribute classe {animation, crime, medical}";
		arffContent += "\n\n@data";
		
		try {
			Path p = Paths.get(filePath);
			String fileName = p.getFileName().toString();
			
			String fileContent = readFile(filePath, StandardCharsets.UTF_8);
			arffContent += "\n" + fileName + ",\""+ fileContent.replace("\"", "").replace("\n", "") + "\"," + nomClasse;
			System.out.println(arffContent);
			
			File file = new File(targetPath);
			 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(arffContent);
			bw.close();
 
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
}

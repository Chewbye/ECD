import java.io.File;


public class Main {
	
	public static void main(String[] args){
		String projectPath = "/auto_home/llafon/Cours/semestre8/ECD/ECD";
		
		
		
		File[] files= getListOfFiles(projectPath + "/corpus/animation");
		for(File f: files){
			ARFF arff = new ARFF(f.getAbsolutePath(), "animation", projectPath + "/arff/" + f.getName() +".arff");
		}
	}

	public static File[] getListOfFiles(String folderPath){
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        System.out.println("File " + listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }	
	    
	    return listOfFiles;
	}
}

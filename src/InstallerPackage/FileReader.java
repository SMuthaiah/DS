package InstallerPackage;

public class FileReader {
	
	private FileReader(){
		
	}
	
	public static FileReader fileInstance = new FileReader();

	
	
	public static FileReader getFileInstance() {
		return fileInstance;
	}

	public static void setFileInstance(FileReader fileInstance) {
		FileReader.fileInstance = fileInstance;
	}
	
	public void readDependency(){
		//read from file and call setDependency method
	}
	
	public void writeDependency(){
		
		//at the end of the program, write the dependency back to file. 
	}
	
	
	

}

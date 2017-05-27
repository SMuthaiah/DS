package InstallerPackage;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
	
	static Scanner sc;
	static InputParser parser;
	static Dependency dependency;
	static Installer installer;
	
	public UI(){
	sc = new Scanner(System.in);
	parser = new InputParser(); 	
	}
	
	private static void decideOption(){
			
		boolean check = true;
		int option = 0;
		
		while(check){
		System.out.println("Welcome to Somu's Installer");
		System.out.println("===========================");
		System.out.println("Choose the Relevant Options");
		System.out.println("1. Install a Component");
		System.out.println("2. Uninstall a Component");
		System.out.println("3. Set Dependency for a Component");
        System.out.println("4. View Installed Components");
        System.out.println("5. Exit installer");
		System.out.println("Press 1/2/3/4/ based on the above options");
		System.out.println("===========================================");
		System.out.println("                                            ");
		
		
		
		try{
		option = sc.nextInt();
		}
		catch(InputMismatchException e){
			option = 0;
			sc.nextLine();
		}
		switch(option){
		
		case 0: 
			System.err.println("Please choose option from 1 to 5");
			break;
		
		case 1:
			//Invoke Install component
			System.out.println("Please provide the Install Component Command. Example: INSTALL TCP");
			sc.nextLine();
			String input = sc.nextLine();
			
			String cmd = parser.getCommandFromInput(input);
			String comp = parser.getComponentFromInput(input);
			
			if(cmd.equals("INSTALL")){
				installer.InstallComponent(comp);
				
			}
			
			System.out.println("                                 ");
			System.out.println("                                 ");
			
			break;
		case 2: 
			//Invoke unintsall component
			System.out.println("Please provide the REMOVE Component Command. Example: REMOVE TCP");
			sc.nextLine();
			String a = sc.nextLine();
			
			String c = parser.getCommandFromInput(a);
			String cmp = parser.getComponentFromInput(a);
			
			if(c.equals("REMOVE")){
				installer.removeComponent(cmp);
			}
			
			System.out.println("                                 ");
			System.out.println("                                 ");
			
			break;
				
		case 3: 
			System.out.println("Please provide the Component and Its dependencies. Example: DEPEND NOTEPAD WINDOWSOS");
			sc.nextLine();
			String userInput = sc.nextLine();
			
			String command = parser.getCommandFromInput(userInput);
			String component = parser.getComponentFromInput(userInput);
			String[] dependencies = parser.getDependencyFromInput(userInput);
			
			
			//Call to Make Dependency
			dependency.makeDependencies(component, dependencies);
			System.out.println("                                 ");
			System.out.println("                                 ");
			break;
			
		case 4:
			System.out.println("You have choosen to List the installed Components");
			installer.printListedComponents();
			System.out.println("                                 ");
			System.out.println("                                 ");
			break;
			
		case 5:
			System.out.println("EXITING THE INSTALLER, THANK YOU");
			check = false;
			break;
			
		default:
			System.err.println("Please Choose option from 1 to 5");
		    break;
		
		}
		
		}
		
		
	}
	
	public static void main (String args[]){
		
		//read the file upon program initialization. 
		FileReader fileReader = FileReader.getFileInstance();
		fileReader.readDependency();
		
		//Create Dependency and Installer Instance 
		 dependency = Dependency.getInstance();
		 installer = Installer.getInstance();
		
		//Initialize UI
		UI ui = new UI();
		decideOption();
		
	}

}

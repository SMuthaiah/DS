package InstallerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Installer {
	
	private static Installer installerInstance = null;
	private static Object mutex = new Object();
	
	HashMap<String, Component> installedComponents = new HashMap<String,Component>();
	HashMap<String, Component> availableComponents = new HashMap<String, Component>();

	
	private Installer(){
		
	}
	
	//Make the Installer class as Singleton and thread safe.
			public static Installer getInstance(){
				if(installerInstance == null){
					synchronized(mutex){
						if(installerInstance == null){
							installerInstance = new Installer();
						}
						
					}
				}	
				return installerInstance;
			}
	
	//Get the List of Installed Components
	public HashMap<String,Component> getInstalledComponents() {
		
		return installedComponents;
	}

	//Set Installed Components
	public void setInstalledComponents(HashMap<String,Component> installedComponents) {
		this.installedComponents = installedComponents;
	} 
	
	public HashMap<String, Component> getAvailableComponents() {
		return availableComponents;
	}

	public void setAvailableComponents(HashMap<String, Component> availableComponents) {
		this.availableComponents = availableComponents;
	}

	
	public synchronized void InstallComponent(String component){
		
		Dependency dep = Dependency.getInstance();
		
		
		if(!checkComponentIsInstalled(component)){
		
		if(!checkComponentIsAvailable(component)){
			this.addComponent(component);	
		}
		
		Component compObj = this.getComponentObject(component);
		ArrayList<Component> dependencies = dep.getAllDependencies(compObj);
		
		
		for(Component c:dependencies){
			
			String ComponentName = c.getComponentName();
			
			
			//Installing the dependencies first but check that it is not already installed and it is not the actual component.
			if(!this.installedComponents.containsKey(ComponentName) && (!c.getComponentName().equals(component))){
				System.out.println("Installing Dependency Component" + " " + ComponentName);
				this.installedComponents.put(ComponentName, c);
			}
			
			
		}
		
		//Install the actual component here. 
		System.out.println(" Installing..." + component);
		this.installedComponents.put(component, compObj);
		}
		else{
			System.out.println("The component" + "" + component + "" + "Is already installed");
		}
		
	}
	
	public synchronized void addComponent(String component){
		
		Component newComponent = new Component(component,false);
		this.availableComponents.put(component, newComponent);
		return;
	}
	
	//Remove the given component. 
	public synchronized void removeComponent(String component){
		
		if(!checkComponentIsInstalled(component)){
			System.err.println("Component has never been installed");
			return;
		}
		
		if(checkDependantComponentsInstalled(component)){
			
			Component comp = this.getComponentObject(component);
			LinkedList<Component> dependencyComponents =  comp.getDependencyList();
			
			this.removeCompFromHash(component);
			
			for(Component c: dependencyComponents){
				
				boolean isOKtoUnistall =  true;
				LinkedList<Component> depandants = c.getDependantList();
				
				for(Component com : depandants){
					
					if(checkComponentIsInstalled(com.getComponentName()))
						isOKtoUnistall = false;
					
					
				}
				
				if(isOKtoUnistall){
					
					removeCompFromHash(c.getComponentName());
					
				}	
				
			}
			
		}
		
		else{
			
			System.err.println("You cannot delete this component as It is still needed by other dependant components");
		}
			
		
	}
	
	
	
	//utility method to remove the comp from HashSet
	
	public void removeCompFromHash(String ComponentName){
		
		System.out.println("Removing Component" + " "+ ComponentName);
		installedComponents.remove(ComponentName);
	
	}
	
	
	//utility method to check if Dependent components are installed
	
	public boolean checkDependantComponentsInstalled(String CompononentName){
		
		Component compObj = availableComponents.get(CompononentName);
		LinkedList<Component> depandents = null;
		
		if(compObj!=null){
			depandents = compObj.getDependantList();
		}
		
		if(depandents==null){
			return true;
		}
		
		if(depandents.size() == 0)
			return true;
		
		for(Component c:depandents){
			
			if(installedComponents.containsKey(c.getComponentName()))
				return false;
			
		}
		
		return true;
		
		
	}
	
	//Utility method to check if a component is present in the availableComponentsList
	
	public boolean checkComponentIsAvailable(String componentName){
		
		if (availableComponents.containsKey(componentName))	
				return true;
		else
				return false;
			
	}
	
	//utility method to check if the component is in the installed list
	
	public boolean checkComponentIsInstalled(String componentName){
		
		if(installedComponents.containsKey(componentName))
			return true;
		else
			return false;
		
	}

	//Utility method to get the componentObject
	
	public Component getComponentObject(String componentName){
		
		Component c;
		if(availableComponents.containsKey(componentName))
			c = availableComponents.get(componentName);
		else
			return null;
		
		return c;
	}
	
	
	//Method to list all the installed Components 
	
	public void printListedComponents(){
		
		try{
		for(Component c : installedComponents.values()){
			
			System.out.println("Component" + " " + c.getComponentName() + " " + "Is Installed");
			
		}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

	
}
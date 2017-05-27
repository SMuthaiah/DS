package InstallerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Dependency {
	
	private static Object mutex = new Object();
	private static Dependency dependencyInstance = null;
	Installer installer;
	
	private Dependency(){	
	}
	
	    //Make the dependency class as Singleton.
		public static Dependency getInstance(){
			if(dependencyInstance == null){
				synchronized(mutex){
					if(dependencyInstance == null){
						dependencyInstance = new Dependency();
					}
					
				}
			}	
			return dependencyInstance;
		}
	
		//Method to Make the dependencies for a given component
		public void makeDependencies(String Component, String[] dependencies){
			
			Component comp;
			Component dep;
			
			installer = Installer.getInstance();
			if(installer.checkComponentIsAvailable(Component))
					comp = installer.getComponentObject(Component);
			else{
				  	installer.addComponent(Component);
				  	comp = installer.getComponentObject(Component);
			}
			
			//Now check if the dependency components are also in the available components. 
			//And add it to the dependencies list. And Add the component to the respective depandant's list.
			
			for(int i=0; i<dependencies.length;i++){
				
				if(installer.checkComponentIsAvailable(dependencies[i])){
					dep = installer.getComponentObject(dependencies[i]);
					if(comp!=null && dep!=null){
						comp.getDependencyList().add(dep);
						dep.getDependantList().add(comp);
					}
				}
					
			else{
				  	installer.addComponent(dependencies[i]);
				  	dep = installer.getComponentObject(dependencies[i]);
				  	if(comp!=null && dep!=null){
						comp.getDependencyList().add(dep);
						dep.getDependantList().add(comp);
					}
			}
					
			}
			
		}
		
		
		//This is the Breadth-first search algorithm for traversing our graph 
		//and identifying all the dependencies.
		
		public ArrayList<Component> getAllDependencies(Component Component){
			
			ArrayList<Component> dependencies = new ArrayList<Component>();
			Queue<Component> q = new LinkedList<Component>();
			
			q.offer(Component);
			Component.setVisited(true);
			
			while(!q.isEmpty()){
			
			Component compFromQ = q.poll();
			dependencies.add(compFromQ);
			
			LinkedList<Component> comp = compFromQ.getDependencyList();
			
			
			if(comp!=null && comp.size() > 0){
				
				for(Component c: comp){
					
					if(c.isVisited() == false)
					{
						c.setVisited(true);
						q.offer(c);
					}
					
				}
				
			}
			
			}
			
			//Reset the Flags back to false. 
			installer = Installer.getInstance();
			HashMap<String, Component> hm= new HashMap<String,Component>();
			for(Component c:hm.values()){
				
				c.setVisited(false);
				
			}
			
			
			return dependencies;
		}
	
		//This Utility method checks what are the dependencies for the component to be installed. 
		public boolean checkDependencies(String Component){
			
			return true;
			
		}
	

}

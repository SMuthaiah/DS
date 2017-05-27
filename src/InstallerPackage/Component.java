package InstallerPackage;

import java.util.LinkedList;

public class Component {

	private String componentName;
	boolean isVisited;
	
	//removing is easy in the future, hence using linkedlist to represent Adjacency List.
	private LinkedList<Component> dependencyList;
	private LinkedList<Component> dependantList; 
	
	public Component(String name, boolean isVisited){
		
		this.componentName = name;
		this.isVisited = isVisited; 
		dependencyList = new LinkedList<Component>(); 
		dependantList = new LinkedList<Component>();
		
	}
	
	
	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public LinkedList<Component> getDependencyList() {
		return dependencyList;
	}

	public void setDependencyList(LinkedList<Component> dependencyList) {
		this.dependencyList = dependencyList;
	}

	public LinkedList<Component> getDependantList() {
		return dependantList;
	}

	public void setDependantList(LinkedList<Component> dependantList) {
		this.dependantList = dependantList;
	}
	
}

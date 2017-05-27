import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.HashMap;


import org.junit.Test;
import InstallerPackage.*;

public class InstallerTests {
	
	final static String component = "CHROME";
	final static String[] dependencies = {"BROWSER","WINDOWS"};
	final static String componentB = "BROWSER";
	final static String[] dependenciesB = {"MONITOR"};
	static Dependency dep = Dependency.getInstance();
	static Installer ins = Installer.getInstance();
	
	@BeforeClass
	public static void setUpClass(){	
		dep.makeDependencies(component, dependencies);
		dep.makeDependencies(componentB, dependenciesB);		
	}
	
	@Test
	public void MakeDependencytest(){
		
		Component c = ins.getComponentObject(component);	
		String[] actualOutput = new String[c.getDependencyList().size()];
		int i=0;
		for(Component comp: c.getDependencyList()){
			
			actualOutput[i++] = comp.getComponentName();	
		}
		
		assertArrayEquals("The Arrays are not equals", dependencies, actualOutput);
		
	}

	
	@Test
	public void CheckGetDependencyTest(){
		
		
		
		Component c = ins.getComponentObject(component);
		
		
		ArrayList<Component> components = dep.getAllDependencies(c);
		String[] actualOutput = new String[components.size()];
		int i=0;
		
		for(Component comp: components){
			System.out.println(comp.getComponentName() + "printing");
			actualOutput[i++] = comp.getComponentName();	
		}
		
		String[] expectedOutput = {"CHROME", "BROWSER","WINDOWS","MONITOR"};
		
		assertEquals("The dependencies are not set correctly", expectedOutput, actualOutput);
		
	}
	
	@Test
	public void InstallTest() {
		
		ins.InstallComponent(component);

		HashMap<String,Component> hm = ins.getInstalledComponents();
		
		String s = hm.get(component).getComponentName();
		 
		assertEquals("Failure in installing component", component, s);
	
	}
	
	@Test
	public void removeComponentTest(){
		
		ins.removeComponent(component);
		HashMap<String,Component> hm = ins.getInstalledComponents();
		assert(hm.size()==0);
		
	}

	

}

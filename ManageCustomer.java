/*
Name	: Hoo Ern Ping
ID		: B200152B
*/
package application;
import java.util.*;

public class ManageCustomer{

	//--------declare arrayList-----------
	private ArrayList<Customer> entry;
	
	//--------default constructor---------
	public ManageCustomer(){
		entry = new ArrayList<Customer>();
	}
	
	//------------------task method------------------------
	//Add method
	public String add(Customer newCustomer){
		String text = "";
		boolean found = false;
		
		for(int i=0; i<entry.size() && found == false; i++) {
			Customer p = entry.get(i);
			//Search the availability of customer id in entry array list
			if(p.getCustomerId().equalsIgnoreCase(newCustomer.getCustomerId())) {
				found = true;
			}
		}
		
		if(found == true){
			text = "Record of customer id: "+ newCustomer.getCustomerId()+" exists."+
					"\nPlease enter other customer id.";
		}else{
			entry.add(newCustomer);
			text = "Added customer id: "+ newCustomer.getCustomerId()
			+ entry.get(entry.size()-1).toString();
		}
		return text;
	}
	
	//Search method
    public String search(String customerId){ 
        int j; 
        
        for(j=0;j<entry.size();j++){
        	Customer p = entry.get(j);
            if(p.getCustomerId().equalsIgnoreCase(customerId)){
                break;
            }
        }
        
        if(j==entry.size()){
        	return "Cannot find the customer id";
        }else{
        	return entry.get(j).toString();
        }
    }
	
	//-----remove method
	public String remove(String customerId){
		int j;
		
        for(j=0;j<entry.size();j++){
            Customer p = entry.get(j);
            if(p.getCustomerId().equalsIgnoreCase(customerId)){
                break;
            }
        }
        
        if(j==entry.size()){
            return "---Cannot find the customer id---";
        }else{
        	entry.remove(j);
        	return "---Customer id: "+customerId+" is removed succefully.";
        }
	}
    
    //------------------toString Method-----------------------
    public String toString(){
    	String output = "";
    	
    	for(Customer c: entry){
    		output += c + "\n";
    	}
    	return output;
    }
}
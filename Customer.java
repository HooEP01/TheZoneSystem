/*
Name	: Hoo Ern Ping
ID		: B200152B
*/
package application;
public class Customer {
	
    //-------instance variable--------
    private String customerId;
    private String customerName;
    private int quantity;
    private String shippingMethod;
    
    //-------default constructor-------
    public Customer(){
        customerId = "";
        customerName = "";
        quantity = 0;
        shippingMethod = ""; 
    }
    
    //------------Constructor with parameter------------------
    public Customer(String customerId, 
    				String customerName,
                    int quantity, 
                    String shippingMethod){
        this.customerId = customerId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.shippingMethod = shippingMethod;
    }
    
    //----------accessor methods or get methods------------
    public String getCustomerId(){
        return customerId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getShippingMethod(){
        return shippingMethod;
    }
    
    //----------mutator methods or set methods--------------
    public void setCustomerId(String newCustomerId){
        customerId = newCustomerId;
    }
    public void setCustomerName(String newCustomerName){
        customerName = newCustomerName;
    }
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public void setShippingMethod(String newShippingMethod){
        shippingMethod = newShippingMethod;
    }
    
    //------------------task method------------------------
    //Compute the unit price
    public double calcTotalPrice(){
        double unit = getQuantity();
        double totalPrice = 0.0;
        
        if(unit >= 216){
            totalPrice = unit * 2.00;
        }
        else if(unit >= 108){
            totalPrice = unit * 2.27;
        }
        else if(unit >= 48){
            totalPrice = unit * 2.63;
        }
        else {
            totalPrice = unit * 2.85;
        }
        return totalPrice;
    }
    
    //Compute shipping charge
    public double calcTotalShippingCharge(){
        double chargePerUnit = 0.0;
        
		if(getShippingMethod().equalsIgnoreCase("Truck")) {
			chargePerUnit = 0.20;
		}else if(getShippingMethod().equalsIgnoreCase("Rail")) {
			chargePerUnit = 0.18;
		}else if(getShippingMethod().equalsIgnoreCase("Ship")) {
			chargePerUnit = 0.12;
		}else {
			chargePerUnit = 0.0;
		}
		
		return chargePerUnit * getQuantity();
    }
    
	//------------------toString Method-----------------------
	public String toString() {
		return 	"\nCustomer ID: "+getCustomerId()+
				"\nCustomer Name: "+getCustomerName()+
				"\nQuantity: "+getQuantity()+
				"\nTotal Price: "+String.format("%.2f",calcTotalPrice())+
				"\nTotal Shipping: "+String.format("%.2f",calcTotalShippingCharge());
	}
}	


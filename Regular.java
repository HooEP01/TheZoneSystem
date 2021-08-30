/*
Name	: Hoo Ern Ping
ID		: B200152B
*/
package application;
public class Regular extends Customer{
	
	//-------default constructor-----
	public Regular(){
			
	}
		
	//------------Constructor with parameter------------------
	public Regular(String customerId, 
				   String customerName, 
				   int quantity, 
				   String shippingMethod){
		super(customerId, customerName, quantity, shippingMethod);
	}
	
	//------------------task method------------------------
	//Compute total shipping discount
	public double calcTotalShippingDiscount(){
		double totalPrice = super.calcTotalPrice();
		double totalShippingDiscount = 0.0;
		double shippingDiscount = 0.0;
		double totalShippingCharge = super.calcTotalShippingCharge();
		
		if(totalPrice >= 1200) {
			shippingDiscount = 0.20; // discount 20%
		}else if(totalPrice >= 400) {
			shippingDiscount = 0.10; // discount 10%
		}else {
			shippingDiscount = 0.0; // discount 0%s
		}
		
		totalShippingDiscount = totalShippingCharge * shippingDiscount;
		return totalShippingDiscount;
	}
	
	//Compute grand total price
    public double calcGrandTotal(){
        double grandTotal = calcTotalPrice() + calcTotalShippingCharge() - calcTotalShippingDiscount();
        return grandTotal;
    }
    
    //------------------toString Method-----------------------
	public String toString() {
		return  super.toString()+
				"\nTotal Shipping Discount: "+String.format("%.2f",calcTotalShippingDiscount())+
				"\nGrandTotal: " +String.format("%.2f",calcGrandTotal());
	}
}

package pack;

public class Carts extends Products {
	 int user_id;
	 int quantity;
	 int cart_id;
     Carts(int cart_id,int user_id,int qunatity){
    	 this.user_id=user_id;
    	 this.quantity=qunatity;
    	 this.cart_id=cart_id;
     }
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	 
     
     
}

package pack;

public class Products {
   private int id;
   private String name,category,img;
   private double price;
   Products(int id,String name,double price,String category,String img){
	   this.id=id;
	   this.name=name;
	   this.category=category;
	   this.img=img;
	   this.price=price;
   }
   Products(){}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
   
}

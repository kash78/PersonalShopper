package ps.project;

public class items {
protected String Items;
protected String Country;
protected String Price;
protected String Weight;
protected String Category;
protected String Supermarket;
protected String Stock;
public items() {}
public items(String Items, String Country, String Price, String Weight,String Category,String Supermarket,String Stock) {
super();
this.Items = Items;
this.Country = Country;
this.Price =  Price;
this.Weight = Weight;
this.Category = Category;
this.Supermarket = Supermarket;
this.Stock= Stock;
}
public String getItems() {
return Items;
}
public void setItems(String Items) {
this.Items = Items;
}
public String getCountry() {
return Country;
}
public void setCountry(String Country) {
	this.Country = Country;
}
public String getPrice() {
return Price;
}
public void setPrice(String Price) {
	this.Price =  Price;
}
public String getWeight() {
return Weight;
}
public void setWeight(String Weight) {
	this.Weight = Weight;
}
public String getCategory() {
return Category;
}
public void setCategory(String Category) {
	this.Category = Category;
}
public String getSupermarket() {
return Supermarket;
}
public void setSupermarket(String Supermarket) {
	this.Supermarket = Supermarket;
}

public String getStock() {
return Stock;
}
public void setStock(String Stock) {
	this.Stock = Stock;
}
}

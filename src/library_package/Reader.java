package library_package;

public class Reader {
int id;
String name;
String phone;

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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public Reader(int id, String name, String phone) {
	this.id = id;
	this.name = name;
	this.phone = phone;
}

public Reader() {
	
}
public String toString() {
	return "ID: " + id + " | Nome: " + name + " | Telefone: " + phone;
}



}

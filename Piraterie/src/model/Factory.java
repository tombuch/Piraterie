package model;

public class Factory {

	public Components create(String readed){
		String[] s = readed.split(";");
		if (s[0].equals("Boat")){
			return new Boat(Double.parseDouble(s[1]), Double.parseDouble(s[2])); 
		}
		if (s[0].equals("Zepplin")){
			return new Zepplin(Double.parseDouble(s[1]), Double.parseDouble(s[2])); 
		}
		return null;
	}
}

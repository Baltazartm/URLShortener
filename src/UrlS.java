
public class UrlS {
	
	public static final String alphabet = "23456789bcdfghjklmnpqrstuvwxyzBCDFGHJKLMNPQRSTUVYXYZ";
	public static final int base = alphabet.length();

	public UrlS() {
		// TODO Auto-generated constructor stub
	
	}
	// assigning id by checking max id in database increment by 1
	public static String shortURL(String urlName){
		int idS = SQLiteData.getMaxId() + 1;
		String shorten = encode(idS);
		
		SQLiteData.insertToTable(idS, urlName, shorten);
		//System.out.println(idS + " " + urlName + " " + shorten);
		return shorten;
	}
	// 	encode id using base 52
	public static String encode(int num){
		System.out.println("encoder worked");
		StringBuilder str = new StringBuilder();
		while (num > 0){
			str.insert(0, alphabet.charAt(num % base));
			num = num / base;
		}
		//System.out.println("encoded " + str);
		return str.toString();
	}
	// takes the shorten url then decode and find name base on id
	public static String longURL(String urlLong){
		int decodedId = decode(urlLong);
		String decodedName = SQLiteData.getUrlName(decodedId);
		System.out.println(decodedName);
		//System.out.println(idL);
		return decodedName;
	}
	// decode shorten url
	public static int decode(String str){
		int num = 0;
		for(int i=0; i<str.length(); i++){
			num = num * base + alphabet.indexOf(str.charAt(i));
		}
		//System.out.println("ID = " + num);
		return num;
	}
}

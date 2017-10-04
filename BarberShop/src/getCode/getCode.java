package getCode;

public class getCode {

	public static String code() {
		String code=(int)((Math.random()*9+1)*100000)+"";
		return code;
	}
}

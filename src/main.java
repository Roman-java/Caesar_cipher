import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        System.out.println("Input a text:");
        String str = in.nextLine();
        System.out.println("Input a number:");
        int num = in.nextInt();
	    
        System.out.println("Text:");
	    System.out.println(str);
	    System.out.println("Code:");
        System.out.println( main.encode( str, num ));
        System.out.println("Decode:");
        System.out.println( main.decode( main.encode( str, num), num));
    }
	
    public static String decode(String enc, int offset) {
    	StringBuilder decoded = new StringBuilder();
    	
    	for (char i : encode(enc, 27-offset).toCharArray())
    		if (i == '`')
    			decoded.append((char) (' '));
    		else
    			decoded.append((char) (i));
    	enc=decoded.toString();
		return enc;
    }
 
    public static String encode(String enc, int offset) {
        offset = offset % 27 + 27;
        StringBuilder encoded = new StringBuilder();
        
        for (char i : enc.toCharArray()) {
        	if(((char) ('`' + (i - '`' + offset) % 27 )) == '`')
        		encoded.append(' ');
        	else if (Character.isSpace(i))
        		encoded.append((char) ('`' + ('`' - '`' + offset) % 27 ));
        	else if (Character.isUpperCase(i))
                encoded.append((char) ('@' + (i - '@' + offset) % 27 ));
            else
                encoded.append((char) ('`' + (i - '`' + offset) % 27 ));
        }
        return encoded.toString();
    }
}
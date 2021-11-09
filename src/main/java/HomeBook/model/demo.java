package HomeBook.model;

import java.sql.SQLException;
import java.util.List;

import Filter.BCrypt;
import JDBC_book.listUser;

/**
 * Author: Ian Gallagher <igallagher@securityinnovation.com>
 *
 * This code utilizes jBCrypt, which you need installed to use.
 * jBCrypt: http://www.mindrot.org/projects/jBCrypt/
 */

public class demo {

	private static int workload = 12;
	
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}
	
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}

	
	public static void main (String[] args) throws SQLException {
//		String passString;
//		passString =  demo.hashPassword("111");
//		System.out.print(passString);
//		
//		System.out.print(demo.checkPassword("888", "$2a$12$zwJ4QgqeFLH5azjD8bGSyeb2PzjEaEph/D.njqtI.RUsTxgVgYIka"));

		
		listUser list = new listUser();
		List<User> list_user;
		
		list_user = list.getUser("tuan1");
		User user = list_user.get(0);
		System.out.print(user.getUser());
	}
	
}

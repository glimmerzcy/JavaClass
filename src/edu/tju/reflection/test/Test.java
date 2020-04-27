package edu.tju.reflection.test;

import java.util.ArrayList;
import java.util.List;

import edu.tju.reflection.entity.User;
import edu.tju.reflection.sql.SQLUnit;
import edu.tju.reflection.sql.SQLable;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setUsername("zhangsan");
		user.setAge(7);
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("lisi");
		user2.setAge(8);
		user2.setEmail("456@kk.com");
		user2.setTelephone("789456");
		
		SQLUnit sqlUnit = new SQLUnit();
		
		try {
			System.out.println("test query");
			System.out.println(sqlUnit.query(user));
			System.out.println("test insert");
			System.out.println(sqlUnit.insert(user));
			
			System.out.println("test insert2");
			List<SQLable> userList = new ArrayList<SQLable>();
			userList.add(user);
			userList.add(user2);
			System.out.println(sqlUnit.insert(userList));
			
			System.out.println("test update");
			System.out.println(sqlUnit.update(user2));
			
			System.out.println("test delete");
			System.out.println(sqlUnit.delete(user));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
}

package js.com.br.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public abstract class DB {
	private static int idSequency = 1;
	private static List<User> users = new ArrayList<>();
	private static List<Company> companies = new ArrayList<>();

	static {
		users.add(new User("joao", "123"));
		users.add(new User("lara", "123"));

		addCompany(new Company("Google", new Date()));
		addCompany(new Company("Microsoft", new Date()));
	}

	public static void addCompany(Company c) {
		c.setId(idSequency);
		companies.add(c);
		idSequency++;
	}

	public static List<Company> getCompanies() {
		return companies;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static User getUser(String login, String password) {
		for (User user : getUsers()) {
			if (user.authenticate(login, password)) {
				return user;
			}
		}

		return null;
	}

	public static Company findById(int id) {
		Company c = null;

		for (Company item : companies) {
			if (item.getId() == id) {
				c = item;
				break;
			}
		}

		return c;
	}

	public static void removeCompany(int id) {
		Iterator<Company> iterator = companies.iterator();
		while (iterator.hasNext()) {
			Company c = iterator.next();
			if (c.getId() == id) {
				iterator.remove();
			}
		}
	}

}

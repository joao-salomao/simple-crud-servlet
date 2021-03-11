package js.com.br;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public abstract class DB {
	private static int idSequency = 1;
	private static List<Company> companies = new ArrayList<>();
	
	static {
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

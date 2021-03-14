package js.com.br.models;

public class User {
	private String login;
	private String password;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public boolean authenticate(String login, String password) {
		if (!this.login.equals(login)) {
			return false;
		}

		if (!this.password.equals(password)) {
			return false;
		}

		return true;
	}

}

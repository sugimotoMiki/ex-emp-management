package jp.co.sample.domain;

/**
 * 管理者を表すクラスです
 * @author sugimoto
 *
 */
public class Administrator {
	
	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**メールアドレス*/
	private String mail;
	/**パスワード*/
	private String password;
	
	public Administrator() {
	}
	
	public Administrator(Integer id, String name, String mail, String password) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}
}

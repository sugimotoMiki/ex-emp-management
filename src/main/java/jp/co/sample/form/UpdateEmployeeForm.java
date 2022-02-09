package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

public class UpdateEmployeeForm {

	/**ID*/
	private String id;
	/**扶養人数*/
	@NotBlank(message="いない場合は0を入力してください")
	private String dependentsCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
	
}

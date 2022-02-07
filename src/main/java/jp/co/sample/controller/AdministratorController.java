package jp.co.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;

@Controller
@RequestMapping("/")
public class AdministratorController {

	/**
	 * フォームオブジェクトをrequestスコープに格納
	 * @return フォームオブジェクトがリクエストスコープに格納されます
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * @return　管理者登録画面へフォワードします
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		
		return "administrator/insert";
	}
	
	
}

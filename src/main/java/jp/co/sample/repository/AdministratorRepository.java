package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final static RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("maid_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	/**
	 * 管理者を登録をする
	 * @param administrator
	 */
	public void insert(Administrator administrator) {

		if (administrator.getId() == null) {
			SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
			String sql = "insert into administrators (name,mail_address,password) values(:name,:mailAddress,:password)";
			template.update(sql, param);	
		} else {
		}

	}

	/**
	 * メールアドレスとパスワードの一致する管理者を検索する
	 * @param mailAddress
	 * @param password
	 * @return　検索された管理者情報
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {

		String sql = "select id,name,mailAddress,password from addministrator where mail_address=:mailAddress and password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("maillAddress", mailAddress).addValue("password", password);
		Administrator administrator = template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);
		return administrator;

	}


}
package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) -> {
	Employee employee = new Employee();
	employee.setId(rs.getInt("id"));
	employee.setName(rs.getString("name"));
	employee.setImage(rs.getString("image"));
	employee.setGender(rs.getString("gender"));
	employee.setHireDate(rs.getDate("hire_date"));
	employee.setMailAddress(rs.getString("mail_address"));
	employee.setZipCode(rs.getString("zip_code"));
	employee.setAddress(rs.getString("address"));
	employee.setTelephone(rs.getString("telephone"));
	employee.setSalary(rs.getInt("salary"));
	employee.setCharacteristics(rs.getString("characteristics"));
	return employee;	
	};


	/**
	 * 全従業員を入社日降順で検索する
	 * @return 全従業員一覧
	 */
	public List<Employee> findAll() {
		String sql = "select id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count from employees order by hire_date desc";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}

	/**
	 * 主キー検索を行う
	 * @param id
	 * @return
	 */
	public Employee load(Integer id) {
		String sql = "select name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count from employees where id=:id";
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}

	/**
	 * idが一致した従業員情報を更新する
	 * @param employee
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		String sql = "update employees set name=:name,image=:image,gender=:gender,hire_date=:hireDate,mail_address=:mailAddress,zip_code=:zipCode,address=:address,telephone=:telephone,salary=:salary,characteristics=:characteristics,dependents_count=:dependentsCount where id=:id";
		template.update(sql, param);
	}
}
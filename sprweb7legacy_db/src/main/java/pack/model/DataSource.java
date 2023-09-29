package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository 
public class DataSource extends DriverManagerDataSource{
	
	// 생성자 안에 데이터 연결 정보를 넣어준다.
	public DataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mariadb://localhost:3306/test");
		setUsername("root");
		setPassword("seoho123");
	}
}

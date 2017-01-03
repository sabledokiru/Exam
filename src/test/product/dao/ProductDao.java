package test.product.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.product.dto.ProductDto;

public class ProductDao {
	private static ProductDao dao;
	private static SqlSessionFactory factory;

	private ProductDao() {
	}
	
	public static ProductDao getInstance() {
		if (dao == null) {
			dao = new ProductDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	public void insert(ProductDto dto){
		SqlSession session = factory.openSession();
		boolean insert = false;
		try {
			session.insert("product.insert",dto);
			insert = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}

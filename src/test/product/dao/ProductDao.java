package test.product.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;

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
}

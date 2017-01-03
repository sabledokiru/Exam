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
   
   public boolean insert(ProductDto dto){
      SqlSession session = factory.openSession(true);
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
      return insert;
   }
   
   public boolean delete(int num){
      SqlSession session = factory.openSession(true);
      boolean delete = false;
      try {
          session.insert("product.delete",num);
         delete = true;
      } catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         session.close();
      }
      return delete;
   }
   
   public boolean update(ProductDto dto){
      SqlSession session=factory.openSession(true);
      boolean update=false;
      try{
         session.update("product.update", dto);
         update=true;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         session.close();
      }
      return update;
   }
   
   public ProductDto getData(int num){
      SqlSession session=factory.openSession();
      ProductDto dto=null;
      try{
         dto=session.selectOne("product.getData", num);
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         session.close();
      }
      return dto;
   }
   
}//전체
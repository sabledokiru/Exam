package test.product.dao;

import java.util.List;

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
   
   public List<ProductDto> getList(ProductDto dto){
		SqlSession session=factory.openSession();
		List<ProductDto> list=null;
		try{
			list=session.selectList("product.getList", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
   
   public int getCount(){
	   System.out.println("getcount 바로앞");
		SqlSession session=factory.openSession();
		System.out.println("getcount 안쪽");
		int count=session.selectOne("product.getCount");
		System.out.println("getcount 샐랙트원 실행후");
		session.close();
		return count;
	}
   
 //조회수를 1 증가 시키는 메소드
 	public void increaseViewCount(int num){
 		//auto commit 되는 SqlSession 객체의 참조값 얻어오기 
 		SqlSession session = factory.openSession(true);
 		try{
 			session.update("product.increaseViewCount", num);
 		}catch(Exception e){
 			e.printStackTrace();
 		}finally{
 			session.close();
 		}
 	}
}//전체
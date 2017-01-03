package test.members.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.members.dto.MembersDto;
import test.mybatis.SqlMapConfig;

public class MembersDao {
	private static MembersDao dao;
	private static SqlSessionFactory factory;
	private MembersDao(){}
	public static MembersDao getInstance(){
		if(dao==null){
			dao=new MembersDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//회원정보를 추가하기
	public boolean insert(MembersDto dto){
		// 세션 객체 생성
		SqlSession session=factory.openSession();
		boolean isSeccess = false;
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSeccess;
	}
	
	//회원정보를 삭제하기
	public void delete(String id){
		
	}
	
}

package test.members.dao;

import java.util.ArrayList;
import java.util.List;

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
		SqlSession session= factory.openSession(true);	
		boolean isSeccess = false;
		try{
			session.insert("members.insert",dto);
			isSeccess = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSeccess;
	}
	
	//회원정보를 삭제하기
	public boolean delete(String id){
		//세션 객체 생성
		SqlSession session=factory.openSession(true);
		boolean isSuccess = false;
		try{
			session.delete("members.delete",id);
			isSuccess = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSuccess;
	}
	
	//회원정보 수정하기
	public boolean update(MembersDto dto){
		//세션 객체 생성
		SqlSession session=factory.openSession(true);
		boolean isSuccess = false;
		try{
			session.update("members.update",dto);
			isSuccess=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSuccess;
	}
	
	//회원 리스트 출력하기
	public List<MembersDto> getList(){
		//세션 객체 생성
		SqlSession session=factory.openSession(true);
		 	List<MembersDto> list = null;
		try{
			list = session.selectList("members.getlist");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	//아이디 중복 체크
	public boolean checkedId(String id){
		//세션 객체 생성
		SqlSession session=factory.openSession();
		boolean isSuccess = true;
		MembersDto dto=null;
		try{
			dto=session.selectOne("members.checkedId",id);	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(dto!=null){
			isSuccess=false;
		}else{
			isSuccess=true;
		}
		return isSuccess;
	}
	
	//한명의 회원정보 출력하기
	public boolean getData(String id){
		//세션 객체 생성
		SqlSession session=factory.openSession();
		boolean isSuccess = false;
		try{
			session.selectOne("members.getData",id);
			isSuccess = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSuccess;
	}
	public boolean isValid(MembersDto dto){
		//세션 객체 생성
		SqlSession session=factory.openSession();
		boolean isSuccess = false;
		try{
			session.selectOne("members.signin" , dto);
			isSuccess=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isSuccess;
	}
}











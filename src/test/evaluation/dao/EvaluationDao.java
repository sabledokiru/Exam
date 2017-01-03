package test.evaluation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.evaluation.dto.EvaluationDto;
import test.mybatis.SqlMapConfig;

public class EvaluationDao {
	private static EvaluationDao dao;
	private static SqlSessionFactory factory;
	
	public static EvaluationDao getInstance(){
		if(dao == null){
			dao = new EvaluationDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 상품평을 입력하는 메소드
	public boolean insert(EvaluationDto dto){
		SqlSession session = factory.openSession(true);
		boolean flag = false;
		try{
			session.insert("evaluation.insert", dto);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}
	
	// 상품평을 수정하는 메소드
	public boolean update(EvaluationDto dto){
		SqlSession session = factory.openSession(true);
		boolean flag = false;
		try{
			session.update("evaluation.update", dto);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}
	
	// 상품평을 삭제하는 메소드
	public boolean delete(int num){
		SqlSession session = factory.openSession(true);
		boolean flag = false;
		try{
			session.delete("evaluation.delete", num);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}
	
	// 선택된 상품평에 대한 정보를 불러오는 메소드
	public EvaluationDto getData(int num){
		SqlSession session = factory.openSession();
		EvaluationDto dto = null;
		try{
			dto = session.selectOne("evaluation.getData", num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return dto;
	}
	
	// 전체 상품평을 불러 오는 메소드
	public List<EvaluationDto> getList(){
		SqlSession session = factory.openSession();
		List<EvaluationDto> list = null;
		try{
			list = session.selectList("evaluation.getList");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
}

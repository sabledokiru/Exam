package test.question.answer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.question.answer.dto.QAAnswerDto;
import test.question.answer.dto.QAWriterDto;

public class QAWriterDao {
	private static QAWriterDao dao;
	private static SqlSessionFactory factory;
	private QAWriterDao(){}
	public static QAWriterDao getInstance(){
		if(dao==null){
			dao=new QAWriterDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//질문자가 질문글 올려서 저장하는 메소드
	public void insert(QAWriterDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("qamapper.insert",dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//질문글(Question 글) 모두 출력하기
	public List<QAWriterDto> getList(){
		SqlSession session=factory.openSession();
		List<QAWriterDto> list=null;
		try{
			list=session.selectList("qamapper.getlist");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	//질문글(Question 글) 하나 출력하기
	public List<QAWriterDto> getdata(int num){
		SqlSession session=factory.openSession();
		List<QAWriterDto> list=null;
		try{
			list=session.selectOne("qamapper.getdata",num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	//질문글 하나 삭제하기
	public void delete(int num){
		SqlSession session=factory.openSession();
		try{
			session.delete("qamapper.delete",num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//질문글 하나 수정하기
		public void update(QAWriterDto dto){
			SqlSession session=factory.openSession(true);
			try{
				session.update("qamapper.update",dto);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		}
		
		public int getCount(){
			SqlSession session = factory.openSession();
			int count = session.selectOne("qamapper.getCount");
			session.close();
			return count;
		} 
		
}

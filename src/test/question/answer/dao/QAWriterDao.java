package test.question.answer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
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
}

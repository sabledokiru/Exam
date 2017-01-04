package test.question.answer.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.question.answer.dto.QAAnswerDto;

public class QAAnswerDao {
	private static QAAnswerDao dao;
	private static SqlSessionFactory factory;
	private QAAnswerDao(){}
	public static QAAnswerDao getInstance(){
		if(dao==null){
			dao=new QAAnswerDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//질문의 답변글을 저장하기
	public void insert(QAAnswerDto dto){
		SqlSession session=factory.openSession();
		
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}

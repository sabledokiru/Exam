package test.question.answer.dao;

import java.util.List;

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
		SqlSession session=factory.openSession(true);
			
		try{
			session.insert("qamapper.ainsert",dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//답변글 모두 출력하기
	public List<QAAnswerDto> getList(){
		SqlSession session=factory.openSession();
		List<QAAnswerDto> list=null;
		try{
			list=session.selectList("qamapper.agetlist");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	//답변글 하나 출력하기
	public List<QAAnswerDto> getdata(int num){
		SqlSession session=factory.openSession();
		List<QAAnswerDto> list=null;
		try{
			list=session.selectOne("qamapper.agetdata",num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	//답변글 하나 삭제하기
	public void delete(int num){
		SqlSession session=factory.openSession(true);
		try{
			session.delete("qamapper.adelete",num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//답변글 하나 수정하기
	public void update(QAAnswerDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.update("qamapper.aupdate",dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	

}








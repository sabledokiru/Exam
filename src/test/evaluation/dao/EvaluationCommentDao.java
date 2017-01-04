package test.evaluation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.evaluation.dto.EvaluationCommentDto;
import test.mybatis.SqlMapConfig;

public class EvaluationCommentDao {
	private static EvaluationCommentDao dao;
	private static SqlSessionFactory factory;
	
	public EvaluationCommentDao(){}
	
	public static EvaluationCommentDao getInstance(){
		if(dao == null){
			dao = new EvaluationCommentDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 새 댓글을 작성하는 메소드
		public void insert(EvaluationCommentDto dto){
			SqlSession session = factory.openSession(true);
			try{
				session.insert("evaluationComment.insert", dto);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		}
		
		// 댓글 목록을 리턴하는 메소드
		public List<EvaluationCommentDto> getList(int ref_group){
			SqlSession session = factory.openSession();
			List<EvaluationCommentDto> list = null;
			try{
				list = session.selectList("evaluationComment.getList", ref_group);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
			return list;
		}
		
		// 새 댓글의 글 번호(sequence) 값을 얻어내서 리턴해주는 메소드
		public int getSequence(){
			SqlSession session = factory.openSession();
			int num = 0;
			try{
				num = session.selectOne("evaluationComment.getSequence");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
			return num;
		}
}

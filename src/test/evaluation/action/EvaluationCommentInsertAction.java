package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationCommentDao;
import test.evaluation.dto.EvaluationCommentDto;

public class EvaluationCommentInsertAction extends Action{
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      // 파라미터로 전달되는 내용 읽어오기
      String writer = (String) request.getSession().getAttribute("id");
      int ref_group = Integer.parseInt(request.getParameter("ref_group"));
      int comNum = Integer.parseInt(request.getParameter("comNum"));
      String target_id = request.getParameter("target_id");
      String content = request.getParameter("content");
      // 댓글 내에서의 그룹번호를 읽어온다.
      // null 이면 원글에 대한 댓글이고 아니면 댓글에 대한 댓글이다.
      int comment_group = Integer.parseInt(request.getParameter("comment_group"));
      // 저장할 댓글 번호를 미리 읽어온다.
      int seq = EvaluationCommentDao.getInstance().getSequence();
      
      EvaluationCommentDto dto = new EvaluationCommentDto();
      dto.setComNum(seq);
      dto.setComWriter(writer);
      dto.setComRef_group(ref_group);
      dto.setComTarget_id(target_id);
      dto.setComContent(content);
      dto.setComComment_group(comment_group);
      EvaluationCommentDao.getInstance().insert(dto);
      return new ActionForward("/views/product/product_info.do?productNum="+ref_group, true);
   }
}
package test.evaluation.dao;

import java.util.List;

import test.evaluation.dto.EvaluationDto;

public class test {
	public static void main(String[] args) {
//		EvaluationDto dto = 
//				new EvaluationDto(1, 10, "컴터가 너무 꾸지네요", "망해라", "뭐 이딴걸 파냐 장사 똑바로해라", "2017-01-02 15:47:55.0");
//		EvaluationDao.getInstance().insert(dto);
		
//		EvaluationDto dto = 
//				new EvaluationDto(1, 10, "배송이 너무 빨라요", "망해라", "총알 배송 때문에 문에 구멍날 뻔 했어요", "2017-01-02 15:47:55.0");
//		EvaluationDao.getInstance().update(dto);
		
//		EvaluationDto dto = EvaluationDao.getInstance().getData(1);
//		System.out.println(dto.getEvaNum());
//		System.out.println(dto.getProductNum());
//		System.out.println(dto.getEvaTitle());
//		System.out.println(dto.getEvaWriter());
//		System.out.println(dto.getEvaContent());
//		System.out.println(dto.getRegdate());
//		System.out.println();
		
//		EvaluationDao.getInstance().delete(1);
		
		List<EvaluationDto> list = EvaluationDao.getInstance().getList();
		
		for(EvaluationDto tmp : list){
			System.out.print(tmp.getEvaNum());
			System.out.print("//");
			System.out.print(tmp.getProductNum());
			System.out.print("//");
			System.out.print(tmp.getEvaTitle());
			System.out.print("//");
			System.out.print(tmp.getEvaWriter());
			System.out.print("//");
			System.out.print(tmp.getEvaContent());
			System.out.print("//");
			System.out.println(tmp.getRegdate());
			System.out.println();
		}
	}
}
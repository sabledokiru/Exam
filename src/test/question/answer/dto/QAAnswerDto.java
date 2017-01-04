package test.question.answer.dto;

public class QAAnswerDto {
	private int answerNum;
	private String answerWriter;
	private String answerContent;
	private int answerRefnum;
	private String regdate;
	
	public QAAnswerDto(){}

	public QAAnswerDto(int answerNum, String answerWriter, String answerContent, int answerRefnum, String regdate) {
		super();
		this.answerNum = answerNum;
		this.answerWriter = answerWriter;
		this.answerContent = answerContent;
		this.answerRefnum = answerRefnum;
		this.regdate = regdate;
	}

	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public int getAnswerRefnum() {
		return answerRefnum;
	}

	public void setAnswerRefnum(int answerRefnum) {
		this.answerRefnum = answerRefnum;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	};
	
	
}

package test.evaluation.dto;

public class EvaluationDto {
	private int evaNum;
	private int productNum;
	private String evaTitle;
	private String evaWriter;
	private String evaContent;
	private String regdate;
	
	public EvaluationDto(int evaNum, int productNum, String evaTitle, String evaWriter, String evaContent,
			String regdate) {
		super();
		this.evaNum = evaNum;
		this.productNum = productNum;
		this.evaTitle = evaTitle;
		this.evaWriter = evaWriter;
		this.evaContent = evaContent;
		this.regdate = regdate;
	}

	public int getEvaNum() {
		return evaNum;
	}

	public void setEvaNum(int evaNum) {
		this.evaNum = evaNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getEvaTitle() {
		return evaTitle;
	}

	public void setEvaTitle(String evaTitle) {
		this.evaTitle = evaTitle;
	}

	public String getEvaWriter() {
		return evaWriter;
	}

	public void setEvaWriter(String evaWriter) {
		this.evaWriter = evaWriter;
	}

	public String getEvaContent() {
		return evaContent;
	}

	public void setEvaContent(String evaContent) {
		this.evaContent = evaContent;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}

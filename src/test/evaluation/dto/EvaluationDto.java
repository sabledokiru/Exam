package test.evaluation.dto;

public class EvaluationDto {
	private int evaNum;
	private int divValue;
	private int productNum;
	private String evaTitle;
	private String evaWriter;
	private String evacontent;
	private String regdate;
	
	public EvaluationDto(){}

	public EvaluationDto(int evaNum, int divValue, int productNum, String evaTitle, String evaWriter, String evacontent,
			String regdate) {
		super();
		this.evaNum = evaNum;
		this.divValue = divValue;
		this.productNum = productNum;
		this.evaTitle = evaTitle;
		this.evaWriter = evaWriter;
		this.evacontent = evacontent;
		this.regdate = regdate;
	}

	public int getEvaNum() {
		return evaNum;
	}

	public void setEvaNum(int evaNum) {
		this.evaNum = evaNum;
	}

	public int getDivValue() {
		return divValue;
	}

	public void setDivValue(int divValue) {
		this.divValue = divValue;
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

	public String getEvacontent() {
		return evacontent;
	}

	public void setEvacontent(String evacontent) {
		this.evacontent = evacontent;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}

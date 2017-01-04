package test.question.answer.dto;

public class QAWriterDto {
	private int writerNum;
	private String writerMainquestion;
	private String writerDetailquestion;
	private String writerWriter;
	private String writerSecret;
	private String regdate;
	
	public QAWriterDto(){}

	public QAWriterDto(int writerNum, String writerMainquestion, String writerDetailquestion, String writerWriter,
			String writerSecret, String regdate) {
		super();
		this.writerNum = writerNum;
		this.writerMainquestion = writerMainquestion;
		this.writerDetailquestion = writerDetailquestion;
		this.writerWriter = writerWriter;
		this.writerSecret = writerSecret;
		this.regdate = regdate;
	}

	public int getWriterNum() {
		return writerNum;
	}

	public void setWriterNum(int writerNum) {
		this.writerNum = writerNum;
	}

	public String getWriterMainquestion() {
		return writerMainquestion;
	}

	public void setWriterMainquestion(String writerMainquestion) {
		this.writerMainquestion = writerMainquestion;
	}

	public String getWriterDetailquestion() {
		return writerDetailquestion;
	}

	public void setWriterDetailquestion(String writerDetailquestion) {
		this.writerDetailquestion = writerDetailquestion;
	}

	public String getWriterWriter() {
		return writerWriter;
	}

	public void setWriterWriter(String writerWriter) {
		this.writerWriter = writerWriter;
	}

	public String getWriterSecret() {
		return writerSecret;
	}

	public void setWriterSecret(String writerSecret) {
		this.writerSecret = writerSecret;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	};
	
	
	
}

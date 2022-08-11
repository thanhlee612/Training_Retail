package vn.aloapp.training.springboot.request.Report;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDReportRequest {
	
	@JsonProperty("report_type")
	private int reportType;
	
	@JsonProperty("from_date_string")
	 private String fromDateString;
	
	@JsonProperty("to_date_string")
	 private String toDateString;

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public String getFromDateString() {
		return fromDateString;
	}

	public void setFromDateString(String fromDateString) {
		this.fromDateString = fromDateString;
	}

	public String getToDateString() {
		return toDateString;
	}

	public void setToDateString(String toDateString) {
		this.toDateString = toDateString;
	}
	
}

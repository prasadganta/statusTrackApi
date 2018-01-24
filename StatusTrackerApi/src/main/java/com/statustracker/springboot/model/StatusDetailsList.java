package com.statustracker.springboot.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "StatusList" })


@Component("StatusDetailsList")
public class StatusDetailsList {
	
	private List<StatusDetail> statusDetail;

	public List<StatusDetail> getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(List<StatusDetail> statusDetail) {
		this.statusDetail = statusDetail;
	}

}

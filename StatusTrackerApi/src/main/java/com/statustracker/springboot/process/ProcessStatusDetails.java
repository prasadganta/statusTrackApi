package com.statustracker.springboot.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.statustracker.springboot.StatusRepository.StatusRepository;
import com.statustracker.springboot.model.StatusDetail;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component("processStatusDetails")
public class ProcessStatusDetails {

	@Autowired
	StatusRepository statusRepository;
	@Autowired
	MongoOperations mongoOperations;

	@SuppressWarnings({ "unchecked", "unused" })
	public void create(StatusDetail statusDetail) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String entryDate = formatter.format(date);
		statusDetail.setEntryDate(entryDate);
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		String entryTime = formatter2.format(date);
		statusDetail.setEntryTime(entryTime);
		// statusRepository.save(statusDetail);

		StatusDetail statusDetailRecord = mongoOperations.findOne(query(
				where("userName").is(statusDetail.getUserName()).and("entryDate").is(statusDetail.getEntryDate())),
				StatusDetail.class, "statusDetail");

		if (null == statusDetailRecord) {

			statusRepository.save(statusDetail);
		} else {
			
			statusRepository.delete(statusRepository.findByid(statusDetailRecord.getId()));
			statusRepository.save(statusDetail);
			
		}
	}

	public StatusDetail retrive(String userName, String entryDate) {

		StatusDetail statusDetailRecord = mongoOperations.findOne(
				query(where("userName").is(userName).and("entryDate").is(entryDate)), StatusDetail.class,
				"statusDetail");
		return statusDetailRecord;
	}

	public List<StatusDetail> retriveByDate(String entryDate) {

		return statusRepository.findByentryDate(entryDate);
	}

}

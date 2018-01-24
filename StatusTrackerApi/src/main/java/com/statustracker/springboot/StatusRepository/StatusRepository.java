package com.statustracker.springboot.StatusRepository;

import com.statustracker.springboot.model.StatusDetail;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component("statusRepository")
public interface StatusRepository extends MongoRepository<StatusDetail,String> {
    
	 List<StatusDetail> findByentryDate(String entryDate);
	 StatusDetail findByid(String Id);
}

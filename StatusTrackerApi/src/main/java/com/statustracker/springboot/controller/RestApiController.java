<<<<<<< HEAD
package com.statustracker.springboot.controller;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mongodb.DBObject;
import com.statustracker.springboot.model.LoginRequest;
import com.statustracker.springboot.model.LoginResponse;
import com.statustracker.springboot.model.StatusDetail;
import com.statustracker.springboot.model.StatusDetailWrapper;
import com.statustracker.springboot.process.ProcessStatusDetails;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	ProcessStatusDetails processStatusDetails;

	@Autowired
	StatusDetail statusDetail;

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@RequestMapping(value = "/loginRequest", method = RequestMethod.GET)
	public LoginResponse LoginRequest(@RequestParam("username") String username,@RequestParam("service") String pwd, HttpServletResponse httpServletResponse) {
		LoginResponse loginResponse = new LoginResponse();
		logger.info(username);
		loginResponse.setSuccess("success");
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		return loginResponse;

	}

	@RequestMapping(value = "/insertTask", method = RequestMethod.POST, consumes = "application/json")
	public void InsertTaskRequest(@RequestBody StatusDetailWrapper processStatusReq,
			HttpServletResponse httpServletResponse) {
		try {
			processStatusDetails.create(processStatusReq.getStatusDetail());
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}

	@RequestMapping(value = "/getTask", method = RequestMethod.GET, produces = "application/json")
	public StatusDetail GetTaskRequest(@RequestParam("userName") String userName, @RequestParam("entryDate") String entryDate,
			HttpServletResponse httpServletResponse) {
		try {
			statusDetail = processStatusDetails.retrive(userName, entryDate);
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json");
			ObjectMapper mapperObj = new ObjectMapper();

		
			/*String jsonStr = mapperObj.writeValueAsString(statusDetail);
			System.out.println(jsonStr);

			httpServletResponse.getWriter().write(jsonStr);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();*/
			
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
		return statusDetail;

	}

	@RequestMapping(value = "/getAllTask", method = RequestMethod.GET, produces = "application/json")
	public void GetAllTaskRequest(@RequestParam("entryDate") String entryDate,
			HttpServletResponse httpServletResponse) {
		try {
			Iterable<StatusDetail> allTaskDetails = processStatusDetails.retriveByDate(entryDate);
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json");
			ObjectMapper mapperObj = new ObjectMapper();
			String jsonStr = mapperObj.writeValueAsString(allTaskDetails);

			httpServletResponse.getWriter().write(jsonStr);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}
=======
package com.statustracker.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mongodb.DBObject;
import com.statustracker.springboot.model.LoginRequest;
import com.statustracker.springboot.model.LoginResponse;
import com.statustracker.springboot.model.StatusDetail;
import com.statustracker.springboot.model.StatusDetailWrapper;
import com.statustracker.springboot.process.ProcessStatusDetails;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	ProcessStatusDetails processStatusDetails;

	@Autowired
	StatusDetail statusDetail;
	

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@RequestMapping(value = "/loginRequest", method = RequestMethod.GET)
	public LoginResponse LoginRequest(@RequestParam("username") String username,@RequestParam("service") String pwd, HttpServletResponse httpServletResponse) {
		LoginResponse loginResponse = new LoginResponse();
		logger.info(username);
		loginResponse.setSuccess("success");
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		return loginResponse;

	}

	@RequestMapping(value = "/insertTask", method = RequestMethod.POST, consumes = "application/json")
	public void InsertTaskRequest(@RequestBody StatusDetailWrapper processStatusReq,
			HttpServletResponse httpServletResponse) {
		try {
			processStatusDetails.create(processStatusReq.getStatusDetail());
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}

	@RequestMapping(value = "/getTask", method = RequestMethod.GET, produces = "application/json")
	public StatusDetail GetTaskRequest(@RequestParam("userName") String userName, @RequestParam("entryDate") String entryDate,
			HttpServletResponse httpServletResponse) {
		try {
			statusDetail = processStatusDetails.retrive(userName, entryDate);
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json");
			ObjectMapper mapperObj = new ObjectMapper();

		
			/*String jsonStr = mapperObj.writeValueAsString(statusDetail);
			System.out.println(jsonStr);

			httpServletResponse.getWriter().write(jsonStr);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();*/
			
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
		return statusDetail;

	}

	@RequestMapping(value = "/getAllTask", method = RequestMethod.GET, produces = "application/json")
	public Iterable<StatusDetail> GetAllTaskRequest(@RequestParam("entryDate") String entryDate,
			HttpServletResponse httpServletResponse) {
		List<StatusDetail> allTaskDetails=null;
		try {
			 allTaskDetails = processStatusDetails.retriveByDate(entryDate);
			/*httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json");
			ObjectMapper mapperObj = new ObjectMapper();
			String jsonStr = mapperObj.writeValueAsString(allTaskDetails);

			httpServletResponse.getWriter().write(jsonStr);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();*/
		} catch (Exception e) {
			logger.error("Unable to insert record to DB " + e.getCause().getMessage());
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
		return allTaskDetails;

	}
>>>>>>> 44663fccec70c11d3baafbaea42169259ac2ea2d
}
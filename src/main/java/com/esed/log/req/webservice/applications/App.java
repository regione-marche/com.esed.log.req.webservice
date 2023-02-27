package com.esed.log.req.webservice.applications;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.log4j.Logger;

import com.esed.log.req.webservice.resources.LogExec;

@ApplicationPath("/app") 
public class App extends Application {

	private static Logger logger = Logger.getLogger(App.class);
	
	private Set<Object> singleton = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public App() {
		//LP PG22XX02 - 20220223 logger.info("Inizio Costruttore App");
		classes.add(LogExec.class);
		//LP PG22XX02 - 20220223 logger.info("Fine: Costruttore App");
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singleton;
	}
	
}

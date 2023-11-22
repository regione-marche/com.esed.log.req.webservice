package com.esed.log.req.webservice.applications;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.esed.log.req.webservice.resources.LogExec;
import com.seda.commons.logger.CustomLoggerManager;
import com.seda.commons.logger.LoggerWrapper;

@ApplicationPath("/app") 
public class App extends Application {

	protected static LoggerWrapper logger = CustomLoggerManager.get(App.class);

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

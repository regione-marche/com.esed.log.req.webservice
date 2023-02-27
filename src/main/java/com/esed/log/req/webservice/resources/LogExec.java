package com.esed.log.req.webservice.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.esed.log.req.ExecLogPap;
import com.esed.log.req.ExecLogWin;
import com.esed.log.req.ExecRequest;
import com.esed.log.req.LogRequestException;
import com.esed.log.req.dati.CollectionDto;
import com.esed.log.req.dati.LogPap;
import com.esed.log.req.dati.LogRequest;
import com.esed.log.req.dati.LogWin;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("exec")
public class LogExec {

	private static final Logger logger = Logger.getLogger(LogExec.class);

	
	
	@POST
	@Path("/save")
	public Response saveRequest(LogRequest in) {
		
		Integer bOk = null;
		
		try {
			bOk = ExecRequest.saveRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(bOk);
		return response.build();
	}
	
	@POST
	@Path("/search")
	public Response searchRequest(LogRequest in)
	{
		CollectionDto collectionDto = null;
		
		try {
			collectionDto = ExecRequest.searchRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(collectionDto);
		return response.build();
	}
	
	
	

	@POST
	@Path("/get")
	public Response getRequest(LogRequest in)
	{
		LogRequest out = null;
		
		try {
			out = ExecRequest.getRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(out);
		return response.build();
	}
	

	@POST
	@Path("/updateExt")
	public Response updateExtRequest(LogRequest in) {
		
		Integer bOk = null;
		
		try {
			bOk = ExecRequest.updateExtRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(bOk);
		return response.build();
	}


	@POST
	@Path("/saveWinLogger")
	public Response saveRequest(LogWin in) {
		
		Integer bOk = null;
		
		try {
			bOk = ExecLogWin.saveRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(bOk);
		return response.build();
	}
	
	

	@POST
	@Path("/searchWin")
	public Response searchWinLogger(LogWin in)
	{
		CollectionDto collectionDto = null;
		
		try {
			collectionDto = ExecLogWin.searchRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(collectionDto);
		return response.build();
	}
	
	@POST
	@Path("/getWin")
	public Response getWinLogger(LogWin in)
	{
		LogWin out = null;
		
		try {
			out = ExecLogWin.getRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(out);
		return response.build();
	}
	
	@POST
	@Path("/savePapLogger")
	public Response saveRequest(LogPap in) {
		
		Integer bOk = null;
		
		try {
			bOk = ExecLogPap.saveRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(bOk);
		return response.build();
	}
	
	@POST
	@Path("/searchPap")
	public Response searchPapLogger(LogPap in)
	{
		CollectionDto collectionDto = null;
		
		try {
			collectionDto = ExecLogPap.searchRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(collectionDto);
		return response.build();
	}
	
	@POST
	@Path("/getPap")
	public Response getPapLogger(LogPap in)
	{
		LogPap out = null;
		
		try {
			out = ExecLogPap.getRequest(in);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(out);
		return response.build();
	}
	


	// YLM PG22XX08 INI
	@POST
	@Path("/getTipoOperazioniPapDDL")
	public Response getTipoOperazioniPapDDL(String dbSchemaCodSocieta)
	{
		CollectionDto out = null;
		
		try {
			out = ExecLogPap.getTipoOperazioni(dbSchemaCodSocieta);
		} catch (LogRequestException e) {
			logger.error(null, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		ResponseBuilder response = Response.ok().entity(out);
		return response.build();
	}
	// YLM PG22XX08 FINE
	
}

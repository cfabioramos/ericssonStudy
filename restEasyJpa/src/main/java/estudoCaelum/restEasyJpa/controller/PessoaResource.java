package estudoCaelum.restEasyJpa.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import estudoCaelum.restEasyJpa.model.ErroModel;
import estudoCaelum.restEasyJpa.model.PessoaModel;
import estudoCaelum.restEasyJpa.service.PessoaService;

@Path("/pessoas")
public class PessoaResource {
	
	@Inject
	private PessoaService service;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<PessoaModel> findAll(){
		return service.findAll();
	}
	
	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id){
		return Response.ok()
				.entity(service.findOne(id))
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@GET
	@Path("/{id}/pagina")
	@Produces(MediaType.TEXT_HTML)
	public void findOneInPage(@PathParam("id") Long id, 
			@Context HttpServletResponse servletResponse, 
			@Context UriInfo uriInfo) throws IOException {
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(id.toString()).build();
	    Response.ok(uri).build();

		servletResponse.sendRedirect("/restEasyJpa/index.html");
		
//		return Response.ok()
//				.entity(service.findOne(id))
//				.type(MediaType.TEXT_HTML)
//				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response insert(@Valid PessoaModel model) throws URISyntaxException{
		
		if (model.getNome().equals("Jesus")) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(new ErroModel("Este nome não é permitido"))
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		model = service.insert(model);
		
		return Response.created(new URI("/pessoas/" + model.getId()))
				.entity(model)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
}

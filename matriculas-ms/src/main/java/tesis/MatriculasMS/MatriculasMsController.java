package tesis.MatriculasMS;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import tesis.pkg_CLASES.Matriculas;
import tesis.pkg_SESSIONS.MatriculasFacade;

@RestController
@RequestMapping("/matriculas")
public class MatriculasMsController {
    
    private static final String template = "Hello, %s!";
		
    @RequestMapping("/greeting/{name}")
    public String greeting2(@PathVariable("name") String name) {
        return String.format(template, name) ;		
    }
    
    
    private MatriculasFacade mf = MatriculasFacade.getMatricula();
    
    
    //@GetMapping(value="/{curso}" , produces= MediaType.APPLICATION_JSON)
    
    @RequestMapping(value="/{curso}" , method=RequestMethod.GET,  produces = "application/json")
    //@ResponseBody
    //@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Matriculas> matriculasPorCurso(@PathVariable Integer curso){
        //System.out.println("curso: "+curso);
        return mf.matriculasByCurso(curso);
    }


}
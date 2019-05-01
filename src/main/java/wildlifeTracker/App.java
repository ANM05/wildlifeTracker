/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wildlifeTracker;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {


    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";


        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("HEALTHY", Endangered.HEALTHY);
            model.put("OKAY", Endangered.OKAY);
            model.put("ILL", Endangered.ILL);
            model.put("NEWBORN", Endangered.NEWBORN);
            model.put("YOUNG", Endangered.YOUNG);
            model.put("ADULT", Endangered.ADULT);
            model.put("rangerName", request.session().attribute("rangerName"));
            model.put("template", "templates/animal-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/animals/new", (request, response) -> {
            String name = request.queryParams("name");
            boolean endangered = request.queryParamsValues("endangered") != null;
            if (endangered) {
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                Endangered endangeredAnimal = new Endangered(name, age, health);
                endangeredAnimal.save();
            } else {
                NonEndangered notEndangered = new NonEndangered(name);
                notEndangered.save();
            }
            response.redirect("/animals");
            return null;
        });
        
    }
}

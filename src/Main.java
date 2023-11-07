import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Spark.staticFileLocation("public_html");

        Spark.get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "index"));

        });

        Spark.get("/chat", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "window"));
        });

        Spark.post("/chat", (request, response) -> {
            String choice = request.queryParams("choice");
            if ("joke".equals(choice)) {
                return "<div>That was funny!</div>";
            } else if ("search".equals(choice)) {
                return "<div>You found me!</div>";
            }
            return "<div>I don't understand!</div>";
        });
    }
}
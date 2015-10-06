import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.abs;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
        staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/", (request, response) -> {
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/index.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

        post("/queen-attack", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            String queenx = request.queryParams("queenx");
            String queeny = request.queryParams("queeny");
            String opponentx = request.queryParams("opponentx");
            String opponenty = request.queryParams("opponenty");
            Integer queen = Integer.parseInt(queenx.concat(queeny));
            Integer opponent = Integer.parseInt(opponentx.concat(opponenty));
            Boolean canAttack = queenAttack(queen, opponent);
            model.put("canAttack", canAttack);
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
	}

	public static Boolean queenAttack(Integer position1, Integer position2) {
    	String position1Str = String.valueOf(position1);
        String position2Str = String.valueOf(position2);
        if (position1Str.substring(1,2).equals(position2Str.substring(1,2))) {
            return true;
        } else if (position1Str.substring(0,1).equals(position2Str.substring(0,1))) {
            return true;
        } else if (isDiagonal(position1Str, position2Str)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isDiagonal(String position1, String position2) {
        Integer pos1Num1 = Integer.parseInt(position1.substring(0,1));
        Integer pos1Num2 = Integer.parseInt(position1.substring(1,2));
        Integer pos2Num1 = Integer.parseInt(position2.substring(0,1));
        Integer pos2Num2 = Integer.parseInt(position2.substring(1,2));
        if (Math.abs(pos1Num1 - pos2Num1) == Math.abs(pos1Num2 - pos2Num2)) {
            return true;
        } else {
            return false;
        }
    }
}
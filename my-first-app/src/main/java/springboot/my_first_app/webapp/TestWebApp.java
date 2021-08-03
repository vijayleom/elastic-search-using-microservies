package springboot.my_first_app.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWebApp {
	Logger log = LoggerFactory.getLogger(getClass());
	@RequestMapping("/uservalidation/services/{userid}")
	public String home(@PathVariable("userid") int userid) {
		MDC.put("user.id", "User ID:" + String.valueOf(userid));
		String name = "User login not found | Name => INVALID";
		if(userid == 21) {
			name = "User login found | Name => Vijay Leo M";
		}else if(userid == 22) {
			name = "User login found | Name => Biju Menon";
		}else if(userid == 23) {
			name = "User login found | Name => Christopher";
		}
		log.info("ID : => "+userid);
		log.info("MSG : => "+name);
		return name;
	}
}
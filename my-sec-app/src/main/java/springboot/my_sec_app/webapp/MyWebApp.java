package springboot.my_sec_app.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebApp {
	Logger log = LoggerFactory.getLogger(getClass());
	@RequestMapping("/entrypoint/services/{entry}")
	public String home(@PathVariable("entry") int entry) {
		MDC.put("entry.id", "Entry ID:" + String.valueOf(entry));
		String name = "Entry Restricted for user ID - "+entry+" | Name => NOT FOUND";
		if(entry == 21) {
			name = "Entry allowed for user ID - "+entry+" | Name => Vijay Leo M";
		}else if(entry == 22) {
			name = "Entry allowed for user ID - "+entry+" | Name => Biju Menon";
		}else if(entry == 23) {
			name = "Entry allowed for user ID - "+entry+" | Name =>Christopher";
		}
		log.info("ID : => "+entry);
		log.info("MSG : => "+name);
		return name;
	}
}

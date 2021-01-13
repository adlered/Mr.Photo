package pers.adlered.mrphoto.web;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.adlered.mrphoto.core.main.ActionExecutor;

@RestController
public class Test {

    ActionExecutor actionExecutor = new ActionExecutor();

    public Test() {
        actionExecutor.setActionDatabaseToUpyun();
        actionExecutor.getActionProcessor().setVal("test-netdisk-adler\ntemp\n7m6L2J4YZwJ1kOzzTqOc8eHyGvEuu0BD");
        System.out.println("Setup success.");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/api/create", method = RequestMethod.POST)
    public String create(@RequestParam("path") String path,
                         @RequestParam("filename") String filename,
                         @RequestParam("isFile") boolean isFile) {
        boolean result = actionExecutor.getActionProcessor().create(path, filename, isFile);
        return result ? new JSONObject().put("status", "200").toString() : new JSONObject().put("status", "500").toString();
    }
}

package pers.adlered.mrphoto.web;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.adlered.mrphoto.core.bean.File;
import pers.adlered.mrphoto.core.main.ActionExecutor;
import sun.security.action.GetPropertyAction;

import java.io.IOException;
import java.security.AccessController;
import java.util.ArrayList;

@RestController
public class Main {

    ActionExecutor actionExecutor = new ActionExecutor();

    public Main() {
        actionExecutor.setActionDatabaseToUpyun();
        actionExecutor.getActionProcessor().setVal("test-netdisk-adler\ntemp\n7m6L2J4YZwJ1kOzzTqOc8eHyGvEuu0BD");
        System.out.println("Setup success.");
    }

    @RequestMapping(value = "/api/create", method = RequestMethod.POST)
    public String create(@RequestParam("path") String path,
                         @RequestParam("filename") String filename,
                         @RequestParam("isFile") boolean isFile) {
        boolean result = actionExecutor.getActionProcessor().create(path, filename, isFile);
        return result ? new JSONObject().put("status", "200").toString() : new JSONObject().put("status", "500").toString();
    }

    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("path") String path,
                         @RequestParam("filename") String filename,
                         @RequestParam("isFile") boolean isFile) {
        boolean result = actionExecutor.getActionProcessor().delete(path, filename, isFile);
        return result ? new JSONObject().put("status", "200").toString() : new JSONObject().put("status", "500").toString();
    }

    @RequestMapping(value = "/api/fetch", method = RequestMethod.POST)
    public String fetch(@RequestParam("path") String path) {
        ArrayList<File> fileList = actionExecutor.getActionProcessor().fetch(path);
        return new JSONObject().put("status", "200")
                .put("result", fileList).toString();
    }

    @RequestMapping(value = "/api/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("path") String path,
                         @RequestParam("file") MultipartFile multipartFile) {
        java.io.File file = transferToFile(multipartFile);
        boolean result = actionExecutor.getActionProcessor().upload(file, path);
        return result ? new JSONObject().put("status", "200").toString() : new JSONObject().put("status", "500").toString();
    }

    // 将MultipartFile转为File
    private java.io.File transferToFile(MultipartFile multipartFile) {
        java.io.File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String tmpdir = System.getProperty("java.io.tmpdir");
            file = new java.io.File(tmpdir, originalFilename != null ? originalFilename : "file.tmp");
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}

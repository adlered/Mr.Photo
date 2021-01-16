package pers.adlered.mrphoto.core.database.realization;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.upyun.RestManager;
import okhttp3.Response;
import pers.adlered.mrphoto.core.database.ActionDatabase;
import pers.adlered.mrphoto.core.main.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 又拍云行为数据库。
 * 函数要求：空间名称\n操作员名城\n操作员密码
 */
public class UpyunActionDatabase implements ActionDatabase {

    private RestManager manager;

    @Override
    public void setVal(String val) {
        // 初始化
        String[] valOfArr = val.split("\n");
        manager = new RestManager(valOfArr[0], valOfArr[1], valOfArr[2]);
        Logger.info("Init upyun val: " + valOfArr[0] + ", " + valOfArr[1] + ", " + valOfArr[2]);
    }

    @Override
    public boolean create(String path, String filename, boolean isFile) {
        if (isFile) {
            try {
                String fullPath = path + "/" + filename;
                Map<String, String> params = new HashMap<>();
                Response result = manager.writeFile(fullPath, new byte[0], params);
                Logger.info("Empty file " + fullPath + " [created] " + result.code());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                String fullPath = path + "/" + filename;
                Response result = manager.mkDir(fullPath);
                Logger.info("Folder " + fullPath + " [created] " + result.code());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public boolean delete(String path, String filename, boolean isFile) {
        if (isFile) {
            try {
                String fullPath = path + "/" + filename;
                Response response = manager.deleteFile(fullPath, null);
                Logger.info("File " + fullPath + " [deleted] " + response.code());
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                String fullPath = path + "/" + filename;
                Response response = manager.rmDir(fullPath);
                Logger.info("Folder " + fullPath + " [deleted] " + response.code());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public boolean upload(java.io.File file, String path, String filename) {
        return false;
    }

    @Override
    public pers.adlered.mrphoto.core.bean.File prop(String path, String filename) {
        return null;
    }

    @Override
    public ArrayList<pers.adlered.mrphoto.core.bean.File> fetch(String path) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("Accept", "application/json");
            params.put("x-list-limit", "10000");
            Response response = manager.readDirIter(path, params);
            ArrayList<pers.adlered.mrphoto.core.bean.File> fileList = new ArrayList<>();

            // JSON处理
            JSONObject fileListJson = JSONObject.parseObject(response.body() != null ? response.body().string() : "");
            JSONArray fileListArray = fileListJson.getJSONArray("files");
            for (int i = 0; i < fileListArray.size(); i++) {
                JSONObject object = fileListArray.getJSONObject(i);
                pers.adlered.mrphoto.core.bean.File file = new pers.adlered.mrphoto.core.bean.File();
                file.setFilename(object.getString("name"));
                file.setImDirectory(object.getString("type").equals("folder"));
                file.setLastDate(object.getLong("last_modified"));
                file.setSize(object.getLong("length"));
                fileList.add(file);
            }

            return fileList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean move(String path, String filename, String newPath, String newFilename, boolean isFile) {
        return false;
    }

    @Override
    public boolean copy(String path, String filename, String newPath, String newFilename, boolean isFile) {
        return false;
    }

    @Override
    public java.io.File download(String path, String filename) {
        return null;
    }

    @Override
    public String getURL(String path, String filename) {
        return null;
    }

    @Override
    public void shutdown() {
        manager = null;
    }
}

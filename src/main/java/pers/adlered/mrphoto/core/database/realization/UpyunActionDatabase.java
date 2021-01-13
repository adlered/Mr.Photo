package pers.adlered.mrphoto.core.database.realization;

import com.upyun.RestManager;
import okhttp3.Response;
import pers.adlered.mrphoto.core.bean.Prop;
import pers.adlered.mrphoto.core.database.ActionDatabase;
import pers.adlered.mrphoto.core.main.Logger;

import java.io.File;
import java.util.ArrayList;

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
            return false;
        } else {
            try {
                String fullPath = path + "/" + filename;
                Response result = manager.mkDir(fullPath);
                Logger.info("Folder " + fullPath + " created: " + result.code());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public boolean delete(String path, String filename, boolean isFile) {
        return false;
    }

    @Override
    public boolean upload(File file, String path, String filename) {
        return false;
    }

    @Override
    public Prop prop(String path, String filename) {
        return null;
    }

    @Override
    public ArrayList<pers.adlered.mrphoto.core.bean.File[]> fetch(String path) {
        return null;
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
    public File download(String path, String filename) {
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

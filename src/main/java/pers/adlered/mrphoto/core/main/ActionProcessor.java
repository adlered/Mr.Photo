package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.bean.Prop;
import pers.adlered.mrphoto.core.database.ActionDatabase;

import java.io.File;
import java.util.ArrayList;

public class ActionProcessor {

    /**
     * 使用 volatile 修饰以便在切换目录和行为数据库时，正在运行的线程也可以跟进而不是使用缓存。
     */
    private volatile String dir;
    private volatile ActionDatabase actionDatabase;

    /**
     * 图床操作
     */

    // 设置变量
    public void setVal(String val) {
        try {
            actionDatabase.setVal(val);
        } catch (Exception e) {
            Logger.warn("SetVal action failed.");
        }
    }

    // 创建空文件/文件夹
    public boolean create(String path, String filename, boolean isFile) {
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        try {
            actionDatabase.create(path, filename, isFile);
        } catch (Exception e) {
            Logger.warn("Create action failed.");
        }
        return false;
    }

    // 关闭线程
    public void shutdown() {
        actionDatabase.shutdown();
        actionDatabase = null;
    }

    /**
     * 切换目录
     */
    public synchronized void cDir(String dir) {
        this.dir = dir;
    }

    /**
     * 切换行为数据库
     */
    public synchronized void cActionDatabase(ActionDatabase actionDatabase) {
        this.actionDatabase = actionDatabase;
    }

}

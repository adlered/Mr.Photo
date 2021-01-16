package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.bean.File;
import pers.adlered.mrphoto.core.database.ActionDatabase;

import java.util.ArrayList;

public class ActionProcessor {

    /**
     * 使用 volatile 修饰以便在切换目录和行为数据库时，正在运行的线程也可以跟进而不是使用缓存。
     */
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
        path = formatPath(path);
        filename = formatFilename(filename);
        try {
            return actionDatabase.create(path, filename, isFile);
        } catch (Exception e) {
            Logger.warn("Create action failed.");
            return false;
        }
    }

    // 删除文件或文件夹
    public boolean delete(String path, String filename, boolean isFile) {
        path = formatPath(path);
        filename = formatFilename(filename);
        try {
            return actionDatabase.delete(path, filename, isFile);
        } catch (Exception e) {
            Logger.warn("Delete action failed.");
            return false;
        }
    }

    // 获取文件列表
    public ArrayList<File> fetch(String path) {
        path = formatPath(path);
        try {
            return actionDatabase.fetch(path);
        } catch (Exception e) {
            Logger.warn("Fetch action failed.");
            return null;
        }
    }

    // 格式化目录
    private String formatPath(String path) {
        path = path.replaceAll("\\\\", "/");
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }

    // 格式化文件名
    private String formatFilename(String filename) {
        filename = filename.replaceAll("\\\\", "")
                .replaceAll("/", "");
        return filename;
    }

    // 关闭线程
    public void shutdown() {
        actionDatabase.shutdown();
        actionDatabase = null;
    }

    /**
     * 切换行为数据库
     */
    public synchronized void cActionDatabase(ActionDatabase actionDatabase) {
        this.actionDatabase = actionDatabase;
    }

}

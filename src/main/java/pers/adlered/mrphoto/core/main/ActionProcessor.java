package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.database.ActionDatabase;

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
        path = path.replaceAll("\\\\", "/");
        filename = filename.replaceAll("\\\\", "")
                .replaceAll("/", "");
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        try {
            actionDatabase.create(path, filename, isFile);
            return true;
        } catch (Exception e) {
            Logger.warn("Create action failed.");
            return false;
        }
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

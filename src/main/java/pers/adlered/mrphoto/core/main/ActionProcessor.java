package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.database.ActionDatabase;

public class ActionProcessor {

    /**
     * 使用 volatile 修饰以便在切换目录和行为数据库时，正在运行的线程也可以跟进而不是使用缓存。
     */
    private volatile String dir;
    private volatile ActionDatabase actionDatabase;

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

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
    public boolean create(String path, String filename) {
        System.out.println("hello world");
        return false;
    }

    public boolean delete(String path, String filename) {
        return false;
    }

    public boolean upload(File file, String path, String filename) {
        return false;
    }

    public Prop prop(String path, String filename) {
        return null;
    }

    public ArrayList<File[]> fetch(String path) {
        return null;
    }

    public boolean move(String path, String filename, String newPath, String newFilename) {
        return false;
    }

    public boolean copy(String path, String filename, String newPath, String newFilename) {
        return false;
    }

    public File download(String path, String filename) {
        return null;
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

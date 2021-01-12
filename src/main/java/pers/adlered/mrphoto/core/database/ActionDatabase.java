package pers.adlered.mrphoto.core.database;

import pers.adlered.mrphoto.core.bean.Prop;

import java.util.ArrayList;

public interface ActionDatabase {

    // 创建指定文件或文件夹
    public boolean create(String path, String filename);
    // 删除指定文件或文件夹
    public boolean delete(String path, String filename);
    // 上传文件
    public boolean upload(java.io.File file, String path, String filename);
    // 获取文件属性
    public Prop prop(String path, String filename);
    // 获取当前目录文件列表
    public ArrayList<pers.adlered.mrphoto.core.bean.File[]> fetch(String path);
    // 移动文件或文件夹
    public boolean move(String path, String filename, String newPath, String newFilename);
    // 复制文件或文件夹
    public boolean copy(String path, String filename, String newPath, String newFilename);
    // 下载文件
    public java.io.File download(String path, String filename);

}

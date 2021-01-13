package pers.adlered.mrphoto.core.database;

import com.upyun.UpException;
import pers.adlered.mrphoto.core.bean.Prop;

import java.io.IOException;
import java.util.ArrayList;

public interface ActionDatabase {

    // 字符串中以每个子类不同的格式要求传入需要的常量，比如用户名密码等
    public void setVal(String val);
    // 创建指定文件或文件夹
    public boolean create(String path, String filename, boolean isFile);
    // 删除指定文件或文件夹
    public boolean delete(String path, String filename, boolean isFile);
    // 上传文件
    public boolean upload(java.io.File file, String path, String filename);
    // 获取文件属性
    public Prop prop(String path, String filename);
    // 获取当前目录文件列表
    public ArrayList<pers.adlered.mrphoto.core.bean.File[]> fetch(String path);
    // 移动文件或文件夹
    public boolean move(String path, String filename, String newPath, String newFilename, boolean isFile);
    // 复制文件或文件夹
    public boolean copy(String path, String filename, String newPath, String newFilename, boolean isFile);
    // 下载文件
    public java.io.File download(String path, String filename);
    // 提供一个可供预览的 HTTP URL 地址
    public String getURL(String path, String filename);
    // 要求提供停止线程的方法，防止内存泄漏，该方法需要阻塞
    public void shutdown();

}

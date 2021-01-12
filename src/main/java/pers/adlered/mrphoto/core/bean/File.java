package pers.adlered.mrphoto.core.bean;

/**
 * 虚拟文件，用于保存属性。
 * 不产生实际上的文件处理，用来表示网络上的文件。
 */
public class File {

    private boolean isDirectory = false;
    private String filename = "";

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

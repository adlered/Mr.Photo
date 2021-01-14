package pers.adlered.mrphoto.core.bean;

/**
 * 虚拟文件，用于保存属性。
 * 不产生实际上的文件处理，用来表示网络上的文件。
 */
public class File {

    // 文件名
    private String filename = "";
    // 是否为文件夹
    private boolean imDirectory = false;
    // 上一次修改时间的时间戳
    Long lastDate;
    // 文件大小
    Long size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isImDirectory() {
        return imDirectory;
    }

    public void setImDirectory(boolean imDirectory) {
        this.imDirectory = imDirectory;
    }

    public Long getLastDate() {
        return lastDate;
    }

    public void setLastDate(Long lastDate) {
        this.lastDate = lastDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

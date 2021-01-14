package pers.adlered.mrphoto.core.bean;

public class Prop {

    // 文件名
    String filename;
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

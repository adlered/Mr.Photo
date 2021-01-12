package pers.adlered.mrphoto.core.bean;

public class Prop {

    // 文件名
    String filename;
    // 上一次修改时间的时间戳
    Long lastDate;
    // 文件大小
    Float size;

    public Prop(String filename, Long lastDate, Float size) {
        this.filename = filename;
        this.lastDate = lastDate;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLastDate() {
        return lastDate;
    }

    public Float getSize() {
        return size;
    }
}

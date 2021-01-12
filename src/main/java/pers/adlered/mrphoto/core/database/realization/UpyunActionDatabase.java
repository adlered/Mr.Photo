package pers.adlered.mrphoto.core.database.realization;

import pers.adlered.mrphoto.core.bean.Prop;
import pers.adlered.mrphoto.core.database.ActionDatabase;

import java.util.ArrayList;

public class UpyunActionDatabase implements ActionDatabase {

    @Override
    public boolean create(String path, String filename) {
        System.out.println("hello world");
        return false;
    }

    @Override
    public boolean delete(String path, String filename) {
        return false;
    }

    @Override
    public boolean upload(java.io.File file, String path, String filename) {
        return false;
    }

    @Override
    public Prop prop(String path, String filename) {
        return null;
    }

    @Override
    public ArrayList<pers.adlered.mrphoto.core.bean.File[]> fetch(String path) {
        return null;
    }

    @Override
    public boolean move(String path, String filename, String newPath, String newFilename) {
        return false;
    }

    @Override
    public boolean copy(String path, String filename, String newPath, String newFilename) {
        return false;
    }

    @Override
    public java.io.File download(String path, String filename) {
        return null;
    }
}

package pers.adlered.mrphoto.core.main;

/**
 * 统一日志输出。
 */
public class Logger {

    private static String prefix = "[MR.PHOTO] ";
    private static String suffix = "";

    public static void info(String message) {
        System.out.println(prefix + message + suffix);
    }

    public static void setPrefix(String prefix) {
        Logger.prefix = prefix;
    }

    public static void setSuffix(String suffix) {
        Logger.suffix = suffix;
    }
}

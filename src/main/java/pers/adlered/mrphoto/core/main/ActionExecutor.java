package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.database.ActionDatabase;
import pers.adlered.mrphoto.core.database.realization.UpyunActionDatabase;

/**
 * ActionExecutor 是面向用户的类。
 * 如要使用 Mr.Photo，请实例化 ActionExecutor 类，然后：
 * 1. 使用 setActionDatabaseTo...() 方法设定行为数据库
 * 2. 使用 getActionProcessor() 方法获得 ActionProcessor 对象，以进行指定图床的增删改查等操作，详情请参阅
 * @see pers.adlered.mrphoto.core.main.ActionProcessor
 *
 * 如要添加一个新的行为数据库：
 * 1. 在 pers.adlered.mrphoto.core.database.realization 中添加一个新的类，并 implements ActionDatabase 进行重写
 * 2. 在 pers.adlered.mrphoto.core.main.ActionExecutor 中添加 setActionDatabaseTo 开头的方法用于切换行为数据库
 */
public class ActionExecutor {

    // ActionProcessor 必须由 ActionExecutor 进行实例化和控制
    private ActionProcessor actionProcessor = new ActionProcessor();

    // 修改 ActionDatabase 使用的行为数据库（切换OSS）
    private void loadActionDatabase(ActionDatabase actionDatabase) throws IllegalAccessException, InstantiationException {
        actionProcessor.cActionDatabase(actionDatabase);
    }

    /**
     * 以下 setActionDatabaseTo 开头的方法皆为面向用户的图床配置切换方法。
     */

    // 又拍云行为数据库
    public void setActionDatabaseToUpyun() {
        ActionDatabase actionDatabase = new UpyunActionDatabase();
        try {
            loadActionDatabase(actionDatabase);
            Logger.info("Upyun OSS in use.");
        } catch (Exception e) {
            Logger.warn("Use Upyun OSS failed.");
        }
    }

    /**
     * 获取实例化的 ActionProcessor
     * 以进行文件操作。
     * @return 实例化后的 ActionProcessor
     */
    public ActionProcessor getActionProcessor() {
        return actionProcessor;
    }

    public void shutdown() {
        actionProcessor.shutdown();
        Logger.info("Shutdown OK.");
    }

}

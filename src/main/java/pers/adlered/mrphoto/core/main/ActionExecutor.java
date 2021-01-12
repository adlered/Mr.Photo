package pers.adlered.mrphoto.core.main;

import pers.adlered.mrphoto.core.database.ActionDatabase;
import pers.adlered.mrphoto.core.database.realization.UpyunActionDatabase;

public class ActionExecutor {

    // ActionProcessor 必须由 ActionExecutor 进行实例化和控制
    private final ActionProcessor actionProcessor = new ActionProcessor();

    // 修改 ActionDatabase 使用的行为数据库（切换OSS）
    private void loadActionDatabase(ActionDatabase actionDatabase) throws IllegalAccessException, InstantiationException {
        actionProcessor.cActionDatabase(actionDatabase);
    }

    /**
     * 以下 setActionDatabaseTo 开头的方法皆为面向用户的图床配置切换方法。
     */

    // 又拍云行为数据库
    public void setActionDatabaseToUpyun() throws InstantiationException, IllegalAccessException {
        ActionDatabase actionDatabase = new UpyunActionDatabase();
        loadActionDatabase(actionDatabase);
    }

    /**
     * 获取实例化的 ActionProcessor
     * 除非有特殊需要，否则不建议调用该方法。
     * @return 实例化后的 ActionProcessor
     */
    public ActionProcessor getActionProcessor() {
        return actionProcessor;
    }


}

package pers.adlered.mrphoto.core.main;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ActionExecutor actionExecutor = new ActionExecutor();
        actionExecutor.setActionDatabaseToUpyun();
        ActionProcessor actionProcessor = actionExecutor.getActionProcessor();
        actionProcessor.setVal("helloooooo");
        actionProcessor.create("", "");
    }
}

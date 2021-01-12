package pers.adlered.mrphoto.core.main;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ActionExecutor actionExecutor = new ActionExecutor();
        actionExecutor.setActionDatabaseToUpyun();
        actionExecutor.getActionProcessor().setVal("helloooooo");
        actionExecutor.getActionProcessor().create("", "");
    }
}

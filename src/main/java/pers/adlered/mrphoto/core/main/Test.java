package pers.adlered.mrphoto.core.main;

public class Test {
    public static void main(String[] args) {
        ActionExecutor actionExecutor = new ActionExecutor();
        actionExecutor.setActionDatabaseToUpyun();
        actionExecutor.getActionProcessor().setVal("adler-s-netdisk\ntemp\n7m6L2J4YZwJ1kOzzTqOc8eHyGvEuu0BD");
        actionExecutor.getActionProcessor().create("/", "test4", false);
        actionExecutor.shutdown();
        actionExecutor.getActionProcessor().create("/", "test4", false);
        actionExecutor.getActionProcessor().setVal("adler-s-netdisk\ntemp\n7m6L2J4YZwJ1kOzzTqOc8eHyGvEuu0BD");
        actionExecutor.setActionDatabaseToUpyun();

    }
}

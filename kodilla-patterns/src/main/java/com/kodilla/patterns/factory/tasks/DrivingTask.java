package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    String taskName;
    String where;
    String using;
    boolean isTaskExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }

    public void executeTask() {
        System.out.println("Task is executed");
        isTaskExecuted = true;
    }

    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}

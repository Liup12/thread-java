package com.thread.lp.task;


/**
 * @author Administrator
 */
public class TaskMsg {

    private String taskId;

    private String vin;

    private String msg;

    public TaskMsg() {
    }

    public TaskMsg(String taskId, String vin, String msg) {
        this.taskId = taskId;
        this.vin = vin;
        this.msg = msg;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TaskMsg{" +
                "taskId='" + taskId + '\'' +
                ", vin='" + vin + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

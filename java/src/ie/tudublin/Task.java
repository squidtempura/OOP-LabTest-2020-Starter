package ie.tudublin;

import processing.data.TableRow;

public class Task {
    String task;
    int start;
    int end;

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }
    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    @Override
    public String toString() {
        return "Task [Task=" + task +",Start=" + start + ",End=" + end +"]";
    }

    public String getTask() {
        return task;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
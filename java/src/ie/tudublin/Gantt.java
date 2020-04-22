package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	//declare an ArrayList to hold instances of the Task class
	public ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	//populates the ArrayList from the file tasks.csv
	public void loadTasks()
	{
		Table T = loadTable("tasks.csv", "header");
		for(TableRow row:T.rows())
		{
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	//prints the elements of the ArrayList
	public void printTasks()
	{
		for(Task t:tasks)
        {
            System.out.println(t);
        }	
	}

	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}

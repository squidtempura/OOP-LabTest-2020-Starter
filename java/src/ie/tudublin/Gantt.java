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

	public void displayTasks()
	{
		colorMode(HSB);
		int color = 0;
		float colorGap = 255 / 10.0f;
		float border = width * 0.05f;
        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <= 30 ; i ++)
        {
			float x = map(i, 1, 30, border, width - border);
			stroke(255);
            line(x, border, x, height - border);
            fill(255);
            text(i, x, border / 2);
		}	
		for(int i = 0 ; i < 9 ; i ++)
        {
			float y = map(i, 1, 9, border, height - border);
			fill(255);
			text(i, border/2, y/2+100);
			fill(color,255,255);
			rect(border,y/2+95,border,15);
			color += colorGap;
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
		displayTasks();
	}
}

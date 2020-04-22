package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	//declare an ArrayList to hold instances of the Task class
	public ArrayList<Task> tasks = new ArrayList<Task>();

	float bx;
	float xoffset = 0; 

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
		Table T = loadTable("tasks.csv", "header");

		float wborder = width * 0.08f;
		float hborder = height * 0.05f;
		
		colorMode(HSB);
		
		
        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <= 30 ; i ++)
        {
			float x = map(i, 1, 30, wborder, width - wborder);
			stroke(255);
            line(x, wborder, x, height - wborder);
            fill(255);
            text(i, x, wborder / 2);
		}
		for(int i = 0 ; i < tasks.size() ; i ++)
        {
			float colorGap = map(i, 0, tasks.size(), 0, 255);
			float y = map(i, 1, 9, hborder, height - hborder);
			fill(255);
			text(T.getString(i,"Task"), hborder, y/2+100);
			fill(colorGap,255,255);
			rect((width-2*wborder)*(T.getInt(i,"Start")-1)/29+wborder,y/2+95,(width-2*wborder)*(T.getInt(i,"End")-T.getInt(i,"Start"))/29,15);
		}
	}

	public void mousePressed()
	{
		println("Mouse pressed");
		xoffset = mouseX - bx;	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
		bx = mouseX - xoffset;
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

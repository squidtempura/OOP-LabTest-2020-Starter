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
		float rectStart = 0;
		float rectEnd = 0;
		float recty = 0;


		float wborder = width * 0.05f;
		float hborder = height * 0.05f;
		
		colorMode(HSB);
        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <= 30 ; i ++)
        {
			float x = map(i, 1, 30, wborder*2, width - wborder);
			stroke(255);
            line(x, wborder, x, height - hborder);
            fill(255);
            text(i, x, wborder / 2);
		}
		for(int i = 0 ; i < tasks.size() ; i ++)
        {
			rectStart = map(tasks.get(i).getStart(),1,30,wborder*2,width-wborder);
			rectEnd = map(tasks.get(i).getEnd(),1,30,wborder*2,width-wborder);
			recty = map(i,0,tasks.size(),hborder*2,height-hborder*2);
			float colorGap = map(i, 0, tasks.size(), 0, 255);
			fill(255);
			text(tasks.get(i).getTask(), hborder, recty+10);
			fill(colorGap,255,255);
			rect(rectStart, recty,rectEnd-rectStart,15);
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

package br.student.gabriel.app;

import br.student.gabriel.controller.FileHandler;
import br.student.gabriel.entities.Task;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TaskTrackerCLI {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		FileHandler fileHandler = new FileHandler();
		ArrayList<Task> tasks = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		fileHandler.JSONUnserializer(tasks);

		if(args.length > 0){
			switch (args[0]){
				case "list":
					if(args.length > 1)
						fileHandler.listTasks(tasks, args[1]);
					break;
				case "add":
					if(args.length > 1){
						addTask(tasks, scanner, args[1]);
					}
					break;
				case "update":
					if (args.length > 1){
						updateTask(tasks, Integer.parseInt(args[1]), args[2]);
					}
					break;
				case "remove":
					removeTask(tasks, Integer.parseInt(args[1]));
					break;
				case "mark-in-progress":
					markInProgress(tasks, Integer.parseInt(args[1]));
					break;
				case "mark-done":
					markDone(tasks, Integer.parseInt(args[1]));
					break;
			}
		}

		fileHandler.JSONSerializer(tasks);
	}

	public static void addTask(ArrayList<Task> tasks, Scanner scanner, String description){
		System.out.print("Task ID: ");
		int tempID = scanner.nextInt();
		scanner.nextLine();

		tasks.add(new Task(tempID, description));
	}
	public static void updateTask(ArrayList<Task> tasks, int index, String description){
		for (Task task : tasks)	{
			if (task.getID() == index) {
				task.setDescription(description);
				task.setUpdatedAt();
				break;
			}

		}
	}

	public static void removeTask(ArrayList<Task> tasks, int index){
		for (int i = 0; i < tasks.size() ; i ++){
			if (tasks.get(i).getID() == index)	{
				tasks.remove(i);
				break;
			}
		}
	}

	public static void markDone(ArrayList<Task> tasks, int index){
		for (Task task : tasks) {
			if (task.getID() == index) {
				task.setStatus("done");
				break;
			}
		}
	}

	public static void markInProgress(ArrayList<Task> tasks, int index){
		for (Task task : tasks) {
			if (task.getID() == index) {
				task.setStatus("in-progress");
				break;
			}
		}
	}

}

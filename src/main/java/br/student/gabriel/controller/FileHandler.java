package br.student.gabriel.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import br.student.gabriel.entities.Task;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileHandler {
	private File fileObject = new File("tasks.json");
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy"
	);
	private JSONArray jsonArray;

	public FileHandler(){
		createFile();
	}


	private void createFile(){
		try {

			if (fileObject.createNewFile())	{
				System.out.println("File created as => " + fileObject.getName());
			} else {
				System.out.println("File loaded as => " + fileObject.getName());
			}

		} catch (Exception e) {
			throw new RuntimeException("Error Occur");
		}
	}

	public void JSONSerializer(ArrayList<Task> tasks){
		// Initialize JSONARRAY (the equivalent of ArrayList<Task>;
		jsonArray = new JSONArray();

		for (Task task : tasks){
			JSONObject temporaryJSONObject = new JSONObject();

			// Populate Object
			temporaryJSONObject.put("ID", task.getID());
			temporaryJSONObject.put("status", task.getStatus());
			temporaryJSONObject.put("description", task.getDescription());
			temporaryJSONObject.put("createdAt", task.getCreatedAt());
			temporaryJSONObject.put("updatedAt", task.getUpdatedAt());

			jsonArray.put(temporaryJSONObject);

		}


		try {
			FileWriter fileWriter = new FileWriter("tasks.json");

			fileWriter.write(jsonArray.toString(2));
			fileWriter.close();

			System.out.println("File Saved...");
		} catch (IOException e) {
			System.out.println("Something has gone wrong");
			throw new RuntimeException(e);
		}
	}


	public void JSONUnserializer(ArrayList<Task> tasks){
		try {
			String test = new String(Files.readAllBytes(fileObject.toPath()));

			if (!test.isBlank() || !test.isEmpty()){
				jsonArray = new JSONArray(test);

				for (int index = 0; index < jsonArray.length(); index++){
					var currentObject = jsonArray.getJSONObject(index);
					try{
						tasks.add(new Task(
								currentObject.getInt("ID"),
								currentObject.getString("description"),
								simpleDateFormat.parse(currentObject.getString("createdAt")),
								simpleDateFormat.parse(currentObject.getString("updatedAt")),
								currentObject.getString("status")
						));
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}

			} else {
				System.out.println("No Tasks Registered.");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void listTasks(ArrayList<Task> tasks, String mode){
		for(Task task: tasks){
			switch (mode){
				case "all":
					System.out.println(task.toString());
					break;
				case "done":
					if (task.getStatus().equals("done")){
						System.out.println(task.toString());
					}
					break;
				case "todo":
					if (task.getStatus().equals("todo")){
						System.out.println(task.toString());
					}
					break;
				case "in-progress":
					if (task.getStatus().equals("in-progress")){
						System.out.println(task.toString());
					}
					break;
				default:
					System.out.println("Not enough args provided, try [done - in-progress - todo].");
			}
		}
	}
}

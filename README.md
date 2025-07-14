# TaskTrackerCLI - Java Version
<detail>This project is originally idealized by <a href="https://roadmap.sh/projects/task-tracker">roadmap.sh</a>.</detail>
<hr>

# Use Cases

Use <code> java -jar TaskTrackerCLI [arguments] </code> to play around.
<ul>
  <li>To add a item, <code>java -jar TaskTrackerCLI add "item"</code></li>
  <li>To remove a item, <code>java -jar TaskTrackerCLI remove index</code></li>
  <li>You can update the item using <code>java -jar TaskTrackerCLI update index</code></li>
  <li>You can mark as done or in-progress item using <code>java -jar TaskTrackerCLI mark-in-progress/mark-done index</code></li>
  <li>As to list, <code>java -jar TaskTrackerCLI list [all, in-progress, done, todo]</code></li>
</ul>

# JSON Storage
The application uses a JSON storage system the file is name <code>tasks.json</code>, which you can freely edit to fit your needs.




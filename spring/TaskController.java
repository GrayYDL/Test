@RestController
class TaskController {

	private final TaskRepository repository;

	TaskController(TaskRepository repository) {
		this.repository = repository;
	}
@GetMapping("/api/tasks")
	List<Task> all() {
		return repository.findAll();
	}
@PostMapping("/api/tasks")
	Task newTask(@RequestBody Task newTask) {
		return repository.save(newTask);
	}
@GetMapping("/api/tasks/{id}")
	Task one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new TaskNotFoundException(id));
	}
@DeleteMapping("/api/tasks/{id}")
	void deleteTask(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
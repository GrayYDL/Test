@Data
@Entity
class Task {

	private @Id @GeneratedValue Long id;
	private String content;
	private String createdTime;

	Task() {}

	Task(String content, String createdTime) {
		this.content = content;
		this.createdTime = createdTime;
	}
}
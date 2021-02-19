package examples.recap2021.metamodel;

public class Option {
	public Option(String text2) {
		text = text2;
	}
	private String text;
	private String targetName;
	private Target target;
	public void setTargetName(String target_name) {
		targetName = target_name;
		
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public String getText() {
		return text;
	}
	public Target getTarget() {
		return target;
	}
}

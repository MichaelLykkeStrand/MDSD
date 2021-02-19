package examples.decisiondiagram.metamodel;

public class Target {
	public Target(String name2, String text2) {
		name = name2;
		text = text2;
	}
	protected String name;
	protected String text;
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
}

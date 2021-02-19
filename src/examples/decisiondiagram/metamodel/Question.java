package examples.decisiondiagram.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Question extends Target {
	
	public Question(String name, String text) {
		super(name,text);
	}

	private List<Option> options = new ArrayList<Option>();

	public List<Option> getOptions() {
		return options;
	}

	public void addOption(Option currentOption) {
		options.add(currentOption);
	}
}

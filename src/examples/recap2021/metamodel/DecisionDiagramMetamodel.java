package examples.recap2021.metamodel;

import java.util.ArrayList;
import java.util.List;

public class DecisionDiagramMetamodel {
	public DecisionDiagramMetamodel(String name2) {
		name = name2;
	}
	private String name;
	private List<Target> targets = new ArrayList<Target>();
	private Target initialTarget;
	public void addInitialQuestion(Question q) {
		targets.add(q);
		if(initialTarget!=null) throw new Error("Inconsistent metamodel");
		initialTarget = q;
	}
	public void addQuestion(Question currentQuestion) {
		targets.add(currentQuestion);
		
	}
	public void addGoal(Goal g) {
		targets.add(g);
	}
	public List<Target> getTargets() {
		return targets;
	}
	public String getName() {
		return name;
	}
	public Target getInitialTarget() {
		return initialTarget;
	}
}

package examples.decisiondiagram.dsl;

import java.util.HashMap;
import java.util.Map;

import examples.decisiondiagram.metamodel.DecisionDiagramMetamodel;
import examples.decisiondiagram.metamodel.Goal;
import examples.decisiondiagram.metamodel.Option;
import examples.decisiondiagram.metamodel.Question;
import examples.decisiondiagram.metamodel.Target;

public class DecisionDiagramDSL {
	protected Builder decisiondiagram(String name) {
		return new Builder(name);
	}
	protected static class Builder {
		protected DecisionDiagramMetamodel model;
		private Question currentQuestion;
		private Option currentOption;
		protected Builder(String name) {
			model = new DecisionDiagramMetamodel(name);
		}
		public Builder initial(String text) {
			currentQuestion = new Question(null,text);
			model.addInitialQuestion(currentQuestion);
			return this;
		}
		public Builder option(String text) {
			currentOption = new Option(text);
			currentQuestion.addOption(currentOption);
			return this;
		}
		public Builder to(String target_name) {
			if(currentOption==null) throw new Error("Syntax error");				
			currentOption.setTargetName(target_name);
			return this;
		}
		public Builder question(String name, String text) {
			currentQuestion = new Question(name,text);
			model.addQuestion(currentQuestion);
			return this;
		}
		public Builder goal(String name, String string2) {
			model.addGoal(new Goal(name,string2));
			return this;
		}
		public DecisionDiagramMetamodel done() {
			Map<String,Target> symbolTable = new HashMap<String,Target>();
			for(Target t: model.getTargets()) {
				if(t.getName()!=null) symbolTable.put(t.getName(), t);
			}
			for(Target t: model.getTargets()) {
				if(t instanceof Question) {
					Question q = (Question)t;
					for(Option p: q.getOptions()) {
						Target target = symbolTable.get(p.getTargetName());
						if(target==null) throw new Error("Undefined name: "+p.getTargetName());
						p.setTarget(target);
					}
				}
			}
			return model;
		}
	}
}

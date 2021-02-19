package examples.decisiondiagram;

import examples.decisiondiagram.dsl.DecisionDiagramDSL;
import examples.decisiondiagram.dsl.DecisionDiagramExecutor;
import examples.decisiondiagram.metamodel.DecisionDiagramMetamodel;

public class StudentLife extends DecisionDiagramDSL {
	public DecisionDiagramMetamodel build() {
		return
		decisiondiagram("Student life").
		  initial("How do you imagine your student life").
		    option("The main thing is to have the best time of my life").to("DreamCareer").
		    option("Student life? I am interested in the curriculum and the degree").to("RelIntFlex").
		  question("DreamCareer","And what does the beginning of your dream career look like").
		    option("A").to("BeAStudent").
		    option("B").to("GiveUp").
		  goal("BeAStudent","Be a student").
		  goal("GiveUp","Don't be a student").
		  goal("RelIntFlex","Not implemented yet").
		  done();
	}
	public static void main(String argv[]) {
		StudentLife s = new StudentLife();
		DecisionDiagramMetamodel mm = s.build();
		DecisionDiagramExecutor exec = new DecisionDiagramExecutor(mm);
		exec.run();
	}
}

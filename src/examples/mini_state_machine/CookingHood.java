package examples.mini_state_machine;

import examples.mini_state_machine.metamodel.Machine;

public class CookingHood extends StateMachine {

	
	
	public static void main(String[] args) {
		new CookingHood().example();
	}

	private void example() {
		// Build (i.e., create metamodel instance)
		Machine mo = this.machine().
				state("OFF").initial().
					when("+").to("ON",() -> {System.out.println("turn on");}).
				state("ON").
					when("+").to("MAX",() -> {System.out.println("go to max");}).
					when("-").to("OFF",() -> {System.out.println("turn off");}).
				state("MAX").
					when("-").to("ON",() -> {System.out.println("normal again");}).
				build();
		// Runtime (i.e., execute the metamodel instance)
		MachineInterpreter mi = new MachineInterpreter(mo);
		mi.processEvent("+");
		mi.processEvent("+");
		mi.processEvent("+");
		mi.processEvent("+");
		mi.processEvent("-");
		mi.processEvent("-");
		mi.processEvent("-");
		mi.processEvent("-");
		mi.processEvent("-");
	}

}

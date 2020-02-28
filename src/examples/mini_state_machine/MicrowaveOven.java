package examples.mini_state_machine;

import examples.mini_state_machine.metamodel.Machine;

public class MicrowaveOven extends StateMachine {

	
	
	public static void main(String[] args) {
		new MicrowaveOven().example();
	}

	private void example() {
		Machine mo = this.machine().
				state("OFF").initial().
					when("power").to("ON",() -> {System.out.println("turned on");}).
				state("ON").
					when("time").to("OFF",() -> {System.out.println("time is up");}).
					when("stop").to("OFF",() -> {System.out.println("turned off");}).
					when("open").to("PAUSE",() -> {System.out.println("door opened");}).
				state("PAUSE").
					when("close").to("ON",() -> {System.out.println("door closed");}).
					when("stop").to("OFF",() -> {System.out.println("turned off (remember to close the door)");}).
				build();
		MachineInterpreter mi = new MachineInterpreter(mo);
		mi.processEvent("power");
		mi.processEvent("stop");
		mi.processEvent("power");
		mi.processEvent("open");
		mi.processEvent("close");
		mi.processEvent("stop");
		mi.processEvent("stop");
		mi.processEvent("stop");
	}

}

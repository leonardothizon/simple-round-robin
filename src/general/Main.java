package general;

import control.CPU;
import control.Control;
import control.Processo;

public class Main {

	
	public static void main(String[] args) {
		
		Control control = new Control();
		CPU cpu  = new CPU(3);
		control.setCpu(cpu);
		
		Processo p1 = new Processo(6, 1);
		control.addProcess(p1);
		Processo p2 = new Processo(4, 2);
		control.addProcess(p2);
		Processo p3 = new Processo(2, 3);
		control.addProcess(p3);
		Processo p4 = new Processo(9, 5);
		control.addProcess(p4);
		Processo p5 = new Processo(13, 6);
		control.addProcess(p5);
		Processo p6 = new Processo(5, 9);
		control.addProcess(p6);
		
		control.run();

	}

}

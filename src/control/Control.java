package control;

import java.util.LinkedList;
import java.util.Queue;

public class Control {

	private Queue<Processo> processes;
	
	private CPU cpu;
	
	/**
	 * Tempo transcorrido pelo computador
	 * Elapsed time 
	 */
	private long elapsed = 0;
	
	private static long sequenceID = 0;
	public static long getSequence() {
		return sequenceID++;
	}
	
	public Control() {
		processes = new LinkedList<>();
	}
	
	public void addProcess(Processo p) {
		processes.add(p);
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public void run() {
		
		while(processes.size() > 0) {
			
			Processo p = processes.poll();
			
			long remain = cpu.process(p);
			elapsed += remain + cpu.getTimeQuantum();
			
			if(p.getBurstTime() > 0)
				processes.add(p);
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Processos restantes: "+ processes.size());
			
		}
		
		System.out.println("Time elapsed: "+ elapsed);
		
		
	}
	
}

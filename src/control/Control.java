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
	private long timeSlace = 1;
	
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
		
		while(processes.size() > 0) { //enquanto existirem processos na fila
				
			Processo p = processes.poll(); // pega o primeiro da fila
			
			if(p.getArrivalTime() <= timeSlace) { // se � o arrivaltime do processo
			
				timeSlace++;
				
				long remain = cpu.process(p);
				
				// verifica se burst time do processo era menor do que o quantum time da CPU
				if(remain < 0)
					elapsed += remain + cpu.getTimeQuantum();
				else
					elapsed += cpu.getTimeQuantum();
				
				// caso n�o tenha terminado, coloca o processo no final da fila
				if(p.getBurstTime() > 0)
					processes.add(p);
				
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println();
				System.out.println(" Processos restantes: "+ processes.size() +" ");
				System.out.println();
			
			} else {
				processes.add(p);
			}
			
		}
		
		System.out.println("Time elapsed: "+ elapsed);
		
		
	}
	
}

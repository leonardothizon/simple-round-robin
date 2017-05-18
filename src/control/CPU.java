package control;

public class CPU {
	
	private int timeQuantum;
	
	public CPU(int timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	
	public int getTimeQuantum() {
		return timeQuantum;
	}

	public long process(Processo p) {
		System.out.print("Processando #"+ p.getId() +" (Tamanho= "+ p.getSize() +")...");
		long burst = p.getBurstTime() - timeQuantum;
		
		if(burst < 0) {
			System.out.print(" Burst Time = 0");
			p.setBurstTime(0);
			return burst;
		} else {
			System.out.print(" Burst Time = "+ burst);
			p.setBurstTime(burst);			
			return 0;
		}
		
	}

}

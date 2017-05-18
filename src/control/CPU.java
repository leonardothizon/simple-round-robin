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
		System.out.println("Processando "+ p.getId());
		long burst = p.getBurstTime() - timeQuantum;
		System.out.println("Restante: "+ burst);
		if(burst >= 0) {
			p.setBurstTime(burst);			
			return 0;
		} else {
			p.setBurstTime(0);
			return burst * -1;
		}
	}

}

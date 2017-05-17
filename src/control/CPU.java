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
		return p.execute(timeQuantum);
	}

}

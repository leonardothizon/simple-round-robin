package control;

public class Processo {
	
	private long id;
	
	private long size;
	
	private long burstTime;
	private int arrivalTime;
	
	public Processo(long size, int arrivalTime) {
		this.size = size;
		this.burstTime = this.size;
		this.arrivalTime = arrivalTime;
		this.id = Control.getSequence();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getBurstTime() {
		return burstTime;
	}
	
	public void setBurstTime(long burstTime) {
		this.burstTime = burstTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

}

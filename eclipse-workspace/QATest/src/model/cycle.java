package model;

public class cycle {
	private int idVersion;
	private String nameCycle;
	private int ctdCasos;
	private int ctdExito;
	private int ctdDefec;
	private int ctdPend;
	private float porExit;
	private float porInc;

	
	@Override
	public String toString() {
		return "cycle [idVersion=" + idVersion + ", nameCycle=" + nameCycle + ", ctdCasos=" + ctdCasos + ", ctdExito="
				+ ctdExito + ", ctdDefec=" + ctdDefec + ", ctdPend=" + ctdPend + ", porExit=" + porExit + ", porInc="
				+ porInc + "]";
	}

	public cycle (int idVersion, String nameCycle, int ctdCasos, int ctdExito, int ctdDefec, int ctdPend,
			float porExit, float porInc) {
		super();
		this.idVersion = idVersion;
		this.nameCycle = nameCycle;
		this.ctdCasos = ctdCasos;
		this.ctdExito = ctdExito;
		this.ctdDefec = ctdDefec;
		this.ctdPend = ctdPend;
		this.porExit = porExit;
		this.porInc = porInc;
	}

	public int getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}
	public String getNameCycle() {
		return nameCycle;
	}
	public void setNameCycle(String nameCycle) {
		this.nameCycle = nameCycle;
	}
	public int getCtdCasos() {
		return ctdCasos;
	}
	public void setCtdCasos(int ctdCasos) {
		this.ctdCasos = ctdCasos;
	}
	public int getCtdExito() {
		return ctdExito;
	}
	public void setCtdExito(int ctdExito) {
		this.ctdExito = ctdExito;
	}
	public int getCtdDefec() {
		return ctdDefec;
	}
	public void setCtdDefec(int ctdDefec) {
		this.ctdDefec = ctdDefec;
	}
	public int getCtdPend() {
		return ctdPend;
	}
	public void setCtdPend(int ctdPend) {
		this.ctdPend = ctdPend;
	}
	public float getPorExit() {
		return porExit;
	}
	public void setPorExit(float porExit) {
		this.porExit = porExit;
	}
	public float getPorInc() {
		return porInc;
	}
	public void setPorInc(float porInc) {
		this.porInc = porInc;
	}
	
	
}

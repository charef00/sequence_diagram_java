package grp2;

public class Virement 
{
	private double mnt;
	private Compte src;
	private Compte dest;
	
	public Virement(double mnt, Compte src, Compte dest) 
	{
		this.mnt = mnt;
		this.src = src;
		this.dest = dest;
	}
	
	public boolean effectuer()
	{
		boolean rtn=this.src.retirer(this.mnt);
		if(!rtn)
		{
			return false;
		}
		rtn=this.dest.deposer(this.mnt);
		
		return rtn;
	}
	
	
	

}

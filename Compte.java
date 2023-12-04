package grp2;

public class Compte 
{
	private String ncom;
	private double solde;
	
	public Compte(String ncom, double solde) {
		this.ncom = ncom;
		this.solde = solde;
	}
	
	public boolean retirer(double mnt)
	{
		if(mnt<=solde)
		{
			this.solde-=mnt;
			return true;
		}
		
		return false;
	}
	
	
	public boolean deposer(double mnt)
	{
		if(mnt>0)
		{
			this.solde+=mnt;
			return true;
		}
		
		return false;
	}

	public String getNcom() {
		return ncom;
	}

	public void setNcom(String ncom) {
		this.ncom = ncom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	
	
	
	

}

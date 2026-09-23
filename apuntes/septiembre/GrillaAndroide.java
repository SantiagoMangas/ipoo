public class GrillaAndroide{
	private Androide[][] grilla;
	
	public GrillaAndroide(int nFil, int nCol){
		grilla = new Androide[nFil][nCol];
	}
	
	public void establecerAndroide(Androide a, int f, int c){
		grilla[f][c] = a;
	}
	
	public Androide obtenerAndroide(int f, int c){
		return grilla[f][c];
	}
	
	public int cantAndroides(){
		int cont = 0;
		for (int i; i < grilla[0].length; i++){
			for (int j; j < grilla.length; j++){
				if (grilla[i][j] != null)
					cont++;
			}
		}
		return cont;
	}
	public int AndriodesFilas(){
		
	}
}

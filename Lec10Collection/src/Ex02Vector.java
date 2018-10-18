import java.util.Vector;

public class Ex02Vector {
	public static void main(String[] args) {
		Vector vector = new Vector();
		
		vector.add(new String("이산"));
		vector.add(new Integer(25));
		vector.add(180.26);//Auto Boxing
		System.out.println(vector);
		
		for(int i=0; i<vector.size(); i++) {
			Object obj =vector.get(i);
			System.out.println(obj);
		}
	}
}

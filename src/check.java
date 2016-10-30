
public class check {
	public static boolean check(int n, String mas[]) {
		// tox stugum
		int tox = n - n % 3;

		if (mas[tox] == mas[tox + 1] && mas[tox] == mas[tox + 2])
			return true;

		// syan stugum
		int syun = n % 3;
		if (mas[syun] == mas[syun + 3]) {
			if (mas[syun] == mas[syun + 6]) {
				return true;
			}
		}
		//
		if (n % 2 != 0)
			return false;
		// ankyunagcov
		if (n % 4 == 0) {
			if (mas[0] == mas[4] && mas[0] == mas[8])
				return true;
			 if (n!=4) return false;
		}
		return (mas[2] == mas[4] && mas[2] == mas[6]);

	}
	public static boolean nichiya(String []mas){
		boolean t=true;
		for(int i=0;i<mas.length;i++){
			if("-".equals(mas[i])){
				t=false;
				break;
			}
		}
		return t;
	}
	public static boolean shutStugum(String []mas){
		int toxTemp = 0,syunTemp = 0;
		for(int i=0;i<mas.length;i++){
			if(mas[i].equals("-")){
				toxTemp=i-(i%3);
				syunTemp=i%3;
				break;
			}		
		}
		if(!mas[toxTemp].equals(mas[toxTemp+1].equals(mas[toxTemp+2]))){
			if(!mas[syunTemp].equals(mas[syunTemp+3].equals(mas[syunTemp+6]))){
				return true;
			}
		}
		return false;
	}
}

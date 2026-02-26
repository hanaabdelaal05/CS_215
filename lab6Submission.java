import java.time.*;
public class lab6Submission{
	public static void main(String[] args) throws Exception {
		LocalDateTime t1= LocalDateTime.now();
		//Excute putitem 250000 times on Ar_ulisy
		Ar_UList Listitems = new Ar_UList();
		for (int i=0;i<250000;++i) {
			Listitems.putItem(i);
		}
		LocalDateTime t2 = LocalDateTime.now();
		System.out.println(Duration.between(t1, t2).toMillis());
		LocalDateTime t3 = LocalDateTime.now();
		for (int i=0;i<250000;++i) {
			Listitems.getItem(i);
		}
		LocalDateTime t4 = LocalDateTime.now();
		System.out.println(Duration.between(t3, t4).toMillis());
		Ar_SList myAr_SList = new Ar_SList();
		LocalDateTime t5 = LocalDateTime.now();
		for (int i=0;i<250000;++i) {
			myAr_SList.putItem(i);
		}
		LocalDateTime t6 = LocalDateTime.now();
		System.out.println(Duration.between(t5, t6).toMillis());
		LocalDateTime t7 = LocalDateTime.now();
		for (int i=0;i<250000;++i) {
			myAr_SList.getItem(i);
		}
		LocalDateTime t8 = LocalDateTime.now();
		System.out.println(Duration.between(t7, t8).toMillis());
		
	}
	
}

	
	
	


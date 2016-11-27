import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//default methods

interface Fly {
	default public  void takeOff() {System.out.println("takeoff");}
	default public void turn()  {System.out.println("turn");}
	default public void crusie() {System.out.println("cruise");}
	default public void land() {System.out.println("land");}
}


public class Sample {
	
	public static int totalValues(List<Integer> numbers) {
		
		int total=0;
		for(int e: numbers){
			total+=e;
		}
		
		return total;
	}
	
	public static int totalValues(List<Integer> numbers,Predicate<Integer> selector){
		
		return numbers.stream()
					.filter(selector)
					.reduce(0, (c,e)-> c+e);
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		values.forEach(value -> System.out.println(value));
		
		int total = 0;
		for(int e : values) {
			total += e*2;
		}
		System.out.println(total);
		
		System.out.println(
			values.stream()
			.map(e -> e*2)
			.reduce(0,(c,e) -> c+e)
		);
		
		System.out.println(totalValues(values, e-> true));
		System.out.println(totalValues(values, e-> e%2 ==0 ));
		System.out.println(totalValues(values, e-> e%2 !=0 ));
		
	}

}

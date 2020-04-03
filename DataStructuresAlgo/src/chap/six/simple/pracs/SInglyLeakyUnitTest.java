package chap.six.simple.pracs;

public class SInglyLeakyUnitTest {
	
	public static void main(String[] args) {
		SingleLinkedListLeaky<String> leakyDairy = new SingleLinkedListLeaky<>(10);
		leakyDairy.addFirst("GreenMountainCoffee");
		leakyDairy.addFirst("PatsPeak");
		leakyDairy.addFirst("MoosePlates");
		leakyDairy.addFirst("WhiteMountains");
		leakyDairy.addFirst("StringLovers");
		leakyDairy.addFirst("LakeSwimmers");
		leakyDairy.addFirst("PaddleBoaters");
		leakyDairy.addFirst("FallLeaves");
		leakyDairy.addFirst("HomeBrewers");
		leakyDairy.addFirst("CraftBeerBrewers");
		
		System.out.println("HeaderTailerDetail");
		System.out.println("*******************");
		System.out.println(leakyDairy.getHead());
		System.out.println(leakyDairy.getTail());
		System.out.println("**********************");
		
		//AddOne more to push the last one out
		
		leakyDairy.addFirst("HotAirBaloons");
		
		System.out.println(leakyDairy.getSize());
		System.out.println(leakyDairy.getHead());
		System.out.println(leakyDairy.getTail());
		
		//System.out.println(leakyDairy.removeFirst());
		//System.out.println(leakyDairy.removeFirst());
		//System.out.println(leakyDairy.removeFirst());
		//System.out.println(leakyDairy.removeFirst());
		//System.out.println(leakyDairy.removeFirst());
		//System.out.println(leakyDairy.getSize());
	
		//Test to remove the last element 
		//String lastElement = leakyDairy.removeLast();
//		if (lastElement != null) {
//			System.out.println(lastElement);
//			System.out.println(leakyDairy.getSize());
//		}
//		else {
//			System.out.println("NullComponent");
//		}
		
	}

}

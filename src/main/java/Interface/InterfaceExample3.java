package Interface;

interface Animal{
	void habitate();
	void food();
}
class Lion implements Animal{

	@Override
	public void habitate() {
		System.out.println("Lion lives at land -forest");
		
	}

	@Override
	public void food() {
		System.out.println("He eats non-vegs");
		
	}
	
}
class Whales implements Animal{

	@Override
	public void habitate() {
		System.out.println("Lion lives at Water");
		
	}

	@Override
	public void food() {
		System.out.println("eat fishes");
		
	}
	
}

class InterfaceExample3{
	public static void main(String[] args) {
		Lion l=new Lion();
		l.habitate();
		l.food();
		
		Whales w=new Whales();
		w.habitate();
		w.food();
	}
}

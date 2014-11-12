import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HolaMundo holaMundo = (HolaMundo) context.getBean("holaMundo");
		holaMundo.display();
		
		HolaMundo holaMundo2 = (HolaMundo) context.getBean("holaMundo");
		holaMundo2.display();
		

	}

}

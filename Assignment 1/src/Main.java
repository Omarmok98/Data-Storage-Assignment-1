import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		FileHandler manager = new FileHandler();
		//manager.constructIndexFile();
		int choice;
		Scanner in  =  new Scanner(System.in);
		while(true)
		{
			System.out.println("1-Search product.");
			System.out.println("2-Add product.");
			System.out.println("3-Update product.");
			System.out.println("4-Delete product.");
			System.out.println("5-Get all product.");
			System.out.println("6-Get all indexes");
			System.out.println("7-Exit.");
			choice = in.nextInt();
			if(choice == 1)
			{
				System.out.println("Please enter your product id: ");
				Product.printProduct(manager.searchProduct(in.nextInt()));
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				
	
			}else if(choice == 2)
			{
				Product p = new Product();
				System.out.println("Please enter your product id: ");p.setId(in.nextInt());
				System.out.println("Please enter your product price: ");p.setPrice(in.nextInt());
				System.out.println("Please enter your product quantity: ");p.setQuantity(in.nextInt());
				//Product.printProduct(p);
				manager.addProduct(p);
				//Product.readAllData();
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
			else if(choice == 3)
			{
				System.out.println("Please enter your product id: ");
				manager.searchProduct(in.nextInt());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
			else if(choice == 4)
			{
				System.out.println("Please enter your product id: ");
				manager.searchProduct(in.nextInt());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				
			}else if (choice == 5)
			{
				Product.readAllData();
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}else if(choice == 6)
			{
				Index.readAllIndex();
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
			else if(choice == 7)
			{
				System.out.println("GoodBye!!!");
				break;
			}else
			{
				continue;
			}
			
		}
		in.close();
			
		/*Product.readAllData();
		System.out.println("###########################");
		Index.readAllIndex();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");*/
		/* 
		Product.printProduct(manager.searchProduct(197));
		Product.printProduct(manager.searchProduct(856));
		Product.printProduct(manager.searchProduct(220));
		Product.printProduct(manager.searchProduct(858));
		Product.printProduct(manager.searchProduct(582));
		Product.printProduct(manager.searchProduct(787));
		Product.printProduct(manager.searchProduct(710));
		Product.printProduct(manager.searchProduct(425));
		Product.printProduct(manager.searchProduct(308));
		Product.printProduct(manager.searchProduct(804));
		Product.printProduct(manager.searchProduct(932));
		Product.printProduct(manager.searchProduct(477));
		Product.printProduct(manager.searchProduct(860));
		Product.printProduct(manager.searchProduct(539));
		Product.printProduct(manager.searchProduct(282));
		Product.printProduct(manager.searchProduct(937));
		Product.printProduct(manager.searchProduct(059));
		Product.printProduct(manager.searchProduct(108));
		Product.printProduct(manager.searchProduct(591));
		Product.printProduct(manager.searchProduct(807));
		*/
	}

}

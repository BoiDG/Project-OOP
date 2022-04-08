import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	void cls() {
		for (int i = 0; i < 26; i++) {
			System.out.println();
		}
	}
	
	void menu() {
		System.out.println("SunibResto\r\n"
				+ "====================\r\n"
				+ "1. Insert New Menu\r\n"
				+ "2. View Menu\r\n"
				+ "3. Update Menu\r\n"
				+ "4. Delete Menu\r\n"
				+ "5. Get Order\r\n"
				+ "6. View Order\r\n"
				+ "7. Exit");
	}

	public Main() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		Vector<Menu> menus = new Vector<>();
		Vector<Menu> menuOrder = new Vector<>();
		Customer customer;
		Vector<Order> orders = new Vector<>();
		int pil=0;
		String name="",cat="",type="",top="",size="",id="";
		String det="",tip="",cate="",cek="";
		String gen="";
		int pri=0,quan=0,idx=0;
		int count=0,total=0,co=0;
		count=1;
		
		
		
		do {
			cls();
			menu();
			
			do {
				try {
					System.out.print(">> ");
					pil=scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} while (pil<1||pil>7);
			
			if(pil==1) {
				cls();
				
				if(count<9) {
					id="MN00"+count;
					count++;
				}
				if(count >= 10 && count<=99) {
					id="MN0"+count;
					count++;
				}
				if(count >= 100 && count<=999) {
					id="MN"+count;
					count++;
					if(count==999) {
						count=1;
					}
				}
				
				do {
					System.out.println("Choose Category[Appetizer | MainCourse | Dessert | Drink]: ");
					cat=scan.nextLine();
				} while (!cat.equals("Appetizer") && !cat.equals("MainCourse") &&!cat.equals("Dessert") &&!cat.equals("Drink"));
				
				do {
					System.out.println("Input name [length must be more than 4]: ");
					name=scan.nextLine();
				} while (name.length()<=4);
				
				do {
					System.out.println("Input price [must be more than 1000]: ");
					pri=scan.nextInt();
					scan.nextLine();
				} while (pri<1000);
				
				do {
					System.out.println("Input quantity [must be more than 1]: ");
					quan=scan.nextInt();
					scan.nextLine();
				} while (quan<1);
				
				
				if(cat.equals("Appetizer") || cat.equals("MainCourse")) {
					do {
						System.out.println("Input Type[Normal | Vegan | Halal]: ");
						type=scan.nextLine();
					} while (!type.equals("Normal") && !type.equals("Vegan") &&!type.equals("Halal"));
					
					if(cat.equals("Appetizer")) {
						menus.add(new Appetizer(id, name, pri, quan, type));
					}
					
					if(cat.equals("MainCourse")) {
						menus.add(new MainCourse(id, name, pri, quan, type));
					}
				}
				
				if(cat.equals("Dessert") ) {
					do {
						System.out.println("Input Topping[Strawberry | Chocolate | Vanilla]: ");
						type=scan.nextLine();
					} while (!type.equals("Strawberry") && !type.equals("Chocolate") &&!type.equals("Vanilla"));
					menus.add(new Dessert(id, name, pri, quan, type));
				}
				
				if(cat.equals("Drink") ) {
					do {
						System.out.println("Input Size[Medium | Large]: ");
						type=scan.nextLine();
					} while (!type.equals("Medium") && !type.equals("Large"));
					menus.add(new Drink(id, name, pri, quan, type));
				}
				System.out.println("successfully add menu");
				scan.nextLine();
				scan.nextLine();
			}
			
			if(pil==2) {
				cls();
//				co=0;
				if(menus.isEmpty()) {
					System.out.println("there's no menu");
					scan.nextLine();
					scan.nextLine();
				}
				else {
					for (int i = 0; i < menus.size(); i++) {
						System.out.println((1+i)+".ID : "+menus.get(i).getID()+
								",Name : "+menus.get(i).getName()+
								",Price : "+menus.get(i).getPrice()+
								",Quantity : "+menus.get(i).getQuantity());
					}
					System.out.println("Press Enter To Continue...");
					scan.nextLine();
					scan.nextLine();
					
				}
			}
			
			if(pil==3) {
				cls();
				if(menus.isEmpty()) {
					System.out.println("there's no menu");
					scan.nextLine();
					scan.nextLine();
				}
				else {
					idx=-1;
					for (int i = 0; i < menus.size(); i++) {
						System.out.println((1+i)+".ID : "+menus.get(i).getID()+
								",Name : "+menus.get(i).getName()+
								",Price : "+menus.get(i).getPrice()+
								",Quantity : "+menus.get(i).getQuantity());
					}
					
					do {
						System.out.println("Input menu ID to update : ");
						det=scan.nextLine();
						for (int i = 0; i < menus.size(); i++) {
							if(det.equals(menus.get(i).getID())){
								tip=menus.get(i).toString();
								idx=i;
								break;
							}
						}
					} while (idx==-1);
					
					if(!det.equals("") && !tip.equals("")) {
						do {
							System.out.println("Input name [length must be more than 4]: ");
							name=scan.nextLine();
						} while (name.length()<=4);
						
						do {
							System.out.println("Input price [must be more than 1000]: ");
							pri=scan.nextInt();
							scan.nextLine();
						} while (pri<1000);
						
						do {
							System.out.println("Input quantity [must be more than 1]: ");
							quan=scan.nextInt();
							scan.nextLine();
						} while (quan<1);
						
						
						if(tip.contains("Appetizer") || tip.contains("MainCourse")) {
							do {
								System.out.println("Input Type[Normal | Vegan | Halal]: ");
								type=scan.nextLine();
							} while (!type.equals("Normal") && !type.equals("Vegan") &&!type.equals("Halal"));
							
							if(tip.equals("Appetizer")) {
								menus.get(idx).setName(name);
								menus.get(idx).setPrice(pri);
								menus.get(idx).setQuantity(quan);
							}
							
							if(tip.equals("MainCourse")) {
								menus.get(idx).setName(name);
								menus.get(idx).setPrice(pri);
								menus.get(idx).setQuantity(quan);
							}
						}
						
						if(tip.contains("Dessert") ) {
							do {
								System.out.println("Input Topping[Strawberry | Chocolate | Vanilla]: ");
								type=scan.nextLine();
							} while (!type.equals("Strawberry") && !type.equals("Chocolate") &&!type.equals("Vanilla"));
							menus.get(idx).setName(name);
							menus.get(idx).setPrice(pri);
							menus.get(idx).setQuantity(quan);
						}
						
						if(tip.contains("Drink") ) {
							do {
								System.out.println("Input Size[Medium | Large]: ");
								type=scan.nextLine();
							} while (!type.equals("Medium") && !type.equals("Large"));
							menus.get(idx).setName(name);
							menus.get(idx).setPrice(pri);
							menus.get(idx).setQuantity(quan);
						}
						System.out.println("successfully update menu");
						scan.nextLine();
						scan.nextLine();
					}
				}
			}
			
			if(pil==4) {
				if(menus.isEmpty()) {
					System.out.println("there's no menu");
					scan.nextLine();
					scan.nextLine();
				}
				else {
					idx=-1;
					for (int i = 0; i < menus.size(); i++) {
						System.out.println((1+i)+".ID : "+menus.get(i).getID()+
								",Name : "+menus.get(i).getName()+
								",Price : "+menus.get(i).getPrice()+
								",Quantity : "+menus.get(i).getQuantity());
					}
					
					do {
						System.out.println("Input menu ID to delete : ");
						det=scan.nextLine();
						for (int i = 0; i < menus.size(); i++) {
							if(det.equals(menus.get(i).getID())){
								idx=i;
								break;
							}
						}
					} while (idx==-1);
					
					if(idx!=-1) {
						do {
							System.out.println("Are you sure want to delete[Y/N]");
							cek=scan.nextLine();
						} while (!cek.equals("Y") && !cek.equals("N"));
						
						if(cek.equals("Y")) {
							menus.remove(idx);
							System.out.println("successfully delete menu");
							scan.nextLine();
							scan.nextLine();
						}
						
						
					}
				}
			}
			
			if(pil==5) {
				if(menus.isEmpty()) {
					System.out.println("there's no menu");
					scan.nextLine();
					scan.nextLine();
				}
				else {
					total=0;
					
					
					do {
						System.out.print("Input your name [length must more than 4] : ");
						name=scan.nextLine();
					} while (name.length()<4);
					
					do {
						System.out.print("Input your gender[Male | Female] : ");
						gen=scan.nextLine();
					} while (!gen.equals("Male") && !gen.equals("Female"));
					scan.nextLine();
					scan.nextLine();
					customer = new Customer(name, gen);
					
					for (int i = 0; i < menus.size(); i++) {
						System.out.println((1+i)+".ID : "+menus.get(i).getID()+
								",Name : "+menus.get(i).getName()+
								",Price : "+menus.get(i).getPrice()+
								",Quantity : "+menus.get(i).getQuantity());
					}
					
					do {
						if(det.equals("")) {
							System.out.println("Input menu ID to order['back' to back] : ");
						}
						else {
							System.out.println("Input menu ID to order['order' to order] : ");
						}
						det=scan.nextLine();
						for (int i = 0; i < menus.size(); i++) {
							if(det.equals(menus.get(i).getID())){
								menuOrder.add(new Menu(menus.get(i).getID(),menus.get(i).getName(),menus.get(i).getPrice(),menus.get(i).getQuantity()) {});
							}
						}
					} while (!det.equals("back") && !det.equals("order"));
					
					if(det.equals("order")) {
						System.out.println("here you order");
						for (int i = 0; i < menuOrder.size(); i++) {
							System.out.println("Pesanan ke - "+(i+1)+" : "+menuOrder.get(i).getName()+" "+menuOrder.get(i).getPrice());
							total+=menuOrder.get(i).getPrice();
						}
						System.out.println("total : "+total);
						orders.add(new Order(customer, new Vector<>(), total));
//						for (int i = 0; i < menuOrder.size(); i++) {
//							orders.get(co).getMenuOrdered().add(new Menu(menuOrder.get(i).getID(),menuOrder.get(i).getName(),menuOrder.get(i).getPrice(),menuOrder.get(i).getQuantity()) {});
//						}
						System.out.println("Press Enter To Continue...");
						scan.nextLine();
						scan.nextLine();
					}
				}
				det="";
				co++;
				
			}
			
			if(pil==6) {
				cls();
				if(orders.isEmpty()) {
					System.out.println("you havent order");
					scan.nextLine();
					scan.nextLine();
				}
				else {
					System.out.println("List Order");
					System.out.println("==========================");
					for (int i = 0; i < orders.size(); i++) {
						System.out.println("Customer Name : "+orders.get(i).getCustomer().getName());
						for (int j = 0; j < orders.get(i).getMenuOrdered().size(); j++) {
							System.out.println("order "+(j+1)+" : "+orders.get(i).getMenuOrdered().get(j).getName()+" "+orders.get(i).getMenuOrdered().get(j).getPrice());
						}
						System.out.println("Total : "+orders.get(i).getTotalPrice());
						System.out.println();
					}
					System.out.println("Press Enter To Continue...");
					scan.nextLine();
					scan.nextLine();
				}
				menuOrder.clear();
			}
			
			
			
			
		} while (pil!=7);
		
	}

	public static void main(String[] args) {
		new Main();
	}

}

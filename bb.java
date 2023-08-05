import java.io.*;
import java.util.*;


class node
{
   node next;
   String name;
   String address;
   long ph_no;
   String email_add;
   String city;
   int pincode;
   int pay_method;
   int offer_code;
   double price;
   int veggie_no[]=new int[50];
   int beverage_no[]=new int[50];
   String veggie[]=new String[50];
   String beverage[]=new String[50];
   double veggie_quan[]=new double[50];
   int beverage_quan[]=new int[50];
   double veggie_price[]=new double[50];
   double beverage_price[]=new double[50];
   int order_no=0,items;
   double quantity_veggie_stock[]=new double[20];
   int quantity_beverage_stock[]=new int[20];
   double savings;
}

class node2
{
    node2 left,right;
    String product;
    double quan;
   
}

class bigBasket
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    node front,rear;

    int products[] = new int[50];
    double price_vegies[]=new double[50];
    double price_beverages[]=new double[50];
    double quantity_veggie_stock[]=new double[20];
    int quantity_beverage_stock[]=new int[20];
    String veggie[]=new String[50];
    String bev[]=new String[50];
    int count1,count2;
    int counter,counter1;
    int order_no;
   

    bigBasket()
    {
        front=null;
        rear=null;
        for(int i=1;i<10;i++)
        quantity_veggie_stock[i]=10;
        //it means that every vegetable is 10kg/pc in stock and its global
        for(int i=1;i<10;i++)
        quantity_beverage_stock[i]=10;
    }
   
    void menu()
    {

       System.out.println("\n-----------------------------------------------------------------");
       System.out.print("|\tSr.no"+"\t|\t"+"Vegetables"+"\t|\t"+" Price"+"\t\t|\n");
       System.out.println("-----------------------------------------------------------------");
       System.out.print("|");
       System.out.println("\t1."+"\t|"+"\tPotato(loose)"+"\t|\t"+"Rs.31/kg"+"\t|");
       price_vegies[1]=31;
       veggie[1]="Potato(loose)";
       System.out.print("|");
       System.out.println("\t2."+"\t|"+"\tLadies'Fingers"+"\t|\t"+"Rs.51/kg"+"\t|");
       price_vegies[2]=51;
       veggie[2]="Ladies'Fingers";
       System.out.print("|");
       System.out.println("\t3."+"\t|"+"\tRadish"+"\t\t|\t"+"Rs.35/kg"+"\t|");
       price_vegies[3]=35;
       veggie[3]="Radish         ";
       System.out.print("|");
       System.out.println("\t4."+"\t|"+"\tCapsicum"+"\t|\t"+"Rs.34/kg"+"\t|");
       price_vegies[4]=34;
       veggie[4]="Capsicum       ";
       System.out.print("|");
       System.out.println("\t5."+"\t|"+"\tTomato-Hybrid"+"\t|\t"+"Rs.17.50/kg"+"\t|");
       price_vegies[5]=17.50;
       veggie[5]="Tomato-Hybrid ";
       System.out.print("|");
       System.out.println("\t6."+"\t|"+"\tCarrot"+"\t\t|\t"+"Rs.84/kg"+"\t|");
       price_vegies[6]=84;
       veggie[6]="Carrot       ";
       System.out.print("|");
       System.out.println("\t7."+"\t|"+"\tMushrooms"+"\t|\t"+"Rs.34/kg"+"\t|");
       price_vegies[7]=34;
       veggie[7]="Mushrooms     ";
       System.out.print("|");
       System.out.println("\t8."+"\t|"+"\tBroccoli"+"\t|\t"+"Rs.24.50/pc"+"\t|");
       price_vegies[8]=24.50;
       veggie[8]="Broccoli      ";
       System.out.print("|");
       System.out.println("\t9."+"\t|"+"\tBeetroot"+"\t|\t"+"Rs.41.50/kg"+"\t|");
       price_vegies[9]=41.50;
       veggie[9]="Beetroot      ";
       System.out.print("|");
       System.out.println("\t10."+"\t|"+"\tCabbage"+"\t\t|\t"+"Rs.10.50/pc"+"\t|");
       price_vegies[10]=10.50;
       veggie[10]="Cabbage       ";
       System.out.println("-----------------------------------------------------------------");
       System.out.println("\n-----------------------------------------------------------------------");
       System.out.print("|\tSr.no"+"\t|\t"+"Beverages"+"\t\t\t"+" Price"+"\t\t|\n");
       System.out.println("-----------------------------------------------------------------------");
       System.out.print("\t"+"Soft Drinks\n");
       System.out.println("------------------------------------------------------------------------");
       System.out.print("|");
       System.out.println("\t1."+"\t|"+"\tEnergy Drink(sugar free)"+"|"+"\tRs.125 (250 ml)"+"\t|");
       price_beverages[1]=40;
       bev[1]="Energy Drink(sugar free)";
       System.out.print("|");
       System.out.println("\t2."+"\t|"+"\tGreen Edition Drink"+"\t|\t"+"Rs.125(250 ml)"+"\t|");
       System.out.print("|");
       price_beverages[2]=39.20;
       bev[2]="Green Edition Drink      ";
       System.out.println("\t3."+"\t|"+"\tBeats Enery Drink"+"\t|"+"\tRs.76.50(250 ml)"+"|");
       price_beverages[3]=36.86;
       bev[3]="Beats Enery Drink        ";
       System.out.println("------------------------------------------------------------------------");
       System.out.print("\t"+"Coffee and Tea"+"\t\n");
       System.out.println("-----------------------------------------------------------------");
       System.out.print("|");
       System.out.println("\t4."+"\t|"+"  Instant Coffee (BRU)"+" |\t"+"Rs.300 (200 g)"+"\t|");
       price_beverages[4]=300;
       bev[4]="Instant Coffee (BRU)    ";
       System.out.print("|");
       System.out.println("\t5."+"\t|"+"  Sunrise Rich Aroma"+"   |\t"+"Rs.840 (500 g)"+"\t|");
       System.out.print("|");
       price_beverages[5]=840;
       bev[5]="Sunrise Rich Aroma      ";
       System.out.println("\t6."+"\t|"+"  Premium Leaf Tea"+"\t|\t"+"Rs.461/kg"+"\t|");
       price_beverages[6]=461;
       bev[6]=" Premium Leaf Tea       ";
       System.out.println("-----------------------------------------------------------------");
       
    }

    void offer()
    {
        System.out.println("1).Get RS. 200 OFF with  Credit Card Pyment");
     
        System.out.println("2).Get 15 % OFF with Debit Card Payment");
       
        System.out.println("3).Get RS. 299 OFF on UPI Payment");
    }
   
    void search() throws IOException
    {
    node cur,prev;
    System.out.println("Enter order number  to be searched :");
    int search=Integer.parseInt(br.readLine());
    int flag=0;
   
    if(front==null)
       System.out.println("Sorry , ORDER NOT FOUND !!!");
    else
    {
       cur=front;
    while(cur!=null)
    {
           
    if(cur.order_no==search)
    {
       flag=1;
       int c=0;
       System.out.println("Order Found.................. ");
       System.out.println("ORDER DETAILS ->");
       System.out.println("\n\tOrder number -> "+cur.order_no);
       System.out.println("\n\nName : "+cur.name);
       System.out.println("Email Address : "+cur.email_add);
       System.out.println("Address : "+cur.address);
       System.out.println("Phone Number : "+cur.ph_no);
       System.out.println("City : "+cur.city);
       System.out.println("_________________________________________________________________________________________________________");
       System.out.println("|Sr no \t\tItem\t\t\t\tUnit Cost\t\tQuantity\t\tPrice   |");
       System.out.println("_________________________________________________________________________________________________________");
       for(int i=0;i<cur.items;i++)
       {
           
           if(cur.veggie[i]!=null )
           {
               c++;
           System.out.print("|  "+(c)+"\t\t"+cur.veggie[i]+"\t\t\t"+cur.veggie_price[i]+"\t\t\t"+cur.veggie_quan[i]+"\t\t\t"+cur.veggie_price[i]*cur.veggie_quan[i]+"\t|");
           System.out.println();
           
           }
           if(cur.beverage[i]!=null )
           {
               c++;
           System.out.print("|  "+(c)+"\t\t"+cur.beverage[i]+"\t"+cur.beverage_price[i]+"\t\t\t"+cur.beverage_quan[i]+"\t\t\t"+cur.beverage_price[i]*cur.beverage_quan[i]+"\t|");
           System.out.println();
           }
       }
       System.out.println("_________________________________________________________________________________________________________");

       break;
    }
    cur=cur.next;
    }
    }
    if(flag==0)
        System.out.println("Not Found!!");
    }

    void enque() throws IOException
    {
        //add orders to the queue as they come according to the order
        //name , address details(house no) , phone number(10 digits ),email address,city?district,pincode,(home,office,other)
        //choose payment method(credit,debit,netbanking),offer code
        node ptr,cur;
        int counter=0,counter1=0;
        ptr=new node();
        System.out.println("\n>> Enter details of the customer below -> \n");
        System.out.print("# Name : ");
        String name = br.readLine();
        ptr.name=name;
        System.out.print("# Email : ");
        String email_add = br.readLine();
        ptr.email_add=email_add;
        System.out.print("# Address : ");
        String address = br.readLine();
        ptr.address=address;
        System.out.print("# City/District : ");
        String city = br.readLine();
        ptr.city=city;
        System.out.print("# Pincode : ");
        int pincode = Integer.parseInt(br.readLine());
        ptr.pincode=pincode;
        System.out.print("# Phone Number (10 Digit) : ");
        long no2 = Long.parseLong(br.readLine());
        ptr.ph_no=no2;
        System.out.println("# Enter the order from the menu -> ");
        menu();
        System.out.println(" \tADD Vegetables ?");
        System.out.println("\t1.YES\t2.NO");
        System.out.print("--> ");
        int ans=Integer.parseInt(br.readLine());
        int ch2=1;
        while(ans==1 || ch2==1)
        {
            System.out.print("___________________________________________\n");
            System.out.print("| 1. ADD+ \t2.Beverages\t3.Next\t   |\n");
            System.out.print("|");
            System.out.print("__________________________________________|\n");
            System.out.print("-->  ");
            ch2=Integer.parseInt(br.readLine());
            if(ch2==1)
            {
            System.out.print("Enter The Veggie Number -> ");
            int veggie_no=Integer.parseInt(br.readLine());
            counter++;                                            //counter is count of veggies ordered for one customer
            ptr.items=ptr.items+1;
            ptr.veggie_no[counter]=veggie_no;
            ptr.veggie[counter]=veggie[veggie_no];
            ptr.veggie_price[counter]=price_vegies[veggie_no];
            System.out.print("Enter Quantity (Kg/pc)  -> \n");
            double kg = Double.parseDouble(br.readLine());
            if(quantity_veggie_stock[veggie_no]>=kg)
            {
            this.quantity_veggie_stock[veggie_no]=this.quantity_veggie_stock[veggie_no]-kg;
            ptr.veggie_quan[counter]=kg;
            ptr.price=ptr.price+price_vegies[veggie_no]*kg;
            }
           
            else
            {
                System.out.println("\n\tOpps , Couldn't Add "+ptr.veggie[counter]);
                System.out.println("Because "+ptr.veggie[counter]+" is out of stock");
            }}
            else
             break;
        }
        while(ans==2 || ch2==2)
        {
            System.out.println("1. Next \n2. ADD + : ");
            ch2=Integer.parseInt(br.readLine());
            if(ch2==2)
            {
            System.out.print("Enter The Beverage Number -> ");
            int bev_no=Integer.parseInt(br.readLine());
            counter1++;
            ptr.items++;
            ptr.beverage_no[counter1]=bev_no;                   //counter1 is count of beverages ordered for one customer
            ptr.beverage[counter1]=bev[bev_no];
            ptr.beverage_price[counter1]=price_beverages[bev_no];
            int quan = Integer.parseInt(br.readLine());
            if(quantity_beverage_stock[bev_no]>=quan)
            {
                quantity_beverage_stock[bev_no]-=quan;
                ptr.beverage_quan[counter1]=quan;
                ptr.price=ptr.price+price_beverages[bev_no]*quan;
            }
            else
            {
                System.out.println("Opps , Couldn't Add "+ptr.beverage[counter1]);
                System.out.println("Because "+ptr.beverage[counter1]+" is out of stock");
            }
           
            }
            else
                break;
           
        }
       
        System.out.println("Offers Of The Day -> \n");
        offer();
        System.out.println("Enter payment method of customer-> \n");
        System.out.println("1.Credit card\n2.DEBIT CARD\n3.NETBANKING\n");
        int ch=Integer.parseInt(br.readLine());
        ptr.pay_method=ch;
           
            if(ptr.pay_method==1)
            {
                ptr.price=ptr.price-200;
                ptr.savings=200;
            }
            if(ptr.pay_method==2)
            {
                ptr.price=ptr.price-(ptr.price*0.15);
                ptr.savings=ptr.price*0.15;
            }
            if(ptr.pay_method==3)
            {
                ptr.price=ptr.price-299;
                ptr.savings=299;
            }
       

       
        ptr.next=null;
        System.out.println(ptr.pay_method);
        if(front==null)
        {
            front=ptr;
            rear=ptr;
            //first order added in the list of the shopkeeper , yet to be delievered
            count1++;                   //count1 counts the number of orders
            order_no=order_no+1;
            ptr.order_no=order_no;
            System.out.println("Order number-> "+order_no);
            System.out.println("ORDER PLACED SUCCESSFULLY !!");
        }
        else
        {
            cur=rear;
            cur.next=ptr;
            rear=ptr;
            System.out.println("ORDER PLACED SUCCESSFULLY !!");
            count1++;
            order_no=order_no+1;           //order number of order number of order added sequentially
            ptr.order_no=order_no;
            System.out.println("Order number-> "+order_no);
        }
    }


    void display()
    {
   
        System.out.println("____________________________________________________________________________________");
        if(front==null)
        {
            //it means the queue is empty
            System.out.println("\n\tOpps , NO ORDERS !!");
            System.out.println("\tALL ORDERS ARE DELIVERED ");
        }
        else
        {
            node cur;
            cur=front;
            System.out.println("\nHere Are The List Of Orders in Detail -> \n");

            while(cur!=null)
            {
                int c=0;
                System.out.println("\n\tOrder number -> "+cur.order_no);
                System.out.println("\n\nName : "+cur.name);
                System.out.println("Email Address : "+cur.email_add);
                System.out.println("Address : "+cur.address);
                System.out.println("Phone Number : "+cur.ph_no);
                System.out.println("City : "+cur.city);
                System.out.println("_________________________________________________________________________________________________________");
                System.out.println("|Sr no \t\tItem\t\t\t\tUnit Cost\t\tQuantity\t\tPrice   |");
                System.out.println("_________________________________________________________________________________________________________");
                for(int i=0;i<cur.items;i++)
                {
                   
                    if(cur.veggie[i]!=null )
                    {
                        c++;
                    System.out.print("|  "+(c)+"\t\t"+cur.veggie[i]+"\t\t\t"+cur.veggie_price[i]+"\t\t\t"+cur.veggie_quan[i]+"\t\t\t"+cur.veggie_price[i]*cur.veggie_quan[i]+"\t|");
                    System.out.println();
                   
                    }
                    if(cur.beverage[i]!=null )
                    {
                        c++;
                    System.out.print("|  "+(c)+"\t\t"+cur.beverage[i]+"\t"+cur.beverage_price[i]+"\t\t\t"+cur.beverage_quan[i]+"\t\t\t"+cur.beverage_price[i]*cur.beverage_quan[i]+"\t|");
                    System.out.println();
                    }
                }

                System.out.printf("\nSavings -> Rs "+cur.savings);
                System.out.println();
                cur=cur.next;
                System.out.println("_________________________________________________________________________________________________________");
                //go to next node in queue
               
            }
           
        }
    }
    void deque()
    {
        if(front==null)
        {
            //it means the queue is empty
            System.out.println("Opps , NO ORDERS !!");
            System.out.println("ALL ORDERS ARE DELIVERED ");
        }
        else
        {
            //move front to next order
            node cur=front;
            front=front.next;
            count1--;                    //number of orders yet to be delivered decremented
            System.out.println("Order number "+cur.order_no+" delivered successfully !");
        }  
    }


}
 
class stock extends bigBasket
{
    node2 root;
    String pro;
     //this class has information about the stocks available in the class bigBasket
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     void create_stock()
     {
        //first add all the available quantity stock in binary search tree
        node2 ptr[]=new node2[20];
        for(int i=1;i<20;i++)
        {
         ptr[i]=new node2();
         
        }
        ptr[1].product = "Potato(loose)         ";
        ptr[1].quan=quantity_veggie_stock[1];
        ptr[2].product="Ladies'Fingers          ";
        ptr[2].quan=quantity_veggie_stock[2];
       
        ptr[3].product="Radish                  ";
        ptr[3].quan=quantity_veggie_stock[3];
       
        ptr[4].product="Capsicum                 ";
        ptr[4].quan=quantity_veggie_stock[4];
       
        ptr[5].product="Tomato-Hybrid            ";
        ptr[5].quan=quantity_veggie_stock[5];
       
        ptr[6].product="Carrot                   ";
        ptr[6].quan=quantity_veggie_stock[6];
       
        ptr[7].product="Mushrooms                ";
        ptr[7].quan=quantity_veggie_stock[7];
       
        ptr[8].product="Broccoli                 ";
        ptr[8].quan=quantity_veggie_stock[8];
     
        ptr[9].product="Beetroot                 ";
        ptr[9].quan=quantity_veggie_stock[9];
     
        ptr[10].product="Cabbage                 ";
        ptr[10].quan=quantity_veggie_stock[10];
       
        ptr[11].product="Energy Drink(sugar free)";
        ptr[11].quan=quantity_beverage_stock[1];
       
        ptr[12].product="Green Edition Drink     ";
        ptr[12].quan=quantity_beverage_stock[2];
       
        ptr[13].product="Beats Enery Drink       ";
        ptr[13].quan=quantity_beverage_stock[3];
       
        ptr[14].product="Instant Coffee (BRU)    ";
        ptr[14].quan=quantity_beverage_stock[4];
       
        ptr[15].product="Sunrise Rich Aroma      ";
        ptr[15].quan=quantity_beverage_stock[5];
       
        ptr[16].product=" Premium Leaf Tea       ";
       
        ptr[16].quan=quantity_beverage_stock[6];
       
       
       
        for(int i=1;i<16;i++)
        {
        ptr[i].left=null;
        ptr[i].right=null;
        }
       
        for(int i=1;i<17;i++)
        {
            if(root==null)
             root=ptr[i];
            else
            {
                node2 prev,curr;
                prev=null;
                curr=root;
               
                while(curr!=null && curr.product.compareToIgnoreCase(ptr[i].product)!=0)
                {
               
                    prev=curr;
                     if(prev.product.compareToIgnoreCase(ptr[i].product)>0)
                      curr=curr.left;
                     else
                      curr=curr.right;
                    //cur is the place where node2 is to be added
                }
               
                if((prev.product).compareToIgnoreCase(ptr[i].product)>0)
                {
                  prev.left=ptr[i];
                }
               
                else
                  prev.right=ptr[i];
            }
        }
     }
 
     void display_stock()
     {
        //display stock
        node2 arr[]=new node2[50];
        for(int i=0;i<50;i++)
        arr[i]=new node2();
        int top=-1;
        System.out.println(">> STOCK DETAILS -> \n");
        if(root==null)
         System.out.println("YOUR STOCK IS EMPTY !!!");
       
        else
        {
            node2 cur;
            cur=root;
            //inorder traversal of bst ->
            System.out.println("______________________________________________________");
            System.out.println("|  Product"+"\t\t\t"+"Quantity(kg/pc)  |");
            System.out.println("______________________________________________________");
            do
            {
            while(cur!=null )
            {
                top++;
                arr[top]=cur;
                cur=cur.left;
            }
            if(top!=-1)
            {
                cur=arr[top];
                top--;
                System.out.println("|  "+cur.product+"\t\t"+cur.quan+"\t|");
                cur=cur.right;
            }
            }while(cur!=null || top!=-1);
            System.out.println("______________________________________________________");
        }
     }
   
     
     void search_stock() throws IOException
     {
    System.out.println("Enter the Name Of The Product To be searched  -> ");
    String pro=br.readLine();
    node2 cur,prev;
    if(root==null)
    System.out.println("Stock is empty..........");
    else
    {
    prev=null;
    cur=root;
    while(cur!=null && pro.compareToIgnoreCase(cur.product.trim())!=0)
    {
    prev=cur;
    if((prev.product.trim()).compareToIgnoreCase(pro)>0)
    cur=cur.left;
    else
    cur=cur.right;
    }

    if(cur==null)
    System.out.println("PRODUCT NOT FOUND !!!");
    else
    {
    System.out.println("PRODUCT FOUND...........");
    System.out.println("______________________________________________________");
         System.out.println("|  Product"+"\t\t\t"+"Quantity(kg/pc)  |");
         System.out.println("______________________________________________________");
    System.out.println(cur.product + " = "+cur.quan +"\n");
    System.out.println("______________________________________________________");
    }
    }
   
     }
     
     void update() throws IOException
     {
    System.out.println("Enter the Name Of The Product To be searched  -> ");
    String pro=br.readLine();
    node2 cur,prev;
    if(root==null)
    System.out.println("Stock is empty..........");
    else
    {
    prev=null;
    cur=root;
    while(cur!=null && pro.compareToIgnoreCase(cur.product.trim())!=0)
    {
    prev=cur;
    if((prev.product.trim()).compareToIgnoreCase(pro)>0)
    cur=cur.left;
    else
    cur=cur.right;
    }

    if(cur==null)
    System.out.println("PRODUCT NOT FOUND !!!");
    else
    {
    System.out.println("PRODUCT FOUND...........");
    System.out.println("______________________________________________________");
         System.out.println("|  Product"+"\t\t\t"+"Quantity(kg/pc)  |");
         System.out.println("______________________________________________________");
    System.out.println(cur.product + " = "+cur.quan +"\n");
    System.out.println("______________________________________________________");
    System.out.println("Enter New Quantity -> ");
    double quan=Double.parseDouble(br.readLine());
    cur.quan=quan;
    if(pro.equals("Potato(loose)"))
    quantity_veggie_stock[1]=quantity_veggie_stock[1]+quan;
    if(pro.equals("Ladies'Fingers"))
    quantity_veggie_stock[2]=quantity_veggie_stock[2]+quan;
    if(pro.equals("Radish"))
    quantity_veggie_stock[3]=quantity_veggie_stock[3]+quan;
    if(pro.equals("Capsicum"))
    quantity_veggie_stock[4]=quantity_veggie_stock[4]+quan;
    if(pro.equals("Tomato-Hybrid"))
    quantity_veggie_stock[5]=quantity_veggie_stock[5]+quan;
    if(pro.equals("Carrot"))
    quantity_veggie_stock[6]=quantity_veggie_stock[6]+quan;
    if(pro.equals("Mushrooms"))
    quantity_veggie_stock[7]=quantity_veggie_stock[7]+quan;
    if(pro.equals("Broccoli"))
    quantity_veggie_stock[8]=quantity_veggie_stock[8]+quan;
    if(pro.equals("Beetroot"))
    quantity_veggie_stock[9]=quantity_veggie_stock[9]+quan;
    if(pro.equals("Cabbage"))
    quantity_veggie_stock[10]=quantity_veggie_stock[10]+quan;
    if(pro.equals("Energy Drink(sugar free)"))
    quantity_beverage_stock[1]=quantity_beverage_stock[1]+(int)quan;
    if(pro.equals("Green Edition Drink "))
    quantity_beverage_stock[2]=quantity_beverage_stock[2]+(int)quan;
    if(pro.equals("Beats Enery Drink"))
    quantity_beverage_stock[3]=quantity_beverage_stock[3]+(int)quan;
    if(pro.equals("Instant Coffee (BRU)"))
    quantity_beverage_stock[4]=quantity_beverage_stock[4]+(int)quan;
    if(pro.equals("Sunrise Rich Aroma"))
    quantity_beverage_stock[5]=quantity_beverage_stock[5]+(int)quan;
    if(pro.equals("Premium Leaf Tea"))
    quantity_beverage_stock[6]=quantity_beverage_stock[6]+(int)quan;
   
   
    System.out.println("Stock Details Updated Successfully -> ");
    }
    }
     }
     
     }
     
     


class bb
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the password -> ");
        int password=Integer.parseInt(br.readLine());
        int ch,ch2;
        if(password==12345)
        {
            stock obj = new stock();
            obj.create_stock();
            do
            {
            System.out.println("   _______________\t   _______________         __________________\t    ____________________________\t   _____________________");

           

            System.out.println("  |               |\t  |               |\t  |                  |\t   |               \t\t|\t  |                     |");



            System.out.println("1.| MANAGE ORDERS |\t2.| DISPLAY STOCK |\t3.|SEARCH A PRODUCT  |\t 4.| UPDATE PRODUCT QUANTITY    |\t5.|\t EXIT\t\t|");



            System.out.println("  |_______________|\t  |_______________|       |__________________|\t   |____________________________|\t  |_____________________|");
           
            System.out.println("Enter your choice -> ");
            ch=Integer.parseInt(br.readLine());
           
            switch(ch)
            {
            case 1:
            System.out.println("1.PLACE ORDER\n2.DISPLAY ALL ORDERS\n3.DELIVER AN ORDER\n4.SEARCH FOR A ORDER\n5.EXIT\n");
            System.out.println("Enter your choice -> ");
                ch2=Integer.parseInt(br.readLine());
                switch(ch2)
                {
                case 1:
                obj.enque();
                break;
                case 2:
                obj.display();
                break;
                case 3:
                obj.deque();
                break;
                case 4:
                obj.search();
                break;
                case 5:
                break;
               
                }
                break;
               
            case 2:
            obj.display_stock();
            break;
           
            case 3:
            obj.search_stock();
            break;
           
            case 4:
            obj.update();
                break;
               
            case 5:
            System.out.println("THANK YOU ...............................................");
            break;
            }
            }while(ch!=5);
           
        }
        else
        {
            System.out.println("Wrong password !! Try Again ");
            main(null);
        }
    }
}


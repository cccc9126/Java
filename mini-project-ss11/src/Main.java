public class Main{
    static void main(String[] args) {
        Drink[] drinks=new Drink[3];
        drinks[0]=new Coffee(0,"Bạc xỉu",30000,true);
        drinks[1]=new FruitJuice(1,"Nước cam",40000,10);
        drinks[2]=null;
        for(int i=0;i<drinks.length;i++){
            if(drinks[i]!=null){
                drinks[i].displayInfo();
                System.out.println("Thành tiền: "+drinks[i].calculatePrice());
                if(drinks[i] instanceof FruitJuice){
                    ((FruitJuice) drinks[i]).mix();
                }
                System.out.println("==========================");
            }

        }
    }
}
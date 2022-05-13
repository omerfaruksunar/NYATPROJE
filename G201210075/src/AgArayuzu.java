import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu{
    private IEyleyici eyleyici ;
    private ISicaklikAlgilayici SicaklikAlgilayici;

    public AgArayuzu(IEyleyici eyleyici ,ISicaklikAlgilayici SicaklikAlgilayici ){
        this.eyleyici = eyleyici;
        this.SicaklikAlgilayici = SicaklikAlgilayici;
    }

    public void mesajYazdir(String mesaj) {

        System.out.println(mesaj);
    }

    public void sicaklikGonder(int sicaklik){

        System.out.println(sicaklik);
    }

    public String veriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }
}

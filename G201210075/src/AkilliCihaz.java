public class AkilliCihaz {
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IAgArayuzu agArayuzu;
    private VeriTabani veriTabani;
    private Publisher publisher;

    private static final String SOGUTUCU_AC = "1";
    private static final String SOGUTUCU_KAPAT = "2";
    private static final String SICAKLIK_GORUNTULE = "3";
    private static final String CIKIS = "4";



    public AkilliCihaz(){
        veriTabani = new VeriTabani();
        eyleyici =new Eyleyici();
        sicaklikAlgilayici =new SicaklikAlgilayici();
        agArayuzu= new AgArayuzu(eyleyici , sicaklikAlgilayici);
        publisher = new Publisher();
    }


    public void basla(){
        agArayuzu.mesajYazdir("*** Akilli Cihaz Yoneticisine Hos Geldiniz ***");
        User kullanici ;
        do {
            agArayuzu.mesajYazdir("Kullanici Adi: ");
            String userName = agArayuzu.veriAl();
            agArayuzu.mesajYazdir("Sifre        : ");
            String password = agArayuzu.veriAl();
            kullanici = new User(userName, password);


            if (kullanici.isKontrol()) {
                agArayuzu.mesajYazdir("***Giris Islemi Basarili***");
            }
            else {
                agArayuzu.mesajYazdir("Girdiginiz Kullanici Adi Veya Sifre Yanlis!!! Lutfen Tekrar Deneyiniz.");
            }
        }while (!kullanici.isKontrol());

        publisher.attach(kullanici);

        publisher.notify(kullanici+"Giris yapildi.");

        islemSec();

    }

    private void islemSec(){
        String secim;
        do {
            secim = anaMenuyuGoster();

            switch (secim){
                case SOGUTUCU_AC :
                    agArayuzu.mesajYazdir(eyleyici.SogutucuAc());
                    break;
                case SOGUTUCU_KAPAT:
                    agArayuzu.mesajYazdir(eyleyici.SogutucuKapat());
                    break;
                case SICAKLIK_GORUNTULE:
                    agArayuzu.sicaklikGonder(sicaklikAlgilayici.sicaklikGonder());
                    int SicaklikDegeri=sicaklikAlgilayici.sicaklikGonder();
                    if(SicaklikDegeri>40){
                        publisher.notify("Yuksek Sicaklik!!!");
                    }
                    else if(SicaklikDegeri<10){
                        publisher.notify("Dusuk Sicaklik!!!");
                    }
                    break;
                case CIKIS:
                    agArayuzu.mesajYazdir("   ***Cikis Yapiliyor***   ");
                    agArayuzu.mesajYazdir("***Cikis Islemi Basarili***");
                    break;
                default:
                    agArayuzu.mesajYazdir("Yanlis Bir Islem Sectiniz, Lutfen Tekrar Deneyiniz.");
                    break;
            }
        }while(!secim.equals(CIKIS));
    }

    private String anaMenuyuGoster(){
        agArayuzu.mesajYazdir("__________________________________");
        agArayuzu.mesajYazdir("************ Ana Menu ************");
        agArayuzu.mesajYazdir("1) Sogutucu Ac ");
        agArayuzu.mesajYazdir("2) Sogutucu Kapat");
        agArayuzu.mesajYazdir("3) Sicaklik Goster");
        agArayuzu.mesajYazdir("4) Cikis Yap ");
        agArayuzu.mesajYazdir("Lutfen Yapmak Istediginiz Islemi Seciniz : ");
        return agArayuzu.veriAl();
    }

}

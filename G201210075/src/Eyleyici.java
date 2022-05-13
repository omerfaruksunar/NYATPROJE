public class Eyleyici implements IEyleyici{
    private String sogutucuDurumu ;

    Eyleyici(){
        sogutucuDurumu = "Kapali";
    }

    public void islemYap(){
        SogutucuAc();
        SogutucuKapat();
    }

    public String SogutucuAc(){
        if (sogutucuDurumu == "Kapali")
        {
            durumuGuncelle("Acik");
            return "Sogutucunuz Aciliyor... \n Sogutucu Acma Islemi Basarili." ;
        }
        else
        {
            return "Sogutucunuz Zaten Acik!!!";
        }
    }

    public String SogutucuKapat(){
        if(sogutucuDurumu == "Acik")
        {
            durumuGuncelle("Kapali");
            return "Sogutucunuz Kapatiliyor...\n Sogutucu Kapatma Islemi Basarili. " ;
        }
        else
        {
            return "Sogutucunuz Zaten Kapali!!!";
        }
    }

    private void durumuGuncelle(String durum)
    {
        this.sogutucuDurumu = durum;
    }
}

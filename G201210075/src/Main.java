public class Main {
    public static void main(String[] args)
    {
        try {
            Tarih tarih = (Tarih) TarihFactory.createComputer(Tarih.class);
            tarih.since(2022);
            tarih.name();

            GuncellemeTarihi guncellemeTarihi = (GuncellemeTarihi) TarihFactory.createComputer(GuncellemeTarihi.class);
            guncellemeTarihi.name();

        } catch (Exception e) {
            e.printStackTrace();
        }
        AkilliCihaz akilliCihaz=new AkilliCihaz();
        akilliCihaz.basla();
    }
}
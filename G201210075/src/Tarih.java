public class Tarih implements ITarih {

        @Override
        public void name() {
            System.out.println("Yetkili Adi:");
        }
        @Override
        public void since(int year) {
            System.out.println(year + " tarihinde yapildi.");
        }

    }


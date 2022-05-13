public class GuncellemeTarihi implements ITarih{

        @Override
        public void name() {

            System.out.println("Omer Faruk SUNAR");
            System.out.println("---------------------------------------");
        }


        @Override
        public void since(int year) {
            System.out.println(year + " tarihinde guncellendi");
        }

    }


public class TarihFactory {

        public static ITarih createComputer(Class aClass) throws IllegalAccessException, InstantiationException {
            return (ITarih) aClass.newInstance();
        }
    }

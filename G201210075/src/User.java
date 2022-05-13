public class User implements IObserver{
    private String UserName;
    private String Password;
    private boolean Kontrol;
    private VeriTabani veritabani;

    User(String UserName , String Password){
        this.UserName = UserName;
        this.Password = Password;
        this.Kontrol = Login(this.UserName,this.Password);
    }

    private boolean Login(String UserName , String Password){
        Boolean kontrol =true;
        VeriTabani data = new VeriTabani();
        kontrol = data.login(UserName,Password);
        return kontrol;
    }

    public boolean isKontrol() {
        return Kontrol;
    }

    @Override
    public void update(String mesaj) {
        System.out.println("Kullanicimiza gelen mesaj->" + mesaj);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Validator.check("login", "Pass", "Pass");
            System.out.println("Вы успешно зарегистрировались");
        } catch (WrongLoginException | WrongPasswordException e){
            throw new RuntimeException(e);
        }
    }
}
public class Validator {
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnm_";

    public static void check(String login, String password, String confirmPassword){
        if (login.length() > 20) {
            throw new WrongLoginException("Логин содержит более 20 символов");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль содержит более 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не равны!");
        }
        if (checkAlphabet(login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы!");
        }
        if (checkAlphabet(password)) {
            throw new WrongPasswordException("Логин содержит недопустимые символы!");
        }
    }

    private static boolean checkAlphabet(String str) {
        var lowercase = str.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            var c = lowercase.charAt(i);
            if (!ALLOWED_CHARS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}

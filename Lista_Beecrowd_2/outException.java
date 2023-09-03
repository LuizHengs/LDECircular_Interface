package Lista_Beecrowd_2;

import java.lang.Exception;
class outException extends Exception{

    private String code;

    public outException (String code, String message) {
        super(message);
        this.setCode(code);
    }

    public outException (String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package br.com.criptografia;

public class CriptografiaCesariana implements Criptografia{

    private final int ASCII_LOWERCASE_Z = 122;
    private final int ASCII_LOWERCASE_A = 97;
    private static int codigoAscii;

    @Override
    public String criptografar(String texto) throws IllegalArgumentException, NullPointerException{
        return criptografaDescriptografa(texto, 3);
    }

    @Override
    public String descriptografar(String texto) throws IllegalArgumentException, NullPointerException {
        return criptografaDescriptografa(texto, -3);
    }

    private String criptografaDescriptografa(String texto, int valor){
        try {
            validarTexto(texto);
            char[] letras = texto.toLowerCase().toCharArray();
            String resp = "";
            for(char letra: letras){
                if (!podeCripografarDescriptografar(letra)){
                    setNovoCodigoAscii(letra, valor);
                    letra = (char) (getNovoCodigoAscii());
                }
                resp = resp.concat(letra+"");
            }
            return resp;
        } catch (Exception e){
            throw e;
        }
    }

    private void validarTexto(String texto) throws IllegalArgumentException, NullPointerException{
        if(texto.isEmpty()){
            throw new IllegalArgumentException("O texto está vazio!");
        }
        if(texto == null){
            throw new NullPointerException("O texto é nulo!");
        }
    }

    private boolean podeCripografarDescriptografar(char letra){
        return Character.isDigit(letra) || Character.isSpaceChar(letra);
    }

    private void setNovoCodigoAscii(char letra, int valor){
        this.codigoAscii = (int) letra + valor;
        if (valor > 0){
            codigoAscii =  codigoAscii > ASCII_LOWERCASE_Z ? (codigoAscii - ASCII_LOWERCASE_Z) + (ASCII_LOWERCASE_Z -1) : codigoAscii;
        } else {
            codigoAscii =  codigoAscii < ASCII_LOWERCASE_A ? (ASCII_LOWERCASE_Z + 1) - (ASCII_LOWERCASE_A - codigoAscii) : codigoAscii;
        }
    }

    private int getNovoCodigoAscii(){
        return this.codigoAscii;
    }

}
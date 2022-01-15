package br.com.fcsilva.organizzeclone.config;


import com.google.firebase.auth.FirebaseAuth;

public class ConfigFirebase {
    // CLASSE QUE RECUPERA A INSTÂNCIA DO FIREBASE

    private static FirebaseAuth autenticacao;

    // retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAuth(){
        if(autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }
}

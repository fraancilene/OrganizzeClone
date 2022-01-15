package br.com.fcsilva.organizzeclone.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.fcsilva.organizzeclone.R;
import br.com.fcsilva.organizzeclone.config.ConfigFirebase;
import br.com.fcsilva.organizzeclone.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;

    // atributos de autenticação
    private FirebaseAuth autenticacao;

    // atributos de usuário
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // recuperando o que o usuário digitou nos campos
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();


                // verificando se o usuário preencheu os campos
                if( !textoNome.isEmpty()){ // verificando se o texto nome não está vazio
                    if ( !textoEmail.isEmpty()){
                        if (!textoSenha.isEmpty()){

                            usuario = new Usuario();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);

                            // método de cadastro de usuário
                            cadastrarUsuario();

                        } else {
                            Toast.makeText(CadastroActivity.this,
                                    "Preencha a senha!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(CadastroActivity.this,
                                "Preencha o email!", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(CadastroActivity.this,
                            "Preencha o nome!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // código de cadastro de usuário
    public void cadastrarUsuario(){
        autenticacao = ConfigFirebase.getFirebaseAuth();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // verificando se o cadastro deu certo
               if (task.isSuccessful()){
                   Toast.makeText(CadastroActivity.this,
                           "Sucesso ao cadastrar o usuário!", Toast.LENGTH_SHORT).show();

               } else {

                   Toast.makeText(CadastroActivity.this,
                           "Erro ao cadastrar o usuário!", Toast.LENGTH_SHORT).show();
               }

            }
        });


    }
}
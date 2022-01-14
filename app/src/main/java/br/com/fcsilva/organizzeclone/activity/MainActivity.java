package br.com.fcsilva.organizzeclone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.fcsilva.organizzeclone.R;


public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // removendo os botões
        setButtonBackVisible(false);
        setButtonNextVisible(false);


        // adicionando os fragments
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_4)
                //.canGoBackward(false) // impedindo que volte depois da ultima tela
                //.canGoBackward(false) // impedindo que avance
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                //.canGoBackward(false) // impedindo que volte depois da ultima tela
                .canGoBackward(false) // impedindo que avance
                .build()
        );
    }

    // metodo para cadastrar usuário
    public void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));

    }

    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));

    }


}
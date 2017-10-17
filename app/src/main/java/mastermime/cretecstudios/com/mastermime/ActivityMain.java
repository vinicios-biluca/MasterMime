package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class ActivityMain extends AppCompatActivity {


    Button play, words, info, quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findMyViews();

        if (isEmpty()) {

            loadSet();

        }


    }

    public void findMyViews() {

        //Fonte customizada
        Typeface myFont = Typeface.createFromAsset(getAssets(), "myfont.otf");

        play = (Button) findViewById(R.id.bt_main_play);
        play.setTypeface(myFont);
        words = (Button) findViewById(R.id.bt_main_words);
        words.setTypeface(myFont);
        info = (Button) findViewById(R.id.bt_main_info);
        info.setTypeface(myFont);
        quit = (Button) findViewById(R.id.bt_main_quit);
        quit.setTypeface(myFont);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showGameActivity();

            }
        });

        words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActivityWords();

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActivityInfo();

            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quitApplication();

            }
        });
    }

    public void showGameActivity() {

        Intent i = new Intent(ActivityMain.this, ActivityNewMatch.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Abre a Tela de Palavras
    public void showActivityWords() {

        Intent i = new Intent(ActivityMain.this, ActivityWords.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Abre a Tela de Informações
    public void showActivityInfo() {

        Intent i = new Intent(ActivityMain.this, ActivityInfo.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Fecha o Aplicativo
    public void quitApplication() {

        ActivityMain.this.finish();

    }

    public boolean isEmpty() {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        List<ObjectWord> words = daoSession.getObjectWordDao().loadAll();

        if (words.size() > 0) {
            return false;
        } else {
            return true;
        }

    }

    public void loadSet() {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        //daoSession.getObjectWordDao().deleteAll();

        if (daoSession.getObjectWordDao().loadAll().size() < 1) {

            insertWord("A BELA E A FERA ", "...", "FILMES e SÉRIES");
            insertWord("ABACAXI", "...", "COMIDAS");
            insertWord("ABAJUR", "...", "OBJETOS");
            insertWord("ABELHA ", "...", "ANIMAIS");
            insertWord("ABRAÇAR", "...", "AÇÃO");
            insertWord("ABSORVENTE", "...", "OBJETOS");
            insertWord("ACADEMIA", "...", "LUGARES");
            insertWord("ACELERAR", "...", "AÇÃO");
            insertWord("ACERTAR", "...", "AÇÃO");
            insertWord("ACHAR", "...", "AÇÃO");
            insertWord("ÁCIDO", "...", "DIVERSOS");
            insertWord("ACONTECER", "...", "DIVERSOS");
            insertWord("ADEUS", "...", "DIVERSOS");
            insertWord("ADICIONAR", "...", "AÇÃO");
            insertWord("ADQUIRIR", "...", "AÇÃO");
            insertWord("AFASTAR", "...", "AÇÃO");
            insertWord("AFEGANISTÃO", "...", "LUGARES");
            insertWord("ÁFRICA", "...", "LUGARES");
            insertWord("AGIR", "...", "AÇÃO");
            insertWord("AGRADECER", "...", "AÇÃO");
            insertWord("AGRONOMIA", "...", "DIVERSOS");
            insertWord("AGUARDAR", "...", "AÇÃO");
            insertWord("ÁGUIA", "...", "ANIMAIS");
            insertWord("AGULHA", "...", "OBJETOS");
            insertWord("AJUDAR", "...", "AÇÃO");
            insertWord("AJUSTAR", "...", "AÇÃO");
            insertWord("ALCE ", "...", "ANIMAIS");
            insertWord("ALDEIA", "...", "LUGARES");
            insertWord("ALEMANHA", "...", "LUGARES");
            insertWord("ALFINETE", "...", "OBJETOS");
            insertWord("ALGORITMO", "...", "DIVERSOS");
            insertWord("ALGUÉM", "...", "PESSOAS");
            insertWord("ALIEN", "...", "DIVERSOS");
            insertWord("ALIMENTAR", "...", "AÇÃO");
            insertWord("ALISAR", "...", "AÇÃO");
            insertWord("ALMOÇAR", "...", "AÇÃO");
            insertWord("ALMOFADA", "...", "OBJETOS");
            insertWord("AMAR", "...", "AÇÃO");
            insertWord("AMEIXA", "...", "COMIDAS");
            insertWord("AMÉRICA CENTRAL", "...", "LUGARES");
            insertWord("AMÉRICA DO NORTE", "...", "LUGARES");
            insertWord("AMÉRICA DO SUL", "...", "LUGARES");
            insertWord("AMIGO", "...", "PESSOAS");
            insertWord("AMOSTRA", "...", "DIVERSOS");
            insertWord("ANÃO", "...", "PESSOAS");
            insertWord("ANDADOR", "...", "OBJETOS");
            insertWord("ANEL", "...", "OBJETOS");
            insertWord("ANGELINA JOLIE", "...", "PESSOAS");
            insertWord("ANTA ", "...", "ANIMAIS");
            insertWord("ANTARTICA", "...", "LUGARES");
            insertWord("ANTARTIDA", "...", "LUGARES");
            insertWord("ANTEONTEM", "...", "DIVERSOS");
            insertWord("ANZOL", "...", "OBJETOS");
            insertWord("APAGAR", "...", "AÇÃO");
            insertWord("APALPAR", "...", "AÇÃO");
            insertWord("APONTADOR", "...", "OBJETOS");
            insertWord("APOSENTADO", "...", "PESSOAS");
            insertWord("APRENDER", "...", "AÇÃO");
            insertWord("APRESENTAÇÃO", "...", "DIVERSOS");
            insertWord("APRESENTAR", "...", "AÇÃO");
            insertWord("ARAGORN", "...", "PESSOAS");
            insertWord("ARANHA", "...", "ANIMAIS");
            insertWord("ARARA ", "...", "ANIMAIS");
            insertWord("ARGENTINA", "...", "LUGARES");
            insertWord("ARMADILHA", "...", "OBJETOS");
            insertWord("ARMÁRIO", "...", "OBJETOS");
            insertWord("ARRANHA CÉU", "...", "LUGARES");
            insertWord("ARROZ", "...", "COMIDAS");
            insertWord("ÁRVORE", "...", "DIVERSOS");
            insertWord("ÁSIA", "...", "LUGARES");
            insertWord("ASMA", "...", "DIVERSOS");
            insertWord("ASSALTO", "...", "DIVERSOS");
            insertWord("ASSISTIR", "...", "AÇÃO");
            insertWord("ASTERÓIDE", "...", "DIVERSOS");
            insertWord("ASTRONAUTA", "...", "PESSOAS");
            insertWord("ATENDER", "...", "AÇÃO");
            insertWord("ATRÁS", "...", "DIVERSOS");
            insertWord("AVALIAÇÃO", "...", "DIVERSOS");
            insertWord("AVATAR ", "...", "DIVERSOS");
            insertWord("AVESTRUZ", "...", "ANIMAIS");
            insertWord("AVESTRUZ ", "...", "ANIMAIS");
            insertWord("AVISAR", "...", "AÇÃO");
            insertWord("BALÃO", "...", "OBJETOS");
            insertWord("BALEIA", "...", "ANIMAIS");
            insertWord("BANDA", "...", "DIVERSOS");
            insertWord("BAR", "...", "LUGARES");
            insertWord("BARACK OBAMA", "...", "PESSOAS");
            insertWord("BARATA", "...", "ANIMAIS");
            insertWord("BARATA ", "...", "ANIMAIS");
            insertWord("BATATA", "...", "COMIDAS");
            insertWord("BATER", "...", "AÇÃO");
            insertWord("BATMAN – O CAVALEIRO DAS TREVAS ", "...", "FILMES e SÉRIES");
            insertWord("BEBER", "...", "AÇÃO");
            insertWord("BEIJAR", "...", "AÇÃO");
            insertWord("BEXIGA", "...", "OBJETOS");
            insertWord("BOLA", "...", "OBJETOS");
            insertWord("BOMBEIRO", "...", "PESSOAS");
            insertWord("BONITA", "...", "PESSOAS");
            insertWord("BORBOLETA ", "...", "ANIMAIS");
            insertWord("BORRACHA ESCOLAR", "...", "OBJETOS");
            insertWord("BOTAS", "...", "OBJETOS");
            insertWord("BRAÇO", "...", "DIVERSOS");
            insertWord("BRASIL", "...", "LUGARES");
            insertWord("BRASÍLIA", "...", "LUGARES");
            insertWord("BRINCAR", "...", "AÇÃO");
            insertWord("BÚFALO ", "...", "ANIMAIS");
            insertWord("BUSCAR", "...", "AÇÃO");
            insertWord("CABRA ", "...", "ANIMAIS");
            insertWord("CAFÉ", "...", "DIVERSOS");
            insertWord("CAIR", "...", "AÇÃO");
            insertWord("CALÇA", "...", "OBJETOS");
            insertWord("CALMO", "...", "PESSOAS");
            insertWord("CAMALEÃO ", "...", "ANIMAIS");
            insertWord("CAMELO ", "...", "ANIMAIS");
            insertWord("CAMINHAR", "...", "AÇÃO");
            insertWord("CAMISA", "...", "OBJETOS");
            insertWord("CAMISETA", "...", "OBJETOS");
            insertWord("CANADÁ", "...", "LUGARES");
            insertWord("CANCELAR", "...", "AÇÃO");
            insertWord("CANETA", "...", "OBJETOS");
            insertWord("CANTAR", "...", "AÇÃO");
            insertWord("CÃO ", "...", "ANIMAIS");
            insertWord("CAPIVARA ", "...", "ANIMAIS");
            insertWord("CARANGUEJO", "...", "ANIMAIS");
            insertWord("CARIMBO", "...", "OBJETOS");
            insertWord("CASTIÇAL", "...", "OBJETOS");
            insertWord("CASTOR ", "...", "ANIMAIS");
            insertWord("CAVALO ", "...", "ANIMAIS");
            insertWord("CD", "...", "OBJETOS");
            insertWord("CHAMAR", "...", "AÇÃO");
            insertWord("CHEGAR", "...", "AÇÃO");
            insertWord("CHEIROSO", "...", "PESSOAS");
            insertWord("CHIMARRÃO", "...", "DIVERSOS");
            insertWord("CHORAR", "...", "AÇÃO");
            insertWord("CHURRASCO", "...", "COMIDAS");
            insertWord("CICLISTA", "...", "PESSOAS");
            insertWord("CINEMA", "...", "DIVERSOS");
            insertWord("CINQUENTA", "...", "DIVERSOS");
            insertWord("CISNE ", "...", "ANIMAIS");
            insertWord("CLAUDIA LEITE", "...", "PESSOAS");
            insertWord("COALA ", "...", "ANIMAIS");
            insertWord("COBRA", "...", "ANIMAIS");
            insertWord("COÇAR", "...", "AÇÃO");
            insertWord("COELHO ", "...", "ANIMAIS");
            insertWord("COISA", "...", "DIVERSOS");
            insertWord("COLHER", "...", "OBJETOS");
            insertWord("COLOCAR", "...", "AÇÃO");
            insertWord("COLORIDO", "...", "DIVERSOS");
            insertWord("COMER", "...", "AÇÃO");
            insertWord("COMPRAR", "...", "AÇÃO");
            insertWord("CONHECER", "...", "AÇÃO");
            insertWord("CONTAGEM", "...", "DIVERSOS");
            insertWord("CONTAR", "...", "AÇÃO");
            insertWord("CONTINUAR", "...", "AÇÃO");
            insertWord("CONTROLAR", "...", "AÇÃO");
            insertWord("CONVERSAR", "...", "AÇÃO");
            insertWord("CONVIDAR", "...", "AÇÃO");
            insertWord("COPO", "...", "OBJETOS");
            insertWord("CORRER", "...", "AÇÃO");
            insertWord("CORRIGIR", "...", "AÇÃO");
            insertWord("CORUJA", "...", "ANIMAIS");
            insertWord("CORVO", "...", "ANIMAIS");
            insertWord("COVA", "...", "DIVERSOS");
            insertWord("CREPÚSCULO", "...", "FILMES e SÉRIES");
            insertWord("CRISTIANO RONALDO", "...", "PESSOAS");
            insertWord("CROCODILO", "...", "ANIMAIS");
            insertWord("DADO", "...", "OBJETOS");
            insertWord("DANÇAR", "...", "AÇÃO");
            insertWord("DARTH VADER", "...", "PESSOAS");
            insertWord("DE VOLTA PARA O FUTURO ", "...", "FILMES e SÉRIES");
            insertWord("DEDAL", "...", "OBJETOS");
            insertWord("DEFUNTO", "...", "PESSOAS");
            insertWord("DEIXAR", "...", "AÇÃO");
            insertWord("DENTADURA", "...", "OBJETOS");
            insertWord("DERRUBAR", "...", "AÇÃO");
            insertWord("DESCER", "...", "AÇÃO");
            insertWord("DESCOBRIR", "...", "AÇÃO");
            insertWord("DESEJAR", "...", "AÇÃO");
            insertWord("DESEMPREGADO", "...", "PESSOAS");
            insertWord("DESERTO DO SAHARA", "...", "LUGARES");
            insertWord("DESISTIR", "...", "AÇÃO");
            insertWord("DETERGENTE", "...", "DIVERSOS");
            insertWord("DEZENA", "...", "DIVERSOS");
            insertWord("DIÁRIO", "...", "OBJETOS");
            insertWord("DICIONÁRIO", "...", "OBJETOS");
            insertWord("DIFERENTE", "...", "DIVERSOS");
            insertWord("DILMA ", "...", "PESSOAS");
            insertWord("DIVIDIR", "...", "AÇÃO");
            insertWord("DIZER", "...", "AÇÃO");
            insertWord("DOURADO", "...", "DIVERSOS");
            insertWord("DURO DE MATAR ", "...", "FILMES e SÉRIES");
            insertWord("DVD", "...", "OBJETOS");
            insertWord("E O VENTO LEVOU... ", "...", "FILMES e SÉRIES");
            insertWord("E.T. – O EXTRATERRESTRE ", "...", "FILMES e SÉRIES");
            insertWord("EBULIÇÃO", "...", "DIVERSOS");
            insertWord("ECONOMIZAR", "...", "AÇÃO");
            insertWord("EGITO", "...", "LUGARES");
            insertWord("ELECTRODOMÉSTICO", "...", "OBJETOS");
            insertWord("ELEFANTE ", "...", "ANIMAIS");
            insertWord("EMPRESÁRIO", "...", "PESSOAS");
            insertWord("ENCHER", "...", "AÇÃO");
            insertWord("ENCONTRAR", "...", "AÇÃO");
            insertWord("ENTENDER", "...", "AÇÃO");
            insertWord("ENTRAR", "...", "AÇÃO");
            insertWord("ENTRETER", "...", "AÇÃO");
            insertWord("EPISÓDIO", "...", "DIVERSOS");
            insertWord("ESCADA", "...", "OBJETOS");
            insertWord("ESCÓCIA", "...", "LUGARES");
            insertWord("ESCOLHER", "...", "AÇÃO");
            insertWord("ESCOVA", "...", "OBJETOS");
            insertWord("ESCRAVA", "...", "PESSOAS");
            insertWord("ESCREVER", "...", "AÇÃO");
            insertWord("ESCURIDÃO", "...", "DIVERSOS");
            insertWord("ESFÉRICO", "...", "DIVERSOS");
            insertWord("ESMALTE", "...", "OBJETOS");
            insertWord("ESPADA", "...", "OBJETOS");
            insertWord("ESPANHA", "...", "LUGARES");
            insertWord("ESPELHO", "...", "OBJETOS");
            insertWord("ESPERAR", "...", "AÇÃO");
            insertWord("ESPERMA", "...", "DIVERSOS");
            insertWord("ESPONJA", "...", "OBJETOS");
            insertWord("ESQUECER", "...", "AÇÃO");
            insertWord("ESQUERDA", "...", "DIVERSOS");
            insertWord("ESQUILO ", "...", "ANIMAIS");
            insertWord("ESTADOS UNIDOS", "...", "LUGARES");
            insertWord("ESTAMPA", "...", "DIVERSOS");
            insertWord("ESTUDAR", "...", "AÇÃO");
            insertWord("ETERNO", "...", "DIVERSOS");
            insertWord("EUROPA", "...", "AÇÃO");
            insertWord("EVAPORAR", "...", "AÇÃO");
            insertWord("EXCLUIR", "...", "AÇÃO");
            insertWord("EXEMPLO", "...", "DIVERSOS");
            insertWord("FACA", "...", "OBJETOS");
            insertWord("FACÃO", "...", "OBJETOS");
            insertWord("FAÍSCA", "...", "DIVERSOS");
            insertWord("FALAR", "...", "AÇÃO");
            insertWord("FAMÍLIA", "...", "DIVERSOS");
            insertWord("FANTOCHE", "...", "OBJETOS");
            insertWord("FAROL", "...", "LUGARES");
            insertWord("FAUSTÃO", "...", "PESSOAS");
            insertWord("FEIJÃO", "...", "COMIDAS");
            insertWord("FERIDA", "...", "DIVERSOS");
            insertWord("FERNANDO DE NORONHA", "...", "PESSOAS");
            insertWord("FERRADURA", "...", "OBJETOS");
            insertWord("FESTA", "...", "DIVERSOS");
            insertWord("FICAR", "...", "AÇÃO");
            insertWord("FILHA", "...", "PESSOAS");
            insertWord("FINGIR", "...", "AÇÃO");
            insertWord("FINO", "...", "DIVERSOS");
            insertWord("FITA MÉTRICA", "...", "OBJETOS");
            insertWord("FLECHA", "...", "OBJETOS");
            insertWord("FOCA ", "...", "ANIMAIS");
            insertWord("FOLHA", "...", "OBJETOS");
            insertWord("FORÇA", "...", "DIVERSOS");
            insertWord("FORMIGA", "...", "ANIMAIS");
            insertWord("FORREST GUMP – O CONTADOR DE HISTÓRIAS ", "...", "FILMES e SÉRIES");
            insertWord("FOTÓGRAFA", "...", "PESSOAS");
            insertWord("FRANÇA", "...", "LUGARES");
            insertWord("FRODO", "...", "PESSOAS");
            insertWord("FUNIL", "...", "OBJETOS");
            insertWord("FURADEIRA", "...", "OBJETOS");
            insertWord("FUTURO", "...", "DIVERSOS");
            insertWord("GAFANHOTO ", "...", "ANIMAIS");
            insertWord("GAIOLA", "...", "OBJETOS");
            insertWord("GAITA", "...", "OBJETOS");
            insertWord("GALINHA ", "...", "ANIMAIS");
            insertWord("GAMBÁ ", "...", "ANIMAIS");
            insertWord("GANGUE", "...", "DIVERSOS");
            insertWord("GANSO ", "...", "ANIMAIS");
            insertWord("GARÇA", "...", "ANIMAIS");
            insertWord("GARÇOM", "...", "PESSOAS");
            insertWord("GARFO", "...", "OBJETOS");
            insertWord("GARGANTILHA", "...", "OBJETOS");
            insertWord("GAROTA", "...", "PESSOAS");
            insertWord("GARRAFA", "...", "OBJETOS");
            insertWord("GATO", "...", "ANIMAIS");
            insertWord("GAÚCHO", "...", "PESSOAS");
            insertWord("GAVETA", "...", "OBJETOS");
            insertWord("GAVIÃO", "...", "ANIMAIS");
            insertWord("GELATINA", "...", "COMIDAS");
            insertWord("GIRAFA ", "...", "ANIMAIS");
            insertWord("GIRASSOL", "...", "DIVERSOS");
            insertWord("GISELE BÜNDCHEN", "...", "PESSOAS");
            insertWord("GLADIADOR ", "...", "PESSOAS");
            insertWord("GOLFINHO ", "...", "ANIMAIS");
            insertWord("GORILA ", "...", "ANIMAIS");
            insertWord("GORRO", "...", "OBJETOS");
            insertWord("GOSTAR", "...", "AÇÃO");
            insertWord("GRÁFICO", "...", "DIVERSOS");
            insertWord("GRAMADO", "...", "LUGARES");
            insertWord("GRÃO", "...", "DIVERSOS");
            insertWord("GRAVATA", "...", "OBJETOS");
            insertWord("GRITO", "...", "DIVERSOS");
            insertWord("GUACAMOLE", "...", "COMIDAS");
            insertWord("GUARDAR", "...", "AÇÃO");
            insertWord("GUERRA", "...", "DIVERSOS");
            insertWord("GUITARRA", "...", "OBJETOS");
            insertWord("GUITARRISTA", "...", "PESSOAS");
            insertWord("GUNS N' ROSES", "...", "DIVERSOS");
            insertWord("HAMBURGUER", "...", "COMIDAS");
            insertWord("HAMSTER ", "...", "ANIMAIS");
            insertWord("HARPA", "...", "OBJETOS");
            insertWord("HARRY POTTER", "...", "FILMES e SÉRIES");
            insertWord("HÉLICE", "...", "OBJETOS");
            insertWord("HIPNOSE", "...", "DIVERSOS");
            insertWord("HIPOPÓTAMO ", "...", "ANIMAIS");
            insertWord("HOLANDA", "...", "LUGARES");
            insertWord("HOLOFOTE", "...", "OBJETOS");
            insertWord("IGUALDADE", "...", "DIVERSOS");
            insertWord("IMÃ", "...", "OBJETOS");
            insertWord("IMAGINAÇÃO", "...", "DIVERSOS");
            insertWord("INALADOR", "...", "OBJETOS");
            insertWord("INCENSO", "...", "OBJETOS");
            insertWord("INDÚSTRIA", "...", "LUGARES");
            insertWord("INFÂNCIA", "...", "DIVERSOS");
            insertWord("INFORMAR", "...", "AÇÃO");
            insertWord("INGLATERRA", "...", "LUGARES");
            insertWord("INVERTER", "...", "AÇÃO");
            insertWord("IRMÃ", "...", "PESSOAS");
            insertWord("IRON MAIDEN", "...", "DIVERSOS");
            insertWord("ISCA", "...", "OBJETOS");
            insertWord("ISOPOR", "...", "OBJETOS");
            insertWord("ISQUEIRO", "...", "OBJETOS");
            insertWord("ITÁLIA", "...", "LUGARES");
            insertWord("IVETE SANGALO", "...", "PESSOAS");
            insertWord("JACARÉ", "...", "ANIMAIS");
            insertWord("JACARÉ ", "...", "ANIMAIS");
            insertWord("JANELA", "...", "OBJETOS");
            insertWord("JAQUETA", "...", "OBJETOS");
            insertWord("JARRA", "...", "OBJETOS");
            insertWord("JIM CARREY", "...", "PESSOAS");
            insertWord("JOGADOR", "...", "PESSOAS");
            insertWord("JOGAR", "...", "AÇÃO");
            insertWord("JOGO", "...", "DIVERSOS");
            insertWord("JOHNY DEPP", "...", "PESSOAS");
            insertWord("JÓIA", "...", "OBJETOS");
            insertWord("JÓIAS", "...", "OBJETOS");
            insertWord("JUÍZ", "...", "PESSOAS");
            insertWord("JULGAR", "...", "AÇÃO");
            insertWord("JURASSIC PARK ", "...", "FILMES e SÉRIES");
            insertWord("JUSTIÇA", "...", "DIVERSOS");
            insertWord("LAGARTIXA ", "...", "ANIMAIS");
            insertWord("LAGARTO ", "...", "ANIMAIS");
            insertWord("LÁGRIMA", "...", "DIVERSOS");
            insertWord("LAMPADA", "...", "OBJETOS");
            insertWord("LANTERNA", "...", "OBJETOS");
            insertWord("LÁPIDE", "...", "OBJETOS");
            insertWord("LÁPIS", "...", "OBJETOS");
            insertWord("LAPISEIRA", "...", "OBJETOS");
            insertWord("LARANJA", "...", "COMIDAS");
            insertWord("LATA", "...", "OBJETOS");
            insertWord("LAVAR", "...", "AÇÃO");
            insertWord("LEÃO ", "...", "ANIMAIS");
            insertWord("LEMBRAR", "...", "AÇÃO");
            insertWord("LENÇO", "...", "OBJETOS");
            insertWord("LEONARDO DI CAPRIO", "...", "PESSOAS");
            insertWord("LEOPARDO ", "...", "ANIMAIS");
            insertWord("LEQUE", "...", "OBJETOS");
            insertWord("LEVAR", "...", "AÇÃO");
            insertWord("LIGAR", "...", "AÇÃO");
            insertWord("LISTRADO", "...", "DIVERSOS");
            insertWord("LIVRO", "...", "OBJETOS");
            insertWord("LIXEIRA", "...", "OBJETOS");
            insertWord("LOBISOMEM", "...", "PESSOAS");
            insertWord("LOBO ", "...", "ANIMAIS");
            insertWord("LONTRA ", "...", "ANIMAIS");
            insertWord("LOUÇA", "...", "OBJETOS");
            insertWord("LUCIANO HUCK", "...", "PESSOAS");
            insertWord("LULA ", "...", "ANIMAIS");
            insertWord("LUMINÁRIA", "...", "OBJETOS");
            insertWord("LUTA", "...", "DIVERSOS");
            insertWord("LUVAS", "...", "OBJETOS");
            insertWord("MAÇA", "...", "COMIDAS");
            insertWord("MAÇÃ", "...", "COMIDAS");
            insertWord("MACACÃO", "...", "OBJETOS");
            insertWord("MACACO", "...", "ANIMAIS");
            insertWord("MADAGASCAR", "...", "LUGARES");
            insertWord("MADEIRA", "...", "DIVERSOS");
            insertWord("MADONNA", "...", "PESSOAS");
            insertWord("MAGO", "...", "PESSOAS");
            insertWord("MALA", "...", "OBJETOS");
            insertWord("MALANDRO", "...", "PESSOAS");
            insertWord("MANDAR", "...", "AÇÃO");
            insertWord("MANTER", "...", "AÇÃO");
            insertWord("MAQUIAGEM", "...", "DIVERSOS");
            insertWord("MARATONA", "...", "DIVERSOS");
            insertWord("MARINHEIRO", "...", "PESSOAS");
            insertWord("MARROCOS", "...", "LUGARES");
            insertWord("MATRIX ", "...", "FILMES e SÉRIES");
            insertWord("MEIAS", "...", "OBJETOS");
            insertWord("MEMÓRIA", "...", "DIVERSOS");
            insertWord("MENTIR", "...", "AÇÃO");
            insertWord("MÊS", "...", "DIVERSOS");
            insertWord("MESSI", "...", "PESSOAS");
            insertWord("METAL", "...", "DIVERSOS");
            insertWord("METALLICA", "...", "DIVERSOS");
            insertWord("MEXER", "...", "AÇÃO");
            insertWord("MICHAEL JACKSON", "...", "PESSOAS");
            insertWord("MIOJO", "...", "COMIDAS");
            insertWord("MISSÃO", "...", "DIVERSOS");
            insertWord("MOCHILA", "...", "OBJETOS");
            insertWord("MOLA", "...", "OBJETOS");
            insertWord("MORAR", "...", "AÇÃO");
            insertWord("MUDAR", "...", "AÇÃO");
            insertWord("NADAR", "...", "AÇÃO");
            insertWord("NÃO", "...", "DIVERSOS");
            insertWord("NATURAL", "...", "DIVERSOS");
            insertWord("NAVALHA", "...", "OBJETOS");
            insertWord("NAVIO", "...", "DIVERSOS");
            insertWord("NAVIO DE BRINQUEDO", "...", "OBJETOS");
            insertWord("NETA", "...", "PESSOAS");
            insertWord("NEYMAR", "...", "PESSOAS");
            insertWord("NIRVANA", "...", "DIVERSOS");
            insertWord("NÍVEL", "...", "DIVERSOS");
            insertWord("NORTE-AMERICANO", "...", "PESSOAS");
            insertWord("NOVELO", "...", "OBJETOS");
            insertWord("O LABIRINTO DO FAUNO ", "...", "FILMES e SÉRIES");
            insertWord("O MÁGICO DE OZ ", "...", "FILMES e SÉRIES");
            insertWord("O PODEROSO CHEFÃO ", "...", "FILMES e SÉRIES");
            insertWord("O PODEROSO CHEFÃO 2 ", "...", "FILMES e SÉRIES");
            insertWord("O REI LEÃO ", "...", "FILMES e SÉRIES");
            insertWord("O RESGATE DO SOLDADO RYAN ", "...", "FILMES e SÉRIES");
            insertWord("O SENHOR DOS ANÉIS", "...", "FILMES e SÉRIES");
            insertWord("O SOL É PARA TODOS ", "...", "FILMES e SÉRIES");
            insertWord("OBIWAN KENOBI", "...", "PESSOAS");
            insertWord("OBRAS DE ARTE", "...", "OBJETOS");
            insertWord("OCEANIA", "...", "LUGARES");
            insertWord("ÓCULOS", "...", "OBJETOS");
            insertWord("ÓCULOS DE SOL", "...", "OBJETOS");
            insertWord("OLHAR", "...", "AÇÃO");
            insertWord("ONÇA ", "...", "ANIMAIS");
            insertWord("ORIENTAL", "...", "PESSOAS");
            insertWord("PAI", "...", "PESSOAS");
            insertWord("PALAVRA", "...", "DIVERSOS");
            insertWord("PALAVRAS-CHAVE", "...", "DIVERSOS");
            insertWord("PANDA", "...", "ANIMAIS");
            insertWord("PANELA", "...", "OBJETOS");
            insertWord("PANO", "...", "OBJETOS");
            insertWord("PAPAGAIO ", "...", "ANIMAIS");
            insertWord("PAPEL", "...", "OBJETOS");
            insertWord("PARÁGRAFO", "...", "DIVERSOS");
            insertWord("PARAR", "...", "AÇÃO");
            insertWord("PARIS", "...", "LUGARES");
            insertWord("PARTICIPAR", "...", "AÇÃO");
            insertWord("PARTIR", "...", "AÇÃO");
            insertWord("PASSAR", "...", "AÇÃO");
            insertWord("PASSEAR", "...", "AÇÃO");
            insertWord("PATO ", "...", "ANIMAIS");
            insertWord("PAVÃO ", "...", "ANIMAIS");
            insertWord("PEDRA", "...", "OBJETOS");
            insertWord("PEIXE", "...", "ANIMAIS");
            insertWord("PEN DRIVE", "...", "OBJETOS");
            insertWord("PENSAMENTO", "...", "DIVERSOS");
            insertWord("PENSAR", "...", "AÇÃO");
            insertWord("PENTEAR", "...", "AÇÃO");
            insertWord("PERMITIR", "...", "AÇÃO");
            insertWord("PERU ", "...", "ANIMAIS");
            insertWord("PIMENTÃO", "...", "COMIDAS");
            insertWord("PINGÜIM ", "...", "ANIMAIS");
            insertWord("PIRANHA ", "...", "ANIMAIS");
            insertWord("PLANILHA", "...", "DIVERSOS");
            insertWord("PODAR", "...", "AÇÃO");
            insertWord("POETA", "...", "PESSOAS");
            insertWord("POLVO ", "...", "ANIMAIS");
            insertWord("POMBO ", "...", "ANIMAIS");
            insertWord("POPULAÇÃO", "...", "DIVERSOS");
            insertWord("PORCO ", "...", "ANIMAIS");
            insertWord("PORTA-RETRATO", "...", "OBJETOS");
            insertWord("PORTUGAL", "...", "LUGARES");
            insertWord("POSSUIR", "...", "AÇÃO");
            insertWord("PRATO", "...", "OBJETOS");
            insertWord("PRECISAR", "...", "AÇÃO");
            insertWord("PREOCUPAR", "...", "AÇÃO");
            insertWord("PRIMEIRO", "...", "DIVERSOS");
            insertWord("PROCURAR", "...", "AÇÃO");
            insertWord("PROTEGER", "...", "AÇÃO");
            insertWord("PULAR", "...", "AÇÃO");
            insertWord("PULGA ", "...", "ANIMAIS");
            insertWord("PULSEIRA", "...", "OBJETOS");
            insertWord("QUADRADO", "...", "DIVERSOS");
            insertWord("QUADRO", "...", "OBJETOS");
            insertWord("QUEBRA CABEÇA", "...", "OBJETOS");
            insertWord("QUIETO", "...", "PESSOAS");
            insertWord("RATO ", "...", "ANIMAIS");
            insertWord("RATOEIRA", "...", "OBJETOS");
            insertWord("REALIZAR", "...", "AÇÃO");
            insertWord("REBAIXAR", "...", "AÇÃO");
            insertWord("RECEBER", "...", "AÇÃO");
            insertWord("REGIÃO", "...", "LUGARES");
            insertWord("RÉGUA", "...", "OBJETOS");
            insertWord("RELÓGIO", "...", "OBJETOS");
            insertWord("REMAR", "...", "AÇÃO");
            insertWord("REMO", "...", "OBJETOS");
            insertWord("REPETIR", "...", "AÇÃO");
            insertWord("RETROVISOR", "...", "OBJETOS");
            insertWord("REVISTA", "...", "OBJETOS");
            insertWord("RIM", "...", "DIVERSOS");
            insertWord("RÍMEL", "...", "OBJETOS");
            insertWord("RINOCERONTE ", "...", "ANIMAIS");
            insertWord("RIO DE JANEIRO", "...", "LUGARES");
            insertWord("ROCHA", "...", "DIVERSOS");
            insertWord("ROCKY, UM LUTADOR ", "...", "FILMES e SÉRIES");
            insertWord("ROLETA", "...", "OBJETOS");
            insertWord("ROMA", "...", "LUGARES");
            insertWord("RONALDINHO GAÚCHO", "...", "PESSOAS");
            insertWord("ROSCA", "...", "OBJETOS");
            insertWord("ROSTO", "...", "DIVERSOS");
            insertWord("ROTEADOR", "...", "OBJETOS");
            insertWord("RURAL", "...", "DIVERSOS");
            insertWord("SABONETE", "...", "OBJETOS");
            insertWord("SACO", "...", "OBJETOS");
            insertWord("SACO DE PANCADAS", "...", "OBJETOS");
            insertWord("SACOLA", "...", "OBJETOS");
            insertWord("SALEIRO", "...", "OBJETOS");
            insertWord("SANDÁLIA", "...", "OBJETOS");
            insertWord("SANDY", "...", "PESSOAS");
            insertWord("SAPATO", "...", "OBJETOS");
            insertWord("SAPO ", "...", "ANIMAIS");
            insertWord("SEGUNDO", "...", "DIVERSOS");
            insertWord("SEMESTRE", "...", "DIVERSOS");
            insertWord("SENHA", "...", "DIVERSOS");
            insertWord("SENTAR", "...", "AÇÃO");
            insertWord("SERVIR", "...", "AÇÃO");
            insertWord("SHAKIRA", "...", "PESSOAS");
            insertWord("SHORTS", "...", "OBJETOS");
            insertWord("SILVIO SANTOS", "...", "PESSOAS");
            insertWord("SINO", "...", "OBJETOS");
            insertWord("SOBREMESA", "...", "COMIDAS");
            insertWord("SOFÁ", "...", "OBJETOS");
            insertWord("STAR WARS", "...", "FILMES e SÉRIES");
            insertWord("SURGIR", "...", "AÇÃO");
            insertWord("SUSHI", "...", "COMIDAS");
            insertWord("TAMANCO", "...", "OBJETOS");
            insertWord("TAMANDUÁ ", "...", "ANIMAIS");
            insertWord("TAMPA", "...", "OBJETOS");
            insertWord("TATAME", "...", "DIVERSOS");
            insertWord("TATU", "...", "ANIMAIS");
            insertWord("TATU ", "...", "ANIMAIS");
            insertWord("TATUAGEM", "...", "DIVERSOS");
            insertWord("TAYLOR SWIFT", "...", "PESSOAS");
            insertWord("TEATRO", "...", "LUGARES");
            insertWord("TECLADO", "...", "OBJETOS");
            insertWord("TELEFONE", "...", "OBJETOS");
            insertWord("TELHA", "...", "OBJETOS");
            insertWord("TEMPERATURA", "...", "DIVERSOS");
            insertWord("TERMÔMETRO", "...", "OBJETOS");
            insertWord("TESOURA", "...", "OBJETOS");
            insertWord("THE BEATLES", "...", "DIVERSOS");
            insertWord("TIGRE ", "...", "ANIMAIS");
            insertWord("TITANIC ", "...", "FILMES e SÉRIES");
            insertWord("TOM CRUISE", "...", "PESSOAS");
            insertWord("TOSSIR", "...", "AÇÃO");
            insertWord("TOURO", "...", "ANIMAIS");
            insertWord("TOY STORY ", "...", "FILMES e SÉRIES");
            insertWord("TRABALHAR", "...", "AÇÃO");
            insertWord("TRABALHO", "...", "DIVERSOS");
            insertWord("TRANSAR", "...", "AÇÃO");
            insertWord("TRANSFORMAÇÃO", "...", "DIVERSOS");
            insertWord("TRENA", "...", "OBJETOS");
            insertWord("TRIBUNAL", "...", "LUGARES");
            insertWord("TRIMESTRE", "...", "DIVERSOS");
            insertWord("TRIPLO", "...", "DIVERSOS");
            insertWord("TURBULÊNCIA", "...", "DIVERSOS");
            insertWord("UMIDIFICADOR", "...", "OBJETOS");
            insertWord("UNIFORME", "...", "OBJETOS");
            insertWord("UP – ALTAS AVENTURAS ", "...", "FILMES e SÉRIES");
            insertWord("URINA", "...", "DIVERSOS");
            insertWord("URNA", "...", "OBJETOS");
            insertWord("URSINHO DE PELÚCIA", "...", "OBJETOS");
            insertWord("URSO ", "...", "ANIMAIS");
            insertWord("USAR", "...", "AÇÃO");
            insertWord("VAPOR", "...", "DIVERSOS");
            insertWord("VARA DE PESCAR", "...", "OBJETOS");
            insertWord("VARAL", "...", "OBJETOS");
            insertWord("VASO", "...", "OBJETOS");
            insertWord("VASSOURA", "...", "OBJETOS");
            insertWord("VEADO ", "...", "ANIMAIS");
            insertWord("VELA", "...", "OBJETOS");
            insertWord("VELHO", "...", "PESSOAS");
            insertWord("VENDER", "...", "AÇÃO");
            insertWord("VENTILADOR", "...", "OBJETOS");
            insertWord("VENTRE", "...", "DIVERSOS");
            insertWord("VENTRÍLOCO", "...", "PESSOAS");
            insertWord("VER", "...", "AÇÃO");
            insertWord("VERDADE", "...", "DIVERSOS");
            insertWord("VESTIR", "...", "AÇÃO");
            insertWord("VIAJAR", "...", "AÇÃO");
            insertWord("VIDRO", "...", "OBJETOS");
            insertWord("VISEIRA", "...", "OBJETOS");
            insertWord("VITAMINA", "...", "COMIDAS");
            insertWord("VIVER", "...", "AÇÃO");
            insertWord("VOAR", "...", "AÇÃO");
            insertWord("VOLTAGEM", "...", "DIVERSOS");
            insertWord("VOLTAR", "...", "AÇÃO");
            insertWord("VOLUME", "...", "DIVERSOS");
            insertWord("WALL-E", "...", "FILMES e SÉRIES");
            insertWord("XADREZ", "...", "DIVERSOS");
            insertWord("XAROPE", "...", "DIVERSOS");
            insertWord("XICARA", "...", "OBJETOS");
            insertWord("XUXA", "...", "PESSOAS");
            insertWord("ZEBRA ", "...", "ANIMAIS");
            insertWord("ZOOM", "...", "DIVERSOS");


            Toast toast = Toast.makeText(getApplicationContext(), "Palavras Carregadas!", Toast.LENGTH_LONG);
            toast.show();

        }


    }

    public void insertWord(String word, String tip, String category) {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        ObjectWord word_object = new ObjectWord();

        word_object.setWord(word.toUpperCase());
        word_object.setTip(tip);
        word_object.setCategory(category);
        word_object.setImage(word_object.getImage());
        word_object.setStatus("FREE");

        daoSession.getObjectWordDao().insert(word_object);


    }

}

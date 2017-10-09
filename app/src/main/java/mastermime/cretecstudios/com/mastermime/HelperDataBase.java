package mastermime.cretecstudios.com.mastermime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

/**
 * Created by vinicios-biluca on 18/09/17.
 */

public class HelperDataBase extends SQLiteOpenHelper {

    static String default_path = android.os.Environment.getExternalStorageDirectory().toString();
    static String main_folder = default_path + "/MasterMime";

    public static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = main_folder + "/dbMasterMime.db3";

    public HelperDataBase(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Cria a Tabela Word
        db.execSQL(tableWord());
        db.execSQL(tableTeam());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String tableWord() {

        return "CREATE TABLE 'word' ("
                + "'id'	INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "'word'	TEXT,"
                + "'tip'	TEXT,"
                + "'category'	TEXT,"
                + "'status'	TEXT"
                + ");";

    }

    public String tableTeam() {

        return "CREATE TABLE 'team' ("
                + "'id'	INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "'code'	TEXT,"
                + "'symbol'	TEXT,"
                + "'name'	TEXT"
                + ");";

    }


    public String generateCode(String seed) {

        Random generator = new Random();
        String code = "";

        for (int i = 0; i < 6; i++) {

            int j = generator.nextInt(9);

            code = code + String.valueOf(j);

        }

        return seed + code;

    }

    public void loadSet(SQLiteDatabase db) {

        db.execSQL("INSERT INTO word VALUES(null,'A BELA E A FERA ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ABACAXI','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ABAJUR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ABELHA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ACERTAR','Acertar no alvo!','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ACHAR','Sinônimo de encontrar','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ACONTECER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ADICIONAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ADQUIRIR','Sinônimo de comprar','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AFEGANISTÃO','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ÁFRICA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AGRONOMIA','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AGIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AGRADECER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ÁGUIA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AGULHA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AJUSTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AJUDAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALIMENTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALCE ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALEMANHA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALFINETE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALIEN','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALMOÇAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ALMOFADA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMAR','Amar outra pessoa','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMIGO','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMEIXA','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMÉRICA CENTRAL','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMÉRICA DO NORTE','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AMÉRICA DO SUL','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANDADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANÃO','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANEL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANGELINA JOLIE','Atriz','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANTA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANTARTICA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANTARTIDA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ANZOL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'APRESENTAÇÃO','','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'APONTADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'APRENDER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'APRESENTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARRANHA CÉU','','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARAGORN','Personagem','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARANHA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARARA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARGENTINA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ARROZ','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ASMA','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ÁSIA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ASSISTIR','Assitir a um filme','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AVALIAÇÃO','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AVATAR ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AVESTRUZ ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'AVISAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BALÃO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BALEIA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BARACK OBAMA','Ex-Presidente','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BARATA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BATATA','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BATER','Bater na porta','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BATMAN – O CAVALEIRO DAS TREVAS ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BEBER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BEIJAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BEXIGA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BOLA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BORBOLETA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BORRACHA ESCOLAR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BOTAS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BRASIL','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BRASÍLIA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BRINCAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BÚFALO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'BUSCAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CABRA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CALÇA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAMALEÃO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAMELO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAMINHAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAMISA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAMISETA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CANADÁ','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CANETA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CANTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CÃO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAPIVARA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CARANGUEJO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CARIMBO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CASTIÇAL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CASTOR ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CAVALO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CD','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CHAMAR','Chamar outra pessoa','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CHEGAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CHORAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CHURRASCO','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CISNE ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CLAUDIA LEITE','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COALA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COBRA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COELHO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COLHER','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COLOCAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COMER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COMPRAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CONHECER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CONTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CONTINUAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CONVERSAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CONVIDAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'COPO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CORRER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CORRIGIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CORVO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CREPÚSCULO','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'CRISTIANO RONALDO','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DADO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DANÇAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DARTH VADER','Personagem','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DE VOLTA PARA O FUTURO ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DEDAL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DEIXAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DENTADURA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DESCER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DESEJAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DESERTO DO SAHARA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DESISTIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DEVER','Dever cumprido','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DIÁRIO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DICIONÁRIO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DILMA ','Ex-Presidenta','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DIVIDIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DURO DE MATAR ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'DVD','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'E O VENTO LEVOU... ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'E.T. – O EXTRATERRESTRE ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'EGITO','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ELEFANTE ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ENCHER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ENCONTRAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ENTENDER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ENTRAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ENTRETER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESCADA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESCÓCIA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESCOLHER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESCOVA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESCREVER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESMALTE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESPADA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESPANHA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESPANHA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESPELHO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESPERAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESQUECER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESQUILO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESTADOS UNIDOS','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ESTUDAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'EUROPA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'EXCLUIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FACA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FACÃO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FALAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FAROL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FAUSTÃO','Apresentador','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FEIJÃO','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FERNANDO DE NORONHA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FERRADURA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FICAR','Não ir embora','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FINGIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FITA MÉTRICA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FOCA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FOLHA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FORMIGA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FORREST GUMP – O CONTADOR DE HISTÓRIAS ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FRANÇA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FRODO','Senhor dos Anéis','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FUNIL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'FURADEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAFANHOTO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAIOLA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAITA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GALINHA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAMBÁ ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GANSO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GARFO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GARGANTILHA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GARRAFA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GATO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAVETA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GAVIÃO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GIRAFA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GISELE BÜNDCHEN','Modelo','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GLADIADOR ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GOLFINHO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GORILA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GORRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GOSTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GRAVATA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GUACAMOLE','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GUITARRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'GUNS N ROSES','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HAMBURGUER','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HAMSTER ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HARPA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HARRY POTTER','Personagem','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HÉLICE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HIPOPÓTAMO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'HOLOFOTE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'IMÃ','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'INALADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'INCENSO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'INFORMAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'INGLATERRA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'IRON MAIDEN','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ISCA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ISOPOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ISQUEIRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ITÁLIA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'IVETE SANGALO','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JACARÉ ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JANELA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JAQUETA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JARRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JIM CARREY','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JOGAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JOHNY DEPP','Ator','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JÓIAS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JULGAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'JURASSIC PARK ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LAGARTIXA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LAGARTO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LAMPADA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LANTERNA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LÁPIS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LAPISEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LARANJA','Fruta','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LATA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LAVAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEÃO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEMBRAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LENÇO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEONARDO DI CAPRIO','Ator','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEOPARDO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEQUE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LEVAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LIGAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LIVRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LIXEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LOBO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LONTRA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LUCIANO HUCK','Apresentador','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LULA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LUMINÁRIA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'LUVAS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MAÇA','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MACACO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MADAGASCAR','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MADONNA','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MALA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MANDAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MANTER','Manter a calma','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MAQUIAGEM','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MARROCOS','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MATRIX ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MEIAS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MENTIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MESSI','Jogador de Futebol','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'METALLICA','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MEXER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MICHAEL JACKSON','Cantor ','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MIOJO','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MOCHILA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MOLA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MORAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'MUDAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NADAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NAVALHA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NAVIO DE BRINQUEDO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NEYMAR','Jogador de Futebol','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NIRVANA','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'NOVELO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O LABIRINTO DO FAUNO ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O MÁGICO DE OZ ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O PODEROSO CHEFÃO ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O PODEROSO CHEFÃO 2 ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O REI LEÃO ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O RESGATE DO SOLDADO RYAN ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O SENHOR DOS ANÉIS','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'O SOL É PARA TODOS ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'OBIWAN KENOBI','Personagem','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'OBRAS DE ARTE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'OCEANIA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ÓCULOS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ÓCULOS DE SOL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'OLHAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ONÇA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PANDA','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PANELA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PAPAGAIO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PAPEL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PARAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PARIS','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PARTICIPAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PARTIR','Ir embora','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PASSAR','Passar por uma porta','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PASSEAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PATO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PAVÃO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PEDRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PEIXE','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PEN DRIVE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PENSAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PERMITIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PERU ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PINGÜIM ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PIRANHA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'POLVO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'POMBO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PORCO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PORTA-RETRATO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PORTUGAL','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'POSSUIR','Sinônimo de ter','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PRATO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PRECISAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PREOCUPAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PROCURAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PROTEGER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PULAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PULGA ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'PULSEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'QUADRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'QUEBRA CABEÇA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RATO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RATOEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'REALIZAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RECEBER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RÉGUA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RELÓGIO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'REMO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'REPETIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'REVISTA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RÍMEL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RINOCERONTE ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RIO DE JANEIRO','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ROCKY, UM LUTADOR ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ROLETA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ROMA','...','PLACES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'RONALDINHO GAÚCHO','Jogador de Futebol','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ROTEADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SABONETE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SACO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SACO DE PANCADAS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SACOLA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SALEIRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SANDÁLIA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SANDY','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SAPATO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SAPO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SENTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SERVIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SHAKIRA','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SHORTS','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SILVIO SANTOS','Apresentador','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SINO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'STAR WARS','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SURGIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'SUSHI','...','FOODS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TAMANCO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TAMANDUÁ ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TAMPA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TATAME','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TATU ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TAYLOR SWIFT','Cantora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TECLADO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TELEFONE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TELHA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TERMÔMETRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TESOURA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'THE BEATLES','...','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TIGRE ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TITANIC ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TOM CRUISE','Ator','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TOSSIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TOURO','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TOY STORY ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TRABALHAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'TRENA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'UMIDIFICADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'UNIFORME','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'UP – ALTAS AVENTURAS ','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'URNA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'URSINHO DE PELÚCIA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'URSO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'USAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VARA DE PESCAR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VARAL','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VASO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VASSOURA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VEADO ','...','ANIMALS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VELA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VENTRÍLOCO','...','MIX','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VENDER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VENTILADOR','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VESTIR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VIAJAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VIDRO','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VISEIRA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VIVER','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VOAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'VOLTAR','...','ACTION','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'WALL-E','...','MOVIES','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'XADREZ','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'XALE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'XAROPE','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'XICARA','...','OBJECT','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'XUXA','Apresentadora','FAMOUS','FREE');");
        db.execSQL("INSERT INTO word VALUES(null,'ZEBRA ','...','ANIMALS','FREE');");


    }
}

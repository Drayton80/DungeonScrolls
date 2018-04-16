package door.opposite.grupo2.dungeonscrolls.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ci on 05/04/18.
 */

public class SQLite extends SQLiteOpenHelper{
    FirebaseDatabase database;
    DatabaseReference reference;
    StorageReference storageReference;


    public static final  String DATABASE_NAME = "dungeonscrolls.db";

    public static final  String T1_TABLE_NAME = "usuario_table";
    public static final  String T1_COL_1 = "ID";
    public static final  String T1_COL_2 = "NICK";
    public static final  String T1_COL_3 = "SENHA";
    public static final  String T1_COL_4 = "EMAIL";
    public static final  String T1_COL_5 = "SALASID";
    public static final  String T1_COL_6 = "FICHASID";


    public static final  String T2_TABLE_NAME = "sala_table";
    public static final  String T2_COL_1 = "ID";
    public static final  String T2_COL_2 = "NOME";
    public static final  String T2_COL_3 = "SENHA";
    public static final  String T2_COL_4 = "MESTRE";
    public static final  String T2_COL_5 = "HISTORIA";
    public static final  String T2_COL_6 = "IMAGEM";
    public static final  String T2_COL_7 = "JOGADORESID";
    public static final  String T2_COL_8 = "FICHASID";
    public static final  String T2_COL_9 = "NOMEMESTRE";
    public static final  String T2_COL_10 = "NOTAS";


    public static final  String T3_TABLE_NAME = "ficha_table";
    public static final  String T3_COL_1 = "ID";
    public static final  String T3_COL_2 = "NOMEPERSONAGEM";
    public static final  String T3_COL_3 = "NOMEJOGADOR";
    public static final  String T3_COL_4 = "CLASSENIVEL";
    public static final  String T3_COL_5 = "RACA";
    public static final  String T3_COL_6 = "TENDENCIA";
    public static final  String T3_COL_7 = "DIVINDADE";
    public static final  String T3_COL_8 = "SEXO";
    public static final  String T3_COL_9 = "TAMANHO";
    public static final  String T3_COL_10 = "ALTURA";
    public static final  String T3_COL_11 = "PESO";
    public static final  String T3_COL_12 = "IDADE";
    public static final  String T3_COL_13 = "FORCA";
    public static final  String T3_COL_14 = "CONSTITUICAO";
    public static final  String T3_COL_15 = "DESTREZA";
    public static final  String T3_COL_16 = "INTELIGENCIA";
    public static final  String T3_COL_17 = "SABEDORIA";
    public static final  String T3_COL_18 = "CARISMA";
    public static final  String T3_COL_19 = "FORCAMOD";
    public static final  String T3_COL_20 = "CONSTITUICAOMOD";
    public static final  String T3_COL_21 = "DESTREZAMOD";
    public static final  String T3_COL_22 = "INTELIGENCIAMOD";
    public static final  String T3_COL_23 = "SABEDORIAMOD";
    public static final  String T3_COL_24 = "CARISMAMOD";
    public static final  String T3_COL_25 = "CA";
    public static final  String T3_COL_26 = "CAOUTROS";
    public static final  String T3_COL_27 = "CATOQUE";
    public static final  String T3_COL_28 = "CASURPRESA";
    public static final  String T3_COL_29 = "ARMADURA";
    public static final  String T3_COL_30 = "ARMADURANATURAL";
    public static final  String T3_COL_31 = "PV";
    public static final  String T3_COL_32 = "REDUCAODEDANO";
    public static final  String T3_COL_33 = "INICIATIVA";
    public static final  String T3_COL_34 = "INICIATIVAOUTROS";
    public static final  String T3_COL_35 = "FORTITUDE";
    public static final  String T3_COL_36 = "FORTITUDEOUTROS";
    public static final  String T3_COL_37 = "FORTITUDEBASE";
    public static final  String T3_COL_38 = "REFLEXO";
    public static final  String T3_COL_39 = "REFLEXOOUTROS";
    public static final  String T3_COL_40 = "REFLEXOBASE";
    public static final  String T3_COL_41 = "VONTADE";
    public static final  String T3_COL_42 = "VONTADEOUTROS";
    public static final  String T3_COL_43 = "VONTADEBASE";
    public static final  String T3_COL_44 = "BBA";
    public static final  String T3_COL_45 = "RESMAGICA";
    public static final  String T3_COL_46 = "DESLOCAMENTO";
    public static final  String T3_COL_47 = "AGARRAR";
    public static final  String T3_COL_48 = "AGARRAROUTROS";
    public static final  String T3_COL_49 = "PC";
    public static final  String T3_COL_50 = "PP";
    public static final  String T3_COL_51 = "PO";
    public static final  String T3_COL_52 = "PL";
    public static final  String T3_COL_53 = "XP";
    public static final  String T3_COL_54 = "XPNECESSARIO";
    public static final  String T3_COL_55 = "IDIOMAS";
    public static final  String T3_COL_56 = "INVENTARIO";
    public static final  String T3_COL_57 = "ATAQUES";
    public static final  String T3_COL_58 = "ARMAEQUIP";
    public static final  String T3_COL_59 = "ARMADURAEQUIP";
    public static final  String T3_COL_60 = "OUTROSEQUIP";
    public static final  String T3_COL_61 = "CARCTCLASSE";
    public static final  String T3_COL_62 = "TALENTOS";
    public static final  String T3_COL_63 = "MAGIAS";
    public static final  String T3_COL_64 = "IMAGEM";


    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, 1);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 +"INTEGER"+ ")";
        //db.execSQL(SQL_String);
        db.execSQL("CREATE TABLE " + T1_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NICK TEXT, SENHA TEXT, EMAIL TEXT, SALASID TEXT, FICHASID TEXT)");
        db.execSQL("CREATE TABLE " + T2_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, SENHA TEXT, MESTRE INTEGER, HISTORIA TEXT, IMAGEM TEXT," +
                " JOGADORESID TEXT, FICHASID TEXT, NOMEMESTRE TEXT, NOTAS TEXT)");
        db.execSQL("CREATE TABLE " + T3_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMEPERSONAGEM TEXT, NOMEJOGADOR TEXT, CLASSENIVEL TEXT, RACA TEXT," +
                " TENDENCIA TEXT, DIVINDADE TEXT, SEXO TEXT, TAMANHO TEXT, ALTURA REAL, PESO REAL, IDADE INTEGER, FORCA INTEGER, CONSTITUICAO INTEGER, DESTREZA INTEGER, " +
                "INTELIGENCIA INTEGER, SABEDORIA INTEGER, CARISMA INTEGER, FORCAMOD INTEGER, CONSTITUICAOMOD INTEGER, DESTREZAMOD INTEGER, INTELIGENCIAMOD INTEGER, " +
                "SABEDORIAMOD INTEGER, CARISMAMOD INTEGER, CA INTEGER, CAOUTROS INTEGER, CATOQUE INTEGER, CASURPRESA INTEGER, ARMADURA INTEGER, ARMADURANATURAL INTEGER, " +
                "PV INTEGER, REDUCAODEDANO INTEGER, INICIATIVA INTEGER, INICIATIVAOUTROS INTEGER, FORTITUDE INTEGER, FORTITUDEOUTROS INTEGER, FORTITUDEBASE INTEGER, " +
                "REFLEXO INTEGER, REFLEXOOUTROS INTEGER, REFLEXOBASE INTEGER, VONTADE INTEGER, VONTADEOUTROS INTEGER, VONTADEBASE INTEGER, BBA INTEGER, RESMAGICA INTEGER, " +
                "DESLOCAMENTO INTEGER, AGARRAR INTEGER, AGARRAROUTROS INTEGER, PC INTEGER, PP INTEGER, PO INTEGER, PL INTEGER, XP INTEGER, XPNECESSARIO INTEGER, " +
                "IDIOMAS TEXT, INVENTARIO TEXT, ATAQUES TEXT, ARMAEQUIP TEXT, ARMADURAEQUIP TEXT, OUTROSEQUIP TEXT, CARCTCLASSE TEXT, TALENTOS TEXT, MAGIAS TEXT, " +
                "IMAGEM BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + T1_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + T2_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + T3_TABLE_NAME);

        onCreate(db);
    }


    public boolean atualizaDataUsuario(){
        reference.child("usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                Usuario user = new Usuario();
                GenericTypeIndicator<ArrayList<Integer>> t = new GenericTypeIndicator<ArrayList<Integer>>(){};
                user.setID(snapshot.child("id").getValue(int.class));
                user.setNick(snapshot.child("nick").getValue(String.class));
                user.setSenha(snapshot.child("senha").getValue(String.class));
                user.setEmail(snapshot.child("email").getValue(String.class));
                user.setSalasID(snapshot.child("salasID").getValue(t));
                user.setFichasID(snapshot.child("fichasID").getValue(t));
                System.out.println("==========================================" + user.getID());

                boolean existe = verSeTemEsseUsuario(user.getID());
                if (existe == true){
                    updateDataUsuario(user);
                }
                else{
                    insereDataUsuario(user);
                }
            }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return true;
    }



    public boolean insereDataUsuario(Usuario usuario){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(T1_COL_2, usuario.getID());
        }catch (Exception e){

        }
        contentValues.put(T1_COL_2, usuario.getNick());
        contentValues.put(T1_COL_3, usuario.getSenha());
        contentValues.put(T1_COL_4, usuario.getEmail());
        contentValues.put(T1_COL_5, usuario.getSalasID().toString());
        contentValues.put(T1_COL_6, usuario.getFichasID().toString());



        long result = db.insert(T1_TABLE_NAME, null, contentValues);
        if(result == -1){
            return  false;
        }else{
            Usuario novoUsuario = selecionarUsuario(usuario.getNick());
            reference.child("usuario").child(String.valueOf(novoUsuario.getID())).setValue(novoUsuario);
            return true;
        }
    }

    public Cursor getAllDataUsuario(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + T1_TABLE_NAME, null ); // "*" represental ALL, esse metedo ta mandando selecionar tudo quem tem na tabela.
        return res;
    }

    public int updateDataUsuario(Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_1, usuario.getID());
        contentValues.put(T1_COL_2, usuario.getNick());
        contentValues.put(T1_COL_3, usuario.getSenha());
        contentValues.put(T1_COL_4, usuario.getEmail());
        contentValues.put(T1_COL_5, usuario.getSalasID().toString());
        contentValues.put(T1_COL_6,usuario.getFichasID().toString());

        reference.child("usuario").child(String.valueOf(usuario.getID())).setValue(usuario);

        int i = db.update(T1_TABLE_NAME, contentValues, "ID = ?", new String[]{String.valueOf(usuario.getID())});
        return i;
    }

    public Integer deleteDataUsuario(Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        reference.child("usuario").child(String.valueOf(usuario.getID())).removeValue();
        return db.delete(T1_TABLE_NAME, "ID = ?", new String[]{String.valueOf(usuario.getID())}); //esse metodo retorna um inteiro, se fori deletado é 1 se não foi é 0

    }



    public Usuario selecionarUsuario(int ID){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T1_TABLE_NAME, new String[]{T1_COL_1, T1_COL_2,
                        T1_COL_3, T1_COL_4, T1_COL_5, T1_COL_6}, "ID = ?", new String[]{String.valueOf(ID)},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Usuario usuario = new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        String[] idSalas = cursor.getString(4).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        String[] idFichas = cursor.getString(5).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] results1 = new int[idSalas.length];
        int[] results2 = new int[idFichas.length];

        for (int i = 0; i < idSalas.length; i++){
            results1[i] = Integer.parseInt(idSalas[i]);
        }

        for (int j = 0; j < idFichas.length; j++){
            results2[j] = Integer.parseInt(idFichas[j]);
        }

        ArrayList<Integer> intList1 = new ArrayList<>();
        ArrayList<Integer> intList2 = new ArrayList<>();
        for (int i : results1)
        {
            intList1.add(i);
        }

        for (int i : results2)
        {
            intList2.add(i);
        }

        usuario.setSalasID(intList1);
        usuario.setFichasID(intList2);

        return usuario;
    }


    public Usuario selecionarUsuario(String nick){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T1_TABLE_NAME, new String[]{T1_COL_1, T1_COL_2,
                        T1_COL_3, T1_COL_4, T1_COL_5, T1_COL_6}, "NICK = ?", new String[]{nick},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        if (cursor == null){
            return null;
        }

        Usuario usuario = new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        String[] idSalas = cursor.getString(4).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        String[] idFichas = cursor.getString(5).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] results1 = new int[idSalas.length];
        int[] results2 = new int[idFichas.length];

        for (int i = 0; i < idSalas.length; i++){
            try {
                results1[i] = Integer.parseInt(idSalas[i]);
            }catch(Exception e){

            }
        }

        for (int j = 0; j < idFichas.length; j++){
            try {
                results2[j] = Integer.parseInt(idFichas[j]);
            }catch(Exception e){

            }
        }

        ArrayList<Integer> intList1 = new ArrayList<>();
        ArrayList<Integer> intList2 = new ArrayList<>();
        for (int i : results1)
        {
            intList1.add(i);
        }

        for (int i : results2)
        {
            intList2.add(i);
        }

        usuario.setSalasID(intList1);
        usuario.setFichasID(intList2);

        return usuario;
    }

    public int ultimoUsuario(){
        int saida = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + T1_TABLE_NAME  + " ORDER BY " + T1_COL_1 + " DESC LIMIT " + 1;
        Cursor c = db.rawQuery(query, null);;
        if(c.moveToFirst())
            saida = Integer.parseInt(c.getString(0));
        c.close();

        return saida;
    }


    public boolean verSeTemEsseUsuario(int i){
        List<Usuario> lista = new ArrayList<Usuario>();

        String query = "SELECT * FROM " + T1_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Usuario usuario = new Usuario(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2), c.getString(3));
                if (i == usuario.getID()){
                    return true;
                }

            }while(c.moveToNext());
        }
        return false;
    }



    public List<Usuario> listaUsuario(){
        List<Usuario> lista = new ArrayList<Usuario>();

        String query = "SELECT * FROM " + T1_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Usuario usuario = new Usuario(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2), c.getString(3));
                String[] idSalas = c.getString(4).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
                String[] idFichas = c.getString(5).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
                int[] results1 = new int[idSalas.length];
                int[] results2 = new int[idFichas.length];

                for (int i = 0; i < idSalas.length; i++){

                    try{
                       results1[i] = Integer.parseInt(idSalas[i]);
                    }catch(Exception e){

                    }
                }

                for (int j = 0; j < idFichas.length; j++){
                    try{
                        results2[j] = Integer.parseInt(idFichas[j]);
                    }catch(Exception e){

                    }
                }

                ArrayList<Integer> intList1 = new ArrayList<>();
                ArrayList<Integer> intList2 = new ArrayList<>();
                for (int i : results1)
                {
                    intList1.add(i);
                }

                for (int i : results2)
                {
                    intList2.add(i);
                }

                usuario.setSalasID(intList1);
                usuario.setFichasID(intList2);


                lista.add(usuario);
            }while(c.moveToNext());
        }
        return lista;
    }

    public boolean insereDataSala(Sala sala){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL_2, sala.getNome());
        contentValues.put(T2_COL_3, sala.getSenha());
        contentValues.put(T2_COL_4, sala.getMestre());
        contentValues.put(T2_COL_5, sala.getHistoria());
        contentValues.put(T2_COL_6, sala.getUri());
        contentValues.put(T2_COL_7, sala.getJogadoresID().toString());
        contentValues.put(T2_COL_8, sala.getFichasID().toString());
        contentValues.put(T2_COL_9, sala.getNomeMestre());
        contentValues.put(T2_COL_10, sala.getNotas());

        long result = db.insert(T2_TABLE_NAME, null, contentValues);
        if(result == -1){
            return  false;
        }else{
            Sala novaSala = selecionarSala(sala.getNome());

            reference.child("sala").child(String.valueOf(novaSala.getID())).setValue(novaSala);

            return true;
        }
    }

    public Cursor getAllDataSala(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + T2_TABLE_NAME, null ); // "*" represental ALL, esse metedo ta mandando selecionar tudo quem tem na tabela.
        return res;
    }


    public boolean updateDataSala(Sala sala){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL_1, sala.getID());
        contentValues.put(T2_COL_2, sala.getNome());
        contentValues.put(T2_COL_3, sala.getSenha());
        contentValues.put(T2_COL_4, sala.getMestre());
        contentValues.put(T2_COL_5, sala.getHistoria());
        contentValues.put(T2_COL_6, sala.getUri());
        contentValues.put(T2_COL_7, sala.getJogadoresID().toString());
        contentValues.put(T2_COL_8, sala.getFichasID().toString());
        contentValues.put(T2_COL_9, sala.getNomeMestre());
        contentValues.put(T2_COL_10, sala.getNotas());
        db.update(T2_TABLE_NAME, contentValues, "ID = ?", new String[]{String.valueOf(sala.getID())});
        return true;
    }

    public Integer deleteDataSala(Sala sala){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(T2_TABLE_NAME, "ID = ?", new String[]{String.valueOf(sala.getID())}); //esse metodo retorna um inteiro, se fori deletado é 1 se não foi é 0

    }



    public Sala selecionarSala(int ID){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T2_TABLE_NAME, new String[]{T2_COL_1, T2_COL_2,
                        T2_COL_3, T2_COL_4, T2_COL_5, T2_COL_6, T2_COL_7, T2_COL_8, T2_COL_9, T2_COL_10}, "ID = ?", new String[]{String.valueOf(ID)},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Sala sala = new Sala(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(8));

        sala.setNotas(cursor.getString(9));
        sala.setUri(cursor.getString(5));

        String[] idJogadores = cursor.getString(6).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        String[] idFichas = cursor.getString(7).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] results1 = new int[idJogadores.length];
        int[] results2 = new int[idFichas.length];

        for (int i = 0; i < idJogadores.length; i++){
            try {
                results1[i] = Integer.parseInt(idJogadores[i]);
            }catch (Exception e){}
        }

        for (int j = 0; j < idFichas.length; j++){
            try{
                results2[j] = Integer.parseInt(idFichas[j]);
                }catch (Exception e){}
        }

        ArrayList<Integer> intList1 = new ArrayList<>();
        ArrayList<Integer> intList2 = new ArrayList<>();
        for (int i : results1)
        {
            intList1.add(i);
        }

        for (int i : results2)
        {
            intList2.add(i);
        }

        sala.setJogadoresID(intList1);
        sala.setFichasID(intList2);

        return sala;
    }


    public Sala selecionarSala(String nome){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T2_TABLE_NAME, new String[]{T2_COL_1, T2_COL_2,
                        T2_COL_3, T2_COL_4, T2_COL_5, T2_COL_6, T2_COL_7, T2_COL_8, T2_COL_9, T2_COL_10}, "NOME = ?", new String[]{nome},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        if (cursor == null){
            return null;
        }
        //Da erro se não achar um dado igual ao procurado //Fui um falho e não consegui ajeitar
        Sala sala = new Sala(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(8));

        sala.setNotas(cursor.getString(9));

        sala.setUri(cursor.getString(5));

        try {
            String[] idJogadores = cursor.getString(6).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
            String[] idFichas = cursor.getString(7).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
            int[] results1 = new int[idJogadores.length];
            int[] results2 = new int[idFichas.length];
            for (int i = 0; i < idJogadores.length; i++) {
                try {
                    results1[i] = Integer.parseInt(idJogadores[i]);
                } catch (Exception e) {

                }
            }

            for (int j = 0; j < idFichas.length; j++) {
                try {
                    results2[j] = Integer.parseInt(idFichas[j]);
                } catch (Exception e) {

                }
            }

            ArrayList<Integer> intList1 = new ArrayList<>();
            ArrayList<Integer> intList2 = new ArrayList<>();
            for (int i : results1)
            {
                intList1.add(i);
            }

            for (int i : results2)
            {
                intList2.add(i);
            }

            sala.setJogadoresID(intList1);
            sala.setFichasID(intList2);
        }catch (Exception e){

        }

        return sala;
    }


    public int ultimaSala(){
        int saida = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + T2_TABLE_NAME  + " ORDER BY " + T2_COL_1 + " DESC LIMIT " + 1;
        Cursor c = db.rawQuery(query, null);;
        if(c.moveToFirst())
            saida = Integer.parseInt(c.getString(0));
        c.close();

        return saida;
    }

    public List<Sala> listaSala(){
        List<Sala> lista = new ArrayList<Sala>();

        String query = "SELECT * FROM " + T2_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Sala sala = new Sala(Integer.valueOf(c.getString(0)), c.getString(1), c.getString(2), Integer.parseInt(c.getString(3)), c.getString(4), c.getString(8));
                sala.setNotas(c.getString(9));
                sala.setUri(c.getString(5));

                String[] idJogadores = c.getString(6).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
                String[] idFichas = c.getString(7).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
                int[] results1 = new int[idJogadores.length];
                int[] results2 = new int[idFichas.length];

                for (int i = 0; i < idJogadores.length; i++){
                    try{
                        results1[i] = Integer.parseInt(idJogadores[i]);
                    }catch(Exception e){

                    }
                }

                for (int j = 0; j < idFichas.length; j++){
                    try{
                        results2[j] = Integer.parseInt(idFichas[j]);
                    }catch(Exception e){

                    }
                }

                ArrayList<Integer> intList1 = new ArrayList<>();
                ArrayList<Integer> intList2 = new ArrayList<>();
                for (int i : results1)
                {
                    intList1.add(i);
                }

                for (int i : results2)
                {
                    intList2.add(i);
                }

                sala.setJogadoresID(intList1);
                sala.setFichasID(intList2);

                lista.add(sala);
            }while(c.moveToNext());
        }
        return lista;
    }

    public boolean insereDataFicha(Ficha ficha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T3_COL_2, ficha.getNomePersonagem());
        contentValues.put(T3_COL_3, ficha.getNomeJogador());
        contentValues.put(T3_COL_4, ficha.getClasseNivel());
        contentValues.put(T3_COL_5, ficha.getRaca());
        contentValues.put(T3_COL_6, ficha.getTendencia());
        contentValues.put(T3_COL_7, ficha.getDivindade());
        contentValues.put(T3_COL_8, ficha.getSexo());
        contentValues.put(T3_COL_9, ficha.getTamanho());
        contentValues.put(T3_COL_10, ficha.getAltura());
        contentValues.put(T3_COL_11, ficha.getPeso());
        contentValues.put(T3_COL_12, ficha.getIdade());
        contentValues.put(T3_COL_13, ficha.getForca());
        contentValues.put(T3_COL_14, ficha.getConstituicao());
        contentValues.put(T3_COL_15, ficha.getDestreza());
        contentValues.put(T3_COL_16, ficha.getInteligencia());
        contentValues.put(T3_COL_17, ficha.getSabedoria());
        contentValues.put(T3_COL_18, ficha.getCarisma());
        contentValues.put(T3_COL_19, ficha.getForcaMod());
        contentValues.put(T3_COL_20, ficha.getConstituicaoMod());
        contentValues.put(T3_COL_21, ficha.getDestrezaMod());
        contentValues.put(T3_COL_22, ficha.getInteligenciaMod());
        contentValues.put(T3_COL_23, ficha.getSabedoriaMod());
        contentValues.put(T3_COL_24, ficha.getCarismaMod());
        contentValues.put(T3_COL_25, ficha.getCa());
        contentValues.put(T3_COL_26, ficha.getCaOutros());
        contentValues.put(T3_COL_27, ficha.getCaToque());
        contentValues.put(T3_COL_28, ficha.getCaSurpresa());
        contentValues.put(T3_COL_29, ficha.getArmadura());
        contentValues.put(T3_COL_30, ficha.getArmaduraNatural());
        contentValues.put(T3_COL_31, ficha.getPv());
        contentValues.put(T3_COL_32, ficha.getReducaoDeDano());
        contentValues.put(T3_COL_33, ficha.getIniciativa());
        contentValues.put(T3_COL_34, ficha.getIniciativaOutros());
        contentValues.put(T3_COL_35, ficha.getFortitude());
        contentValues.put(T3_COL_36, ficha.getFortitudeOutros());
        contentValues.put(T3_COL_37, ficha.getFortitudeBase());
        contentValues.put(T3_COL_38, ficha.getReflexo());
        contentValues.put(T3_COL_39, ficha.getReflexoOutros());
        contentValues.put(T3_COL_40, ficha.getReflexoBase());
        contentValues.put(T3_COL_41, ficha.getVontade());
        contentValues.put(T3_COL_42, ficha.getVontadeOutros());
        contentValues.put(T3_COL_43, ficha.getVontadeBase());
        contentValues.put(T3_COL_44, ficha.getBba());
        contentValues.put(T3_COL_45, ficha.getResMagica());
        contentValues.put(T3_COL_46, ficha.getDeslocamento());
        contentValues.put(T3_COL_47, ficha.getAgarrar());
        contentValues.put(T3_COL_48, ficha.getAgarrarOutros());
        contentValues.put(T3_COL_49, ficha.getPc());
        contentValues.put(T3_COL_50, ficha.getPp());
        contentValues.put(T3_COL_51, ficha.getPo());
        contentValues.put(T3_COL_52, ficha.getPl());
        contentValues.put(T3_COL_53, ficha.getXp());
        contentValues.put(T3_COL_54, ficha.getXpNecessario());
        contentValues.put(T3_COL_55, ficha.getIdiomas());
        contentValues.put(T3_COL_56, ficha.getInventario());
        contentValues.put(T3_COL_57, ficha.getAtaques());
        contentValues.put(T3_COL_58, ficha.getArmaEquip());
        contentValues.put(T3_COL_59, ficha.getArmaduraEquip());
        contentValues.put(T3_COL_60, ficha.getOutrosEquip());
        contentValues.put(T3_COL_61, ficha.getCarctClasse());
        contentValues.put(T3_COL_62, ficha.getTalentos());
        contentValues.put(T3_COL_63, ficha.getMagias());
        contentValues.put(T3_COL_64, ficha.getImagem());

        long result = db.insert(T3_TABLE_NAME, null, contentValues);
        if(result == -1){
            return  false;
        }else{
            return true;
        }
    }

    public Cursor getAllDataFicha(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + T3_TABLE_NAME, null ); // "*" represental ALL, esse metedo ta mandando selecionar tudo quem tem na tabela.
        return res;
    }

    public boolean updateDataFicha(Ficha ficha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T3_COL_1, ficha.getId());
        contentValues.put(T3_COL_2, ficha.getNomePersonagem());
        contentValues.put(T3_COL_3, ficha.getNomeJogador());
        contentValues.put(T3_COL_4, ficha.getClasseNivel());
        contentValues.put(T3_COL_5, ficha.getRaca());
        contentValues.put(T3_COL_6, ficha.getTendencia());
        contentValues.put(T3_COL_7, ficha.getDivindade());
        contentValues.put(T3_COL_8, ficha.getSexo());
        contentValues.put(T3_COL_9, ficha.getTamanho());
        contentValues.put(T3_COL_10, ficha.getAltura());
        contentValues.put(T3_COL_11, ficha.getPeso());
        contentValues.put(T3_COL_12, ficha.getIdade());
        contentValues.put(T3_COL_13, ficha.getForca());
        contentValues.put(T3_COL_14, ficha.getConstituicao());
        contentValues.put(T3_COL_15, ficha.getDestreza());
        contentValues.put(T3_COL_16, ficha.getInteligencia());
        contentValues.put(T3_COL_17, ficha.getSabedoria());
        contentValues.put(T3_COL_18, ficha.getCarisma());
        contentValues.put(T3_COL_19, ficha.getForcaMod());
        contentValues.put(T3_COL_20, ficha.getConstituicaoMod());
        contentValues.put(T3_COL_21, ficha.getDestrezaMod());
        contentValues.put(T3_COL_22, ficha.getInteligenciaMod());
        contentValues.put(T3_COL_23, ficha.getSabedoriaMod());
        contentValues.put(T3_COL_24, ficha.getCarismaMod());
        contentValues.put(T3_COL_25, ficha.getCa());
        contentValues.put(T3_COL_26, ficha.getCaOutros());
        contentValues.put(T3_COL_27, ficha.getCaToque());
        contentValues.put(T3_COL_28, ficha.getCaSurpresa());
        contentValues.put(T3_COL_29, ficha.getArmadura());
        contentValues.put(T3_COL_30, ficha.getArmaduraNatural());
        contentValues.put(T3_COL_31, ficha.getPv());
        contentValues.put(T3_COL_32, ficha.getReducaoDeDano());
        contentValues.put(T3_COL_33, ficha.getIniciativa());
        contentValues.put(T3_COL_34, ficha.getIniciativaOutros());
        contentValues.put(T3_COL_35, ficha.getFortitude());
        contentValues.put(T3_COL_36, ficha.getFortitudeOutros());
        contentValues.put(T3_COL_37, ficha.getFortitudeBase());
        contentValues.put(T3_COL_38, ficha.getReflexo());
        contentValues.put(T3_COL_39, ficha.getReflexoOutros());
        contentValues.put(T3_COL_40, ficha.getReflexoBase());
        contentValues.put(T3_COL_41, ficha.getVontade());
        contentValues.put(T3_COL_42, ficha.getVontadeOutros());
        contentValues.put(T3_COL_43, ficha.getVontadeBase());
        contentValues.put(T3_COL_44, ficha.getBba());
        contentValues.put(T3_COL_45, ficha.getResMagica());
        contentValues.put(T3_COL_46, ficha.getDeslocamento());
        contentValues.put(T3_COL_47, ficha.getAgarrar());
        contentValues.put(T3_COL_48, ficha.getAgarrarOutros());
        contentValues.put(T3_COL_49, ficha.getPc());
        contentValues.put(T3_COL_50, ficha.getPp());
        contentValues.put(T3_COL_51, ficha.getPo());
        contentValues.put(T3_COL_52, ficha.getPl());
        contentValues.put(T3_COL_53, ficha.getXp());
        contentValues.put(T3_COL_54, ficha.getXpNecessario());
        contentValues.put(T3_COL_55, ficha.getIdiomas());
        contentValues.put(T3_COL_56, ficha.getInventario());
        contentValues.put(T3_COL_57, ficha.getAtaques());
        contentValues.put(T3_COL_58, ficha.getArmaEquip());
        contentValues.put(T3_COL_59, ficha.getArmaduraEquip());
        contentValues.put(T3_COL_60, ficha.getOutrosEquip());
        contentValues.put(T3_COL_61, ficha.getCarctClasse());
        contentValues.put(T3_COL_62, ficha.getTalentos());
        contentValues.put(T3_COL_63, ficha.getMagias());
        contentValues.put(T3_COL_64, ficha.getImagem());
        db.update(T3_TABLE_NAME, contentValues, "ID = ?", new String[]{String.valueOf(ficha.getId())});
        return true;
    }

    public Integer deleteDataFicha(Ficha ficha){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(T3_TABLE_NAME, "ID = ?", new String[]{String.valueOf(ficha.getId())}); //esse metodo retorna um inteiro, se fori deletado é 1 se não foi é 0

    }



    public Ficha selecionarFicha(int ID){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T3_TABLE_NAME, new String[]{T3_COL_1, T3_COL_2,
                        T3_COL_3, T3_COL_4, T3_COL_5, T3_COL_6, T3_COL_7, T3_COL_8, T3_COL_9, T3_COL_10, T3_COL_11, T3_COL_12, T3_COL_13, T3_COL_14, T3_COL_15, T3_COL_16,
                        T3_COL_17, T3_COL_18, T3_COL_19, T3_COL_20, T3_COL_21, T3_COL_22, T3_COL_23, T3_COL_24, T3_COL_25, T3_COL_26, T3_COL_27, T3_COL_28, T3_COL_29, T3_COL_30,
                        T3_COL_31, T3_COL_32, T3_COL_33, T3_COL_34, T3_COL_35, T3_COL_36, T3_COL_37, T3_COL_38, T3_COL_39, T3_COL_40, T3_COL_41, T3_COL_42, T3_COL_43, T3_COL_44,
                        T3_COL_45, T3_COL_46, T3_COL_47, T3_COL_48, T3_COL_49, T3_COL_50, T3_COL_51, T3_COL_52, T3_COL_53, T3_COL_54, T3_COL_55, T3_COL_56, T3_COL_57, T3_COL_58,
                        T3_COL_59, T3_COL_60, T3_COL_61, T3_COL_62, T3_COL_63, T3_COL_64}, "ID = ?", new String[]{String.valueOf(ID)},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        System.out.println(cursor.getString(1));

        System.out.println(cursor.getString(0));
        Ficha ficha = new Ficha(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), Float.parseFloat(cursor.getString(9)), Float.parseFloat(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)),
                Integer.parseInt(cursor.getString(15)), Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)), Integer.parseInt(cursor.getString(18)),
                Integer.parseInt(cursor.getString(19)), Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)), Integer.parseInt(cursor.getString(22)),
                Integer.parseInt(cursor.getString(23)), Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)), Integer.parseInt(cursor.getString(26)),
                Integer.parseInt(cursor.getString(27)), Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)), Integer.parseInt(cursor.getString(30)),
                Integer.parseInt(cursor.getString(31)), Integer.parseInt(cursor.getString(32)), Integer.parseInt(cursor.getString(33)), Integer.parseInt(cursor.getString(34)),
                Integer.parseInt(cursor.getString(35)), Integer.parseInt(cursor.getString(36)), Integer.parseInt(cursor.getString(37)), Integer.parseInt(cursor.getString(38)),
                Integer.parseInt(cursor.getString(39)), Integer.parseInt(cursor.getString(40)), Integer.parseInt(cursor.getString(41)), Integer.parseInt(cursor.getString(42)),
                Integer.parseInt(cursor.getString(43)), Integer.parseInt(cursor.getString(44)), Integer.parseInt(cursor.getString(45)), Integer.parseInt(cursor.getString(46)),
                Integer.parseInt(cursor.getString(47)), Integer.parseInt(cursor.getString(48)), Integer.parseInt(cursor.getString(49)), Integer.parseInt(cursor.getString(50)),
                Integer.parseInt(cursor.getString(51)), Integer.parseInt(cursor.getString(52)), Integer.parseInt(cursor.getString(53)), cursor.getString(54), cursor.getString(55),
                cursor.getString(56), cursor.getString(57), cursor.getString(58), cursor.getString(59), cursor.getString(60), cursor.getString(61), cursor.getString(62));

        byte[] img = cursor.getBlob(63);
        ficha.setImagem(img);

        return ficha;
    }


    public Ficha selecionarFicha(String nomepersonagem){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(T3_TABLE_NAME, new String[]{T3_COL_1, T3_COL_2,
                        T3_COL_3, T3_COL_4, T3_COL_5, T3_COL_6, T3_COL_7, T3_COL_8, T3_COL_9, T3_COL_10, T3_COL_11, T3_COL_12, T3_COL_13, T3_COL_14, T3_COL_15, T3_COL_16,
                        T3_COL_17, T3_COL_18, T3_COL_19, T3_COL_20, T3_COL_21, T3_COL_22, T3_COL_23, T3_COL_24, T3_COL_25, T3_COL_26, T3_COL_27, T3_COL_28, T3_COL_29, T3_COL_30,
                        T3_COL_31, T3_COL_32, T3_COL_33, T3_COL_34, T3_COL_35, T3_COL_36, T3_COL_37, T3_COL_38, T3_COL_39, T3_COL_40, T3_COL_41, T3_COL_42, T3_COL_43, T3_COL_44,
                        T3_COL_45, T3_COL_46, T3_COL_47, T3_COL_48, T3_COL_49, T3_COL_50, T3_COL_51, T3_COL_52, T3_COL_53, T3_COL_54, T3_COL_55, T3_COL_56, T3_COL_57, T3_COL_58,
                        T3_COL_59, T3_COL_60, T3_COL_61, T3_COL_62, T3_COL_63, T3_COL_64}, "NOMEPERSONAGEM = ?", new String[]{nomepersonagem},
                null, null, null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        if (cursor == null){
            return null;
        }
        //Da erro se não achar um dado igual ao procurado //Fui um falho e não consegui ajeitar

        Ficha ficha = new Ficha(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), Float.parseFloat(cursor.getString(9)), Float.parseFloat(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)),
                Integer.parseInt(cursor.getString(15)), Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)), Integer.parseInt(cursor.getString(18)),
                Integer.parseInt(cursor.getString(19)), Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)), Integer.parseInt(cursor.getString(22)),
                Integer.parseInt(cursor.getString(23)), Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)), Integer.parseInt(cursor.getString(26)),
                Integer.parseInt(cursor.getString(27)), Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)), Integer.parseInt(cursor.getString(30)),
                Integer.parseInt(cursor.getString(31)), Integer.parseInt(cursor.getString(32)), Integer.parseInt(cursor.getString(33)), Integer.parseInt(cursor.getString(34)),
                Integer.parseInt(cursor.getString(35)), Integer.parseInt(cursor.getString(36)), Integer.parseInt(cursor.getString(37)), Integer.parseInt(cursor.getString(38)),
                Integer.parseInt(cursor.getString(39)), Integer.parseInt(cursor.getString(40)), Integer.parseInt(cursor.getString(41)), Integer.parseInt(cursor.getString(42)),
                Integer.parseInt(cursor.getString(43)), Integer.parseInt(cursor.getString(44)), Integer.parseInt(cursor.getString(45)), Integer.parseInt(cursor.getString(46)),
                Integer.parseInt(cursor.getString(47)), Integer.parseInt(cursor.getString(48)), Integer.parseInt(cursor.getString(49)), Integer.parseInt(cursor.getString(50)),
                Integer.parseInt(cursor.getString(51)), Integer.parseInt(cursor.getString(52)), Integer.parseInt(cursor.getString(53)), cursor.getString(54), cursor.getString(55),
                cursor.getString(56), cursor.getString(57), cursor.getString(58), cursor.getString(59), cursor.getString(60), cursor.getString(61), cursor.getString(62));

        byte[] img = cursor.getBlob(63);
        ficha.setImagem(img);

        return ficha;
    }

    public int ultimaFicha(){
        int saida = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + T3_TABLE_NAME  + " ORDER BY " + T3_COL_1 + " DESC LIMIT " + 1;
        Cursor c = db.rawQuery(query, null);;
        if(c.moveToFirst())
            saida = Integer.parseInt(c.getString(0));
        c.close();

        return saida;
    }


    public List<Ficha> listaFicha(){
        List<Ficha> lista = new ArrayList<Ficha>();

        String query = "SELECT * FROM " + T3_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Ficha ficha = new Ficha(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), Float.parseFloat(cursor.getString(9)), Float.parseFloat(cursor.getString(10)),
                        Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)),
                        Integer.parseInt(cursor.getString(15)), Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)), Integer.parseInt(cursor.getString(18)),
                        Integer.parseInt(cursor.getString(19)), Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)), Integer.parseInt(cursor.getString(22)),
                        Integer.parseInt(cursor.getString(23)), Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)), Integer.parseInt(cursor.getString(26)),
                        Integer.parseInt(cursor.getString(27)), Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)), Integer.parseInt(cursor.getString(30)),
                        Integer.parseInt(cursor.getString(31)), Integer.parseInt(cursor.getString(32)), Integer.parseInt(cursor.getString(33)), Integer.parseInt(cursor.getString(34)),
                        Integer.parseInt(cursor.getString(35)), Integer.parseInt(cursor.getString(36)), Integer.parseInt(cursor.getString(37)), Integer.parseInt(cursor.getString(38)),
                        Integer.parseInt(cursor.getString(39)), Integer.parseInt(cursor.getString(40)), Integer.parseInt(cursor.getString(41)), Integer.parseInt(cursor.getString(42)),
                        Integer.parseInt(cursor.getString(43)), Integer.parseInt(cursor.getString(44)), Integer.parseInt(cursor.getString(45)), Integer.parseInt(cursor.getString(46)),
                        Integer.parseInt(cursor.getString(47)), Integer.parseInt(cursor.getString(48)), Integer.parseInt(cursor.getString(49)), Integer.parseInt(cursor.getString(50)),
                        Integer.parseInt(cursor.getString(51)), Integer.parseInt(cursor.getString(52)), Integer.parseInt(cursor.getString(53)), cursor.getString(54), cursor.getString(55),
                        cursor.getString(56), cursor.getString(57), cursor.getString(58), cursor.getString(59), cursor.getString(60), cursor.getString(61), cursor.getString(62));

                byte[] img = cursor.getBlob(63);
                ficha.setImagem(img);

                lista.add(ficha);
            }while(cursor.moveToNext());
        }
        return lista;
    }


}

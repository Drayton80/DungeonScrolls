package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.commands.EventosFicha;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();     // Objeto da classe DialogFragmentCreator aonde estão ferramentas para criar Dialog Fragments
    AlertDialog dialog;
    AlertDialog dialogCamera;
    DialogFragmentCreator geraDialogCamera = new DialogFragmentCreator();
    ActivitySheetBinding binding;
    Usuario usuarioLogado;
    Sala salaUsada;
    Ficha fichaUsada;
    FichaModel fichaModel;
    Intent extra;
    SQLite sqLite;
    int[] salasID, fichasID;
    ImageView campoImagem;
    boolean pegoFoto = false;
    StorageReference storage;
    Uri buffer;
    Boolean mestre = false;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.sheet_drawer_menu);
        toggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.common_open_on_phone, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.design_navigation_view_3);

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }

        sqLite = new SQLite(this);
        sqLite.atualizaDataFicha(this);
        sqLite.atualizaDataUsuario(this);
        sqLite.atualizaDataSala(this);
        campoImagem = (ImageView) findViewById(R.id.imageView);
        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");
        mestre = extra.getBooleanExtra("mestre", mestre);
        try {
            Picasso.get().load(Uri.parse(fichaUsada.getImagem())).into(campoImagem);
        } catch (Exception e) {
        }

        storage = FirebaseStorage.getInstance().getReference();

        binding.setFichaElementos(new FichaModel(fichaUsada));
        if (fichaUsada.getImagem() != null) {
            Picasso.get().load(Uri.parse(fichaUsada.getImagem())).into(binding.imageView);
        }

        binding.setFichaButtons(new EventosFicha() {
            @Override
            public void onClickAparencia() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetAppearanceActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickCombate() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetBattleInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickTalentosPericias() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetFeatsSkillsActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickEquipamentos() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetEquipmentItensActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickInfoMagias() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetMagicInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                extra.putExtra("mestre", mestre);
                startActivity(extra);
            }

            @Override
            public void onClickPropriedadesEspeciais() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                extra = new Intent(SheetActivity.this, SheetSpecialPropertiesActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                extra.putExtra("mestre", mestre);
                startActivity(extra);
            }

            @Override
            public void onClickSalvarFicha() {


                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SheetActivity.this, loadingCircleDialog);

                fichaUsada.setNomePersonagem(binding.getFichaElementos().nomePersonagem);
                fichaUsada.setIdade(binding.getFichaElementos().idade);
                fichaUsada.setXp(binding.getFichaElementos().xp);
                fichaUsada.setRaca(binding.getFichaElementos().raca);
                fichaUsada.setClasseNivel(binding.getFichaElementos().classeNivel);
                fichaUsada.setForca(binding.getFichaElementos().forca);
                fichaUsada.setDestreza(binding.getFichaElementos().destreza);
                fichaUsada.setConstituicao(binding.getFichaElementos().constituicao);
                fichaUsada.setSabedoria(binding.getFichaElementos().sabedoria);
                fichaUsada.setInteligencia(binding.getFichaElementos().inteligencia);
                fichaUsada.setCarisma(binding.getFichaElementos().carisma);
                fichaUsada.setFortitude(binding.getFichaElementos().fortitude);
                fichaUsada.setFortitudeBase(binding.getFichaElementos().fortitudeBase);
                fichaUsada.setFortitudeOutros(binding.getFichaElementos().fortitudeOutros);
                fichaUsada.setReflexo(binding.getFichaElementos().reflexo);
                fichaUsada.setReflexoBase(binding.getFichaElementos().reflexoBase);
                fichaUsada.setReflexoOutros(binding.getFichaElementos().reflexoOutros);
                fichaUsada.setVontade(binding.getFichaElementos().vontade);
                fichaUsada.setVontadeBase(binding.getFichaElementos().vontadeBase);
                fichaUsada.setVontadeOutros(binding.getFichaElementos().vontadeOutros);
                fichaUsada.setCarctClasse(binding.getFichaElementos().carctClasse);
                fichaUsada.setPvAtual(binding.getFichaElementos().pvAtual);
                fichaUsada.setPv(binding.getFichaElementos().pv);
                fichaUsada.setSubTipo(binding.getFichaElementos().subTipo);
                fichaUsada.setNivelDesafio(binding.getFichaElementos().nivelDesafio);
                fichaUsada.setNivelAjuste(binding.getFichaElementos().nivelAjuste);
                fichaUsada.setTipo(binding.getFichaElementos().tipo);


                Uri uri;

                if (pegoFoto) {
                    uri = buffer;
                } else {

                    uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
                }
                StorageReference path = storage.child("FotosFicha").child(uri.getLastPathSegment());
                path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        boolean foiInserido = false;
                        Uri uriCerta = taskSnapshot.getDownloadUrl();

                        fichaUsada.setImagem(uriCerta.toString());
                    }
                });

                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());

            }

            @Override
            public void onClickSalvarImagem() {

                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_photos, null);
                dialogCamera = geraDialogCamera.criaDialogFragmentLoadingCamera(SheetActivity.this, loadingCircleDialog);
                Button bt_camera = (Button) loadingCircleDialog.findViewById(R.id.bt_camera);
                Button bt_galeria = (Button) loadingCircleDialog.findViewById(R.id.bt_galeria);
                bt_camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i, 0);
                        geraDialogCamera.fechaDialogFragment(dialogCamera);
                    }
                });

                bt_galeria.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, 1);
                        geraDialogCamera.fechaDialogFragment(dialogCamera);

                    }
                });


            }
        });
    }

    @Override
    public void onBackPressed() {
        extra = new Intent(SheetActivity.this, RoomActivity.class);
        extra.putExtra("usuarioLogado", usuarioLogado);
        extra.putExtra("salaUsada", salaUsada);
        extra.putExtra("mestre", mestre);
        startActivity(extra);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {

            if (data != null) {
                Bundle bundle = data.getExtras();

                // Recupera o Bitmap retornado pela c�mera
                Bitmap bitmap = (Bitmap) bundle.get("data");
                // Atualiza a imagem na tela
                buffer = getImageUri(this, bitmap);
                campoImagem.setImageBitmap(bitmap);
                pegoFoto = true;

            }

            Uri uri;

            if (pegoFoto) {
                uri = buffer;
            } else {

                uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
            }
            StorageReference path = storage.child("FotosFicha").child(uri.getLastPathSegment());
            path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    boolean foiInserido = false;
                    Uri uriCerta = taskSnapshot.getDownloadUrl();

                    fichaUsada.setImagem(uriCerta.toString());
                    sqLite.updateDataFicha(fichaUsada);
                }
            });


        }////

        if (requestCode == 1) {

            if (data != null) {


                // Atualiza a imagem na tela
                buffer = data.getData();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(SheetActivity.this.getContentResolver(), buffer);
                } catch (IOException e) {
                    System.out.println("oush");
                }
                campoImagem.setImageBitmap(bitmap);
                pegoFoto = true;

            }

            Uri uri;

            if (pegoFoto) {
                uri = buffer;
            } else {

                uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
            }
            StorageReference path = storage.child("FotosFicha").child(uri.getLastPathSegment());
            path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    boolean foiInserido = false;
                    Uri uriCerta = taskSnapshot.getDownloadUrl();

                    fichaUsada.setImagem(uriCerta.toString());
                    sqLite.updateDataFicha(fichaUsada);
                }
            });



        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    @Override
    protected void onStop() {
        super.onStop();
        // dialog só é null antes de ser instanciado, apenas por garantia para não dar erros
        if (dialog != null) {
            // Usado para fechar o Dialog Fragment do Loading Magic Circle, é chamado no onStop() pois ele apenas ocorre quando outra activity é chamada
            // e essa sai de visualização, logo após não estar mais visível.
            geraDialog.fechaDialogFragment(dialog);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_navigationDrawer_item_listaDeSalas:
                extra = new Intent(SheetActivity.this, RoomsMenu.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                //extra.putExtra("salaUsada", salaUsada);
                //extra.putExtra("fichaUsada", fichaUsada);
                //extra.putExtra("mestre", mestre);
                startActivity(extra);
                return true;
            case R.id.menu_navigationDrawer_item_paginaPrincipal:
                extra = new Intent(SheetActivity.this, RoomActivity.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                //extra.putExtra("fichaUsada", fichaUsada);
                //extra.putExtra("mestre", mestre);
                startActivity(extra);
                return true;

            case R.id.menu_navigationDrawer_item_sairDaConta:
                extra = new Intent(SheetActivity.this, MainActivity.class);
                startActivity(extra);
                return true;

        }
        return false;
    }
}

package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.databinding.BaseObservable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;

/**
 * Created by ci on 02/04/18.
 */

public class FichaModel extends BaseObservable{
    
    public int id;
    public String nomePersonagem;
    public String nomeJogador;
    public String classeNivel;
    public String raca;
    public String tendencia;
    public String divindade;
    public String sexo;
    public String tamanho;
    public float altura;
    public float peso;
    public int idade;
    public int forca;
    public int constituicao;
    public int destreza;
    public int inteligencia;
    public int sabedoria;
    public int carisma;
    public int forcaMod;
    public int constituicaoMod;
    public int destrezaMod;
    public int inteligenciaMod;
    public int sabedoriaMod;
    public int carismaMod;
    public int ca;
    public int caOutros;
    public int caToque;
    public int caSurpresa;
    public int armadura;
    public int armaduraNatural;
    public int pv;
    public int reducaoDeDano;
    public int iniciativa;
    public int iniciativaOutros;
    public int fortitude;
    public int fortitudeOutros;
    public int fortitudeBase;
    public int reflexo;
    public int reflexoOutros;
    public int reflexoBase;
    public int vontade;
    public int vontadeOutros;
    public int vontadeBase;
    public int bba;
    public int resMagica;
    public int deslocamento;
    public int agarrar;
    public int agarrarOutros;
    public int pc;
    public int pp;
    public int po;
    public int pl;
    public int xp;
    public int xpNecessario;
    public String idiomas;
    public String inventario;
    public String ataques;
    public String armaEquip;
    public String armaduraEquip;
    public String outrosEquip;
    public String carctClasse;
    public String talentos;
    public String magias;
    public byte[] imagem;
    Bitmap imagemTest;
    
    //Pericias pericias;

    public FichaModel(){
    }

    public FichaModel (Ficha ficha) {
        this.id = ficha.getId();
        this.nomePersonagem = ficha.getNomePersonagem();
        this.nomeJogador = ficha.getNomeJogador();
        this.classeNivel = ficha.getClasseNivel();
        this.raca = ficha.getRaca();
        this.tendencia = ficha.getTendencia();
        this.divindade = ficha.getDivindade();
        this.sexo = ficha.getSexo();
        this.tamanho = ficha.getTamanho();
        this.altura = ficha.getAltura();
        this.peso = ficha.getPeso();
        this.idade = ficha.getIdade();
        this.forca = ficha.getForca();
        this.constituicao = ficha.getConstituicao();
        this.destreza = ficha.getDestreza();
        this.inteligencia = ficha.getInteligencia();
        this.sabedoria = ficha.getSabedoria();
        this.carisma = ficha.getCarisma();
        this.forcaMod = ((ficha.getForca()-10)/2);
        this.constituicaoMod = ((ficha.getConstituicao()-10)/2);
        this.destrezaMod = ((ficha.getDestreza()-10)/2);
        this.inteligenciaMod = ((ficha.getInteligencia()-10)/2);
        this.sabedoriaMod = ((ficha.getSabedoria()-10)/2);
        this.carismaMod = ((ficha.getCarisma()-10)/2);
        this.ca = ficha.getCa();
        this.caOutros = ficha.getCaOutros();
        this.caToque = ficha.getCaToque();
        this.caSurpresa = ficha.getCaSurpresa();
        this.armadura = ficha.getArmadura();
        this.armaduraNatural = ficha.getArmaduraNatural();
        this.pv = ficha.getPv();
        this.reducaoDeDano = ficha.getReducaoDeDano();
        this.iniciativa = ficha.getIniciativa();
        this.iniciativaOutros = ficha.getIniciativaOutros();
        this.fortitude = (ficha.getFortitudeBase() + ficha.getFortitudeOutros());
        this.fortitudeOutros = ficha.getFortitudeOutros();
        this.fortitudeBase = ficha.getFortitudeBase();
        this.reflexo = (ficha.getReflexoBase() + ficha.getReflexoOutros());
        this.reflexoOutros = ficha.getReflexoOutros();
        this.reflexoBase = ficha.getReflexoBase();
        this.vontade = (ficha.getVontadeBase() + ficha.getVontadeOutros());
        this.vontadeOutros = ficha.getVontadeOutros();
        this.vontadeBase = ficha.getVontadeBase();
        this.bba = ficha.getBba();
        this.resMagica = ficha.getResMagica();
        this.deslocamento = ficha.getDeslocamento();
        this.agarrar = ficha.getAgarrar();
        this.agarrarOutros = ficha.getAgarrarOutros();
        this.pc = ficha.getPc();
        this.pp = ficha.getPp();
        this.po = ficha.getPo();
        this.pl = ficha.getPl();
        this.xp = ficha.getXp();
        this.xpNecessario = ficha.getXpNecessario();
        this.idiomas = ficha.getIdiomas();
        this.inventario = ficha.getInventario();
        this.ataques = ficha.getAtaques();
        this.armaEquip = ficha.getArmaEquip();
        this.armaduraEquip = ficha.getArmaduraEquip();
        this.outrosEquip = ficha.getOutrosEquip();
        this.carctClasse = ficha.getCarctClasse();
        this.talentos = ficha.getTalentos();
        this.magias = ficha.getMagias();
        this.imagem = ficha.getImagem();
    }

    //Métodos Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
        notifyPropertyChanged(R.id.sheet_plainText_name);
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getClasseNivel() {
        return classeNivel;
    }

    public void setClasseNivel(String classeNivel) {
        this.classeNivel = classeNivel;
        notifyPropertyChanged(R.id.sheet_editText_classes);

    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {

        this.raca = raca;
        notifyPropertyChanged(R.id.sheet_editText_raca);

    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {

        this.tendencia = tendencia;
    }

    public String getDivindade() {
        return divindade;
    }

    public void setDivindade(String divindade) {
        this.divindade = divindade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getAltura() {

        return String.valueOf(altura);
    }

    public void setAltura(String altura) {
        this.altura = Float.parseFloat(altura);
    }

    public String getPeso() {
        return String.valueOf(peso);
    }

    public void setPeso(String peso) {
        this.peso = Float.parseFloat(peso);
    }

    public String getIdade() {

        return String.valueOf(idade);
    }

    public void setIdade(String idade) {
        if(idade.equals("")){
            this.idade = 0;
        }else {
            this.idade = Integer.parseInt(idade);
        }
        notifyPropertyChanged(R.id.sheet_editText_idade);
    }

    public String getForca() {
        return String.valueOf(forca);
    }

    public void setForca(String forca) {
        if(forca.equals("")){
            this.forca = 0;
        }else {
            this.forca = Integer.parseInt(forca);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesForca);
    }

    public String getConstituicao() {
        return String.valueOf(constituicao);
    }

    public void setConstituicao(String constituicao) {
        if(constituicao.equals("")){
            this.constituicao = 0;
        }else {
            this.constituicao = Integer.parseInt(constituicao);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesConstituicao);
    }

    public String getDestreza() {
        return String.valueOf(destreza);
    }

    public void setDestreza(String destreza) {
        if(destreza.equals("")){
            this.destreza = 0;
        }else {
            this.destreza = Integer.parseInt(destreza);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesDestreza);
    }

    public String getInteligencia() {return String.valueOf(inteligencia);
    }

    public void setInteligencia(String inteligencia) {
        if(inteligencia.equals("")){
            this.inteligencia = 0;
        }else {
            this.inteligencia = Integer.parseInt(inteligencia);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesInteligencia);
    }

    public String getSabedoria() {return String.valueOf(sabedoria);
    }

    public void setSabedoria(String sabedoria) {
        if(sabedoria.equals("")){
            this.sabedoria = 0;
        }else {
            this.sabedoria = Integer.parseInt(sabedoria);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesSabedoria);
    }

    public String getCarisma() {
        return String.valueOf(carisma);
    }

    public void setCarisma(String carisma) {
        if(carisma.equals("")){
            this.carisma = 0;
        }else {
            this.carisma = Integer.parseInt(carisma);
        }
        notifyPropertyChanged(R.id.sheet_editText_habilidadesCarisma);
    }

    public String getForcaMod() {

        return String.valueOf((forca -10)/2);
    }

    public void setForcaMod(String forcaMod) {

        this.forcaMod = Integer.parseInt(forcaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesForcaModificador);
    }

    public String getConstituicaoMod() {
        return String.valueOf((constituicao-10)/2);
    }

    public void setConstituicaoMod(String constituicaoMod) {

        this.constituicaoMod = Integer.parseInt(constituicaoMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesConstituicaoModificador);
    }

    public String getDestrezaMod() {
        return String.valueOf(destrezaMod);
    }

    public void setDestrezaMod(String destrezaMod) {

        this.destrezaMod = Integer.parseInt(destrezaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesDestrezaModificador);
    }

    public String getInteligenciaMod() {
        return String.valueOf(inteligenciaMod);
    }

    public void setInteligenciaMod(String inteligenciaMod) {

        this.inteligenciaMod = Integer.parseInt(inteligenciaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesInteligenciaModificador);
    }

    public String getSabedoriaMod() {
        return String.valueOf(sabedoriaMod);
    }

    public void setSabedoriaMod(String sabedoriaMod) {

        this.sabedoriaMod = Integer.parseInt(sabedoriaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesSabedoriaModificador);
    }

    public String getCarismaMod() {
        return String.valueOf(carismaMod);
    }

    public void setCarismaMod(String carismaMod) {

        this.carismaMod = Integer.parseInt(carismaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesCarismaModificador);
    }

    public String getCa() {
        return String.valueOf(ca);
    }

    public void setCa(String ca) {
        this.ca = Integer.parseInt(ca);
    }

    public String getCaOutros() {
        return String.valueOf(caOutros);
    }

    public void setCaOutros(String caOutros) {
        this.caOutros = Integer.parseInt(caOutros);
    }

    public String getCaToque() {
        return String.valueOf(caToque);
    }

    public void setCaToque(String caToque) {
        this.caToque = Integer.parseInt(caToque);
    }

    public String getCaSurpresa() {
        return String.valueOf(caSurpresa);
    }

    public void setCaSurpresa(String caSurpresa) {
        this.caSurpresa = Integer.parseInt(caSurpresa);
    }

    public String getArmadura() {
        return String.valueOf(armadura);
    }

    public void setArmadura(String armadura) {
        this.armadura = Integer.parseInt(armadura);
    }

    public String getArmaduraNatural() {
        return String.valueOf(armaduraNatural);
    }

    public void setArmaduraNatural(String armaduraNatural) {
        this.armaduraNatural = Integer.parseInt(armaduraNatural);
    }

    public String getPv() {
        return String.valueOf(pv);
    }

    public void setPv(String pv) {
        this.pv = Integer.parseInt(pv);
    }

    public String getReducaoDeDano() {
        return String.valueOf(reducaoDeDano);
    }

    public void setReducaoDeDano(String reducaoDeDano) {
        this.reducaoDeDano = Integer.parseInt(reducaoDeDano);
    }

    public String getIniciativa() {
        return String.valueOf(iniciativa);
    }

    public void setIniciativa(String iniciativa) {
        this.iniciativa = Integer.parseInt(iniciativa);
    }

    public String getIniciativaOutros() {
        return String.valueOf(iniciativaOutros);
    }

    public void setIniciativaOutros(String iniciativaOutros) {
        this.iniciativaOutros = Integer.parseInt(iniciativaOutros);
    }

    public String getFortitude() {
        return String.valueOf(fortitude);
    }

    public void setFortitude(String fortitude) {

        this.fortitude = Integer.parseInt(fortitude);
        notifyPropertyChanged(R.id.sheet_editText_resistenciasFortitudeTotal);
    }

    public String getFortitudeOutros() {
        return String.valueOf(fortitudeOutros);
    }

    public void setFortitudeOutros(String fortitudeOutros) {
        if(fortitudeOutros.equals("")){
            this.fortitudeOutros = 0;
        }else {
            this.fortitudeOutros = Integer.parseInt(fortitudeOutros);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasFortitudeOutros);
    }

    public String getFortitudeBase() {
        return String.valueOf(fortitudeBase);
    }

    public void setFortitudeBase(String fortitudeBase) {
        if(fortitudeBase.equals("")){
            this.fortitudeBase = 0;
        }else {
            this.fortitudeBase = Integer.parseInt(fortitudeBase);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasFortitudeBase);
    }

    public String getReflexo() {
        return String.valueOf(reflexo);
    }

    public void setReflexo(String reflexo) {

        this.reflexo = Integer.parseInt(reflexo);
        notifyPropertyChanged(R.id.sheet_editText_resistenciasReflexosTotal);
    }

    public String getReflexoOutros() {
        return String.valueOf(reflexoOutros);
    }

    public void setReflexoOutros(String reflexoOutros) {
        if(reflexoOutros.equals("")){
            this.reflexoOutros = 0;
        }else {
            this.reflexoOutros = Integer.parseInt(reflexoOutros);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasReflexosOutros);
    }

    public String getReflexoBase() {
        return String.valueOf(reflexoBase);
    }

    public void setReflexoBase(String reflexoBase) {
        if(reflexoBase.equals("")){
            this.reflexoBase = 0;
        }else {
            this.reflexoBase = Integer.parseInt(reflexoBase);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasReflexosOutros);
    }

    public String getVontade() {
        return String.valueOf(vontade);
    }

    public void setVontade(String vontade) {

        this.vontade = Integer.parseInt(vontade);
        notifyPropertyChanged(R.id.sheet_editText_resistenciasVontadeTotal);

    }

    public String getVontadeOutros() {
        return String.valueOf(vontadeOutros);
    }

    public void setVontadeOutros(String vontadeOutros) {
        if(vontadeOutros.equals("")){
            this.vontadeOutros = 0;
        }else {
            this.vontadeOutros = Integer.parseInt(vontadeOutros);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasVontadeOutros);
    }

    public String getVontadeBase() {
        return String.valueOf(vontadeBase);
    }

    public void setVontadeBase(String vontadeBase) {
        if(vontadeBase.equals("")){
            this.vontadeBase = 0;
        }else {
            this.vontadeBase = Integer.parseInt(vontadeBase);
        }
        notifyPropertyChanged(R.id.sheet_editText_resistenciasVontadeBase);
    }

    public String getBba() {
        return String.valueOf(bba);
    }

    public void setBba(String bba) {
        this.bba = Integer.parseInt(bba);
    }

    public String getResMagica() {
        return String.valueOf(resMagica);
    }

    public void setResMagica(String resMagica) {
        this.resMagica = Integer.parseInt(resMagica);
    }

    public String getDeslocamento() {
        return String.valueOf(deslocamento);
    }

    public void setDeslocamento(String deslocamento) {
        this.deslocamento = Integer.parseInt(deslocamento);
    }

    public String getAgarrar() {
        return String.valueOf(agarrar);
    }

    public void setAgarrar(String agarrar) {
        this.agarrar = Integer.parseInt(agarrar);
    }

    public String getAgarrarOutros() {
        return String.valueOf(agarrarOutros);
    }

    public void setAgarrarOutros(String agarrarOutros) {
        this.agarrarOutros = Integer.parseInt(agarrarOutros);
    }

    public String getPc() {
        return String.valueOf(pc);
    }

    public void setPc(String pc) {
        this.pc = Integer.parseInt(pc);
    }

    public String getPp() {
        return String.valueOf(pp);
    }

    public void setPp(String pp) {
        this.pp = Integer.parseInt(pp);
    }

    public String getPo() {
        return String.valueOf(po);
    }

    public void setPo(String po) {
        this.po = Integer.parseInt(po);
    }

    public String getPl() {
        return String.valueOf(pl);
    }

    public void setPl(String pl) {
        this.pl = Integer.parseInt(pl);
    }

    public String getXp() {
        return String.valueOf(xp);
    }

    public void setXp(String xp) {
        if(xp.equals("")){
            this.xp = 0;
        }else {
            this.xp = Integer.parseInt(xp);
        }
        notifyPropertyChanged(R.id.sheet_editText_experiencia);
    }

    public String getXpNecessario() {
        return String.valueOf(xpNecessario);
    }

    public void setXpNecessario(String xpNecessario) {
        this.xpNecessario = Integer.parseInt(xpNecessario);
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getAtaques() {
        return ataques;
    }

    public void setAtaques(String ataques) {
        this.ataques = ataques;
    }

    public String getArmaEquip() {
        return armaEquip;
    }

    public void setArmaEquip(String armaEquip) {
        this.armaEquip = armaEquip;
    }

    public String getArmaduraEquip() {
        return armaduraEquip;
    }

    public void setArmaduraEquip(String armaduraEquip) {
        this.armaduraEquip = armaduraEquip;
    }

    public String getOutrosEquip() {
        return outrosEquip;
    }

    public void setOutrosEquip(String outrosEquip) {
        this.outrosEquip = outrosEquip;
    }

    public String getCarctClasse() {
        return carctClasse;
    }

    public void setCarctClasse(String carctClasse) {
        this.carctClasse = carctClasse;
    }

    public String getTalentos() {
        return talentos;
    }

    public void setTalentos(String talentos) {
        this.talentos = talentos;
    }

    public String getMagias() {
        return magias;
    }

    public void setMagias(String magias) {
        this.magias = magias;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Bitmap getBitmap() {
        if(imagem == null){
            return null;
        }
        // Cria o Bitmap necess�rio para exibir no ImageView
        Bitmap bitmap = BitmapFactory.decodeByteArray(imagem, 0, imagem.length);
        return bitmap;
    }

    public Bitmap getImagemTest() {
        return imagemTest;
    }

    public void setImagemTest(Bitmap imagemTest) {
        this.imagemTest = imagemTest;
    }


    public ArrayList<FichaModel> getArrayListaFicha(int[] fichasID, SQLite sqLite){

        ArrayList<FichaModel> fichaModelArrayList = new ArrayList<>();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + Arrays.toString(fichasID));

        for (int i = 0; i < fichasID.length; i++){
            if(fichasID[i] == 0){}
            else {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + i);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fichasID[i]);
                FichaModel fichaModel = new FichaModel(sqLite.selecionarFicha(fichasID[i]));
                fichaModelArrayList.add(fichaModel);
            }
        }

        return fichaModelArrayList;
    }
}

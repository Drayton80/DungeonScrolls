package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.databinding.BaseObservable;
import android.net.Uri;

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
    public Uri imagem;
    public String pericias;
    public int pvAtual; //lembrar de botas em todo lugar;
    public int resistenciaNatural;
    public float pesoTotal;
    public float pesoMax;
    public String descricaoAparencia;
    public String testeResistencia;
    public String chanceFalha;
    public String numeroMagias;
    public String escolhaEspecializada;
    public String qualiEspeciais;
    public String habiEspeciais;
    


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
        this.ca = (10 + ficha.getArmadura() + ficha.getArmaduraNatural() + ficha.getCaOutros() + ficha.getDestrezaMod());
        this.caOutros = ficha.getCaOutros();
        this.caToque = (10 + ficha.getDestrezaMod());
        this.caSurpresa = (10 + ficha.getArmadura() + ficha.getArmaduraNatural());
        this.armadura = ficha.getArmadura();
        this.armaduraNatural = ficha.getArmaduraNatural();
        this.pv = ficha.getPv();
        this.reducaoDeDano = ficha.getReducaoDeDano();
        this.iniciativa = (ficha.getDestrezaMod() + ficha.getIniciativaOutros());
        this.iniciativaOutros = ficha.getIniciativaOutros();
        this.fortitude = (ficha.getFortitudeBase() + ficha.getFortitudeOutros() + ficha.getConstituicaoMod());
        this.fortitudeOutros = ficha.getFortitudeOutros();
        this.fortitudeBase = ficha.getFortitudeBase();
        this.reflexo = (ficha.getReflexoBase() + ficha.getReflexoOutros() + ficha.getDestrezaMod());
        this.reflexoOutros = ficha.getReflexoOutros();
        this.reflexoBase = ficha.getReflexoBase();
        this.vontade = (ficha.getVontadeBase() + ficha.getVontadeOutros() + ficha.getSabedoriaMod());
        this.vontadeOutros = ficha.getVontadeOutros();
        this.vontadeBase = ficha.getVontadeBase();
        this.bba = ficha.getBba();
        this.resMagica = ficha.getResMagica();
        this.deslocamento = ficha.getDeslocamento();
        this.agarrar = (ficha.getForcaMod() + ficha.getAgarrarOutros() + ficha.getBba());
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
        try {
            this.imagem = Uri.parse(ficha.getImagem());
        }catch (Exception e){}
        this.pericias = ficha.getPericias();
        this.pvAtual = ficha.getPvAtual();
        this.resistenciaNatural = ficha.getResistenciaNatural();
        this.pesoTotal = ficha.getPesoTotal();
        this.pesoMax = ficha.getPesoMax();
        this.descricaoAparencia = ficha.getDescricaoAparencia();
        this.testeResistencia = ficha.getTesteResistencia();
        this.chanceFalha = ficha.getChanceFalha();
        this.numeroMagias = ficha.getNumeroMagias();
        this.escolhaEspecializada = ficha.getEscolhaEspecializada();
        this.qualiEspeciais = ficha.getQualiEspeciais();
        this.habiEspeciais = ficha.getHabiEspeciais();

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
        notifyPropertyChanged(R.id.sheetAp_editText_inclination);
    }

    public String getDivindade() {
        return divindade;
    }

    public void setDivindade(String divindade) {
        this.divindade = divindade;
        notifyPropertyChanged(R.id.sheetAp_editText_divinity);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
        notifyPropertyChanged(R.id.sheetAp_editText_gender);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
        notifyPropertyChanged(R.id.sheetAp_editText_size);
    }

    public String getAltura() {

        return String.valueOf(altura);
    }

    public void setAltura(String altura) {
        if(altura.equals("")){
            this.altura = 0;
        }else if(altura.equals(".")){
            this.altura = 0;
        }else{
            this.altura = Float.parseFloat(altura);
        }
        notifyPropertyChanged(R.id.sheetAp_editText_height);
    }

    public String getPeso() {
        return String.valueOf(peso);
    }

    public void setPeso(String peso) {
        if(peso.equals("")){
            this.peso = 0;
        }else if(peso.equals(".")){
            this.peso = 0;
        }else{
            this.peso = Float.parseFloat(peso);
        }
        notifyPropertyChanged(R.id.sheetAp_editText_weight);
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

        return String.valueOf((forca - 10)/2);
    }

    public void setForcaMod(String forcaMod) {

        this.forcaMod = Integer.parseInt(forcaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesForcaModificador);
        notifyPropertyChanged(R.id.sheetBI_editText_agarrarForca);
    }

    public String getConstituicaoMod() {

        return String.valueOf((constituicao - 10)/2);
    }

    public void setConstituicaoMod(String constituicaoMod) {

        this.constituicaoMod = Integer.parseInt(constituicaoMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesConstituicaoModificador);
    }

    public String getDestrezaMod() {

        return String.valueOf((destreza - 10)/2);
    }

    public void setDestrezaMod(String destrezaMod) {

        this.destrezaMod = Integer.parseInt(destrezaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesDestrezaModificador);
        notifyPropertyChanged(R.id.sheetBI_editText_iniciativaDestreza);
    }

    public String getInteligenciaMod() {

        return String.valueOf((inteligencia - 10)/2);
    }

    public void setInteligenciaMod(String inteligenciaMod) {

        this.inteligenciaMod = Integer.parseInt(inteligenciaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesInteligenciaModificador);
    }

    public String getSabedoriaMod() {

        return String.valueOf((sabedoria - 10)/2);
    }

    public void setSabedoriaMod(String sabedoriaMod) {

        this.sabedoriaMod = Integer.parseInt(sabedoriaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesSabedoriaModificador);
    }

    public String getCarismaMod() {

        return String.valueOf((carisma - 10)/2);
    }

    public void setCarismaMod(String carismaMod) {
        this.carismaMod = Integer.parseInt(carismaMod);
        notifyPropertyChanged(R.id.sheet_editText_habilidadesCarismaModificador);
    }

    public String getCa() {
        if((10 + (armadura + armaduraNatural + caOutros + destrezaMod)) < 10){
            return String.valueOf(10);

        }else{
            return String.valueOf(10 + (armadura + armaduraNatural + caOutros + destrezaMod));

        }
    }

    public void setCa(String ca) {
        if(ca.equals("")){
            this.ca = 10;
        }else{
            this.ca = Integer.parseInt(ca);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_caNormal);
    }

    public String getCaOutros() {
        return String.valueOf(caOutros);
    }

    public void setCaOutros(String caOutros) {
        if(caOutros.equals("")){
            this.caOutros = 0;
        }else if(caOutros.equals("-")){
            this.caOutros = 0;
        }else{
            this.caOutros = Integer.parseInt(caOutros);

        }
        notifyPropertyChanged(R.id.sheetBI_editText_caOutros);
    }

    public String getCaToque() {

        return String.valueOf(10 + destrezaMod);
    }

    public void setCaToque(String caToque) {
        if(caToque.equals("")){
            this.caToque = 0;
        }else{
            this.caToque = Integer.parseInt(caToque);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_caToque);

    }

    public String getCaSurpresa() {
        return String.valueOf(10 + armadura + armaduraNatural);
    }

    public void setCaSurpresa(String caSurpresa) {
        if(caSurpresa.equals("")){
            this.caSurpresa = 0;
        }else{
            this.caSurpresa = Integer.parseInt(caSurpresa);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_caSurpresa);
    }

    public String getArmadura() {
        return String.valueOf(armadura);
    }

    public void setArmadura(String armadura) {
        if(armadura.equals("")){
            this.armadura = 0;
        }else{
            this.armadura = Integer.parseInt(armadura);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_caArmadura);
    }

    public String getArmaduraNatural() {
        return String.valueOf(armaduraNatural);
    }

    public void setArmaduraNatural(String armaduraNatural) {
        if(armaduraNatural.equals("")){
            this.armaduraNatural = 0;
        }else{
            this.armaduraNatural = Integer.parseInt(armaduraNatural);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_caNatural);
    }

    public String getPv() {
        return String.valueOf(pv);
    }

    public void setPv(String pv) {
        if(pv.equals("")){
            this.pv = 0;
        }else{
            this.pv = Integer.parseInt(pv);
        }
        //notifyPropertyChanged(R.id.sheetBI_editText_pvTotal);
    }

    public String getReducaoDeDano() {
        return String.valueOf(reducaoDeDano);
    }

    public void setReducaoDeDano(String reducaoDeDano) {
        if(reducaoDeDano.equals("")){
            this.reducaoDeDano = 0;
        }else{
            this.reducaoDeDano = Integer.parseInt(reducaoDeDano);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_reducaoDeDano);

    }

    public String getIniciativa() {

        return String.valueOf((destrezaMod + iniciativaOutros));
    }

    public void setIniciativa(String iniciativa) {
        if(iniciativa.equals("")){
            this.iniciativa = 0;
        }else{
            this.iniciativa = Integer.parseInt(iniciativa);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_iniciativa);
    }

    public String getIniciativaOutros() {
        return String.valueOf(iniciativaOutros);
    }

    public void setIniciativaOutros(String iniciativaOutros) {
        if(iniciativaOutros.equals("")){
            this.iniciativaOutros = 0;
        }else if(iniciativaOutros.equals("-")){
            this.iniciativaOutros = 0;
        }else{
            this.iniciativaOutros = Integer.parseInt(iniciativaOutros);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_iniciativaOutros);
    }

    public String getFortitude() {

        return String.valueOf((fortitudeBase + fortitudeOutros + constituicaoMod));
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
        }else if(fortitudeOutros.equals("-")){
            this.fortitudeOutros = 0;
        }else{
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

        return String.valueOf((reflexoBase + reflexoOutros + destrezaMod));
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
        }else if(reflexoOutros.equals("-")){
            this.reflexoOutros = 0;
        }else{
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

    public String getVontade()
    {
        return String.valueOf((vontadeBase + vontadeOutros + sabedoriaMod));
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
        }else if(vontadeOutros.equals("-")){
            this.vontadeOutros = 0;
        }else{
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
        if(bba.equals("")){
            this.bba = 0;
        }else{
            this.bba = Integer.parseInt(bba);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_bba);
    }

    public String getResMagica() {
        return String.valueOf(resMagica);
    }

    public void setResMagica(String resMagica) {
        if(resMagica.equals("")){
            this.resMagica = 0;
        }else{
            this.resMagica = Integer.parseInt(resMagica);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_resistenciaMagica);
    }

    public String getDeslocamento() {
        return String.valueOf(deslocamento);
    }

    public void setDeslocamento(String deslocamento) {
        if(deslocamento.equals("")){
            this.deslocamento = 0;
        }else{
            this.deslocamento = Integer.parseInt(deslocamento);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_deslocamento);
    }

    public String getAgarrar() {

        return String.valueOf((forcaMod + agarrarOutros + bba));
    }

    public void setAgarrar(String agarrar) {
        if(agarrar.equals("")){
            this.agarrar = 0;
        }else{
            this.agarrar = Integer.parseInt(agarrar);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_agarrar);
    }

    public String getAgarrarOutros() {
        return String.valueOf(agarrarOutros);
    }

    public void setAgarrarOutros(String agarrarOutros) {
        if(agarrarOutros.equals("")){
            this.agarrarOutros = 0;
        }else if(agarrarOutros.equals("-")){
            this.agarrarOutros = 0;
        }else{
            this.agarrarOutros = Integer.parseInt(agarrarOutros);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_agarrarOutros);
    }

    public String getPc() {
        return String.valueOf(pc);
    }

    public void setPc(String pc) {
        if(pc.equals("")){
            this.pc = 0;
        }else {
            this.pc = Integer.parseInt(pc);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_pc);
    }

    public String getPp() {
        return String.valueOf(pp);
    }

    public void setPp(String pp) {
        if(pp.equals("")){
            this.pp = 0;
        }else {
            this.pp = Integer.parseInt(pp);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_pp);
    }

    public String getPo() {
        return String.valueOf(po);
    }

    public void setPo(String po) {
        if(po.equals("")){
            this.po = 0;
        }else {
            this.po = Integer.parseInt(po);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_po);
    }

    public String getPl() {
        return String.valueOf(pl);
    }

    public void setPl(String pl) {
        if(pl.equals("")){
            this.pl = 0;
        }else {
            this.pl = Integer.parseInt(pl);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_pl);
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
        notifyPropertyChanged(R.id.sheetAp_editText_languages);
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
        notifyPropertyChanged(R.id.sheetEI_editText_itens);
    }

    public String getAtaques() {
        return ataques;
    }

    public void setAtaques(String ataques) {

        this.ataques = ataques;
        notifyPropertyChanged(R.id.sheetBI_editText_attacks);
    }

    public String getArmaEquip() {
        return armaEquip;
    }

    public void setArmaEquip(String armaEquip) {

        this.armaEquip = armaEquip;
        notifyPropertyChanged(R.id.sheetEI_editText_weapons);
    }

    public String getArmaduraEquip() {
        return armaduraEquip;
    }

    public void setArmaduraEquip(String armaduraEquip) {

        this.armaduraEquip = armaduraEquip;
        notifyPropertyChanged(R.id.sheetEI_editText_armor);
    }

    public String getOutrosEquip() {
        return outrosEquip;
    }

    public void setOutrosEquip(String outrosEquip) {

        this.outrosEquip = outrosEquip;
        notifyPropertyChanged(R.id.sheetEI_editText_protectionItem);
    }

    public String getCarctClasse() {
        return carctClasse;
    }

    public void setCarctClasse(String carctClasse) {

        this.carctClasse = carctClasse;
        notifyPropertyChanged(R.id.sheet_editText_nivel);
    }

    public String getTalentos() {
        return talentos;
    }

    public void setTalentos(String talentos) {
        this.talentos = talentos;
        notifyPropertyChanged(R.id.sheetFS_editText_telentos);
    }

    public String getMagias() {
        return magias;
    }

    public void setMagias(String magias) {

        this.magias = magias;
        notifyPropertyChanged(R.id.sheetMI_editText_numeroMagiasPorDia3);
    }


    public Uri getImagem() {
        return imagem;
    }

    public void setImagem(Uri imagem) {
        this.imagem = imagem;
    }

    public String getPericias() {
        return pericias;
    }

    public void setPericias(String pericias) {

        this.pericias = pericias;
        notifyPropertyChanged(R.id.sheetFS_editText_pericias);
    }

    public String getPvAtual() {
        return String.valueOf(pvAtual);
    }

    public void setPvAtual(String pvAtual) {

        if(pvAtual.equals("")){
            this.pvAtual = 0;
        }else if(pvAtual.equals("-")){
            this.pvAtual = 0;
        }else{
            this.pvAtual = Integer.parseInt(pvAtual);
        }
        //notifyPropertyChanged(R.id.sheetBI_editText_pvAtual);
    }

    public String getResistenciaNatural() {
        return String.valueOf(resistenciaNatural);
    }

    public void setResistenciaNatural(String resistenciaNatural) {
        if(resistenciaNatural.equals("")){
            this.resistenciaNatural = 0;
        }else {
            this.resistenciaNatural = Integer.parseInt(resistenciaNatural);
        }
        notifyPropertyChanged(R.id.sheetBI_editText_resistenciasElementais);
    }

    public String getPesoTotal() {
        return String.valueOf(pesoTotal);
    }

    public void setPesoTotal(String pesoTotal) {
        if(pesoTotal.equals("")){
            this.pesoTotal = 0;
        }else if(pesoTotal.equals(".")){
            this.pesoTotal = 0;
        }else {
            this.pesoTotal = Float.parseFloat(pesoTotal);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_carriedWeight);
    }

    public String getPesoMax() {
        return String.valueOf(pesoMax);
    }

    public void setPesoMax(String pesoMax) {
        if(pesoMax.equals("")){
            this.pesoMax = 0;
        }else if(pesoMax.equals(".")){
            this.pesoMax = 0;
        }else {
            this.pesoMax = Float.parseFloat(pesoMax);
        }
        notifyPropertyChanged(R.id.sheetEI_editText_maxWeight);
    }

    public String getDescricaoAparencia() {
        return descricaoAparencia;
    }

    public void setDescricaoAparencia(String descricaoAparencia) {
        this.descricaoAparencia = descricaoAparencia;
        notifyPropertyChanged(R.id.sheetAp_editText_appearance);
    }

    public String getTesteResistencia() {
        return testeResistencia;
    }

    public void setTesteResistencia(String testeResistencia) {
        this.testeResistencia = testeResistencia;
        notifyPropertyChanged(R.id.sheetMI_editText_testeDeResistenciaMagica);
    }

    public String getChanceFalha() {
        return chanceFalha;
    }

    public void setChanceFalha(String chanceFalha) {
        this.chanceFalha = chanceFalha;
        notifyPropertyChanged(R.id.sheetMI_editText_testeDeResistenciaMagica2);
    }

    public String getNumeroMagias() {
        return numeroMagias;
    }

    public void setNumeroMagias(String numeroMagias) {
        this.numeroMagias = numeroMagias;
        notifyPropertyChanged(R.id.sheetMI_editText_numeroMagiasPorDia);
    }

    public String getEscolhaEspecializada() {
        return escolhaEspecializada;
    }

    public void setEscolhaEspecializada(String escolhaEspecializada) {
        this.escolhaEspecializada = escolhaEspecializada;
        notifyPropertyChanged(R.id.sheetMI_editText_dominioEscola);
    }

    public String getQualiEspeciais() {
        return qualiEspeciais;
    }

    public void setQualiEspeciais(String qualiEspeciais) {

        this.qualiEspeciais = qualiEspeciais;
        notifyPropertyChanged(R.id.sheetSP_editText_qualidadesEspeciais);
    }

    public String getHabiEspeciais() {
        return habiEspeciais;
    }

    public void setHabiEspeciais(String habiEspeciais) {
        this.habiEspeciais = habiEspeciais;
        notifyPropertyChanged(R.id.sheetSP_editText_habilidadesEspeciais);
    }

    public ArrayList<FichaModel> getArrayListaFicha(int[] fichasID, SQLite sqLite){

        ArrayList<FichaModel> fichaModelArrayList = new ArrayList<>();

        for (int i = 0; i < fichasID.length; i++){
            if(fichasID[i] == 0){}
            else {
                FichaModel fichaModel = new FichaModel(sqLite.selecionarFicha(fichasID[i]));
                fichaModelArrayList.add(fichaModel);
            }
        }

        return fichaModelArrayList;
    }
}

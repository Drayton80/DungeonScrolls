package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.databinding.BaseObservable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import door.opposite.grupo2.dungeonscrolls.model.Ficha;

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
        this.forcaMod = ficha.getForcaMod();
        this.constituicaoMod = ficha.getConstituicaoMod();
        this.destrezaMod = ficha.getDestrezaMod();
        this.inteligenciaMod = ficha.getInteligenciaMod();
        this.sabedoriaMod = ficha.getSabedoriaMod();
        this.carismaMod = ficha.getCarismaMod();
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
        this.fortitude = ficha.getFortitude();
        this.fortitudeOutros = ficha.getFortitudeOutros();
        this.fortitudeBase = ficha.getFortitudeBase();
        this.reflexo = ficha.getReflexo();
        this.reflexoOutros = ficha.getReflexoOutros();
        this.reflexoBase = ficha.getReflexoBase();
        this.vontade = ficha.getVontade();
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
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getForcaMod() {
        return forcaMod;
    }

    public void setForcaMod(int forcaMod) {
        this.forcaMod = forcaMod;
    }

    public int getConstituicaoMod() {
        return constituicaoMod;
    }

    public void setConstituicaoMod(int constituicaoMod) {
        this.constituicaoMod = constituicaoMod;
    }

    public int getDestrezaMod() {
        return destrezaMod;
    }

    public void setDestrezaMod(int destrezaMod) {
        this.destrezaMod = destrezaMod;
    }

    public int getInteligenciaMod() {
        return inteligenciaMod;
    }

    public void setInteligenciaMod(int inteligenciaMod) {
        this.inteligenciaMod = inteligenciaMod;
    }

    public int getSabedoriaMod() {
        return sabedoriaMod;
    }

    public void setSabedoriaMod(int sabedoriaMod) {
        this.sabedoriaMod = sabedoriaMod;
    }

    public int getCarismaMod() {
        return carismaMod;
    }

    public void setCarismaMod(int carismaMod) {
        this.carismaMod = carismaMod;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getCaOutros() {
        return caOutros;
    }

    public void setCaOutros(int caOutros) {
        this.caOutros = caOutros;
    }

    public int getCaToque() {
        return caToque;
    }

    public void setCaToque(int caToque) {
        this.caToque = caToque;
    }

    public int getCaSurpresa() {
        return caSurpresa;
    }

    public void setCaSurpresa(int caSurpresa) {
        this.caSurpresa = caSurpresa;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getArmaduraNatural() {
        return armaduraNatural;
    }

    public void setArmaduraNatural(int armaduraNatural) {
        this.armaduraNatural = armaduraNatural;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getReducaoDeDano() {
        return reducaoDeDano;
    }

    public void setReducaoDeDano(int reducaoDeDano) {
        this.reducaoDeDano = reducaoDeDano;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getIniciativaOutros() {
        return iniciativaOutros;
    }

    public void setIniciativaOutros(int iniciativaOutros) {
        this.iniciativaOutros = iniciativaOutros;
    }

    public int getFortitude() {
        return fortitude;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public int getFortitudeOutros() {
        return fortitudeOutros;
    }

    public void setFortitudeOutros(int fortitudeOutros) {
        this.fortitudeOutros = fortitudeOutros;
    }

    public int getFortitudeBase() {
        return fortitudeBase;
    }

    public void setFortitudeBase(int fortitudeBase) {
        this.fortitudeBase = fortitudeBase;
    }

    public int getReflexo() {
        return reflexo;
    }

    public void setReflexo(int reflexo) {
        this.reflexo = reflexo;
    }

    public int getReflexoOutros() {
        return reflexoOutros;
    }

    public void setReflexoOutros(int reflexoOutros) {
        this.reflexoOutros = reflexoOutros;
    }

    public int getReflexoBase() {
        return reflexoBase;
    }

    public void setReflexoBase(int reflexoBase) {
        this.reflexoBase = reflexoBase;
    }

    public int getVontade() {
        return vontade;
    }

    public void setVontade(int vontade) {
        this.vontade = vontade;
    }

    public int getVontadeOutros() {
        return vontadeOutros;
    }

    public void setVontadeOutros(int vontadeOutros) {
        this.vontadeOutros = vontadeOutros;
    }

    public int getVontadeBase() {
        return vontadeBase;
    }

    public void setVontadeBase(int vontadeBase) {
        this.vontadeBase = vontadeBase;
    }

    public int getBba() {
        return bba;
    }

    public void setBba(int bba) {
        this.bba = bba;
    }

    public int getResMagica() {
        return resMagica;
    }

    public void setResMagica(int resMagica) {
        this.resMagica = resMagica;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getAgarrar() {
        return agarrar;
    }

    public void setAgarrar(int agarrar) {
        this.agarrar = agarrar;
    }

    public int getAgarrarOutros() {
        return agarrarOutros;
    }

    public void setAgarrarOutros(int agarrarOutros) {
        this.agarrarOutros = agarrarOutros;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

    public int getPl() {
        return pl;
    }

    public void setPl(int pl) {
        this.pl = pl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpNecessario() {
        return xpNecessario;
    }

    public void setXpNecessario(int xpNecessario) {
        this.xpNecessario = xpNecessario;
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
}

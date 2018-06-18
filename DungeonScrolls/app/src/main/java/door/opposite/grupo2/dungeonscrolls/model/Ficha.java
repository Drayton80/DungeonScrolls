package door.opposite.grupo2.dungeonscrolls.model;

import java.io.Serializable;

/**
 * Created by ci on 02/04/18.
 */

public class Ficha implements Serializable{


    private int id;
    private String nomePersonagem;
    private String nomeJogador;
    private String classeNivel;
    private String raca;
    private String tendencia;
    private String divindade;
    private String sexo;
    private String tamanho;
    private float altura;
    private float peso;
    private int idade;
    private int forca;
    private int constituicao;
    private int destreza;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    private int forcaMod;
    private int constituicaoMod;
    private int destrezaMod;
    private int inteligenciaMod;
    private int sabedoriaMod;
    private int carismaMod;
    private int ca;
    private int caOutros;
    private int caToque;
    private int caSurpresa;
    private int armadura;
    private int armaduraNatural;
    private int pv;
    private int reducaoDeDano;
    private int iniciativa;
    private int iniciativaOutros;
    private int fortitude;
    private int fortitudeOutros;
    private int fortitudeBase;
    private int reflexo;
    private int reflexoOutros;
    private int reflexoBase;
    private int vontade;
    private int vontadeOutros;
    private int vontadeBase;
    private int bba;
    private int resMagica;
    private int deslocamento;
    private int agarrar;
    private int agarrarOutros;
    private int pc;
    private int pp;
    private int po;
    private int pl;
    private int xp;
    private int xpNecessario; //Não está usado usado
    private String idiomas;
    private String inventario;
    private String ataques;
    private String armaEquip;
    private String armaduraEquip;
    private String outrosEquip;
    private String carctClasse;
    private String talentos;
    private String magias;
    private String imagem;
    private String pericias;
    private int pvAtual;
    private int resistenciaNatural;
    private float pesoTotal;
    private float pesoMax;
    private String descricaoAparencia;
    private String testeResistencia;
    private String chanceFalha;
    private String numeroMagias;
    private String escolhaEspecializada;
    private String qualiEspeciais;
    private String habiEspeciais;
    private String ambiente;
    private String organizacao;
    private String evolucao;
    private String tipo;
    private String subTipo;
    private String nivelAjuste;
    private String anotacoes; //Não está sendo usado
    private float nivelDesafio;
    private float espaco;
    private float alcance;

    public Ficha(){

    }



    public Ficha( String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }



    public Ficha(int id, String nomePersonagem, String nomeJogador,
                 String classeNivel, String raca, String tendencia, String sexo,
                 String tamanho, float altura, float peso, int idade, int forca,
                 int constituicao, int destreza, int inteligencia, int sabedoria,
                 int carisma, int caOutros, int armadura, int armaduraNatural,
                 int pv, int reducaoDeDano, int iniciativaOutros,
                 int fortitudeOutros, int fortitudeBase,
                 int reflexoOutros, int reflexoBase, int vontadeOutros, int vontadeBase,
                 int bba, int resMagica, int deslocamento, int agarrarOutros, int xp,
                 int xpNecessario, String idiomas, String ataques, String carctClasse, String talentos) {
        this.id = id;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.caOutros = caOutros;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrarOutros = agarrarOutros;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.ataques = ataques;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
    }

    public Ficha(int id, String nomePersonagem, String nomeJogador, String classeNivel,
                 String raca, String tendencia, String divindade, String sexo, String tamanho,
                 float altura, float peso, int idade, int forca, int constituicao, int destreza,
                 int inteligencia, int sabedoria, int carisma, int forcaMod, int constituicaoMod,
                 int destrezaMod, int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca,
                 int caOutros, int caToque, int caSurpresa, int armadura, int armaduraNatural,
                 int pv, int reducaoDeDano, int iniciativa, int iniciativaOutros, int fortitude,
                 int fortitudeOutros, int fortitudeBase, int reflexo, int reflexoOutros,
                 int reflexoBase, int vontade, int vontadeOutros, int vontadeBase, int bba,
                 int resMagica, int deslocamento, int agarrar, int agarrarOutros, int pc,
                 int pp, int po, int pl, int xp, int xpNecessario, String idiomas,
                 String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias) {
        this.id = id;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
    }

    public Ficha(int id, String nomePersonagem, String nomeJogador, String classeNivel, String raca,
                 String tendencia, String divindade, String sexo, String tamanho, float altura,
                 float peso, int idade, int forca, int constituicao, int destreza, int inteligencia,
                 int sabedoria, int carisma, int forcaMod, int constituicaoMod, int destrezaMod,
                 int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca, int caOutros,
                 int caToque, int caSurpresa, int armadura, int armaduraNatural, int pv, int reducaoDeDano,
                 int iniciativa, int iniciativaOutros, int fortitude, int fortitudeOutros,
                 int fortitudeBase, int reflexo, int reflexoOutros, int reflexoBase, int vontade,
                 int vontadeOutros, int vontadeBase, int bba, int resMagica, int deslocamento,
                 int agarrar, int agarrarOutros, int pc, int pp, int po, int pl, int xp, int xpNecessario,
                 String idiomas, String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias,
                 String pericias, int pvAtual, int resistenciaNatural, float pesoTotal, float pesoMax,
                 String descricaoAparencia, String testeResistencia, String chanceFalha, String numeroMagias,
                 String escolhaEspecializada, String qualiEspeciais, String habiEspeciais, String ambiente,
                 String organizacao, String evolucao, String tipo, String subTipo, String nivelAjuste,
                 String anotacoes, float nivelDesafio, float espaco, float alcance) {
        this.id = id;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
        this.pericias = pericias;
        this.pvAtual = pvAtual;
        this.resistenciaNatural = resistenciaNatural;
        this.pesoTotal = pesoTotal;
        this.pesoMax = pesoMax;
        this.descricaoAparencia = descricaoAparencia;
        this.testeResistencia = testeResistencia;
        this.chanceFalha = chanceFalha;
        this.numeroMagias = numeroMagias;
        this.escolhaEspecializada = escolhaEspecializada;
        this.qualiEspeciais = qualiEspeciais;
        this.habiEspeciais = habiEspeciais;
        this.ambiente = ambiente;
        this.organizacao = organizacao;
        this.evolucao = evolucao;
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.nivelAjuste = nivelAjuste;
        this.anotacoes = anotacoes;
        this.nivelDesafio = nivelDesafio;
        this.espaco = espaco;
        this.alcance = alcance;
    }
    public Ficha(String nomePersonagem, String nomeJogador, String classeNivel, String raca,
                 String tendencia, String divindade, String sexo, String tamanho, float altura,
                 float peso, int idade, int forca, int constituicao, int destreza, int inteligencia,
                 int sabedoria, int carisma, int forcaMod, int constituicaoMod, int destrezaMod,
                 int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca, int caOutros,
                 int caToque, int caSurpresa, int armadura, int armaduraNatural, int pv, int reducaoDeDano,
                 int iniciativa, int iniciativaOutros, int fortitude, int fortitudeOutros,
                 int fortitudeBase, int reflexo, int reflexoOutros, int reflexoBase, int vontade,
                 int vontadeOutros, int vontadeBase, int bba, int resMagica, int deslocamento,
                 int agarrar, int agarrarOutros, int pc, int pp, int po, int pl, int xp, int xpNecessario,
                 String idiomas, String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias,
                 String pericias, int pvAtual, int resistenciaNatural, float pesoTotal, float pesoMax,
                 String descricaoAparencia, String testeResistencia, String chanceFalha, String numeroMagias,
                 String escolhaEspecializada, String qualiEspeciais, String habiEspeciais, String ambiente,
                 String organizacao, String evolucao, String tipo, String subTipo, String nivelAjuste,
                 String anotacoes, float nivelDesafio, float espaco, float alcance) {
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
        this.pericias = pericias;
        this.pvAtual = pvAtual;
        this.resistenciaNatural = resistenciaNatural;
        this.pesoTotal = pesoTotal;
        this.pesoMax = pesoMax;
        this.descricaoAparencia = descricaoAparencia;
        this.testeResistencia = testeResistencia;
        this.chanceFalha = chanceFalha;
        this.numeroMagias = numeroMagias;
        this.escolhaEspecializada = escolhaEspecializada;
        this.qualiEspeciais = qualiEspeciais;
        this.habiEspeciais = habiEspeciais;
        this.ambiente = ambiente;
        this.organizacao = organizacao;
        this.evolucao = evolucao;
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.nivelAjuste = nivelAjuste;
        this.anotacoes = anotacoes;
        this.nivelDesafio = nivelDesafio;
        this.espaco = espaco;
        this.alcance = alcance;
    }

    public Ficha(String nomePersonagem, String nomeJogador, String classeNivel,
                 String raca, String tendencia, String divindade, String sexo, String tamanho,
                 float altura, float peso, int idade, int forca, int constituicao, int destreza,
                 int inteligencia, int sabedoria, int carisma, int forcaMod, int constituicaoMod,
                 int destrezaMod, int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca,
                 int caOutros, int caToque, int caSurpresa, int armadura, int armaduraNatural,
                 int pv, int reducaoDeDano, int iniciativa, int iniciativaOutros, int fortitude,
                 int fortitudeOutros, int fortitudeBase, int reflexo, int reflexoOutros,
                 int reflexoBase, int vontade, int vontadeOutros, int vontadeBase, int bba,
                 int resMagica, int deslocamento, int agarrar, int agarrarOutros, int pc,
                 int pp, int po, int pl, int xp, int xpNecessario, String idiomas,
                 String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias) {
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
    }

    public Ficha(int id) {
        this.id = id;
    }

    public Ficha(int id, String nomePersonagem, String nomeJogador, String classeNivel, String raca,
                 String tendencia, String divindade, String sexo, String tamanho, float altura,
                 float peso, int idade, int forca, int constituicao, int destreza, int inteligencia,
                 int sabedoria, int carisma, int forcaMod, int constituicaoMod, int destrezaMod,
                 int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca, int caOutros,
                 int caToque, int caSurpresa, int armadura, int armaduraNatural, int pv,
                 int reducaoDeDano, int iniciativa, int iniciativaOutros, int fortitude, int fortitudeOutros,
                 int fortitudeBase, int reflexo, int reflexoOutros, int reflexoBase, int vontade,
                 int vontadeOutros, int vontadeBase, int bba, int resMagica, int deslocamento,
                 int agarrar, int agarrarOutros, int pc, int pp, int po, int pl, int xp, int xpNecessario,
                 String idiomas, String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias, String pericias,
                 int pvAtual, int resistenciaNatural, float pesoTotal, float pesoMax,
                 String descricaoAparencia, String testeResistencia, String chanceFalha, String numeroMagias,
                 String escolhaEspecializada, String qualiEspeciais, String habiEspeciais) {
        this.id = id;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
        this.pericias = pericias;
        this.pvAtual = pvAtual;
        this.resistenciaNatural = resistenciaNatural;
        this.pesoTotal = pesoTotal;
        this.pesoMax = pesoMax;
        this.descricaoAparencia = descricaoAparencia;
        this.testeResistencia = testeResistencia;
        this.chanceFalha = chanceFalha;
        this.numeroMagias = numeroMagias;
        this.escolhaEspecializada = escolhaEspecializada;
        this.qualiEspeciais = qualiEspeciais;
        this.habiEspeciais = habiEspeciais;
    }



    public Ficha(String nomePersonagem, String nomeJogador, String classeNivel, String raca,
                 String tendencia, String divindade, String sexo, String tamanho, float altura,
                 float peso, int idade, int forca, int constituicao, int destreza, int inteligencia,
                 int sabedoria, int carisma, int forcaMod, int constituicaoMod, int destrezaMod,
                 int inteligenciaMod, int sabedoriaMod, int carismaMod, int ca, int caOutros,
                 int caToque, int caSurpresa, int armadura, int armaduraNatural, int pv,
                 int reducaoDeDano, int iniciativa, int iniciativaOutros, int fortitude, int fortitudeOutros,
                 int fortitudeBase, int reflexo, int reflexoOutros, int reflexoBase, int vontade,
                 int vontadeOutros, int vontadeBase, int bba, int resMagica, int deslocamento,
                 int agarrar, int agarrarOutros, int pc, int pp, int po, int pl, int xp, int xpNecessario,
                 String idiomas, String inventario, String ataques, String armaEquip, String armaduraEquip,
                 String outrosEquip, String carctClasse, String talentos, String magias, String pericias,
                 int pvAtual, int resistenciaNatural, float pesoTotal, float pesoMax,
                 String descricaoAparencia, String testeResistencia, String chanceFalha, String numeroMagias,
                 String escolhaEspecializada, String qualiEspeciais, String habiEspeciais) {
        this.id = id;
        this.nomePersonagem = nomePersonagem;
        this.nomeJogador = nomeJogador;
        this.classeNivel = classeNivel;
        this.raca = raca;
        this.tendencia = tendencia;
        this.divindade = divindade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.forcaMod = forcaMod;
        this.constituicaoMod = constituicaoMod;
        this.destrezaMod = destrezaMod;
        this.inteligenciaMod = inteligenciaMod;
        this.sabedoriaMod = sabedoriaMod;
        this.carismaMod = carismaMod;
        this.ca = ca;
        this.caOutros = caOutros;
        this.caToque = caToque;
        this.caSurpresa = caSurpresa;
        this.armadura = armadura;
        this.armaduraNatural = armaduraNatural;
        this.pv = pv;
        this.reducaoDeDano = reducaoDeDano;
        this.iniciativa = iniciativa;
        this.iniciativaOutros = iniciativaOutros;
        this.fortitude = fortitude;
        this.fortitudeOutros = fortitudeOutros;
        this.fortitudeBase = fortitudeBase;
        this.reflexo = reflexo;
        this.reflexoOutros = reflexoOutros;
        this.reflexoBase = reflexoBase;
        this.vontade = vontade;
        this.vontadeOutros = vontadeOutros;
        this.vontadeBase = vontadeBase;
        this.bba = bba;
        this.resMagica = resMagica;
        this.deslocamento = deslocamento;
        this.agarrar = agarrar;
        this.agarrarOutros = agarrarOutros;
        this.pc = pc;
        this.pp = pp;
        this.po = po;
        this.pl = pl;
        this.xp = xp;
        this.xpNecessario = xpNecessario;
        this.idiomas = idiomas;
        this.inventario = inventario;
        this.ataques = ataques;
        this.armaEquip = armaEquip;
        this.armaduraEquip = armaduraEquip;
        this.outrosEquip = outrosEquip;
        this.carctClasse = carctClasse;
        this.talentos = talentos;
        this.magias = magias;
        this.pericias = pericias;
        this.pvAtual = pvAtual;
        this.resistenciaNatural = resistenciaNatural;
        this.pesoTotal = pesoTotal;
        this.pesoMax = pesoMax;
        this.descricaoAparencia = descricaoAparencia;
        this.testeResistencia = testeResistencia;
        this.chanceFalha = chanceFalha;
        this.numeroMagias = numeroMagias;
        this.escolhaEspecializada = escolhaEspecializada;
        this.qualiEspeciais = qualiEspeciais;
        this.habiEspeciais = habiEspeciais;
    }


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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPericias() {
        return pericias;
    }

    public void setPericias(String pericias) {
        this.pericias = pericias;
    }

    public int getPvAtual() {
        return pvAtual;
    }

    public void setPvAtual(int pvAtual) {
        this.pvAtual = pvAtual;
    }

    public int getResistenciaNatural() {
        return resistenciaNatural;
    }

    public void setResistenciaNatural(int resistenciaNatural) {
        this.resistenciaNatural = resistenciaNatural;
    }

    public float getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public float getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }

    public String getDescricaoAparencia() {
        return descricaoAparencia;
    }

    public void setDescricaoAparencia(String descricaoAparencia) {
        this.descricaoAparencia = descricaoAparencia;
    }

    public String getTesteResistencia() {
        return testeResistencia;
    }

    public void setTesteResistencia(String testeResistencia) {
        this.testeResistencia = testeResistencia;
    }

    public String getChanceFalha() {
        return chanceFalha;
    }

    public void setChanceFalha(String chanceFalha) {
        this.chanceFalha = chanceFalha;
    }

    public String getNumeroMagias() {
        return numeroMagias;
    }

    public void setNumeroMagias(String numeroMagias) {
        this.numeroMagias = numeroMagias;
    }

    public String getEscolhaEspecializada() {
        return escolhaEspecializada;
    }

    public void setEscolhaEspecializada(String escolhaEspecializada) {
        this.escolhaEspecializada = escolhaEspecializada;
    }

    public String getQualiEspeciais() {
        return qualiEspeciais;
    }

    public void setQualiEspeciais(String qualiEspeciais) {
        this.qualiEspeciais = qualiEspeciais;
    }

    public String getHabiEspeciais() {
        return habiEspeciais;
    }

    public void setHabiEspeciais(String habiEspeciais) {
        this.habiEspeciais = habiEspeciais;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getNivelAjuste() {
        return nivelAjuste;
    }

    public void setNivelAjuste(String nivelAjuste) {
        this.nivelAjuste = nivelAjuste;
    }

    public float getNivelDesafio() {
        return nivelDesafio;
    }

    public void setNivelDesafio(float nivelDesafio) {
        this.nivelDesafio = nivelDesafio;
    }

    public float getEspaco() {
        return espaco;
    }

    public void setEspaco(float espaco) {
        this.espaco = espaco;
    }

    public float getAlcance() {
        return alcance;
    }

    public void setAlcance(float alcance) {
        this.alcance = alcance;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
}
